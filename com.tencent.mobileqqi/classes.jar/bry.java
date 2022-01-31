import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AccountManageActivity;

class bry
  implements Runnable
{
  bry(brx parambrx) {}
  
  public void run()
  {
    int i = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.a.jdField_a_of_type_Int);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(false);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView = null;
    int j = this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    while (i < j)
    {
      View localView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localView.getTag() != null) {
        localView.setTag(Integer.valueOf(i));
      }
      i += 1;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bry
 * JD-Core Version:    0.7.0.1
 */