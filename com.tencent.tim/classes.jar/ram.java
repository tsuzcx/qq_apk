import com.tencent.qphone.base.util.QLog;

public class ram
{
  private static rak a = ;
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (a.isLoggable(3)) {
      a.d(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (a.isLoggable(3)) {
      a.d(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(3)) {
      d(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void a(rak paramrak)
  {
    if (paramrak == null) {
      throw new IllegalArgumentException();
    }
    a = paramrak;
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject)
  {
    if (a.isLoggable(3)) {
      a.d(paramString1, formatString(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (a.isLoggable(3)) {
      a.d(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (a.isLoggable(4)) {
      a.i(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 }));
    }
  }
  
  public static void b(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (a.isLoggable(4)) {
      a.i(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
    }
  }
  
  public static void b(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(4)) {
      a.i(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void c(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(5)) {
      a.w(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a.isLoggable(3)) {
      a.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject)
  {
    if (a.isLoggable(4)) {
      a.i(paramString1, formatString(paramString2, new Object[] { paramObject }));
    }
  }
  
  public static void d(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (a.isLoggable(4)) {
      a.i(paramString1, formatString(paramString2, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.isLoggable(3)) {
      a.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(3)) {
      d(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(6)) {
      a.e(paramString1, formatString(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a.isLoggable(6)) {
      a.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.isLoggable(6)) {
      a.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(6)) {
      a.e(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  private static String formatString(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (a.isLoggable(4)) {
      a.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(4)) {
      a.i(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (a.isLoggable(2)) {
      a.v(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(2)) {
      a.v(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (a.isLoggable(5)) {
      a.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a.isLoggable(5)) {
      a.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a.isLoggable(5)) {
      a.w(paramString1, formatString(paramString2, paramVarArgs));
    }
  }
  
  public static void wtf(String paramString1, String paramString2)
  {
    if (a.isLoggable(6)) {
      a.e(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ram
 * JD-Core Version:    0.7.0.1
 */