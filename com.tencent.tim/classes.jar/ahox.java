import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahox
  implements CompoundButton.OnCheckedChangeListener
{
  public ahox(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((aizh)this.a.app.getManager(303)).b((short)-23166, paramBoolean, true);
    anot.a(this.a.app, "dc00898", "", "", "0X8009976", "0X8009976", 3, 3, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahox
 * JD-Core Version:    0.7.0.1
 */