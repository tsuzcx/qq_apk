package com.tencent.token;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class aei
{
  public static aek a = new aek();
  
  public static void a(Object paramObject)
  {
    b(paramObject);
  }
  
  public static String b(Object paramObject)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aei
 * JD-Core Version:    0.7.0.1
 */