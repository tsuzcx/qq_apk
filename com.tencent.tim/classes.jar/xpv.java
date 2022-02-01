import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xpv
  implements View.OnClickListener
{
  xpv(xpu paramxpu) {}
  
  public void onClick(View paramView)
  {
    xpu.a locala = (xpu.a)wja.a(paramView);
    Object localObject = (MessageForTroopFee)locala.mMessage;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", ((MessageForTroopFee)localObject).actionUrl);
    paramView.getContext().startActivity(localIntent);
    localObject = ((TroopManager)this.a.app.getManager(52)).b(locala.friendUin);
    int i;
    if (localObject != null)
    {
      if (!((TroopInfo)localObject).isTroopOwner(this.a.app.getCurrentAccountUin())) {
        break label160;
      }
      i = 0;
    }
    for (;;)
    {
      anot.a(this.a.app, "P_CliOper", "Grp_pay", "", "grp_aio", "Clk_payobj", 0, 0, locala.friendUin, i + "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label160:
      if (((TroopInfo)localObject).isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpv
 * JD-Core Version:    0.7.0.1
 */