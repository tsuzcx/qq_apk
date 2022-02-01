import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class tmw
  extends Handler
{
  private WeakReference<VideoPlayManager> a;
  
  public tmw(VideoPlayManager paramVideoPlayManager)
  {
    this.a = new WeakReference(paramVideoPlayManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    VideoPlayManager localVideoPlayManager;
    if (this.a != null)
    {
      localVideoPlayManager = (VideoPlayManager)this.a.get();
      if (localVideoPlayManager != null) {
        switch (paramMessage.what)
        {
        }
      }
    }
    do
    {
      return;
      localVideoPlayManager = null;
      break;
    } while ((VideoPlayManager.a(localVideoPlayManager) == null) || (tmx.a(VideoPlayManager.a(localVideoPlayManager)) == null));
    Object localObject = tmx.a(VideoPlayManager.a(localVideoPlayManager));
    paramMessage = VideoPlayManager.a(localVideoPlayManager);
    if ((localObject != null) && (((sdj)localObject).f()))
    {
      long l = ((sdj)localObject).a();
      localObject = VideoPlayManager.a(localVideoPlayManager).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((tmy)((Iterator)localObject).next()).a(paramMessage, tmz.a(l) * 1000);
      }
    }
    VideoPlayManager.a(localVideoPlayManager).sendEmptyMessageDelayed(0, VideoPlayManager.a(localVideoPlayManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmw
 * JD-Core Version:    0.7.0.1
 */