import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class vpy
  implements AdExposureChecker.ExposureCallback
{
  vpy(vpv paramvpv) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.w("AdExposureChecker", "onExposure");
    vpk.a(this.a.a, vpv.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpy
 * JD-Core Version:    0.7.0.1
 */