import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.1.1;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class tlp
  implements HippyQQEngine.HippyQQEngineListener
{
  public void onError(int paramInt, String paramString)
  {
    if (this.a.getActivity() != null) {}
    for (Looper localLooper = this.a.getActivity().getMainLooper();; localLooper = BaseActivity.sTopActivity.getMainLooper())
    {
      new Handler(localLooper).postDelayed(new ViolaFragment.1.1(this), 1000L);
      if (QLog.isColorLevel()) {
        QLog.e("ViolaFragment", 2, "initHippy error statusCode=" + paramInt + ", msg=" + paramString);
      }
      return;
    }
  }
  
  public void onSuccess()
  {
    this.a.a.b();
    this.a.a.d();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlp
 * JD-Core Version:    0.7.0.1
 */