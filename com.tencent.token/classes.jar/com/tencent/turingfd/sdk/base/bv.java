package com.tencent.turingfd.sdk.base;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class bv
{
  public static bx a = new bx();
  
  public static String a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Throwable))
    {
      Object localObject = (Throwable)paramObject;
      StringWriter localStringWriter = new StringWriter();
      paramObject = new PrintWriter(localStringWriter);
      ((Throwable)localObject).printStackTrace(paramObject);
      paramObject.flush();
      localObject = localStringWriter.toString();
      paramObject.close();
      return localObject;
    }
    return paramObject.toString();
  }
  
  public static void a(String paramString, Object paramObject)
  {
    a.a(6, paramString, a(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bv
 * JD-Core Version:    0.7.0.1
 */