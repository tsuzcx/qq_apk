import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class cvi
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  
  public cvi(cvf paramcvf, int paramInt)
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
      if (((j < cvf.a(this.jdField_a_of_type_Cvf)) || (cvf.a(this.jdField_a_of_type_Cvf).size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (cvf.a(this.jdField_a_of_type_Cvf))
        {
          i = cvf.a(this.jdField_a_of_type_Cvf).size();
          if (i == 0) {
            cvf.b(this.jdField_a_of_type_Cvf);
          }
        }
      }
      try
      {
        cvf.a(this.jdField_a_of_type_Cvf).wait(30000L);
        cvf.c(this.jdField_a_of_type_Cvf);
        i = j + 1;
        cvh localcvh = null;
        j = i;
        if (localcvh == null) {
          continue;
        }
        cvf.a(this.jdField_a_of_type_Cvf, localcvh);
        yield();
        j = i;
        continue;
        if (i > cvf.d(this.jdField_a_of_type_Cvf))
        {
          localcvh = (cvh)cvf.a(this.jdField_a_of_type_Cvf).remove(i - 1);
        }
        else
        {
          localcvh = (cvh)cvf.a(this.jdField_a_of_type_Cvf).remove(0);
          break label310;
          localObject = finally;
          throw localObject;
          if (QLog.isColorLevel()) {
            QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_Boolean) && (cvf.a(this.jdField_a_of_type_Cvf) != null) && (this.jdField_a_of_type_Int < cvf.a(this.jdField_a_of_type_Cvf).length)) {
            cvf.a(this.jdField_a_of_type_Cvf)[this.jdField_a_of_type_Int] = null;
          }
          cvf.e(this.jdField_a_of_type_Cvf);
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
 * Qualified Name:     cvi
 * JD-Core Version:    0.7.0.1
 */