import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gym
  implements ActionSheet.OnButtonClickListener
{
  public gym(AvatarWallAdapter paramAvatarWallAdapter, Activity paramActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      AvatarWallAdapter.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, 15);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this.jdField_a_of_type_AndroidAppActivity, 8 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gym
 * JD-Core Version:    0.7.0.1
 */