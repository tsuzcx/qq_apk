package com.tencent.feedback.common;

import com.tencent.feedback.proguard.a;
import java.util.Locale;

public final class e
{
  private static e.a a = null;
  
  private static e.a a()
  {
    try
    {
      e.a locala = a;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(e.a parama)
  {
    try
    {
      a = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private static boolean a(int paramInt, String paramString, Object... paramVarArgs)
  {
    e.a locala = a();
    if (locala == null) {
      return false;
    }
    String str;
    if (paramString == null) {
      str = "null";
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 0: 
        locala.a(str);
        return true;
        str = paramString;
        if (paramVarArgs != null)
        {
          str = paramString;
          if (paramVarArgs.length != 0) {
            str = String.format(Locale.US, paramString, paramVarArgs);
          }
        }
        break;
      }
    }
    locala.b(str);
    return true;
    locala.c(str);
    return true;
    locala.d(str);
    return true;
  }
  
  private static boolean a(int paramInt, Throwable paramThrowable)
  {
    e.a locala = a();
    if (locala == null) {
      return false;
    }
    paramThrowable = a.a(paramThrowable);
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      locala.a(paramThrowable);
      return true;
    case 1: 
      locala.b(paramThrowable);
      return true;
    case 2: 
      locala.c(paramThrowable);
      return true;
    }
    locala.d(paramThrowable);
    return true;
  }
  
  public static boolean a(String paramString, Object... paramVarArgs)
  {
    return a(0, paramString, paramVarArgs);
  }
  
  public static boolean a(Throwable paramThrowable)
  {
    return a(2, paramThrowable);
  }
  
  public static boolean b(String paramString, Object... paramVarArgs)
  {
    return a(1, paramString, paramVarArgs);
  }
  
  public static boolean b(Throwable paramThrowable)
  {
    return a(3, paramThrowable);
  }
  
  public static boolean c(String paramString, Object... paramVarArgs)
  {
    return a(2, paramString, paramVarArgs);
  }
  
  public static boolean d(String paramString, Object... paramVarArgs)
  {
    return a(3, paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.e
 * JD-Core Version:    0.7.0.1
 */