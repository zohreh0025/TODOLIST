package todolist.ir;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private EditText edit;
    private View.OnClickListener onClickListener;
   // private Button btn;
    public TodoViewHolder(@NonNull View itemView, View.OnClickListener onClickListener) {
        super(itemView);
        edit=itemView.findViewById(R.id.edit);
        this.onClickListener=onClickListener;
       // btn=itemView.findViewById(R.id.btn);
    }
    public void bind(final TodoData data){

        edit.setText(data.getEdittxt());
        itemView.setOnClickListener(onClickListener);



    }
}
