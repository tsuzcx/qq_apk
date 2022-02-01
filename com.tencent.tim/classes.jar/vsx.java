import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoConstants;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vsx
  implements View.OnClickListener
{
  public vsx(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.bVj();
    long l2 = 0L;
    long l1 = l2;
    if (this.a.mIp != null)
    {
      l1 = l2;
      if (!this.a.mIp.isEmpty()) {
        l1 = jkw.C(this.a.mIp);
      }
    }
    SharedPreferences localSharedPreferences = aqmj.i(this.a.mSelfUin);
    l2 = localSharedPreferences.getLong("qav_roomid", 0L);
    long l3 = localSharedPreferences.getLong(VideoConstants.Mg, 0L);
    anpa.a(this.a.mApp, this.a.mBeginTime, this.a.mEndTime, this.a.GQ, this.a.GR, this.a.GS, this.a.mSdkVersion, l3, l1, l2, this.a.mToUin, this.a.aPM);
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "reportEvent beginTime: " + this.a.mBeginTime + ", endTime: " + this.a.mEndTime + ", sdkVersion: " + this.a.mSdkVersion + ", peerSdkVersion: " + l3 + ", bussinessType: " + this.a.GQ + ", bussinessFlag: " + this.a.GR + ", ip: " + this.a.mIp + ", toUin: " + this.a.mToUin + ", score: " + this.a.GS + ", problems: " + this.a.aPM);
    }
    localSharedPreferences.edit().putBoolean(VideoConstants.Ml, true).commit();
    if (this.a.GT != 0L) {}
    try
    {
      this.a.mApp.b().t(this.a.mToUin, this.a.mUinType, this.a.GT);
      this.a.getActivity().finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScoreActivity", 2, "removeMsgByUniseq : " + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsx
 * JD-Core Version:    0.7.0.1
 */