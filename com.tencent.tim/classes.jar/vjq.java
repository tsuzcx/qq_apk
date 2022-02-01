import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity.a;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import java.util.concurrent.atomic.AtomicBoolean;

public class vjq
  implements CompoundButton.OnCheckedChangeListener
{
  public vjq(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = jqc.getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    Object localObject;
    if (i == 0)
    {
      QQToast.a(this.this$0.getActivity(), 1, 2131698346, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
      localObject = this.this$0;
      if (!paramBoolean) {
        NotifyPushSettingActivity.a((NotifyPushSettingActivity)localObject, bool1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool1 = false;
      break;
      if (NotifyPushSettingActivity.a(this.this$0).compareAndSet(true, true))
      {
        QQToast.a(this.this$0.getActivity(), 1, 2131700455, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
        localObject = this.this$0;
        if (!paramBoolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          NotifyPushSettingActivity.a((NotifyPushSettingActivity)localObject, bool1);
          break;
        }
      }
      NotifyPushSettingActivity.a(this.this$0, paramBoolean);
      if (paramBoolean)
      {
        localObject = acfp.m(2131709175) + NotifyPushSettingActivity.a.aU(3600000L);
        NotifyPushSettingActivity.a(this.this$0).setRightText((CharSequence)localObject);
        NotifyPushSettingActivity.a(this.this$0).set(true);
        long l = NetConnInfoCenter.getServerTime();
        ((CardHandler)this.this$0.app.getBusinessHandler(2)).E((int)(3600L + l), "", "not_disturb_from_notify_push_setting_activity");
        anot.a(this.this$0.app, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, 60L + "", "0", "", "");
      }
      else
      {
        localObject = NotifyPushSettingActivity.a(this.this$0).a().getText().toString();
        NotifyPushSettingActivity.a(this.this$0).a().setText("");
        NotifyPushSettingActivity.a(this.this$0).set(true);
        ((CardHandler)this.this$0.app.getBusinessHandler(2)).E(0, (String)localObject, "not_disturb_from_notify_push_setting_activity");
        anot.a(this.this$0.app, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 2, "0", "0", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjq
 * JD-Core Version:    0.7.0.1
 */