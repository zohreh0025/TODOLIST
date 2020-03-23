package todolist.ir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TodoListFragmant extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragmant_todo_list,container,false);
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView=view.findViewById(R.id.todorecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TodoData[]todo=new TodoData[]{
                new TodoData("salaaaaaaam","mn zohreh hastam"),
                new TodoData("hiii","mn zahra hastam")
        };
        TodoAdaptor adaptor=new TodoAdaptor(todo);
        recyclerView.setAdapter(adaptor);
    }
}
