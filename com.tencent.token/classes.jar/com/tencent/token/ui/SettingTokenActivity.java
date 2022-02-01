package com.tencent.token.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.aap;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.sb;
import com.tencent.token.sk;
import com.tencent.token.su;
import com.tencent.token.th;

public class SettingTokenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView mTokenPwdTxt;
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131165977)
    {
      if (i != 2131165979)
      {
        if (i != 2131165984)
        {
          if (i != 2131165987) {
            return;
          }
          sb.a().a(System.currentTimeMillis(), 6);
          if ((sk.a().c()) && (sk.a().a == 1)) {
            paramView = new Intent(this, StartPwdDigitSelActivity.class);
          } else {
            paramView = new Intent(this, StartPwdGestureIndexActivity.class);
          }
          startActivity(paramView);
          sk.a();
          sk.d("startpwd_tip_newflag");
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
    findViewById(2131165987).setOnClickListener(this);
    findViewById(2131165979).setOnClickListener(this);
    findViewById(2131165984).setOnClickListener(this);
    findViewById(2131165977).setOnClickListener(this);
    this.mTokenPwdTxt = ((TextView)findViewById(2131165988));
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = su.b();
    int j = ((su)localObject).a;
    int i = 1;
    if ((j == 0) || (1 == ((su)localObject).a)) {
      i = 0;
    }
    if (i == 0) {
      findViewById(2131165772).setVisibility(4);
    }
    localObject = aap.f();
    if ((!sk.a().c()) && ((!th.a().d()) || (localObject == null) || (!((QQUser)localObject).mIsRegisterFacePwd)))
    {
      this.mTokenPwdTxt.setText(2131493587);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968769));
    }
    else
    {
      this.mTokenPwdTxt.setText(2131493588);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968669));
    }
    su.b();
    localObject = su.a().edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sp_new_key", false);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingTokenActivity
 * JD-Core Version:    0.7.0.1
 */