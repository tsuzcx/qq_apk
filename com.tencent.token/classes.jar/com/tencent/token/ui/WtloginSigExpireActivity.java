package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.p;
import com.tencent.token.ui.base.SwitchButton;

public class WtloginSigExpireActivity
  extends BaseActivity
{
  private long mAppid = 523005419L;
  private boolean mAppid1SigOk = false;
  private CompoundButton.OnCheckedChangeListener mCheckListener = new ahq(this);
  private View.OnClickListener mFindPwdListener = new ahp(this);
  private Handler mHandler = new aho(this);
  private View.OnClickListener mLoginListener = new ahr(this);
  private Button mOKButton;
  private String mPasswd;
  private TextView mPasswdDisText;
  private EditText mPasswdEdit;
  private TextView mPasswdHideText;
  private long mUin;
  private TextView mfindPwdText;
  
  private void gotoNextStep()
  {
    AccountPageActivity.mNeedRefreshEval = true;
    SettingPageActivity.mNeedRefreshMbInfo = true;
    finish();
  }
  
  private void initView()
  {
    setContentView(2130903262);
    Object localObject = ax.a().e();
    if (localObject == null)
    {
      finish();
      return;
    }
    this.mUin = ((QQUser)localObject).mRealUin;
    ((TextView)findViewById(2131297110)).setText(((QQUser)localObject).mNickName + "(" + ((QQUser)localObject).mUinMask + ")");
    this.mPasswdEdit = ((EditText)findViewById(2131297313));
    if (this.mPasswdEdit != null) {
      this.mPasswdEdit.clearFocus();
    }
    this.mfindPwdText = ((TextView)findViewById(2131297318));
    this.mfindPwdText.setOnClickListener(this.mFindPwdListener);
    this.mPasswdDisText = ((TextView)findViewById(2131297315));
    this.mPasswdHideText = ((TextView)findViewById(2131297316));
    localObject = (SwitchButton)findViewById(2131297314);
    ((SwitchButton)localObject).a(true, false);
    ((SwitchButton)localObject).setOnCheckedChangeListener(this.mCheckListener);
    this.mOKButton = ((Button)findViewById(2131297317));
    this.mOKButton.setOnClickListener(this.mLoginListener);
    p.a().a(System.currentTimeMillis(), 73);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.WtloginSigExpireActivity
 * JD-Core Version:    0.7.0.1
 */