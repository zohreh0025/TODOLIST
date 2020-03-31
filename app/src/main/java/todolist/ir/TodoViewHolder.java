package todolist.ir;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private TextView edit;
    private TodoOnClick onClickListener;
   // private Button btn;
    public TodoViewHolder(@NonNull View itemView, TodoOnClick onClickListener) {
        super(itemView);
        edit=itemView.findViewById(R.id.edit);
        this.onClickListener=onClickListener;
       // btn=itemView.findViewById(R.id.btn);
    }
    public void bind(final TodoData data){

        edit.setText(data.getEdittxt());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(data);
            }
        });



    }
}
