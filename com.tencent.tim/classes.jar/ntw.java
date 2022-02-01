import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.e;
import com.tencent.qphone.base.util.QLog;

public class ntw
  implements ViolaBaseView.e
{
  public ntw(ViolaFragment paramViolaFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((this.b.a.Gh()) && (paramBoolean))
    {
      if (Math.abs(paramInt1) < this.b.a.qY() / 2) {
        break label79;
      }
      if (!ViolaFragment.a(this.b))
      {
        this.b.h(Boolean.valueOf(false));
        aafx.setStatusBarDarkIcon(this.b.getActivity(), true);
        ViolaFragment.a(this.b, true);
      }
    }
    label79:
    while (!ViolaFragment.a(this.b)) {
      return;
    }
    this.b.h(Boolean.valueOf(true));
    aafx.setStatusBarDarkIcon(this.b.getActivity(), false);
    ViolaFragment.a(this.b, false);
  }
  
  public void aF(String paramString, int paramInt) {}
  
  public void aLD()
  {
    this.b.a.hideProgressBar();
    this.b.a.bbC();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola success!");
    }
  }
  
  public void onError(int paramInt)
  {
    this.b.a.hideProgressBar();
    this.b.a.bbB();
    if (QLog.isColorLevel()) {
      QLog.e("ViolaFragment", 2, "initViola error,error code=" + paramInt);
    }
  }
  
  public void onProcess(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntw
 * JD-Core Version:    0.7.0.1
 */