import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class vpu
  implements AdExposureChecker.ExposureCallback
{
  vpu(vpt paramvpt) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    vpk.a(vpt.a(this.a), (vpj)this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpu
 * JD-Core Version:    0.7.0.1
 */