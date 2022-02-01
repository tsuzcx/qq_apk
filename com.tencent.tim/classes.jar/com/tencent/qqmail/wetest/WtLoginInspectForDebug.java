package com.tencent.qqmail.wetest;

import android.app.Application;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WtLoginInspectForDebug
{
  private static final String EMAIL = "";
  private static final String EMAIL_FOLDER_PWD = "";
  private static final String EMAIL_FOR_MONKEY = "";
  private static final String PASSWORD = "";
  private static final String PASSWORD_FOLDER_PWD = "";
  private static final String PASSWORD_FOR_MONKYE = "";
  private static final String TAG = "WtLoginInspectForDebug";
  
  private static WebView filterWebView(ViewGroup paramViewGroup)
  {
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      Object localObject = paramViewGroup.getChildAt(i);
      if ((localObject instanceof WebView)) {
        localObject = (WebView)localObject;
      }
      WebView localWebView;
      do
      {
        return localObject;
        if (!(localObject instanceof ViewGroup)) {
          break;
        }
        localWebView = filterWebView((ViewGroup)localObject);
        localObject = localWebView;
      } while (localWebView != null);
      i += 1;
    }
    return null;
  }
  
  public static void init(Application paramApplication)
  {
    if (WeTestConfig.autoLoginQQ()) {
      paramApplication.registerActivityLifecycleCallbacks(new WtLoginInspectForDebug.1());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.wetest.WtLoginInspectForDebug
 * JD-Core Version:    0.7.0.1
 */