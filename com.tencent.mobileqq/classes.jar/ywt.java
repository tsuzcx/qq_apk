import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

class ywt
  implements ytb
{
  ywt(ywq paramywq) {}
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    yxs.b("GdtBaseBannerFragment", String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(this.a.getActivity().getApplicationContext(), String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, yta paramyta)
  {
    yxs.d("GdtBaseBannerFragment", "onAdFailedToLoad " + paramyta.a());
    Toast.makeText(this.a.getActivity().getApplicationContext(), "onAdFailedToLoad " + paramyta.a(), 0).show();
  }
  
  public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    yxs.b("GdtBaseBannerFragment", String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(this.a.getActivity().getApplicationContext(), String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    yxs.b("GdtBaseBannerFragment", String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(this.a.getActivity().getApplicationContext(), String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    yxs.b("GdtBaseBannerFragment", String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(this.a.getActivity().getApplicationContext(), String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywt
 * JD-Core Version:    0.7.0.1
 */