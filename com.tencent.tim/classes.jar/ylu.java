import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ylu
  extends BroadcastReceiver
{
  public ylu(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) && (BlessSelectMemberActivity.d(this.this$0) == 9003) && (BlessSelectMemberActivity.e(this.this$0) == 32))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "ACTION_START_VIDEO_CHAT from BLESS_WEB");
      }
      paramContext = new Intent("tencent.video.q2v.startUploadPTV");
      paramContext.putExtra("broadcastType", 1);
      this.this$0.app.getApp().sendBroadcast(paramContext);
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylu
 * JD-Core Version:    0.7.0.1
 */