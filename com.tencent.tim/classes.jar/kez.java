import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;

final class kez
  extends aqbn
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    paramDownloadParams = paramBitmap.copy(paramBitmap.getConfig(), true);
    aqmp.fastblur(paramDownloadParams, 40);
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kez
 * JD-Core Version:    0.7.0.1
 */