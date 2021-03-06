package todolist.ir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdaptor extends RecyclerView.Adapter<TodoViewHolder> {
    private List<TodoData> todo;
    private TodoOnClick onClickListener;

    public TodoAdaptor(List<TodoData> todo,TodoOnClick onClickListener)
    {
        this.todo = todo;
        this.onClickListener=onClickListener;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo,parent,false);
        TodoViewHolder todoViewHolder=new TodoViewHolder(itemview,onClickListener);
        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        TodoData notes= todo.get(position);
         holder.bind(notes);
    }


    @Override
    public int getItemCount() {
        return todo.size();
    }
}
