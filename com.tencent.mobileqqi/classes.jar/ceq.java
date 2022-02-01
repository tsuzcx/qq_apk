import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class ceq
  extends MessageObserver
{
  public ceq(Conversation paramConversation) {}
  
  protected void a()
  {
    TroopAssistantManager.a().c(this.a.a);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      this.a.b(new cet(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    paramString = RecentDataListManager.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("Q.recent", 2, "onPushSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i("Q.recent", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if (paramBoolean)
    {
      this.a.a.a().c(AppConstants.O, 7000);
      this.a.a(9, AppConstants.O, 7000);
    }
  }
  
  protected void b()
  {
    this.a.a(0L);
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("Q.recent", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i("Q.recent", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    this.a.a(9, AppConstants.O, 7000);
  }
  
  protected void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (this.a.b != 1000L) {
      this.a.b = 1000L;
    }
    this.a.b(new cer(this, paramBoolean));
  }
  
  public void d(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, -2147483648);
  }
  
  protected void e(boolean paramBoolean)
  {
    this.a.b(new ces(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ceq
 * JD-Core Version:    0.7.0.1
 */