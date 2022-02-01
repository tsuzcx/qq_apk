import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class tkk
  implements tgc.a
{
  public tkk(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS) {}
  
  public void onResponse(tgc paramtgc)
  {
    int k = -2147483648;
    int i;
    int j;
    if (paramtgc == null)
    {
      i = -2147483648;
      j = -2147483648;
    }
    for (;;)
    {
      i = this.a.getErrorCode(GdtInterstitialFragmentForJS.a(this.a).a.ad, j, i, k);
      GdtInterstitialFragmentForJS.a(this.a, new tgk(i));
      Toast.makeText(this.a.getActivity().getApplicationContext(), String.format("on response:%s", new Object[] { GdtInterstitialFragmentForJS.a(this.a).getErrorMessage() }), 0).show();
      return;
      if (paramtgc.a() == null)
      {
        i = -2147483648;
        j = -2147483648;
      }
      else
      {
        long l = paramtgc.a().timeMillis;
        i = paramtgc.a().httpResponseCode;
        int m;
        if (paramtgc.a().a == null)
        {
          m = -2147483648;
          j = i;
          i = m;
        }
        else
        {
          j = paramtgc.a().a.ret.get();
          if (j != 0)
          {
            m = i;
            i = j;
            j = m;
          }
          else if (paramtgc.a().a.pos_ads_info.size() <= 0)
          {
            m = i;
            i = j;
            j = m;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.a().a.pos_ads_info.get(0)).ret.get();
            if (k != 0)
            {
              m = i;
              i = j;
              j = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.a().a.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              m = i;
              i = j;
              j = m;
            }
            else
            {
              paramtgc = (qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.a().a.pos_ads_info.get(0)).ads_info.get(0);
              GdtInterstitialFragmentForJS.a(this.a).a.ad = new GdtAd(paramtgc);
              GdtInterstitialFragmentForJS.a(this.a, new thm(this.a.getActivity(), GdtInterstitialFragmentForJS.a(this.a)));
              m = i;
              i = j;
              j = m;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkk
 * JD-Core Version:    0.7.0.1
 */