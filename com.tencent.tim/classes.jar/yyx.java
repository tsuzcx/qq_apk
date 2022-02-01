import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class yyx
{
  private static HashMap<String, Integer> hk = new HashMap();
  private static HashMap<String, Long> hl = new HashMap();
  private static HashMap<String, List<yxd>> hm = new HashMap();
  private static HashMap<String, HashMap<String, Boolean>> hn = new HashMap();
  
  public static void S(String paramString, long paramLong)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString))) {
      hl.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public static long V(String paramString)
  {
    long l = 0L;
    if (hl.containsKey(paramString)) {
      l = ((Long)hl.get(paramString)).longValue();
    }
    return l;
  }
  
  public static byte a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.e(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.gender;
      }
    }
    return 0;
  }
  
  public static List<yvy> a(ArrayList<yxd> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList.isEmpty()) || (paramQQAppInterface == null)) {
      return localArrayList;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = String.valueOf(((yxd)paramArrayList.get(i)).troopUin);
      TroopInfo localTroopInfo = paramQQAppInterface.c(str);
      if ((localTroopInfo != null) && (localTroopInfo.troopname != null) && (!localTroopInfo.troopname.isEmpty()))
      {
        yvy localyvy = new yvy();
        localyvy.b = localTroopInfo;
        localyvy.mTroopUin = str;
        localyvy.mCount = ((yxd)paramArrayList.get(i)).mCount;
        localArrayList.add(localyvy);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localArrayList.add(paramString2);
      paramString2 = (acms)paramQQAppInterface.getBusinessHandler(20);
    } while (paramString2 == null);
    paramString2.a(paramString1, localArrayList, paramString3);
  }
  
  public static boolean a(long paramLong, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopWithCommonFriendsHelper", 2, "getTroopWithCommonFriendsList,frienduin:" + paramLong);
    }
    String str = String.valueOf(paramLong);
    paramQQAppInterface = (ahpj)paramQQAppInterface.getBusinessHandler(153);
    if (!il(str))
    {
      paramQQAppInterface.S(bR(str), ah(str));
      if (QLog.isColorLevel()) {
        QLog.d("TroopWithCommonFriendsHelper", 2, "getTroopWithCommonFriendsList:EnableGetTroopList,false");
      }
      return false;
    }
    if ((paramLong > 0L) && (paramInt != 0))
    {
      paramQQAppInterface.aK(paramLong, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean ae(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (HashMap)hn.get(paramString1);
      if ((paramString1 != null) && (paramString1.containsKey(paramString2))) {
        return ((Boolean)paramString1.get(paramString2)).booleanValue();
      }
    }
    return true;
  }
  
  public static List<yxd> ah(String paramString)
  {
    Object localObject = new ArrayList();
    if (hm.containsKey(paramString)) {
      localObject = (List)hm.get(paramString);
    }
    return localObject;
  }
  
  public static int bR(String paramString)
  {
    int i = 0;
    if (hk.containsKey(paramString)) {
      i = ((Integer)hk.get(paramString)).intValue();
    }
    return i;
  }
  
  public static void cH(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString))) {
      hk.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public static boolean il(String paramString)
  {
    long l1 = (System.currentTimeMillis() - V(paramString)) / 1000L;
    long l2 = bR(paramString);
    if ((l1 < l2) && (l2 != 0L)) {
      return false;
    }
    zp(paramString);
    zq(paramString);
    zr(paramString);
    return true;
  }
  
  public static void t(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, Boolean.valueOf(paramBoolean));
    hn.put(paramString1, localHashMap);
  }
  
  public static void u(String paramString, List<yxd> paramList)
  {
    if (!TextUtils.isEmpty(paramString)) {
      hm.put(paramString, paramList);
    }
  }
  
  public static void zp(String paramString)
  {
    if (hk.containsKey(paramString)) {
      hk.remove(paramString);
    }
  }
  
  public static void zq(String paramString)
  {
    if (hl.containsKey(paramString)) {
      hl.remove(paramString);
    }
  }
  
  public static void zr(String paramString)
  {
    if (hm.containsKey(paramString)) {
      hm.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyx
 * JD-Core Version:    0.7.0.1
 */