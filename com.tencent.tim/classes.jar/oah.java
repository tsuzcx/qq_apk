import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.6.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class oah
  implements View.OnClickListener
{
  oah(oac paramoac) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.mApp, "P_CliOper", "Pb_account_lifeservice", "", "0X8005733", "0X8005733", 0, 0, "", "", "", "");
    anot.a(this.this$0.mApp, "CliOper", "", "", "0X8006430", "0X8006430", 0, 0, "", "", "", "");
    this.this$0.avU = false;
    this.this$0.R.setEnabled(false);
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.6.1(this));
    if (this.this$0.bdz == 1) {
      oac.b(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.bdz == 3)
      {
        MqqHandler localMqqHandler = this.this$0.mApp.getHandler(SubscriptFeedsActivity.class);
        if ((localMqqHandler != null) && (this.this$0.mContext.get() != null) && ((this.this$0.mContext.get() instanceof SubscriptFeedsActivity))) {
          localMqqHandler.sendEmptyMessage(1006);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oah
 * JD-Core Version:    0.7.0.1
 */