import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;

class chp
  implements DialogInterface.OnCancelListener
{
  chp(cho paramcho) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chp
 * JD-Core Version:    0.7.0.1
 */