import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class vjy
  implements CompoundButton.OnCheckedChangeListener
{
  public vjy(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.this$0, this.this$0.currentUin, this.this$0.getString(2131718627), "qqsetting_lock_screen_whenexit_key", paramBoolean);
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject, "", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.i("qqls", 4, "collectPerformance qqls setting isChecked=" + paramBoolean);
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ls_setting", paramBoolean + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.this$0.app.getCurrentAccountUin(), "qqlsSettingReprotTag", true, 0L, 0L, (HashMap)localObject, "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjy
 * JD-Core Version:    0.7.0.1
 */