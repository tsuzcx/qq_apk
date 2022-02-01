import android.content.ComponentName;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy.1.1;

public class rlk
  implements IBinder.DeathRecipient
{
  rlk(rlj paramrlj, ComponentName paramComponentName) {}
  
  public void binderDied()
  {
    rlg.i("RMWServiceProxy", "binderDied, delay 1s then reconnect");
    this.this$0.onServiceDisconnected(this.a);
    new Handler(Looper.getMainLooper()).postDelayed(new RMWServiceProxy.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlk
 * JD-Core Version:    0.7.0.1
 */