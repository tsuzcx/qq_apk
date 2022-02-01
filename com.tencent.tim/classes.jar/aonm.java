import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class aonm
  extends aoiz
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean azK()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    localOptions.inJustDecodeBounds = false;
    String str = paramFile.getAbsolutePath();
    if (!aqhq.fileExistsAndNotEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForPicThumbDownloader", 2, "decodeFile file not exits. just return");
      }
      return null;
    }
    paramURLDrawableHandler = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    SafeBitmapFactory.decodeFile(str, localOptions);
    paramDownloadParams = ThumbWidthHeightDP.resizeAndClipBitmap(paramURLDrawableHandler, paramDownloadParams, ThumbWidthHeightDP.getThumbWidthHeightDP(false), false);
    if (!paramURLDrawableHandler.equals(paramDownloadParams.mBitmap)) {
      paramURLDrawableHandler.recycle();
    }
    paramFile = new RoundRectBitmap(new aooy(paramFile.getAbsolutePath()).Q(paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
    paramFile.mDisplayWidth = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    paramFile.mDisplayHeight = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels;
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonm
 * JD-Core Version:    0.7.0.1
 */