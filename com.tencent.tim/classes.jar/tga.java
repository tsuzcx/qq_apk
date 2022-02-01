import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class tga
  implements AdVideoSpliceAdapter
{
  public AdError show(AdVideoSpliceAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      tkw.e("GdtVideoSpliceAdapter", "show error");
      return new AdError(4);
    }
    tkw.i("GdtVideoSpliceAdapter", "show");
    new TransitionContext(paramParams).start();
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tga
 * JD-Core Version:    0.7.0.1
 */