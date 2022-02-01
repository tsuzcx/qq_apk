package btmsdkobf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tmsdk.base.utils.MD5Util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.GregorianCalendar;
import java.util.Properties;

public class bg
{
  private static final long fJ = new GregorianCalendar(2040, 0, 1).getTimeInMillis() / 1000L;
  private Properties fK;
  boolean fL = false;
  private Context mContext;
  
  bg(Properties paramProperties, Context paramContext)
  {
    this.fK = paramProperties;
    this.mContext = paramContext;
  }
  
  private String j(String paramString)
  {
    Object localObject3 = this.mContext.getPackageManager();
    String str2 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      paramString = ((PackageManager)localObject3).getPackageInfo(paramString, 64);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    String str1;
    if (paramString != null)
    {
      localObject3 = new ByteArrayInputStream(paramString.signatures[0].toByteArray());
      localObject1 = localObject2;
      paramString = str2;
      try
      {
        str2 = MD5Util.encrypt_bytes(((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate((InputStream)localObject3)).getEncoded());
        localObject1 = str2;
        paramString = str2;
        ((ByteArrayInputStream)localObject3).close();
        return str2;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return localObject1;
      }
      catch (CertificateException localCertificateException)
      {
        localCertificateException.printStackTrace();
        str1 = paramString;
      }
    }
    return str1;
  }
  
  public long A()
  {
    String str = Long.toString(fJ);
    return Long.parseLong(this.fK.getProperty("expiry.seconds", str));
  }
  
  public String getChannel()
  {
    return this.fK.getProperty("lc_sdk_channel");
  }
  
  public boolean z()
  {
    if (this.fL) {
      return true;
    }
    Object localObject = j(this.mContext.getPackageName());
    if (localObject == null) {
      return true;
    }
    String str = this.fK.getProperty("signature").toUpperCase().trim();
    this.fL = ((String)localObject).equals(str);
    if (!this.fL)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("your    signature is ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" len:");
      localStringBuilder.append(((String)localObject).length());
      eg.f("DEBUG", localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("licence signature is ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" len:");
      ((StringBuilder)localObject).append(str.length());
      eg.f("DEBUG", ((StringBuilder)localObject).toString());
    }
    return this.fL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bg
 * JD-Core Version:    0.7.0.1
 */