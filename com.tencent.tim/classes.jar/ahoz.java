import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahoz
  implements CompoundButton.OnCheckedChangeListener
{
  public ahoz(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((aizh)this.a.app.getManager(303)).b((short)-23309, paramBoolean, true);
    anot.a(this.a.app, "dc00898", "", "", "0X8009976", "0X8009976", 5, 5, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahoz
 * JD-Core Version:    0.7.0.1
 */