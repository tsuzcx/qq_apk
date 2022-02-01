import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;

class aiga
  extends CustomizedDownloader
{
  aiga(aifl paramaifl) {}
  
  public void onDownload(boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    paramBundle = new Bundle();
    paramBundle.putString("url", paramString1);
    paramBundle.putString("path", paramString2);
    aigi.a().a(paramBundle, paramDownloadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiga
 * JD-Core Version:    0.7.0.1
 */