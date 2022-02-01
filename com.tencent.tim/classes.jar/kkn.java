import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class kkn
{
  public static long a(AdData paramAdData)
  {
    if (kmx.e(paramAdData)) {
      return 30102L;
    }
    if (kmx.c(paramAdData)) {
      return 30103L;
    }
    return 0L;
  }
  
  private static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return "0";
          if (paramBoolean1) {
            return "1";
          }
        } while (!paramBoolean2);
        return "0";
        return "8";
        return "9";
        if (paramBoolean1) {
          return "2";
        }
      } while (!paramBoolean2);
      return "1";
    } while (!paramBoolean2);
    return "2";
  }
  
  public static kkp a(AdData paramAdData)
  {
    if (paramAdData != null) {
      return paramAdData.a;
    }
    return null;
  }
  
  public static JSONObject a(AdData paramAdData, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if (paramAdData == null) {
      return null;
    }
    kkp localkkp = a(paramAdData);
    String str;
    HashMap localHashMap;
    if ((paramAdData instanceof ProteusInnerData))
    {
      str = ((ProteusInnerData)paramAdData).aJR + "";
      localHashMap = new HashMap();
      localHashMap.put("oper_module", Long.valueOf(a(paramAdData)));
      localHashMap.put("oper_id", Long.valueOf(paramLong1));
      localHashMap.put("oper_type", Long.valueOf(paramLong2));
      localHashMap.put("obj_id", "" + str);
      localHashMap.put("loc_id", "0");
      if (localkkp == null) {
        break label351;
      }
      str = localkkp.appid;
      label144:
      localHashMap.put("app_id", str);
      if (localkkp == null) {
        break label358;
      }
      str = localkkp.packageName;
      label166:
      localHashMap.put("game_pkg", str);
      localHashMap.put("ex1", paramString1);
      if (localkkp == null) {
        break label365;
      }
    }
    label351:
    label358:
    label365:
    for (paramString1 = localkkp.ZR;; paramString1 = "")
    {
      localHashMap.put("ex2", paramString1);
      localHashMap.put("ex3", paramAdData.rowkey);
      localHashMap.put("ex4", paramAdData.abq);
      localHashMap.put("ex5", paramString2);
      paramAdData = new JSONObject();
      paramString1 = localHashMap.keySet();
      try
      {
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramAdData.put(paramString2, localHashMap.get(paramString2));
        }
        str = "";
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = new JSONObject();
        try
        {
          paramString1.put("game_gift_report", paramAdData.toString());
          return paramString1;
        }
        catch (JSONException paramAdData)
        {
          paramAdData.printStackTrace();
          return paramString1;
        }
      }
      break;
      str = "";
      break label144;
      str = "";
      break label166;
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    knd.f(paramAdvertisementInfo);
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    jzk.a(new kku.a().a(localQQAppInterface).a(BaseApplication.getContext()).a(119).b(39).e(paramJSONObject2).a(paramAdvertisementInfo).d(paramJSONObject1).a());
  }
  
  public static void a(AdData paramAdData, int paramInt, String paramString)
  {
    if (paramAdData == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GameComponentReport", 2, "adData is null");
      }
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = kmx.e(paramAdData);
      bool2 = kmx.c(paramAdData);
    } while ((!bool1) && (!bool2));
    String str = a(bool1, bool2, paramInt);
    long l;
    if (bool1) {
      l = 3010205L;
    }
    for (;;)
    {
      a(kne.a(paramAdData), jzk.a(paramAdData.abq, paramAdData.rowkey, paramAdData.a.ZR, paramAdData.a.aaa, paramAdData.a.packageName, new HashMap()), a(paramAdData, l, 9L, str, paramString));
      return;
      if (bool2) {
        l = 3010307L;
      } else {
        l = 3010205L;
      }
    }
  }
  
  private static String aY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  public static void b(AdData paramAdData, int paramInt, String paramString)
  {
    if (paramAdData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameComponentReport", 2, "adData is null");
      }
      return;
    }
    String str = aY(paramInt);
    a(kne.a(paramAdData), jzk.a(paramAdData.abq, paramAdData.rowkey, paramAdData.a.ZR, paramAdData.a.aaa, paramAdData.a.packageName, new HashMap()), a(paramAdData, 3010305L, 10L, str, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkn
 * JD-Core Version:    0.7.0.1
 */