import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vno
  implements View.OnClickListener
{
  public vno(QQBroadcastActivity.a parama, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.v.edit().putBoolean(this.val$key, true).commit();
    this.b.a.handler.sendEmptyMessageDelayed(1010, 1000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vno
 * JD-Core Version:    0.7.0.1
 */