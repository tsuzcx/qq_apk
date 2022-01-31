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
import com.tencent.token.cp;
import com.tencent.token.global.RqdApplication;

public class ScanLoginAccountListActivity
  extends BaseActivity
{
  private QQUser mActionUser;
  private yg mAdapter;
  public View.OnClickListener mDeleteListener = new yd(this);
  private Handler mHandler = new yb(this);
  private ListView mListView;
  public View.OnClickListener mLoginListener = new yc(this);
  private String mQQUin;
  private byte[] mScanCode;
  private cp mScanLoginManager;
  private Button mTitleButton;
  public View.OnClickListener mTitleButtonListener = new yf(this);
  
  private void gotoQuickLoginWb()
  {
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, this.mQQUin);
  }
  
  private void initUI()
  {
    this.mListView = ((ListView)findViewById(2131559206));
    this.mAdapter = new yg(this);
    this.mListView.setAdapter(this.mAdapter);
    this.mTitleButton = getRightTitleButton();
    refreshUI();
  }
  
  private void judgeNextStep() {}
  
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968746);
    this.mScanLoginManager = cp.a(RqdApplication.l());
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