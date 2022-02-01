import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.ThreadManager;

public class zsx
  implements MessageQueue.IdleHandler
{
  public zsx(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    akxe.a(SendPhotoActivity.TAG, "queueIdle", "start");
    this.a.mHandler.removeMessages(3);
    this.a.a = new SendPhotoTask(this.a, null, this.a.mHandler);
    ThreadManager.post(this.a.a, 8, null, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsx
 * JD-Core Version:    0.7.0.1
 */