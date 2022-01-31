import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;

public final class ccp
  implements Runnable
{
  public ccp(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    FriendSystemMsgController.a().c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ccp
 * JD-Core Version:    0.7.0.1
 */