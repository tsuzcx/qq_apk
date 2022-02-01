import com.tencent.mobileqq.servlet.LoginVerifyServlet.3;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class anej
  implements HostnameVerifier
{
  public anej(LoginVerifyServlet.3 param3, URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$url.getHost(), paramSSLSession);
    if (!bool) {
      QLog.d("LoginVerifyServlet", 1, new Object[] { "OpenVirtual.HostnameVerifier.host:", this.val$url.getHost(), ",address:", paramSSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anej
 * JD-Core Version:    0.7.0.1
 */