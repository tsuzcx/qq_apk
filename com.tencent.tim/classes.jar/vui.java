import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vui
  implements CompoundButton.OnCheckedChangeListener
{
  public vui(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (((paramCompoundButton == this.a.aA.a()) || (paramCompoundButton == this.a.aB.a())) && (!aqiw.isNetSupport(this.a.getActivity())))
    {
      this.a.cf(2131696349, 0);
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      if (!paramBoolean) {
        SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, paramCompoundButton, bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      if (paramCompoundButton == this.a.aA.a()) {
        this.a.app.bE(paramBoolean, true);
      } else if (paramCompoundButton == this.a.aB.a()) {
        this.a.app.bF(paramBoolean, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vui
 * JD-Core Version:    0.7.0.1
 */