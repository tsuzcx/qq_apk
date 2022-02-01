import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;
import tencent.im.PluginConfig.PluginConfig.GetResourceReqInfo;

public class acgw
{
  public static int B(QQAppInterface paramQQAppInterface)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.getPreferences().getInt("sp_key_leba_group_seq", 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("LebaHelper", 2, "getLebaGroup, seq=" + j);
    return j;
  }
  
  public static int C(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    int i = paramQQAppInterface.getPreferences().getInt("sp_key_leba_plugin_type", 0);
    QLog.i("LebaHelper", 1, "getLebaPluginType =" + i);
    return i;
  }
  
  public static int D(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    int i = paramQQAppInterface.getPreferences().getInt("sp_key_leba_layout_type", 0);
    QLog.d("LebaHelper", 1, "getLebaLayoutType =" + i);
    return i;
  }
  
  public static void F(List<aevs> paramList1, List<aevs> paramList2)
  {
    Collections.sort(paramList2, new acgw.a());
    paramList2 = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (paramList2.hasNext())
    {
      aevs localaevs1 = (aevs)paramList2.next();
      aevs localaevs2;
      if (gw(localaevs1.a.sPriority) != j)
      {
        localaevs2 = new aevs();
        if (paramList1.size() > 0) {
          if (i < 2)
          {
            ((aevs)paramList1.get(paramList1.size() - 1)).cPu = 0;
            label101:
            localaevs2.bCo = "empty_normal";
            label108:
            paramList1.add(localaevs2);
            j = gw(localaevs1.a.sPriority);
            localaevs1.cPu = 1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        paramList1.add(localaevs1);
        break;
        ((aevs)paramList1.get(paramList1.size() - 1)).cPu = 2;
        break label101;
        localaevs2.bCo = "empty_normal";
        break label108;
        i += 1;
        localaevs1.cPu = 3;
      }
    }
    if (paramList1.size() > 0)
    {
      if (i < 2) {
        ((aevs)paramList1.get(paramList1.size() - 1)).cPu = 0;
      }
    }
    else {
      return;
    }
    ((aevs)paramList1.get(paramList1.size() - 1)).cPu = 2;
  }
  
  public static void G(List<aevs> paramList, List<Integer> paramList1)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        QLog.i("leba_sort", 1, "userSortList == null || userSortList.isEmpty()");
        Collections.sort(paramList, new acgw.a());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("sortTableItem");
      localStringBuilder.append(" us=").append(paramList1);
      ArrayList localArrayList = new ArrayList();
      Collections.sort(paramList, new acgw.a());
      Iterator localIterator = paramList.iterator();
      aevs localaevs;
      while (localIterator.hasNext())
      {
        localaevs = (aevs)localIterator.next();
        for (;;)
        {
          try
          {
            j = paramList1.indexOf(Integer.valueOf((int)localaevs.WP));
            if (j < 0) {
              continue;
            }
            localaevs.cPv = j;
          }
          catch (Exception localException)
          {
            QLog.i("leba_sort", 1, "sortTableItem", localException);
            continue;
            localStringBuilder.append(",fix ").append(localaevs.WP);
          }
          if (localaevs.aig()) {
            continue;
          }
          localArrayList.add(localaevs);
          break;
          localaevs.cPv = 2147483647;
        }
      }
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      Collections.sort(localArrayList, new acgw.b());
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        k = j;
        if (!((aevs)paramList.get(i)).aig())
        {
          k = j;
          if (j < localArrayList.size())
          {
            paramList.set(i, localArrayList.get(j));
            k = j + 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public static int a(acgu.a parama)
  {
    if (parama == null) {
      return 0;
    }
    return parama.cwh * 1000 + parama.index;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getPreferences().getLong("sp_key_leba_plugin_user_sort_time" + paramInt, 0L);
  }
  
  public static List<Integer> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    localArrayList = new ArrayList();
    QQAppInterface localQQAppInterface = null;
    try
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_plugin_user_sort_list" + paramInt, "");
      localQQAppInterface = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        localQQAppInterface = paramQQAppInterface;
        JSONArray localJSONArray = new JSONArray(paramQQAppInterface);
        paramInt = 0;
        for (;;)
        {
          localQQAppInterface = paramQQAppInterface;
          if (paramInt >= localJSONArray.length()) {
            break;
          }
          localQQAppInterface = paramQQAppInterface;
          localArrayList.add(Integer.valueOf(localJSONArray.getInt(paramInt)));
          paramInt += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("leba_sort", 1, "getSortInfo " + localQQAppInterface, paramQQAppInterface);
    }
  }
  
  public static PluginConfig.GetResourceReq a(int paramInt, List<LebaPluginInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramList.next();
        if (localLebaPluginInfo != null)
        {
          PluginConfig.GetResourceReqInfo localGetResourceReqInfo = new PluginConfig.GetResourceReqInfo();
          localGetResourceReqInfo.res_id.set((int)localLebaPluginInfo.uiResId);
          localGetResourceReqInfo.res_seq.set(localLebaPluginInfo.sResSeq);
          localArrayList.add(localGetResourceReqInfo);
        }
      }
    }
    if (anwa.aze()) {}
    for (int i = 4026;; i = 4000)
    {
      QLog.i("LebaHelper", 1, "getLebaPluginListReq pluginType = " + i);
      paramList = new PluginConfig.GetResourceReq();
      paramList.plugin_type.set(i);
      paramList.plugin_layout_seq.set(paramInt);
      paramList.reqinfo_list.set(localArrayList);
      return paramList;
    }
  }
  
  public static void a(SharedPreferences paramSharedPreferences, List<Integer> paramList, Long paramLong, int paramInt)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Integer localInteger = (Integer)paramList.next();
          if (localInteger != null) {
            localJSONArray.put(localInteger);
          }
        }
        paramSharedPreferences.putString("sp_key_leba_plugin_user_sort_list" + paramInt, localJSONArray.toString());
      }
    }
    catch (Exception paramSharedPreferences)
    {
      QLog.i("leba_sort", 1, "saveSortInfo", paramSharedPreferences);
      return;
    }
    if (paramLong != null) {
      paramSharedPreferences.putLong("sp_key_leba_plugin_user_sort_time" + paramInt, paramLong.longValue());
    }
    paramSharedPreferences.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    if (paramLong == 100000L) {
      return (paramQQAppInterface.a() != null) && (paramQQAppInterface.a().aav());
    }
    boolean bool;
    if (paramBoolean)
    {
      paramQQAppInterface = (LebaPluginInfo)paramMap.get(Long.valueOf(paramLong));
      if ((paramQQAppInterface != null) && ((paramQQAppInterface == null) || (paramQQAppInterface.showInSimpleMode != 0))) {
        break label140;
      }
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "needShowRedDot, id=" + paramLong + ", isSimpleMode=" + paramBoolean + ", needShow=" + bool);
      }
      return bool;
      if (!zjq.a().e(paramQQAppInterface, paramLong)) {
        bool = false;
      } else {
        label140:
        bool = true;
      }
    }
  }
  
  public static boolean ag(QQAppInterface paramQQAppInterface)
  {
    if (anwa.aze()) {}
    for (int i = 4026; i != C(paramQQAppInterface); i = 4000) {
      return true;
    }
    return false;
  }
  
  public static boolean ah(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_upgrade_info", "");
    if (!"3058".equals(paramQQAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramQQAppInterface, "3058" }));
      }
      return bool;
    }
  }
  
  public static Map<Long, acgu.a> c(List<acgu.a> paramList)
  {
    if (paramList == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      acgu.a locala = (acgu.a)paramList.next();
      if (locala != null) {
        localHashMap.put(Long.valueOf(locala.uiResId), locala);
      }
    }
    return localHashMap;
  }
  
  public static boolean c(aevs paramaevs)
  {
    if ((paramaevs.a.cDataType == 1) && (!TextUtils.isEmpty(paramaevs.a.strPkgName))) {
      return "qzone_feedlist".equals(paramaevs.a.strPkgName);
    }
    return false;
  }
  
  public static void cs(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("sp_key_leba_upgrade_info", "3058");
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, String.format("update version, buildNum[%s]", new Object[] { "3058" }));
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    QLog.i("LebaHelper", 1, "saveLebaInfo,layoutType = " + paramInt1 + ",pluginType" + paramInt2);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("sp_key_leba_layout_type", paramInt1);
    paramQQAppInterface.putInt("sp_key_leba_plugin_type", paramInt2);
    paramQQAppInterface.commit();
  }
  
  /* Error */
  public static List<acgu.a> f(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 34
    //   8: iconst_2
    //   9: ldc_w 420
    //   12: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: new 156	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 157	java/util/ArrayList:<init>	()V
    //   22: astore_3
    //   23: aload_0
    //   24: invokevirtual 18	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   27: ldc_w 422
    //   30: ldc 213
    //   32: invokeinterface 217 3 0
    //   37: astore_0
    //   38: new 224	org/json/JSONArray
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 225	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   46: astore_0
    //   47: iconst_0
    //   48: istore_1
    //   49: iload_1
    //   50: aload_0
    //   51: invokevirtual 228	org/json/JSONArray:length	()I
    //   54: if_icmpge +129 -> 183
    //   57: aload_0
    //   58: iload_1
    //   59: invokevirtual 426	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   62: astore 4
    //   64: aload 4
    //   66: invokevirtual 432	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   69: astore 5
    //   71: aload 5
    //   73: ifnull +153 -> 226
    //   76: new 195	acgu$a
    //   79: dup
    //   80: invokespecial 433	acgu$a:<init>	()V
    //   83: astore 6
    //   85: iconst_0
    //   86: istore_2
    //   87: iload_2
    //   88: aload 5
    //   90: invokevirtual 228	org/json/JSONArray:length	()I
    //   93: if_icmpge +92 -> 185
    //   96: aload 5
    //   98: iload_2
    //   99: invokevirtual 436	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   102: astore 7
    //   104: ldc_w 437
    //   107: aload 7
    //   109: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: ifeq +18 -> 130
    //   115: aload 6
    //   117: aload 4
    //   119: aload 7
    //   121: invokevirtual 440	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   124: putfield 388	acgu$a:uiResId	J
    //   127: goto +106 -> 233
    //   130: ldc_w 442
    //   133: aload 7
    //   135: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +18 -> 156
    //   141: aload 6
    //   143: aload 4
    //   145: aload 7
    //   147: invokevirtual 445	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   150: putfield 198	acgu$a:cwh	I
    //   153: goto +80 -> 233
    //   156: ldc_w 446
    //   159: aload 7
    //   161: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +69 -> 233
    //   167: aload 6
    //   169: aload 4
    //   171: aload 7
    //   173: invokevirtual 445	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   176: putfield 201	acgu$a:index	I
    //   179: goto +54 -> 233
    //   182: astore_0
    //   183: aload_3
    //   184: areturn
    //   185: aload_3
    //   186: aload 6
    //   188: invokeinterface 132 2 0
    //   193: pop
    //   194: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +29 -> 226
    //   200: ldc 34
    //   202: iconst_2
    //   203: new 36	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   210: ldc 213
    //   212: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 66	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iload_1
    //   227: iconst_1
    //   228: iadd
    //   229: istore_1
    //   230: goto -181 -> 49
    //   233: iload_2
    //   234: iconst_1
    //   235: iadd
    //   236: istore_2
    //   237: goto -150 -> 87
    //   240: astore 7
    //   242: goto -9 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramQQAppInterface	QQAppInterface
    //   48	182	1	i	int
    //   86	151	2	j	int
    //   22	164	3	localArrayList	ArrayList
    //   62	108	4	localJSONObject	JSONObject
    //   69	28	5	localJSONArray	JSONArray
    //   83	133	6	locala	acgu.a
    //   102	70	7	str	String
    //   240	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   38	47	182	org/json/JSONException
    //   49	71	182	org/json/JSONException
    //   76	85	182	org/json/JSONException
    //   87	104	182	org/json/JSONException
    //   104	127	182	org/json/JSONException
    //   130	153	182	org/json/JSONException
    //   156	179	182	org/json/JSONException
    //   185	226	182	org/json/JSONException
    //   104	127	240	java/lang/Exception
    //   130	153	240	java/lang/Exception
    //   156	179	240	java/lang/Exception
  }
  
  public static void f(QQAppInterface paramQQAppInterface, List<acgu.a> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "saveGroupInfo");
    }
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          acgu.a locala = (acgu.a)paramList.next();
          if (locala == null) {
            continue;
          }
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("uiResId", locala.uiResId);
            localJSONObject.put("groudId", locala.cwh);
            localJSONObject.put("index", locala.index);
            localJSONArray.put(localJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("LebaHelper", 2, "" + locala);
            }
          }
          catch (JSONException paramList)
          {
            QLog.e("LebaHelper", 1, "saveGroupInfo, exp=", paramList);
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putString("sp_key_leba_group_info", localJSONArray.toString());
      paramQQAppInterface.commit();
    } while (!QLog.isColorLevel());
    QLog.i("LebaHelper", 2, "saveGroupInfo, result=" + true);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (7720L == paramLong)
      {
        int i = aqmj.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
        paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
        if ((i == 1) && (paramQQAppInterface.isResourceReady())) {}
        for (boolean bool = false;; bool = true) {
          return bool;
        }
      }
      if (7759L != paramLong) {
        break;
      }
      paramQQAppInterface = ((aegs)paramQQAppInterface.getManager(269)).a();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.cMJ < 1));
    return false;
    return false;
  }
  
  public static void gN(List<aevs> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramList.size());
    localLinkedHashSet.addAll(paramList);
    paramList.clear();
    paramList.addAll(localLinkedHashSet);
  }
  
  public static int gw(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static void o(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "saveLebaGroupSeq，seq=" + paramInt);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("sp_key_leba_group_seq", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static class a
    implements Comparator<aevs>
  {
    private boolean d(aevs paramaevs)
    {
      return (paramaevs != null) && (paramaevs.a != null);
    }
    
    public int a(aevs paramaevs1, aevs paramaevs2)
    {
      if ((d(paramaevs1)) && (d(paramaevs2))) {
        if (paramaevs1.a.sPriority <= paramaevs2.a.sPriority) {}
      }
      do
      {
        return 1;
        if (paramaevs1.a.sPriority < paramaevs2.a.sPriority) {
          return -1;
        }
        return 0;
        if (d(paramaevs1)) {
          return -1;
        }
      } while (d(paramaevs2));
      return 0;
    }
  }
  
  public static class b
    implements Comparator<aevs>
  {
    public int a(aevs paramaevs1, aevs paramaevs2)
    {
      if (paramaevs1.cPv > paramaevs2.cPv) {}
      do
      {
        return 1;
        if (paramaevs1.cPv < paramaevs2.cPv) {
          return -1;
        }
      } while (paramaevs1.a.sPriority > paramaevs2.a.sPriority);
      if (paramaevs1.a.sPriority < paramaevs2.a.sPriority) {
        return -1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgw
 * JD-Core Version:    0.7.0.1
 */