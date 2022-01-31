import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import java.lang.ref.WeakReference;

public class wgj
  extends Handler
{
  private WeakReference a;
  
  public wgj(NewFriendActivity paramNewFriendActivity)
  {
    this.a = new WeakReference(paramNewFriendActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NewFriendActivity localNewFriendActivity = (NewFriendActivity)this.a.get();
    if (localNewFriendActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      localNewFriendActivity.a(paramMessage.arg1);
      return;
    }
    localNewFriendActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgj
 * JD-Core Version:    0.7.0.1
 */