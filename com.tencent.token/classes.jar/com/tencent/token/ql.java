package com.tencent.token;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

final class ql
{
  private static final SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss SSS");
  private static final byte[] b = { 4, 0, 0, 0, -1, -1, -1, 0 };
  
  public static void a(PrintStream paramPrintStream, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if ((paramPrintStream != null) && (!qs.a(paramArrayOfByte)) && (!qs.b(paramString1)))
    {
      if (qs.b(paramString2)) {
        return;
      }
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(a.format(Long.valueOf(System.currentTimeMillis())));
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
          paramPrintStream.write(ox.a(paramArrayOfByte.length));
          paramPrintStream.write(paramArrayOfByte);
          paramPrintStream.write(b);
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
 * Qualified Name:     com.tencent.token.ql
 * JD-Core Version:    0.7.0.1
 */