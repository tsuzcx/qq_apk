import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;

public class cku
  implements MessageQueue.IdleHandler
{
  public cku(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    new ckv(this.a).execute(new Void[0]);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cku
 * JD-Core Version:    0.7.0.1
 */