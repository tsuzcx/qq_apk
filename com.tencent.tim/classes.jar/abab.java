import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class abab
  extends BroadcastReceiver
{
  public abab(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "ACTION_SCREEN_OFF == >>");
      }
      this.this$0.pause();
    }
    while (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "ACTION_START_VIDEO_CHAT == >>");
    }
    this.this$0.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abab
 * JD-Core Version:    0.7.0.1
 */