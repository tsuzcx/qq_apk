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
import com.tencent.token.bu;
import com.tencent.token.cc;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.l;

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
      public void onClick(View paramAnonymousView)
      {
        bu.a().a(System.currentTimeMillis(), 15);
        paramAnonymousView = new Intent(StartPwdGestureSelActivity.this, StartPwdGestureModifyActivity.class);
        StartPwdGestureSelActivity.this.startActivityForResult(paramAnonymousView, 258);
        l.a(StartPwdGestureSelActivity.this, 1);
      }
    });
    this.mButtonClear.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        bu.a().a(System.currentTimeMillis(), 21);
        paramAnonymousView = new Intent(StartPwdGestureSelActivity.this, StartPwdGestureDeleteActivity.class);
        StartPwdGestureSelActivity.this.startActivityForResult(paramAnonymousView, 256);
        l.a(StartPwdGestureSelActivity.this, 1);
      }
    });
    try
    {
      this.mSetStartPwd = RqdApplication.l().getSharedPreferences("start_pwd_config", 0).getInt("is_set_start_pwd_show", 1);
      if (this.mSetStartPwd == 1) {
        this.mSwitchStartPwd.a(false, false);
      }
      for (this.mIsChecked = true;; this.mIsChecked = false)
      {
        this.mSwitchStartPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean != StartPwdGestureSelActivity.this.mIsChecked) {
              return;
            }
            for (;;)
            {
              try
              {
                paramAnonymousCompoundButton = RqdApplication.l().getSharedPreferences("start_pwd_config", 0).edit();
                if (StartPwdGestureSelActivity.this.mSetStartPwd == 1)
                {
                  bu.a().a(System.currentTimeMillis(), 65);
                  paramAnonymousCompoundButton.putInt("is_set_start_pwd_show", 0);
                  StartPwdGestureSelActivity.access$102(StartPwdGestureSelActivity.this, 0);
                  StartPwdGestureSelActivity.this.mSwitchStartPwd.a(true, false);
                  StartPwdGestureSelActivity.access$002(StartPwdGestureSelActivity.this, false);
                  paramAnonymousCompoundButton.commit();
                  return;
                }
              }
              catch (Exception paramAnonymousCompoundButton)
              {
                paramAnonymousCompoundButton.printStackTrace();
                return;
              }
              paramAnonymousCompoundButton.putInt("is_set_start_pwd_show", 1);
              StartPwdGestureSelActivity.access$102(StartPwdGestureSelActivity.this, 1);
              StartPwdGestureSelActivity.this.mSwitchStartPwd.a(false, false);
              StartPwdGestureSelActivity.access$002(StartPwdGestureSelActivity.this, true);
            }
          }
        });
        this.mTitleBar.setBackgroundColor(getResources().getColor(2131493039));
        this.mTitleDivider.setBackgroundColor(getResources().getColor(2131493053));
        this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837617));
        this.mTitleText.setTextColor(getResources().getColor(2131493027));
        return;
        this.mSwitchStartPwd.a(true, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 256) {
      if (paramInt2 == 257)
      {
        bu.a().a(System.currentTimeMillis(), 22);
        startActivity(new Intent(this, StartPwdUpdateInfoActivity.class));
        showOrangeToast(2131231102, 2130838018);
        finish();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (cc.a().c());
        finish();
        return;
      } while (paramInt1 != 258);
      if (paramInt2 == 259)
      {
        bu.a().a(System.currentTimeMillis(), 16);
        showOrangeToast(2131231091, 2130838018);
        return;
      }
    } while (cc.a().c());
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968769);
    this.mButtonModify = ((Button)findViewById(2131559290));
    this.mButtonClear = ((Button)findViewById(2131559291));
    this.mSwitchStartPwd = ((SwitchButton)findViewById(2131559289));
    this.mTextOpName = ((TextView)findViewById(2131558539));
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureSelActivity
 * JD-Core Version:    0.7.0.1
 */