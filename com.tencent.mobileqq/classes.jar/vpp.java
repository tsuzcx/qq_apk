import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class vpp
  implements AdExposureChecker.ExposureCallback
{
  vpp(vpo paramvpo) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    vpk.a(vpo.a(this.a), (vpj)this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpp
 * JD-Core Version:    0.7.0.1
 */