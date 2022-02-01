package com.tencent.token.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.aaz;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.so;
import com.tencent.token.sw;
import com.tencent.token.tg;
import com.tencent.token.tt;

public class SettingTokenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView mTokenPwdTxt;
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131166012)
    {
      if (i != 2131166014)
      {
        if (i != 2131166019)
        {
          if (i != 2131166022) {
            return;
          }
          so.a().a(System.currentTimeMillis(), 6);
          if ((sw.a().c()) && (sw.a().a == 1)) {
            paramView = new Intent(this, StartPwdDigitSelActivity.class);
          } else {
            paramView = new Intent(this, StartPwdGestureIndexActivity.class);
          }
          startActivity(paramView);
          sw.a();
          sw.d("startpwd_tip_newflag");
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
    setContentView(2131296455);
    findViewById(2131166022).setOnClickListener(this);
    findViewById(2131166014).setOnClickListener(this);
    findViewById(2131166019).setOnClickListener(this);
    findViewById(2131166012).setOnClickListener(this);
    this.mTokenPwdTxt = ((TextView)findViewById(2131166023));
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = tg.b();
    int j = ((tg)localObject).a;
    int i = 1;
    if ((j == 0) || (1 == ((tg)localObject).a)) {
      i = 0;
    }
    if (i == 0) {
      findViewById(2131165789).setVisibility(4);
    }
    localObject = aaz.f();
    if ((!sw.a().c()) && ((!tt.a().d()) || (localObject == null) || (!((QQUser)localObject).mIsRegisterFacePwd)))
    {
      this.mTokenPwdTxt.setText(2131493595);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968770));
    }
    else
    {
      this.mTokenPwdTxt.setText(2131493596);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968670));
    }
    tg.b();
    localObject = tg.a().edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sp_new_key", false);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingTokenActivity
 * JD-Core Version:    0.7.0.1
 */