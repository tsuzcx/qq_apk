package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.tencent.qbardemo.MainActivity;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.x;

public class ScanLoginAccountListActivity
  extends BaseActivity
{
  private QQUser mActionUser;
  private yq mAdapter;
  public View.OnClickListener mDeleteListener = new yn(this);
  private Handler mHandler = new yl(this);
  private ListView mListView;
  public View.OnClickListener mLoginListener = new ym(this);
  private String mQQUin;
  private byte[] mScanCode;
  private x mScanLoginManager;
  private Button mTitleButton;
  public View.OnClickListener mTitleButtonListener = new yp(this);
  
  private void initUI()
  {
    this.mListView = ((ListView)findViewById(2131297023));
    this.mAdapter = new yq(this);
    this.mListView.setAdapter(this.mAdapter);
    this.mTitleButton = getRightTitleButton();
    this.mTitleButton.setVisibility(4);
  }
  
  private void refreshUI()
  {
    this.mTitleButton.setVisibility(4);
  }
  
  public void addUser()
  {
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("scancode", this.mScanCode);
    localIntent.putExtra("wtlogin_appid", 523005419L);
    localIntent.putExtra("page_id", 5);
    startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903187);
    this.mScanLoginManager = x.a(RqdApplication.i());
    this.mScanCode = getIntent().getByteArrayExtra("scancode");
    initUI();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      startActivity(new Intent(this, MainActivity.class));
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    this.mAdapter.notifyDataSetChanged();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ScanLoginAccountListActivity
 * JD-Core Version:    0.7.0.1
 */