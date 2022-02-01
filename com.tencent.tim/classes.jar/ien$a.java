import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class ien$a
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext sslContext = SSLContext.getInstance("TLS");
  
  public ien$a(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
    try
    {
      paramKeyStore = new ien.c();
      this.sslContext.init(null, new TrustManager[] { paramKeyStore }, null);
      return;
    }
    catch (Exception paramKeyStore)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[cancel] cancel task" + paramKeyStore);
        }
        paramKeyStore = null;
      }
    }
  }
  
  public Socket createSocket()
    throws IOException
  {
    return this.sslContext.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return this.sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ien.a
 * JD-Core Version:    0.7.0.1
 */