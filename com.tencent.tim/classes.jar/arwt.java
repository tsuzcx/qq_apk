import com.tencent.qphone.base.util.QLog;

public class arwt
{
  protected static boolean ddq = true;
  protected static String regex = "";
  
  static
  {
    regex += ".*[S|s][I|i][D|d].*";
    regex += "|.*==.*";
    regex += "|.*[U|u][I|i][N|n].*";
    regex += "|.*%3d%3d.*";
    regex += "|.*[V|v][K|k][E|e][Y|y]";
  }
  
  public static boolean aHh()
  {
    return ddq;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    log(2, paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(2, paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(4, paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    log(1, paramString1, paramString2, null);
  }
  
  protected static void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (ddq) {
      if (paramInt == 1)
      {
        if (paramThrowable != null) {
          break label187;
        }
        if (QLog.isColorLevel()) {
          QLog.i(paramString1, 2, "" + "::" + paramString2);
        }
      }
    }
    label98:
    do
    {
      break label186;
      if ((paramInt == 2) || (paramInt == 0))
      {
        if (paramThrowable != null) {
          break label226;
        }
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "" + "::" + paramString2);
        }
      }
      if (paramInt == 3)
      {
        if (paramThrowable != null) {
          break label265;
        }
        if (QLog.isColorLevel()) {
          QLog.w(paramString1, 2, "" + "::" + paramString2);
        }
      }
      for (;;)
      {
        if (paramInt == 4)
        {
          if (paramThrowable != null) {
            break label304;
          }
          if (QLog.isColorLevel()) {
            QLog.e(paramString1, 2, "" + "::" + paramString2);
          }
        }
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break;
        if (!QLog.isColorLevel()) {
          break label98;
        }
        QLog.d(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break label98;
        if (QLog.isColorLevel()) {
          QLog.w(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        }
      }
    } while (!QLog.isColorLevel());
    label186:
    label187:
    label226:
    QLog.e(paramString1, 2, "" + "::" + paramString2, paramThrowable);
    label265:
    label304:
    return;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    log(0, paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(3, paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(3, paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwt
 * JD-Core Version:    0.7.0.1
 */