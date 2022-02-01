import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class utk
  implements AdExposureChecker.ExposureCallback
{
  utk(uth paramuth) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.w("AdExposureChecker", "onExposure");
    usw.a(this.a.a, uth.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utk
 * JD-Core Version:    0.7.0.1
 */