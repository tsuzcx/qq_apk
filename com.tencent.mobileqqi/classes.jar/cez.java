import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class cez
  extends SubAccountBindObserver
{
  public cez(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.a.d = true;
    if ((paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.p == 1008)) {
      this.a.a.a().c(AppConstants.O, 7000);
    }
    this.a.a(8, AppConstants.O, 7000);
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.a(8, AppConstants.O, 7000);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.a.a().c(AppConstants.O, 7000);
    this.a.a(8, AppConstants.O, 7000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cez
 * JD-Core Version:    0.7.0.1
 */