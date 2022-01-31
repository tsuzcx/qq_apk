import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;

public class urh
  implements Runnable
{
  public urh(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void run()
  {
    Bitmap localBitmap = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838601);
    if ((localBitmap != null) && (BaseApplicationImpl.sImageCache != null)) {
      BaseApplicationImpl.sImageCache.put("aio_doodle_progress", localBitmap, (byte)0);
    }
    new Handler(Looper.getMainLooper()).post(new uri(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urh
 * JD-Core Version:    0.7.0.1
 */