import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.RadioButton;
import com.tencent.mobileqq.activity.main.MainAssistObserver;

public class ejc
  implements DialogInterface.OnDismissListener
{
  public ejc(MainAssistObserver paramMainAssistObserver, RadioButton paramRadioButton) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioButton.isChecked()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ejc
 * JD-Core Version:    0.7.0.1
 */