import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.OpenTroopChatLogic;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

public class bah
  extends Handler
{
  public bah(OpenTroopChatLogic paramOpenTroopChatLogic) {}
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a(paramMessageRecord, str);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a();
    switch (paramMessage.what)
    {
    default: 
    case 1002: 
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      } while (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      paramMessage = Message.obtain();
      paramMessage.what = 1003;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      OpenTroopChatLogic.a(this.a);
      return;
    }
    paramMessage = (MessageForMyEnterTroop)MessageRecordFactory.a(-4004);
    paramMessage.init(str, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", MessageCache.a(), -4004, 1, 0L);
    paramMessage.iMemberCount = 0;
    a(paramMessage, false, false, false);
    OpenTroopChatLogic.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bah
 * JD-Core Version:    0.7.0.1
 */