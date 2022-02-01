package com.tencent.qqmail.model;

public final class MailEncode
{
  public static final int BYTE_BIT_0 = 1;
  public static final int BYTE_BIT_1 = 2;
  public static final int BYTE_BIT_2 = 4;
  public static final int BYTE_BIT_3 = 8;
  public static final int BYTE_BIT_4 = 16;
  public static final int BYTE_BIT_5 = 32;
  public static final int BYTE_BIT_6 = 64;
  public static final int BYTE_BIT_7 = 128;
  public static final int BYTE_BIT_LOW5 = 31;
  public static final int BYTE_BIT_LOW6 = 63;
  public static final int BYTE_BIT_LOW7 = 127;
  public static final int CONV_FALG = 16;
  public static final int DETAIL_FLAG = 1;
  public static final int MAIHED_FAG = 224;
  public static final int MAX_BASE_3BYTE = 8388608;
  public static final int MAX_MAX_TIM = 1879048192;
  public static final int MAX_NUM = 268435456;
  public static final int MAX_NUM_1BYTE = 128;
  public static final int MAX_NUM_2BYTE = 16384;
  public static final int MAX_NUM_3BYTE = 2097152;
  public static final int MAX_TIM_2BYTE = 32768;
  public static final int MAX_TIM_DIFF = 1073741824;
  public static final int STAR_FALG = 4;
  public static final int TAG_FALG = 8;
  public static final int UNREAD_FALG = 2;
  
  public static boolean IS_BASE_3BYTE(int paramInt)
  {
    return paramInt < 8388608;
  }
  
  public static boolean IS_NUM_1BYTE(int paramInt)
  {
    return paramInt < 128;
  }
  
  public static boolean IS_NUM_2BYTE(int paramInt)
  {
    return paramInt < 16384;
  }
  
  public static boolean IS_NUM_3BYTE(int paramInt)
  {
    return paramInt < 2097152;
  }
  
  public static boolean IS_TIME_2BYTE(int paramInt)
  {
    return paramInt < 32768;
  }
  
  public static boolean NUM_OK(int paramInt)
  {
    return paramInt < 268435456;
  }
  
  public static boolean TIM_DIFF_OK(int paramInt)
  {
    return paramInt < 1073741824;
  }
  
  public static boolean TIM_OK(int paramInt)
  {
    return paramInt < 1879048192;
  }
  
  public static void htonl(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte[3] = ((byte)(paramInt & 0xFF));
    paramArrayOfByte[2] = ((byte)(paramInt >> 8 & 0xFF));
    paramArrayOfByte[1] = ((byte)(paramInt >> 16 & 0xFF));
    paramArrayOfByte[0] = ((byte)(paramInt >>> 24));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.MailEncode
 * JD-Core Version:    0.7.0.1
 */