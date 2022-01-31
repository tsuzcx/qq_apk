package com.tencent.tmassistantsdk.f;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public final class i
{
  private static String b = "NA";
  private Context a = null;
  
  public i(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static StringBuffer a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if ((paramString[i] > ' ') && (paramString[i] != '/') && (paramString[i] != '_') && (paramString[i] != '&') && (paramString[i] != '|') && (paramString[i] != '-')) {
        localStringBuffer.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuffer;
  }
  
  public final String a()
  {
    h localh = new h();
    Object localObject;
    String str;
    if ("100".contains("BuildNo"))
    {
      localObject = "0000";
      localh.c = ((String)localObject);
      localh.d = "";
      localh.e = b;
      localObject = new StringBuffer();
      str = Build.VERSION.RELEASE;
      if (!TextUtils.isEmpty(str)) {
        break label189;
      }
      ((StringBuffer)localObject).append("NA");
    }
    for (;;)
    {
      ((StringBuffer)localObject).append("_");
      ((StringBuffer)localObject).append(Build.VERSION.SDK_INT);
      localh.f = ((StringBuffer)localObject).toString();
      localh.h = this.a.getResources().getDisplayMetrics().heightPixels;
      localh.g = this.a.getResources().getDisplayMetrics().widthPixels;
      localh.i = 0;
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(a(Build.BRAND));
      ((StringBuffer)localObject).append("_");
      ((StringBuffer)localObject).append(a(Build.MODEL));
      localh.a = ((StringBuffer)localObject).toString();
      localh.b = "100";
      return localh.a();
      localObject = "100";
      break;
      label189:
      ((StringBuffer)localObject).append(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.i
 * JD-Core Version:    0.7.0.1
 */