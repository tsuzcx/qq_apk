import android.view.View;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class bnj
  implements ActionSheet.OnButtonClickListener
{
  public bnj(TroopManageActivity paramTroopManageActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.getActivity()))
    {
      TroopManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity, paramInt + 1);
      TroopManageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.a = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.a.a(2, this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.getString(2131362785), 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnj
 * JD-Core Version:    0.7.0.1
 */