import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.os.MqqHandler;

public class tnc
  extends Handler
{
  public tnc(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return;
        if (!this.a.isFinishing())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131434046));
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(2130845523);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131434045));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
      return;
    }
    if (paramMessage.obj == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    paramMessage = (tni)paramMessage.obj;
    if ((TextUtils.isEmpty(paramMessage.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramMessage.b)) || (TextUtils.isEmpty(paramMessage.c)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    if (!this.a.app.getPreferences().getString("chatHistoryEventName", "").equals(paramMessage.jdField_a_of_type_JavaLangString)) {
      ThreadManager.getSubThreadHandler().post(new tnd(this, paramMessage));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem);
    this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c(30).a();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(paramMessage.jdField_a_of_type_JavaLangString);
    this.a.jdField_a_of_type_JavaLangString = paramMessage.b;
    this.a.b = paramMessage.c;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.a);
    QQSettingMsgHistoryActivity.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnc
 * JD-Core Version:    0.7.0.1
 */