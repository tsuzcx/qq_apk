package com.tencent.apkupdate.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

public final class e
{
  private static String b = "NA";
  private Context a = null;
  
  public e(Context paramContext)
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
    d locald = new d();
    Object localObject;
    String str;
    if ("100".contains("BuildNo"))
    {
      localObject = "0000";
      locald.c((String)localObject);
      locald.d("");
      locald.e(b);
      localObject = new StringBuffer();
      str = Build.VERSION.RELEASE;
      if (!TextUtils.isEmpty(str)) {
        break label214;
      }
      ((StringBuffer)localObject).append("NA");
    }
    for (;;)
    {
      ((StringBuffer)localObject).append("_");
      ((StringBuffer)localObject).append(Build.VERSION.SDK_INT);
      locald.f(((StringBuffer)localObject).toString());
      locald.b(this.a.getResources().getDisplayMetrics().heightPixels);
      locald.a(this.a.getResources().getDisplayMetrics().widthPixels);
      locald.c(0);
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(a(Build.BRAND));
      ((StringBuffer)localObject).append("_");
      ((StringBuffer)localObject).append(a(Build.MODEL));
      locald.a(((StringBuffer)localObject).toString());
      locald.b("100");
      Log.i("vivianliao", " qua :" + locald.a());
      return locald.a();
      localObject = "100";
      break;
      label214:
      ((StringBuffer)localObject).append(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.c.e
 * JD-Core Version:    0.7.0.1
 */