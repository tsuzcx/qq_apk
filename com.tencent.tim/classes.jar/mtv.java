import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class mtv
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(mtu.access$000(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((mtu.a().get() == 0) && (mtu.b().get() < mtu.access$300()))
      {
        mtu.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        mtu.a().set(1);
        mtu.b().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(mtu.access$000(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (mtu.a().get() != 1);
    if ((mtu.b() != null) && (mtu.b().isAlive())) {
      mtu.b().interrupt();
    }
    mtu.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtv
 * JD-Core Version:    0.7.0.1
 */