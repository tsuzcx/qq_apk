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

public class sxb
{
  private static String TAG = sxb.class.getName();
  public static String aHS = "EXTRA_DATAV1";
  static String aHT = "wns_share_data";
  private static Map<String, String> gA;
  
  private static void P(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (true == paramMap.isEmpty())) {}
    long l;
    do
    {
      do
      {
        return;
      } while (BaseApplication.getContext() == null);
      l = sxc.aT();
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
    sxc.fy(System.currentTimeMillis());
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
            awdq.GP();
          }
          str3 = awdq.getBSSID();
          if (str3 != null)
          {
            da(str3, str1 + ":" + System.currentTimeMillis());
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
            da(str3.toLowerCase(), str1 + ":" + System.currentTimeMillis());
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
  
  public static void da(String paramString1, String paramString2)
  {
    gA = sxc.O();
    if (gA != null) {
      gA.put(paramString1, paramString2);
    }
    for (;;)
    {
      P(gA);
      sxc.Q(gA);
      return;
      gA = new HashMap();
      gA.put(paramString1, paramString2);
    }
  }
  
  public static void tX(String paramString)
  {
    String str;
    if (NetworkState.isWifiConn())
    {
      str = awdq.getBSSID();
      if (str != null)
      {
        da(str, paramString + ":" + System.currentTimeMillis());
        QLog.d("QzoneIPStracyConfig", 2, "save bssid=" + str + ",value=" + paramString + ":" + System.currentTimeMillis());
      }
    }
    do
    {
      return;
      str = NetworkState.getAPN();
    } while (str == null);
    da(str.toLowerCase(), paramString + ":" + System.currentTimeMillis());
    QLog.d("QzoneIPStracyConfig", 2, "save apn=" + str.toLowerCase() + ",value=" + paramString + ":" + System.currentTimeMillis());
  }
  
  public static int uB()
  {
    try
    {
      Map localMap = sxc.O();
      if (localMap == null) {
        return 0;
      }
      Object localObject;
      if (NetworkState.isWifiConn()) {
        localObject = awdq.getBSSID();
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
      QLog.e(TAG, 2, "read wifi operator by bssid fail", localException);
    }
    return 0;
  }
  
  public static void yZ(int paramInt)
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
      tX(str1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxb
 * JD-Core Version:    0.7.0.1
 */