package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final a a = new a();
  private final Map<String, BusResponseCallback> b = new HashMap();
  
  public static a a()
  {
    return a;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.b)
    {
      this.b.remove(paramString);
      return;
    }
  }
  
  public void a(String paramString, BusResponseCallback paramBusResponseCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBusResponseCallback == null)) {
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.containsKey(paramString)) {
        this.b.put(paramString, paramBusResponseCallback);
      }
      return;
    }
  }
  
  public BusResponseCallback b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.b)
    {
      paramString = (BusResponseCallback)this.b.get(paramString);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.activity.internal.a
 * JD-Core Version:    0.7.0.1
 */