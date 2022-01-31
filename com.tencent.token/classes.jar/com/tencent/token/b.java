package com.tencent.token;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b
  extends i
{
  private String a = "AES";
  private String b = "MD5";
  private String c = "SHA1";
  private byte[] d = new byte[16];
  private String e;
  
  public b()
  {
    int i = 0;
    for (;;)
    {
      if (i >= 16)
      {
        this.e = "UTF-8";
        return;
      }
      this.d[i] = ((byte)(i % 8));
      i += 1;
    }
  }
  
  private static String d(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i >= paramArrayOfByte.length) {
      return localStringBuffer.toString();
    }
    if (Integer.toHexString(paramArrayOfByte[i] & 0xFF).length() == 1) {
      localStringBuffer.append("0").append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
    }
    for (;;)
    {
      i += 1;
      break;
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
    }
  }
  
  public final String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        if (paramString.length() > 0)
        {
          paramString = new FileInputStream(paramString);
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString);
          MessageDigest localMessageDigest = MessageDigest.getInstance(this.b);
          localMessageDigest.reset();
          byte[] arrayOfByte = new byte[1024];
          for (;;)
          {
            int i = localBufferedInputStream.read(arrayOfByte);
            if (i <= 0)
            {
              localBufferedInputStream.close();
              paramString.close();
              return d(localMessageDigest.digest());
            }
            localMessageDigest.update(arrayOfByte, 0, i);
          }
        }
        return "";
      }
      catch (Throwable paramString)
      {
        a(paramString);
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = e.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      a(paramArrayOfByte);
    }
    return "";
  }
  
  public final String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        if (paramString.length() > 0)
        {
          paramString = new FileInputStream(paramString);
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString);
          MessageDigest localMessageDigest = MessageDigest.getInstance(this.c);
          localMessageDigest.reset();
          byte[] arrayOfByte = new byte[1024];
          for (;;)
          {
            int i = localBufferedInputStream.read(arrayOfByte);
            if (i <= 0)
            {
              localBufferedInputStream.close();
              paramString.close();
              return d(localMessageDigest.digest());
            }
            localMessageDigest.update(arrayOfByte, 0, i);
          }
        }
        return "";
      }
      catch (Throwable paramString)
      {
        a(paramString);
      }
    }
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      a(paramArrayOfByte);
    }
    return null;
  }
  
  public final String c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(this.b);
        localMessageDigest.reset();
        localMessageDigest.update(paramString.getBytes(this.e));
        paramString = d(localMessageDigest.digest());
        return paramString;
      }
      catch (Throwable paramString)
      {
        a(paramString);
      }
    }
    return "";
  }
  
  public final byte[] c(byte[] paramArrayOfByte)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.d, this.a);
      Cipher localCipher = Cipher.getInstance(this.a);
      localCipher.init(1, localSecretKeySpec);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      a(paramArrayOfByte);
    }
    return null;
  }
  
  public final String d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      int j;
      int i;
      char c1;
      try
      {
        localObject = new StringBuffer();
        j = 0;
        i = 0;
        if (j >= paramString.length())
        {
          paramString = ((StringBuffer)localObject).toString();
          if (paramString.length() <= 0) {
            break label143;
          }
          localObject = MessageDigest.getInstance(this.b);
          ((MessageDigest)localObject).reset();
          ((MessageDigest)localObject).update(paramString.getBytes(this.e));
          paramString = ((MessageDigest)localObject).digest();
          i = 0;
          if (i < paramString.length) {
            break label146;
          }
          return d(paramString);
        }
        c1 = paramString.charAt(j);
        if (i != 0) {
          break label183;
        }
        if (c1 != '=') {
          break label171;
        }
        i = 61;
      }
      catch (Throwable paramString)
      {
        Object localObject;
        a(paramString);
      }
      if (((StringBuffer)localObject).length() > 0)
      {
        continue;
        ((StringBuffer)localObject).append(c1);
        break label162;
        label143:
        return "";
        label146:
        paramString[i] = ((byte)(paramString[i] + 1));
        i += 1;
        continue;
      }
      for (;;)
      {
        label162:
        j += 1;
        break;
        label171:
        if (c1 == ':') {
          i = 58;
        }
      }
      label183:
      if ((c1 >= '0') && (c1 <= 'f') && ((c1 <= '9') || (c1 >= 'A'))) {
        if ((c1 <= 'F') || (c1 >= 'a')) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.b
 * JD-Core Version:    0.7.0.1
 */