import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.2.1;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.2.2;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

public final class xbw
  implements TVK_ICacheMgr.IPreloadCallback
{
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      xca localxca = xbu.a();
      xbu.a().post(new TVKPreloader.2.2(this, localxca, paramString1, paramInt, paramString2));
      return;
    }
  }
  
  public void onPreLoadSucess(String arg1, String paramString2)
  {
    synchronized ()
    {
      paramString2 = xbu.a();
      xbu.a().post(new TVKPreloader.2.1(this, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbw
 * JD-Core Version:    0.7.0.1
 */