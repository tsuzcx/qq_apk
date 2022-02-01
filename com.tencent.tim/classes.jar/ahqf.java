import com.tencent.qphone.base.util.QLog;

public class ahqf
  implements ahqd
{
  public void b(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ("i".equals(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.i(paramString1, 2, paramString3, paramThrowable);
      }
    }
    do
    {
      do
      {
        return;
        if (!"d".equals(paramString2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(paramString1, 2, paramString3, paramThrowable);
      return;
      if ("w".equals(paramString2))
      {
        QLog.w(paramString1, 2, paramString3, paramThrowable);
        return;
      }
      if ("e".equals(paramString2))
      {
        QLog.e(paramString1, 2, paramString3, paramThrowable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(paramString1, 2, paramString3, paramThrowable);
  }
  
  public void log(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1, paramString2, paramString3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqf
 * JD-Core Version:    0.7.0.1
 */