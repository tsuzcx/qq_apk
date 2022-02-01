import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class tsb
  implements tpb
{
  public tsb(ReadinjoyAdHippyFragment paramReadinjoyAdHippyFragment) {}
  
  public void a()
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadinjoyAdHippyFragment.2.1(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "initViola success!");
    }
    if ((this.a.a != null) && (this.a.a.c()) && (this.a.c()) && (ReadinjoyTabFrame.d_())) {
      this.a.a.a(true);
    }
  }
  
  public void a(int paramInt)
  {
    ReadinjoyAdHippyFragment.a(this.a);
    ReadinjoyAdHippyFragment.a(this.a).c();
    if (QLog.isColorLevel()) {
      QLog.e("ReadinjoyAdMiniGameFragment", 2, "initViola error,error code=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((1 == paramInt) && (pch.a())) {
      pkp.a().l();
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "initViola process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsb
 * JD-Core Version:    0.7.0.1
 */