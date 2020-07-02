package todolist.ir;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public class Dialog_Messag extends Dialog {
    private Button btn_ok;
    private EditText add_list;

    private NoteDao noteDao;

    private DatabaseThread databaseThread;

    public Dialog_Messag(@NonNull Context context, final NoteCallback noteCallback) {
        super(context);
        setContentView(R.layout.messag_layout);
        noteDao = Room.databaseBuilder(context, NoteDatabase.class, "note_database")
            .build()
            .getNoteDao();
        databaseThread = new DatabaseThread();
        btn_ok= findViewById(R.id.btn_ok);
        add_list= findViewById(R.id.add_list);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String note = add_list.getText().toString();
                if (!note.isEmpty()){
                    databaseThread.addRunnable(new Runnable() {
                        @Override
                        public void run() {
                            NoteTable noteTable = new NoteTable(null, note);
                            long noteId = noteDao.insertNote(noteTable);
                            if (noteId >= 0) {
                                noteCallback.onNewNoteAdded();
                                dismiss();
                            }
                        }
                    });
                }
            }
        });
    }
}
