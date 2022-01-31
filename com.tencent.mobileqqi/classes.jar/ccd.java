import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.qphone.base.util.QLog;

public class ccd
  implements DialogInterface.OnDismissListener
{
  public ccd(ChatHistory paramChatHistory) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    int i = ((MessageSearchDialog)paramDialogInterface).b();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDismiss, recordCount : " + i);
    }
    if (i <= 0) {}
    int j;
    do
    {
      return;
      j = (i - 1) / 8 + 1;
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "onDismiss, pageIndex = " + j);
      }
    } while (j < 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a = ((i - 1) % 8);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(j));
    this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ccd
 * JD-Core Version:    0.7.0.1
 */