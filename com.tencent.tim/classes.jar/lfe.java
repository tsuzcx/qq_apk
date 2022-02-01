import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class lfe
  implements URLDrawable.DownloadListener
{
  public lfe(GifView paramGifView, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, long paramLong, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (GifView.a(this.a))
    {
      if (!GifView.b(this.a)) {
        break label104;
      }
      GifView.a(this.a);
    }
    for (;;)
    {
      QLog.d("gifvideo.GifView", 1, "onLoadFialed! mIsBigImg=" + GifView.b(this.a) + " w=" + GifView.a(this.a) + " h=" + GifView.b(this.a));
      GifView localGifView = this.a;
      localGifView.aOv += 1;
      return;
      label104:
      this.f.restartDownload();
    }
  }
  
  public void onFileDownloadStarted()
  {
    this.i.set(System.currentTimeMillis());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.j.set(System.currentTimeMillis() - this.val$startTime);
    this.n.set(System.currentTimeMillis() - this.i.get());
    this.q.set(paramLong);
    QLog.d("gifvideo.GifView", 1, "gif download success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfe
 * JD-Core Version:    0.7.0.1
 */