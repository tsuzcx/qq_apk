import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class acpz
{
  public static long Rg = 863913600L;
  public static int czd = 9999;
  public static int cze = 2147483647;
  public static int czf = 3000;
  public static Integer[] f = { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3000) };
  public static Integer[] g = { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(3) };
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (NetConnInfoCenter.getServerTime() - paramRecentUser.lastmsgtime >= Rg) {}
    while ((!iE(paramRecentUser.getType())) || ((paramRecentUser.getType() == 1) && (!iF(paramQQAppInterface.cs(paramRecentUser.uin))))) {
      return false;
    }
    return true;
  }
  
  public static boolean iE(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = f;
    int j = arrayOfInteger.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInteger[i].intValue() == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean iF(int paramInt)
  {
    boolean bool2 = false;
    Integer[] arrayOfInteger = g;
    int j = arrayOfInteger.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInteger[i].intValue() == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acpz
 * JD-Core Version:    0.7.0.1
 */