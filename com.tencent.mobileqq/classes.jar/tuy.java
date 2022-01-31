import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tuy
  implements ActionSheet.OnButtonClickListener
{
  public tuy(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.e());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tuy
 * JD-Core Version:    0.7.0.1
 */