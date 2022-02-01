package com.tencent.tbs.one.impl.common;

import com.tencent.tbs.one.impl.a.f;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  public static a a;
  
  public static void a(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("DESCRIPTION", paramString);
    a("TBSOneAction", paramInt, localHashMap);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, Throwable paramThrowable)
  {
    f.a("Reporting error: [%d] %s", new Object[] { Integer.valueOf(paramInt3), paramString2, paramThrowable });
    HashMap localHashMap = new HashMap();
    localHashMap.put("DEPS_VERSION_CODE", Integer.valueOf(paramInt1));
    localHashMap.put("COMPONENT_NAME", paramString1);
    localHashMap.put("COMPONENT_VERSION_CODE", Integer.valueOf(paramInt2));
    localHashMap.put("DESCRIPTION", paramString2);
    localHashMap.put("THROWABLE", paramThrowable);
    a("TBSOneError", paramInt3, localHashMap);
  }
  
  public static void a(String paramString, int paramInt, Map paramMap)
  {
    if (a != null) {
      a.a(paramString, paramInt, paramMap);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("DESCRIPTION", paramString);
    localHashMap.put("THROWABLE", paramThrowable);
    a("TBSOneError", 510, localHashMap);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, Map paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.h
 * JD-Core Version:    0.7.0.1
 */