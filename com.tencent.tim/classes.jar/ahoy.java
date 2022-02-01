import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahoy
  implements CompoundButton.OnCheckedChangeListener
{
  public ahoy(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((aizh)this.a.app.getManager(303)).b((short)-23310, paramBoolean, true);
    anot.a(this.a.app, "dc00898", "", "", "0X8009976", "0X8009976", 4, 4, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahoy
 * JD-Core Version:    0.7.0.1
 */