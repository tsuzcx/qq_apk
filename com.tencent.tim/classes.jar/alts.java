import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

public class alts
  extends aoiz
{
  protected BaseApplicationImpl b;
  
  public alts(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.b = paramBaseApplicationImpl;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if ((paramDownloadParams != null) && (paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      paramOutputStream = (String)paramDownloadParams.tag;
      paramDownloadParams = aqul.getSDKPrivatePath(acbn.oM);
      try
      {
        paramDownloadParams = new File(paramDownloadParams);
        paramDownloadParams.mkdirs();
        paramDownloadParams = new File(paramDownloadParams, Utils.Crc64String(paramOutputStream));
        if (paramDownloadParams.exists()) {
          return paramDownloadParams;
        }
        int i = aqva.a(new aquz(paramOutputStream, paramDownloadParams), null);
        if (i == 0) {
          return paramDownloadParams;
        }
      }
      catch (Exception paramOutputStream)
      {
        QLog.e("AbsDownloader", 1, "download exception " + paramOutputStream);
      }
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if ((paramDownloadParams != null) && (paramFile != null))
    {
      paramDownloadParams = paramDownloadParams.getHeader("isCircle");
      if (paramDownloadParams != null)
      {
        paramDownloadParams = paramDownloadParams.getValue();
        if (!TextUtils.isEmpty(paramDownloadParams))
        {
          int j = Integer.valueOf(paramDownloadParams).intValue();
          int i = 90;
          if (this.b != null) {
            i = aqcx.dip2px(this.b, 30.0F);
          }
          paramDownloadParams = aqhu.m(paramFile.getAbsolutePath(), i, i);
          paramFile = paramDownloadParams;
          if (j == 1)
          {
            if (paramDownloadParams != null) {
              paramFile = aqhu.b(paramDownloadParams, paramDownloadParams.getWidth(), paramDownloadParams.getWidth(), paramDownloadParams.getHeight());
            }
          }
          else {
            return paramFile;
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alts
 * JD-Core Version:    0.7.0.1
 */