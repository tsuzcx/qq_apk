import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class bde
  implements View.OnClickListener
{
  public bde(QQMapActivity paramQQMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.runOnUiThread(new bdf(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bde
 * JD-Core Version:    0.7.0.1
 */