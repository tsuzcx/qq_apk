import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;

public class anz
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aoc(this);
  private DataTag jdField_a_of_type_ComTencentMobileqqProfileDataTag;
  private MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog;
  
  public anz(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof DataTag))) {
      return false;
    }
    Object localObject = (DataTag)paramView.getTag();
    switch (((DataTag)localObject).z)
    {
    }
    for (;;)
    {
      return true;
      if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a))
      {
        paramView.setSelected(true);
        this.jdField_a_of_type_ComTencentMobileqqProfileDataTag = ((DataTag)localObject);
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131298988, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131363570));
        this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131363274), (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, new aoa(this, paramView));
        continue;
        paramView.setSelected(true);
        this.jdField_a_of_type_ComTencentMobileqqProfileDataTag = ((DataTag)localObject);
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131298988, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131363570));
        this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131363274), (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, new aob(this, paramView));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     anz
 * JD-Core Version:    0.7.0.1
 */