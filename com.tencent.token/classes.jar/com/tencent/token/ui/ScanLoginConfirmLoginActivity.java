package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qbardemo.MainActivity;
import com.tencent.token.cp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.k;
import com.tencent.token.utils.w;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class ScanLoginConfirmLoginActivity
  extends BaseActivity
{
  private Button mCancelButton;
  private TextView mConfirmBusiness;
  private Button mConfirmButton;
  private TextView mConfirmTime;
  private Handler mHandler = new yo(this);
  private ImageView mQQIcon;
  private String mQQNick;
  private TextView mQQNickText;
  private String mQQUin;
  private byte[] mScanCode;
  private cp mScanLoginManager;
  
  private void initUI()
  {
    this.mConfirmTime = ((TextView)findViewById(2131559214));
    this.mConfirmBusiness = ((TextView)findViewById(2131559216));
    this.mQQNickText = ((TextView)findViewById(2131559202));
    this.mConfirmButton = ((Button)findViewById(2131559218));
    this.mCancelButton = ((Button)findViewById(2131559219));
    this.mQQIcon = ((ImageView)findViewById(2131559201));
    WloginSimpleInfo localWloginSimpleInfo = this.mScanLoginManager.c(this.mQQUin);
    if (localWloginSimpleInfo != null) {}
    for (this.mQQNick = new String(localWloginSimpleInfo._nick);; this.mQQNick = null)
    {
      this.mQQNickText.setText(this.mQQNick);
      this.mConfirmButton.setOnClickListener(new yp(this));
      this.mCancelButton.setOnClickListener(new yr(this));
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968748);
    this.mScanLoginManager = cp.a(RqdApplication.l());
    paramBundle = getIntent();
    this.mQQUin = paramBundle.getStringExtra("qquin");
    this.mScanCode = paramBundle.getByteArrayExtra("scancode");
    paramBundle = paramBundle.getExtras();
    initUI();
    this.mConfirmTime.setText(w.a(1000L * paramBundle.getLong("scantime"), '-'));
    this.mConfirmBusiness.setText(new String(paramBundle.getByteArray("appname")));
    this.mQQIcon.setImageDrawable(k.a(this.mQQUin, null));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ScanLoginConfirmLoginActivity
 * JD-Core Version:    0.7.0.1
 */