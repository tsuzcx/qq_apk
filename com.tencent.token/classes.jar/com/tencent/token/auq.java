package com.tencent.token;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class auq
{
  private static aup a = new aur();
  
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
    d(paramObject);
  }
  
  public static void a(Object paramObject, Throwable paramThrowable)
  {
    paramObject = d(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject);
    localStringBuilder.append('\n');
    localStringBuilder.append(a(paramThrowable));
  }
  
  public static void b(Object paramObject)
  {
    d(paramObject);
  }
  
  public static void c(Object paramObject)
  {
    d(paramObject);
  }
  
  private static String d(Object paramObject)
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
 * Qualified Name:     com.tencent.token.auq
 * JD-Core Version:    0.7.0.1
 */