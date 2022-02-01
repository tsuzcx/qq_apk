package com.tencent.smtt.utils;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class g
{
  protected static final char[] a = "0123456789abcdef".toCharArray();
  private static String b = "";
  private static byte[] c = null;
  private static g f = null;
  private static String g;
  private Cipher d = null;
  private Cipher e = null;
  
  private g()
    throws Exception
  {
    g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
    Object localObject = "00000000";
    int i = 0;
    while (i < 12)
    {
      localObject = (String)localObject + String.valueOf(new Random().nextInt(89999999) + 10000000);
      i += 1;
    }
    c = ((String)localObject + g).getBytes();
    this.d = Cipher.getInstance("RSA/ECB/NoPadding");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(d());
    ((StringBuilder)localObject).append(e());
    localObject = new X509EncodedKeySpec(Base64.decode(((StringBuilder)localObject).toString().getBytes(), 0));
    localObject = KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject);
    this.d.init(1, (Key)localObject);
    b = b(this.d.doFinal(c));
    localObject = new DESedeKeySpec(g.getBytes());
    localObject = SecretKeyFactory.getInstance("DESede").generateSecret((KeySpec)localObject);
    this.e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    this.e.init(1, (Key)localObject);
  }
  
  public static g a()
  {
    try
    {
      if (f == null) {
        f = new g();
      }
      g localg = f;
      return localg;
    }
    catch (Exception localException)
    {
      f = null;
      localException.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    paramString = new DESedeKeySpec(paramString.getBytes());
    paramString = SecretKeyFactory.getInstance("DESede").generateSecret(paramString);
    Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = a[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(paramString.getBytes()));
      Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      localCipher.init(2, paramString);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String c()
  {
    return g;
  }
  
  private String d()
  {
    return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0";
  }
  
  private String e()
  {
    return "fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
  }
  
  public byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    return this.e.doFinal(paramArrayOfByte);
  }
  
  public String b()
  {
    return b;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject = g.getBytes();
    try
    {
      localObject = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec((byte[])localObject));
      Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      localCipher.init(2, (Key)localObject);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      TbsLog.i(paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.g
 * JD-Core Version:    0.7.0.1
 */