import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;

class awlm
  implements Downloader.DownloadListener
{
  awlm(awll paramawll, awkt paramawkt, String paramString1, String paramString2, aeoq.a parama) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadCanceled = " + paramString);
    if (this.jdField_a_of_type_Awkt != null) {
      this.jdField_a_of_type_Awkt.abT("download canceld url = " + paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadFailed = " + paramString);
    if (this.jdField_a_of_type_Awkt != null) {
      this.jdField_a_of_type_Awkt.abT("download fail url = " + paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadSucceed = " + paramString);
    paramString = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(this.zx.hashCode()));
    paramDownloadResult = arwv.encodeFileHexStr(this.vi);
    if (this.jdField_a_of_type_Aeoq$a != null) {
      QZLog.i("VipARQGLoaderManager", 1, "download fileMD5 = " + paramDownloadResult + " config.md5 = " + this.jdField_a_of_type_Aeoq$a.md5);
    }
    if ((this.jdField_a_of_type_Aeoq$a != null) && (!TextUtils.isEmpty(paramDownloadResult)) && (paramDownloadResult.equalsIgnoreCase(this.jdField_a_of_type_Aeoq$a.md5)))
    {
      paramDownloadResult = new File(this.vi);
      QzoneZipCacheHelper.unzipFile(paramDownloadResult.getAbsolutePath(), paramString);
      if (paramDownloadResult.exists()) {
        ahbj.deleteFile(paramDownloadResult);
      }
      if (new File(paramString).exists())
      {
        QZLog.i("VipARQGLoaderManager", 1, "download success file exist start put to map = " + paramString);
        awll.a(this.this$0).put(this.zx, paramString);
        if (this.jdField_a_of_type_Awkt != null) {
          this.jdField_a_of_type_Awkt.abS(paramString);
        }
      }
    }
    while (this.jdField_a_of_type_Awkt == null)
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Awkt == null);
      this.jdField_a_of_type_Awkt.abT("download success but the file is not exist");
      return;
    }
    this.jdField_a_of_type_Awkt.abT("download success but the file md5 is not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlm
 * JD-Core Version:    0.7.0.1
 */