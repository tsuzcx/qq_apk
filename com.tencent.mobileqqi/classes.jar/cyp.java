import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

class cyp
  extends Handler
{
  cyp(cyo paramcyo) {}
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a().a(paramMessageRecord, str);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a();
    switch (paramMessage.what)
    {
    default: 
    case 1002: 
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      } while (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.c(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      paramMessage = Message.obtain();
      paramMessage.what = 1003;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      cyo.a(this.a);
      return;
    }
    paramMessage = (MessageForMyEnterTroop)MessageRecordFactory.a(-4004);
    paramMessage.init(str, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", MessageCache.a(), -4004, 1, 0L);
    paramMessage.iMemberCount = 0;
    a(paramMessage, false, false, false);
    cyo.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cyp
 * JD-Core Version:    0.7.0.1
 */