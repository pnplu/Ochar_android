package com.aigdy.contactmemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aigdy.contactmemory.Model.EntityModel;
import com.aigdy.contactmemory.Model.UserModel;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickRegister(View v) {
        Button regis = (Button)findViewById(R.id.reg);
        Intent dointent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(dointent);
        finish();
    }

    public void onClickSignIn(View v) {
        EditText username_edt = (EditText)findViewById(R.id.EdtUsername);
        EditText password_edt = (EditText)findViewById(R.id.EdtPassword);

        EntityModel entity = new EntityModel();

        //Assign Data to EntityModel object
        entity.getValues().put("login_username",username_edt.getText().toString());
        entity.getValues().put("login_password",password_edt.getText().toString());

        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresult = connector.connect("getusersignin.php",true,entity);
        //Toast.makeText(this, strresult, Toast.LENGTH_SHORT).show();

        //Get JSON to String
        //สร้างกระบวนการตรงนี้ไว้ใน UserModel ไว้หมดแล้ว
        /*
        try {
            JSONObject jdata = new JSONObject(strresult);
            Toast.makeText(this, jdata.get("user_id").toString(), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        UserModel user = new UserModel();
        user.setUserModel(strresult);

        //ถ้าทุกอย่างเรียบร้อยให้ไปหน้า mains
        if (user.getUser_id() != 0){
            Intent dointent = new Intent(this,AddfoodActivity.class);
            startActivity(dointent);
            finish();
        }else {
            Toast.makeText(this,"Username or Password is incorrect.",Toast.LENGTH_SHORT).show();
        }

    }

}
