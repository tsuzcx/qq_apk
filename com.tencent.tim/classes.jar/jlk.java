import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;

public class jlk
{
  public static int a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return a((QQAppInterface)paramAppInterface, paramString1, paramString2);
    }
    return b(paramAppInterface, paramString1, paramString2);
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.b(paramString2, paramString1) == null) {
          return 3;
        }
        paramQQAppInterface = paramQQAppInterface.b(paramString2);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopOwner(paramString1))) {
          return 0;
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isTroopAdmin(paramString1))) {
          return 1;
        }
        if (paramQQAppInterface != null) {
          return 2;
        }
        return -1;
      }
      return -1;
    }
    return -1;
  }
  
  private static int b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface instanceof jlk.a)) {
      return ((jlk.a)paramAppInterface).g(paramString1, paramString2);
    }
    return -1;
  }
  
  public static int c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    switch (a(paramAppInterface, paramString1, paramString2))
    {
    default: 
      return 4;
    case 0: 
      return 3;
    case 1: 
      return 2;
    case 2: 
      return 1;
    }
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract int g(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlk
 * JD-Core Version:    0.7.0.1
 */