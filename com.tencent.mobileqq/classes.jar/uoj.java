import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;

public class uoj
  implements Runnable
{
  public uoj(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void run()
  {
    Drawable localDrawable1 = DoodleResHelper.a().a(1, DoodleMsgLayout.a(this.a), true);
    if (localDrawable1 != null) {
      ((URLDrawable)localDrawable1).setIndividualPause(true);
    }
    Drawable localDrawable2 = DoodleResHelper.a().a(2, DoodleMsgLayout.a(this.a), false);
    if (localDrawable2 != null) {
      ((URLDrawable)localDrawable2).startDownload();
    }
    new Handler(Looper.getMainLooper()).post(new uok(this, localDrawable1, localDrawable2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uoj
 * JD-Core Version:    0.7.0.1
 */