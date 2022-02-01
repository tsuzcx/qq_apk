import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class snt
  implements View.OnClickListener
{
  public snt(TroopGiftPanel paramTroopGiftPanel, snf.e parame) {}
  
  public void onClick(View paramView)
  {
    if (this.a.tabID == 1) {
      this.this$0.tu(this.a.jumpUrl);
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.this$0.nD(), "", "", this.a.title);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopGiftPanel.a(this.this$0, this.a.jumpUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snt
 * JD-Core Version:    0.7.0.1
 */