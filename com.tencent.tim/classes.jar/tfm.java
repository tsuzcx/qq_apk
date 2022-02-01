import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.gdtad.views.image.GdtGifImageView;
import java.lang.ref.WeakReference;

public class tfm
  implements AdImageViewAdapter
{
  public View buildImageView(AdImageViewAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      WeakReference localWeakReference = new WeakReference(new tfn(this, paramParams));
      return new GdtGifImageView((Context)paramParams.context.get(), paramParams.url, paramParams.guassianUrl, localWeakReference);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfm
 * JD-Core Version:    0.7.0.1
 */