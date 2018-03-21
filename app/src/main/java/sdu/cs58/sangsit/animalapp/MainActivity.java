package sdu.cs58.sangsit.animalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // ประกาศตัวแปล
    EditText nameEditText;
    Button startButton;
    String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ผูกตัวแปล
        nameEditText = findViewById(R.id.edtName);
        startButton = findViewById(R.id.btnStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameString = nameEditText.getText().toString().trim();//เอาข้อความที่ USER พิมย์มาเก็บไว้ใน nameString
                // Check ค่าว่าง nameString
                if (nameString.length() == 0) {
                    Toast.makeText(getApplicationContext(),"กรุณาใส่ชื่อสิ",Toast.LENGTH_SHORT).show();
                }else {
                    //เปิดหน้าเกม
                    Intent startIntent = new Intent(MainActivity.this,GameActivity.class);
                    startIntent.putExtra("Name",nameString);
                    startActivity(startIntent);

                }//end else
            }// end on click
        });
    }//end onCreate Method

}//end Class
