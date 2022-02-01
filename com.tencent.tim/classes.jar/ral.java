import com.tencent.qphone.base.util.QLog;

public class ral
  implements rak
{
  public static final ral a = new ral();
  public int bpm = 3;
  private int bpn = -1;
  
  public static ral a()
  {
    return a;
  }
  
  private void b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QLog.d(paramString1, 2, paramString2, paramThrowable);
      return;
    case 3: 
      QLog.d(paramString1, 2, paramString2, paramThrowable);
      return;
    case 4: 
      QLog.i(paramString1, 2, paramString2, paramThrowable);
      return;
    case 5: 
      QLog.e(paramString1, 1, paramString2, paramThrowable);
      return;
    }
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  private void println(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 3: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 4: 
      QLog.i(paramString1, 2, paramString2);
      return;
    case 5: 
      QLog.e(paramString1, 1, paramString2);
      return;
    }
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void d(String paramString1, String paramString2)
  {
    println(3, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(3, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    println(6, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(6, paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    println(4, paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(4, paramString1, paramString2, paramThrowable);
  }
  
  public boolean isLoggable(int paramInt)
  {
    if ((this.bpn != -1) && (paramInt >= this.bpn)) {}
    do
    {
      do
      {
        return true;
      } while (5 <= paramInt);
      if (!QLog.isColorLevel()) {
        return false;
      }
    } while (this.bpm <= paramInt);
    return false;
  }
  
  public void v(String paramString1, String paramString2)
  {
    println(2, paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    println(5, paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    b(5, paramString1, paramString2, paramThrowable);
  }
  
  public void wL(int paramInt)
  {
    this.bpn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ral
 * JD-Core Version:    0.7.0.1
 */