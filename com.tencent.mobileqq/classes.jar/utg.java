import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class utg
  implements AdExposureChecker.ExposureCallback
{
  utg(utf paramutf) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    usw.a(utf.a(this.a), (usv)this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utg
 * JD-Core Version:    0.7.0.1
 */