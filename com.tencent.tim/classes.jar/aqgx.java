import GeneralSettings.Setting;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.DBUtils.1;
import com.tencent.mobileqq.utils.DBUtils.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class aqgx
{
  aqgx.b a = new aqgx.b(10, 32);
  
  public static aqgx a()
  {
    return aqgx.a.a;
  }
  
  public static boolean c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return BaseApplication.getContext().getSharedPreferences(paramString1, 0).getBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
  }
  
  public static void k(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    if (paramBoolean)
    {
      localEditor.putBoolean(paramString1 + "group_file_inner_reddot_tim" + paramString3, true);
      localEditor.putBoolean(paramString1 + "group_file_reddot_tim" + paramString3, true);
    }
    for (;;)
    {
      localEditor.putBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
      localEditor.commit();
      return;
      localEditor.putBoolean(paramString1 + "group_file_inner_reddot_tim" + paramString3, false);
      localEditor.putBoolean(paramString1 + "group_file_reddot_tim" + paramString3, false);
    }
  }
  
  public static void l(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    localEditor.putBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
    localEditor.commit();
  }
  
  public static int m(String paramString1, String paramString2, String paramString3)
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("troop_news_notify", i).getInt(paramString1 + paramString2 + paramString3, 0);
    }
  }
  
  public static void v(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("troop_news_notify", i).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString1 + paramString2 + paramString3, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public void SB(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().putBoolean("hasShowBindDialog", paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setHasShowBindDialog:" + paramBoolean);
  }
  
  public TroopMemberCardInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    try
    {
      paramString1 = (TroopMemberCardInfo)paramQQAppInterface.find(TroopMemberCardInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.close();
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
      paramString1 = (TroopMemberInfo)paramQQAppInterface.find(TroopMemberInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.close();
    }
  }
  
  public Map<String, Integer> a(List<String> paramList, int paramInt, QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localHashMap;
    }
    if (paramQQAppInterface == null) {
      return localHashMap;
    }
    acld localacld = (acld)paramQQAppInterface.getManager(40);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str1 = (String)paramList.get(i);
      if ((str1 == null) || (str1.length() == 0)) {}
      for (;;)
      {
        i += 1;
        break;
        paramQQAppInterface = new StringBuilder(40);
        paramQQAppInterface.append("message.group.policy.");
        paramQQAppInterface.append(str1);
        String str2 = paramQQAppInterface.toString();
        RoamSetting localRoamSetting = localacld.a(str2);
        paramQQAppInterface = localRoamSetting;
        if (localRoamSetting == null)
        {
          paramQQAppInterface = localRoamSetting;
          if (!TextUtils.isEmpty(str2))
          {
            paramQQAppInterface = new RoamSetting(str2, Integer.toString(paramInt));
            localArrayList.add(paramQQAppInterface);
          }
        }
        localHashMap.put(str1, Integer.valueOf(RoamSetting.getIntValue(paramQQAppInterface, paramInt)));
      }
    }
    if (localArrayList.size() > 0) {
      this.a.ao(new DBUtils.1(this, localArrayList, localacld));
    }
    return localHashMap;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Context paramContext)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (paramString2 == null) {
      return;
    }
    paramString2 = paramContext.getSharedPreferences(paramString2, 0).edit();
    paramString1 = "message.group.policy." + paramString1;
    paramString2.remove(paramString1);
    paramString2.commit();
    ((acld)paramQQAppInterface.getManager(40)).EL(paramString1);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, TroopMemberCardInfo paramTroopMemberCardInfo)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramTroopMemberCardInfo.getStatus() == 1000)
    {
      paramQQAppInterface.persistOrReplace(paramTroopMemberCardInfo);
      if (paramTroopMemberCardInfo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramTroopMemberCardInfo.getStatus() != 1001) && (paramTroopMemberCardInfo.getStatus() != 1002)) {
      return bool;
    }
    return paramQQAppInterface.update(paramTroopMemberCardInfo);
  }
  
  public Object[] a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = null;
    arrayOfObject[1] = Boolean.valueOf(false);
    if (paramArrayList == null) {
      return arrayOfObject;
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    ArrayList localArrayList = new ArrayList();
    arrayOfObject[0] = localArrayList;
    int i = 0;
    label701:
    for (;;)
    {
      try
      {
        if (i < paramArrayList.size())
        {
          stTroopRemarkInfo localstTroopRemarkInfo = (stTroopRemarkInfo)paramArrayList.get(i);
          Object localObject = (TroopMemberCardInfo)localEntityManager.find(TroopMemberCardInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
          int j;
          if (localObject != null)
          {
            j = 1;
            ((TroopMemberCardInfo)localObject).email = localstTroopRemarkInfo.sEmail;
            ((TroopMemberCardInfo)localObject).memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
            ((TroopMemberCardInfo)localObject).memo = localstTroopRemarkInfo.sMemo;
            ((TroopMemberCardInfo)localObject).colorNick = aqpm.D(localstTroopRemarkInfo.sName.getBytes());
            if (((TroopMemberCardInfo)localObject).colorNick == null) {
              ((TroopMemberCardInfo)localObject).colorNick = localstTroopRemarkInfo.sName;
            }
            ((TroopMemberCardInfo)localObject).name = aqpm.pQ(((TroopMemberCardInfo)localObject).colorNick);
            ((TroopMemberCardInfo)localObject).nick = localstTroopRemarkInfo.strNick;
            ((TroopMemberCardInfo)localObject).sex = localstTroopRemarkInfo.cGender;
            ((TroopMemberCardInfo)localObject).tel = localstTroopRemarkInfo.sPhone;
            ((TroopMemberCardInfo)localObject).troopuin = paramString;
            ((TroopMemberCardInfo)localObject).level = localstTroopRemarkInfo.strRank;
            ((TroopMemberCardInfo)localObject).job = localstTroopRemarkInfo.bytes_job;
            ((TroopMemberCardInfo)localObject).charm = ((int)localstTroopRemarkInfo.GlamourLevel);
            ((TroopMemberCardInfo)localObject).torchFlag = ((int)localstTroopRemarkInfo.TorchbearerFlag);
            if (j != 0)
            {
              localEntityManager.update((Entity)localObject);
              localArrayList.add(localObject);
              TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localEntityManager.find(TroopMemberInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
              if (localTroopMemberInfo == null) {
                break label701;
              }
              localTroopMemberInfo.troopColorNick = ((TroopMemberCardInfo)localObject).colorNick;
              localTroopMemberInfo.troopnick = ((TroopMemberCardInfo)localObject).name;
              localTroopMemberInfo.friendnick = localstTroopRemarkInfo.strNick;
              localTroopMemberInfo.memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
              localTroopMemberInfo.sex = localstTroopRemarkInfo.cGender;
              localTroopMemberInfo.troopuin = paramString;
              localTroopMemberInfo.mGlamourLevel = ((int)localstTroopRemarkInfo.GlamourLevel);
              localTroopMemberInfo.mVipType = ((TroopMemberCardInfo)localObject).mVipType;
              localTroopMemberInfo.mVipLevel = ((TroopMemberCardInfo)localObject).mVipLevel;
              if ((localstTroopRemarkInfo.strRank != null) && (localstTroopRemarkInfo.strRank.length() > 0))
              {
                localObject = (TroopManager)paramQQAppInterface.getManager(52);
                if (localObject != null)
                {
                  localObject = ((TroopManager)localObject).b(paramString);
                  if (localObject != null)
                  {
                    localObject = ((TroopInfo)localObject).getTroopLevelMap();
                    if (localObject != null)
                    {
                      Iterator localIterator = ((HashMap)localObject).keySet().iterator();
                      if (localIterator.hasNext())
                      {
                        Integer localInteger = (Integer)localIterator.next();
                        if (!localstTroopRemarkInfo.strRank.equals(((HashMap)localObject).get(localInteger))) {
                          continue;
                        }
                        localTroopMemberInfo.realLevel = localInteger.intValue();
                      }
                    }
                  }
                }
              }
              localEntityManager.update(localTroopMemberInfo);
              break label701;
            }
          }
          else
          {
            localObject = new TroopMemberCardInfo();
            j = 0;
            continue;
          }
          localEntityManager.persist((Entity)localObject);
          continue;
        }
        i += 1;
      }
      catch (Exception paramQQAppInterface)
      {
        arrayOfObject[1] = Boolean.valueOf(false);
        if (QLog.isColorLevel()) {
          QLog.e("handlerGetTroopMemberCardInfoList()", 2, paramQQAppInterface.toString());
        }
        localEntityTransaction.end();
        localEntityManager.close();
        if (QLog.isColorLevel()) {
          QLog.d("handlerGetTroopMemberCardInfoList", 2, "insertTroopMemberCardList bRet = " + arrayOfObject[1]);
        }
        return arrayOfObject;
        arrayOfObject[1] = Boolean.valueOf(true);
        localEntityTransaction.commit();
        localEntityTransaction.end();
        localEntityManager.close();
      }
      finally
      {
        localEntityTransaction.end();
        localEntityManager.close();
      }
    }
  }
  
  public boolean aCB()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localSharedPreferences.getBoolean("hasShowBindDialog", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "hasShowBindDialog:" + bool2);
    return bool2;
  }
  
  public int aK(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("subaccount_sp", 0).getInt("subaccount_sp_version", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountVersion() ver=" + i);
    }
    return i;
  }
  
  public boolean am(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    do
    {
      return bool2;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
      paramContext = paramContext.getSharedPreferences("subaccount_sp", 0);
      paramString = paramString + "subaccount_show_in_recentlist_first";
      if (localSharedPreferences.getBoolean(paramString, false))
      {
        localSharedPreferences.edit().remove(paramString).commit();
        paramContext.edit().putBoolean(paramString, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() update showedBefore:=true");
        }
      }
      if (localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false))
      {
        bool2 = localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false);
        localSharedPreferences.edit().remove("subaccount_is_top_in_recentlist").commit();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() remove isTopRU=" + bool2);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() isTop=" + bool1);
    return bool1;
  }
  
  public boolean an(Context paramContext, String paramString)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    return paramContext.getSharedPreferences("subaccount_sp", 0).getBoolean(paramString, false);
  }
  
  /* Error */
  public ArrayList<TroopMemberCardInfo> b(QQAppInterface paramQQAppInterface, String paramString, ArrayList<friendlist.stUinInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +14 -> 15
    //   4: aload_3
    //   5: ifnull +10 -> 15
    //   8: aload_3
    //   9: invokevirtual 221	java/util/ArrayList:size	()I
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 170	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 171	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: aload_1
    //   27: invokevirtual 127	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   30: invokevirtual 133	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore 6
    //   35: aload 6
    //   37: invokevirtual 266	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore 7
    //   42: aload 7
    //   44: invokevirtual 271	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   47: iconst_0
    //   48: istore 4
    //   50: iload 4
    //   52: aload_3
    //   53: invokevirtual 221	java/util/ArrayList:size	()I
    //   56: if_icmpge +249 -> 305
    //   59: aload_3
    //   60: iload 4
    //   62: invokevirtual 272	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 482	friendlist/stUinInfo
    //   68: astore 9
    //   70: aload 6
    //   72: ldc 135
    //   74: iconst_2
    //   75: anewarray 137	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 9
    //   86: getfield 485	friendlist/stUinInfo:dwuin	J
    //   89: invokestatic 281	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   92: aastore
    //   93: invokevirtual 143	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   96: checkcast 135	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +164 -> 265
    //   104: iconst_1
    //   105: istore 5
    //   107: aload_1
    //   108: aload 9
    //   110: getfield 485	friendlist/stUinInfo:dwuin	J
    //   113: invokestatic 281	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   116: putfield 291	com/tencent/mobileqq/data/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   119: aload_1
    //   120: aload_2
    //   121: putfield 342	com/tencent/mobileqq/data/TroopMemberCardInfo:troopuin	Ljava/lang/String;
    //   124: aload 9
    //   126: getfield 488	friendlist/stUinInfo:dwFlag	J
    //   129: lconst_1
    //   130: land
    //   131: lconst_0
    //   132: lcmp
    //   133: ifeq +12 -> 145
    //   136: aload_1
    //   137: aload 9
    //   139: getfield 489	friendlist/stUinInfo:sName	Ljava/lang/String;
    //   142: putfield 320	com/tencent/mobileqq/data/TroopMemberCardInfo:name	Ljava/lang/String;
    //   145: aload 9
    //   147: getfield 488	friendlist/stUinInfo:dwFlag	J
    //   150: ldc2_w 490
    //   153: land
    //   154: lconst_0
    //   155: lcmp
    //   156: ifeq +12 -> 168
    //   159: aload_1
    //   160: aload 9
    //   162: getfield 492	friendlist/stUinInfo:cGender	B
    //   165: putfield 333	com/tencent/mobileqq/data/TroopMemberCardInfo:sex	B
    //   168: aload 9
    //   170: getfield 488	friendlist/stUinInfo:dwFlag	J
    //   173: ldc2_w 493
    //   176: land
    //   177: lconst_0
    //   178: lcmp
    //   179: ifeq +12 -> 191
    //   182: aload_1
    //   183: aload 9
    //   185: getfield 495	friendlist/stUinInfo:sPhone	Ljava/lang/String;
    //   188: putfield 339	com/tencent/mobileqq/data/TroopMemberCardInfo:tel	Ljava/lang/String;
    //   191: aload 9
    //   193: getfield 488	friendlist/stUinInfo:dwFlag	J
    //   196: ldc2_w 496
    //   199: land
    //   200: lconst_0
    //   201: lcmp
    //   202: ifeq +12 -> 214
    //   205: aload_1
    //   206: aload 9
    //   208: getfield 498	friendlist/stUinInfo:sEmail	Ljava/lang/String;
    //   211: putfield 288	com/tencent/mobileqq/data/TroopMemberCardInfo:email	Ljava/lang/String;
    //   214: aload 9
    //   216: getfield 488	friendlist/stUinInfo:dwFlag	J
    //   219: ldc2_w 499
    //   222: land
    //   223: lconst_0
    //   224: lcmp
    //   225: ifeq +12 -> 237
    //   228: aload_1
    //   229: aload 9
    //   231: getfield 503	friendlist/stUinInfo:sRemark	Ljava/lang/String;
    //   234: putfield 297	com/tencent/mobileqq/data/TroopMemberCardInfo:memo	Ljava/lang/String;
    //   237: iload 5
    //   239: ifeq +40 -> 279
    //   242: aload 6
    //   244: aload_1
    //   245: invokevirtual 256	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   248: pop
    //   249: aload 8
    //   251: aload_1
    //   252: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: iload 4
    //   258: iconst_1
    //   259: iadd
    //   260: istore 4
    //   262: goto -212 -> 50
    //   265: new 135	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   268: dup
    //   269: invokespecial 432	com/tencent/mobileqq/data/TroopMemberCardInfo:<init>	()V
    //   272: astore_1
    //   273: iconst_0
    //   274: istore 5
    //   276: goto -169 -> 107
    //   279: aload 6
    //   281: aload_1
    //   282: invokevirtual 435	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   285: goto -36 -> 249
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   293: aload 7
    //   295: invokevirtual 444	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   298: aload 6
    //   300: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   303: aconst_null
    //   304: areturn
    //   305: aload 7
    //   307: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   310: aload 7
    //   312: invokevirtual 444	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   315: aload 6
    //   317: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   320: aload 8
    //   322: areturn
    //   323: astore_1
    //   324: aload 7
    //   326: invokevirtual 444	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   329: aload 6
    //   331: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	aqgx
    //   0	336	1	paramQQAppInterface	QQAppInterface
    //   0	336	2	paramString	String
    //   0	336	3	paramArrayList	ArrayList<friendlist.stUinInfo>
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
  
  public void c(ArrayList<Setting> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    long l = 0L;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      QLog.d("RoamSetting", 2, "saveGeneralSettings setting start size = " + paramArrayList.size());
    }
    acld localacld = (acld)paramQQAppInterface.getManager(40);
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String str;
    label174:
    int j;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        paramQQAppInterface = (Setting)paramArrayList.get(i);
        str = paramQQAppInterface.Path;
        paramQQAppInterface = paramQQAppInterface.Value;
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "saveGeneralSettings path =" + str + "; value = " + paramQQAppInterface);
        }
        if (str == null)
        {
          paramQQAppInterface = (QQAppInterface)localObject;
          i += 1;
          localObject = paramQQAppInterface;
        }
        else
        {
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0) && (!paramQQAppInterface.equalsIgnoreCase(""))) {
            break label538;
          }
          j = aqlz.fk(str);
          if (j == 1) {
            paramQQAppInterface = String.valueOf(1);
          }
        }
      }
    }
    label538:
    for (;;)
    {
      label223:
      RoamSetting localRoamSetting = localacld.a(str, paramQQAppInterface);
      if (localRoamSetting != null) {
        localArrayList.add(localRoamSetting);
      }
      if (("message.ring.switch".equals(str)) || ("message.vibrate.switch".equals(str)) || ("message.ring.care".equals(str)))
      {
        if (localObject == null) {
          localObject = localSharedPreferences.edit();
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              ((SharedPreferences.Editor)localObject).putString(str, paramQQAppInterface);
              paramQQAppInterface = (QQAppInterface)localObject;
            }
            catch (Exception paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
              paramQQAppInterface = (QQAppInterface)localObject;
            }
            break label174;
            if (j == 2)
            {
              paramQQAppInterface = String.valueOf(0);
              break label223;
            }
            if (j == 3)
            {
              paramQQAppInterface = String.valueOf(0);
              break label223;
            }
            if (j == 4)
            {
              paramQQAppInterface = "";
              break label223;
            }
            if (j == 5)
            {
              paramQQAppInterface = "";
              break label223;
            }
            if (j == 6)
            {
              paramQQAppInterface = String.valueOf(1);
              break label223;
            }
            if (j == 7)
            {
              paramQQAppInterface = String.valueOf(0);
              break label223;
            }
            if (j == 8)
            {
              paramQQAppInterface = String.valueOf(1);
              break label223;
            }
            paramQQAppInterface = "0";
            break label223;
            if (Looper.getMainLooper().getThread() == Thread.currentThread())
            {
              ThreadManager.post(new DBUtils.2(this, localacld, localArrayList), 5, null, false);
              if (localObject == null) {}
            }
            try
            {
              ((SharedPreferences.Editor)localObject).commit();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DBUtils", 2, "GeneralSettings zsw saveGeneralSettings setting end, consume time =" + (System.currentTimeMillis() - l));
              return;
              localacld.jg(localArrayList);
            }
            catch (Exception paramArrayList)
            {
              for (;;)
              {
                paramArrayList.printStackTrace();
              }
            }
          }
        }
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      break label174;
    }
  }
  
  public void dl(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      paramString = paramString + "bindQQAgain";
      localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "setShownAgainBindDialog() " + paramString + ":" + paramBoolean);
  }
  
  public int fe(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      i = j;
    }
    label19:
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return i;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
        i = j;
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      j = localSharedPreferences.getInt(paramString, 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, paramString + ":" + j);
    return j;
  }
  
  public void fy(Context paramContext)
  {
    int i = aewh.getVersionCode(paramContext);
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putInt("subaccount_sp_version", i).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setSubAccountVersion() ver=" + i);
    }
  }
  
  public void gn(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      paramInt += 1;
      localSharedPreferences.edit().putInt(paramString, paramInt).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "set " + paramString + "=" + paramInt);
  }
  
  public void h(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public void l(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "saveGeneralSettingRevision=" + paramInt);
    }
    ((acld)paramQQAppInterface.getManager(40)).JJ(paramInt);
  }
  
  public boolean ro(String paramString)
  {
    if (((paramString == null) || (paramString.length() < 5)) && (QLog.isColorLevel())) {
      QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() return.FALSE: mainUin=" + paramString);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramString = paramString + "bindQQAgain";
      bool2 = localSharedPreferences.getBoolean(paramString, false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() " + paramString + ":" + bool2);
    return bool2;
  }
  
  static class a
  {
    static aqgx a = new aqgx(null);
  }
  
  public static class b
    implements ThreadExcutor.IThreadListener
  {
    ConcurrentLinkedQueue<Runnable> O = new ConcurrentLinkedQueue();
    private int dZi;
    private int mRunningTaskNum;
    private int mThreadType;
    
    public b(int paramInt1, int paramInt2)
    {
      this.dZi = paramInt1;
      this.mThreadType = paramInt2;
      this.mRunningTaskNum = 0;
    }
    
    public void ao(Runnable paramRunnable)
    {
      this.O.offer(paramRunnable);
      runNext();
    }
    
    public void onAdded() {}
    
    public void onPostRun()
    {
      this.mRunningTaskNum -= 1;
      runNext();
    }
    
    public void onPreRun() {}
    
    public void runNext()
    {
      if (this.mRunningTaskNum < this.dZi)
      {
        Runnable localRunnable = (Runnable)this.O.poll();
        if (localRunnable != null)
        {
          this.mRunningTaskNum += 1;
          ThreadManager.excute(localRunnable, this.mThreadType, this, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgx
 * JD-Core Version:    0.7.0.1
 */