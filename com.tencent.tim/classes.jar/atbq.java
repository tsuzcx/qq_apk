import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.activity.profile.friend.FriendProfileFragment;
import java.util.Arrays;

public class atbq
  implements ausj.a
{
  public atbq(FriendProfileFragment paramFriendProfileFragment, int[] paramArrayOfInt, jln paramjln) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.fq[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileFragment", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.fq) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_Jln.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment.a(FriendProfileFragment.b(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment), this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment.getActivity(), FriendProfileFragment.a(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment));
      anot.a(FriendProfileFragment.c(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment), "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.cZ = aqep.b(FriendProfileFragment.b(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment).e);
    paramView.aTl = FriendProfileFragment.c(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment).e.uin;
    paramView.aTn = FriendProfileFragment.a(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment).getNickName();
    paramView.troopUin = FriendProfileFragment.d(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment).e.troopUin;
    wmj.a(FriendProfileFragment.d(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment), this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment.getActivity(), paramView, false, null, null);
    anot.a(FriendProfileFragment.e(this.jdField_a_of_type_ComTencentTimActivityProfileFriendFriendProfileFragment), "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbq
 * JD-Core Version:    0.7.0.1
 */