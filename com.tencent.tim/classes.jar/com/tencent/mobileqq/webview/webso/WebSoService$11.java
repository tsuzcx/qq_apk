package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import arcy;
import ardk;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

final class WebSoService$11
  implements Runnable
{
  WebSoService$11(String paramString1, Uri paramUri, String paramString2, String paramString3) {}
  
  public void run()
  {
    System.currentTimeMillis();
    String str1 = "";
    if (this.czT != null)
    {
      ardk.i(this.czT.getBytes(), ardk.h(this.d));
      str1 = arcy.getSHA1(this.czT);
    }
    SharedPreferences.Editor localEditor;
    if ((!TextUtils.isEmpty(this.czR)) && (this.d != null))
    {
      localEditor = WebSoService.access$200().edit();
      String str2 = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      String str3 = ardk.g(this.d);
      localEditor.putString("eTag_" + str2 + str3, this.czR);
      localEditor.putString("pageVersion_" + str2 + str3, this.czS);
      localEditor.putString("htmlSha1_" + str2 + str3, str1);
      if (Build.VERSION.SDK_INT < 9) {
        localEditor.commit();
      }
    }
    else
    {
      return;
    }
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.11
 * JD-Core Version:    0.7.0.1
 */