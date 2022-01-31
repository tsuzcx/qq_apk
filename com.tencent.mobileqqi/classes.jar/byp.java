import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class byp
  extends MessageObserver
{
  public byp(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (paramBoolean) {
      AccountManageActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     byp
 * JD-Core Version:    0.7.0.1
 */