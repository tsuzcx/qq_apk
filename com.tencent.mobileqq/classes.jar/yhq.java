import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class yhq
  extends BroadcastReceiver
{
  public yhq(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(this.a.app.getApp().getPackageName()))) {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + paramContext);
      }
    }
    while ((!paramContext.equals("tencent.av.v2q.StopVideoChat")) || ((paramIntent.getIntExtra("stopReason", 0) != 0) && (paramIntent.getIntExtra("stopReason3rd", -1) != 1)) || (!this.a.a.getBooleanExtra("sendToVideo", false))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "ACTION_STOP_VIDEO_CHAT");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yhq
 * JD-Core Version:    0.7.0.1
 */