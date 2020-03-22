package todolist.ir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoAdaptor extends RecyclerView.Adapter<TodoViewHolder> {
    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo,parent,false);
        TodoViewHolder todoViewHolder=new TodoViewHolder(itemview);
        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
holder.bind("salam mn zohreh hastam");
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
