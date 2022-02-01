import com.tencent.qphone.base.util.QLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class jqe
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify("cgi.connect.qq.com", paramSSLSession);
    QLog.d("Q.share.sdk", 1, new Object[] { "queryImageByIP|verify hostname=", paramString, ", host=", "cgi.connect.qq.com", ", verify=", Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jqe
 * JD-Core Version:    0.7.0.1
 */