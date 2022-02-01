package com.tencent.token;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class agp
{
  public static final String a = afz.a(afz.aE);
  
  public static String a(String paramString)
  {
    try
    {
      Object localObject = afz.a(afz.aF);
      localCipher = Cipher.getInstance((String)localObject);
      localCipher.init(2, new SecretKeySpec(a.getBytes("UTF-8"), (String)localObject));
      if (TextUtils.isEmpty(paramString))
      {
        paramString = null;
      }
      else
      {
        localObject = paramString.toCharArray();
        int j = localObject.length / 2;
        paramString = new byte[j];
        int i = 0;
        while (i < j)
        {
          int k = i * 2;
          int m = Character.digit(localObject[k], 16);
          paramString[i] = ((byte)((Character.digit(localObject[(k + 1)], 16) | m << 4) & 0xFF));
          i += 1;
        }
      }
    }
    finally
    {
      for (;;)
      {
        Cipher localCipher;
      }
    }
    paramString = new String(localCipher.doFinal(paramString), "UTF-8");
    return paramString;
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agp
 * JD-Core Version:    0.7.0.1
 */