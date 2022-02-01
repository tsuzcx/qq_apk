import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sns
  implements View.OnClickListener
{
  public sns(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    TroopGiftPanel.b(this.this$0).setSelected(false);
    this.this$0.a.setSelectedTab(-1);
    TroopGiftPanel.a(this.this$0).setSelected(true);
    ((TextView)TroopGiftPanel.b(this.this$0).findViewById(2131380735)).setTextColor(Color.parseColor("#ff878b99"));
    TroopGiftPanel.b(this.this$0).findViewById(2131381919).setVisibility(8);
    ((TextView)TroopGiftPanel.a(this.this$0).findViewById(2131380734)).setTextColor(Color.parseColor("#ffff5b84"));
    TroopGiftPanel.a(this.this$0).findViewById(2131381927).setVisibility(0);
    this.this$0.onTabSelected(this.this$0.mCurrentTab, TroopGiftPanel.bym);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sns
 * JD-Core Version:    0.7.0.1
 */