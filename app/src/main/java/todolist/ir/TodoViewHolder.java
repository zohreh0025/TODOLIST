package todolist.ir;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private EditText edit;
    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);
        edit=itemView.findViewById(R.id.edit);
    }
    public void bind(TodoData data){

        edit.setText(data.getEdittxt());


    }
}
