import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.QIMNotifyAddFriendMsg;

public class yet
  implements Runnable
{
  public yet(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, NewFriendMessage paramNewFriendMessage) {}
  
  public void run()
  {
    ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.a.getManager(256)).b(((QIMNotifyAddFriendMsg)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a);
    this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.a.runOnUiThread(new yeu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yet
 * JD-Core Version:    0.7.0.1
 */