import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;

public class cjn
  implements MessageQueue.IdleHandler
{
  public cjn(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    new cjo(this.a).execute(new Void[0]);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjn
 * JD-Core Version:    0.7.0.1
 */