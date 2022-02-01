import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class lff
  implements URLDrawableDownListener
{
  public lff(GifView paramGifView, long paramLong, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, StringBuilder paramStringBuilder, URLDrawable paramURLDrawable) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (GifView.a(this.a))
    {
      if (!GifView.b(this.a)) {
        break label116;
      }
      GifView.a(this.a);
    }
    for (;;)
    {
      QLog.d("gifvideo.GifView", 1, "onLoadFialed! mIsBigImg=" + GifView.b(this.a) + " w=" + GifView.a(this.a) + " h=" + GifView.b(this.a) + " progress: " + this.v);
      paramView = this.a;
      paramView.aOv += 1;
      return;
      label116:
      this.f.restartDownload();
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.v.append(System.currentTimeMillis() + " " + paramInt + " ");
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.val$startTime;
    if (this.i.get() != 0L)
    {
      l1 -= this.i.get();
      if (this.j.longValue() != 0L) {
        break label362;
      }
    }
    label362:
    for (int k = 1;; k = 0)
    {
      QLog.d("gifvideo.GifView", 2, "gif status: " + k + " file size: " + this.q + " download time: " + this.j + " load time: " + l2);
      QLog.d("gifvideo.GifView", 2, "gif status: " + k + " file size: " + this.q + " download time2: " + this.n + " load time2: " + l1);
      kbp.a(null, "", "0X800A148", "0X800A148", 0, k, this.q + "", this.n + "", l1 + "", this.j + " " + l2, false);
      GifView.b(this.a);
      QLog.d("gifvideo.GifView", 1, "onLoadSuccess! mIsBigImg=" + GifView.b(this.a) + " w=" + GifView.a(this.a) + " h=" + GifView.b(this.a) + " progress: " + this.v);
      return;
      l1 = l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lff
 * JD-Core Version:    0.7.0.1
 */