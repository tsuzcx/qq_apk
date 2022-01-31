import com.tencent.mobileqq.app.I18nTranslatorHandler;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class fda
  implements HostnameVerifier
{
  public fda(I18nTranslatorHandler paramI18nTranslatorHandler) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (paramString.startsWith("https://macqq.translator.qq.com")) || (paramString.startsWith("macqq.translator.qq.com"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fda
 * JD-Core Version:    0.7.0.1
 */