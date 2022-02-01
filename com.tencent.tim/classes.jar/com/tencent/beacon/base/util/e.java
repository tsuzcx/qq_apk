package com.tencent.beacon.base.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.c.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(Context paramContext)
  {
    if ((a.get()) && ((!b.b(paramContext, "android.permission.INTERNET")) || (!b.b(paramContext, "android.permission.ACCESS_NETWORK_STATE")))) {
      a("当前无网络相关权限！");
    }
  }
  
  public static void a(String paramString)
  {
    c.b("[strict]  " + paramString, new Object[0]);
    if (!a.get()) {
      return;
    }
    throw new IllegalStateException("[strict] " + paramString);
  }
  
  public static void a(Map paramMap)
  {
    if ((a.get()) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof String)) {
          a("Key必须为String类型!");
        }
        if (!(paramMap.get(localObject) instanceof String)) {
          a("Value必须为String类型!");
        }
      }
    }
  }
  
  public static boolean a(String paramString, Object paramObject)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    if ((paramObject instanceof String))
    {
      bool = TextUtils.isEmpty((String)paramObject);
      localStringBuilder = new StringBuilder().append(paramString).append(" ");
      if (paramObject != null) {
        break label88;
      }
    }
    label88:
    for (paramObject = "=";; paramObject = "!")
    {
      c.a(paramObject + "= null!", new Object[0]);
      if ((bool) && (a.get())) {
        break label94;
      }
      return bool;
      if (paramObject == null)
      {
        bool = true;
        break;
      }
      bool = false;
      break;
    }
    label94:
    throw new NullPointerException(paramString + " == null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.util.e
 * JD-Core Version:    0.7.0.1
 */