import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class asbq
  implements HostnameVerifier
{
  asbq(URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$url.getHost(), paramSSLSession);
    if (!bool) {
      QLog.d("OpenSdkVirtualUtil", 1, new Object[] { "OpenVirtual.HostnameVerifier.host:", this.val$url.getHost(), ",address:", paramSSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbq
 * JD-Core Version:    0.7.0.1
 */