import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class avrr
  implements Downloader.DownloadListener
{
  avrr(avrq paramavrq, avrq.a parama) {}
  
  public void onDownloadCanceled(String paramString)
  {
    avrq.a(this.jdField_b_of_type_Avrq, false);
    if (avrq.a(this.jdField_b_of_type_Avrq).size() > 0)
    {
      avrq.a locala = (avrq.a)avrq.a(this.jdField_b_of_type_Avrq).get(0);
      avrq.a(this.jdField_b_of_type_Avrq).remove(0);
      avrq.a(this.jdField_b_of_type_Avrq, locala);
    }
    if (this.jdField_b_of_type_Avrq$a.c != null) {
      this.jdField_b_of_type_Avrq$a.c.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    avrq.a(this.jdField_b_of_type_Avrq, false);
    if (avrq.a(this.jdField_b_of_type_Avrq).size() > 0)
    {
      avrq.a locala = (avrq.a)avrq.a(this.jdField_b_of_type_Avrq).get(0);
      avrq.a(this.jdField_b_of_type_Avrq).remove(0);
      avrq.a(this.jdField_b_of_type_Avrq, locala);
    }
    if (this.jdField_b_of_type_Avrq$a.c != null) {
      this.jdField_b_of_type_Avrq$a.c.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_b_of_type_Avrq$a.c != null) {
      this.jdField_b_of_type_Avrq$a.c.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    avrq.a(this.jdField_b_of_type_Avrq, false);
    if (avrq.a(this.jdField_b_of_type_Avrq).size() > 0)
    {
      avrq.a locala = (avrq.a)avrq.a(this.jdField_b_of_type_Avrq).get(0);
      avrq.a(this.jdField_b_of_type_Avrq).remove(0);
      avrq.a(this.jdField_b_of_type_Avrq, locala);
    }
    if (this.jdField_b_of_type_Avrq$a.c != null) {
      this.jdField_b_of_type_Avrq$a.c.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrr
 * JD-Core Version:    0.7.0.1
 */