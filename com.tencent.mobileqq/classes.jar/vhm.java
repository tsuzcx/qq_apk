import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class vhm
  implements Downloader.DownloadListener
{
  vhm(vhl paramvhl, vhn paramvhn) {}
  
  public void onDownloadCanceled(String paramString)
  {
    vhl.a(this.jdField_a_of_type_Vhl, false);
    if (vhl.a(this.jdField_a_of_type_Vhl).size() > 0)
    {
      vhn localvhn = (vhn)vhl.a(this.jdField_a_of_type_Vhl).get(0);
      vhl.a(this.jdField_a_of_type_Vhl).remove(0);
      vhl.a(this.jdField_a_of_type_Vhl, localvhn);
    }
    if (this.jdField_a_of_type_Vhn.a != null) {
      this.jdField_a_of_type_Vhn.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    vhl.a(this.jdField_a_of_type_Vhl, false);
    if (vhl.a(this.jdField_a_of_type_Vhl).size() > 0)
    {
      vhn localvhn = (vhn)vhl.a(this.jdField_a_of_type_Vhl).get(0);
      vhl.a(this.jdField_a_of_type_Vhl).remove(0);
      vhl.a(this.jdField_a_of_type_Vhl, localvhn);
    }
    if (this.jdField_a_of_type_Vhn.a != null) {
      this.jdField_a_of_type_Vhn.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Vhn.a != null) {
      this.jdField_a_of_type_Vhn.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    vhl.a(this.jdField_a_of_type_Vhl, false);
    if (vhl.a(this.jdField_a_of_type_Vhl).size() > 0)
    {
      vhn localvhn = (vhn)vhl.a(this.jdField_a_of_type_Vhl).get(0);
      vhl.a(this.jdField_a_of_type_Vhl).remove(0);
      vhl.a(this.jdField_a_of_type_Vhl, localvhn);
    }
    if (this.jdField_a_of_type_Vhn.a != null) {
      this.jdField_a_of_type_Vhn.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhm
 * JD-Core Version:    0.7.0.1
 */