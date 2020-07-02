package todolist.ir;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class TodoListFragmant extends Fragment {

    private EditText searchedit;
    private EditText textedit;
    private ImageView action_add;
    private TextView toolbartitel;
    private String highlightString;
    private RecyclerView recyclerView;

    private NoteDao noteDao;

    private DatabaseThread databaseThread;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteDao = Room.databaseBuilder(requireContext(), NoteDatabase.class, "note_database")
            .build()
            .getNoteDao();
        databaseThread = new DatabaseThread();
    }

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState
    ) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragmant_todo_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbartitel = view.findViewById(R.id.toolbar_titel);
        searchedit = view.findViewById(R.id.searchEdit);
        action_add = view.findViewById(R.id.action_add);
        ImageView searchaction = view.findViewById(R.id.action_search);
        ImageView add_item = view.findViewById(R.id.action_add);

        recyclerView = view.findViewById(R.id.todorecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_Messag dialog_messag = new Dialog_Messag(getContext(), new NoteCallback() {
                    @Override
                    public void onNewNoteAdded() {
                        List<NoteTable> notes = noteDao.getNotes();
                        final List<TodoData> todoDataList = mapNoteTableToTodoData(notes);
                        requireActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateAdapter(todoDataList);
                            }
                        });
                    }
                });
                dialog_messag.show();
            }
        });

        searchaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbartitel.setVisibility(View.GONE);
                action_add.setVisibility(View.GONE);
                searchedit.setVisibility(View.VISIBLE);
            }
        });

        databaseThread.addRunnable(new Runnable() {
            @Override
            public void run() {
                List<NoteTable> notes = noteDao.getNotes();
                final List<TodoData> todoDataList = mapNoteTableToTodoData(notes);
                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateAdapter(todoDataList);
                    }
                });
            }
        });
    }

    private void updateAdapter(List<TodoData> todoDataList) {
        TodoAdaptor adaptor = new TodoAdaptor(todoDataList, new TodoOnClick() {
            @Override
            public void onClick(TodoData data) {
                getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmant_todo, new TodoDatilFragmant())
                    .commit();
            }

            @Override
            public void onDeleteClick(TodoData data) {
                ArrayList<TodoData> todoDataArrayList = new ArrayList<>();
                todoDataArrayList.add(data);
                final List<NoteTable> noteTables = mapTodoDataToNoteTable(todoDataArrayList);
                databaseThread.addRunnable(new Runnable() {
                    @Override
                    public void run() {
                        long result = noteDao.deleteNote(noteTables.get(0));
                        if (result >= 0) {
                            List<NoteTable> notes = noteDao.getNotes();
                            final List<TodoData> todoDataList = mapNoteTableToTodoData(notes);
                            requireActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    updateAdapter(todoDataList);
                                }
                            });
                        }
                    }
                });
            }
        });
        recyclerView.setAdapter(adaptor);
    }

    private List<TodoData> mapNoteTableToTodoData(List<NoteTable> noteTables) {
        ArrayList<TodoData> todoDataArrayList = new ArrayList<>();
        for (int i = 0; i < noteTables.size(); i++) {
            NoteTable noteTable = noteTables.get(i);
            TodoData todoData = new TodoData(noteTable.getNoteId(), noteTable.getNote());
            todoDataArrayList.add(todoData);
        }
        return todoDataArrayList;
    }

    private List<NoteTable> mapTodoDataToNoteTable(List<TodoData> noteTables) {
        ArrayList<NoteTable> todoDataArrayList = new ArrayList<>();
        for (int i = 0; i < noteTables.size(); i++) {
            TodoData noteTable = noteTables.get(i);
            NoteTable todoData = new NoteTable(noteTable.getNoteId(), noteTable.getEdittxt());
            todoDataArrayList.add(todoData);
        }
        return todoDataArrayList;
    }

    public boolean HandleBackPress() {
        boolean HandleBackPress = false;
        if (searchedit.getVisibility() == View.VISIBLE) {
            searchedit.setVisibility(View.GONE);
            toolbartitel.setVisibility(View.VISIBLE);
            HandleBackPress = true;
        }
        return HandleBackPress;
    }
}
