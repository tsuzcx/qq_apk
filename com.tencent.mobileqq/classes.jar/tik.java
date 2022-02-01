import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class tik
  extends Handler
{
  private WeakReference<VideoPlayManager> a;
  
  public tik(VideoPlayManager paramVideoPlayManager)
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
    } while ((VideoPlayManager.a(localVideoPlayManager) == null) || (til.a(VideoPlayManager.a(localVideoPlayManager)) == null));
    Object localObject = til.a(VideoPlayManager.a(localVideoPlayManager));
    paramMessage = VideoPlayManager.a(localVideoPlayManager);
    if ((localObject != null) && (((rwf)localObject).f()))
    {
      long l = ((rwf)localObject).a();
      localObject = VideoPlayManager.a(localVideoPlayManager).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((tim)((Iterator)localObject).next()).a(paramMessage, tin.a(l) * 1000);
      }
    }
    VideoPlayManager.a(localVideoPlayManager).sendEmptyMessageDelayed(0, VideoPlayManager.a(localVideoPlayManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tik
 * JD-Core Version:    0.7.0.1
 */