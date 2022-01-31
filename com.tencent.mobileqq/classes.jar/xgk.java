import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class xgk
  implements Downloader.DownloadListener
{
  xgk(xgj paramxgj, xfr paramxfr, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult) {}
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    xgj.a(this.jdField_a_of_type_Xgj, this.jdField_a_of_type_Xfr, xgg.a().b(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgk
 * JD-Core Version:    0.7.0.1
 */