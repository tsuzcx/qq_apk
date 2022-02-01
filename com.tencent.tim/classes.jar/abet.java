import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abet
  implements CompoundButton.OnCheckedChangeListener
{
  abet(abes paramabes, RedTouch paramRedTouch, aevs paramaevs) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!AppSetting.enableTalkBack) {
      abes.a(this.jdField_b_of_type_Abes, this.G, this.jdField_b_of_type_Aevs, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abet
 * JD-Core Version:    0.7.0.1
 */