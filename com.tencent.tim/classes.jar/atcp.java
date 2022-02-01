import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atcp
  implements CompoundButton.OnCheckedChangeListener
{
  atcp(atcn paramatcn, RedTouch paramRedTouch, aunr paramaunr) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!AppSetting.enableTalkBack) {
      atcn.a(this.b, this.G, this.a, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcp
 * JD-Core Version:    0.7.0.1
 */