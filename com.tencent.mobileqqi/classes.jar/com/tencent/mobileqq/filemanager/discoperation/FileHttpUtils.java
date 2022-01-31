package com.tencent.mobileqq.filemanager.discoperation;

import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;
import java.io.PrintStream;

public class FileHttpUtils
{
  static final String a = "FileHttpUtils<FileAssistant>";
  
  public static int a(SSCM paramSSCM, long paramLong1, long paramLong2, long paramLong3)
  {
    int i;
    if (paramLong3 == 0L)
    {
      FMConstants.V = paramSSCM.a(BaseApplication.getContext(), paramLong1, paramLong3);
      if (paramLong1 < FMConstants.V) {}
      for (;;)
      {
        i = (int)paramLong1;
        int k = Utils.a(BaseApplication.getContext());
        int j;
        if (k != 1)
        {
          j = i;
          if (k != 2) {}
        }
        else
        {
          j = i;
          if (i > 16384) {
            j = 16384;
          }
        }
        i = Math.min(j, 1048576);
        if (QLog.isColorLevel()) {
          QLog.d("FileHttpUtils<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong2 + "], size[" + i + "]");
        }
        return i;
        paramLong1 = FMConstants.V;
      }
    }
    FMConstants.T = paramSSCM.a(BaseApplication.getContext(), paramLong1, paramLong2);
    if (paramLong1 < FMConstants.T + paramLong2) {}
    for (paramLong1 -= paramLong2;; paramLong1 = FMConstants.T)
    {
      i = (int)paramLong1;
      break;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        str1 = '0' + str2;
      }
      System.out.print(str1.toUpperCase() + " ");
      localStringBuffer.append(str1.toUpperCase() + "");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 4)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i >>> 24).byteValue();
      i <<= 8;
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(short paramShort)
  {
    byte[] arrayOfByte = new byte[2];
    short s = 0;
    int i = paramShort;
    paramShort = s;
    while (paramShort < 2)
    {
      arrayOfByte[paramShort] = Integer.valueOf(i >>> 8).byteValue();
      i = (short)(i << 8);
      paramShort += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils
 * JD-Core Version:    0.7.0.1
 */