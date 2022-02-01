import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.e;
import com.tencent.qphone.base.util.QLog;

public class lfc
  implements ViolaBaseView.e
{
  public lfc(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void aF(String paramString, int paramInt)
  {
    if ((1 == paramInt) && (kyo.Bg())) {
      lcc.a().aJJ();
    }
  }
  
  public void aLD()
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.2.1(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "initViola success!");
    }
    if ((ReadInJoyViolaChannelFragment.a(this.a) != null) && (ReadInJoyViolaChannelFragment.a(this.a).Gm()) && (this.a.BR()) && (ReadinjoyTabFrame.Dx())) {
      ReadInJoyViolaChannelFragment.a(this.a).qg(true);
    }
  }
  
  public void onError(int paramInt)
  {
    ReadInJoyViolaChannelFragment.a(this.a);
    ReadInJoyViolaChannelFragment.a(this.a).bbB();
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyViolaChannelFragment", 2, "initViola error,error code=" + paramInt);
    }
  }
  
  public void onProcess(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "initViola process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfc
 * JD-Core Version:    0.7.0.1
 */