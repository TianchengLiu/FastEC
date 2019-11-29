package cn.cu.wisdomsite.tcMain;

import androidx.appcompat.app.AppCompatActivity;
import cn.cu.wisdomsite.R;
import cn.cu.wisdomsite.tcMain.bean.Tab;
import cn.cu.wisdomsite.tcMain.fragment.HomeFragment;
import cn.cu.wisdomsite.tcMain.fragment.MineFragment;
import cn.cu.wisdomsite.tcMain.fragment.AddressListFragment;
import cn.cu.wisdomsite.tcMain.widget.CuToolBar;
import cn.cu.wisdomsite.tcMain.widget.FragmentTabHost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 主活动
 *
 *  initTab(); 调用底部菜单栏
 *
 *  initToolBar(); 调用顶部ToolBar
 */
public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;

    private List<Tab> mTabs = new ArrayList<>();

    private CuToolBar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();

        initToolBar();
    }

    /**
     * 调用ToolBar顶部菜单方法
     *
     * setNavigationOnClickListener 左边返回按钮逻辑实现方法
     *
     * setRightButtonOnClickListener 右边菜单按钮逻辑实现方法
     *
     * setOnTabChangedListener:
     */
    private void initToolBar() {

        mToolBar = (CuToolBar) findViewById(R.id.toolBar);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTabHost.setCurrentTab(0);
            }
        });

        mToolBar.setRightButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You click RightIcon", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //向FragmentTabHost添加TabSpace
    private void initTab() {

        Tab tab_home = new Tab(R.string.home,R.drawable.selector_icon_home, HomeFragment.class);
        Tab tab_video = new Tab(R.string.addlist,R.drawable.selector_icon_addresslist, AddressListFragment.class);
        Tab tab_mine = new Tab(R.string.mine,R.drawable.selector_icon_mine, MineFragment.class);

        mTabs.add(tab_home);
        mTabs.add(tab_video);
        mTabs.add(tab_mine);

        mTabHost = (FragmentTabHost)findViewById(R.id.tabHost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);


        //循环向TabSpace添加Tab标签
        for (Tab b : mTabs){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(b.getTitle()));
            tabSpec.setIndicator(buildIndicator(b));
            mTabHost.addTab(tabSpec,b.getFragment(),null);
        }

        //设置Tab变化监听事件，当Tab变化时，ToolBar标题相应的改变
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (mTabHost.getCurrentTab() == 0){
                    mToolBar.setTitle(R.string.home);
                }
                if (mTabHost.getCurrentTab() == 1){
                    mToolBar.setTitle(R.string.addlist);
                }
                if (mTabHost.getCurrentTab() == 2){
                    mToolBar.setTitle(R.string.mine);
                }
            }
        });
    }

    //创建Indicator
    private View buildIndicator(Tab tab){
        View view = LayoutInflater.from(this).inflate(R.layout.tab_indicater,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_tab);
        TextView textView = (TextView)view.findViewById(R.id.text_indicator);

        imageView.setBackgroundResource(tab.getIcon());
        textView.setText(tab.getTitle());

        return view;
    }

    //设置当前Tab方法
    public void setTab(int tab){
        mTabHost.setCurrentTab(tab);
    }

}
