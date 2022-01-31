import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class wa
  implements ActionSheet.OnButtonClickListener
{
  int jdField_a_of_type_Int = -1;
  
  public wa(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
      } while (this.jdField_a_of_type_Int < 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_Int, false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
    } while (this.jdField_a_of_type_Int < 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wa
 * JD-Core Version:    0.7.0.1
 */