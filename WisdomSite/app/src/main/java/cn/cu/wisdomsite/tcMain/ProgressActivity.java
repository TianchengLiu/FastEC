package cn.cu.wisdomsite.tcMain;

import androidx.appcompat.app.AppCompatActivity;
import cn.cu.wisdomsite.R;
import cn.cu.wisdomsite.tcMain.widget.CuToolBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProgressActivity extends AppCompatActivity {
    private CuToolBar pro_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        pro_bar = (CuToolBar)findViewById(R.id.toolbar_pro);

        pro_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(ProgressActivity.this,MainActivity.class);
                startActivity(intent_back);
            }
        });
    }
}
