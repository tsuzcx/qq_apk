import android.view.View;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class nzh
  implements ausj.a
{
  public nzh(SubscriptFeedsActivity paramSubscriptFeedsActivity, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.val$actionSheet.dismiss();
      return;
    }
    oan.a().a(this.val$uin, this.this$0.app, this.this$0, null);
    paramInt = ocp.e(this.this$0.app, this.val$uin);
    aalb.l(this.this$0.app, this.val$uin, paramInt);
    this.this$0.app.b().ca(this.val$uin, 1008);
    kbp.b(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
    paramView = SubscriptFeedsActivity.a(this.this$0).iterator();
    oal localoal;
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
      localoal = (oal)paramView.next();
    } while ((localoal.mUin == null) || (!localoal.mUin.equals(this.val$uin)));
    for (paramInt = localoal.aOr;; paramInt = 0)
    {
      anot.a(null, "dc00899", "Pb_account_lifeservice", this.val$uin, "0X80064CF", "0X80064CF", 0, 0, "" + paramInt, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzh
 * JD-Core Version:    0.7.0.1
 */