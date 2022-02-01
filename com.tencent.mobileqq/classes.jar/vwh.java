import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class vwh
  implements Downloader.DownloadListener
{
  vwh(vwg paramvwg, vwi paramvwi) {}
  
  public void onDownloadCanceled(String paramString)
  {
    vwg.a(this.jdField_a_of_type_Vwg, false);
    if (vwg.a(this.jdField_a_of_type_Vwg).size() > 0)
    {
      vwi localvwi = (vwi)vwg.a(this.jdField_a_of_type_Vwg).get(0);
      vwg.a(this.jdField_a_of_type_Vwg).remove(0);
      vwg.a(this.jdField_a_of_type_Vwg, localvwi);
    }
    if (this.jdField_a_of_type_Vwi.a != null) {
      this.jdField_a_of_type_Vwi.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    vwg.a(this.jdField_a_of_type_Vwg, false);
    if (vwg.a(this.jdField_a_of_type_Vwg).size() > 0)
    {
      vwi localvwi = (vwi)vwg.a(this.jdField_a_of_type_Vwg).get(0);
      vwg.a(this.jdField_a_of_type_Vwg).remove(0);
      vwg.a(this.jdField_a_of_type_Vwg, localvwi);
    }
    if (this.jdField_a_of_type_Vwi.a != null) {
      this.jdField_a_of_type_Vwi.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Vwi.a != null) {
      this.jdField_a_of_type_Vwi.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    vwg.a(this.jdField_a_of_type_Vwg, false);
    if (vwg.a(this.jdField_a_of_type_Vwg).size() > 0)
    {
      vwi localvwi = (vwi)vwg.a(this.jdField_a_of_type_Vwg).get(0);
      vwg.a(this.jdField_a_of_type_Vwg).remove(0);
      vwg.a(this.jdField_a_of_type_Vwg, localvwi);
    }
    if (this.jdField_a_of_type_Vwi.a != null) {
      this.jdField_a_of_type_Vwi.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwh
 * JD-Core Version:    0.7.0.1
 */