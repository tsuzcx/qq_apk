import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;

public class zhf
  implements Runnable
{
  public zhf(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQAppInterface.H();
    QQAppInterface.a(this.a);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qzone.cleanunreadcount");
    localIntentFilter.addAction("com.tecent.qzone.clearAlbumRedTouch");
    QQAppInterface.c(this.a).registerReceiver(QQAppInterface.a(this.a), localIntentFilter);
    VideoBroadcastReceiver.a(this.a);
    if (this.a.e()) {
      PtvTemplateManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhf
 * JD-Core Version:    0.7.0.1
 */