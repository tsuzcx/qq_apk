import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.HistoryItem;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.SearchHistoryAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

public class cfv
  implements AdapterView.OnItemClickListener
{
  public cfv(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onItemClick, position = " + paramInt);
    }
    paramAdapterView = MessageSearchDialog.a(this.a).a();
    if (paramAdapterView == this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter)
    {
      paramAdapterView = (MessageItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.getItem(paramInt);
      MessageSearchDialog.a(this.a, MessageSearchDialog.a(this.a).a().a(MessageSearchDialog.a(this.a).jdField_a_of_type_JavaLangString, MessageSearchDialog.a(this.a).jdField_a_of_type_Int, paramAdapterView.a));
      if (QLog.isColorLevel()) {
        QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onItemClick, mRecordCount = " + MessageSearchDialog.a(this.a));
      }
      this.a.a(true);
      this.a.dismiss();
    }
    do
    {
      return;
      if (paramAdapterView == this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter)
      {
        paramAdapterView = (HistoryItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter.getItem(paramInt);
        this.a.b = false;
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramAdapterView.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramAdapterView.jdField_a_of_type_JavaLangString.length());
        this.a.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        ((InputMethodManager)this.a.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onItemClick, unknown data type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cfv
 * JD-Core Version:    0.7.0.1
 */