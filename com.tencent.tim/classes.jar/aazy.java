import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;

public class aazy
  extends BroadcastReceiver
{
  public aazy(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onReceive ===>" + paramContext);
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      if ((this.this$0.fa != null) && (this.this$0.fa.get() != null) && (((ISuperPlayer)this.this$0.fa.get()).isPlaying())) {
        this.this$0.bBu = true;
      }
      this.this$0.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazy
 * JD-Core Version:    0.7.0.1
 */