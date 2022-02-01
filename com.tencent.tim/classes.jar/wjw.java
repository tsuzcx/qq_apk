import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager.1;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.Manager;

public class wjw
  implements Manager
{
  public static String TAG = "AppGuideTipsManager";
  private AppGuideTipsConfig a;
  private int bNI;
  private boolean bcQ;
  private boolean bcR = true;
  private EntityManager em;
  private Map<String, AppGuideTipsConfig> hr = new HashMap();
  private QQAppInterface mApp;
  
  public wjw(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  private void a(MessageRecord paramMessageRecord, AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    paramAppGuideTipsConfig = new MessageForTimDouFuGuide(paramAppGuideTipsConfig);
    paramAppGuideTipsConfig.frienduin = str;
    paramAppGuideTipsConfig.time = l;
    paramAppGuideTipsConfig.istroop = paramMessageRecord.istroop;
    this.mApp.b().a(paramAppGuideTipsConfig, this.mApp.getCurrentAccountUin(), false, false, true, true);
  }
  
  private void b(MessageRecord paramMessageRecord, AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    Object localObject = this.mApp.getCurrentAccountUin();
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    int i = paramAppGuideTipsConfig.tipsMsg.indexOf(paramAppGuideTipsConfig.tipsHighLight);
    int j = paramAppGuideTipsConfig.tipsHighLight.length();
    paramMessageRecord = new ahwa(str, (String)localObject, paramAppGuideTipsConfig.tipsMsg, paramMessageRecord.istroop, -5022, 2621441, l);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", paramAppGuideTipsConfig.tipsUrl);
    paramMessageRecord.addHightlightItem(i, i + j, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.mApp, paramMessageRecord);
    ((MessageForUniteGrayTip)localObject).appGuideTipsOpKey = paramAppGuideTipsConfig.opkey;
    ahwb.a(this.mApp, (MessageForUniteGrayTip)localObject);
  }
  
  private void bYx()
  {
    this.bNI = this.mApp.getPreferences().getInt("tim_is_office_user", 0);
  }
  
  public void Cc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "saveOfficeUserFlag: " + paramInt);
    }
    if (paramInt == this.bNI) {
      return;
    }
    this.bNI = paramInt;
    this.mApp.getPreferences().edit().putInt("tim_is_office_user", paramInt).apply();
  }
  
  public void G(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("app_tail_id");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      break label14;
    }
    for (;;)
    {
      label14:
      return;
      if (!aegu.ag(paramMessageRecord))
      {
        localObject = (AppGuideTipsConfig)this.hr.get(localObject);
        if (localObject == null) {
          break;
        }
        if (((AppGuideTipsConfig)localObject).allow)
        {
          Boolean localBoolean = (Boolean)((AppGuideTipsConfig)localObject).msgTypeMap.get(Integer.valueOf(paramMessageRecord.msgtype));
          if ((localBoolean == null) || (!localBoolean.booleanValue())) {}
        }
        for (int i = 1; i != 0; i = 0)
        {
          ((AppGuideTipsConfig)localObject).allow = false;
          ((AppGuideTipsConfig)localObject).addCount += 1;
          ((AppGuideTipsConfig)localObject).lastAddTime = System.currentTimeMillis();
          a((Entity)localObject);
          if ("1".equals(((AppGuideTipsConfig)localObject).tipsType))
          {
            a(paramMessageRecord, (AppGuideTipsConfig)localObject);
            return;
          }
          b(paramMessageRecord, (AppGuideTipsConfig)localObject);
          return;
        }
      }
    }
  }
  
  public AppGuideTipsConfig a()
  {
    if (this.a == null) {
      bYy();
    }
    return this.a;
  }
  
  public void a(BaseChatPie paramBaseChatPie, MessageRecord paramMessageRecord)
  {
    if ((this.bcR) || (this.bNI != 1) || (this.a == null)) {
      break label22;
    }
    label22:
    while (aegu.ag(paramMessageRecord)) {
      return;
    }
    AppGuideTipsConfig localAppGuideTipsConfig = this.a;
    long l = NetConnInfoCenter.getServerTimeMillis();
    label93:
    boolean bool1;
    if ((!"0".equals(localAppGuideTipsConfig.switchKey)) && (l - localAppGuideTipsConfig.lastAddTime > localAppGuideTipsConfig.duration * 1000L) && (localAppGuideTipsConfig.addCount < localAppGuideTipsConfig.maxCount))
    {
      localAppGuideTipsConfig.allow = true;
      bool1 = false;
      if (localAppGuideTipsConfig.allow)
      {
        if (localAppGuideTipsConfig.msgTypeMap.isEmpty()) {
          break label284;
        }
        paramMessageRecord = (Boolean)localAppGuideTipsConfig.msgTypeMap.get(Integer.valueOf(paramMessageRecord.msgtype));
        if ((paramMessageRecord == null) || (!paramMessageRecord.booleanValue())) {
          break label278;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (!localAppGuideTipsConfig.aioTypes.isEmpty()) {
          bool2 = localAppGuideTipsConfig.aioTypes.contains(Integer.valueOf(paramBaseChatPie.getCurType()));
        }
      }
      if ((!bool2) || (!paramBaseChatPie.Pb())) {
        break;
      }
      localAppGuideTipsConfig.allow = false;
      localAppGuideTipsConfig.addCount += 1;
      localAppGuideTipsConfig.lastAddTime = l;
      b(localAppGuideTipsConfig);
      anot.a(null, "dc00898", "", "", "0X8008947", "0X8008947", 0, 0, "", "", "", "");
      return;
      localAppGuideTipsConfig.allow = false;
      break label93;
      label278:
      bool1 = false;
      continue;
      label284:
      bool1 = true;
    }
  }
  
  public void a(AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.mApp.getCurrentAccountUin(), 0).edit();
    try
    {
      localEditor.putString("tim_gray_tips_switch", paramAppGuideTipsConfig.switchKey);
      localEditor.putInt("tim_gray_tips_total", paramAppGuideTipsConfig.maxCount);
      localEditor.putLong("tim_gray_tips_duration", paramAppGuideTipsConfig.duration);
      localEditor.putString("tim_gray_tips_url", paramAppGuideTipsConfig.tipsUrl);
      localEditor.putString("tim_gray_tips_txt", paramAppGuideTipsConfig.tipsMsg);
      localEditor.putString("tim_gray_tips_types", paramAppGuideTipsConfig.msgTypeStr);
      localEditor.putString("tim_tips_bar_aio_types", paramAppGuideTipsConfig.aioTypeStr);
      localEditor.apply();
      return;
    }
    catch (Exception paramAppGuideTipsConfig)
    {
      paramAppGuideTipsConfig.printStackTrace();
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    if (!this.em.isOpen()) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.em.persistOrReplace(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.em.update(paramEntity);
  }
  
  public void b(AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "updateTimAIOTipsBarConfig, add count: ", Integer.valueOf(paramAppGuideTipsConfig.addCount) });
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.mApp.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("tim_gray_tips_count", paramAppGuideTipsConfig.addCount);
    localEditor.putLong("tim_gray_tips_time", paramAppGuideTipsConfig.lastAddTime);
    localEditor.apply();
  }
  
  public void bYA()
  {
    ThreadManager.executeOnSubThread(new AppGuideTipsManager.2(this));
  }
  
  public void bYw()
  {
    if (!this.bcQ) {
      loadConfig();
    }
    if ((this.hr == null) || (this.hr.size() <= 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      Iterator localIterator = this.hr.values().iterator();
      while (localIterator.hasNext())
      {
        AppGuideTipsConfig localAppGuideTipsConfig = (AppGuideTipsConfig)localIterator.next();
        if (localAppGuideTipsConfig != null) {
          if ((!"0".equals(localAppGuideTipsConfig.switchKey)) && (l - localAppGuideTipsConfig.lastAddTime > localAppGuideTipsConfig.duration * 1000L) && (localAppGuideTipsConfig.addCount < localAppGuideTipsConfig.maxCount)) {
            localAppGuideTipsConfig.allow = true;
          } else {
            localAppGuideTipsConfig.allow = false;
          }
        }
      }
    }
  }
  
  public void bYy()
  {
    AppGuideTipsConfig localAppGuideTipsConfig = new AppGuideTipsConfig();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.mApp.getCurrentAccountUin(), 0);
    localAppGuideTipsConfig.switchKey = ((SharedPreferences)localObject).getString("tim_gray_tips_switch", "0");
    localAppGuideTipsConfig.maxCount = ((SharedPreferences)localObject).getInt("tim_gray_tips_total", 0);
    localAppGuideTipsConfig.duration = ((SharedPreferences)localObject).getLong("tim_gray_tips_duration", 0L);
    localAppGuideTipsConfig.tipsUrl = ((SharedPreferences)localObject).getString("tim_gray_tips_url", "");
    localAppGuideTipsConfig.tipsMsg = ((SharedPreferences)localObject).getString("tim_gray_tips_txt", "");
    localAppGuideTipsConfig.msgTypeStr = ((SharedPreferences)localObject).getString("tim_gray_tips_types", "");
    localAppGuideTipsConfig.aioTypeStr = ((SharedPreferences)localObject).getString("tim_tips_bar_aio_types", "");
    localAppGuideTipsConfig.addCount = ((SharedPreferences)localObject).getInt("tim_gray_tips_count", 0);
    localAppGuideTipsConfig.lastAddTime = ((SharedPreferences)localObject).getLong("tim_gray_tips_time", 0L);
    int i;
    int j;
    if (!TextUtils.isEmpty(localAppGuideTipsConfig.msgTypeStr))
    {
      localObject = localAppGuideTipsConfig.msgTypeStr.split("\\|");
      if (localObject != null)
      {
        i = 0;
        for (;;)
        {
          if (i < localObject.length) {
            try
            {
              j = Integer.valueOf(localObject[i]).intValue();
              localAppGuideTipsConfig.msgTypeMap.put(Integer.valueOf(j), Boolean.valueOf(true));
              i += 1;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                localException1.printStackTrace();
              }
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(localAppGuideTipsConfig.aioTypeStr))
    {
      localObject = localAppGuideTipsConfig.aioTypeStr.split("\\|");
      if (localObject != null)
      {
        i = 0;
        for (;;)
        {
          if (i < localObject.length) {
            try
            {
              j = Integer.valueOf(localObject[i]).intValue();
              localAppGuideTipsConfig.aioTypes.add(Integer.valueOf(j));
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localException2.printStackTrace();
              }
            }
          }
        }
      }
    }
    this.a = localAppGuideTipsConfig;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "loadTimAIOTipsBarConfig, switch: ", localAppGuideTipsConfig.switchKey });
    }
  }
  
  public void bYz()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "clearTimAIOGrayTipsBarConfig");
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.mApp.getCurrentAccountUin(), 0).edit().clear().apply();
  }
  
  /* Error */
  public void ge(java.util.List<AppGuideTipsConfig> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 499 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 55	wjw:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   20: invokevirtual 503	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   23: astore 4
    //   25: aload 4
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 508	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   32: aload_0
    //   33: getfield 38	wjw:hr	Ljava/util/Map;
    //   36: invokeinterface 510 1 0
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 99	wjw:bcQ	Z
    //   46: iconst_0
    //   47: istore_2
    //   48: iload_2
    //   49: aload_1
    //   50: invokeinterface 499 1 0
    //   55: if_icmpge +67 -> 122
    //   58: aload_1
    //   59: iload_2
    //   60: invokeinterface 513 2 0
    //   65: checkcast 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   68: astore 4
    //   70: aload 4
    //   72: ifnull +235 -> 307
    //   75: aload_0
    //   76: getfield 55	wjw:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   79: ldc 101
    //   81: aload 4
    //   83: getfield 282	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   86: invokevirtual 517	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   89: checkcast 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   92: astore 5
    //   94: aload 5
    //   96: ifnull +211 -> 307
    //   99: aload 4
    //   101: aload 5
    //   103: getfield 265	com/tencent/mobileqq/data/AppGuideTipsConfig:addCount	I
    //   106: putfield 265	com/tencent/mobileqq/data/AppGuideTipsConfig:addCount	I
    //   109: aload 4
    //   111: aload 5
    //   113: getfield 274	com/tencent/mobileqq/data/AppGuideTipsConfig:lastAddTime	J
    //   116: putfield 274	com/tencent/mobileqq/data/AppGuideTipsConfig:lastAddTime	J
    //   119: goto +188 -> 307
    //   122: new 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   125: dup
    //   126: invokespecial 456	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   129: astore 4
    //   131: aload 4
    //   133: sipush 1001
    //   136: invokevirtual 520	com/tencent/mobileqq/data/AppGuideTipsConfig:setStatus	(I)V
    //   139: aload_0
    //   140: getfield 55	wjw:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   143: aload 4
    //   145: ldc_w 522
    //   148: iconst_1
    //   149: anewarray 109	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: ldc_w 304
    //   157: aastore
    //   158: invokevirtual 526	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   161: pop
    //   162: iconst_0
    //   163: istore_2
    //   164: iload_2
    //   165: aload_1
    //   166: invokeinterface 499 1 0
    //   171: if_icmpge +30 -> 201
    //   174: aload_1
    //   175: iload_2
    //   176: invokeinterface 513 2 0
    //   181: checkcast 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   184: astore 4
    //   186: aload 4
    //   188: ifnull +126 -> 314
    //   191: aload_0
    //   192: aload 4
    //   194: invokevirtual 277	wjw:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   197: pop
    //   198: goto +116 -> 314
    //   201: aload_3
    //   202: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   205: aload_3
    //   206: ifnull -193 -> 13
    //   209: aload_3
    //   210: invokevirtual 532	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   213: return
    //   214: astore 4
    //   216: aload_3
    //   217: astore_1
    //   218: aload 4
    //   220: astore_3
    //   221: aload_3
    //   222: invokevirtual 392	java/lang/Exception:printStackTrace	()V
    //   225: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +33 -> 261
    //   231: getstatic 28	wjw:TAG	Ljava/lang/String;
    //   234: iconst_2
    //   235: new 187	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 534
    //   245: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_3
    //   249: invokevirtual 537	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 540	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_1
    //   262: ifnull -249 -> 13
    //   265: aload_1
    //   266: invokevirtual 532	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   269: return
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_3
    //   273: aload_3
    //   274: ifnull +7 -> 281
    //   277: aload_3
    //   278: invokevirtual 532	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   281: aload_1
    //   282: athrow
    //   283: astore_1
    //   284: goto -11 -> 273
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: aload 4
    //   293: astore_1
    //   294: goto -21 -> 273
    //   297: astore 4
    //   299: aload_3
    //   300: astore_1
    //   301: aload 4
    //   303: astore_3
    //   304: goto -83 -> 221
    //   307: iload_2
    //   308: iconst_1
    //   309: iadd
    //   310: istore_2
    //   311: goto -263 -> 48
    //   314: iload_2
    //   315: iconst_1
    //   316: iadd
    //   317: istore_2
    //   318: goto -154 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	wjw
    //   0	321	1	paramList	java.util.List<AppGuideTipsConfig>
    //   47	271	2	i	int
    //   15	289	3	localObject1	Object
    //   23	170	4	localObject2	Object
    //   214	5	4	localException1	Exception
    //   287	5	4	localObject3	Object
    //   297	5	4	localException2	Exception
    //   92	20	5	localAppGuideTipsConfig	AppGuideTipsConfig
    // Exception table:
    //   from	to	target	type
    //   16	25	214	java/lang/Exception
    //   16	25	270	finally
    //   28	46	283	finally
    //   48	70	283	finally
    //   75	94	283	finally
    //   99	119	283	finally
    //   122	162	283	finally
    //   164	186	283	finally
    //   191	198	283	finally
    //   201	205	283	finally
    //   221	261	287	finally
    //   28	46	297	java/lang/Exception
    //   48	70	297	java/lang/Exception
    //   75	94	297	java/lang/Exception
    //   99	119	297	java/lang/Exception
    //   122	162	297	java/lang/Exception
    //   164	186	297	java/lang/Exception
    //   191	198	297	java/lang/Exception
    //   201	205	297	java/lang/Exception
  }
  
  public void loadConfig()
  {
    if (this.bcQ) {
      return;
    }
    ThreadManager.post(new AppGuideTipsManager.1(this), 5, null, false);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjw
 * JD-Core Version:    0.7.0.1
 */