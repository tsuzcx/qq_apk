package com.tencent.feedback.common;

import android.util.Log;
import com.tencent.feedback.proguard.a;
import java.util.Locale;

public final class e
{
  private static a a;
  
  private static a a()
  {
    try
    {
      a locala = a;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(a parama)
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
    a locala = a();
    if (locala == null) {
      return false;
    }
    String str;
    if (paramString == null)
    {
      str = "null";
    }
    else
    {
      str = paramString;
      if (paramVarArgs != null) {
        if (paramVarArgs.length == 0) {
          str = paramString;
        } else {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 3: 
      locala.d(str);
      return true;
    case 2: 
      locala.c(str);
      return true;
    case 1: 
      locala.b(str);
      return true;
    }
    locala.a(str);
    return true;
  }
  
  private static boolean a(int paramInt, Throwable paramThrowable)
  {
    a locala = a();
    if (locala == null) {
      return false;
    }
    paramThrowable = a.a(paramThrowable);
    switch (paramInt)
    {
    default: 
      return false;
    case 3: 
      locala.d(paramThrowable);
      return true;
    case 2: 
      locala.c(paramThrowable);
      return true;
    case 1: 
      locala.b(paramThrowable);
      return true;
    }
    locala.a(paramThrowable);
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
  
  public static class a
  {
    public void a(String paramString)
    {
      Log.i("eup", paramString);
    }
    
    public void b(String paramString)
    {
      Log.d("eup", paramString);
    }
    
    public void c(String paramString)
    {
      Log.w("eup", paramString);
    }
    
    public void d(String paramString)
    {
      Log.e("eup", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.e
 * JD-Core Version:    0.7.0.1
 */