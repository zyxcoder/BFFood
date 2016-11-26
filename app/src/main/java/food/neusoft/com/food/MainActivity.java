package food.neusoft.com.food;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import food.neusoft.com.food.Fragment.main.AttachmentFragment;
import food.neusoft.com.food.Fragment.main.HomeFragment;
import food.neusoft.com.food.Fragment.main.MineFragment;
import food.neusoft.com.food.Fragment.main.OrderFragment;
import food.neusoft.com.food.Fragment.main.base.BaseFragment;
import food.neusoft.com.food.activity.BaseActivity;
import food.neusoft.com.food.adapter.MyFragmentAdapter;
import food.neusoft.com.food.thread.User;
import food.neusoft.com.food.utils.SystemStatusManager;

/**
 * Created by 张宇翔 on 2016/11/21 22:32.
 * Email：1124751755@qq.com
 * 功能：主页面
 */

public class MainActivity extends BaseActivity implements View.OnClickListener{


    @ViewInject(R.id.radioGroup)
    private RadioGroup radioGroup;
    @ViewInject(R.id.radio0)
    private RadioButton radio0;
    @ViewInject(R.id.radio1)
    private RadioButton radio1;
    @ViewInject(R.id.radio2)
    private RadioButton radio2;
    @ViewInject(R.id.radio3)
    private RadioButton radio3;
    @ViewInject(R.id.viewPager)
    private ViewPager viewPager;


    private boolean isExit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setTranslucentStatus();
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);

        radio0.setOnClickListener(this);
        radio1.setOnClickListener(this);
        radio2.setOnClickListener(this);
        radio3.setOnClickListener(this);

        ((NApplication) this.getApplication()).addActivity(this);

        setupFragment();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (NApplication.user_number == null) {
            User user = new User(this);
            NApplication.user_number = user.getUserNumber();
            NApplication.user_power = user.getUserPower();
        }
    }

    private void setTranslucentStatus(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        }
        SystemStatusManager tintManager = new SystemStatusManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(0);// 状态栏无背景
        tintManager.setStatusBarTintColor(0x5e000000);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio0:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.radio1:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.radio2:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.radio3:
                viewPager.setCurrentItem(3,false);
                break;
            default:
                break;
        }
    }


    private void setupFragment(){
        FragmentManager fm=getSupportFragmentManager();
        List<BaseFragment> fs=new ArrayList<>();
        fs.add(new HomeFragment());
        fs.add(new AttachmentFragment());
        fs.add(new OrderFragment());
        fs.add(new MineFragment());

        MyFragmentAdapter adapter=new MyFragmentAdapter(fm,fs);
        viewPager.setAdapter(adapter);


        //初始选中第1页--->首页
        viewPager.setCurrentItem(0,false);
        radio0.setChecked(true);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radio0.setChecked(true);
                        break;
                    case 1:
                        radio1.setChecked(true);
                        break;
                    case 2:
                        radio2.setChecked(true);
                        break;
                    case 3:
                        radio3.setChecked(true);
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    //设置再那一次退出程序方法
    @Override
    public void onBackPressed() {
        if (isExit) {
            super.onBackPressed();
            ((NApplication) this.getApplication()).destoryAllActivity();
            finish();

            // System.exit(0);
        } else {
            isExit = true;
            new Timer().schedule(new TimerTask() {

                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
            Toast.makeText(getApplicationContext(), "再点击一次退出程序", Toast.LENGTH_SHORT).show();
        }

    }


}
