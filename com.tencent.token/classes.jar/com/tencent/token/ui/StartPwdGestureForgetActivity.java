package com.tencent.token.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.s;

public class StartPwdGestureForgetActivity
  extends BaseActivity
{
  public static final int K_FORGET2MODIFY_INTENT_REQUEST = 16;
  public static final int K_FORGET2MODIFY_INTENT_RESPONSE = 17;
  private long mAppid = 523005425L;
  private Button mButtonOK;
  private CompoundButton.OnCheckedChangeListener mCheckListener = new abf(this);
  private TextView mForget;
  private Handler mHandler = new abg(this);
  private TextView mPasswdDisText;
  private TextView mPasswdHideText;
  private TextView mQQMask;
  private EditText mQQPasswd;
  private QQUser mQQUser;
  private int mSourceActivityType;
  
  private void initUI()
  {
    if (this.mQQUser == null) {
      return;
    }
    this.mForget.setOnClickListener(new abj(this));
    this.mQQMask.setText(this.mQQUser.mNickName + "(" + this.mQQUser.mUinMask + ")");
    this.mButtonOK.setOnClickListener(new abk(this));
  }
  
  private void judgeNextStep()
  {
    dismissDialog();
    p.a().a(System.currentTimeMillis(), 25);
    ah.a().f();
    RqdApplication.f();
    s.a(FaceRecognitionCameraActivity.LANUCH_RETRY_COUNT, 0);
    ah.a();
    ah.a(0);
    setResult(257);
    if ((this.mSourceActivityType != 2) && (this.mSourceActivityType != 1) && (this.mSourceActivityType != 4))
    {
      if (this.mSourceActivityType != 5) {
        break label125;
      }
      localIntent = new Intent(this, FaceChangePwdIndexActivity.class);
      localIntent.putExtra("verify_psw", true);
      localIntent.setFlags(67108864);
      p.a().a(System.currentTimeMillis(), 95);
      startActivity(localIntent);
    }
    label125:
    while (ah.a().c())
    {
      Intent localIntent;
      finish();
      return;
    }
    showOldPwdDeletedAlert();
  }
  
  private void showNobindingAlert(Context paramContext, int paramInt1, int paramInt2)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
      showUserDialog(2131361808, getString(paramInt1), paramInt2, new abn(this, paramContext), new abo(this, paramContext));
    }
  }
  
  private void showOldPwdDeletedAlert()
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(2131361808, getString(2131362149), 2131362148, 2131361809, new abl(this), new abm(this));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    }
    do
    {
      return super.dispatchKeyEvent(paramKeyEvent);
    } while ((!b.d()) || (paramKeyEvent.getAction() != 0) || (this.mSourceActivityType != 3));
    exitToken();
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!ah.a().c())
    {
      showOldPwdDeletedAlert();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mQQUser = ((QQUser)paramBundle.getSerializableExtra("qquser"));
    this.mSourceActivityType = paramBundle.getIntExtra("startpwd_forget_source", 0);
    setNeverShowLockVerifyView();
    setContentView(2130903204);
    if ((this.mSourceActivityType == 4) || (this.mSourceActivityType == 5)) {
      setTitle(2131362628);
    }
    this.mButtonOK = ((Button)findViewById(2131297117));
    this.mQQMask = ((TextView)findViewById(2131297110));
    this.mQQPasswd = ((EditText)findViewById(2131297113));
    if (this.mQQPasswd != null) {
      this.mQQPasswd.clearFocus();
    }
    this.mForget = ((TextView)findViewById(2131297118));
    paramBundle = (SwitchButton)findViewById(2131297114);
    paramBundle.a(true, false);
    paramBundle.setOnCheckedChangeListener(this.mCheckListener);
    this.mPasswdHideText = ((TextView)findViewById(2131297116));
    this.mPasswdDisText = ((TextView)findViewById(2131297115));
    if (this.mQQUser == null)
    {
      af.a().b(this.mHandler);
      showProDialog(this, 2131362146, new abi(this));
    }
    e.c("mSourceActivityType=" + this.mSourceActivityType);
    if (this.mSourceActivityType == 3) {
      setBackArrowHide();
    }
    initUI();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureForgetActivity
 * JD-Core Version:    0.7.0.1
 */