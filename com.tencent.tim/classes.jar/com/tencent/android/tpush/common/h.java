package com.tencent.android.tpush.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.d.a;

public class h
{
  private static volatile h a = null;
  private boolean b = false;
  private boolean c = false;
  private int d = -1;
  
  private h(Context paramContext)
  {
    this.c = a.a(paramContext);
  }
  
  public static h a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new h(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    if (this.d == -1)
    {
      String str = Build.MANUFACTURER;
      if (!TextUtils.isEmpty(str))
      {
        str = str.trim().toLowerCase();
        if ((!"meizu".equals(str)) && (!"oppo".equals(str)) && (!"xiaomi".equals(str)) && (!"vivo".equals(str)) && (!"huawei".equals(str)) && (!this.b)) {
          break label94;
        }
      }
    }
    label94:
    for (this.d = 1; this.d == 1; this.d = 0) {
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.h
 * JD-Core Version:    0.7.0.1
 */