import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QZoneShareActivity.22.1;

public class awac
  extends BroadcastReceiver
{
  public awac(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qq.shareupdate".equals(paramIntent.getAction())) {
      ThreadManager.postImmediately(new QZoneShareActivity.22.1(this), null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awac
 * JD-Core Version:    0.7.0.1
 */