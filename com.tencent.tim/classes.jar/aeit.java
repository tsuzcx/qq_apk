import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class aeit
{
  private Map<String, String> jY = new HashMap();
  
  public static aeit a(aeic[] paramArrayOfaeic)
  {
    Object localObject;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        aeit localaeit = new aeit();
        i = 0;
        localObject = localaeit;
        if (i >= paramArrayOfaeic.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaeic[i].taskId) });
        }
        localObject = new JSONObject(paramArrayOfaeic[i].content);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localaeit.jY.put("apolloGrayUrlWhite", paramArrayOfaeic[i].content);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localaeit.jY.put("apolloTraceConfig", paramArrayOfaeic[i].content);
        }
      }
      catch (Exception paramArrayOfaeic)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfaeic, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aeit paramaeit)
  {
    if ((paramQQAppInterface == null) || (paramaeit == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramaeit.jY.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramaeit.jY.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          abxh.c(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          abxh.G(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeit
 * JD-Core Version:    0.7.0.1
 */