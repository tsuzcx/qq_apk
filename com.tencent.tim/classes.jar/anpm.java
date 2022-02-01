import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.qphone.base.util.QLog;

final class anpm
  implements BeaconLogger
{
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void printStackTrace(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TIMBeaconReport", 2, "beacon t", paramThrowable);
    }
  }
  
  public void v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpm
 * JD-Core Version:    0.7.0.1
 */