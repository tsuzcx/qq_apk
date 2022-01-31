package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qbardemo.MainActivity;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.x;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class ScanLoginConfirmLoginActivity
  extends BaseActivity
{
  private Button mCancelButton;
  private TextView mConfirmBusiness;
  private Button mConfirmButton;
  private TextView mConfirmTime;
  private Handler mHandler = new yz(this);
  private ImageView mQQIcon;
  private String mQQNick;
  private TextView mQQNickText;
  private String mQQUin;
  private byte[] mScanCode;
  private x mScanLoginManager;
  
  private void initUI()
  {
    this.mConfirmTime = ((TextView)findViewById(2131297031));
    this.mConfirmBusiness = ((TextView)findViewById(2131297033));
    this.mQQNickText = ((TextView)findViewById(2131297019));
    this.mConfirmButton = ((Button)findViewById(2131297035));
    this.mCancelButton = ((Button)findViewById(2131297036));
    this.mQQIcon = ((ImageView)findViewById(2131297018));
    WloginSimpleInfo localWloginSimpleInfo = this.mScanLoginManager.c(this.mQQUin);
    if (localWloginSimpleInfo != null) {}
    for (this.mQQNick = new String(localWloginSimpleInfo._nick);; this.mQQNick = null)
    {
      this.mQQNickText.setText(this.mQQNick);
      this.mConfirmButton.setOnClickListener(new za(this));
      this.mCancelButton.setOnClickListener(new zc(this));
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903189);
    this.mScanLoginManager = x.a(RqdApplication.i());
    paramBundle = getIntent();
    this.mQQUin = paramBundle.getStringExtra("qquin");
    this.mScanCode = paramBundle.getByteArrayExtra("scancode");
    paramBundle = paramBundle.getExtras();
    initUI();
    this.mConfirmTime.setText(s.a(1000L * paramBundle.getLong("scantime")));
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