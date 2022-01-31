import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.redtouch.RedTouchManager;

public final class gke
  implements Runnable
{
  public gke(RedTouchManager paramRedTouchManager, Conversation paramConversation, Handler paramHandler) {}
  
  public void run()
  {
    RedTouchManager localRedTouchManager = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager;
    gkf localgkf = new gkf(this);
    localRedTouchManager.a(new int[] { 0, 1, 2 }, localgkf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gke
 * JD-Core Version:    0.7.0.1
 */