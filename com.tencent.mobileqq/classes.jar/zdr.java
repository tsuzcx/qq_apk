import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zdr
{
  public static String a;
  private static Map<String, String> a;
  static String b = "wns_share_data";
  private static String c = zdr.class.getName();
  
  static
  {
    jdField_a_of_type_JavaLangString = "EXTRA_DATAV1";
  }
  
  public static int a()
  {
    try
    {
      Map localMap = zds.a();
      if (localMap == null) {
        return 0;
      }
      Object localObject;
      if (NetworkState.isWifiConn()) {
        localObject = bjrk.a();
      }
      while (localObject != null)
      {
        localObject = (String)localMap.get(localObject);
        if (localObject == null)
        {
          return 0;
          localObject = NetworkState.getAPN();
        }
        else
        {
          localObject = ((String)localObject).split(":");
          if ((localObject != null) && (localObject.length > 0))
          {
            int i = Integer.valueOf(localObject[0]).intValue();
            return i;
          }
          return 0;
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      QLog.e(c, 2, "read wifi operator by bssid fail", localException);
    }
    return 0;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    String str2 = "";
    String str1 = str2;
    switch (paramInt)
    {
    default: 
      str1 = str2;
    }
    while (!TextUtils.isEmpty(str1))
    {
      a(str1);
      return;
      str1 = "3";
      continue;
      str1 = "0";
      continue;
      str1 = "2";
      continue;
      str1 = "1";
    }
  }
  
  public static void a(String paramString)
  {
    String str;
    if (NetworkState.isWifiConn())
    {
      str = bjrk.a();
      if (str != null)
      {
        a(str, paramString + ":" + System.currentTimeMillis());
        QLog.d("QzoneIPStracyConfig", 2, "save bssid=" + str + ",value=" + paramString + ":" + System.currentTimeMillis());
      }
    }
    do
    {
      return;
      str = NetworkState.getAPN();
    } while (str == null);
    a(str.toLowerCase(), paramString + ":" + System.currentTimeMillis());
    QLog.d("QzoneIPStracyConfig", 2, "save apn=" + str.toLowerCase() + ",value=" + paramString + ":" + System.currentTimeMillis());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    jdField_a_of_type_JavaUtilMap = zds.a();
    if (jdField_a_of_type_JavaUtilMap != null) {
      jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    }
    for (;;)
    {
      a(jdField_a_of_type_JavaUtilMap);
      zds.a(jdField_a_of_type_JavaUtilMap);
      return;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    }
  }
  
  private static void a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (true == paramMap.isEmpty())) {}
    long l;
    do
    {
      do
      {
        return;
      } while (BaseApplication.getContext() == null);
      l = zds.a();
      QLog.d("ConfigProvider", 2, "last_check_time:" + l);
    } while (System.currentTimeMillis() - l <= 86400000L);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = ((String)paramMap.get(str)).split(":");
      if ((arrayOfString != null) && (arrayOfString.length >= 2) && (System.currentTimeMillis() - Long.parseLong(arrayOfString[1]) > 2592000000L)) {
        localArrayList.add(str);
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      paramMap.remove((String)localIterator.next());
    }
    localArrayList.clear();
    QLog.e("ConfigProvider", 2, " last_check_time:" + System.currentTimeMillis());
    zds.a(System.currentTimeMillis());
  }
  
  public static boolean a(Map<String, byte[]> paramMap, boolean paramBoolean)
  {
    if (paramMap == null) {
      return false;
    }
    Set localSet = paramMap.keySet();
    Iterator localIterator = localSet.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      if ((localObject1 == null) || (!((String)localObject1).equals("ExtraConfig"))) {
        break label493;
      }
      Object localObject2 = (byte[])paramMap.get(localObject1);
      localObject1 = new UniAttribute();
      ((UniAttribute)localObject1).decode((byte[])localObject2);
      localObject2 = ((UniAttribute)localObject1).getKeySet();
      if (localSet == null) {
        break label493;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = (String)((Iterator)localObject2).next();
        String str1 = (String)((UniAttribute)localObject1).get(str2);
        if ((str2 == null) || (!str2.equals("WifiCarrierType")) || (str1 == null)) {
          break label490;
        }
        QLog.d("QzoneIPStracyConfig", 2, str2 + "=" + str1);
        try
        {
          if (Integer.valueOf(str1).intValue() >= 0) {
            break label271;
          }
          QLog.i("ConfigProvider", 2, "receive WiFiOperator error,value=" + str1);
          bool = true;
        }
        catch (Exception localException)
        {
          QLog.i("ConfigProvider", 2, "receive WiFiOperator error,value=" + str1, localException);
          bool = true;
        }
        continue;
        label271:
        String str3;
        if (NetworkState.isWifiConn())
        {
          if (!paramBoolean) {
            bjrk.b();
          }
          str3 = bjrk.a();
          if (str3 != null)
          {
            a(str3, str1 + ":" + System.currentTimeMillis());
            QLog.d("QzoneIPStracyConfig", 2, "save bssid=" + str3 + ",value=" + str1 + ":" + System.currentTimeMillis());
          }
        }
        for (bool = false;; bool = false)
        {
          label375:
          break;
          if (!paramBoolean) {
            NetworkState.isNetSupport();
          }
          str3 = NetworkState.getAPN();
          if (str3 != null)
          {
            a(str3.toLowerCase(), str1 + ":" + System.currentTimeMillis());
            QLog.d("QzoneIPStracyConfig", 2, "save apn=" + str3.toLowerCase() + ",value=" + str1 + ":" + System.currentTimeMillis());
          }
        }
      }
    }
    label490:
    label493:
    for (;;)
    {
      break;
      return bool;
      break label375;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdr
 * JD-Core Version:    0.7.0.1
 */