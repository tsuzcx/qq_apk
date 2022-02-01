import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class acsx
  implements View.OnClickListener
{
  acsx(acsv paramacsv) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "CliOper", "", "", "0X8006B16", "0X8006B16", 0, 0, "", "", "", "");
    anot.a(null, "dc00898", "", "", "0X8009AC9", "0X8009AC9", 0, 0, "", "", "", "");
    Object localObject = PreferenceManager.getDefaultSharedPreferences(acsv.a(this.this$0));
    int i = ((SharedPreferences)localObject).getInt("push_msg_notify_cancle", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("push_msg_notify_cancle", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsx
 * JD-Core Version:    0.7.0.1
 */