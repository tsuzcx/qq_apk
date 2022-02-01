import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class abeu
  implements View.OnClickListener
{
  abeu(abes paramabes, RedTouch paramRedTouch, aevs paramaevs) {}
  
  public void onClick(View paramView)
  {
    Switch localSwitch;
    if (AppSetting.enableTalkBack)
    {
      localSwitch = (Switch)paramView.findViewById(2131364012);
      if (localSwitch != null) {
        if (localSwitch.isChecked()) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      abes.a(this.jdField_b_of_type_Abes, this.G, this.jdField_b_of_type_Aevs, localSwitch.isChecked());
      paramView.sendAccessibilityEvent(1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abeu
 * JD-Core Version:    0.7.0.1
 */