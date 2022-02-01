import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class jqb
  implements HostnameVerifier
{
  jqb(URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.b.getHost(), paramSSLSession);
    if (bool) {
      QLog.d("URLUtil", 1, new Object[] { "OpenVirtual.HostnameVerifier.host:", this.b.getHost(), ",address:", paramSSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqb
 * JD-Core Version:    0.7.0.1
 */