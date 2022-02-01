import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class abtt
  extends aquy
{
  abtt(String paramString, File paramFile, abto.e parame) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.val$url + " task.getStatus():" + paramaquz.getStatus());
    }
    if (3 == paramaquz.getStatus()) {
      if (!this.ad.exists()) {}
    }
    while (this.a == null)
    {
      do
      {
        try
        {
          jqp.b(this.ad, this.ad.getParent() + File.separator);
          if (this.a != null) {
            this.a.aR(true, 0);
          }
          return;
        }
        catch (Exception paramaquz)
        {
          for (;;)
          {
            this.ad.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + paramaquz.getMessage());
            }
          }
        }
        catch (OutOfMemoryError paramaquz)
        {
          for (;;)
          {
            this.ad.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + paramaquz.getMessage());
            }
          }
        }
      } while (this.a == null);
      this.a.aR(false, 0);
      return;
    }
    this.a.aR(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtt
 * JD-Core Version:    0.7.0.1
 */