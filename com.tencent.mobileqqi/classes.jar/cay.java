import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cay
  extends Handler
{
  public cay(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (!this.a.isFinishing())
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131561834));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130839719);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131561702));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cay
 * JD-Core Version:    0.7.0.1
 */