package com.tencent.mobileqq.activity.phone;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import chw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ProtectedWebView;

public class TosActivity
  extends IphoneTitleBarActivity
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "frombusiness";
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "key_file";
  private static final String c = "file:///android_asset/phone_tos.html";
  private static final String d = "file:///android_asset/business_tos.html";
  private static final String e = "file:///android_asset/phone_tos.html";
  private ProtectedWebView jdField_a_of_type_ComTencentWidgetProtectedWebView;
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, TosActivity.class));
  }
  
  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, TosActivity.class);
    localIntent.putExtra("key_file", 2);
    paramContext.startActivity(localIntent);
  }
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = new ProtectedWebView(BaseApplicationImpl.a);
    this.a.setFadingEdgeLength(0);
    if (VersionUtils.c()) {
      this.a.setOverScrollMode(2);
    }
    setContentView(this.a);
    removeWebViewLayerType();
    setTitle("服务声明");
    if (getIntent().getIntExtra("key_file", 1) == 2) {}
    paramBundle = getIntent();
    if (paramBundle != null) {
      if (paramBundle.getIntExtra("frombusiness", 1) == 0) {
        this.a.loadUrl("file:///android_asset/business_tos.html");
      }
    }
    for (;;)
    {
      this.a.setOnLongClickListener(new chw(this));
      return true;
      this.a.loadUrl("file:///android_asset/phone_tos.html");
      continue;
      this.a.loadUrl("file:///android_asset/phone_tos.html");
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    setContentView(new TextView(this));
    try
    {
      this.a.stopLoading();
      try
      {
        label23:
        this.a.clearView();
        try
        {
          label30:
          this.a.destroy();
          return;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        break label30;
      }
    }
    catch (Exception localException3)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.TosActivity
 * JD-Core Version:    0.7.0.1
 */