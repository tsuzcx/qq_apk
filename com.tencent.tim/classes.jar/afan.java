import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class afan
  implements RadioGroup.OnCheckedChangeListener
{
  public afan(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime, String paramString) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131366155) {
      DBFixConfigActivity.cPH = 1;
    }
    for (;;)
    {
      this.a.getApplication().getSharedPreferences(DBFixManager.bCE, 0).edit().putInt(this.val$uin + DBFixManager.bCF, DBFixConfigActivity.cPH).commit();
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      if (paramInt == 2131365635) {
        DBFixConfigActivity.cPH = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afan
 * JD-Core Version:    0.7.0.1
 */