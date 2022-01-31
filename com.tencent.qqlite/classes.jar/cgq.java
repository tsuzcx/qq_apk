import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.SearchHistoryAdapter;

public class cgq
  implements TextWatcher
{
  public cgq(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (this.a.b) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter.a(paramEditable);
    }
    this.a.b = true;
    if (paramEditable.length() == 0)
    {
      this.a.findViewById(2131297955).setVisibility(8);
      return;
    }
    this.a.findViewById(2131297955).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgq
 * JD-Core Version:    0.7.0.1
 */