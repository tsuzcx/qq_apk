import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;

public class xct
  implements View.OnClickListener
{
  public xct(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    TroopGiftPanel.a(this.a).setSelected(false);
    this.a.a.a(-1);
    TroopGiftPanel.b(this.a).setSelected(true);
    ((TextView)TroopGiftPanel.b(this.a).findViewById(2131378200)).setTextColor(Color.parseColor("#ffff5b84"));
    TroopGiftPanel.b(this.a).findViewById(2131379173).setVisibility(0);
    ((TextView)TroopGiftPanel.a(this.a).findViewById(2131378199)).setTextColor(Color.parseColor("#ff878b99"));
    TroopGiftPanel.a(this.a).findViewById(2131379180).setVisibility(8);
    this.a.onTabSelected(this.a.h, TroopGiftPanel.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xct
 * JD-Core Version:    0.7.0.1
 */