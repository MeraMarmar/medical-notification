package com.example.mdecinenotofication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class notifccat extends AppCompatActivity {
   // ArrayList<String> items;
   ArrayList<listItem> items = new ArrayList<listItem>();
    ArrayAdapter<String> myadater;
    ListView ls;

    database db=new database(this);
Medecine medecine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifccat);
         Myadater myadater=new Myadater(items);
         ls = (ListView) findViewById(R.id.listview);
         show();

    }
        public void show(){
            ArrayList<Medecine>listData=db.getAllData();
            ArrayList<String> arrayList = new ArrayList<>();
            for(int i = 0 ;i < listData.size();i++){
              // String s = listData.get(i).getNameOfmedicine()+"        "+listData.get(i).date +"        "
                    //    +listData.get(i).hour +"         "+listData.get(i).minute +"        "+listData.get(i).second
                    //   +"        "+listData.get(i).numoftaken;
                items.add(new listItem(listData.get(i).getNameOfmedicine(),listData.get(i).hour));
            }
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.list_row,arrayList);
            ls.setAdapter(myadater);
        }



    public void addData(View view) {
        Intent i=new Intent(this,addData.class);
        startActivity(i);
    }

    public void update(View view) {

    }

    class Myadater extends BaseAdapter{
ArrayList<listItem>items=new ArrayList<listItem>();
Myadater(ArrayList<listItem>items){
    this.items=items;
}
       @Override
       public int getCount() {
           return items.size();
       }

       @Override
       public Object getItem(int position) {
           return items.get(position).Name;
       }

       @Override
       public long getItemId(int position) {
           return position;
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           LayoutInflater layoutInflater=getLayoutInflater();
           View view= layoutInflater.inflate(R.layout.list_row,null);
           TextView textshowname=view.findViewById(R.id.textshowname);
           TextView textshowtime=view.findViewById(R.id.textshowtime);
           textshowname.setText(items.get(position).Name);
           textshowtime.setText(items.get(position).Time);
           Button button_yes=view.findViewById(R.id.imageyes);
           Button button_no=view.findViewById(R.id.imageno);
           Button button_alrm=view.findViewById(R.id.imagealarm);
           button_yes.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
           return view;

       }
   }
}
