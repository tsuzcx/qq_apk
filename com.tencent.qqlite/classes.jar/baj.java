import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.OpenTroopChatLogic;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class baj
  extends MessageObserver
{
  public baj(OpenTroopChatLogic paramOpenTroopChatLogic) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int k = 0;
    int j = k;
    int i;
    if (paramArrayOfString != null) {
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          j = 1;
        }
      }
      else
      {
        if (j != 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在重发消息");
          paramArrayOfString = Message.obtain();
          paramArrayOfString.what = 1003;
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayOfString);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     baj
 * JD-Core Version:    0.7.0.1
 */