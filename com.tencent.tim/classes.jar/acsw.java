import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class acsw
  implements View.OnClickListener
{
  acsw(acsv paramacsv) {}
  
  public void onClick(View paramView)
  {
    if (acsv.Y != null) {
      acsv.a(this.this$0).startActivity(acsv.Y);
    }
    anot.a(null, "CliOper", "", "", "0X8006B15", "0X8006B15", 0, 0, "", "", "", "");
    anot.a(null, "dc00898", "", "", "0X8009AC8", "0X8009AC8", 0, 0, "", "", "", "");
    Object localObject = PreferenceManager.getDefaultSharedPreferences(acsv.a(this.this$0));
    int i = ((SharedPreferences)localObject).getInt("push_msg_notify_open", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("push_msg_notify_open", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsw
 * JD-Core Version:    0.7.0.1
 */