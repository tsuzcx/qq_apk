package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

public class StartPwdGestureIndexActivity
  extends BaseActivity
{
  private View mDividerView;
  private TextView mFacePwdTxt;
  private View mFacePwdView;
  private TextView mGesturePwdTxt;
  private View mGesturePwdView;
  private Handler mHandler = new abr(this);
  private View.OnClickListener mManageGesturePwdListener = new abp(this);
  private View.OnClickListener mNewGesturePwdListener = new abq(this);
  
  private void initUI()
  {
    this.mGesturePwdView = findViewById(2131297119);
    this.mFacePwdView = findViewById(2131296547);
    this.mDividerView = findViewById(2131296550);
    this.mGesturePwdTxt = ((TextView)findViewById(2131297120));
    this.mFacePwdTxt = ((TextView)findViewById(2131297121));
    this.mFacePwdView.setOnClickListener(new abs(this));
    if (ax.a().e() == null) {
      this.mFacePwdView.setVisibility(8);
    }
  }
  
  private void refreshFacePwd()
  {
    if (ax.a().h())
    {
      QQUser localQQUser = t.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        this.mFacePwdTxt.setText(localQQUser.mNickName + "(" + s.e(localQQUser.mRealUin) + ")");
        this.mFacePwdTxt.setTextColor(getResources().getColor(2131165299));
      }
      for (;;)
      {
        this.mFacePwdView.setVisibility(0);
        this.mDividerView.setVisibility(0);
        return;
        this.mFacePwdTxt.setText(2131362381);
        this.mFacePwdTxt.setTextColor(getResources().getColor(2131165193));
      }
    }
    this.mFacePwdView.setVisibility(4);
    this.mDividerView.setVisibility(4);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903205);
    initUI();
  }
  
  public void onResume()
  {
    super.onResume();
    if (ax.a().k) {
      refreshFacePwd();
    }
    while (ah.a().c())
    {
      this.mGesturePwdTxt.setText(2131362380);
      this.mGesturePwdTxt.setTextColor(getResources().getColor(2131165299));
      this.mGesturePwdView.setOnClickListener(this.mManageGesturePwdListener);
      return;
      if (ax.a().e() != null) {
        af.a().b(this.mHandler);
      }
    }
    this.mGesturePwdTxt.setText(2131362381);
    this.mGesturePwdView.setOnClickListener(this.mNewGesturePwdListener);
    this.mGesturePwdTxt.setTextColor(getResources().getColor(2131165193));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdGestureIndexActivity
 * JD-Core Version:    0.7.0.1
 */