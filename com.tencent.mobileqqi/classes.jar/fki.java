import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class fki
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public fki(fkf paramfkf, int paramInt)
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
      if (((j < fkf.a(this.jdField_a_of_type_Fkf)) || (fkf.a(this.jdField_a_of_type_Fkf).size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (fkf.a(this.jdField_a_of_type_Fkf))
        {
          i = fkf.a(this.jdField_a_of_type_Fkf).size();
          if (i == 0) {
            fkf.b(this.jdField_a_of_type_Fkf);
          }
        }
      }
      try
      {
        fkf.a(this.jdField_a_of_type_Fkf).wait(30000L);
        fkf.c(this.jdField_a_of_type_Fkf);
        i = j + 1;
        fkh localfkh = null;
        j = i;
        if (localfkh == null) {
          continue;
        }
        fkf.a(this.jdField_a_of_type_Fkf, localfkh);
        yield();
        j = i;
        continue;
        if (i > fkf.d(this.jdField_a_of_type_Fkf))
        {
          localfkh = (fkh)fkf.a(this.jdField_a_of_type_Fkf).remove(i - 1);
        }
        else
        {
          localfkh = (fkh)fkf.a(this.jdField_a_of_type_Fkf).remove(0);
          break label310;
          localObject = finally;
          throw localObject;
          if (QLog.isColorLevel()) {
            QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_Boolean) && (fkf.a(this.jdField_a_of_type_Fkf) != null) && (this.jdField_a_of_type_Int < fkf.a(this.jdField_a_of_type_Fkf).length)) {
            fkf.a(this.jdField_a_of_type_Fkf)[this.jdField_a_of_type_Int] = null;
          }
          fkf.e(this.jdField_a_of_type_Fkf);
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
 * Qualified Name:     fki
 * JD-Core Version:    0.7.0.1
 */