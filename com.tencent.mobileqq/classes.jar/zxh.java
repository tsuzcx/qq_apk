import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;

class zxh
  extends bgod
{
  zxh(zxg paramzxg, Downloader.DownloadListener paramDownloadListener, String paramString1, zxi paramzxi, String paramString2, String paramString3) {}
  
  public void onCancel(bgoe parambgoe)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(this.jdField_a_of_type_JavaLangString);
    }
    zxi.a(this.jdField_a_of_type_Zxi, 3);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "onDownloadCanceled" });
  }
  
  public void onDone(bgoe parambgoe)
  {
    if (parambgoe.a == 0)
    {
      boolean bool;
      if (new File(zxg.jdField_a_of_type_JavaLangString).exists())
      {
        bool = FileUtils.unzip(new File(this.jdField_a_of_type_JavaLangString), new File(zxg.jdField_a_of_type_JavaLangString + "/" + this.b));
        if (!bool) {
          break label158;
        }
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
        }
        new File(this.jdField_a_of_type_JavaLangString).delete();
        zxi.a(this.jdField_a_of_type_Zxi, 0);
      }
      for (;;)
      {
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdsuccess:" + bool);
        return;
        label158:
        zxi.a(this.jdField_a_of_type_Zxi, 2);
      }
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
    }
    zxi.a(this.jdField_a_of_type_Zxi, 2);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByIdonDownloadFailed:" });
  }
  
  public void onProgress(bgoe parambgoe)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, 0L, 0.0F);
    }
    zxi.a(this.jdField_a_of_type_Zxi, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxh
 * JD-Core Version:    0.7.0.1
 */