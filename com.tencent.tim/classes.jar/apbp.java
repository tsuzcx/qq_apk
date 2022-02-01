import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class apbp
  extends Handler
{
  apbp(apbo paramapbo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return;
          this.this$0.mItems = ((List)paramMessage.obj);
          this.this$0.Wz(1000);
          return;
          this.this$0.mItems = ((List)paramMessage.obj);
          apbo.a(this.this$0);
          this.this$0.notifyObservers(Integer.valueOf(101));
        } while (!QLog.isColorLevel());
        QLog.d("TroopFeedsDataManager", 2, "end load feed: " + System.currentTimeMillis());
        return;
        this.this$0.mItems = ((List)paramMessage.obj);
        apbo.b(this.this$0);
        this.this$0.notifyObservers(Integer.valueOf(105));
      } while (!QLog.isColorLevel());
      QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "end auto pull down feed");
      return;
    case 5: 
      apbo.c(this.this$0);
      this.this$0.notifyObservers(Integer.valueOf(1010));
      return;
    }
    apbo.d(this.this$0);
    this.this$0.notifyObservers(Integer.valueOf(103));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbp
 * JD-Core Version:    0.7.0.1
 */