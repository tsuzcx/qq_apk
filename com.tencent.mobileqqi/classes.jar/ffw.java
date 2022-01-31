import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ffw
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ffw(fft paramfft, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    setName("QQHeadDownloadThread" + this.jdField_a_of_type_Int);
    Process.setThreadPriority(10);
    int j = 0;
    for (;;)
    {
      int i;
      if (((j < fft.a(this.jdField_a_of_type_Fft)) || (fft.a(this.jdField_a_of_type_Fft).size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (fft.a(this.jdField_a_of_type_Fft))
        {
          i = fft.a(this.jdField_a_of_type_Fft).size();
          if (i == 0) {
            fft.b(this.jdField_a_of_type_Fft);
          }
        }
      }
      try
      {
        fft.a(this.jdField_a_of_type_Fft).wait(30000L);
        fft.c(this.jdField_a_of_type_Fft);
        i = j + 1;
        ffv localffv = null;
        j = i;
        if (localffv == null) {
          continue;
        }
        fft.a(this.jdField_a_of_type_Fft, localffv);
        yield();
        j = i;
        continue;
        if (i > fft.d(this.jdField_a_of_type_Fft))
        {
          localffv = (ffv)fft.a(this.jdField_a_of_type_Fft).remove(i - 1);
        }
        else
        {
          localffv = (ffv)fft.a(this.jdField_a_of_type_Fft).remove(0);
          break label310;
          localObject = finally;
          throw localObject;
          if (QLog.isColorLevel()) {
            QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_Boolean) && (fft.a(this.jdField_a_of_type_Fft) != null) && (this.jdField_a_of_type_Int < fft.a(this.jdField_a_of_type_Fft).length)) {
            fft.a(this.jdField_a_of_type_Fft)[this.jdField_a_of_type_Int] = null;
          }
          fft.e(this.jdField_a_of_type_Fft);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          continue;
          label310:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffw
 * JD-Core Version:    0.7.0.1
 */