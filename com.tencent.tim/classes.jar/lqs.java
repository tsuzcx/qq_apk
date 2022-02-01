import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class lqs
  implements ljc.c
{
  lqs(lqr paramlqr) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    String str;
    if ((paramBoolean) && (paramInt == 2) && (lqr.a(this.a) != null) && (lqr.a(this.a).mSocialFeedInfo != null))
    {
      lbz.a().ab(lqr.a(lqr.a(this.a)), paramInt);
      str = kxm.a(lqr.a(this.a).mAlgorithmID, kxm.a(lqr.a(this.a)), (int)lqr.a(this.a).mChannelID, 0, 0, aqiw.isWifiConnected(lqr.a(this.a)), lqr.a(lqr.a(this.a)) + "", null, lqr.a(this.a).innerUniqueID, null, lqr.a(this.a));
      if (!odv.aT(lqr.a(this.a).mChannelID)) {
        break label300;
      }
    }
    label300:
    for (paramString = "0X800941D";; paramString = "0X80080EC")
    {
      kbp.a(null, lqr.a(lqr.a(this.a)) + "", paramString, paramString, 0, 0, String.valueOf(lqr.a(this.a).mFeedId), String.valueOf(lqr.a(this.a).mArticleID), Integer.toString(lqr.a(this.a).mStrategyId), str, false);
      ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqs
 * JD-Core Version:    0.7.0.1
 */