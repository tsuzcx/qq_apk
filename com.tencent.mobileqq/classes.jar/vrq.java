import android.os.Handler;
import android.os.Looper;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;

public class vrq
  implements VideoDrawable.OnPlayRepeatListener
{
  AIOGalleryAdapter a;
  
  public vrq(AIOGalleryAdapter paramAIOGalleryAdapter)
  {
    this.a = paramAIOGalleryAdapter;
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new vrr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrq
 * JD-Core Version:    0.7.0.1
 */