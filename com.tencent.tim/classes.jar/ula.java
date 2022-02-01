import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils.36.1;
import com.tencent.mobileqq.activity.ChatActivityUtils.36.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class ula
  implements jjw.a
{
  public ula(int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, alkm paramalkm, long paramLong1, Intent paramIntent, long paramLong2, String paramString) {}
  
  public void aA(Context paramContext, String paramString)
  {
    paramString = null;
    if ((this.bFa == 0) && (this.bFb == 3000)) {
      ThreadManager.post(new ChatActivityUtils.36.1(this), 5, null, true);
    }
    int i = this.B.getIntExtra("MultiAVType", 0);
    String str;
    if (i != 2)
    {
      str = this.B.getComponent().getClassName();
      paramString = paramContext.getClass().getName();
      QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, className[" + str + "], contextName[" + paramString + "]");
    }
    for (;;)
    {
      if (i == 2) {
        if (this.val$app.a().i(1, this.kU))
        {
          paramContext = new Intent("tencent.video.q2v.back2VideoRoom");
          this.val$app.getApp().sendBroadcast(paramContext);
        }
      }
      for (;;)
      {
        if (this.bFa == 0) {
          ThreadManager.getFileThreadHandler().post(new ChatActivityUtils.36.2(this));
        }
        return;
        avfh.a(this.val$app, paramContext, this.B, 1);
        continue;
        if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.av.ui.AVActivity")) && (((!TextUtils.isEmpty(paramString)) && (paramString.equals("com.tencent.mobileqq.qcall.QCallDetailActivity"))) || (paramString.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity")) || (paramString.equals("com.tencent.mobileqq.activity.SplashActivity")) || (paramString.equals("com.tencent.mobileqq.activity.recent.RecentT9SearchActivity"))))
        {
          paramString = new Intent(paramContext, AVLoadingDialogActivity.class);
          paramString.putExtra("avactivity_intent", this.B);
          paramString.addFlags(268435456);
          AudioHelper.rw("发起音视频_start_AVLoadingDialogActivity");
          paramContext.startActivity(paramString);
        }
        else
        {
          AudioHelper.rw("发起音视频_start_AVActivity");
          paramContext.startActivity(this.B);
        }
      }
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ula
 * JD-Core Version:    0.7.0.1
 */