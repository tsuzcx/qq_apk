package com.tencent.android.tpush.encrypt;

import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

public class Rijndael
{
  public static String decrypt(String paramString)
  {
    if (!i.b(paramString))
    {
      String str1 = TpnsSecurity.oiSymmetryDecrypt2(paramString);
      int i = 0;
      while (i < 3)
      {
        str2 = str1;
        if (!"failed".equals(str1)) {
          return str2;
        }
        str1 = TpnsSecurity.oiSymmetryDecrypt2(paramString);
        i += 1;
      }
    }
    String str2 = "";
    return str2;
  }
  
  public static String encrypt(String paramString)
  {
    if (!i.b(paramString))
    {
      String str1 = TpnsSecurity.oiSymmetryEncrypt2(paramString);
      int i = 0;
      while (i < 3)
      {
        str2 = str1;
        if (!"failed".equals(str1)) {
          return str2;
        }
        str1 = TpnsSecurity.oiSymmetryEncrypt2(paramString);
        i += 1;
      }
    }
    String str2 = "";
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.encrypt.Rijndael
 * JD-Core Version:    0.7.0.1
 */