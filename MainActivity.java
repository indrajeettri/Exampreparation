package com.example.hp.costometost;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alert;
    Button alertbutton;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listviwe1);
        final ArrayList arrayList=new ArrayList();
        arrayList.add("indra");
        arrayList.add("indra1");
        arrayList.add("indra2");
        arrayList.add("indra3");
        arrayList.add("indra4");
        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"you clicked"+arrayList.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        alertbutton=findViewById(R.id.btn3);
        alert=new AlertDialog.Builder(this);
        alertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.setMessage("this is aleart box")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(getApplicationContext(),"you are choos" +
                                "en yes",Toast.LENGTH_SHORT).show();
                    }
                })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getApplicationContext(),"you are choosen no",Toast.LENGTH_SHORT).show();
                            }
                        }).setTitle("welcome to allert");
                AlertDialog alertDialog=alert.create();
                alertDialog.show();
            }
        });

        TextView textView=findViewById(R.id.text1);
        registerForContextMenu(textView);
        Button button=findViewById(R.id.btn1);
        final Button button1=findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,button1);
                popupMenu.getMenuInflater().inflate(R.menu.menu1,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(),"you clicked"+menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View view1=inflater.inflate(R.layout.custom,(ViewGroup)findViewById(R.id.custom));
                Toast toast=new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view1);
                toast.show();
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.item1){
            Toast.makeText(getApplicationContext(),"you selected"+item.getTitle(),Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.item2){
            Toast.makeText(getApplicationContext(),"you selected"+item.getTitle(),Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.item3){
            Toast.makeText(getApplicationContext(),"you selected"+item.getTitle(),Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}