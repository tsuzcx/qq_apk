import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class bsq
  extends SubAccountBindObserver
{
  public bsq(AccountManageActivity paramAccountManageActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (paramBoolean) {
      AccountManageActivity.a(this.a);
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (paramBoolean) {
      AccountManageActivity.a(this.a);
    }
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (paramBoolean)
    {
      this.a.b.a().c(AppConstants.O, 7000);
      AccountManageActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bsq
 * JD-Core Version:    0.7.0.1
 */