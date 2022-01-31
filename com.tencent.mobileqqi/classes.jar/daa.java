import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.BaseApplication;

public class daa
  implements DialogInterface.OnClickListener
{
  public daa(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ProfileCardMoreActivity.a(this.a).getInputValue();
    if (!paramDialogInterface.equals(this.a.jdField_a_of_type_JavaLangString))
    {
      if (!NetworkUtil.e(BaseApplication.getContext())) {
        break label133;
      }
      if (paramDialogInterface.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
        break label122;
      }
      FriendListHandler localFriendListHandler = (FriendListHandler)this.a.b.a(1);
      if (localFriendListHandler != null)
      {
        localFriendListHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialogInterface);
        ProfileCardMoreActivity.a(this.a, ProfileCardMoreActivity.a(this.a) | 0x1);
        this.a.b(paramDialogInterface);
      }
    }
    else
    {
      return;
    }
    this.a.a(2131562435, 1);
    return;
    label122:
    this.a.a(2131562516, 0);
    return;
    label133:
    this.a.a(2131562445, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     daa
 * JD-Core Version:    0.7.0.1
 */