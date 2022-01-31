import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;

public class yrm
  implements View.OnClickListener
{
  public yrm(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    TroopGiftPanel.a(this.a).setSelected(false);
    this.a.a.a(-1);
    TroopGiftPanel.b(this.a).setSelected(true);
    ((TextView)TroopGiftPanel.b(this.a).findViewById(2131378766)).setTextColor(Color.parseColor("#ffff5b84"));
    TroopGiftPanel.b(this.a).findViewById(2131379871).setVisibility(0);
    ((TextView)TroopGiftPanel.a(this.a).findViewById(2131378765)).setTextColor(Color.parseColor("#ff878b99"));
    TroopGiftPanel.a(this.a).findViewById(2131379880).setVisibility(8);
    this.a.onTabSelected(this.a.h, TroopGiftPanel.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yrm
 * JD-Core Version:    0.7.0.1
 */