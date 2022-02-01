import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class aeir
{
  private Map<String, String> jX = new HashMap();
  
  public static aeir a(aeic[] paramArrayOfaeic)
  {
    Object localObject;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      aeir localaeir;
      int i;
      try
      {
        localaeir = new aeir();
        i = 0;
        localObject = localaeir;
        if (i >= paramArrayOfaeic.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaeic[i].taskId) });
        }
        localObject = new JSONObject(paramArrayOfaeic[i].content);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localaeir.jX.put("apolloConfig", paramArrayOfaeic[i].content);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localaeir.jX.put("apolloGame", paramArrayOfaeic[i].content);
        }
      }
      catch (Exception paramArrayOfaeic)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfaeic, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localaeir.jX.put("apolloPreDownload", paramArrayOfaeic[i].content);
      }
      i += 1;
    }
  }
  
  public static String a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    return paramString2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aeir paramaeir)
  {
    if ((paramQQAppInterface == null) || (paramaeir == null) || (paramaeir.jX.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        aeis.cXh();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramaeir.jX.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramaeir.jX.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          abxh.b(str2, paramQQAppInterface, paramBoolean);
          if (paramBoolean) {
            abhh.DB(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            abxh.d(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            abxh.H(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    aeiu.cXi();
  }
  
  public static void cXg()
  {
    try
    {
      String str = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getString("sp_key_config_script", "");
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("ApolloConfig_GlobalProcessor", 1, new Object[] { "rollbackConfig scriptConfig:", str });
        abxh.b(new JSONObject(str), "base_script", false);
        abhh.ch.set(true);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeir
 * JD-Core Version:    0.7.0.1
 */