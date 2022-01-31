import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.EUCountryUtils;

public class enu
  implements View.OnClickListener
{
  public enu(MainAssistObserver paramMainAssistObserver, RadioButton paramRadioButton1, QQCustomDialog paramQQCustomDialog, RadioButton paramRadioButton2) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioButton.isChecked())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      MainAssistObserver.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver);
    }
    do
    {
      return;
      if (!this.b.isChecked()) {
        break;
      }
      EUCountryUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a(), 1);
      EUCountryUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a(), 2);
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    return;
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a, 2131563355, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     enu
 * JD-Core Version:    0.7.0.1
 */