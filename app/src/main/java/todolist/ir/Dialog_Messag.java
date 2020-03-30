package todolist.ir;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class Dialog_Messag extends Dialog {
    private Button btn_ok;
    private EditText add_list;

    public Dialog_Messag(@NonNull Context context) {
        super(context);
        setContentView(R.layout.messag_layout);
        btn_ok= findViewById(R.id.btn_ok);
        add_list= findViewById(R.id.add_list);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String list=add_list.getText().toString();
                if (list.isEmpty()){
                    add_list.setError("add list");
                }
            }
        });
    }
}
