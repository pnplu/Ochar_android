package com.aigdy.contactmemory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aigdy.contactmemory.Model.EntityModel;
import com.aigdy.contactmemory.Model.UserModel;

/**
 * Created by KWAN on 18/12/2559.
 */
public class AddfoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfood);
    }

    public void AddFood(View v){
        EditText foodname_edt = (EditText)findViewById(R.id.EDTFood_name_addpage);
        EditText description_edt = (EditText)findViewById(R.id.EDTDescription_addpage);
        EditText material_edt = (EditText)findViewById(R.id.EDTname_material_addpage);
        EditText amount_material_addfood_edt = (EditText)findViewById(R.id.EDTamount_material_addpage);
        EditText unit_material_addfood_edt = (EditText)findViewById(R.id.EDTunit_material_addpage);
        EditText type_food_edt = (EditText)findViewById(R.id.EDTType_food);

        EntityModel entity = new EntityModel();

        //Assign Data to EntityModel object
        entity.getValues().put("foodname",foodname_edt.getText().toString());
        entity.getValues().put("description",description_edt.getText().toString());
        entity.getValues().put("material",material_edt.getText().toString());
        entity.getValues().put("amount_material",amount_material_addfood_edt.getText().toString());
        entity.getValues().put("unit_material",unit_material_addfood_edt.getText().toString());
        entity.getValues().put("type_food",type_food_edt.getText().toString());

        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresult = connector.connect("addfood.php",true,entity);
        //Toast.makeText(this, strresult, Toast.LENGTH_SHORT).show();


        UserModel user = new UserModel();
        user.setUserModel(strresult);

        Intent dointent4 = new Intent(this,ProfileActivity.class);
        startActivity(dointent4);
        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        finish();




    }






    public void logout(View view)
    {
        Button to_profile = (Button) findViewById(R.id.BTNLoguot);
        Intent intent3 = new Intent(AddfoodActivity.this, LoginActivity.class);
        startActivity(intent3);
    }
}
