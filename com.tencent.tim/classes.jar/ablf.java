import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig.1;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ablf
{
  static {}
  
  public static boolean M(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.p();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putInt(paramString, paramInt).apply();
      return true;
    }
    return false;
  }
  
  public static boolean ao(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.p();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putString(paramString1, paramString2).apply();
      return true;
    }
    return false;
  }
  
  public static int b(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = -1;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (abhh)paramQQAppInterface.getManager(153);
      int i;
      if ("aio.city.game".equals(paramString))
      {
        i = j;
        if (paramQQAppInterface != null)
        {
          if (!paramQQAppInterface.bCD) {
            break label45;
          }
          i = ablg.cpH;
        }
      }
      label45:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return i;
              i = -1;
            }
            i = j;
          } while (!"drawer.game".equals(paramString));
          i = j;
        } while (paramQQAppInterface == null);
        i = j;
      } while (!paramQQAppInterface.bCE);
      return ablg.cpF;
    }
    QLog.e("ApolloGameConfig", 1, "app is null");
    return -1;
  }
  
  public static String it(String paramString)
  {
    SharedPreferences localSharedPreferences = ApolloGameUtil.p();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString, "");
    }
    return "";
  }
  
  public static void loadConfig()
  {
    ThreadManager.post(new ApolloGameConfig.1(), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablf
 * JD-Core Version:    0.7.0.1
 */