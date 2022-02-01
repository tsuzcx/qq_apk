package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.bv;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
import com.tencent.token.global.e;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;

public class StartPwdGestureIndexActivity
  extends BaseActivity
{
  private View mDividerView;
  private TextView mFacePwdTxt;
  private View mFacePwdView;
  private TextView mGesturePwdTxt;
  private View mGesturePwdView;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (StartPwdGestureIndexActivity.this.isFinishing()) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        StartPwdGestureIndexActivity.this.refreshFacePwd();
        return;
      }
      StartPwdGestureIndexActivity.this.dismissDialog();
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      e.a(StartPwdGestureIndexActivity.this.getResources(), paramAnonymousMessage);
      StartPwdGestureIndexActivity.this.showUserDialog(2131230767, paramAnonymousMessage.c, 2131230897, null);
    }
  };
  private View.OnClickListener mManageGesturePwdListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new Intent(StartPwdGestureIndexActivity.this, StartPwdGestureSelActivity.class);
      StartPwdGestureIndexActivity.this.startActivity(paramAnonymousView);
    }
  };
  private View.OnClickListener mNewGesturePwdListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new Intent(StartPwdGestureIndexActivity.this, StartPwdUpdateInfoActivity.class);
      StartPwdGestureIndexActivity.this.startActivity(paramAnonymousView);
    }
  };
  
  private void initUI()
  {
    this.mGesturePwdView = findViewById(2131559281);
    this.mFacePwdView = findViewById(2131558834);
    this.mDividerView = findViewById(2131558837);
    this.mGesturePwdTxt = ((TextView)findViewById(2131559282));
    this.mFacePwdTxt = ((TextView)findViewById(2131559283));
    this.mFacePwdView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(StartPwdGestureIndexActivity.this, FacePwdIndexActivity.class);
        StartPwdGestureIndexActivity.this.startActivity(paramAnonymousView);
      }
    });
    if (cr.a().e() == null) {
      this.mFacePwdView.setVisibility(8);
    }
  }
  
  private void refreshFacePwd()
  {
    if (cr.a().h())
    {
      QQUser localQQUser = m.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        this.mFacePwdTxt.setText(localQQUser.mNickName + "(" + l.e(localQQUser.mRealUin) + ")");
        this.mFacePwdTxt.setTextColor(getResources().getColor(2131492937));
      }
      while (m.n())
      {
        this.mFacePwdView.setVisibility(0);
        this.mDividerView.setVisibility(0);
        return;
        this.mFacePwdTxt.setText(2131231442);
        this.mFacePwdTxt.setTextColor(getResources().getColor(2131493035));
      }
      this.mFacePwdView.setVisibility(4);
      this.mDividerView.setVisibility(4);
      return;
    }
    this.mFacePwdView.setVisibility(4);
    this.mDividerView.setVisibility(4);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968767);
    initUI();
  }
  
  public void onResume()
  {
    super.onResume();
    if (cr.a().k) {
      refreshFacePwd();
    }
    while (cd.a().c())
    {
      this.mGesturePwdTxt.setText(2131231443);
      this.mGesturePwdTxt.setTextColor(getResources().getColor(2131492937));
      this.mGesturePwdView.setOnClickListener(this.mManageGesturePwdListener);
      return;
      if (cr.a().e() != null) {
        bv.a().e(this.mHandler);
      }
    }
    this.mGesturePwdTxt.setText(2131231442);
    this.mGesturePwdView.setOnClickListener(this.mNewGesturePwdListener);
    this.mGesturePwdTxt.setTextColor(getResources().getColor(2131493035));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureIndexActivity
 * JD-Core Version:    0.7.0.1
 */