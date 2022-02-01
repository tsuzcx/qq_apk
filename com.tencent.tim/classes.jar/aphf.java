import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aphf
  implements View.OnClickListener
{
  public aphf(HomeWorkTroopSelectorFragment.a parama, CheckBox paramCheckBox) {}
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = this.T;
    if (!this.T.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphf
 * JD-Core Version:    0.7.0.1
 */