import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class trc
  implements ppm
{
  private WeakReference<trb> a;
  
  public trc(trb paramtrb)
  {
    this.a = new WeakReference(paramtrb);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      trb localtrb = (trb)this.a.get();
      if ((localtrb != null) && (trb.a(localtrb) != null)) {
        trb.a(localtrb).post(new VideoAdExposureManager.PosListener.1(this, localtrb, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trc
 * JD-Core Version:    0.7.0.1
 */