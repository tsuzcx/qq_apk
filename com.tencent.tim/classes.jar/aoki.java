import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class aoki
  extends aoiz
{
  private static final String[] PROJECTION_VIDEO = { "DISTINCT _id", "_data" };
  
  public static URL a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    try
    {
      paramString1 = new URL("devicemsgthumb", "", localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceMsgThumbDownloader", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  public static String processPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.startsWith("file://")) {
        str = paramString.substring("file://".length());
      }
      paramString = str;
    } while (str.startsWith(File.separator));
    return File.separator + str;
  }
  
  public Bitmap L(String paramString)
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
    paramString = "_data='" + processPath(paramString) + "' COLLATE NOCASE";
    return alld.query(BaseApplicationImpl.getContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, paramString, null, null);
  }
  
  @SuppressLint({"NewApi"})
  public Bitmap createVideoThumbnail(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramFile = parseUrl(paramDownloadParams.url);
    if (paramFile == null) {}
    do
    {
      return null;
      if (aqhq.fileExistsAndNotEmpty(paramFile.path)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceMsgThumbDownloader", 2, "decodeFile file not exits. just return");
    return null;
    paramURLDrawableHandler = BaseApplicationImpl.getContext();
    if (ahav.getFileType(paramFile.path) == 2) {}
    for (paramFile = new aoki.b();; paramFile = new aoki.a()) {
      return AlbumThumbManager.getInstance(paramURLDrawableHandler).getThumb(paramDownloadParams.url, paramFile);
    }
  }
  
  public LocalMediaInfo parseUrl(URL paramURL)
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      paramURL = paramURL.getFile().split("\\|");
      localLocalMediaInfo.path = paramURL[0];
      localLocalMediaInfo.thumbWidth = Integer.parseInt(paramURL[1]);
      localLocalMediaInfo.thumbHeight = Integer.parseInt(paramURL[2]);
      return localLocalMediaInfo;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  class a
    implements aoow
  {
    a() {}
    
    public Bitmap getBitmap(URL paramURL)
    {
      LocalMediaInfo localLocalMediaInfo = aoki.this.parseUrl(paramURL);
      if (localLocalMediaInfo == null) {}
      for (;;)
      {
        return null;
        paramURL = new BitmapFactory.Options();
        paramURL.inDensity = 160;
        paramURL.inTargetDensity = 160;
        paramURL.inScreenDensity = 160;
        try
        {
          paramURL = BitmapFactory.decodeFile(localLocalMediaInfo.path, paramURL);
          if (paramURL == null) {
            continue;
          }
          return ThumbnailUtils.extractThumbnail(paramURL, localLocalMediaInfo.thumbWidth, localLocalMediaInfo.thumbHeight, 2);
        }
        catch (OutOfMemoryError paramURL)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VIdeoThumbDownloader", 2, "DeviceImgBitmapDecoder getBitmap", paramURL);
            }
            paramURL = null;
          }
        }
      }
    }
  }
  
  class b
    implements aoow
  {
    b() {}
    
    public Bitmap getBitmap(URL paramURL)
    {
      paramURL = aoki.this.parseUrl(paramURL);
      if (paramURL == null) {
        paramURL = null;
      }
      for (;;)
      {
        return paramURL;
        String str = paramURL.path;
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        try
        {
          Bitmap localBitmap = aoki.this.createVideoThumbnail(str);
          paramURL = localBitmap;
          if (localBitmap == null)
          {
            paramURL = aoki.this.L(str);
            return paramURL;
          }
        }
        catch (Throwable paramURL)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
          }
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoki
 * JD-Core Version:    0.7.0.1
 */