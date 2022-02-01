import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class mvd
  implements ntp.c
{
  mvd(muz parammuz, String paramString) {}
  
  public void aSu()
  {
    QLog.w("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 1, "loadViolaPageFailed");
    if (!TextUtils.isEmpty(this.akr)) {
      if ((SplashActivity.dO == null) || (SplashActivity.dO.get() == null)) {
        break label53;
      }
    }
    label53:
    for (Object localObject = (ContextWrapper)SplashActivity.dO.get();; localObject = BaseApplicationImpl.getContext())
    {
      kxm.a((Context)localObject, this.akr, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvd
 * JD-Core Version:    0.7.0.1
 */