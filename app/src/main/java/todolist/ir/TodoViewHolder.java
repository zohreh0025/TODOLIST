package todolist.ir;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    private TextView titel;
    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);
        titel=(TextView) itemView.findViewById(R.id.titel);
    }
    public void bind(String titeltxt){
        titel.setText(titeltxt);

    }
}
