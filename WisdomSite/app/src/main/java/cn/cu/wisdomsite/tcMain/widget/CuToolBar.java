package cn.cu.wisdomsite.tcMain.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import cn.cu.wisdomsite.R;

/**
 * 自定义ToolBar，重写setTitle方法
 *
 * 第一个构造方法调用第二个构造方法，第二个构造方法调用第三个构造方法，逻辑都在第三个构造方法中实现
 *
 * 第三个构造方法中添加两个属性：rightButtonIcon（右上角按钮），isShowSearchView（是否显示搜索框）
 */
public class CuToolBar extends Toolbar {
    
    private View mview;
    private EditText editText;
    private ImageButton imageButton;
    private TextView textView;
    
    public CuToolBar(Context context) {
        this(context,null);
    }

    public CuToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CuToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        setContentInsetsRelative(10,10);
        if (attrs != null){
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.CuToolBar, defStyleAttr, 0);

            final Drawable rightIcon = a.getDrawable(R.styleable.CuToolBar_rightButtonIcon);
            if (rightIcon != null) {
                setRightButtonIcon(rightIcon);
            }

            boolean isShowSearchView = a.getBoolean(R.styleable.CuToolBar_isShowSearchView,false);
            if (isShowSearchView){
                showSearchView();
                hideTitleView();
            }
            a.recycle();
        }

    }

    /**
     * 绑定自定义控件toolbar.xml，其中包含搜索框，当前界面的文字描述，以及右上角按钮
     */
    private void initView() {

        if (mview == null){
            mview = LayoutInflater.from(getContext()).inflate(R.layout.toolbar,null);
            editText = (EditText)mview.findViewById(R.id.toolbar_searchview);
            textView = (TextView)mview.findViewById(R.id.toolbar_title);
            imageButton = (ImageButton)mview.findViewById(R.id.toolbar_rightButton);
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mview,layoutParams);
        }

    }

    //右上角菜单设置
    public void setRightButtonIcon(Drawable icon){
        if (imageButton != null){
            imageButton.setImageDrawable(icon);
            imageButton.setVisibility(VISIBLE);
        }
    }

    //右上角按钮点击事件
    public void setRightButtonOnClickListener(OnClickListener listener){
        imageButton.setOnClickListener(listener);
    }

    //重写setTitle方法，第一个setTitle调用下面的setTitle方法
    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (textView != null){
            textView.setText(title);
            showTitleView();
        }
    }
    //搜索框显示
    public void showSearchView(){
        if (editText != null){
            editText.setVisibility(VISIBLE);
        }
    }

    //搜索框隐藏
    public void hideSearchView(){
        if (editText != null){
            editText.setVisibility(GONE);
        }
    }

    //显示标题
    public void showTitleView(){
        if (textView != null){
            textView.setVisibility(VISIBLE);
        }
    }

    //隐藏标题
    public void hideTitleView(){
        if (textView != null){
            textView.setVisibility(GONE);
        }
    }
}
