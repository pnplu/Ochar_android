package com.aigdy.contactmemory;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aigdy.contactmemory.Model.EntityModel;
import com.aigdy.contactmemory.Model.UserModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Man Tanawat on 12/15/2016.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       /* username = (EditText)findViewById(R.id.etUsername);
        password = (EditText)findViewById(R.id.etPassword);
        email = (EditText)findViewById(R.id.etEmail);
        name = (EditText)findViewById(R.id.etName);*/
    }
    public void onClickAddRegister(View v){
        /*String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String str_email = email.getText().toString();
        String str_name = name.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,str_username,str_password,str_email,str_name);*/
        EditText username_edt = (EditText)findViewById(R.id.EDTUsername_register);
        EditText email_edt = (EditText)findViewById(R.id.EDTemail_register);
        EditText password_edt = (EditText)findViewById(R.id.EDTPassword_register);

        EntityModel entity = new EntityModel();

        //Assign Data to EntityModel object
        entity.getValues().put("username",username_edt.getText().toString());
        entity.getValues().put("email",email_edt.getText().toString());
        entity.getValues().put("password",password_edt.getText().toString());

        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresult = connector.connect("getuserregister.php",true,entity);
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
            Intent dointent = new Intent(this,LoginActivity.class);
            startActivity(dointent);
            Toast.makeText(this,"Register Success",Toast.LENGTH_SHORT).show();
            finish();


    }
}