import android.app.Activity;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import java.lang.ref.WeakReference;

public final class yja
  implements AdCanvasAdapter
{
  public AdError show(AdCanvasAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      yny.d("GdtCanvasAdapter", "show error");
      return new AdError(4);
    }
    GdtCanvasData localGdtCanvasData = ypo.a((GdtAd)GdtAd.class.cast(paramParams.ad), paramParams.autoDownload);
    if ((localGdtCanvasData == null) || (!localGdtCanvasData.isValid()))
    {
      yny.d("GdtCanvasAdapter", "show error");
      return new AdError(4);
    }
    GdtCanvasBaseFragment.start((Activity)paramParams.activity.get(), GdtCanvasFragmentForJS.class, localGdtCanvasData, paramParams.extrasForIntent);
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yja
 * JD-Core Version:    0.7.0.1
 */