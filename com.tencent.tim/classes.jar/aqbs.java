import android.graphics.Bitmap;
import com.tencent.gdtad.util.GdtSmartBlur;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class aqbs
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramDownloadParams = paramDownloadParams.tag;
      if ((GdtSmartBlur.a().isLoaded) && ((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 1))
      {
        int i = ((int[])(int[])paramDownloadParams)[0];
        GdtSmartBlur.a().c(paramBitmap, i);
      }
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqbs
 * JD-Core Version:    0.7.0.1
 */