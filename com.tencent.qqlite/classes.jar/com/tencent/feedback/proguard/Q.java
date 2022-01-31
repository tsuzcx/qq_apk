package com.tencent.feedback.proguard;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class Q
  implements S
{
  private String a = null;
  
  public final void a(String paramString)
  {
    int i;
    if (paramString != null) {
      i = paramString.length();
    }
    for (;;)
    {
      if (i >= 16)
      {
        this.a = paramString.substring(0, 16);
        return;
      }
      paramString = paramString + "0";
      i += 1;
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    int j = 0;
    if ((this.a == null) || (paramArrayOfByte == null))
    {
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    Object localObject1 = new StringBuffer();
    int k = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i >= k)
      {
        localObject1 = new SecretKeySpec(this.a.getBytes(), "AES");
        Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)localObject2).init(2, (Key)localObject1, new IvParameterSpec(this.a.getBytes()));
        localObject1 = ((Cipher)localObject2).doFinal(paramArrayOfByte);
        localObject2 = new StringBuffer();
        k = localObject1.length;
        i = j;
        for (;;)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (i >= k) {
            break;
          }
          ((StringBuffer)localObject2).append(localObject1[i] + " ");
          i += 1;
        }
      }
      ((StringBuffer)localObject1).append(paramArrayOfByte[i] + " ");
      i += 1;
    }
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    int j = 0;
    if ((this.a == null) || (paramArrayOfByte == null))
    {
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    Object localObject1 = new StringBuffer();
    int k = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i >= k)
      {
        localObject1 = new SecretKeySpec(this.a.getBytes(), "AES");
        Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)localObject2).init(1, (Key)localObject1, new IvParameterSpec(this.a.getBytes()));
        localObject1 = ((Cipher)localObject2).doFinal(paramArrayOfByte);
        localObject2 = new StringBuffer();
        k = localObject1.length;
        i = j;
        for (;;)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (i >= k) {
            break;
          }
          ((StringBuffer)localObject2).append(localObject1[i] + " ");
          i += 1;
        }
      }
      ((StringBuffer)localObject1).append(paramArrayOfByte[i] + " ");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.Q
 * JD-Core Version:    0.7.0.1
 */