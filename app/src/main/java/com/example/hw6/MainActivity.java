package com.example.hw6;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout background;
    TextView tball, tgym, tpark;
    ImageView pika;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = (LinearLayout) findViewById(R.id.background);
        tball = (TextView) findViewById(R.id.tball);
        tgym = (TextView) findViewById(R.id.tgym);
        tpark = (TextView) findViewById(R.id.tpark);
        pika = (ImageView) findViewById(R.id.pika);
        registerForContextMenu(pika);
        pika.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        toast= new Toast(MainActivity.this);
        background.setBackgroundColor(Color.rgb(110, 240, 255));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("피카츄에게 무엇을 할까?");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu2, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.feed:

                final String[] versionArray = new String[]{"라즈열매", "나나열매", "파인열매"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("어떤 열매를 먹일까?");
                dlg.setItems(versionArray,
                        new DialogInterface.OnClickListener() {
                            View toastView = getLayoutInflater().inflate(R.layout.toast,
                                    (ViewGroup) findViewById(R.id.toastLayout));

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                Toast toast = new Toast(MainActivity.this);

                                toast.setGravity(Gravity.CENTER, 0, -100);
                                toast.setView(toastView);
                                toast.show();
                            }
                        });
                dlg.setPositiveButton("취소", null);
                dlg.show();
                return true;
            case R.id.sleep:
                Toast tMsg = Toast.makeText(MainActivity.this, "잘잤다!",
                    Toast.LENGTH_SHORT);
                tMsg.show();
//                toast =Toast.makeText(MainActivity.this, "잘잤다!",Toast.LENGTH_SHORT);
//                toast.show();
                return true;
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ball:
                background.setBackgroundColor(Color.rgb(110, 240, 255));
                tball.setVisibility(View.VISIBLE);
                tgym.setVisibility(View.GONE);
                tpark.setVisibility(View.GONE);
                return true;
            case R.id.gym:
                background.setBackgroundColor(Color.rgb(155, 240, 72));
                tgym.setVisibility(View.VISIBLE);
                tball.setVisibility(View.GONE);
                tpark.setVisibility(View.GONE);
                return true;
            case R.id.park:
                background.setBackgroundColor(Color.rgb(255, 50, 50));
                tpark.setVisibility(View.VISIBLE);
                tgym.setVisibility(View.GONE);
                tball.setVisibility(View.GONE);
                return true;
        }
        return false;
    }
}