import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;

class cms
  implements Runnable
{
  cms(cmr paramcmr) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.a.b.getManager(46)).a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
    if (localCard != null) {
      this.a.a.runOnUiThread(new cmt(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cms
 * JD-Core Version:    0.7.0.1
 */