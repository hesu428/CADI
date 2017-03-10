package com.example.haams.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private Button btnEnroll;
    private EditText editName,editAge;
    private Intent sIntent;
    private static final int RequestCode = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gIntent = getIntent();
        data = gIntent.getIntExtra("main",-1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1001:
                if(resultCode==RESULT_OK){
                    Toast.makeText(MainActivity.this,data.getStringExtra("Send"),Toast.LENGTH_LONG.show());
                }
                break;
        }

    }

    private void initView() {
        /*
        아이디 찾아오기!!
         */
        btnEnroll = (Button) findViewById(R.id.btn_enroll);
        editName = (EditText) findViewById(R.id.editName);
        editAge = (EditText) findViewById(R.id.editAge);

        btnEnroll.setOnClickListener(new View.OnClickListener()){


        }

        intent = new Intent(MainActivity.this,SecondActivity.class);

        // 1번째방법 --> 익명클래스로 바로 구현해버리기
        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(intent);
                finish();
            }
        });


        // 2번째방법 --> View.OnClickListener를 구현하는 클래스를 만들어주기!
        btnIntro.setOnClickListener(btnClick);
        btnIntro2.setOnClickListener(btnClick);

        // 3번째방법 --> implements를 액티비티에서 바로 하기!!
        btnIntro.setOnClickListener(this);
        btnIntro2.setOnClickListener(MainActivity.this);


    }

    private View.OnClickListener btnClick = new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_intro:
                    Toast.makeText(MainActivity.this, name.getText().toString() + "/" + age.getText().toString() + "/" + school.getText().toString() + "/" + part.getText().toString(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_intro2:
                    //
                    break;


            }
        }
    };

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onStart() {
        Log.i("MainActivity","시작했습니다.");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("MainActivity","다시 시작했습니다.");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i("MainActivity","종료되었습니다.");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i("MainActivity","정지되었습니다.");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.i("MainActivity","일시정지되었습니다.");
        super.onPause();
    }
}


