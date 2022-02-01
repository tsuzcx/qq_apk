import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class acmn
  extends MqqHandler
{
  public acmn(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("ThreadManager", 1, "global fileHandler cannot excute removeCallbacksAndMessages");
      return;
    }
    super.removeCallbacksAndMessages(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acmn
 * JD-Core Version:    0.7.0.1
 */