import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class ulr
  implements qfo
{
  private WeakReference<ulq> a;
  
  public ulr(ulq paramulq)
  {
    this.a = new WeakReference(paramulq);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      ulq localulq = (ulq)this.a.get();
      if ((localulq != null) && (ulq.a(localulq) != null)) {
        ulq.a(localulq).post(new VideoAdExposureManager.PosListener.1(this, localulq, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulr
 * JD-Core Version:    0.7.0.1
 */