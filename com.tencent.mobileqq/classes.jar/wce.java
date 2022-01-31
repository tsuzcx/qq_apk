import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class wce
  extends BroadcastReceiver
{
  public wce(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) && (BlessSelectMemberActivity.c(this.a) == 9003) && (BlessSelectMemberActivity.d(this.a) == 32))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "ACTION_START_VIDEO_CHAT from BLESS_WEB");
      }
      paramContext = new Intent("tencent.video.q2v.startUploadPTV");
      paramContext.putExtra("broadcastType", 1);
      this.a.app.getApp().sendBroadcast(paramContext);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wce
 * JD-Core Version:    0.7.0.1
 */