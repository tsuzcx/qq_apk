import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.5.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.e;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class ntz
  implements ViolaBaseView.e
{
  public ntz(ViolaFragment paramViolaFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void aF(String paramString, int paramInt) {}
  
  public void aLD()
  {
    this.b.a.hideProgressBar();
    this.b.a.bbC();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage success!");
    }
  }
  
  public void onError(int paramInt)
  {
    if (this.b.getActivity() != null) {}
    for (Looper localLooper = this.b.getActivity().getMainLooper();; localLooper = BaseActivity.sTopActivity.getMainLooper())
    {
      new Handler(localLooper).postDelayed(new ViolaFragment.5.1(this), 1000L);
      if (QLog.isColorLevel()) {
        QLog.e("ViolaFragment", 2, "reloadPage error,error code=" + paramInt);
      }
      return;
    }
  }
  
  public void onProcess(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntz
 * JD-Core Version:    0.7.0.1
 */