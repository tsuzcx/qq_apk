package btmsdkobf;

import android.content.Context;
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
  
  /* Error */
  private String j(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	btmsdkobf/bg:mContext	Landroid/content/Context;
    //   4: invokevirtual 52	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: bipush 64
    //   12: invokevirtual 58	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +81 -> 98
    //   20: new 60	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_1
    //   25: getfield 66	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   28: iconst_0
    //   29: aaload
    //   30: invokevirtual 72	android/content/pm/Signature:toByteArray	()[B
    //   33: invokespecial 75	java/io/ByteArrayInputStream:<init>	([B)V
    //   36: astore_2
    //   37: ldc 77
    //   39: invokestatic 83	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   42: aload_2
    //   43: invokevirtual 87	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   46: checkcast 89	java/security/cert/X509Certificate
    //   49: invokevirtual 92	java/security/cert/X509Certificate:getEncoded	()[B
    //   52: invokestatic 98	com/tmsdk/base/utils/MD5Util:encrypt_bytes	([B)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_2
    //   57: invokevirtual 101	java/io/ByteArrayInputStream:close	()V
    //   60: aload_1
    //   61: areturn
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -53 -> 16
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 105	java/security/cert/CertificateException:printStackTrace	()V
    //   79: aload_1
    //   80: areturn
    //   81: astore_2
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_2
    //   85: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   88: aload_1
    //   89: areturn
    //   90: astore_2
    //   91: goto -7 -> 84
    //   94: astore_2
    //   95: goto -20 -> 75
    //   98: aconst_null
    //   99: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	bg
    //   0	100	1	paramString	String
    //   7	50	2	localObject	Object
    //   72	4	2	localCertificateException1	java.security.cert.CertificateException
    //   81	4	2	localIOException1	java.io.IOException
    //   90	1	2	localIOException2	java.io.IOException
    //   94	1	2	localCertificateException2	java.security.cert.CertificateException
    // Exception table:
    //   from	to	target	type
    //   8	16	62	java/lang/Exception
    //   37	56	72	java/security/cert/CertificateException
    //   37	56	81	java/io/IOException
    //   56	60	90	java/io/IOException
    //   56	60	94	java/security/cert/CertificateException
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
    if (this.fL) {}
    String str1;
    do
    {
      return true;
      str1 = j(this.mContext.getPackageName());
    } while (str1 == null);
    String str2 = this.fK.getProperty("signature").toUpperCase().trim();
    this.fL = str1.equals(str2);
    if (this.fL) {}
    for (;;)
    {
      return this.fL;
      eg.f("DEBUG", "your    signature is " + str1 + " len:" + str1.length());
      eg.f("DEBUG", "licence signature is " + str2 + " len:" + str2.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bg
 * JD-Core Version:    0.7.0.1
 */