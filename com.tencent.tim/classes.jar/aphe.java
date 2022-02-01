import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.a;
import com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aphe
  implements CompoundButton.OnCheckedChangeListener
{
  public aphe(HomeWorkTroopSelectorFragment.a parama, HomeWorkTroopSelectorFragment.b paramb) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.a.first).troopuin.equals(HomeWorkTroopSelectorFragment.a.a(this.b)))) {
      this.a.second = Boolean.valueOf(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphe
 * JD-Core Version:    0.7.0.1
 */