package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import enh;

public class TroopNewcomerNoticeActivity
  extends QQBrowserActivity
  implements View.OnClickListener
{
  public static final String a = "troop_friend_uin";
  public static final String b = "http://web.qun.qq.com/mannounce/portal.html#gc=%s";
  protected boolean a = false;
  public String c = "";
  protected View d = null;
  
  protected boolean a()
  {
    this.a = true;
    ThreadManager.b(new enh(this));
    finish();
    return super.a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.c = getIntent().getStringExtra("troop_friend_uin");
    if (!TextUtils.isEmpty(this.c))
    {
      super.getIntent().putExtra("url", String.format("http://web.qun.qq.com/mannounce/portal.html#gc=%s", new Object[] { this.c }));
      super.doOnCreate(paramBundle);
      u();
      a(false);
    }
    try
    {
      ((View)findViewById(2131296891).getParent()).setVisibility(8);
      return true;
      super.finish();
      return false;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.d("TroopNewcomerNoticeActivity", 1, "titleBar visiable gone.");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "AIOchat", "Clk_iknow", 0, 0, this.c, "", "", "");
    a();
  }
  
  protected void u()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296636);
    if (this.d == null) {
      this.d = LayoutInflater.from(this).inflate(2130903382, null);
    }
    this.d.findViewById(2131297887).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localRelativeLayout.addView(this.d, localLayoutParams);
    ((RelativeLayout.LayoutParams)findViewById(2131296643).getLayoutParams()).addRule(2, 2131297886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNewcomerNoticeActivity
 * JD-Core Version:    0.7.0.1
 */