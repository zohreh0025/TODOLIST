package todolist.ir;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private TextView titel;
    private EditText edit;
    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);
        edit=itemView.findViewById(R.id.edit);
        titel=itemView.findViewById(R.id.titel);
    }
    public void bind(TodoData data){
        titel.setText(data.getTitel());
        edit.setText(data.getEdittxt());


    }
}
