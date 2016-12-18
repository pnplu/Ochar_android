package com.aigdy.contactmemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aigdy.contactmemory.Adapter.ContactAdapter;
import com.aigdy.contactmemory.Model.ContactModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1.Init Data List
    private ArrayList<ContactModel> dataset;

    //2.Init Adapter
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3.new Data List
        dataset = new ArrayList<ContactModel>();

        //4.new Adapter
        adapter = new ContactAdapter(dataset);

        //5.call RecyclerView
        RecyclerView rcy = (RecyclerView)findViewById(R.id.RCVData);

        //6.Set adapter of RecyclerView
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.setAdapter(adapter);

        ServerConnect connector = new ServerConnect();
        String result = connector.connect("index.php",true);

        Toast.makeText(this,result,Toast.LENGTH_LONG).show();
        TextView tv = (TextView)findViewById(R.id.TV01);
        tv.setText(result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //check ResultCode
        if (requestCode == 1){
            //check ResultCode
            if (resultCode == RESULT_OK){
                //1.Get data from intent object
                //String name = data.getStringExtra("NAME");
                //String tel = data.getStringExtra("TEL");

                //2.Reference to TextView
                //TextView tv = (TextView)findViewById(R.id.TV01);

                //3.Set text to TextView
                //tv.setText("Result " + name + " : " + tel);

                //2กับ3 ไม่เอาเพราะว่าข้อมูลจะใส่ใน list แทน


                //New
                //7.Get data from intent object
                String name = data.getStringExtra("NAME");
                String tel = data.getStringExtra("TEL");
                //8.Add to Data List
                dataset.add(new ContactModel(name,tel));

                //9.Update adapter
                adapter.notifyDataSetChanged();
            }
        }
    }


    public void onClickAddContact(View v){
        // Create Intent , Where to go Activity
        Intent dointent = new Intent(this, AddActivity.class);
        // this คือผู้ส่ง AddActivity.class คือผู้รับ

        // Start Activity
        startActivityForResult(dointent,1);
        //เลขอะไรก็ได้แต่ขอให้รู้ว่าไปหน้าไหน

    }
}
