package com.tencent.token;

public final class afj
{
  static
  {
    byte[] arrayOfByte1 = new byte[16];
    byte[] tmp6_5 = arrayOfByte1;
    tmp6_5[0] = 48;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    byte[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    byte[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    byte[] arrayOfByte2 = new byte[256];
    byte[] arrayOfByte3 = new byte[256];
    int i = 0;
    while (i < 256)
    {
      arrayOfByte2[i] = arrayOfByte1[(i >>> 4)];
      arrayOfByte3[i] = arrayOfByte1[(i & 0xF)];
      i += 1;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afj
 * JD-Core Version:    0.7.0.1
 */