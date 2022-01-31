package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.utils.Base64Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;

public class Encrypt
{
  private static final int a = 117;
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject1 = localObject2;
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localObject1;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject1 = new X509EncodedKeySpec(Base64Util.a(paramString, 0));
    paramString = KeyFactory.getInstance("RSA");
    Object localObject2 = paramString.generatePublic((KeySpec)localObject1);
    localObject1 = Cipher.getInstance(paramString.getAlgorithm());
    ((Cipher)localObject1).init(1, (Key)localObject2);
    int k = paramArrayOfByte.length;
    localObject2 = new ByteArrayOutputStream();
    int j = 0;
    int i = 0;
    if (k - i > 0)
    {
      if (k - i > 117) {}
      for (paramString = ((Cipher)localObject1).doFinal(paramArrayOfByte, i, 117);; paramString = ((Cipher)localObject1).doFinal(paramArrayOfByte, i, k - i))
      {
        ((ByteArrayOutputStream)localObject2).write(paramString, 0, paramString.length);
        j += 1;
        i = j * 117;
        break;
      }
    }
    paramArrayOfByte = ((ByteArrayOutputStream)localObject2).toByteArray();
    ((ByteArrayOutputStream)localObject2).close();
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.Encrypt
 * JD-Core Version:    0.7.0.1
 */