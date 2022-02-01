import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class xdu
  implements ausj.a
{
  xdu(xdt paramxdt, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.a.this$0.sessionInfo.cZ != 3000);
    try
    {
      long l = Long.valueOf(this.a.this$0.sessionInfo.aTl).longValue();
      paramView = (accc)this.a.this$0.app.getBusinessHandler(22);
      if (paramView != null) {
        paramView.hh(l);
      }
      anot.a(this.a.this$0.app, "P_CliOper", "Grp_discuss", "", "grey", "Clk", 0, 0, "", String.valueOf(this.a.val$type), "", "");
      return;
    }
    catch (NumberFormatException paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdu
 * JD-Core Version:    0.7.0.1
 */