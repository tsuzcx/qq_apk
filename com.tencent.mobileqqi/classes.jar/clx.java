import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendPushListener;
import com.tencent.qphone.base.util.QLog;

public class clx
  implements NewFriendPushListener
{
  public clx(Conversation paramConversation) {}
  
  public void a(NewFriendMessage paramNewFriendMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onRecommendMsgPushed");
    }
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     clx
 * JD-Core Version:    0.7.0.1
 */