package com.tencent.token.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.aay;
import com.tencent.token.aaz;
import com.tencent.token.ajr;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.sp;
import com.tencent.token.sp.a;
import com.tencent.token.sw;
import com.tencent.token.tt;
import com.tencent.token.xt;

public class StartPwdGestureIndexActivity
  extends BaseActivity
{
  private View mDividerView;
  private TextView mFacePwdTxt;
  private View mFacePwdView;
  private TextView mGesturePwdTxt;
  private View mGesturePwdView;
  @SuppressLint({"HandlerLeak"})
  private Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (StartPwdGestureIndexActivity.this.isFinishing()) {
        return;
      }
      if (paramAnonymousMessage.what != 3003) {
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        StartPwdGestureIndexActivity.this.refreshFacePwd();
        return;
      }
      StartPwdGestureIndexActivity.this.dismissDialog();
      paramAnonymousMessage = (xt)paramAnonymousMessage.obj;
      xt.a(StartPwdGestureIndexActivity.this.getResources(), paramAnonymousMessage);
      StartPwdGestureIndexActivity.this.showUserDialog(2131492911, paramAnonymousMessage.c, 2131493041, null);
    }
  };
  private View.OnClickListener mManageGesturePwdListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new Intent(StartPwdGestureIndexActivity.this, StartPwdGestureSelActivity.class);
      StartPwdGestureIndexActivity.this.startActivity(paramAnonymousView);
    }
  };
  private View.OnClickListener mNewGesturePwdListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new Intent(StartPwdGestureIndexActivity.this, StartPwdUpdateInfoActivity.class);
      StartPwdGestureIndexActivity.this.startActivity(paramAnonymousView);
    }
  };
  
  private void initUI()
  {
    this.mGesturePwdView = findViewById(2131166017);
    this.mFacePwdView = findViewById(2131166015);
    this.mDividerView = findViewById(2131165460);
    this.mGesturePwdTxt = ((TextView)findViewById(2131166018));
    this.mFacePwdTxt = ((TextView)findViewById(2131166016));
    this.mFacePwdView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(StartPwdGestureIndexActivity.this, FacePwdIndexActivity.class);
        StartPwdGestureIndexActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.mFacePwdView.setVisibility(8);
  }
  
  private void refreshFacePwd()
  {
    if (tt.a().d())
    {
      QQUser localQQUser = aaz.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        TextView localTextView = this.mFacePwdTxt;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localQQUser.mNickName);
        localStringBuilder.append("(");
        localStringBuilder.append(aay.e(localQQUser.mRealUin));
        localStringBuilder.append(")");
        localTextView.setText(localStringBuilder.toString());
        this.mFacePwdTxt.setTextColor(getResources().getColor(2130968670));
      }
      else
      {
        this.mFacePwdTxt.setText(2131493595);
        this.mFacePwdTxt.setTextColor(getResources().getColor(2130968770));
      }
      if (aaz.n())
      {
        this.mFacePwdView.setVisibility(0);
        this.mDividerView.setVisibility(0);
        return;
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
    setContentView(2131296462);
    initUI();
  }
  
  public void onResume()
  {
    super.onResume();
    if (tt.a().j) {
      refreshFacePwd();
    } else if (tt.a().k.b() != null) {
      sp.a.a().b(this.mHandler);
    }
    if (sw.a().c())
    {
      this.mGesturePwdTxt.setText(2131493596);
      this.mGesturePwdTxt.setTextColor(getResources().getColor(2130968670));
      this.mGesturePwdView.setOnClickListener(this.mManageGesturePwdListener);
      return;
    }
    this.mGesturePwdTxt.setText(2131493595);
    this.mGesturePwdView.setOnClickListener(this.mNewGesturePwdListener);
    this.mGesturePwdTxt.setTextColor(getResources().getColor(2130968770));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureIndexActivity
 * JD-Core Version:    0.7.0.1
 */