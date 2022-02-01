import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;

public class dlw
  implements View.OnClickListener
{
  public dlw(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b.a().c(AppConstants.O, 7000);
    if (!PhoneNumLoginImpl.a().a(this.a.b, this.a)) {}
    do
    {
      return;
      paramView = "";
      if (SubAccountMessageActivity.a(this.a) != null) {
        paramView = SubAccountMessageActivity.a(this.a).subuin;
      }
      ReportController.b(this.a.b, "CliOper", "", paramView, "Bind_account", "Clk_readmsg", 0, 0, "", "", "", "");
    } while (!this.a.f());
    this.a.d();
    if (SubAccountMessageActivity.a(this.a))
    {
      ((MessageHandler)this.a.b.a(0)).a().a(SubAccountMessageActivity.a(this.a).subuin, "sub.account.switchAccount");
      return;
    }
    SubAccountMessageActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dlw
 * JD-Core Version:    0.7.0.1
 */