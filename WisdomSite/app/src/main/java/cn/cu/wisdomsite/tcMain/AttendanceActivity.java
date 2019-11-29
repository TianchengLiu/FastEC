package cn.cu.wisdomsite.tcMain;

import androidx.appcompat.app.AppCompatActivity;
import cn.cu.wisdomsite.R;
import cn.cu.wisdomsite.tcMain.widget.CuToolBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AttendanceActivity extends AppCompatActivity {
    private CuToolBar att_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        att_bar = (CuToolBar)findViewById(R.id.toolbar_att);

        att_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(AttendanceActivity.this,MainActivity.class);
                startActivity(intent_back);
            }
        });
    }
}
