package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class VsEncryptUtil
{
  public static String getAesKeyAPPLOCAL()
  {
    byte[] arrayOfByte1 = new byte[16];
    byte[] tmp6_5 = arrayOfByte1;
    tmp6_5[0] = 76;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 75;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 72;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 68;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 71;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 100;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 104;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 115;
    byte[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 41;
    byte[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 40;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 42;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 38;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 94;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 37;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 36;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 35;
    tmp90_84;
    byte[] arrayOfByte2 = new byte[11];
    byte[] tmp105_103 = arrayOfByte2;
    tmp105_103[0] = 118;
    byte[] tmp110_105 = tmp105_103;
    tmp110_105[1] = 105;
    byte[] tmp115_110 = tmp110_105;
    tmp115_110[2] = 100;
    byte[] tmp120_115 = tmp115_110;
    tmp120_115[3] = 101;
    byte[] tmp125_120 = tmp120_115;
    tmp125_120[4] = 111;
    byte[] tmp130_125 = tmp125_120;
    tmp130_125[5] = 115;
    byte[] tmp135_130 = tmp130_125;
    tmp135_130[6] = 104;
    byte[] tmp141_135 = tmp135_130;
    tmp141_135[7] = 105;
    byte[] tmp147_141 = tmp141_135;
    tmp147_141[8] = 101;
    byte[] tmp153_147 = tmp147_141;
    tmp153_147[9] = 108;
    byte[] tmp159_153 = tmp153_147;
    tmp159_153[10] = 100;
    tmp159_153;
    int j = arrayOfByte1.length;
    int k = arrayOfByte2.length;
    int i = 0;
    while (i < j)
    {
      arrayOfByte1[i] = ((byte)(arrayOfByte1[i] ^ arrayOfByte2[(i % k)]));
      i += 1;
    }
    return new String(arrayOfByte1);
  }
  
  public static String getAesKeySDCRD()
  {
    byte[] arrayOfByte1 = new byte[16];
    byte[] tmp6_5 = arrayOfByte1;
    tmp6_5[0] = 33;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 64;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 35;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 36;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 113;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 119;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 104;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 100;
    byte[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 64;
    byte[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 68;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 69;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 82;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 101;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 110;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 118;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 42;
    tmp90_84;
    byte[] arrayOfByte2 = new byte[11];
    byte[] tmp105_103 = arrayOfByte2;
    tmp105_103[0] = 118;
    byte[] tmp110_105 = tmp105_103;
    tmp110_105[1] = 105;
    byte[] tmp115_110 = tmp110_105;
    tmp115_110[2] = 100;
    byte[] tmp120_115 = tmp115_110;
    tmp120_115[3] = 101;
    byte[] tmp125_120 = tmp120_115;
    tmp125_120[4] = 111;
    byte[] tmp130_125 = tmp125_120;
    tmp130_125[5] = 115;
    byte[] tmp135_130 = tmp130_125;
    tmp135_130[6] = 104;
    byte[] tmp141_135 = tmp135_130;
    tmp141_135[7] = 105;
    byte[] tmp147_141 = tmp141_135;
    tmp147_141[8] = 101;
    byte[] tmp153_147 = tmp147_141;
    tmp153_147[9] = 108;
    byte[] tmp159_153 = tmp153_147;
    tmp159_153[10] = 100;
    tmp159_153;
    int j = arrayOfByte1.length;
    int k = arrayOfByte2.length;
    int i = 0;
    while (i < j)
    {
      arrayOfByte1[i] = ((byte)(arrayOfByte1[i] ^ arrayOfByte2[(i % k)]));
      i += 1;
    }
    return new String(arrayOfByte1);
  }
  
  public static byte[] vsAesDecrypt(String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {}
    while (paramString.length() != 16) {
      return null;
    }
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] vsAesEncrypt(String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {}
    while (paramString.length() != 16) {
      return null;
    }
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] vsDecryptAPPLOCAL(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = vsAesDecrypt(getAesKeyAPPLOCAL(), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] vsDecryptSDCARD(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = vsAesDecrypt(getAesKeySDCRD(), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] vsEncryptAPPLOCAL(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = vsAesEncrypt(getAesKeyAPPLOCAL(), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] vsEncryptSDCARD(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = vsAesEncrypt(getAesKeySDCRD(), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsEncryptUtil
 * JD-Core Version:    0.7.0.1
 */