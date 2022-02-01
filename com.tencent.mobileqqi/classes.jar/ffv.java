import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ffv
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ffv(ffs paramffs, int paramInt)
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
      if (((j < ffs.a(this.jdField_a_of_type_Ffs)) || (ffs.a(this.jdField_a_of_type_Ffs).size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (ffs.a(this.jdField_a_of_type_Ffs))
        {
          i = ffs.a(this.jdField_a_of_type_Ffs).size();
          if (i == 0) {
            ffs.b(this.jdField_a_of_type_Ffs);
          }
        }
      }
      try
      {
        ffs.a(this.jdField_a_of_type_Ffs).wait(30000L);
        ffs.c(this.jdField_a_of_type_Ffs);
        i = j + 1;
        ffu localffu = null;
        j = i;
        if (localffu == null) {
          continue;
        }
        ffs.a(this.jdField_a_of_type_Ffs, localffu);
        yield();
        j = i;
        continue;
        if (i > ffs.d(this.jdField_a_of_type_Ffs))
        {
          localffu = (ffu)ffs.a(this.jdField_a_of_type_Ffs).remove(i - 1);
        }
        else
        {
          localffu = (ffu)ffs.a(this.jdField_a_of_type_Ffs).remove(0);
          break label310;
          localObject = finally;
          throw localObject;
          if (QLog.isColorLevel()) {
            QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_Boolean) && (ffs.a(this.jdField_a_of_type_Ffs) != null) && (this.jdField_a_of_type_Int < ffs.a(this.jdField_a_of_type_Ffs).length)) {
            ffs.a(this.jdField_a_of_type_Ffs)[this.jdField_a_of_type_Int] = null;
          }
          ffs.e(this.jdField_a_of_type_Ffs);
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
 * Qualified Name:     ffv
 * JD-Core Version:    0.7.0.1
 */