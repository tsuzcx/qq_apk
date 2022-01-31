import android.app.Dialog;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class acq
  implements Handler.Callback
{
  public acq(ChatHistory paramChatHistory) {}
  
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
          ChatHistory.a(this.a).setEnabled(true);
        } while (!NetworkUtil.e(BaseApplication.getContext()));
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.a.b.setVisibility(8);
        return true;
        this.a.jdField_a_of_type_AndroidAppDialog = new Dialog(this.a, 2131624119);
        this.a.jdField_a_of_type_AndroidAppDialog.setContentView(2130903599);
        ((TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131296470)).setText(paramMessage.obj.toString());
        this.a.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new acr(this));
        this.a.jdField_a_of_type_AndroidAppDialog.show();
        return true;
        this.a.f();
        return true;
        ChatHistory.a(this.a).setEnabled(true);
        try
        {
          if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
        }
        catch (IllegalArgumentException paramMessage)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
            }
            this.a.jdField_a_of_type_AndroidAppDialog = null;
          }
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
            }
            this.a.jdField_a_of_type_AndroidAppDialog = null;
          }
        }
        finally
        {
          this.a.jdField_a_of_type_AndroidAppDialog = null;
        }
        this.a.c();
        return true;
        ChatHistory.a(this.a).setEnabled(true);
        if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.a.a(2130837975, this.a.getString(2131363174));
        return true;
        ChatHistory.a(this.a).setEnabled(true);
        if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.a.a(2130837975, this.a.getString(2131363176));
        return true;
        ChatHistory.a(this.a).setEnabled(true);
        if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.a.a(2130837975, this.a.getString(2131363175));
        return true;
        this.a.a(2130837975, this.a.getString(2131363397));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     acq
 * JD-Core Version:    0.7.0.1
 */