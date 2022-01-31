import android.view.View;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tri
  implements ActionSheet.OnButtonClickListener
{
  public tri(SubAccountUgActivity paramSubAccountUgActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.b());
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.a(2131436378);
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.b = true;
      paramView = (SubAccountProtocManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app.getManager(27);
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tri
 * JD-Core Version:    0.7.0.1
 */