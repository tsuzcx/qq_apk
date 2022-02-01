package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.bu;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cq;
import com.tencent.token.utils.m;

public class SettingTokenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView mTokenPwdTxt;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131559260: 
    default: 
      return;
    case 2131559259: 
      bu.a().a(System.currentTimeMillis(), 6);
      com.tencent.token.global.h.a();
      if ((cc.a().c()) && (cc.a().e() == 1)) {}
      for (paramView = new Intent(this, StartPwdDigitSelActivity.class);; paramView = new Intent(this, StartPwdGestureIndexActivity.class))
      {
        startActivity(paramView);
        cc.a().b("startpwd_tip_newflag");
        return;
      }
    case 2131559261: 
      startActivity(new Intent(this, CorrectTokenActivity.class));
      return;
    case 2131559262: 
      startActivity(new Intent(this, AssistantRecommendFriendQrcode.class));
      return;
    }
    startActivity(new Intent(this, AboutActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968760);
    findViewById(2131559259).setOnClickListener(this);
    findViewById(2131559261).setOnClickListener(this);
    findViewById(2131559262).setOnClickListener(this);
    findViewById(2131559263).setOnClickListener(this);
    this.mTokenPwdTxt = ((TextView)findViewById(2131559260));
  }
  
  public void onResume()
  {
    super.onResume();
    if (!com.tencent.token.core.bean.h.b().c()) {
      findViewById(2131559265).setVisibility(4);
    }
    QQUser localQQUser = m.f();
    if ((cc.a().c()) || ((cq.a().h()) && (localQQUser != null) && (localQQUser.mIsRegisterFacePwd)))
    {
      this.mTokenPwdTxt.setText(2131231443);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2131492937));
    }
    for (;;)
    {
      com.tencent.token.core.bean.h.b().d();
      return;
      this.mTokenPwdTxt.setText(2131231442);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2131493035));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingTokenActivity
 * JD-Core Version:    0.7.0.1
 */