import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.redtouch.RedTouchManager;

public final class gfv
  implements Runnable
{
  public gfv(RedTouchManager paramRedTouchManager, Conversation paramConversation, Handler paramHandler) {}
  
  public void run()
  {
    RedTouchManager localRedTouchManager = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager;
    gfw localgfw = new gfw(this);
    localRedTouchManager.a(new int[] { 0, 1, 2 }, localgfw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfv
 * JD-Core Version:    0.7.0.1
 */