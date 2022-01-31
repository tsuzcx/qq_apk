import android.app.Dialog;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class cho
  implements Handler.Callback
{
  public cho(ChatHistory paramChatHistory) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        } while (!NetworkUtil.e(BaseApplication.getContext()));
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.a.b.setVisibility(8);
        return true;
        this.a.jdField_a_of_type_AndroidAppDialog = new Dialog(this.a, 2131624405);
        this.a.jdField_a_of_type_AndroidAppDialog.setContentView(2130903940);
        ((TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131231029)).setText(paramMessage.obj.toString());
        this.a.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new chp(this));
        this.a.jdField_a_of_type_AndroidAppDialog.show();
        return true;
        this.a.g();
        return true;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.a.d();
        return true;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.a.a(2130837947, this.a.getString(2131563005));
        return true;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.a.a(2130837947, this.a.getString(2131562486));
        return true;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.a.a(2130837947, this.a.getString(2131561770));
        return true;
        this.a.a(2130837947, this.a.getString(2131562085));
        return true;
      } while (paramMessage.obj == null);
      paramMessage = (Cursor)paramMessage.obj;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter != null)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor() != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor().deactivate();
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.changeCursor(paramMessage);
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a < 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a >= 8));
    ChatHistory.a(this.a).setSelection(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a + ChatHistory.a(this.a).getHeaderViewsCount());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a = -1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cho
 * JD-Core Version:    0.7.0.1
 */