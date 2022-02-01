package com.tencent.qqmail.utilities.encryptionalgorithm;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import javax.crypto.Cipher;

public class RsaEncryption
{
  private static final boolean RSA_SECPWD = true;
  private static final String TAG = "RSA";
  private static final String UNINITIALIZED_EXCEPTION_MESSAGE = "uninitialized key";
  private static PublicKey publicKey = null;
  
  public static String encrypt(String paramString)
  {
    ValidateHelper.notNull(paramString);
    if (publicKey == null)
    {
      setPublicKey(QMApplicationContext.sharedInstance());
      if (publicKey != null) {}
    }
    try
    {
      Object localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      ((Cipher)localObject).init(1, publicKey);
      localObject = ((Cipher)localObject).doFinal(paramString.getBytes());
      localObject = StringExtention.base64Encode((byte[])localObject, localObject.length);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "RSA", "rsa encrypt: ", localException);
    }
    return paramString;
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    int j = 0;
    if (paramPublicKey == null) {
      throw new IllegalStateException("uninitialized key");
    }
    for (;;)
    {
      int k;
      int m;
      int n;
      int i;
      try
      {
        new ByteArrayOutputStream();
        k = ((RSAPublicKey)paramPublicKey).getModulus().bitLength() / 8;
        m = paramArrayOfByte.length;
        Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(1, paramPublicKey);
        if (m > k - 11)
        {
          n = m / (k - 11);
          if (m % (k - 11) != 0) {
            break label197;
          }
          i = 0;
          n += i;
          paramPublicKey = new ByteArrayOutputStream();
          i = j;
          break label163;
          paramPublicKey.write(localCipher.doFinal(paramArrayOfByte, (k - 11) * i, j));
          i += 1;
          break label163;
          return paramPublicKey.toByteArray();
        }
        else
        {
          paramPublicKey = localCipher.doFinal(paramArrayOfByte);
          return paramPublicKey;
        }
      }
      catch (Exception paramPublicKey)
      {
        QMLog.log(6, "RSA", "rsa encrypt: ", paramPublicKey);
        return paramArrayOfByte;
      }
      label163:
      if (i < n)
      {
        j = k - 11;
        if (i == n - 1)
        {
          j = m - (k - 11) * i;
          continue;
          label197:
          i = 1;
        }
      }
    }
  }
  
  public static String encryptInBlock(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (i > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(encrypt(paramString.substring(i, Math.min(paramString.length(), i + 96))));
      i += 96;
    }
    return localStringBuilder.toString();
  }
  
  public static String encryptPwdBeforeSend(String paramString)
  {
    ValidateHelper.notNull(paramString);
    long l = new Date().getTime();
    return encrypt(paramString + "\r\n" + l);
  }
  
  public static boolean isLoginUsedRsa()
  {
    return true;
  }
  
  public static void listAssetsFiles(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPublicKey err. list files in assets:\n");
    paramContext = paramContext.getResources().getAssets();
    try
    {
      paramContext = paramContext.list("");
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(paramContext[i]);
        localStringBuilder.append("\n");
        i += 1;
      }
      QMLog.log(4, "RSA", localStringBuilder.toString());
      return;
    }
    catch (IOException paramContext)
    {
      QMLog.log(6, "RSA", "setPublicKey list file err:" + paramContext.toString());
    }
  }
  
  public static void setPublicKey(Context paramContext)
  {
    if (publicKey != null) {
      return;
    }
    try
    {
      Object localObject = CertificateFactory.getInstance("X.509");
      InputStream localInputStream = paramContext.getResources().getAssets().open("mail/Theoservice.cer");
      localObject = ((CertificateFactory)localObject).generateCertificate(localInputStream);
      localInputStream.close();
      publicKey = ((Certificate)localObject).getPublicKey();
      return;
    }
    catch (Exception localException)
    {
      listAssetsFiles(paramContext);
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption
 * JD-Core Version:    0.7.0.1
 */