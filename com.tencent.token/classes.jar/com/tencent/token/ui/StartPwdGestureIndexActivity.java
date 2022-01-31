package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

public class StartPwdGestureIndexActivity
  extends BaseActivity
{
  private View mDividerView;
  private TextView mFacePwdTxt;
  private View mFacePwdView;
  private TextView mGesturePwdTxt;
  private View mGesturePwdView;
  private Handler mHandler = new zx(this);
  private View.OnClickListener mManageGesturePwdListener = new zv(this);
  private View.OnClickListener mNewGesturePwdListener = new zw(this);
  
  private void initUI()
  {
    this.mGesturePwdView = findViewById(2131559280);
    this.mFacePwdView = findViewById(2131558833);
    this.mDividerView = findViewById(2131558836);
    this.mGesturePwdTxt = ((TextView)findViewById(2131559281));
    this.mFacePwdTxt = ((TextView)findViewById(2131559282));
    this.mFacePwdView.setOnClickListener(new zy(this));
    if (do.a().e() == null) {
      this.mFacePwdView.setVisibility(8);
    }
  }
  
  private void refreshFacePwd()
  {
    if (do.a().h())
    {
      QQUser localQQUser = x.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        this.mFacePwdTxt.setText(localQQUser.mNickName + "(" + w.e(localQQUser.mRealUin) + ")");
        this.mFacePwdTxt.setTextColor(getResources().getColor(2131492937));
      }
      while (x.n())
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
    if (do.a().k) {
      refreshFacePwd();
    }
    while (cy.a().c())
    {
      this.mGesturePwdTxt.setText(2131231443);
      this.mGesturePwdTxt.setTextColor(getResources().getColor(2131492937));
      this.mGesturePwdView.setOnClickListener(this.mManageGesturePwdListener);
      return;
      if (do.a().e() != null) {
        cw.a().b(this.mHandler);
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