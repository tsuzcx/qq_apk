package com.tencent.open.base;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class LogUtility
{
  protected static final int a = 0;
  public static final String a = "opensdk";
  protected static boolean a = true;
  protected static final int b = 1;
  protected static String b = "";
  protected static final int c = 2;
  protected static final int d = 3;
  protected static final int e = 4;
  protected static final int f = 0;
  
  static
  {
    b += ".*[S|s][I|i][D|d].*";
    b += "|.*==.*";
    b += "|.*[U|u][I|i][N|n].*";
    b += "|.*%3d%3d.*";
    b += "|.*[V|v][K|k][E|e][Y|y]";
  }
  
  protected static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((!a) || (TextUtils.isEmpty(paramString2)) || (paramString2.matches(b))) {}
    label278:
    for (;;)
    {
      return;
      if (paramInt == 1)
      {
        if (paramThrowable == null) {
          QLog.i(paramString1, 2, "" + "::" + paramString2);
        }
      }
      else
      {
        if ((paramInt == 2) || (paramInt == 0))
        {
          if (paramThrowable != null) {
            break label214;
          }
          QLog.d(paramString1, 2, "" + "::" + paramString2);
        }
        label104:
        if (paramInt == 3)
        {
          if (paramThrowable != null) {
            break label247;
          }
          QLog.w(paramString1, 2, "" + "::" + paramString2);
        }
      }
      for (;;)
      {
        if (paramInt != 4) {
          break label278;
        }
        if (paramThrowable != null) {
          break label280;
        }
        QLog.e(paramString1, 2, "" + "::" + paramString2);
        return;
        QLog.i(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break;
        label214:
        QLog.d(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break label104;
        label247:
        QLog.w(paramString1, 2, "" + "::" + paramString2, paramThrowable);
      }
    }
    label280:
    QLog.e(paramString1, 2, "" + "::" + paramString2, paramThrowable);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(0, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(1, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.LogUtility
 * JD-Core Version:    0.7.0.1
 */