import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class cnw
  implements View.OnClickListener
{
  public cnw(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131230986)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
        localActionSheet.a(2131561928, 3);
        localActionSheet.d(2131561746);
        localActionSheet.a(new cnx(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnw
 * JD-Core Version:    0.7.0.1
 */