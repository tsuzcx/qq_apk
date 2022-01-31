import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class cwp
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public cwp(cwm paramcwm, int paramInt)
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
      if (((j < cwm.a(this.jdField_a_of_type_Cwm)) || (cwm.a(this.jdField_a_of_type_Cwm).size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (cwm.a(this.jdField_a_of_type_Cwm))
        {
          i = cwm.a(this.jdField_a_of_type_Cwm).size();
          if (i == 0) {
            cwm.b(this.jdField_a_of_type_Cwm);
          }
        }
      }
      try
      {
        cwm.a(this.jdField_a_of_type_Cwm).wait(30000L);
        cwm.c(this.jdField_a_of_type_Cwm);
        i = j + 1;
        cwo localcwo = null;
        j = i;
        if (localcwo == null) {
          continue;
        }
        cwm.a(this.jdField_a_of_type_Cwm, localcwo);
        yield();
        j = i;
        continue;
        if (i > cwm.d(this.jdField_a_of_type_Cwm))
        {
          localcwo = (cwo)cwm.a(this.jdField_a_of_type_Cwm).remove(i - 1);
        }
        else
        {
          localcwo = (cwo)cwm.a(this.jdField_a_of_type_Cwm).remove(0);
          break label310;
          localObject = finally;
          throw localObject;
          if (QLog.isColorLevel()) {
            QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_Boolean) && (cwm.a(this.jdField_a_of_type_Cwm) != null) && (this.jdField_a_of_type_Int < cwm.a(this.jdField_a_of_type_Cwm).length)) {
            cwm.a(this.jdField_a_of_type_Cwm)[this.jdField_a_of_type_Int] = null;
          }
          cwm.e(this.jdField_a_of_type_Cwm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cwp
 * JD-Core Version:    0.7.0.1
 */