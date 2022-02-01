package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.token.bv;
import com.tencent.token.ce;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tencent.token.utils.m;

public class SettingTokenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView mTokenPwdTxt;
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131165970)
    {
      if (i != 2131165972)
      {
        if (i != 2131165977)
        {
          if (i != 2131165980) {
            return;
          }
          bv.a().a(System.currentTimeMillis(), 6);
          com.tencent.token.global.h.a();
          if ((ce.a().c()) && (ce.a().e() == 1)) {
            paramView = new Intent(this, StartPwdDigitSelActivity.class);
          } else {
            paramView = new Intent(this, StartPwdGestureIndexActivity.class);
          }
          startActivity(paramView);
          ce.a().b("startpwd_tip_newflag");
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
    findViewById(2131165980).setOnClickListener(this);
    findViewById(2131165972).setOnClickListener(this);
    findViewById(2131165977).setOnClickListener(this);
    findViewById(2131165970).setOnClickListener(this);
    this.mTokenPwdTxt = ((TextView)findViewById(2131165981));
  }
  
  public void onResume()
  {
    super.onResume();
    if (!com.tencent.token.core.bean.h.b().c()) {
      findViewById(2131165767).setVisibility(4);
    }
    QQUser localQQUser = m.f();
    if ((!ce.a().c()) && ((!cs.a().h()) || (localQQUser == null) || (!localQQUser.mIsRegisterFacePwd)))
    {
      this.mTokenPwdTxt.setText(2131493586);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968769));
    }
    else
    {
      this.mTokenPwdTxt.setText(2131493587);
      this.mTokenPwdTxt.setTextColor(getResources().getColor(2130968669));
    }
    com.tencent.token.core.bean.h.b().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingTokenActivity
 * JD-Core Version:    0.7.0.1
 */