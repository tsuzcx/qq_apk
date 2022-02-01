import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class usk
  implements AdExposureChecker.ExposureCallback
{
  usk(usg paramusg) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    urv.a(BaseApplicationImpl.getContext(), usg.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usk
 * JD-Core Version:    0.7.0.1
 */