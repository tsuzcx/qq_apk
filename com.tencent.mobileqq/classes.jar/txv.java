import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class txv
  implements puu
{
  private WeakReference<txu> a;
  
  public txv(txu paramtxu)
  {
    this.a = new WeakReference(paramtxu);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      txu localtxu = (txu)this.a.get();
      if ((localtxu != null) && (txu.a(localtxu) != null)) {
        txu.a(localtxu).post(new VideoAdExposureManager.PosListener.1(this, localtxu, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txv
 * JD-Core Version:    0.7.0.1
 */