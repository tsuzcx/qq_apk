import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class dts
  implements CompoundButton.OnCheckedChangeListener
{
  public dts(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default: 
      return;
    }
    TroopAssistantManager.a().a(this.a.b, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dts
 * JD-Core Version:    0.7.0.1
 */