package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.bu;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
import com.tencent.token.utils.m;

public class SettingTokenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView mTokenPwdTxt;
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131165968)
    {
      if (i != 2131165970)
      {
        if (i != 2131165975)
        {
          if (i != 2131165978) {
            return;
          }
          bu.a().a(System.currentTimeMillis(), 6);
          com.tencent.token.global.h.a();
          if ((cd.a().c()) && (cd.a().e() == 1)) {
            paramView = new Intent(this, StartPwdDigitSelActivity.class);
          } else {
            paramView = new Intent(this, StartPwdGestureIndexActivity.class);
          }
          startActivity(paramView);
          cd.a().b("startpwd_tip_newflag");
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
    setContentView(2131296441);
    findViewById(2131165978).setOnClickListener(this);
    findViewById(2131165970).setOnClickListener(this);
    findViewById(2131165975).setOnClickListener(this);
    findViewById(2131165968).setOnClickListener(this);
    this.mTokenPwdTxt = ((TextView)findViewById(2131165979));
  }
  
  public void onResume()
  {
    super.onResume();
    if (!com.tencent.token.core.bean.h.b().c()) {
      findViewById(2131165765).setVisibility(4);
    }
    QQUser localQQUser = m.f();
    if ((!cd.a().c()) && ((!cr.a().h()) || (localQQUser == null) || (!localQQUser.mIsRegisterFacePwd)))
    {
      this.mTokenPwdTxt.setText(2131493585);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968769));
    }
    else
    {
      this.mTokenPwdTxt.setText(2131493586);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968669));
    }
    com.tencent.token.core.bean.h.b().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingTokenActivity
 * JD-Core Version:    0.7.0.1
 */