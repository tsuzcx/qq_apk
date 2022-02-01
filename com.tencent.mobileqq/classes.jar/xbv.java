import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.1.1;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;

public final class xbv
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  public void onComplete(String arg1, String paramString2)
  {
    synchronized ()
    {
      paramString2 = xbu.a();
      xbu.a().post(new TVKPreloader.1.1(this, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbv
 * JD-Core Version:    0.7.0.1
 */