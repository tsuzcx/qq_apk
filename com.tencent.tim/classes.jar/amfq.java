import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amfq
  implements CompoundButton.OnCheckedChangeListener
{
  public amfq(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((aqiw.isNetSupport(this.a.getActivity())) && (SignTextEditFragment.a(this.a) != null))
    {
      if (AppSetting.enableTalkBack) {
        this.a.P.setContentDescription(acfp.m(2131709428));
      }
      SignTextEditFragment.a(this.a).E(paramBoolean);
      anot.a(this.a.mApp, "dc00898", "", "", "0X800A97B", "0X800A97B", 0, 0, "0", "0", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject = this.a.getActivity();
    int i;
    label117:
    CheckBox localCheckBox;
    if (SignTextEditFragment.a(this.a) != null)
    {
      i = 2131696346;
      QQToast.a((Context)localObject, i, 1).show();
      localObject = this.a;
      localCheckBox = this.a.P;
      if (paramBoolean) {
        break label168;
      }
    }
    label168:
    for (boolean bool = true;; bool = false)
    {
      SignTextEditFragment.a((SignTextEditFragment)localObject, localCheckBox, bool);
      break;
      i = 2131719890;
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfq
 * JD-Core Version:    0.7.0.1
 */