import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class allt
  extends BroadcastReceiver
{
  allt(alls paramalls) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.qzonex.localalbum.new_photo_notification_feedback_action".equals(paramIntent.getAction())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzonePhotoGuideNotifyServlet", 2, "QzonePhotoGuideNotifyServlet onReceive");
      }
      if (this.this$0.handler != null) {
        this.this$0.handler.removeCallbacks(this.this$0.hp);
      }
      this.this$0.stopService();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allt
 * JD-Core Version:    0.7.0.1
 */