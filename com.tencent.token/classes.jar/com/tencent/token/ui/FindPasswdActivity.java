package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.captchasdk.TCaptchaPopupActivity;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.cw;
import org.json.JSONObject;

public class FindPasswdActivity
  extends BaseActivity
{
  private static final int VERIFYREQESTCODE = 1001;
  private boolean canchange_uin;
  private Boolean isShowLockVerify;
  private String mCaptchaSig = "";
  private Handler mHandler = new jl(this);
  private long mRealUin;
  private QueryCaptchaResult mResult;
  private EditText mUinEditText;
  
  protected void gotoVerifyActivity(QueryCaptchaResult paramQueryCaptchaResult)
  {
    Intent localIntent = new Intent(this, TCaptchaPopupActivity.class);
    if (paramQueryCaptchaResult != null) {
      localIntent.putExtra("appid", paramQueryCaptchaResult.mAppid);
    }
    startActivityForResult(localIntent, 1001);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      if (paramInt1 == 1001)
      {
        if (paramInt2 != -1) {
          break label120;
        }
        try
        {
          paramIntent = new JSONObject(paramIntent.getStringExtra("retJson"));
          if (paramIntent.getInt("ret") == 0)
          {
            showProDialogWithoutShutDown(this, getString(2131231392));
            if (this.mResult == null) {
              continue;
            }
            cw.a().d(this.mResult.mRealUin, this.mResult.mSceneId, paramIntent.getString("ticket"), paramIntent.getString("randstr"), this.mHandler);
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
    }
    Toast.makeText(this, "未验证成功", 0).show();
    return;
    label120:
    Toast.makeText(this, "未验证成功", 0).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.isShowLockVerify = Boolean.valueOf(getIntent().getBooleanExtra("not_showLockVerify", false));
    if (this.isShowLockVerify.booleanValue()) {
      setNeverShowLockVerifyView();
    }
    setContentView(2130968662);
    findViewById(2131558915).setOnClickListener(new jo(this));
    this.mUinEditText = ((EditText)findViewById(2131558914));
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
      cw.a().d(this.mRealUin, 5, this.mHandler);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    abi.c();
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
      cw.a().d(this.mRealUin, 5, this.mHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FindPasswdActivity
 * JD-Core Version:    0.7.0.1
 */