import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class vpz
  implements AdExposureChecker.ExposureCallback
{
  vpz(vpv paramvpv) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    vpk.a(BaseApplicationImpl.getContext(), vpv.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpz
 * JD-Core Version:    0.7.0.1
 */