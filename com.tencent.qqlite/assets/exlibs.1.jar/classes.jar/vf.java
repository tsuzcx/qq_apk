import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AccountManageActivity;

class vf
  implements Runnable
{
  vf(ve paramve) {}
  
  public void run()
  {
    int i = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.a.jdField_a_of_type_Int);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_Boolean) {
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
      i += 2;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vf
 * JD-Core Version:    0.7.0.1
 */