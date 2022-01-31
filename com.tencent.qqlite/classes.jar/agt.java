import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendPushListener;
import com.tencent.qphone.base.util.QLog;

public class agt
  implements NewFriendPushListener
{
  public agt(Conversation paramConversation) {}
  
  public void a(NewFriendMessage paramNewFriendMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onRecommendMsgPushed");
    }
    this.a.b(new agu(this));
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agt
 * JD-Core Version:    0.7.0.1
 */