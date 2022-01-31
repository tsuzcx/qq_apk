import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public final class bhr
  implements X509HostnameVerifier
{
  public void verify(String paramString, X509Certificate paramX509Certificate) {}
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
  {
    if (paramString.startsWith("macqq.translator.qq.com")) {
      return;
    }
    throw new IOException("Mismatched host :" + paramString);
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return paramString.startsWith("https://macqq.translator.qq.com");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhr
 * JD-Core Version:    0.7.0.1
 */