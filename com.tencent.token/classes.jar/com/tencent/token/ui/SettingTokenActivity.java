package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.h;
import com.tencent.token.p;
import com.tencent.token.utils.t;

public class SettingTokenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView mTokenPwdTxt;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297090: 
    default: 
      return;
    case 2131297089: 
      p.a().a(System.currentTimeMillis(), 6);
      if ((ah.a().c()) && (ah.a().e() == 1)) {}
      for (paramView = new Intent(this, StartPwdDigitSelActivity.class);; paramView = new Intent(this, StartPwdGestureIndexActivity.class))
      {
        startActivity(paramView);
        ah.a();
        ah.d("startpwd_tip_newflag");
        return;
      }
    case 2131297091: 
      startActivity(new Intent(this, CorrectTokenActivity.class));
      return;
    case 2131297092: 
      startActivity(new Intent(this, AssistantRecommendFriendQrcode.class));
      return;
    }
    startActivity(new Intent(this, AboutActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903197);
    findViewById(2131297089).setOnClickListener(this);
    findViewById(2131297091).setOnClickListener(this);
    findViewById(2131297092).setOnClickListener(this);
    findViewById(2131297093).setOnClickListener(this);
    this.mTokenPwdTxt = ((TextView)findViewById(2131297090));
  }
  
  public void onResume()
  {
    super.onResume();
    if (!h.b().e()) {
      findViewById(2131296288).setVisibility(4);
    }
    QQUser localQQUser = t.f();
    if ((ah.a().c()) || ((ax.a().h()) && (localQQUser != null) && (localQQUser.mIsRegisterFacePwd)))
    {
      this.mTokenPwdTxt.setText(2131362380);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2131165299));
    }
    for (;;)
    {
      h.b();
      h.f();
      return;
      this.mTokenPwdTxt.setText(2131362381);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2131165193));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingTokenActivity
 * JD-Core Version:    0.7.0.1
 */