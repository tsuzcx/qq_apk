import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class aqof
  implements HostnameVerifier
{
  public aqof(HttpCommunicator paramHttpCommunicator, String paramString, aqog paramaqog) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.cus, paramSSLSession);
    this.this$0.a(this.g, "httpsSSLProcess,HostnameVerifier", "reqhost = " + this.cus + ",address = " + paramSSLSession.getPeerHost() + "result:isverify = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqof
 * JD-Core Version:    0.7.0.1
 */