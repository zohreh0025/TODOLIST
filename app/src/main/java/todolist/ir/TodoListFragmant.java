package todolist.ir;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.transition.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLOutput;

public class TodoListFragmant extends Fragment {
    private EditText searchedit;
    private EditText textedit;
    private ImageView action_add;
    private  TextView toolbartitel;
    private String highlightString;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragmant_todo_list,container,false);
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       toolbartitel =view.findViewById(R.id.toolbar_titel);
       searchedit= view.findViewById(R.id.searchEdit);
       action_add=view.findViewById(R.id.action_add);
        ImageView searchaction=view.findViewById(R.id.action_search);
        ImageView add_item=view.findViewById(R.id.action_add);
        add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_Messag dialog_messag=new Dialog_Messag(getContext());
                dialog_messag.show();
            }
        });

        searchaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbartitel.setVisibility(View.GONE);
                action_add.setVisibility(View.GONE);
                searchedit.setVisibility(View.VISIBLE);
            }
        });

        RecyclerView recyclerView=view.findViewById(R.id.todorecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final TodoData[]todo=new TodoData[]{
                new TodoData("salaam"),
                new TodoData("hiii"),
                new TodoData("khoafz")
        };
        TodoAdaptor adaptor=new TodoAdaptor(todo, new TodoOnClick() {
            @Override
            public void onClick(TodoData data) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragmant_todo,new TodoDatilFragmant())
                        .commit();
            }
        });
                recyclerView.setAdapter(adaptor);




    }
    public boolean HandleBackPress(){
        boolean HandleBackPress=false;
        if(searchedit.getVisibility()==View.VISIBLE){
            searchedit.setVisibility(View.GONE);
            toolbartitel.setVisibility(View.VISIBLE);
            HandleBackPress=true;
        }
        return HandleBackPress;
    }

}
