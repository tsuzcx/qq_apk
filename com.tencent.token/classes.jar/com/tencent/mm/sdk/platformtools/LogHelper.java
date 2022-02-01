package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.algorithm.TypeTransform;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

final class LogHelper
{
  private static final SimpleDateFormat aa = new SimpleDateFormat("MM-dd HH:mm:ss SSS");
  private static final byte[] ab = { 4, 0, 0, 0, -1, -1, -1, 0 };
  
  public static void initLogHeader(PrintStream paramPrintStream, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((paramPrintStream != null) && (!Util.isNullOrNil(paramString2)))
    {
      if (paramLong == 0L) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("1 ");
      localStringBuilder.append(paramString1);
      paramPrintStream.println(localStringBuilder.toString());
      paramString1 = new StringBuilder("2 ");
      paramString1.append(paramString2);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("3 ");
      paramString1.append(paramLong);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("4 ");
      paramString1.append(Integer.toHexString(paramInt));
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("5 ");
      paramString1.append(Build.VERSION.RELEASE);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("6 ");
      paramString1.append(Build.VERSION.CODENAME);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("7 ");
      paramString1.append(Build.VERSION.INCREMENTAL);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("8 ");
      paramString1.append(Build.BOARD);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("9 ");
      paramString1.append(Build.DEVICE);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("10 ");
      paramString1.append(Build.DISPLAY);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("11 ");
      paramString1.append(Build.FINGERPRINT);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("12 ");
      paramString1.append(Build.HOST);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("13 ");
      paramString1.append(Build.MANUFACTURER);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("14 ");
      paramString1.append(Build.MODEL);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("15 ");
      paramString1.append(Build.PRODUCT);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("16 ");
      paramString1.append(Build.TAGS);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("17 ");
      paramString1.append(Build.TYPE);
      paramPrintStream.println(paramString1.toString());
      paramString1 = new StringBuilder("18 ");
      paramString1.append(Build.USER);
      paramPrintStream.println(paramString1.toString());
      paramPrintStream.println();
      paramPrintStream.flush();
    }
  }
  
  public static void writeToStream(PrintStream paramPrintStream, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if ((paramPrintStream != null) && (!Util.isNullOrNil(paramArrayOfByte)) && (!Util.isNullOrNil(paramString1)))
    {
      if (Util.isNullOrNil(paramString2)) {
        return;
      }
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(aa.format(Long.valueOf(System.currentTimeMillis())));
        localStringBuffer.append(" ");
        localStringBuffer.append(paramString1);
        localStringBuffer.append(" ");
        localStringBuffer.append(paramString2);
        paramString1 = localStringBuffer.toString();
        try
        {
          paramArrayOfByte = new DESKeySpec(paramArrayOfByte);
          paramArrayOfByte = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte);
          paramString2 = Cipher.getInstance("DES");
          paramString2.init(1, paramArrayOfByte);
          paramArrayOfByte = paramString2.doFinal(paramString1.getBytes());
          paramPrintStream.write(TypeTransform.intToByteArrayLH(paramArrayOfByte.length));
          paramPrintStream.write(paramArrayOfByte);
          paramPrintStream.write(ab);
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        paramPrintStream.flush();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LogHelper
 * JD-Core Version:    0.7.0.1
 */