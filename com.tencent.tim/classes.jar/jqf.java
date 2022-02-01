import com.tencent.qphone.base.util.QLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class jqf
  implements HostnameVerifier
{
  jqf(String paramString) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$host, paramSSLSession);
    QLog.d("Q.share.sdk", 1, new Object[] { "uploadImageWithHttps|verify hostname=", paramString, ", host=", this.val$host, ", verify=", Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jqf
 * JD-Core Version:    0.7.0.1
 */