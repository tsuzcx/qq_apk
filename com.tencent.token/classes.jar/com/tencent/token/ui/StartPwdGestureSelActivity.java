package com.tencent.token.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.aac;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.rt;
import com.tencent.token.sc;
import com.tencent.token.ui.base.SwitchButton;

public class StartPwdGestureSelActivity
  extends BaseActivity
{
  public static final int K_SEL2CLEAR_INTENT_REQUESTCODE = 256;
  public static final int K_SEL2CLEAR_INTENT_RESULTCODE = 257;
  public static final int K_SEL2MODIFY_INTENT_REQUESTCODE = 258;
  public static final int K_SEL2MODIFY_INTENT_RESULTCODE = 259;
  private Button mButtonClear;
  private Button mButtonModify;
  private boolean mIsChecked = false;
  private int mSetStartPwd;
  private SwitchButton mSwitchStartPwd;
  private TextView mTextOpName;
  
  private void initUI()
  {
    this.mButtonModify.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        rt.a().a(System.currentTimeMillis(), 15);
        paramAnonymousView = new Intent(StartPwdGestureSelActivity.this, StartPwdGestureModifyActivity.class);
        StartPwdGestureSelActivity.this.startActivityForResult(paramAnonymousView, 258);
        aac.a(StartPwdGestureSelActivity.this, 1);
      }
    });
    this.mButtonClear.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        rt.a().a(System.currentTimeMillis(), 21);
        paramAnonymousView = new Intent(StartPwdGestureSelActivity.this, StartPwdGestureDeleteActivity.class);
        StartPwdGestureSelActivity.this.startActivityForResult(paramAnonymousView, 256);
        aac.a(StartPwdGestureSelActivity.this, 1);
      }
    });
    try
    {
      this.mSetStartPwd = RqdApplication.n().getSharedPreferences("start_pwd_config", 0).getInt("is_set_start_pwd_show", 1);
      if (this.mSetStartPwd == 1)
      {
        this.mSwitchStartPwd.a(false, false);
        this.mIsChecked = true;
      }
      else
      {
        this.mSwitchStartPwd.a(true, false);
        this.mIsChecked = false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.mSwitchStartPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean != StartPwdGestureSelActivity.this.mIsChecked) {
          return;
        }
        try
        {
          paramAnonymousCompoundButton = RqdApplication.n().getSharedPreferences("start_pwd_config", 0).edit();
          if (StartPwdGestureSelActivity.this.mSetStartPwd == 1)
          {
            rt.a().a(System.currentTimeMillis(), 65);
            paramAnonymousCompoundButton.putInt("is_set_start_pwd_show", 0);
            StartPwdGestureSelActivity.access$102(StartPwdGestureSelActivity.this, 0);
            StartPwdGestureSelActivity.this.mSwitchStartPwd.a(true, false);
            StartPwdGestureSelActivity.access$002(StartPwdGestureSelActivity.this, false);
          }
          else
          {
            paramAnonymousCompoundButton.putInt("is_set_start_pwd_show", 1);
            StartPwdGestureSelActivity.access$102(StartPwdGestureSelActivity.this, 1);
            StartPwdGestureSelActivity.this.mSwitchStartPwd.a(false, false);
            StartPwdGestureSelActivity.access$002(StartPwdGestureSelActivity.this, true);
          }
          paramAnonymousCompoundButton.commit();
          return;
        }
        catch (Exception paramAnonymousCompoundButton)
        {
          paramAnonymousCompoundButton.printStackTrace();
        }
      }
    });
    this.mTitleBar.setBackgroundColor(getResources().getColor(2130968773));
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2130968789));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2131099762));
    this.mTitleText.setTextColor(getResources().getColor(2130968761));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 256)
    {
      if (paramInt2 == 257)
      {
        rt.a().a(System.currentTimeMillis(), 22);
        startActivity(new Intent(this, StartPwdUpdateInfoActivity.class));
        showOrangeToast(2131493245, 2131100170);
        finish();
        return;
      }
      if (!sc.a().c()) {
        finish();
      }
    }
    else if (paramInt1 == 258)
    {
      if (paramInt2 == 259)
      {
        rt.a().a(System.currentTimeMillis(), 16);
        showOrangeToast(2131493234, 2131100170);
        return;
      }
      if (!sc.a().c()) {
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296451);
    this.mButtonModify = ((Button)findViewById(2131165566));
    this.mButtonClear = ((Button)findViewById(2131165564));
    this.mSwitchStartPwd = ((SwitchButton)findViewById(2131165377));
    this.mTextOpName = ((TextView)findViewById(2131166076));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureSelActivity
 * JD-Core Version:    0.7.0.1
 */