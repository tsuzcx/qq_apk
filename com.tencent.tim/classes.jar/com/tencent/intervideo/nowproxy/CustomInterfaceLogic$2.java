package com.tencent.intervideo.nowproxy;

import android.app.Activity;
import android.webkit.WebView;
import com.tencent.intervideo.nowproxy.baseability.cookie.CookieHelper;

class CustomInterfaceLogic$2
  implements WebCallHandler
{
  CustomInterfaceLogic$2(CustomInterfaceLogic paramCustomInterfaceLogic) {}
  
  public void getCookieInfo(NowCookieEvent paramNowCookieEvent)
  {
    CookieHelper.plant(Global.getApplicationContext(), paramNowCookieEvent);
  }
  
  public boolean onCallScheme(String paramString)
  {
    return false;
  }
  
  public void onWebPageReady(Activity paramActivity, WebView paramWebView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.CustomInterfaceLogic.2
 * JD-Core Version:    0.7.0.1
 */