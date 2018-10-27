package com.gdm.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private TextView tv;
   private EditText e1,e2;
   private Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv=(TextView) findViewById(R.id.tv);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b1)
        {
//            Toast.makeText(this, "YES", Toast.LENGTH_LONG).show();
            String un=e1.getText().toString();
            String pass=e2.getText().toString();

            if(!un.equals("") && !pass.equals("") ) {

                //Writting data


                SharedPreferences sp = getSharedPreferences("User Details", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("un", un);
                editor.putString("pass", pass);
                editor.commit();
                e1.setText("");
                e2.setText("");
                Toast.makeText(this,"Data Store Successfully",Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Username or Password is empty...", Toast.LENGTH_SHORT).show();
//                Log.e("Empty Field",un+pass);



        }
        else if(view.getId()==R.id.b2)
        {
//            Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();


            //reding the data from user

            SharedPreferences sp = getSharedPreferences("User Details", Context.MODE_PRIVATE);
            if(sp.contains("un")&&sp.contains("pass"))
            {
                String un=sp.getString("un","Data not found");
                String pass=sp.getString("pass","Data not found");
                tv.setText(un+"\n "+ pass);



            }




        }

    }
}
