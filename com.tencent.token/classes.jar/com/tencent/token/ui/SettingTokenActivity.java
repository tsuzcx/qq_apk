package com.tencent.token.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.aad;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.rt;
import com.tencent.token.sc;
import com.tencent.token.sm;
import com.tencent.token.sz;

public class SettingTokenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView mTokenPwdTxt;
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131165975)
    {
      if (i != 2131165977)
      {
        if (i != 2131165982)
        {
          if (i != 2131165985) {
            return;
          }
          rt.a().a(System.currentTimeMillis(), 6);
          if ((sc.a().c()) && (sc.a().a == 1)) {
            paramView = new Intent(this, StartPwdDigitSelActivity.class);
          } else {
            paramView = new Intent(this, StartPwdGestureIndexActivity.class);
          }
          startActivity(paramView);
          sc.a();
          sc.d("startpwd_tip_newflag");
          return;
        }
        startActivity(new Intent(this, AssistantRecommendFriendQrcode.class));
        return;
      }
      startActivity(new Intent(this, CorrectTokenActivity.class));
      return;
    }
    startActivity(new Intent(this, AboutActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296442);
    findViewById(2131165985).setOnClickListener(this);
    findViewById(2131165977).setOnClickListener(this);
    findViewById(2131165982).setOnClickListener(this);
    findViewById(2131165975).setOnClickListener(this);
    this.mTokenPwdTxt = ((TextView)findViewById(2131165986));
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = sm.b();
    int j = ((sm)localObject).a;
    int i = 1;
    if ((j == 0) || (1 == ((sm)localObject).a)) {
      i = 0;
    }
    if (i == 0) {
      findViewById(2131165771).setVisibility(4);
    }
    localObject = aad.f();
    if ((!sc.a().c()) && ((!sz.a().d()) || (localObject == null) || (!((QQUser)localObject).mIsRegisterFacePwd)))
    {
      this.mTokenPwdTxt.setText(2131493587);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968769));
    }
    else
    {
      this.mTokenPwdTxt.setText(2131493588);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968669));
    }
    sm.b();
    localObject = sm.a().edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sp_new_key", false);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingTokenActivity
 * JD-Core Version:    0.7.0.1
 */