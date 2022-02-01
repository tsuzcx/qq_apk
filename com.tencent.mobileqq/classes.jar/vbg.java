import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class vbg
  implements AdExposureChecker.ExposureCallback
{
  vbg(vbc paramvbc) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    var.a(BaseApplicationImpl.getContext(), vbc.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbg
 * JD-Core Version:    0.7.0.1
 */