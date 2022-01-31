import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class cvo
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public cvo(cvl paramcvl, int paramInt)
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
      if (((j < cvl.a(this.jdField_a_of_type_Cvl)) || (cvl.a(this.jdField_a_of_type_Cvl).size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (cvl.a(this.jdField_a_of_type_Cvl))
        {
          i = cvl.a(this.jdField_a_of_type_Cvl).size();
          if (i == 0) {
            cvl.b(this.jdField_a_of_type_Cvl);
          }
        }
      }
      try
      {
        cvl.a(this.jdField_a_of_type_Cvl).wait(30000L);
        cvl.c(this.jdField_a_of_type_Cvl);
        i = j + 1;
        cvn localcvn = null;
        j = i;
        if (localcvn == null) {
          continue;
        }
        cvl.a(this.jdField_a_of_type_Cvl, localcvn);
        yield();
        j = i;
        continue;
        if (i > cvl.d(this.jdField_a_of_type_Cvl))
        {
          localcvn = (cvn)cvl.a(this.jdField_a_of_type_Cvl).remove(i - 1);
        }
        else
        {
          localcvn = (cvn)cvl.a(this.jdField_a_of_type_Cvl).remove(0);
          break label310;
          localObject = finally;
          throw localObject;
          if (QLog.isColorLevel()) {
            QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_Boolean) && (cvl.a(this.jdField_a_of_type_Cvl) != null) && (this.jdField_a_of_type_Int < cvl.a(this.jdField_a_of_type_Cvl).length)) {
            cvl.a(this.jdField_a_of_type_Cvl)[this.jdField_a_of_type_Int] = null;
          }
          cvl.e(this.jdField_a_of_type_Cvl);
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
 * Qualified Name:     cvo
 * JD-Core Version:    0.7.0.1
 */