import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.3.1;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.3.2;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.e;
import com.tencent.qphone.base.util.QLog;

public class lfd
  implements ViolaBaseView.e
{
  public lfd(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
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
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.3.2(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reloadPage success!");
    }
  }
  
  public void onError(int paramInt)
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.3.1(this), 1000L);
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyViolaChannelFragment", 2, "reloadPage error,error code=" + paramInt);
    }
  }
  
  public void onProcess(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reloadPage process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */