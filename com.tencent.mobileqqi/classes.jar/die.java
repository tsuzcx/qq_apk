import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class die
  implements View.OnClickListener
{
  public die(QQMapActivity paramQQMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.h) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     die
 * JD-Core Version:    0.7.0.1
 */