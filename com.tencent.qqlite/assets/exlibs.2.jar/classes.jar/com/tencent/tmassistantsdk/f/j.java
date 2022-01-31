package com.tencent.tmassistantsdk.f;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public final class j
{
  private static String b = "NA";
  private Context a = null;
  
  public j(Context paramContext)
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
    i locali = new i();
    Object localObject;
    String str;
    if ("100".contains("BuildNo"))
    {
      localObject = "0000";
      locali.c = ((String)localObject);
      locali.d = "";
      locali.e = b;
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
      locali.f = ((StringBuffer)localObject).toString();
      locali.h = this.a.getResources().getDisplayMetrics().heightPixels;
      locali.g = this.a.getResources().getDisplayMetrics().widthPixels;
      locali.i = 0;
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(a(Build.BRAND));
      ((StringBuffer)localObject).append("_");
      ((StringBuffer)localObject).append(a(Build.MODEL));
      locali.a = ((StringBuffer)localObject).toString();
      locali.b = "100";
      return locali.a();
      localObject = "100";
      break;
      label189:
      ((StringBuffer)localObject).append(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.j
 * JD-Core Version:    0.7.0.1
 */