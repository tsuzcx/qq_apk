import android.os.Handler;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QIMNewFriendManager.IQIMNotifyNewFriendListener;

public class zdi
  implements QIMNewFriendManager.IQIMNotifyNewFriendListener
{
  public zdi(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void a()
  {
    if (this.a.a.hasMessages(17)) {
      this.a.a.removeMessages(17);
    }
    this.a.a.sendEmptyMessage(17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdi
 * JD-Core Version:    0.7.0.1
 */