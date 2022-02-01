package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import gum;
import gun;

public class TroopNewcomerNoticeActivity
  extends QQBrowserActivity
  implements View.OnClickListener
{
  public static final String a = "troop_friend_uin";
  public static final String b = "http://web.qun.qq.com/mannounce/portal.html#gc=%s";
  protected boolean a = false;
  protected View b = null;
  public String c = "";
  
  protected void e()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131231172);
    if (this.b == null) {
      this.b = LayoutInflater.from(this).inflate(2130903462, null);
    }
    this.b.findViewById(2131232662).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localRelativeLayout.addView(this.b, localLayoutParams);
    ((RelativeLayout.LayoutParams)findViewById(2131231179).getLayoutParams()).addRule(2, 2131232661);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.a = true;
    finish();
    ThreadManager.b(new gum(this));
    ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "AIOchat", "Clk_iknow", 0, 0, this.c, "", "", "");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e();
    a(false);
    try
    {
      ((View)findViewById(2131231447).getParent()).setVisibility(8);
      this.c = getIntent().getStringExtra("troop_friend_uin");
      if (!TextUtils.isEmpty(this.c))
      {
        ((CustomWebView)findViewById(2131230905)).loadUrl(String.format("http://web.qun.qq.com/mannounce/portal.html#gc=%s", new Object[] { this.c }));
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.d("TroopNewcomerNoticeActivity", 2, "titleBar visiable gone.");
      }
      finish();
    }
  }
  
  protected void onDestroy()
  {
    if (!this.a) {
      ThreadManager.b(new gun(this));
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNewcomerNoticeActivity
 * JD-Core Version:    0.7.0.1
 */