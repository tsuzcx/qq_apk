import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public class adca
{
  public static String TAG = "AREngine_ARPromotion";
  static adcc a;
  
  public static adbv a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (adbv)((QQAppInterface)paramAppInterface).getManager(279);
    }
    if (AudioHelper.isDev()) {
      throw new IllegalArgumentException(acfp.m(2131709986));
    }
    return null;
  }
  
  public static adcc a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (AudioHelper.isDev())) {
      throw new IllegalArgumentException(acfp.m(2131709984));
    }
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new adcc(paramAppInterface);
      }
      return a;
    }
    finally {}
  }
  
  public static boolean isActivity(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.hF();
    return (paramLong1 < l) && (paramLong2 > l);
  }
  
  public static boolean isExpired(long paramLong)
  {
    return paramLong < AudioHelper.hF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adca
 * JD-Core Version:    0.7.0.1
 */