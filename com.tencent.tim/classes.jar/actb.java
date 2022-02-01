import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class actb
  implements View.OnClickListener
{
  actb(acsz paramacsz) {}
  
  public void onClick(View paramView)
  {
    try
    {
      anot.a(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (acsv.Y != null) {
        acsz.a(this.b).startActivity(acsv.Y);
      }
      for (;;)
      {
        this.b.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (acsz.a(this.b) == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(acsz.access$300(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        acsv.cA(acsz.a(this.b));
        acsz.a(this.b).startActivity(acsv.Y);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(acsz.access$300(), 2, "Start Activity Failed");
          acsz.a(this.b).startActivity(aqin.g(acsz.a(this.b)));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(acsz.access$300(), 2, "mAppInterface=null, use default intent");
          }
          acsz.a(this.b).startActivity(aqin.d(acsz.a(this.b)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actb
 * JD-Core Version:    0.7.0.1
 */