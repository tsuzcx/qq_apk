import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;

public class alkt
{
  public static String eN(int paramInt)
  {
    return String.valueOf(paramInt & 0xFFFFFFFF);
  }
  
  public static long getLong(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(alkt.class.getSimpleName(), 2, "failed getLong, uin = " + paramString);
      }
    }
    return 0L;
  }
  
  public static String longToString(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static String mO(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    int m = paramString.length() - 4;
    int k = m - 4;
    int i = m;
    if (m < 0) {
      i = 0;
    }
    if (k < 0) {}
    for (;;)
    {
      if ((j < i) && (i > 0)) {
        localStringBuffer.replace(j, i, "*");
      }
      return localStringBuffer.toString();
      j = k;
    }
  }
  
  public static long stringToLong(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w(alkt.class.getSimpleName(), 2, "failed to long:" + paramString);
      }
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkt
 * JD-Core Version:    0.7.0.1
 */