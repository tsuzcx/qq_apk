import android.view.View;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ahq
  implements ActionSheet.OnButtonClickListener
{
  public ahq(DetailProfileActivity paramDetailProfileActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Byte != paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity.jdField_a_of_type_Boolean = true;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDetailProfileActivity;
    if (paramInt == 0) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramView.a(paramInt, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ahq
 * JD-Core Version:    0.7.0.1
 */