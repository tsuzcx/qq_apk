import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.lang.ref.WeakReference;

public class tfs
  implements AdQQMINIProgramAdapter
{
  public AdError show(AdQQMINIProgramAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      tkw.e("GdtQQMINIProgramAdapter", "show error");
      return new AdError(4);
    }
    GdtAd localGdtAd = (GdtAd)GdtAd.class.cast(paramParams.ad);
    tkw.i("GdtQQMINIProgramAdapter", String.format("show %s", new Object[] { localGdtAd.getUrlForLandingPage() }));
    MiniAppLauncher.startMiniApp((Context)paramParams.context.get(), localGdtAd.getUrlForLandingPage(), 2054, new tft(this));
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfs
 * JD-Core Version:    0.7.0.1
 */