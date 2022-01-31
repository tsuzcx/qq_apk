import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;

public class twy
  implements View.OnClickListener
{
  public twy(TroopDisbandActivity paramTroopDisbandActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    TroopDisbandActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     twy
 * JD-Core Version:    0.7.0.1
 */