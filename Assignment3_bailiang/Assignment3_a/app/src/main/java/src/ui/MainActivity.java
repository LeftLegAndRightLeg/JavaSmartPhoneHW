package src.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * 项目的主Activity，所有的Fragment都嵌入在这里。
 *
 * @author guolin
 */
public class MainActivity extends Activity implements OnClickListener {

    private NewStudent NewStudent;
    private StudentList StudentList;
    private Statistics Statistics;
    private View newStudentLayout;
    private View studentListLayout;
    private View statisticsLayout;

    private FragmentManager fragmentManager;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);

    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    private void initViews() {
        newStudentLayout = findViewById(R.id.newStudentLayout);
        studentListLayout = findViewById(R.id.studentListLayout);
        statisticsLayout = findViewById(R.id.statisticsLayout);
        newStudentLayout.setOnClickListener(this);
        studentListLayout.setOnClickListener(this);
        statisticsLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newStudentLayout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.studentListLayout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.statisticsLayout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setTabSelection(int index) {
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (NewStudent == null) {
                    // 如果NewStudent为空，则创建一个并添加到界面上
                    NewStudent = new NewStudent();
                    transaction.add(R.id.content, NewStudent);
                } else {
                    // 如果NewStudent不为空，则直接将它显示出来
                    transaction.show(NewStudent);
                }
                break;
            case 1:
                if (StudentList == null) {
                    // 如果StudentList为空，则创建一个并添加到界面上
                    StudentList = new StudentList();
                    transaction.add(R.id.content, StudentList);
                } else {
                    // 如果StudentList不为空，则直接将它显示出来
                    transaction.show(StudentList);
                }
                break;
            case 2:
                if (Statistics == null) {
                    // 如果Statistics为空，则创建一个并添加到界面上
                    Statistics = new Statistics();
                    transaction.add(R.id.content, Statistics);
                } else {
                    // 如果Statistics不为空，则直接将它显示出来
                    transaction.show(Statistics);
                }
                break;

        }
        transaction.commit();
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void hideFragments(FragmentTransaction transaction) {
        if (NewStudent != null) {
            transaction.hide(NewStudent);
        }
        if (StudentList != null) {
            transaction.hide(StudentList);
        }
        if (Statistics != null) {
            transaction.hide(Statistics);
        }
    }
}
