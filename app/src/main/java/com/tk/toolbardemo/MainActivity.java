package com.tk.toolbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.tk.toolbardemo.R.id.toolbar;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBar();
    }

    private void initBar() {
        mToolbar = (Toolbar) findViewById(toolbar);
        //设置当前的ActionBar
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        mToolbar.setTitle("标题");
        mToolbar.setSubtitle("副标题");
        mToolbar.setLogo(R.mipmap.ic_launcher);
        //设置Toobar的home键的（返回按钮）
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setOnMenuItemClickListener(this);
    }

    /**
     * 自己写的menu文件的按钮的监听
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "第一个图标", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "第二个图标", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //通过menu文件来把加载进去
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 系统按钮的监听
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Toast.makeText(this, "home键", Toast.LENGTH_SHORT).show();
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "设置按钮", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
