package com.tencent.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class InputMethodUtil
{
  public static final String a = "SOGOU_EXPRESSION";
  public static final String b = "com.sogou.inputmethod.expression";
  public static final String c = "SOGOU_EXP_PATH";
  public static final String d = "com.sogou.inputmethod.appid";
  public static final String e = "com.tencent.mobileqq.sogou.openid";
  public static final String f = "SOGOU_APP_ID";
  public static final String g = "SOGOU_OPENID";
  
  public static void a(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "default_input_method");
    return (paramContext != null) && (paramContext.contains("com.sohu.inputmethod.sogou"));
  }
  
  public static void b(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.util.InputMethodUtil
 * JD-Core Version:    0.7.0.1
 */