import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vla
  implements CompoundButton.OnCheckedChangeListener
{
  public vla(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!aqiw.isNetworkAvailable(this.this$0))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131696349, 0).show(this.this$0.getTitleBarHeight());
      FormSwitchItem localFormSwitchItem = this.this$0.au;
      if (!paramBoolean) {
        localFormSwitchItem.setChecked(bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((CardHandler)this.this$0.app.getBusinessHandler(2)).Ew(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vla
 * JD-Core Version:    0.7.0.1
 */