import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.EUCountryUtils;

public class eht
  implements View.OnClickListener
{
  public eht(MainAssistObserver paramMainAssistObserver, TextView paramTextView, eji parameji, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(""))
    {
      EUCountryUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.b.a(), this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b);
      if (EUCountryUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString())) {
        this.jdField_a_of_type_Eji.a();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        return;
        this.jdField_a_of_type_Eji.b();
      }
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a, 2131563356, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eht
 * JD-Core Version:    0.7.0.1
 */