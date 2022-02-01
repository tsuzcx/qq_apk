import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.ThreadRegulator.a;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acmr
  extends MqqHandler
{
  public acmr(ThreadRegulator paramThreadRegulator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (ThreadRegulator.a)paramMessage.obj;
    if (paramMessage != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadManager.Regulaotr", 2, paramMessage.type + " cost " + (paramMessage.endTime - paramMessage.startTime) + ", paused " + paramMessage.el);
      }
      paramMessage.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acmr
 * JD-Core Version:    0.7.0.1
 */