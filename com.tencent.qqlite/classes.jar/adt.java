import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.Editable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.qphone.base.util.QLog;

public class adt
  implements DialogInterface.OnDismissListener
{
  public adt(ChatHistory paramChatHistory, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_Int = ((i - 1) % 8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(j));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adt
 * JD-Core Version:    0.7.0.1
 */