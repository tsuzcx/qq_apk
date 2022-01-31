package tmsdk.common.dual.l;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.util.Base64;
import com.tmsdk.dual.TMSDualSDKContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import tmsdkdual.l;
import tmsdkdual.m;

public final class Tlm
{
  private static final byte[] af = { 99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 113, 113, 112, 105, 109, 115, 101, 99, 117, 114, 101 };
  private static volatile Tlm ag = null;
  public static final String ai = new String(af);
  private Calendar ah = Calendar.getInstance();
  private Properties aj;
  private Context mContext;
  
  public Tlm()
  {
    try
    {
      load();
      return;
    }
    catch (Throwable localThrowable)
    {
      m.a("TMSDUAL_Licence", "licence check failed");
    }
  }
  
  private static byte[] dd(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(2, paramArrayOfByte2);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (GeneralSecurityException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return null;
  }
  
  private String g(String paramString)
  {
    Object localObject = this.mContext.getPackageManager();
    try
    {
      paramString = ((PackageManager)localObject).getPackageInfo(paramString, 64);
      if ((paramString != null) && (paramString.signatures != null))
      {
        paramString = paramString.signatures[0];
        if (paramString == null) {
          return null;
        }
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      localObject = new ByteArrayInputStream(paramString.toByteArray());
    }
    for (;;)
    {
      try
      {
        paramString = l.b(((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate((InputStream)localObject)).getEncoded());
        paramString = null;
      }
      catch (CertificateException localCertificateException1)
      {
        try
        {
          ((ByteArrayInputStream)localObject).close();
          return paramString;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        catch (CertificateException localCertificateException2)
        {
          continue;
        }
        localCertificateException1 = localCertificateException1;
        paramString = null;
        localCertificateException1.printStackTrace();
      }
      catch (IOException localIOException1)
      {
        paramString = null;
        localIOException1.printStackTrace();
      }
    }
  }
  
  private byte[] g(int paramInt)
  {
    Object localObject6 = null;
    byte[] arrayOfByte = null;
    Object localObject3 = arrayOfByte;
    Object localObject1 = localObject6;
    try
    {
      AssetManager localAssetManager = TMSDualSDKContext.getApplicaionContext().getAssets();
      if (paramInt == 0) {}
      for (Object localObject5 = "licence_dual.conf";; localObject5 = "licence_dual" + paramInt + ".conf")
      {
        localObject3 = arrayOfByte;
        localObject1 = localObject6;
        localObject5 = localAssetManager.open((String)localObject5);
        localObject3 = localObject5;
        localObject1 = localObject5;
        arrayOfByte = new byte[((InputStream)localObject5).available()];
        localObject3 = localObject5;
        localObject1 = localObject5;
        ((InputStream)localObject5).read(arrayOfByte);
        if (localObject5 != null) {}
        try
        {
          ((InputStream)localObject5).close();
          return arrayOfByte;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return arrayOfByte;
        }
        localObject3 = arrayOfByte;
        localObject1 = localObject6;
      }
      try
      {
        Object localObject2;
        localObject2.close();
        throw localObject4;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (IOException localIOException3)
    {
      localObject2 = localObject3;
      throw new RuntimeException(localIOException3);
    }
    finally
    {
      if (localObject2 == null) {}
    }
  }
  
  private void load()
  {
    do
    {
      try
      {
        byte[] arrayOfByte1 = g(0);
        if (arrayOfByte1 == null)
        {
          m.a("TMSDUAL_Licence", "Certification file is missing! Please contact TMS(Tencent Mobile Secure) group.");
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        m.a("TMSDUAL_Licence", "loadLicence Invaild signature! Please contact TMS(Tencent Mobile Secure) group.");
        return;
      }
      localObject3 = v();
      byte[] arrayOfByte2 = new byte[''];
      System.arraycopy(localRuntimeException, 0, arrayOfByte2, 0, arrayOfByte2.length);
      localObject3 = l.a(arrayOfByte2, (RSAPublicKey)localObject3);
      if (localObject3 == null)
      {
        m.a("TMSDUAL_Licence", "RSA decrypt error.");
        return;
      }
      arrayOfByte2 = new byte[localRuntimeException.length - 128];
      System.arraycopy(localRuntimeException, 128, arrayOfByte2, 0, arrayOfByte2.length);
      localObject1 = dd(arrayOfByte2, (byte[])localObject3);
    } while (localObject1 == null);
    Object localObject3 = new ByteArrayInputStream((byte[])localObject1);
    Object localObject1 = new Properties();
    for (;;)
    {
      try
      {
        ((Properties)localObject1).load((InputStream)localObject3);
      }
      catch (IOException localIOException4)
      {
        localIOException4 = localIOException4;
        localIOException4.printStackTrace();
        try
        {
          localIOException1.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        continue;
      }
      finally {}
      try
      {
        ((ByteArrayInputStream)localObject3).close();
        this.aj = ((Properties)localObject1);
        this.mContext = TMSDualSDKContext.getApplicaionContext();
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    try
    {
      localIOException2.close();
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        localIOException3.printStackTrace();
      }
    }
  }
  
  private static RSAPublicKey v()
  {
    return l.d(Base64.decode("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM5ekNDQWQ4Q0NRRGlsbUFjTWxiczVEQU5C\nZ2txaGtpRzl3MEJBUVVGQURCK01Rc3dDUVlEVlFRR0V3SkQKVGpFTE1Ba0dBMVVFQ0JNQ1IwUXhD\nekFKQmdOVkJBY1RBa2RhTVJJd0VBWURWUVFLRkFsMFpXTUlibU5sYm5ReApDekFKQmdOVkJBc1RB\nak5ITVE0d0RBWURWUVFERXdWdlltRnRZVEVrTUNJR0NTcUdTSWIzRFFFSkFSWVZiMkpoCmJXRjZa\nVzVuUUhSbGJtTmxiblF1WTI5dE1CNFhEVEV4TVRFeE5qRXhNVGN4TjFvWERURXlNREl5TkRFeE1U\nY3gKTjFvd2dZQXhDekFKQmdOVkJBWVRBa05PTVFzd0NRWURWUVFJRXdKSFJERUxNQWtHQTFVRUJ4\nTUNSMW94RURBTwpCZ05WQkFvVEIzUmxibU5sYm5ReEN6QUpCZ05WQkFzVEFqTkhNUkl3RUFZRFZR\nUURFd2x2WW1GdFlYcGxibWN4CkpEQWlCZ2txaGtpRzl3MEJDUUVXRlc5aVlXMWhlbVZ1WjBCMFpX\nNWpaVzUwTG1OdmJUQ0JuekFOQmdrcWhraUcKOXcwQkFRRUZBQU9CalFBd2dZa0NnWUVBd1kvV3FI\nV2NlRERkSm16anI3TlpSeS9qTllwS1NzVzExZngxaTIrQwpxTUE3NTJXb1d1bDZuSTB1MGZkWitk\nUzVUandRNkU0Qm13dXduVTVnQmJYK1VzQ2VHRHZaQVhQc045UEVWYnZTCkcvR25YclQrcTI2VUpP\nNHcrd3VNdmk5YWxkZHhhbkNKeXJ2ZWQ2NUdvMXhXUEErWGNHaVQxMndubjZtUHhyMnUKcVEwQ0F3\nRUFBVEFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBblpzV3FpSmV5SC9sT0prSWN6L2ZidDN3MXFL\nRApGTXJ5cFVHVFN6Z3NONWNaMW9yOGlvVG5ENGRLaDdJN2ttbDRpcGNvMDF0enc2MGhLYUtwNG9G\nMnYrMEs2NGZDCnBEMG9EUlkrOGoyK2RsMmNxeHBsT0FYdDc1RWFKNW40MG1DZDdTN0VBS0d2Z2Na\naVhyV0Z1eUtCL2QvNTh3Qm4KOEFGUVJhTnBySXNOSHpxMkMwL0JXR1pTSnJicmhOWExFY0ZtL0Ru\nTG14ZEVNYWxPSXhnSkhGcEFOS2tadXBzdgo0L0lDVFhSL0RJaURjbXJjbDFkNkc2VmgyaUcwaS9v\nRDBHQnBMZlFPcEF0Vmx6Y2lxZnBsTkphcnpRUTZUVXRyCm5GRmVNVDNDc2t5VGJwYnp1R2dDdUxj\nQVR3cnRQd1BOOWZzQXYrSjRJZm0rZUNVVDVnZlorMSsyNHc9PQotLS0tLUVORCBDRVJUSUZJQ0FU\nRS0tLS0tCg==\n".getBytes(), 0));
  }
  
  public boolean w()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aj != null)
    {
      if (this.mContext != null) {
        break label22;
      }
      bool1 = bool2;
    }
    label22:
    String str1;
    String str2;
    do
    {
      do
      {
        return bool1;
        str1 = g(this.mContext.getPackageName());
        bool1 = bool2;
      } while (str1 == null);
      str2 = this.aj.getProperty("signature").toUpperCase().trim();
      bool2 = str1.equals(str2);
      bool1 = bool2;
    } while (bool2);
    m.b("DEBUG", "your    signature is " + str1 + " len:" + str1.length());
    m.b("DEBUG", "licence signature is " + str2 + " len:" + str2.length());
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdk.common.dual.l.Tlm
 * JD-Core Version:    0.7.0.1
 */