package com.tencent.feedback.proguard;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class F
  implements H
{
  private String a = null;
  
  public final void a(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.length();
      while (i < 16)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("0");
        paramString = localStringBuilder.toString();
        i += 1;
      }
      this.a = paramString.substring(0, 16);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if ((this.a != null) && (paramArrayOfByte != null))
    {
      Object localObject1 = new StringBuffer();
      int k = paramArrayOfByte.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        int m = paramArrayOfByte[i];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        i += 1;
      }
      localObject1 = new SecretKeySpec(this.a.getBytes(), "AES");
      Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject2).init(2, (Key)localObject1, new IvParameterSpec(this.a.getBytes()));
      paramArrayOfByte = ((Cipher)localObject2).doFinal(paramArrayOfByte);
      localObject1 = new StringBuffer();
      k = paramArrayOfByte.length;
      i = j;
      while (i < k)
      {
        j = paramArrayOfByte[i];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        i += 1;
      }
      return paramArrayOfByte;
    }
    return null;
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    if ((this.a != null) && (paramArrayOfByte != null))
    {
      Object localObject1 = new StringBuffer();
      int k = paramArrayOfByte.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        int m = paramArrayOfByte[i];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        i += 1;
      }
      localObject1 = new SecretKeySpec(this.a.getBytes(), "AES");
      Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject2).init(1, (Key)localObject1, new IvParameterSpec(this.a.getBytes()));
      paramArrayOfByte = ((Cipher)localObject2).doFinal(paramArrayOfByte);
      localObject1 = new StringBuffer();
      k = paramArrayOfByte.length;
      i = j;
      while (i < k)
      {
        j = paramArrayOfByte[i];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        i += 1;
      }
      return paramArrayOfByte;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.F
 * JD-Core Version:    0.7.0.1
 */