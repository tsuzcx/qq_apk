import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

class ieo
  implements X509HostnameVerifier
{
  private X509HostnameVerifier c = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
  
  ieo(ien paramien) {}
  
  public void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.c.verify(str, paramX509Certificate);
  }
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.c.verify(str, paramSSLSocket);
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.c.verify(str, paramArrayOfString1, paramArrayOfString2);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "[AsyncHttpClient] host:" + paramString);
    }
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    return this.c.verify(str, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ieo
 * JD-Core Version:    0.7.0.1
 */