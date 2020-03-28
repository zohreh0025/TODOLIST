package todolist.ir;

import android.os.Bundle;
import android.transition.Visibility;
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

public class TodoListFragmant extends Fragment {
    private EditText searchedit;
    private  TextView toolbartitel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragmant_todo_list,container,false);
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       toolbartitel =view.findViewById(R.id.toolbar_titel);
       searchedit= view.findViewById(R.id.searchEdit);
        ImageView searchaction=view.findViewById(R.id.action_search);
        searchaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbartitel.setVisibility(View.GONE);
                searchedit.setVisibility(View.VISIBLE);
            }
        });
        RecyclerView recyclerView=view.findViewById(R.id.todorecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TodoData[]todo=new TodoData[]{
                new TodoData("salaam"),
                new TodoData("hiii"),
                new TodoData("khoafz")
        };
        TodoAdaptor adaptor=new TodoAdaptor(todo, new TodoOnClick() {
            @Override
            public void onClick(TodoData data) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmant_todo,new TodoDatilFragmant())
                        .commit();
            }
        });
                recyclerView.setAdapter(adaptor);
    }
    public boolean HandleBackPress(){
        boolean HandleBackPress=false;
        if(searchedit.getVisibility()==View.VISIBLE){
            searchedit.setVisibility(View.GONE);
            toolbartitel.setVisibility(View.VISIBLE);
            HandleBackPress=true;
        }
        return HandleBackPress;
    }
}
