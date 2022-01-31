import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil.1;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil.2;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil.3;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class zva
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 7;
    case 2: 
      return 0;
    case 3: 
      return 9;
    case 4: 
      return 11;
    case 5: 
      return 12;
    case 6: 
      return 13;
    }
    return 14;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return "android";
    case 2: 
      return "ark";
    case 5: 
      return "limi";
    case 3: 
      return "mini_game";
    case 4: 
      return "mini_app";
    case 6: 
      return "qqpay";
    }
    return "web";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.util", 2, "url is empty");
      }
    }
    do
    {
      return null;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DoraemonOpenAPI.util", 2, "scheme not match " + paramString);
    return null;
    int i = paramString.indexOf('?');
    int j = paramString.indexOf('#');
    if (i == -1)
    {
      i = j;
      if (j == -1) {
        i = paramString.length();
      }
    }
    for (;;)
    {
      return paramString.substring(0, i);
      if (j != -1) {
        i = Math.min(i, j);
      }
    }
  }
  
  public static void a(zrt paramzrt, int paramInt)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.4(paramzrt, paramInt));
  }
  
  public static void a(zrt paramzrt, int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.2(paramzrt, paramInt, paramString));
  }
  
  public static void a(zrt paramzrt, JSONObject paramJSONObject)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.1(paramzrt, paramJSONObject));
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public static void b(zrt paramzrt, JSONObject paramJSONObject)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.3(paramzrt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zva
 * JD-Core Version:    0.7.0.1
 */