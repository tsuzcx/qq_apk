import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.EUCountryUtils;
import mqq.app.MobileQQ;

public class emx
  implements View.OnClickListener
{
  public emx(MainAssistObserver paramMainAssistObserver, TextView paramTextView, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(""))
    {
      if (EUCountryUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))
      {
        EUCountryUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a());
        EUCountryUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.getApplication().getProperty(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a()));
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a, this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b, true);
      }
      do
      {
        return;
        EUCountryUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a(), this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b);
        EUCountryUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a(), 1);
        EUCountryUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a(), 1);
        MainAssistObserver.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver, this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b);
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a, 2131563356, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     emx
 * JD-Core Version:    0.7.0.1
 */