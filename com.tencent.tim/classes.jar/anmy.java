import com.tencent.mobileqq.dinifly.IDiniFlyQLog;
import com.tencent.qphone.base.util.QLog;

public final class anmy
  implements IDiniFlyQLog
{
  public void trace(int paramInt1, String paramString1, int paramInt2, String paramString2, Throwable paramThrowable)
  {
    if ((1 == paramInt2) || (QLog.isColorLevel())) {}
    switch (paramInt1)
    {
    case 4: 
    default: 
      QLog.i(paramString1, paramInt2, paramString2, null);
      return;
    case 5: 
      QLog.w(paramString1, paramInt2, paramString2, null);
      return;
    case 6: 
      QLog.e(paramString1, paramInt2, paramString2, null);
      return;
    }
    QLog.d(paramString1, paramInt2, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmy
 * JD-Core Version:    0.7.0.1
 */