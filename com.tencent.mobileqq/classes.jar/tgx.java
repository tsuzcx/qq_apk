import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.8.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class tgx
  implements tpb
{
  public tgx(ViolaFragment paramViolaFragment) {}
  
  public void a()
  {
    this.a.mViolaUiDelegate.b();
    this.a.mViolaUiDelegate.d();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage success!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.getActivity() != null) {}
    for (Looper localLooper = this.a.getActivity().getMainLooper();; localLooper = BaseActivity.sTopActivity.getMainLooper())
    {
      new Handler(localLooper).postDelayed(new ViolaFragment.8.1(this), 1000L);
      if (QLog.isColorLevel()) {
        QLog.e("ViolaFragment", 2, "reloadPage error,error code=" + paramInt);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tgx
 * JD-Core Version:    0.7.0.1
 */