import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.data.HotChatInfo;

public class vvk
  implements Runnable
{
  public vvk(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state;
    HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i);
    HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */