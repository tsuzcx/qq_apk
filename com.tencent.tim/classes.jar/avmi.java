import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;

public class avmi
{
  public static boolean B(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      paramAppInterface = (acja)paramAppInterface.getManager(56);
      if (paramAppInterface != null) {
        return paramAppInterface.b("1805987832") != null;
      }
    }
    return false;
  }
  
  public static short a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return VipUtils.a(paramQQAppInterface, paramString);
  }
  
  public static void aT(@NonNull Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("QR_OUT_SETTING", 0).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static int bB(Context paramContext)
  {
    return g(paramContext, "QR_USERPREF58", -1);
  }
  
  public static void ba(Context paramContext, int paramInt)
  {
    aT(paramContext, "QR_USERPREF58", paramInt);
  }
  
  public static int g(@NonNull Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences("QR_OUT_SETTING", 0).getInt(paramString, paramInt);
  }
  
  public static int u(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    int i = j;
    int k;
    if (paramQQAppInterface != null)
    {
      k = VipUtils.a(paramQQAppInterface, paramString);
      if ((k & 0x4) == 0) {
        break label26;
      }
      i = 2;
    }
    label26:
    do
    {
      return i;
      i = j;
    } while ((k & 0x2) == 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmi
 * JD-Core Version:    0.7.0.1
 */