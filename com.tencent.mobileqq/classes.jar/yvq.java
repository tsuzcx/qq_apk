import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;

public class yvq
  implements AdapterView.OnItemClickListener
{
  public yvq(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.onTabSelected(0, paramInt);
    paramView.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvq
 * JD-Core Version:    0.7.0.1
 */