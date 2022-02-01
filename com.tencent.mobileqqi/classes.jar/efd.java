import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;

public final class efd
  implements Runnable
{
  public efd(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    FriendSystemMsgController.a().c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efd
 * JD-Core Version:    0.7.0.1
 */