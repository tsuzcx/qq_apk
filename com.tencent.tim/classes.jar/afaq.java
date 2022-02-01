import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class afaq
  implements CompoundButton.OnCheckedChangeListener
{
  public afaq(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.getApplication().getSharedPreferences(acss.bqF, 0).edit().putBoolean(acss.bqG, paramBoolean).commit();
    QQToast.a(this.this$0.getApplicationContext(), acfp.m(2131704692), 1).show();
    if ((this.a instanceof QQAppInterface)) {
      ((QQAppInterface)this.a).exit(false);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afaq
 * JD-Core Version:    0.7.0.1
 */