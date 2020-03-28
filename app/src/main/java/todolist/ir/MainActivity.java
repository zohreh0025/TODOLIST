package todolist.ir;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TodoListFragmant todoListFragmant;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoListFragmant=new TodoListFragmant();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmant_todo,todoListFragmant )
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(!todoListFragmant.HandleBackPress())
        super.onBackPressed();

    }
}
