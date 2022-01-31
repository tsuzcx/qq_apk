import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.qphone.base.util.QLog;

public class eek
  implements Runnable
{
  public eek(NewFriendActivity paramNewFriendActivity, Object paramObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "init red dot from NewFriendManager push");
    }
    if (NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity) != this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity.a(((NewFriendMessage)this.jdField_a_of_type_JavaLangObject).b())) {
      NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eek
 * JD-Core Version:    0.7.0.1
 */