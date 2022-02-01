package com.tencent.token;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class afr
{
  public static afs a = new afs();
  
  public static String a(Object paramObject)
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
  
  public static void a(Object paramObject, Throwable paramThrowable)
  {
    paramObject = a(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject);
    localStringBuilder.append('\n');
    localStringBuilder.append(a(paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afr
 * JD-Core Version:    0.7.0.1
 */