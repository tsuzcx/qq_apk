import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class abbf
{
  private static boolean bBK = true;
  public static HashMap<String, String> ia;
  private static Object object = new Object();
  
  static
  {
    ia = new HashMap();
  }
  
  public static void Dp(boolean paramBoolean)
  {
    bBK = paramBoolean;
  }
  
  public static boolean N(QQAppInterface paramQQAppInterface)
  {
    return XN();
  }
  
  public static boolean XN()
  {
    return bBK;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getInt("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString, 1);
  }
  
  public static Set<String> a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (object)
    {
      paramQQAppInterface = aqmk.a(localSharedPreferences, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      return paramQQAppInterface;
    }
  }
  
  public static void a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      if (e(paramString1, paramQQAppInterface)) {
        h(paramString1, paramQQAppInterface);
      }
      if (f(paramString1, paramQQAppInterface)) {
        i(paramString1, paramQQAppInterface);
      }
    }
    do
    {
      return;
      try
      {
        int i = Integer.parseInt(paramString2);
        if (!e(paramString1, paramQQAppInterface)) {
          g(paramString1, paramQQAppInterface);
        }
        b(paramString1, i, paramQQAppInterface);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.i("SpecialCareManager", 2, "dealWithRespSound|exception = " + paramString1.toString());
  }
  
  public static void a(List<String> paramList1, int paramInt, List<String> paramList2, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ackk)paramQQAppInterface.getBusinessHandler(15);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramList1, paramInt, paramList2);
    }
  }
  
  public static void a(Map<String, Integer> paramMap, QQAppInterface paramQQAppInterface)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (QLog.isColorLevel()) {
        QLog.d("SpecialCareManager", 2, "getSpecialCareSounds from FriendList: " + localEntry.toString());
      }
      String str = (String)localEntry.getKey();
      int i = ((Integer)localEntry.getValue()).intValue();
      localEditor.putInt("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + str, i);
    }
    localEditor.commit();
  }
  
  public static void b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_quota" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void b(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString, paramInt);
    localEditor.commit();
  }
  
  public static void b(List<String> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject1 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    label224:
    for (;;)
    {
      synchronized (object)
      {
        localObject1 = aqmk.a((SharedPreferences)localObject1, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
        if (localObject1 != null) {
          break label224;
        }
        localObject1 = new HashSet();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str1 = (String)paramList.next();
          String str2 = paramQQAppInterface.getCurrentAccountUin() + str1;
          if (!ia.containsKey(str2)) {
            ia.put(str2, str1);
          }
          if (((Set)localObject1).contains(str1)) {
            continue;
          }
          ((Set)localObject1).add(str1);
        }
      }
      paramList = ((Set)localObject1).toArray();
      aqmk.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramList).commit();
      return;
    }
  }
  
  public static void bN(QQAppInterface paramQQAppInterface)
  {
    ia.clear();
    Object localObject = aqmk.a(paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4), "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ia.put(paramQQAppInterface.getCurrentAccountUin() + str, str);
      }
    }
    Dp(false);
  }
  
  public static void bO(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putLong("key_get_special_sound_quota_time" + paramQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void c(int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_svip_quota" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void c(List<String> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    synchronized (object)
    {
      localObject2 = aqmk.a((SharedPreferences)localObject2, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if (localObject2 == null) {
        break label217;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str1 = (String)paramList.next();
        String str2 = paramQQAppInterface.getCurrentAccountUin() + str1;
        if (ia.containsKey(str2)) {
          ia.remove(str2);
        }
        if (((Set)localObject2).contains(str1)) {
          ((Set)localObject2).remove(str1);
        }
      }
    }
    paramList = ((Set)localObject2).toArray();
    aqmk.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramList).commit();
    label217:
  }
  
  public static void d(List<String> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localEditor.remove("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + str);
    }
    localEditor.commit();
  }
  
  public static boolean e(String paramString, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (object)
    {
      paramQQAppInterface = aqmk.a(localSharedPreferences, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()) && (paramQQAppInterface.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean f(String paramString, QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).contains("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString);
  }
  
  public static void g(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    Object localObject2 = paramQQAppInterface.getCurrentAccountUin() + paramString;
    if (!ia.containsKey(localObject2)) {
      ia.put(localObject2, paramString);
    }
    synchronized (object)
    {
      localObject2 = aqmk.a((SharedPreferences)localObject1, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashSet();
      }
      if (((Set)localObject1).contains(paramString)) {
        return;
      }
      ((Set)localObject1).add(paramString);
      paramString = ((Set)localObject1).toArray();
      aqmk.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramString).commit();
      return;
    }
  }
  
  public static void h(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    ??? = paramQQAppInterface.getCurrentAccountUin() + paramString;
    if (ia.containsKey(???)) {
      ia.remove(???);
    }
    synchronized (object)
    {
      localObject2 = aqmk.a((SharedPreferences)localObject2, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if (localObject2 != null)
      {
        if (!((Set)localObject2).contains(paramString)) {
          return;
        }
        ((Set)localObject2).remove(paramString);
        paramString = ((Set)localObject2).toArray();
        aqmk.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramString).commit();
      }
      return;
    }
  }
  
  public static void i(String paramString, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.remove("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString);
    localEditor.commit();
  }
  
  public static boolean jb(String paramString)
  {
    return ia.containsKey(paramString);
  }
  
  public static int w(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (object)
    {
      paramQQAppInterface = aqmk.a(localSharedPreferences, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.size();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbf
 * JD-Core Version:    0.7.0.1
 */