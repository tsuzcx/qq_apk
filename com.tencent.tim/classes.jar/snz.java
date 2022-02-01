import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.c;
import com.tencent.biz.troopgift.TroopGiftPanel.f;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class snz
  implements View.OnClickListener
{
  public snz(TroopGiftPanel.c paramc, TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    this.a.gR();
    this.a.dismiss();
    if (this.a.this$0.aMj) {
      this.a.this$0.a.onHide();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((BaseChatPie)this.a.this$0.dq.get()).bzx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snz
 * JD-Core Version:    0.7.0.1
 */