import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class aoke
  extends aolf
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    paramDownloadParams.url = new URL(paramDownloadParams.url.getFile());
    paramDownloadParams.urlStr = paramDownloadParams.url.toString();
    return super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramURLDrawableHandler = new BitmapFactory.Options();
    paramURLDrawableHandler.inJustDecodeBounds = true;
    paramDownloadParams = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramURLDrawableHandler);
    float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    paramURLDrawableHandler.inSampleSize = (Math.min(paramURLDrawableHandler.outWidth, paramURLDrawableHandler.outHeight) / (int)(f * 70.0F + 0.5F));
    paramURLDrawableHandler.inJustDecodeBounds = false;
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramURLDrawableHandler);
      return aqhu.r(aqhu.P(paramFile), 70, 70);
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        paramFile = paramDownloadParams;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoke
 * JD-Core Version:    0.7.0.1
 */