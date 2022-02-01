import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;

public class aokh
  extends aokf
{
  public aokh(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("DataLineFaceDownloader", paramBaseApplicationImpl);
  }
  
  private String E(Context paramContext, String paramString)
  {
    String str = aqhu.b(paramContext, paramString, 0);
    ImageInfo localImageInfo = new ImageInfo();
    aqhu.a(4, paramContext, paramString, str, true, localImageInfo, 0);
    return localImageInfo.filePath;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if ((paramDownloadParams.tag instanceof MessageForPic)) {}
    for (paramDownloadParams = ((MessageForPic)paramDownloadParams.tag).path;; paramDownloadParams = null)
    {
      if (TextUtils.isEmpty(paramDownloadParams)) {}
      File localFile1;
      do
      {
        return null;
        localFile1 = new File(paramDownloadParams);
      } while (!localFile1.exists());
      File localFile2;
      if (localFile1.length() >= 1048576L)
      {
        String str = E(this.b.getApplicationContext(), paramDownloadParams);
        if (!aqhq.fileExists(str)) {
          break label203;
        }
        localFile2 = new File(str);
        QLog.i("DataLineFaceDownloader", 1, "DatalineChat downloadImage compress, orgFilePath:" + paramDownloadParams + " orgFileSize:" + localFile1.length() + " compressPath:" + str + " compressFileSize:" + localFile2.length());
      }
      label203:
      for (paramDownloadParams = localFile2;; paramDownloadParams = localFile1)
      {
        aokf.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        return null;
        QLog.i("DataLineFaceDownloader", 1, "DatalineChat downloadImage uncompress, orgFilePath:" + paramDownloadParams + " orgFileSize:" + localFile1.length());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokh
 * JD-Core Version:    0.7.0.1
 */