package com.huawei.agconnect.config.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Keys
{
  public static final int AES_KEY_SIZE = 16;
  private static final int KEY_ITERATION_COUNT = 5000;
  
  public static SecretKey buildAesKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    throws NoSuchAlgorithmException, InvalidKeySpecException
  {
    if ((paramArrayOfByte1.length != 16) || (paramArrayOfByte2.length != 16) || (paramArrayOfByte3.length != 16)) {
      throw new IllegalArgumentException("invalid data for generating the key.");
    }
    paramArrayOfByte1 = Hex.encodeHexString(getKey(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3));
    return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(paramArrayOfByte1.toCharArray(), paramArrayOfByte4, 5000, 128)).getEncoded(), "AES");
  }
  
  private static byte[] bytesShift(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes must not be null.");
    }
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      if (paramInt < 0) {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] << -paramInt));
      }
      for (;;)
      {
        i += 1;
        break;
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] >> paramInt));
      }
    }
    return paramArrayOfByte;
  }
  
  private static byte[] bytesXor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      throw new NullPointerException("left or right must not be null.");
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      throw new IllegalArgumentException("left and right must be the same length.");
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] getKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return bytesXor(bytesShift(bytesXor(bytesShift(paramArrayOfByte1, -4), paramArrayOfByte2), 6), paramArrayOfByte3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.impl.Keys
 * JD-Core Version:    0.7.0.1
 */