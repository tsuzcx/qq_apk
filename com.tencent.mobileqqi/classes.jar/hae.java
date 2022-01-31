import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class hae
  extends Thread
{
  private boolean a = true;
  
  public void a()
  {
    this.a = false;
  }
  
  public void run()
  {
    setName("FaceDecodeThread" + getId());
    Object localObject1 = null;
    while (this.a) {
      synchronized (FaceDecodeTask.a())
      {
        int i = FaceDecodeTask.a().size();
        if (i == 0) {}
        try
        {
          FaceDecodeTask.a().wait();
          localObject3 = localObject1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            Object localObject3;
            Object localObject4 = localObject2;
          }
        }
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          FaceDecodeTask.b((FaceDecodeTask)localObject3);
          localObject1 = null;
          continue;
          localObject3 = (FaceDecodeTask)FaceDecodeTask.a().remove(0);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecodeTask", 2, "FaceDecodeThread thread exit. isRunning=" + this.a + ", id=" + getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hae
 * JD-Core Version:    0.7.0.1
 */