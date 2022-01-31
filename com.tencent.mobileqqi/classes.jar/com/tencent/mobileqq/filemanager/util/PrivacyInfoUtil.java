package com.tencent.mobileqq.filemanager.util;

import com.tencent.qphone.base.util.QLog;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class PrivacyInfoUtil
{
  private final byte jdField_a_of_type_Byte = 0;
  private final int jdField_a_of_type_Int = 20;
  private final String jdField_a_of_type_JavaLangString = "PrivacyInfoUtil";
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final byte[] jdField_a_of_type_ArrayOfByte = "gavinhuangdaydayup_happy".getBytes();
  private final byte jdField_b_of_type_Byte = 0;
  private final String jdField_b_of_type_JavaLangString = "DESede/ECB/PKCS5Padding";
  private final byte[] jdField_b_of_type_ArrayOfByte = "doscarlettmarryrenzzhang".getBytes();
  private final byte jdField_c_of_type_Byte = 1;
  private final String jdField_c_of_type_JavaLangString = "random";
  private final byte[] jdField_c_of_type_ArrayOfByte = "wangpeilin_georgewangson".getBytes();
  private final byte jdField_d_of_type_Byte = 0;
  private final byte[] jdField_d_of_type_ArrayOfByte = "georgebirthdayis19790526".getBytes();
  private final byte jdField_e_of_type_Byte = 1;
  private final byte[] jdField_e_of_type_ArrayOfByte = "qlinkwillthebestfunction".getBytes();
  private final byte jdField_f_of_type_Byte = 2;
  private final byte[] jdField_f_of_type_ArrayOfByte = "qqwillbebetterthanwechat".getBytes();
  private final byte[] g = "whowillbethenextbigtiger".getBytes();
  private final byte[] h = "whenwillwefindmahang_370".getBytes();
  private final byte[] i = "whenwillchinagetworldcap".getBytes();
  
  public PrivacyInfoUtil()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_f_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
  }
  
  private byte a()
  {
    return 0;
  }
  
  private String a(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      return null;
    case 0: 
      return "DESede/ECB/PKCS5Padding";
    }
    return "random";
  }
  
  private String a(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(Long.toHexString((paramByte1 << 2) + paramByte2));
    localStringBuilder.append(Long.toHexString(paramByte3));
    Random localRandom = new Random();
    paramByte1 = 0;
    while (paramByte1 < 9)
    {
      paramByte2 = localRandom.nextInt() & 0xFF;
      localStringBuilder.append(Integer.toHexString((paramByte2 & 0xF0) >> 4));
      localStringBuilder.append(Integer.toHexString(paramByte2 & 0xF));
      paramByte1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private String a(byte paramByte1, byte paramByte2, byte paramByte3, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(Integer.toHexString((paramByte1 << 2) + paramByte2));
    localStringBuilder.append(Integer.toHexString(paramByte3));
    localStringBuilder.append(Integer.toHexString((paramArrayOfByte[0] & 0xF0) >> 4));
    localStringBuilder.append(Integer.toHexString(paramArrayOfByte[0] & 0xF));
    String str = a(paramByte1);
    if (str == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot algorithm is null");
      return null;
    }
    byte[] arrayOfByte = a(paramByte3);
    if (arrayOfByte == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot key is null");
      return null;
    }
    paramByte2 = 7;
    if (paramArrayOfByte.length < 8) {
      paramByte2 = paramArrayOfByte.length - 1;
    }
    paramArrayOfByte = b(str, arrayOfByte, paramArrayOfByte, 1, paramByte2);
    if (paramArrayOfByte == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot doCipher return null");
      return null;
    }
    paramByte2 = 0;
    while (paramByte2 < paramArrayOfByte.length)
    {
      localStringBuilder.append(Integer.toHexString((paramArrayOfByte[paramByte2] & 0xF0) >> 4));
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[paramByte2] & 0xF));
      paramByte2 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private byte[] a(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (byte[])this.jdField_a_of_type_JavaUtilArrayList.get(paramByte);
    }
    return null;
  }
  
  private byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    while (j < 8)
    {
      arrayOfByte[j] = ((byte)(int)(paramLong >> (7 - j) * 8 & 0xFF));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private byte[] b(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, paramString);
      Cipher localCipher = Cipher.getInstance(paramString);
      localCipher.init(1, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2, paramInt1, paramInt2);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      QLog.e("PrivacyInfoUtil", 1, "doCipher NoSuchAlgorithmException exception, algorithm[" + paramString + "]");
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        QLog.e("PrivacyInfoUtil", 1, "doCipher NoSuchPaddingException exception, algorithm[" + paramString + "]");
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        QLog.e("PrivacyInfoUtil", 1, "doCipher lang exception, algorithm[" + paramString + "]");
      }
    }
  }
  
  public long a(String paramString)
  {
    int k = 0;
    long l2;
    if ((paramString == null) || (paramString.length() < 20))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "getUinFromPrivacyInfo privacyInfo is incorrect");
      }
      l2 = 0L;
      return l2;
    }
    int j = Integer.valueOf(paramString.substring(0, 1), 16).byteValue();
    if ((byte)(j & 0x3) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "getUinFromPrivacyInfo plainType is not uin");
      }
      return 0L;
    }
    Object localObject = a((byte)((j & 0xC) >> 2));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "getUinFromPrivacyInfo algorithm is null");
      }
      return 0L;
    }
    byte[] arrayOfByte1 = a(Integer.valueOf(paramString.substring(1, 2), 16).byteValue());
    if (arrayOfByte1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "getUinFromPrivacyInfo key is null");
      }
      return 0L;
    }
    byte[] arrayOfByte2 = new byte[8];
    j = 0;
    while (j < 8)
    {
      arrayOfByte2[j] = Integer.valueOf(paramString.substring(j * 2 + 4, j * 2 + 6), 16).byteValue();
      j += 1;
    }
    localObject = a((String)localObject, arrayOfByte1, arrayOfByte2, 0, arrayOfByte2.length);
    long l1 = Integer.valueOf(paramString.substring(2, 4), 16).byteValue();
    j = k;
    for (;;)
    {
      l2 = l1;
      if (j >= 7) {
        break;
      }
      l1 = ((l1 << 4) + ((localObject[j] & 0xF0) >> 4) << 4) + (localObject[j] & 0xF);
      j += 1;
    }
  }
  
  public String a()
  {
    return a((byte)1, (byte)2, (byte)0);
  }
  
  public String a(long paramLong)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (str != null) {
      return str;
    }
    str = a(a(), (byte)0, (byte)0, a(paramLong));
    if (this.jdField_a_of_type_JavaUtilHashMap.size() > 20) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), str);
    return str;
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "getPrivacyInfoFromNick nick is empty");
      }
      return null;
    }
    return a(a(), (byte)1, (byte)0, paramString.getBytes());
  }
  
  public byte[] a(String paramString)
  {
    int j = 0;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1;
    if ((paramString == null) || (paramString.length() < 20))
    {
      arrayOfByte1 = arrayOfByte2;
      if (QLog.isColorLevel())
      {
        QLog.e("PrivacyInfoUtil", 2, "getRandomFromPrivacyInfo privacyInfo is incorrect");
        arrayOfByte1 = arrayOfByte2;
      }
    }
    do
    {
      byte b1;
      do
      {
        int k;
        do
        {
          return arrayOfByte1;
          k = Integer.valueOf(paramString.substring(0, 1), 16).byteValue();
          if (2 == (byte)(k & 0x3)) {
            break;
          }
          arrayOfByte1 = arrayOfByte2;
        } while (!QLog.isColorLevel());
        QLog.e("PrivacyInfoUtil", 2, "getRandomFromPrivacyInfo plainType is not random");
        return null;
        b1 = (byte)((k & 0xC) >> 2);
        if (a(b1) != null) {
          break;
        }
        arrayOfByte1 = arrayOfByte2;
      } while (!QLog.isColorLevel());
      QLog.e("PrivacyInfoUtil", 2, "getRandomFromPrivacyInfo algorithm is null, cipherType[" + b1 + "]");
      return null;
      if (a(Integer.valueOf(paramString.substring(1, 2), 16).byteValue()) != null) {
        break;
      }
      arrayOfByte1 = arrayOfByte2;
    } while (!QLog.isColorLevel());
    QLog.e("PrivacyInfoUtil", 2, "getUinFromPrivacyInfo key is null");
    return null;
    arrayOfByte2 = new byte[9];
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (j >= 9) {
        break;
      }
      arrayOfByte2[j] = Integer.valueOf(paramString.substring(j * 2 + 2, j * 2 + 4), 16).byteValue();
      j += 1;
    }
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, paramString);
      Cipher localCipher = Cipher.getInstance(paramString);
      localCipher.init(2, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2, paramInt1, paramInt2);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "doDecrypt NoSuchAlgorithmException exception, algorithm[" + paramString + "]");
      }
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PrivacyInfoUtil", 2, "doDecrypt NoSuchPaddingException exception, algorithm[" + paramString + "]");
        }
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PrivacyInfoUtil", 2, "doDecrypt lang exception, algorithm[" + paramString + "]");
        }
      }
    }
  }
  
  public String b(String paramString)
  {
    int m = 0;
    if ((paramString == null) || (paramString.length() < 20)) {
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "getNickFromPrivacyInfo privacyInfo is incorrect");
      }
    }
    byte[] arrayOfByte1;
    do
    {
      do
      {
        do
        {
          return null;
          k = Integer.valueOf(paramString.substring(0, 1), 16).byteValue();
          if (1 == (byte)(k & 0x3)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("PrivacyInfoUtil", 2, "getNickFromPrivacyInfo plainType is not nick");
        return null;
        localObject = a((byte)((k & 0xC) >> 2));
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("PrivacyInfoUtil", 2, "getNickFromPrivacyInfo algorithm is null");
      return null;
      arrayOfByte1 = a(Integer.valueOf(paramString.substring(1, 2), 16).byteValue());
      if (arrayOfByte1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PrivacyInfoUtil", 2, "getNickFromPrivacyInfo key is null");
    return null;
    byte[] arrayOfByte2 = new byte[8];
    int k = 0;
    while (k < 8)
    {
      arrayOfByte2[k] = Integer.valueOf(paramString.substring(k * 2 + 4, k * 2 + 6), 16).byteValue();
      k += 1;
    }
    Object localObject = a((String)localObject, arrayOfByte1, arrayOfByte2, 0, arrayOfByte2.length);
    int j = Integer.valueOf(paramString.substring(2, 4), 16).byteValue();
    paramString = new byte[localObject.length + 1];
    paramString[0] = j;
    k = m;
    while (k < localObject.length)
    {
      paramString[(k + 1)] = localObject[k];
      k += 1;
    }
    return new String(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.PrivacyInfoUtil
 * JD-Core Version:    0.7.0.1
 */