import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tuw
  implements ActionSheet.OnButtonClickListener
{
  public tuw(TroopInfoActivity paramTroopInfoActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, 13);
      return;
    }
    AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */