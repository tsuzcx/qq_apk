import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;

public class wbk
  implements Runnable
{
  public wbk(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    if (!NearbyChatPie.b(this.a)) {
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).p(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbk
 * JD-Core Version:    0.7.0.1
 */