package com.tencent.token;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class avo
{
  private static avn a = new avp();
  
  private static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "(Null stack trace)";
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    paramThrowable = localStringWriter.toString();
    localPrintWriter.close();
    return paramThrowable;
  }
  
  public static void a(Object paramObject)
  {
    e(paramObject);
  }
  
  public static void a(Object paramObject, Throwable paramThrowable)
  {
    paramObject = e(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject);
    localStringBuilder.append('\n');
    localStringBuilder.append(a(paramThrowable));
  }
  
  public static void b(Object paramObject)
  {
    e(paramObject);
  }
  
  public static void c(Object paramObject)
  {
    e(paramObject);
  }
  
  public static void d(Object paramObject)
  {
    e(paramObject);
  }
  
  private static String e(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Throwable)) {
      return a((Throwable)paramObject);
    }
    return paramObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.avo
 * JD-Core Version:    0.7.0.1
 */