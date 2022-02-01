import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class vbf
  implements AdExposureChecker.ExposureCallback
{
  vbf(vbc paramvbc) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.w("AdExposureChecker", "onExposure");
    var.a(this.a.a, vbc.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbf
 * JD-Core Version:    0.7.0.1
 */