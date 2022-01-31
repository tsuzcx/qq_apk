import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class cnw
  extends BroadcastReceiver
{
  public cnw(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onReceive ===>" + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      ShortVideoPlayActivity.c(this.a);
      if (ShortVideoPlayActivity.a(this.a) != null) {
        ShortVideoPlayActivity.a(this.a).setVisibility(0);
      }
      if (ShortVideoPlayActivity.b(this.a) != null) {
        ShortVideoPlayActivity.b(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cnw
 * JD-Core Version:    0.7.0.1
 */