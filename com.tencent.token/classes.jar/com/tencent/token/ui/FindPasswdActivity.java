package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.core.bean.QueryCaptchaResult;

public class FindPasswdActivity
  extends BaseActivity
{
  private boolean canchange_uin;
  private Boolean isShowLockVerify;
  private String mCaptchaSig = "";
  private Handler mHandler = new ks(this);
  private long mRealUin;
  private QueryCaptchaResult mResult;
  private EditText mUinEditText;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.isShowLockVerify = Boolean.valueOf(getIntent().getBooleanExtra("not_showLockVerify", false));
    if (this.isShowLockVerify.booleanValue()) {
      setNeverShowLockVerifyView();
    }
    setContentView(2130903100);
    findViewById(2131296628).setOnClickListener(new kt(this));
    this.mUinEditText = ((EditText)findViewById(2131296627));
    if (this.mUinEditText != null) {
      this.mUinEditText.clearFocus();
    }
    if ((getIntent() != null) && (getIntent().getLongExtra("real_uin", 0L) != 0L))
    {
      this.mUinEditText.setText(getIntent().getLongExtra("real_uin", 0L) + "");
      this.canchange_uin = getIntent().getBooleanExtra("canchange_uin", false);
      if (!this.canchange_uin) {
        this.mUinEditText.setEnabled(false);
      }
      this.mRealUin = getIntent().getLongExtra("real_uin", 0L);
      af.a().f(this.mRealUin, 5, this.mHandler);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getLongExtra("real_uin", 0L) != 0L))
    {
      this.mUinEditText.setText(paramIntent.getLongExtra("real_uin", 0L) + "");
      this.canchange_uin = paramIntent.getBooleanExtra("canchange_uin", false);
      if (!this.canchange_uin) {
        this.mUinEditText.setEnabled(false);
      }
      this.mRealUin = getIntent().getLongExtra("real_uin", 0L);
      af.a().f(this.mRealUin, 5, this.mHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FindPasswdActivity
 * JD-Core Version:    0.7.0.1
 */