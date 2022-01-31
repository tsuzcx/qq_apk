package com.tencent.feedback.common;

import android.util.Log;
import java.util.Locale;

public final class e
{
  public static boolean a = false;
  public static boolean b = false;
  
  private static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i != 0)
      {
        if (paramString2 != null) {
          break label33;
        }
        str = "null";
      }
    }
    for (;;)
    {
      Log.d(paramString1, str);
      return;
      i = 0;
      break;
      label33:
      str = paramString2;
      if (paramVarArgs != null)
      {
        str = paramString2;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString2, paramVarArgs);
        }
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i != 0)
      {
        if (paramString != null) {
          break label32;
        }
        str = "null";
      }
    }
    for (;;)
    {
      Log.i("eup", str);
      return;
      i = 0;
      break;
      label32:
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i != 0)
      {
        if (paramString != null) {
          break label32;
        }
        str = "null";
      }
    }
    for (;;)
    {
      Log.d("eup", str);
      return;
      i = 0;
      break;
      label32:
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i != 0)
      {
        if (paramString != null) {
          break label32;
        }
        str = "null";
      }
    }
    for (;;)
    {
      Log.w("eup", str);
      return;
      i = 0;
      break;
      label32:
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    int i;
    String str;
    if (a)
    {
      i = 1;
      if (i == 0) {
        return;
      }
      if (paramString != null) {
        break label58;
      }
      str = "null";
    }
    for (;;)
    {
      Log.e("eup", str);
      if (!b) {
        return;
      }
      throw new RuntimeException(String.format("RQD ERROR CHECK:\n %s \n this error will throw only Constants.Is_AutoCheckOpen == true!\n this throw is for found error early!", new Object[] { str }));
      i = 0;
      break;
      label58:
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length != 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    a("eup_step_api", paramString, paramVarArgs);
  }
  
  public static void f(String paramString, Object... paramVarArgs)
  {
    a("eup_step_buffer", paramString, paramVarArgs);
  }
  
  public static void g(String paramString, Object... paramVarArgs)
  {
    a("eup_step_db", paramString, paramVarArgs);
  }
  
  public static void h(String paramString, Object... paramVarArgs)
  {
    a("eup_step_upload", paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.common.e
 * JD-Core Version:    0.7.0.1
 */