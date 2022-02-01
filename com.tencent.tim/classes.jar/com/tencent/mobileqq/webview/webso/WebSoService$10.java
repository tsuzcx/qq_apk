package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import arcx;
import arcy;
import ardk;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

final class WebSoService$10
  implements Runnable
{
  WebSoService$10(arcx paramarcx, Uri paramUri, String paramString1, String paramString2, WebSoService.WebSoState paramWebSoState) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Arcx != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Arcx.entity_body != null)
      {
        ardk.i(this.jdField_a_of_type_Arcx.entity_body.getBytes(), ardk.h(this.d));
        localObject1 = arcy.getSHA1(this.jdField_a_of_type_Arcx.entity_body);
      }
    }
    if ((!TextUtils.isEmpty(this.czR)) && (this.d != null))
    {
      localObject2 = WebSoService.access$200().edit();
      String str1 = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      String str2 = ardk.g(this.d);
      ((SharedPreferences.Editor)localObject2).putString("eTag_" + str1 + str2, this.czR);
      ((SharedPreferences.Editor)localObject2).putString("pageVersion_" + str1 + str2, this.czS);
      ((SharedPreferences.Editor)localObject2).putString("htmlSha1_" + str1 + str2, (String)localObject1);
      if (Build.VERSION.SDK_INT >= 9) {
        break label254;
      }
      ((SharedPreferences.Editor)localObject2).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a.eeE = ((int)(System.currentTimeMillis() - l));
      return;
      label254:
      ((SharedPreferences.Editor)localObject2).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.10
 * JD-Core Version:    0.7.0.1
 */