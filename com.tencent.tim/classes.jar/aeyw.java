public class aeyw
{
  public static final int LOG_LEVEL;
  private static final StringBuilder P;
  private static aexw.a b;
  
  static
  {
    if (aewr.a().a().isDebug()) {}
    for (int i = 4;; i = 3)
    {
      LOG_LEVEL = i;
      P = new StringBuilder();
      return;
    }
  }
  
  public static void a(aexw.a parama)
  {
    b = parama;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((LOG_LEVEL >= 4) && (b != null)) {
      b.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    if ((LOG_LEVEL >= 4) && (b != null))
    {
      P.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        P.append(localObject);
        i += 1;
      }
      b.d(paramString, P.toString());
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if ((LOG_LEVEL >= 1) && (b != null)) {
      b.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((LOG_LEVEL >= 1) && (b != null)) {
      b.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    if ((LOG_LEVEL >= 1) && (b != null))
    {
      P.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        P.append(localObject);
        i += 1;
      }
      b.e(paramString, P.toString());
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if ((LOG_LEVEL >= 3) && (b != null)) {
      b.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    if ((LOG_LEVEL >= 3) && (b != null))
    {
      P.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        P.append(localObject);
        i += 1;
      }
      b.i(paramString, P.toString());
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if ((LOG_LEVEL >= 5) && (b != null)) {
      b.v(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    if ((LOG_LEVEL >= 5) && (b != null))
    {
      P.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        P.append(localObject);
        i += 1;
      }
      b.v(paramString, P.toString());
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if ((LOG_LEVEL >= 2) && (b != null)) {
      b.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyw
 * JD-Core Version:    0.7.0.1
 */