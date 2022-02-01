import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Thumbnails;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class aoot
  extends aoiz
{
  private static final String[] PROJECTION_VIDEO = { "DISTINCT _id", "_data" };
  
  private Bitmap L(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (Build.VERSION.SDK_INT < 5)
    {
      localObject = localCursor;
      label17:
      return localObject;
    }
    try
    {
      localCursor = b(paramString);
      paramString = (String)localObject;
      if (localCursor != null) {
        paramString = (String)localObject;
      }
    }
    finally
    {
      try
      {
        if (localCursor.getCount() > 0)
        {
          long l = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
          paramString = (String)localObject;
          if (localCursor.moveToFirst()) {
            paramString = MediaStore.Video.Thumbnails.getThumbnail(BaseApplicationImpl.getContext().getContentResolver(), l, 1, null);
          }
        }
        localObject = paramString;
        if (localCursor == null) {
          break label17;
        }
        localCursor.close();
        return paramString;
      }
      finally
      {
        break label112;
      }
      paramString = finally;
      localCursor = null;
    }
    label112:
    if (localCursor != null) {
      localCursor.close();
    }
    throw paramString;
  }
  
  @SuppressLint({"NewApi"})
  private Bitmap createVideoThumbnail(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    return new File(acbn.SDCARD_ROOT);
  }
  
  public boolean azK()
  {
    return false;
  }
  
  public Cursor b(String paramString)
  {
    paramString = "_data='" + aoki.processPath(paramString) + "' COLLATE NOCASE";
    return alld.query(BaseApplicationImpl.getContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, paramString, null, null);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    return AlbumThumbManager.getInstance(BaseApplicationImpl.getContext()).getThumb(paramDownloadParams.url, new aoot.a());
  }
  
  class a
    implements aoow
  {
    a() {}
    
    public Bitmap getBitmap(URL paramURL)
    {
      String str = paramURL.getPath();
      try
      {
        Bitmap localBitmap = aoot.a(aoot.this, str);
        paramURL = localBitmap;
        if (localBitmap == null) {
          paramURL = aoot.b(aoot.this, str);
        }
        return paramURL;
      }
      catch (Throwable paramURL)
      {
        QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoot
 * JD-Core Version:    0.7.0.1
 */