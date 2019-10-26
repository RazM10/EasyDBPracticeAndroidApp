package org.richit.easydbpractice;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import p32929.androideasysql_library.Column;
import p32929.androideasysql_library.EasyDB;

public class MainActivity extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DummyDatabase.init(this);

        textView1 = findViewById(R.id.tv1);
    }

    int i = 0;

    public void addData(View view) {
        boolean abc = DummyDatabase.addData("Munir" + i++, "Jack" + i++, "" + i++);
        Toast.makeText(this, "Added: " + abc, Toast.LENGTH_SHORT).show();

        textView1.setText(DummyDatabase.getAllData());
    }
}
