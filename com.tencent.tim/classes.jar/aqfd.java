import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.atomic.AtomicBoolean;

final class aqfd
  implements aqez.a<T>
{
  aqfd(AtomicBoolean paramAtomicBoolean, akoy paramakoy, aqez.a parama, WebView paramWebView, AnimatorSet paramAnimatorSet) {}
  
  public T a(Bitmap paramBitmap)
  {
    if (this.ef.get())
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish isCanceled");
      this.c.dismiss();
      return null;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "onScreenshotFinish bitmap is null");
      this.c.dismiss();
      return null;
    }
    return this.a.a(paramBitmap);
  }
  
  public void a(T paramT, Bitmap paramBitmap)
  {
    if (this.ef.get())
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap isCanceled");
      this.c.dismiss();
      return;
    }
    if (paramT == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap t is null");
      this.c.dismiss();
      return;
    }
    if (paramBitmap == null)
    {
      QLog.e("ScreenShotUtil", 1, "postBitmap bitmap is null");
      this.c.dismiss();
      this.a.g(new NullPointerException("postBitmap bitmap is null"));
      return;
    }
    if ((this.g.getContext() != null) && (this.c.isShowing()))
    {
      if (this.av.isRunning()) {
        this.av.end();
      }
      this.c.dismiss();
    }
    this.a.a(paramT, paramBitmap);
  }
  
  public void g(Exception paramException)
  {
    this.a.g(paramException);
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfd
 * JD-Core Version:    0.7.0.1
 */