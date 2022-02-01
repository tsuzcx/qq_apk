import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.downloader.GalleryDecoder;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.HashMap;

public class xum
  extends GalleryDecoder
{
  private BaseApplicationImpl c;
  
  public xum(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(BaseApplicationImpl.getContext());
    this.c = paramBaseApplicationImpl;
  }
  
  public Object decodeVideo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i = 0;
    if (paramDownloadParams.tag != null) {
      i = ((Integer)paramDownloadParams.tag).intValue();
    }
    if (i == 3)
    {
      paramURLDrawableHandler = ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
      int j = paramURLDrawableHandler.getWidth();
      i = paramURLDrawableHandler.getHeight();
      float f = Gallery.getAIOImageScale(j, i, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, null);
      j = (int)(j * f);
      i = (int)(i * f);
      return ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
    }
    return null;
  }
  
  public String getLogTag()
  {
    return "PEAK";
  }
  
  public void reportSafeDecode(SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption)
  {
    if ((!paramSafeDecodeOption.isInJustDecodeBounds) && (paramSafeDecodeOption.needRegionDecode))
    {
      HashMap localHashMap = paramSafeDecodeOption.getInfo();
      localHashMap.put("from", "GalleryDecoder");
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "safeDecode", paramSafeDecodeOption.isGetBitmap, paramSafeDecodeOption.runTime, paramSafeDecodeOption.rawHeight * paramSafeDecodeOption.rawWidth, localHashMap, "");
    }
  }
  
  public RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      RoundRectBitmap localRoundRectBitmap = new RoundRectBitmap(paramBitmap, paramInt);
      return localRoundRectBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return new RoundRectBitmap(paramBitmap, 6.0F);
  }
  
  public boolean useJpegTurbo()
  {
    return akyr.asY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xum
 * JD-Core Version:    0.7.0.1
 */