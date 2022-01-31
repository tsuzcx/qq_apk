import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.PhoneContactAddMessage;

public class yhy
  implements Runnable
{
  public yhy(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, NewFriendMessage paramNewFriendMessage) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.a.getManager(10)).a(((PhoneContactAddMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a);
    this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter.a.runOnUiThread(new yhz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yhy
 * JD-Core Version:    0.7.0.1
 */