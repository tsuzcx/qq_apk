import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class apb
  implements View.OnClickListener
{
  public apb(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296440)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
        localActionSheet.a(2131363936, 3);
        localActionSheet.d(2131362794);
        localActionSheet.a(new apc(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     apb
 * JD-Core Version:    0.7.0.1
 */