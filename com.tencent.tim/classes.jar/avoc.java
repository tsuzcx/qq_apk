import com.tencent.qphone.base.util.QLog;

public final class avoc
{
  public static void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadingCenter-" + paramString1, 2, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    QLog.e("ReadingCenter-" + paramString1, 1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e("ReadingCenter-" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadingCenter-" + paramString1, 2, paramString2);
    }
  }
  
  public static void m(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i("ReadingCenter-" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public static void u(String paramString1, String paramString2)
  {
    QLog.i("ReadingCenter-" + paramString1, 1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    QLog.w("ReadingCenter-" + paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avoc
 * JD-Core Version:    0.7.0.1
 */