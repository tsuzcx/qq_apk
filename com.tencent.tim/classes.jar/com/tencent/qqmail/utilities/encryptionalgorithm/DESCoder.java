package com.tencent.qqmail.utilities.encryptionalgorithm;

import com.tencent.qqmail.utilities.log.QMLog;
import java.security.Key;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public abstract class DESCoder
{
  public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
  public static final String KEY_ALGORITHM = "DES";
  private static final int TABLE_N = 8;
  private static final String TAG = "DES";
  private static final byte[] m_tranKeyTable = { 92, 94, 80, 117, 108, 110, 33, 51, 119, 49, 6, 127, 112, 102, 84, 83, 29, 58, 55, 53, 89, 61, 62, 12, 51, 4, 17, 32, 23, 13, 15, 57, 70, 46, 61, 90, 31, 75, 53, 109, 54, 37, 26, 62, 47, 68, 47, 26, 123, 78, 64, 52, 41, 115, 22, 63, 16, 43, 2, 18, 126, 57, 39, 51, 126, 97, 95, 120, 62, 78, 74, 95, 32, 63, 49, 94, 26, 125, 43, 99, 93, 38, 3, 111, 57, 122, 101, 104, 117, 75, 42, 124, 48, 56, 11, 74, 73, 35, 61, 121, 88, 101, 8, 108, 69, 123, 76, 59, 116, 77, 40, 93, 10, 77, 93, 123, 106, 34, 111, 123, 28, 106, 74, 109, 79, 70, 15, 110 };
  private static final byte[] m_tranMidTable;
  private static final byte[] m_tranSeedTable = { 16, 21, 2, 21, 23, 13, 7, 5, 4, 31, 8, 9, 26, 9, 7, 5, 12, 3, 17, 8, 2, 22, 24, 20, 25, 1, 27, 12, 10, 1, 28, 9 };
  private static byte[] secKey = initKey();
  
  static
  {
    m_tranMidTable = new byte[] { 27, 10, 80, 15, 7, 22, 3, 29, 23, 46, 19, 0, 22, 31, 16, 61, 4, 120, 30, 14, 20, 1, 122, 21, 8, 25, 18, 121, 34, 6, 13, 17 };
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = toKey(secKey);
      Cipher localCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      localCipher.init(2, (Key)localObject);
      localObject = localCipher.doFinal(paramArrayOfByte);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (paramArrayOfByte == null) {
        break label42;
      }
    }
    if (secKey == null) {
      label42:
      QMLog.log(6, "DES", "des decrypt exception: data or key is null", localException);
    }
    for (;;)
    {
      return null;
      QMLog.log(6, "DES", "des decrypt exception:  data: " + paramArrayOfByte.length + "key: " + secKey.length, localException);
    }
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte2 = toKey(paramArrayOfByte2);
    Cipher localCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    localCipher.init(2, paramArrayOfByte2);
    return localCipher.doFinal(paramArrayOfByte1);
  }
  
  public static String desDecode(String paramString)
  {
    return new String(desDecode(paramString, new String(secKey)));
  }
  
  public static String desDecode(String paramString1, String paramString2)
  {
    return new String(new byte[0]);
  }
  
  public static String desEncode(String paramString)
  {
    return new String(desEncode(paramString, new String(secKey)));
  }
  
  public static String desEncode(String paramString1, String paramString2)
  {
    return new String(new String());
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = toKey(secKey);
      Cipher localCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      localCipher.init(1, (Key)localObject);
      localObject = localCipher.doFinal(paramArrayOfByte);
      return localObject;
    }
    catch (Exception localException)
    {
      if (paramArrayOfByte == null) {
        break label38;
      }
    }
    if (secKey == null) {
      label38:
      QMLog.log(6, "DES", "des decrypt exception: data or key is null", localException);
    }
    for (;;)
    {
      return null;
      QMLog.log(6, "DES", "des encrypt exception: data: " + paramArrayOfByte.length + "key: " + secKey.length, localException);
    }
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte2 = toKey(paramArrayOfByte2);
    Cipher localCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    localCipher.init(1, paramArrayOfByte2);
    return localCipher.doFinal(paramArrayOfByte1);
  }
  
  private static byte[] initKey()
  {
    int k = 0;
    int[] arrayOfInt1 = new int[8];
    arrayOfInt1[0] = 1;
    arrayOfInt1[1] = 1;
    int i = 0;
    while (i < 6)
    {
      arrayOfInt1[(i + 2)] = (arrayOfInt1[i] + arrayOfInt1[(i + 1)]);
      i += 1;
    }
    Object localObject1 = new int[8];
    i = 0;
    while (i < 8)
    {
      localObject1[i] = (arrayOfInt1[i] % 4 + i * 4);
      i += 1;
    }
    byte[] arrayOfByte = new byte[8];
    i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = m_tranSeedTable[localObject1[i]];
      i += 1;
    }
    arrayOfByte = new byte[8];
    i = 0;
    int j;
    while (i < 8)
    {
      j = m_tranSeedTable[(localObject1[i] + 1)];
      arrayOfByte[i] = m_tranMidTable[(j & 0xFF)];
      i += 1;
    }
    Object localObject2 = new HashMap();
    localObject1 = new byte[''];
    int m = (m_tranSeedTable[31] & 0xFF) % 8;
    i = 0;
    if (i < 128)
    {
      if (i / 8 % 2 != 0)
      {
        j = i % 8;
        if (j + m >= 8)
        {
          j = i - (j + m) + 1;
          label232:
          localObject1[j] = m_tranKeyTable[i];
          ((HashMap)localObject2).put(Byte.valueOf(m_tranKeyTable[i]), Integer.valueOf(j));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = i + m;
        break label232;
        localObject1[i] = m_tranKeyTable[i];
        ((HashMap)localObject2).put(Byte.valueOf(m_tranKeyTable[i]), Integer.valueOf(i));
      }
    }
    int[] arrayOfInt2 = new int[8];
    i = 0;
    while (i < 8)
    {
      if (((HashMap)localObject2).containsKey(Byte.valueOf(arrayOfByte[i]))) {
        arrayOfInt2[i] = (((Integer)((HashMap)localObject2).get(Byte.valueOf(arrayOfByte[i]))).intValue() + 8);
      }
      i += 1;
    }
    localObject2 = new byte[8];
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= arrayOfInt2.length) {
        break;
      }
      localObject2[i] = localObject1[arrayOfInt2[i]];
      i += 1;
    }
    while (j < 8)
    {
      arrayOfByte[j] = Integer.valueOf((localObject2[j] & 0xFF) - arrayOfInt1[(7 - j)]).byteValue();
      j += 1;
    }
    return arrayOfByte;
  }
  
  public static Key toKey(byte[] paramArrayOfByte)
    throws Exception
  {
    paramArrayOfByte = new DESKeySpec(paramArrayOfByte);
    return SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.encryptionalgorithm.DESCoder
 * JD-Core Version:    0.7.0.1
 */