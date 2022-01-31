import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class ctu
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ctv(this);
  private DataTag jdField_a_of_type_ComTencentMobileqqProfileDataTag;
  
  public ctu(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof DataTag))) {
      return false;
    }
    Object localObject = (DataTag)paramView.getTag();
    switch (((DataTag)localObject).C)
    {
    }
    for (;;)
    {
      return true;
      if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a))
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileDataTag = ((DataTag)localObject);
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131234877, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131561879));
        FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, null));
        continue;
        this.jdField_a_of_type_ComTencentMobileqqProfileDataTag = ((DataTag)localObject);
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131234877, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131561879));
        FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ctu
 * JD-Core Version:    0.7.0.1
 */