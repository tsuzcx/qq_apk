package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import elm;

public class MyBusinessActivity
  extends PublicAccountBrowser
{
  public static final int a = 2;
  public static final String a = "MyBusinessActivity_NeedRefreshPage";
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, MyBusinessActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("title", paramActivity.getString(2131562419));
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hideRightButton", true);
    paramActivity.startActivity(localIntent);
  }
  
  public static void c(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.a()).edit().putBoolean("MyBusinessActivity_NeedRefreshPage", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m.setVisibility(0);
      this.m.setText(getResources().getString(2131558971));
      this.m.setOnClickListener(new elm(this));
      return;
    }
    this.m.setVisibility(8);
    this.m.setText("");
    this.m.setOnClickListener(null);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.a()).getBoolean("MyBusinessActivity_NeedRefreshPage", false))
    {
      if (this.a != null) {
        this.a.reload();
      }
      c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.MyBusinessActivity
 * JD-Core Version:    0.7.0.1
 */