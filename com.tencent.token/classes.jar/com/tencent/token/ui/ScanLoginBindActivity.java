package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.dq;
import com.tencent.token.global.RqdApplication;

public class ScanLoginBindActivity
  extends BaseActivity
{
  private final long mAppid = 523005419L;
  private byte[] mAqSig;
  ImageView mBindIcon;
  TextView mBindInfo;
  Button mCompleteBtn;
  public Handler mHandler = new yk(this);
  String mQQUin;
  cp mScanLoginManager;
  private int mType = 1;
  Button mVerifyBtn;
  private View.OnClickListener mVerifyListener = new yi(this);
  
  private void goToWtLoginAccountInput()
  {
    if (do.a().e() == null) {
      return;
    }
    gotoQuickLoginWb();
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void initUI()
  {
    dq localdq = do.a().b(this.mQQUin);
    setContentView(2130968747);
    this.mBindInfo = ((TextView)findViewById(2131559208));
    this.mCompleteBtn = ((Button)findViewById(2131559211));
    this.mVerifyBtn = ((Button)findViewById(2131559210));
    this.mBindIcon = ((ImageView)findViewById(2131559207));
    if ((localdq != null) && (localdq.d))
    {
      this.mBindInfo.setText(2131231090);
      this.mBindIcon.setImageResource(2130837653);
    }
    for (;;)
    {
      this.mCompleteBtn.setOnClickListener(new yn(this));
      this.mVerifyBtn.setOnClickListener(this.mVerifyListener);
      return;
      if ((localdq != null) && (localdq.c))
      {
        this.mBindInfo.setText(2131231420);
        this.mBindIcon.setImageResource(2130837653);
      }
    }
  }
  
  private void judgeNextStep() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mScanLoginManager = cp.a(RqdApplication.l());
    this.mQQUin = getIntent().getStringExtra("qquin");
    initUI();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    abi.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ScanLoginBindActivity
 * JD-Core Version:    0.7.0.1
 */