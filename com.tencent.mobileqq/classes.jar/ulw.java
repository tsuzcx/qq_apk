import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ulw
  extends Handler
{
  ulw(ulv paramulv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ulv.a(this.a, ulv.a(this.a) + 500L);
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "start record playDurationTime:  " + ulv.a(this.a));
    this.a.a();
    ulv.a(this.a, ulv.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulw
 * JD-Core Version:    0.7.0.1
 */