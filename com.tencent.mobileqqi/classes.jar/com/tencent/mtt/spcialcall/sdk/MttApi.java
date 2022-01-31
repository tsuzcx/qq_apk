package com.tencent.mtt.spcialcall.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;

public class MttApi
{
  public static int a(Activity paramActivity, String paramString, HashMap paramHashMap)
  {
    return MttLoader.a(paramActivity, paramString, paramHashMap);
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    if (b(paramWebView, paramString)) {
      return;
    }
    if (MttLoader.b(paramWebView.getContext())) {}
    for (paramString = "http://res.imtt.qq.com/mbwebview/open_mtt_hd.txt";; paramString = "http://res.imtt.qq.com/mbwebview/download_mtt_hd.txt")
    {
      paramString = "javascript:var insertJsNode=document.getElementById(\"" + "x5insertadnode" + "\");if(null==insertJsNode){insertJsNode=document.createElement('script');insertJsNode.setAttribute('id',\"" + "x5insertadnode" + "\");insertJsNode.setAttribute('charset','" + "gbk" + "');insertJsNode.setAttribute('src',\"" + paramString + "\");document.body.appendChild(insertJsNode);}";
      try
      {
        paramWebView.loadUrl(paramString);
        return;
      }
      catch (Exception paramWebView)
      {
        return;
      }
    }
  }
  
  public static boolean a(WebView paramWebView, String paramString)
  {
    if ((paramString != null) && (paramWebView != null) && (paramString.startsWith("mttbrowser://")))
    {
      paramString = new Intent();
      paramString.setAction("com.tencent.QQBrowser.action.VIEW");
      String str = paramWebView.getUrl();
      if (str != null)
      {
        paramString.setData(Uri.parse(str));
        try
        {
          paramWebView.getContext().startActivity(paramString);
          return true;
        }
        catch (Exception paramString)
        {
          paramWebView.loadUrl("http://mdc.html5.qq.com/mh?channel_id=50079&u=");
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean b(WebView paramWebView, String paramString)
  {
    return (paramWebView == null) || (TextUtils.isEmpty(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mtt.spcialcall.sdk.MttApi
 * JD-Core Version:    0.7.0.1
 */