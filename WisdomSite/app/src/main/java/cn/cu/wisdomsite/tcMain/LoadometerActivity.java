package cn.cu.wisdomsite.tcMain;

import androidx.appcompat.app.AppCompatActivity;
import cn.cu.wisdomsite.R;
import cn.cu.wisdomsite.tcMain.widget.CuToolBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoadometerActivity extends AppCompatActivity {
    private CuToolBar load_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadometer);

        load_bar = (CuToolBar)findViewById(R.id.toolbar_load);

        load_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(LoadometerActivity.this,MainActivity.class);
                startActivity(intent_back);
            }
        });
    }
}
