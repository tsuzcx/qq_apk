import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class aqcd
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramDownloadParams = paramDownloadParams.tag;
    int i;
    if (((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 1)) {
      i = ((int[])(int[])paramDownloadParams)[0];
    }
    for (paramDownloadParams = aqhu.b(paramBitmap, i, i, i);; paramDownloadParams = null) {
      return paramDownloadParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqcd
 * JD-Core Version:    0.7.0.1
 */