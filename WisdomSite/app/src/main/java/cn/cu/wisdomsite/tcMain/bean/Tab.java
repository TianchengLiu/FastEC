package cn.cu.wisdomsite.tcMain.bean;

/**
 * Tab 实体类
 * title：名字，定义在strings文件里面
 * icon：selector选择器icon
 * fragment：对应的fragment
 */
public class Tab {
    private int title;
    private int icon;
    private Class fragment;
    public Tab(int title, int icon, Class fragment) {
        this.title = title;
        this.icon = icon;
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
