package com.android.safeguard;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a
  extends h
{
  private String a = "AES";
  private String b = "MD5";
  private String c = "SHA1";
  private byte[] d = new byte[16];
  private String e;
  
  public a()
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
  
  private String d(byte[] paramArrayOfByte)
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
  
  public String a(String paramString)
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (j >= paramString.length()) {
      label23:
      return localStringBuffer.toString();
    }
    char c1 = paramString.charAt(j);
    if (i == 0) {
      if (c1 == '=') {
        i = 61;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (c1 == ':')
      {
        i = 58;
        continue;
        if ((c1 < '0') || (c1 > 'f') || ((c1 > '9') && (c1 < 'A')) || ((c1 > 'F') && (c1 < 'a')))
        {
          if (localStringBuffer.length() <= 0) {
            continue;
          }
          break label23;
        }
        localStringBuffer.append(c1);
      }
    }
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = d.a(paramArrayOfByte, 0);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      a(paramArrayOfByte);
    }
    return "";
  }
  
  public String b(String paramString)
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
  
  public byte[] b(byte[] paramArrayOfByte)
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
  
  public String c(String paramString)
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
  
  public byte[] c(byte[] paramArrayOfByte)
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
  
  public String d(String paramString)
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
  
  public String e(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        paramString = a(paramString);
        if (paramString.length() > 0)
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance(this.b);
          localMessageDigest.reset();
          localMessageDigest.update(paramString.getBytes(this.e));
          paramString = localMessageDigest.digest();
          int i = 0;
          for (;;)
          {
            if (i >= paramString.length) {
              return d(paramString);
            }
            paramString[i] = ((byte)(paramString[i] + 1));
            i += 1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.a
 * JD-Core Version:    0.7.0.1
 */