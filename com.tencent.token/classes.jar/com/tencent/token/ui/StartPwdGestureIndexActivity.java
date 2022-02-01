package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.aao;
import com.tencent.token.aap;
import com.tencent.token.ais;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.sc;
import com.tencent.token.sc.a;
import com.tencent.token.sk;
import com.tencent.token.th;
import com.tencent.token.xh;

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
      paramAnonymousMessage = (xh)paramAnonymousMessage.obj;
      xh.a(StartPwdGestureIndexActivity.this.getResources(), paramAnonymousMessage);
      StartPwdGestureIndexActivity.this.showUserDialog(2131492910, paramAnonymousMessage.c, 2131493040, null);
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
    this.mGesturePwdView = findViewById(2131165982);
    this.mFacePwdView = findViewById(2131165980);
    this.mDividerView = findViewById(2131165447);
    this.mGesturePwdTxt = ((TextView)findViewById(2131165983));
    this.mFacePwdTxt = ((TextView)findViewById(2131165981));
    this.mFacePwdView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(StartPwdGestureIndexActivity.this, FacePwdIndexActivity.class);
        StartPwdGestureIndexActivity.this.startActivity(paramAnonymousView);
      }
    });
    if (th.a().k.b() == null)
    {
      this.mFacePwdView.setVisibility(8);
      return;
    }
  }
  
  private void refreshFacePwd()
  {
    if (th.a().d())
    {
      QQUser localQQUser = aap.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        TextView localTextView = this.mFacePwdTxt;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localQQUser.mNickName);
        localStringBuilder.append("(");
        localStringBuilder.append(aao.e(localQQUser.mRealUin));
        localStringBuilder.append(")");
        localTextView.setText(localStringBuilder.toString());
        this.mFacePwdTxt.setTextColor(getResources().getColor(2130968669));
      }
      else
      {
        this.mFacePwdTxt.setText(2131493587);
        this.mFacePwdTxt.setTextColor(getResources().getColor(2130968769));
      }
      if (aap.n())
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
    setContentView(2131296449);
    initUI();
  }
  
  public void onResume()
  {
    super.onResume();
    if (th.a().j) {
      refreshFacePwd();
    } else if (th.a().k.b() != null) {
      sc.a.a().c(this.mHandler);
    }
    if (sk.a().c())
    {
      this.mGesturePwdTxt.setText(2131493588);
      this.mGesturePwdTxt.setTextColor(getResources().getColor(2130968669));
      this.mGesturePwdView.setOnClickListener(this.mManageGesturePwdListener);
      return;
    }
    this.mGesturePwdTxt.setText(2131493587);
    this.mGesturePwdView.setOnClickListener(this.mNewGesturePwdListener);
    this.mGesturePwdTxt.setTextColor(getResources().getColor(2130968769));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureIndexActivity
 * JD-Core Version:    0.7.0.1
 */