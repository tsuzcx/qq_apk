import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;

public class cjt
  implements MessageQueue.IdleHandler
{
  public cjt(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    new cju(this.a).execute(new Void[0]);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjt
 * JD-Core Version:    0.7.0.1
 */