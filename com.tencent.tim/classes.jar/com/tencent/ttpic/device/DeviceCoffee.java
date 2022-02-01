package com.tencent.ttpic.device;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class DeviceCoffee
{
  public static byte[] drink(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    LogUtils.v("Coffee", "drink() deviceName = " + paramString1 + ", sign = " + paramString2);
    return nDrink(paramArrayOfByte, paramArrayOfByte.length, paramString1, paramString2);
  }
  
  public static byte[] drinkRawData(byte[] paramArrayOfByte, String paramString)
  {
    return nDrinkRawData(paramArrayOfByte, paramArrayOfByte.length, paramString);
  }
  
  private static native byte[] nDrink(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2);
  
  private static native byte[] nDrinkRawData(byte[] paramArrayOfByte, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceCoffee
 * JD-Core Version:    0.7.0.1
 */