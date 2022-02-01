package com.tencent.mobileqq.utils;

import GeneralSettings.Setting;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RoamSettingManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopRemarkInfo;
import hbq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBUtils
{
  public static final String a = "troop_photo_new";
  public static final String b = "troop_photo_message";
  public static final String c = "troop_file_new";
  public static final String d = "troop_notification_new";
  private static final String e = "DBUtils";
  private static final String f = "troop_news_notify";
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    int i = Build.VERSION.SDK_INT;
    Context localContext = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localContext.getSharedPreferences("troop_news_notify", i).getInt(paramString1 + paramString2 + paramString3, 0);
    }
  }
  
  public static DBUtils a()
  {
    return hbq.a;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences("troop_news_notify", i).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString1 + paramString2 + paramString3, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public int a(String paramString, Context paramContext)
  {
    String str = paramString + "subaccount_push_notifacation_flag";
    return paramContext.getSharedPreferences(paramString, 0).getInt(str, -1);
  }
  
  public int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramString == null) {
      return 0;
    }
    paramString = "message.group.policy_pc." + paramString;
    return ((RoamSettingManager)paramQQAppInterface.getManager(38)).a(paramString, 0);
  }
  
  public TroopMemberCardInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      paramString1 = (TroopMemberCardInfo)paramQQAppInterface.a(TroopMemberCardInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  public TroopMemberInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      paramString1 = (TroopMemberInfo)paramQQAppInterface.a(TroopMemberInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.a();
    }
  }
  
  /* Error */
  public ArrayList a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +14 -> 15
    //   4: aload_3
    //   5: ifnull +10 -> 15
    //   8: aload_3
    //   9: invokevirtual 139	java/util/ArrayList:size	()I
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 135	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 140	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: aload_1
    //   27: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   30: invokevirtual 115	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore 6
    //   35: aload 6
    //   37: invokevirtual 143	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore 7
    //   42: aload 7
    //   44: invokevirtual 146	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   47: iconst_0
    //   48: istore 4
    //   50: iload 4
    //   52: aload_3
    //   53: invokevirtual 139	java/util/ArrayList:size	()I
    //   56: if_icmpge +249 -> 305
    //   59: aload_3
    //   60: iload 4
    //   62: invokevirtual 150	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 152	friendlist/stUinInfo
    //   68: astore 9
    //   70: aload 6
    //   72: ldc 117
    //   74: iconst_2
    //   75: anewarray 119	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 9
    //   86: getfield 156	friendlist/stUinInfo:dwuin	J
    //   89: invokestatic 160	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   92: aastore
    //   93: invokevirtual 124	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   96: checkcast 117	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +164 -> 265
    //   104: iconst_1
    //   105: istore 5
    //   107: aload_1
    //   108: aload 9
    //   110: getfield 156	friendlist/stUinInfo:dwuin	J
    //   113: invokestatic 160	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   116: putfield 163	com/tencent/mobileqq/data/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   119: aload_1
    //   120: aload_2
    //   121: putfield 166	com/tencent/mobileqq/data/TroopMemberCardInfo:troopuin	Ljava/lang/String;
    //   124: aload 9
    //   126: getfield 169	friendlist/stUinInfo:dwFlag	J
    //   129: lconst_1
    //   130: land
    //   131: lconst_0
    //   132: lcmp
    //   133: ifeq +12 -> 145
    //   136: aload_1
    //   137: aload 9
    //   139: getfield 172	friendlist/stUinInfo:sName	Ljava/lang/String;
    //   142: putfield 175	com/tencent/mobileqq/data/TroopMemberCardInfo:name	Ljava/lang/String;
    //   145: aload 9
    //   147: getfield 169	friendlist/stUinInfo:dwFlag	J
    //   150: ldc2_w 176
    //   153: land
    //   154: lconst_0
    //   155: lcmp
    //   156: ifeq +12 -> 168
    //   159: aload_1
    //   160: aload 9
    //   162: getfield 181	friendlist/stUinInfo:cGender	B
    //   165: putfield 184	com/tencent/mobileqq/data/TroopMemberCardInfo:sex	B
    //   168: aload 9
    //   170: getfield 169	friendlist/stUinInfo:dwFlag	J
    //   173: ldc2_w 185
    //   176: land
    //   177: lconst_0
    //   178: lcmp
    //   179: ifeq +12 -> 191
    //   182: aload_1
    //   183: aload 9
    //   185: getfield 189	friendlist/stUinInfo:sPhone	Ljava/lang/String;
    //   188: putfield 192	com/tencent/mobileqq/data/TroopMemberCardInfo:tel	Ljava/lang/String;
    //   191: aload 9
    //   193: getfield 169	friendlist/stUinInfo:dwFlag	J
    //   196: ldc2_w 193
    //   199: land
    //   200: lconst_0
    //   201: lcmp
    //   202: ifeq +12 -> 214
    //   205: aload_1
    //   206: aload 9
    //   208: getfield 197	friendlist/stUinInfo:sEmail	Ljava/lang/String;
    //   211: putfield 200	com/tencent/mobileqq/data/TroopMemberCardInfo:email	Ljava/lang/String;
    //   214: aload 9
    //   216: getfield 169	friendlist/stUinInfo:dwFlag	J
    //   219: ldc2_w 201
    //   222: land
    //   223: lconst_0
    //   224: lcmp
    //   225: ifeq +12 -> 237
    //   228: aload_1
    //   229: aload 9
    //   231: getfield 205	friendlist/stUinInfo:sRemark	Ljava/lang/String;
    //   234: putfield 208	com/tencent/mobileqq/data/TroopMemberCardInfo:memo	Ljava/lang/String;
    //   237: iload 5
    //   239: ifeq +40 -> 279
    //   242: aload 6
    //   244: aload_1
    //   245: invokevirtual 211	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   248: pop
    //   249: aload 8
    //   251: aload_1
    //   252: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: iload 4
    //   258: iconst_1
    //   259: iadd
    //   260: istore 4
    //   262: goto -212 -> 50
    //   265: new 117	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   268: dup
    //   269: invokespecial 216	com/tencent/mobileqq/data/TroopMemberCardInfo:<init>	()V
    //   272: astore_1
    //   273: iconst_0
    //   274: istore 5
    //   276: goto -169 -> 107
    //   279: aload 6
    //   281: aload_1
    //   282: invokevirtual 219	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   285: goto -36 -> 249
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   293: aload 7
    //   295: invokevirtual 221	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   298: aload 6
    //   300: invokevirtual 126	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   303: aconst_null
    //   304: areturn
    //   305: aload 7
    //   307: invokevirtual 223	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   310: aload 7
    //   312: invokevirtual 221	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   315: aload 6
    //   317: invokevirtual 126	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   320: aload 8
    //   322: areturn
    //   323: astore_1
    //   324: aload 7
    //   326: invokevirtual 221	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   329: aload 6
    //   331: invokevirtual 126	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	DBUtils
    //   0	336	1	paramQQAppInterface	QQAppInterface
    //   0	336	2	paramString	String
    //   0	336	3	paramArrayList	ArrayList
    //   48	213	4	i	int
    //   105	170	5	j	int
    //   33	297	6	localEntityManager	EntityManager
    //   40	285	7	localEntityTransaction	EntityTransaction
    //   24	297	8	localArrayList	ArrayList
    //   68	162	9	localstUinInfo	friendlist.stUinInfo
    // Exception table:
    //   from	to	target	type
    //   42	47	288	java/lang/Exception
    //   50	100	288	java/lang/Exception
    //   107	145	288	java/lang/Exception
    //   145	168	288	java/lang/Exception
    //   168	191	288	java/lang/Exception
    //   191	214	288	java/lang/Exception
    //   214	237	288	java/lang/Exception
    //   242	249	288	java/lang/Exception
    //   249	256	288	java/lang/Exception
    //   265	273	288	java/lang/Exception
    //   279	285	288	java/lang/Exception
    //   305	310	288	java/lang/Exception
    //   42	47	323	finally
    //   50	100	323	finally
    //   107	145	323	finally
    //   145	168	323	finally
    //   168	191	323	finally
    //   191	214	323	finally
    //   214	237	323	finally
    //   242	249	323	finally
    //   249	256	323	finally
    //   265	273	323	finally
    //   279	285	323	finally
    //   289	293	323	finally
    //   305	310	323	finally
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (localArrayList.size() == 0)) {
      return localArrayList;
    }
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i);
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((String)localObject).split("\\.");
        if ((localObject != null) && (localObject.length != 0)) {
          localArrayList.add(localObject[(localObject.length - 1)]);
        }
      }
    }
    return localArrayList;
  }
  
  public Map a(List paramList, int paramInt, QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localHashMap;
    }
    if (paramQQAppInterface == null) {
      return localHashMap;
    }
    paramQQAppInterface = (RoamSettingManager)paramQQAppInterface.getManager(38);
    int i = 0;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(str, Integer.valueOf(paramQQAppInterface.a("message.group.policy." + str, paramInt)));
      }
    }
    return localHashMap;
  }
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "saveGeneralSettingRevision=" + paramInt);
    }
    ((RoamSettingManager)paramQQAppInterface.getManager(38)).a(paramInt);
  }
  
  public void a(String paramString, Context paramContext)
  {
    String str = paramString + "subaccount_push_notifacation_flag";
    paramContext.getSharedPreferences(paramString, 0).edit().remove(str).commit();
  }
  
  public void a(String paramString, Context paramContext, int paramInt)
  {
    String str = paramString + "subaccount_push_notifacation_flag";
    paramContext.getSharedPreferences(paramString, 0).edit().putInt(str, paramInt).commit();
  }
  
  public void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    String str = paramString + "subaccount_show_in_recentlist_first";
    paramContext.getSharedPreferences(paramString, 0).edit().putBoolean(str, paramBoolean).commit();
  }
  
  public void a(String paramString1, String paramString2, Context paramContext)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (paramString2 == null) {
      return;
    }
    paramString2 = paramContext.getSharedPreferences(paramString2, 0).edit();
    paramString2.remove("message.group.policy." + paramString1);
    paramString2.commit();
  }
  
  public void a(ArrayList paramArrayList, QQAppInterface paramQQAppInterface)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    long l;
    label205:
    do
    {
      return;
      l = 0L;
      if (QLog.isColorLevel())
      {
        l = System.currentTimeMillis();
        QLog.d("RoamSetting", 2, "saveGeneralSettings setting start size = " + paramArrayList.size());
      }
      RoamSettingManager localRoamSettingManager = (RoamSettingManager)paramQQAppInterface.getManager(38);
      int i = 0;
      if (i < paramArrayList.size())
      {
        Object localObject1 = (Setting)paramArrayList.get(i);
        String str = ((Setting)localObject1).Path;
        Object localObject2 = ((Setting)localObject1).Value;
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "saveGeneralSettings path =" + str + "; value = " + (String)localObject2);
        }
        if (str == null) {}
        for (;;)
        {
          i += 1;
          break;
          int j;
          if ((localObject2 != null) && (((String)localObject2).length() != 0))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equalsIgnoreCase("")) {}
          }
          else
          {
            j = RoamSettingController.a(str);
            if (j != 1) {
              break label277;
            }
            localObject1 = String.valueOf(1);
          }
          localRoamSettingManager.a(str, (String)localObject1);
          if (("message.ring.switch".equals(str)) || ("message.vibrate.switch".equals(str)))
          {
            localObject2 = BaseApplication.getContext().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
            try
            {
              ((SharedPreferences.Editor)localObject2).putString(str, (String)localObject1);
              ((SharedPreferences.Editor)localObject2).commit();
              continue;
              if (j == 2)
              {
                localObject1 = String.valueOf(0);
                break label205;
              }
              if (j == 3)
              {
                localObject1 = String.valueOf(0);
                break label205;
              }
              if (j == 4)
              {
                localObject1 = "";
                break label205;
              }
              if (j == 5)
              {
                localObject1 = "";
                break label205;
              }
              if (j == 6)
              {
                localObject1 = String.valueOf(1);
                break label205;
              }
              localObject1 = "0";
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    label277:
    QLog.d("DBUtils", 2, "GeneralSettings zsw saveGeneralSettings setting end, consume time =" + (System.currentTimeMillis() - l));
  }
  
  public void a(boolean paramBoolean, String paramString, Context paramContext)
  {
    paramContext.getSharedPreferences(paramString, 0).edit().putBoolean("subaccount_is_top_in_recentlist", paramBoolean).commit();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, TroopMemberCardInfo paramTroopMemberCardInfo)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramTroopMemberCardInfo.getStatus() == 1000)
    {
      paramQQAppInterface.b(paramTroopMemberCardInfo);
      if (paramTroopMemberCardInfo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramTroopMemberCardInfo.getStatus() != 1001) && (paramTroopMemberCardInfo.getStatus() != 1002)) {
      return bool;
    }
    return paramQQAppInterface.a(paramTroopMemberCardInfo);
  }
  
  public boolean a(String paramString, Context paramContext)
  {
    String str = paramString + "subaccount_show_in_recentlist_first";
    return paramContext.getSharedPreferences(paramString, 0).getBoolean(str, false);
  }
  
  public Object[] a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = null;
    arrayOfObject[1] = Boolean.valueOf(false);
    if (paramArrayList == null) {
      return arrayOfObject;
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    ArrayList localArrayList = new ArrayList();
    arrayOfObject[0] = localArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramArrayList.size()) {
          break label598;
        }
        localstTroopRemarkInfo = (stTroopRemarkInfo)paramArrayList.get(i);
        localObject1 = (TroopMemberCardInfo)localEntityManager.a(TroopMemberCardInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
        if (localObject1 == null) {
          continue;
        }
        j = 1;
        ((TroopMemberCardInfo)localObject1).email = localstTroopRemarkInfo.sEmail;
        ((TroopMemberCardInfo)localObject1).memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
        ((TroopMemberCardInfo)localObject1).memo = localstTroopRemarkInfo.sMemo;
        ((TroopMemberCardInfo)localObject1).name = localstTroopRemarkInfo.sName;
        ((TroopMemberCardInfo)localObject1).nick = localstTroopRemarkInfo.strNick;
        ((TroopMemberCardInfo)localObject1).sex = localstTroopRemarkInfo.cGender;
        ((TroopMemberCardInfo)localObject1).tel = localstTroopRemarkInfo.sPhone;
        ((TroopMemberCardInfo)localObject1).troopuin = paramString;
        ((TroopMemberCardInfo)localObject1).level = localstTroopRemarkInfo.strRank;
        if (j == 0) {
          continue;
        }
        localEntityManager.a((Entity)localObject1);
        localArrayList.add(localObject1);
        localObject1 = (TroopMemberInfo)localEntityManager.a(TroopMemberInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
        if (localObject1 == null) {
          continue;
        }
        j = 1;
      }
      catch (Exception paramQQAppInterface)
      {
        stTroopRemarkInfo localstTroopRemarkInfo;
        Object localObject2;
        Iterator localIterator;
        Integer localInteger;
        arrayOfObject[1] = Boolean.valueOf(false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("handlerGetTroopMemberCardInfoList()", 2, paramQQAppInterface.toString());
        localEntityTransaction.b();
        localEntityManager.a();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handlerGetTroopMemberCardInfoList", 2, "insertTroopMemberCardList bRet = " + arrayOfObject[1]);
        return arrayOfObject;
        Object localObject1 = new TroopMemberInfo();
        int j = 0;
        continue;
        localEntityManager.a((Entity)localObject1);
      }
      finally
      {
        localEntityTransaction.b();
        localEntityManager.a();
      }
      ((TroopMemberInfo)localObject1).troopnick = localstTroopRemarkInfo.sName;
      ((TroopMemberInfo)localObject1).friendnick = localstTroopRemarkInfo.strNick;
      ((TroopMemberInfo)localObject1).memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
      ((TroopMemberInfo)localObject1).sex = localstTroopRemarkInfo.cGender;
      ((TroopMemberInfo)localObject1).troopuin = paramString;
      if ((localstTroopRemarkInfo.strRank != null) && (localstTroopRemarkInfo.strRank.length() > 0))
      {
        localObject2 = (FriendsManagerImp)paramQQAppInterface.getManager(8);
        if (localObject2 != null)
        {
          localObject2 = ((FriendsManagerImp)localObject2).a(paramString);
          if (localObject2 != null)
          {
            localObject2 = ((TroopInfo)localObject2).getTroopLevelMap();
            if (localObject2 != null)
            {
              localIterator = ((HashMap)localObject2).keySet().iterator();
              if (localIterator.hasNext())
              {
                localInteger = (Integer)localIterator.next();
                if (!localstTroopRemarkInfo.strRank.equals(((HashMap)localObject2).get(localInteger))) {
                  continue;
                }
                ((TroopMemberInfo)localObject1).level = localInteger.intValue();
              }
            }
          }
        }
      }
      if (j != 0)
      {
        localEntityManager.a((Entity)localObject1);
        break label624;
        localObject1 = new TroopMemberCardInfo();
        j = 0;
        continue;
        localEntityManager.a((Entity)localObject1);
        continue;
      }
      else
      {
        label598:
        arrayOfObject[1] = Boolean.valueOf(true);
        localEntityTransaction.c();
        localEntityTransaction.b();
        localEntityManager.a();
        continue;
      }
      label624:
      i += 1;
    }
  }
  
  public boolean b(String paramString, Context paramContext)
  {
    return paramContext.getSharedPreferences(paramString, 0).getBoolean("subaccount_is_top_in_recentlist", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DBUtils
 * JD-Core Version:    0.7.0.1
 */