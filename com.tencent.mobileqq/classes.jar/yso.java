import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class yso
  implements AdVideoSpliceAdapter
{
  public AdError show(AdVideoSpliceAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      yxs.d("GdtVideoSpliceAdapter", "show error");
      return new AdError(4);
    }
    yxs.b("GdtVideoSpliceAdapter", "show");
    new TransitionContext(paramParams).b();
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yso
 * JD-Core Version:    0.7.0.1
 */