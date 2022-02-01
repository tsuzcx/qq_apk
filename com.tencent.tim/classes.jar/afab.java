import MQQ.ItemCfgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class afab
{
  public static ArrayList<ItemCfgInfo> J(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          localObject = a(((JSONObject)localObject).toString());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QVIP.NamePlateCfgInfo", 1, "parseJsonArray2List exception message = " + paramString.getMessage());
    }
    return null;
  }
  
  public static ItemCfgInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      ItemCfgInfo localItemCfgInfo = new ItemCfgInfo();
      localItemCfgInfo.vipType = paramString.optInt("vipType");
      localItemCfgInfo.itemJumUrl = o(paramString.optString("itemJumUrl"));
      return localItemCfgInfo;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QVIP.NamePlateCfgInfo", 1, "parseJsonObject2Item exception message = " + paramString.getMessage());
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "getVipNamePlateJumUrl");
    }
    paramQQAppInterface = j(paramQQAppInterface, paramString);
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      return b(paramInt, paramLong, paramQQAppInterface);
    }
    return null;
  }
  
  public static JSONObject a(ItemCfgInfo paramItemCfgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "NamePlate converItem2JsonObject");
    }
    if ((paramItemCfgInfo == null) || (paramItemCfgInfo.itemJumUrl == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    HashMap localHashMap;
    try
    {
      localHashMap = new HashMap();
      Iterator localIterator = paramItemCfgInfo.itemJumUrl.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(String.valueOf(((Long)localEntry.getKey()).longValue()), localEntry.getValue());
      }
      localJSONObject.put("vipType", paramItemCfgInfo.vipType);
    }
    catch (Exception paramItemCfgInfo)
    {
      paramItemCfgInfo.printStackTrace();
      QLog.e("QVIP.NamePlateCfgInfo", 1, "converItem2JsonObject exception message = " + paramItemCfgInfo.getMessage());
      return null;
    }
    localJSONObject.put("itemJumUrl", new JSONObject(localHashMap));
    return localJSONObject;
  }
  
  public static String b(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "getCfgJumpUrl type = " + paramInt + " nameplateId = " + paramLong + " json = \n" + paramString);
    }
    paramString = J(paramString);
    if (paramString == null) {
      return null;
    }
    Map.Entry localEntry;
    do
    {
      paramString = paramString.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            localObject = (ItemCfgInfo)paramString.next();
          } while ((localObject == null) || (((ItemCfgInfo)localObject).vipType != paramInt));
          localObject = ((ItemCfgInfo)localObject).itemJumUrl;
        } while (localObject == null);
        localObject = ((Map)localObject).entrySet().iterator();
      }
      localEntry = (Map.Entry)((Iterator)localObject).next();
    } while ((localEntry == null) || (localEntry.getKey() == null) || (((Long)localEntry.getKey()).longValue() != paramLong));
    return (String)localEntry.getValue();
    return null;
  }
  
  public static String j(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.e(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.nameplateCfgInfo;
      }
    }
    return null;
  }
  
  public static void k(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "NamePlate vipNamePlateClickReport namePlateId = " + paramLong);
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A59C", (int)paramLong, 0, "", "", "", "");
  }
  
  public static Map<Long, String> o(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = awki.B(paramString);
    } while (localObject == null);
    paramString = new HashMap(((Map)localObject).size());
    Object localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry != null) {
        paramString.put(Long.valueOf(Long.parseLong((String)localEntry.getKey())), (String)localEntry.getValue());
      }
    }
    return paramString;
  }
  
  public static String q(ArrayList<ItemCfgInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      JSONObject localJSONObject = a((ItemCfgInfo)paramArrayList.next());
      if (localJSONObject != null) {
        localJSONArray.put(localJSONObject);
      }
    }
    return localJSONArray.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afab
 * JD-Core Version:    0.7.0.1
 */