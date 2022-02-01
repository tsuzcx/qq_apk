import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class aoos
  extends aoiz
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    return new File(acbn.SDCARD_ROOT);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    return AlbumThumbManager.getInstance(BaseApplicationImpl.getContext()).getThumb(paramDownloadParams.url, new aoos.a());
  }
  
  class a
    implements aoow
  {
    a() {}
    
    public Bitmap getBitmap(URL paramURL)
    {
      return ShortVideoUtils.getVideoThumbnail(null, paramURL.getPath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoos
 * JD-Core Version:    0.7.0.1
 */