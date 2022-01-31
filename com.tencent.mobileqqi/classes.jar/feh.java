import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;

public class feh
  implements Runnable
{
  public feh(NewFriendManager paramNewFriendManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a.a;
    if ((localQQAppInterface == null) || (this.a.a.getManager(10) == null)) {
      return;
    }
    ((PhoneContactManagerImp)localQQAppInterface.getManager(10)).l();
    localQQAppInterface.a().a().b();
    FriendSystemMsgController.a().a(this.a.a, 0);
    FriendSystemMsgController.a().c(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     feh
 * JD-Core Version:    0.7.0.1
 */