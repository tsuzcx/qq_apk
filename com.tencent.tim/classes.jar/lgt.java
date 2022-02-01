import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class lgt
{
  private void C(String paramString, long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = awit.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("event_simple_g_info_" + lgu.eH(paramString), paramLong);
    awit.a((SharedPreferences.Editor)localObject, true);
  }
  
  private long H(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return -1L;
      localObject = awit.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getLong("event_simple_g_info_" + lgu.eH(paramString), -1L);
  }
  
  private void a(String paramString, TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    while ((paramTroopInfo.timeSec == H(paramTroopInfo.troopuin)) && (!lgs.a().ajZ)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(eI("g_ui"), eI(eH(paramTroopInfo.troopuin)));
    localHashMap.put(eI("g_code"), eI(eH(paramTroopInfo.troopcode)));
    localHashMap.put(eI("g_oui"), eI(eH(paramTroopInfo.troopowneruin)));
    localHashMap.put(eI("g_name"), eI(paramTroopInfo.troopname));
    localHashMap.put(eI("g_mem"), eI(paramTroopInfo.troopmemo));
    localHashMap.put(eI("g_ind"), eI(paramTroopInfo.fingertroopmemo));
    localHashMap.put(eI("g_create_time"), eI(paramTroopInfo.troopCreateTime + ""));
    localHashMap.put(eI("g_mem_num"), eI(paramTroopInfo.wMemberNum + ""));
    localHashMap.put(eI("g_adm"), eI(eJ(paramTroopInfo.Administrator)));
    localHashMap.put(eI("g_class"), eI(paramTroopInfo.mGroupClassExtText));
    localHashMap.put(eI("g_grade"), eI(paramTroopInfo.nTroopGrade + ""));
    localHashMap.put(eI("g_type"), eI(paramTroopInfo.troopTypeExt + ""));
    anpc.a(null).collectPerformance(paramString, "event_simple_g_info", false, 1000L, 1000L, localHashMap, null);
    C(paramTroopInfo.troopuin, paramTroopInfo.timeSec);
  }
  
  private String eH(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return atad.toMD5(paramString);
  }
  
  private String eI(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return Base64.encodeToString(paramString.getBytes(), 3);
  }
  
  private String eJ(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.split("\\|");
    int i = 0;
    while (i < paramString.length)
    {
      if (!TextUtils.isEmpty(paramString[i])) {
        localStringBuilder.append(eH(paramString[i])).append('^');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void S(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).cE();
        if (localObject != null)
        {
          paramQQAppInterface = paramQQAppInterface.getCurrentUin();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a(paramQQAppInterface, (TroopInfo)((Iterator)localObject).next());
            try
            {
              Thread.sleep(1000L);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgt
 * JD-Core Version:    0.7.0.1
 */