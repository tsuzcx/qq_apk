package com.tencent.mobileqq.gamecenter.data;

import aahb;
import aahb.b;
import aahb.d;
import ahrv;
import ahrz.a;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import aqhq;
import aqiz;
import aqrb;
import awot;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tba;
import tbb;
import tbj;

public class GameNoticeCenter
  implements tba
{
  private static final Comparator<GameNoticeInfo> COMPARATOR = new ahrv();
  private long Fk;
  private final int TYPE_INSTALL = 1;
  private GameNoticeInfoList jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList;
  private a jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a;
  private volatile AtomicBoolean bn = new AtomicBoolean(false);
  private Runnable bz = new GameNoticeCenter.1(this);
  private volatile AtomicBoolean cV = new AtomicBoolean(false);
  private final int daV = 2;
  private final int daW = 3;
  private Date f = new Date();
  private Runnable gA = new GameNoticeCenter.4(this);
  
  public GameNoticeCenter(QQAppInterface paramQQAppInterface)
  {
    GameCenterReceiver.registerReceiver();
    GameCenterReceiver.a(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList = new GameNoticeInfoList(paramQQAppInterface.a().createEntityManager());
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.bz, 300000L);
  }
  
  private void Kz(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, new Object[] { "hideBanner: ", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a, ", sendMessage=", Boolean.valueOf(paramBoolean) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a != null)
    {
      if (paramBoolean)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          aahb.a((QQAppInterface)localAppRuntime, a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a = null;
    }
  }
  
  private Date a(long paramLong)
  {
    this.f.setTime(paramLong);
    return this.f;
  }
  
  private tbj a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      localObject = new tbj((AppInterface)localObject);
      ((tbj)localObject).f("4").g("430").a("817");
      return localObject;
    }
  }
  
  private boolean a(ahrz.a parama)
  {
    Object localObject = parama.appId;
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId((String)localObject);
    switch (parama.bBa)
    {
    case 7: 
    case 8: 
    default: 
      if (localObject != null)
      {
        QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo(remove), ", parama });
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.remove(localObject);
        QLog.d("GameNoticeCenter", 1, new Object[] { "remove GameNoticeInfo: ", localObject });
        return true;
      }
      break;
    case 6: 
    case 9: 
    case 10: 
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, new Object[] { "processTaskInfo(add), ", parama });
      }
      if ((localObject != null) && ((((GameNoticeInfo)localObject).bannerType != GameNoticeInfo.convertToBannerType(parama)) || (((GameNoticeInfo)localObject).createTime != parama.createTime)))
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.remove(localObject);
        QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: remove GameNoticeInfo: ", localObject });
        localObject = null;
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      if (localObject == null)
      {
        parama = new GameNoticeInfo(parama, BaseApplication.getContext());
        if (parama.isValid())
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.add(parama);
          QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: add GameNoticeInfo: ", parama });
          return true;
        }
        QLog.e("GameNoticeCenter", 1, new Object[] { "processTaskInfo: invalid GameNoticeInfo: ", parama });
        return bool;
        return false;
      }
      return bool;
    }
  }
  
  private final boolean a(GameNoticeInfo paramGameNoticeInfo)
  {
    boolean bool = false;
    if (!paramGameNoticeInfo.infoRequested)
    {
      paramGameNoticeInfo.infoRequested = true;
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, new Object[] { "request register: ", paramGameNoticeInfo });
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((aqrb)((QQAppInterface)localAppRuntime).getBusinessHandler(71)).VB(paramGameNoticeInfo.appId);
      }
      bool = true;
    }
    return bool;
  }
  
  private void b(int paramInt, WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a != null) && (a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a) != null) && (paramWadlResult.a.appId.equals(a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a).appId)))
      {
        int i = 0;
        if (paramInt == 1)
        {
          paramInt = i;
          if (a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a).bannerType != 1) {}
        }
        for (paramInt = 1; paramInt != 0; paramInt = 1)
        {
          paramWadlResult = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId(a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a).appId);
          if (paramWadlResult != null)
          {
            paramWadlResult.shown = true;
            this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(paramWadlResult);
          }
          Kz(true);
          return;
        }
      }
    }
  }
  
  private void dpx()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBanner begin, now=" + l1 + ",mGameNoticeInfos size=" + this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.iterator();
    GameNoticeInfo localGameNoticeInfo;
    Object localObject;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localGameNoticeInfo = (GameNoticeInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 1, "checkBanner info=" + localGameNoticeInfo);
        }
        if (!localGameNoticeInfo.isValid())
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.remove(localGameNoticeInfo);
        }
        else
        {
          if ((localGameNoticeInfo.bannerType == 1) && (!TextUtils.isEmpty(localGameNoticeInfo.filePath)))
          {
            localObject = new File(localGameNoticeInfo.filePath);
            if (((File)localObject).exists())
            {
              long l2 = tbb.P("KEY_RED_POINT_TIME_" + localGameNoticeInfo.appId);
              long l3 = ((File)localObject).lastModified();
              if (QLog.isColorLevel()) {
                QLog.d("GameNoticeCenter", 1, "redPointTime=" + l2 + ",now=" + l1 + ",fileLastModifiedTime=" + l3);
              }
              if ((l1 - l2 > 604800000L) || (l2 > l1))
              {
                l2 = l1 - l3;
                if (QLog.isColorLevel()) {
                  QLog.d("GameNoticeCenter", 1, "lostTime=" + l2 + ",compTime=" + 86400000L + " | " + 172800000L);
                }
                if ((l2 > 86400000L) && (l2 < 172800000L))
                {
                  tbb.j("KEY_RED_POINT_TIME_" + localGameNoticeInfo.appId, l1);
                  if (!aqiz.isAppInstalled(BaseApplicationImpl.getApplication(), localGameNoticeInfo.packageName)) {
                    awot.a().acU(9);
                  }
                }
              }
            }
          }
          if (l1 < localGameNoticeInfo.startTime)
          {
            if (!QLog.isColorLevel()) {
              break label927;
            }
            QLog.d("GameNoticeCenter", 1, new Object[] { "time miss, break! startTime=", a(localGameNoticeInfo.startTime) });
            localObject = null;
          }
        }
      }
    }
    for (;;)
    {
      label466:
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, "getting no banner to show");
        }
        Kz(true);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label925;
        }
        QLog.d("GameNoticeCenter", 2, "checkBanner end!!!");
        return;
        if (localGameNoticeInfo.shown)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GameNoticeCenter", 2, "shown==true, continue! ");
          break;
        }
        if (localGameNoticeInfo.endTime < l1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 1, new Object[] { "time expired, continue! endTime=", a(localGameNoticeInfo.endTime) });
          }
          localGameNoticeInfo.shown = true;
          this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(localGameNoticeInfo);
          break;
        }
        if (localGameNoticeInfo.bannerType == 1)
        {
          if (aqiz.isAppInstalled(BaseApplication.getContext(), localGameNoticeInfo.packageName)) {
            break;
          }
          localObject = localGameNoticeInfo;
          if (aqhq.fileExists(localGameNoticeInfo.filePath)) {
            break label466;
          }
          break;
        }
        if ((localGameNoticeInfo.bannerType != 2) || (!aqiz.isAppInstalled(BaseApplication.getContext(), localGameNoticeInfo.packageName))) {
          break;
        }
        if (a(localGameNoticeInfo))
        {
          if (!QLog.isColorLevel()) {
            break label927;
          }
          QLog.d("GameNoticeCenter", 1, "request register info, break! ");
          localObject = null;
          break label466;
        }
        if (!TextUtils.isEmpty(localGameNoticeInfo.title))
        {
          localObject = localGameNoticeInfo;
          if (!TextUtils.isEmpty(localGameNoticeInfo.jumpUrl)) {
            break label466;
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GameNoticeCenter", 2, "title or jumpUrl is empty, break! ");
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a != null) && (((GameNoticeInfo)localObject).equals(a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 2, new Object[] { "mCurrentBanner not changed, mCurrentBanner=", a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a) });
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 1, new Object[] { "show banner=", localObject, ", hiding ", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a });
          }
          Kz(false);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a = new a((GameNoticeInfo)((GameNoticeInfo)localObject).clone());
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject instanceof QQAppInterface))
          {
            localObject = (QQAppInterface)localObject;
            a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a, aahb.a((QQAppInterface)localObject, 2, "com.tencent.mobileqq.gamecenter", a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a).title, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a));
            if (a.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$a) == null) {
              Kz(false);
            }
          }
        }
      }
      label925:
      break;
      label927:
      localObject = null;
    }
  }
  
  /* Error */
  private final void dpy()
  {
    // Byte code:
    //   0: invokestatic 309	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: lload_1
    //   5: aload_0
    //   6: getfield 483	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:Fk	J
    //   9: lsub
    //   10: ldc2_w 106
    //   13: lcmp
    //   14: ifle +42 -> 56
    //   17: aload_0
    //   18: lload_1
    //   19: putfield 483	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:Fk	J
    //   22: new 485	ahrz
    //   25: dup
    //   26: invokestatic 241	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   29: invokespecial 488	ahrz:<init>	(Landroid/content/Context;)V
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload_0
    //   38: aload 4
    //   40: invokevirtual 492	ahrz:fh	()Ljava/util/List;
    //   43: invokespecial 496	com/tencent/mobileqq/gamecenter/data/GameNoticeCenter:kX	(Ljava/util/List;)V
    //   46: aload 4
    //   48: ifnull +8 -> 56
    //   51: aload 4
    //   53: invokevirtual 499	ahrz:close	()V
    //   56: return
    //   57: astore 5
    //   59: aconst_null
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: ldc 122
    //   67: iconst_1
    //   68: aload 5
    //   70: invokevirtual 502	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokestatic 504	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 4
    //   78: ifnull -22 -> 56
    //   81: aload 4
    //   83: invokevirtual 499	ahrz:close	()V
    //   86: return
    //   87: astore_3
    //   88: return
    //   89: astore 4
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 499	ahrz:close	()V
    //   101: aload 4
    //   103: athrow
    //   104: astore_3
    //   105: return
    //   106: astore_3
    //   107: goto -6 -> 101
    //   110: astore 4
    //   112: goto -19 -> 93
    //   115: astore 5
    //   117: goto -55 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	GameNoticeCenter
    //   3	16	1	l	long
    //   36	29	3	localahrz1	ahrz
    //   87	1	3	localThrowable1	Throwable
    //   92	6	3	localObject1	Object
    //   104	1	3	localThrowable2	Throwable
    //   106	1	3	localThrowable3	Throwable
    //   32	50	4	localahrz2	ahrz
    //   89	13	4	localObject2	Object
    //   110	1	4	localObject3	Object
    //   57	12	5	localException1	java.lang.Exception
    //   115	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	34	57	java/lang/Exception
    //   81	86	87	java/lang/Throwable
    //   22	34	89	finally
    //   51	56	104	java/lang/Throwable
    //   97	101	106	java/lang/Throwable
    //   37	46	110	finally
    //   65	76	110	finally
    //   37	46	115	java/lang/Exception
  }
  
  private void kX(List<ahrz.a> paramList)
  {
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList();
    }
    Object localObject2 = new StringBuilder().append("handleTaskInfos, taskInfos.size=").append(((List)localObject1).size()).append(",mGameNoticeInfos=");
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList != null) {}
    for (paramList = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.size());; paramList = "null")
    {
      QLog.d("GameNoticeCenter", 1, paramList);
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList != null) && (((List)localObject1).size() >= 1)) {
        break;
      }
      return;
    }
    paramList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    boolean bool;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ahrz.a)((Iterator)localObject1).next();
      bool = i | a((ahrz.a)localObject2);
      i = bool;
      if (!TextUtils.isEmpty(((ahrz.a)localObject2).appId))
      {
        i = bool;
        if (!paramList.contains(((ahrz.a)localObject2).appId))
        {
          paramList.add(((ahrz.a)localObject2).appId);
          i = bool;
        }
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GameNoticeInfo)((Iterator)localObject1).next();
      if (!paramList.contains(((GameNoticeInfo)localObject2).appId))
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.remove(localObject2);
        bool = i | 0x1;
        i = bool;
        if (QLog.isColorLevel())
        {
          QLog.d("GameNoticeCenter", 2, new Object[] { "handleTaskInfos, remove ", localObject2 });
          i = bool;
        }
      }
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.sort();
    }
    QLog.d("GameNoticeCenter", 1, new Object[] { "handleTaskInfos end, remains ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.size()) });
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.dpz();
  }
  
  private static void m(String paramString, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.addFlags(268435456);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    paramContext.startActivity(localIntent);
  }
  
  public void a(WadlResult paramWadlResult)
  {
    b(1, paramWadlResult);
  }
  
  public void b(WadlResult paramWadlResult)
  {
    b(2, paramWadlResult);
  }
  
  public void be(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("game_appid");
    GameNoticeInfo localGameNoticeInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.getByAppId(str);
    if (localGameNoticeInfo != null)
    {
      if (paramJSONObject.optInt("registered", 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localGameNoticeInfo.registered = bool;
        long l1 = paramJSONObject.optLong("bar_delay");
        long l2 = paramJSONObject.optLong("bar_interval");
        tbb.j("MILLISECONDS_DELAY", l1);
        tbb.j("MILLISECONDS_INTERVAL", l2);
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, new Object[] { "parseGameRegisterInfo, ", localGameNoticeInfo, ", data:" + paramJSONObject.toString() });
        }
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.updateDB(localGameNoticeInfo);
        dpx();
        return;
      }
    }
    QLog.e("GameNoticeCenter", 1, new Object[] { "parseGameRegisterInfo, GameNoticeInfo for ", str, " not found!" });
  }
  
  public void c(WadlResult paramWadlResult)
  {
    b(3, paramWadlResult);
  }
  
  public void dpw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBannerFromResume mInit=" + this.bn + ",mCheckBannerPosted=" + this.cV);
    }
    if (!this.bn.get()) {}
    while (this.cV.getAndSet(true)) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i != 0; i = 0)
    {
      ThreadManagerV2.excute(this.gA, 16, null, true);
      return;
    }
    this.gA.run();
  }
  
  public void init()
  {
    int i;
    if (!this.bn.getAndSet(true))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label52;
      }
      i = 1;
      if (i == 0) {
        break label57;
      }
      ThreadManagerV2.excute(new GameNoticeCenter.2(this), 16, null, true);
    }
    for (;;)
    {
      ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.bz);
      return;
      label52:
      i = 0;
      break;
      label57:
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter$GameNoticeInfoList.initData();
    }
  }
  
  class GameNoticeInfoList
    extends CopyOnWriteArrayList<GameNoticeInfo>
  {
    private EntityManager mEntityManager;
    
    public GameNoticeInfoList(EntityManager paramEntityManager)
    {
      this.mEntityManager = paramEntityManager;
    }
    
    private final void dpz()
    {
      if (QLog.isColorLevel())
      {
        int i = 0;
        while (i < size())
        {
          QLog.d("GameNoticeCenter", 2, new Object[] { get(i) });
          i += 1;
        }
      }
    }
    
    public boolean add(GameNoticeInfo paramGameNoticeInfo)
    {
      boolean bool = super.add(paramGameNoticeInfo);
      if (bool) {
        this.mEntityManager.persist(paramGameNoticeInfo);
      }
      return bool;
    }
    
    GameNoticeInfo getByAppId(String paramString)
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext())
      {
        GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)localIterator.next();
        if ((!TextUtils.isEmpty(localGameNoticeInfo.appId)) && (localGameNoticeInfo.appId.equals(paramString))) {
          return localGameNoticeInfo;
        }
      }
      return null;
    }
    
    void initData()
    {
      ArrayList localArrayList = (ArrayList)this.mEntityManager.query(GameNoticeInfo.class);
      clear();
      if (localArrayList != null)
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!((GameNoticeInfo)((Iterator)localObject).next()).isValid()) {
            ((Iterator)localObject).remove();
          }
        }
        addAll(localArrayList);
        sort();
      }
      Object localObject = new StringBuilder().append("initData, restore size=");
      if (localArrayList != null) {}
      for (int i = localArrayList.size();; i = 0)
      {
        QLog.d("GameNoticeCenter", 1, i + ", remains size=" + size());
        dpz();
        GameNoticeCenter.this.dpw();
        return;
      }
    }
    
    public GameNoticeInfo remove(int paramInt)
    {
      GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)super.remove(paramInt);
      if (localGameNoticeInfo != null) {
        this.mEntityManager.remove(localGameNoticeInfo);
      }
      return localGameNoticeInfo;
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool = super.remove(paramObject);
      if ((bool) && ((paramObject instanceof Entity))) {
        this.mEntityManager.remove((Entity)paramObject);
      }
      return bool;
    }
    
    void sort()
    {
      try
      {
        ArrayList localArrayList = new ArrayList(this);
        Collections.sort(localArrayList, GameNoticeCenter.e());
        clear();
        addAll(localArrayList);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameNoticeCenter", 1, "initData exception", localThrowable);
      }
    }
    
    void updateDB(GameNoticeInfo paramGameNoticeInfo)
    {
      if (paramGameNoticeInfo.getStatus() == 1000) {
        this.mEntityManager.persistOrReplace(paramGameNoticeInfo);
      }
      while ((paramGameNoticeInfo.getStatus() != 1001) && (paramGameNoticeInfo.getStatus() != 1002)) {
        return;
      }
      this.mEntityManager.update(paramGameNoticeInfo);
    }
  }
  
  class a
    implements aahb.b
  {
    private final GameNoticeInfo a;
    private aahb.d d;
    
    a(GameNoticeInfo paramGameNoticeInfo)
    {
      this.a = paramGameNoticeInfo;
      QLog.d("GameNoticeCenter", 1, new Object[] { "hide banner at: ", GameNoticeCenter.a(GameNoticeCenter.this, this.a.endTime), ", mInfo=", this.a });
      if (this.a.bannerType == 1) {
        GameNoticeCenter.a(GameNoticeCenter.this).e("81706").b("205431").d("8").c(this.a.appId).h(this.a.apkChannel).NF();
      }
      while (this.a.bannerType != 2) {
        return;
      }
      GameNoticeCenter.a(GameNoticeCenter.this).e("81707").b("205433").d("8").c(this.a.appId).h(this.a.apkChannel).NF();
    }
    
    public boolean isNeedAutoCloseWhenAccountChange()
    {
      return true;
    }
    
    public void onClose()
    {
      QLog.d("GameNoticeCenter", 1, new Object[] { "onClose, ", this.a });
      GameNoticeInfo localGameNoticeInfo = GameNoticeCenter.a(GameNoticeCenter.this).getByAppId(this.a.appId);
      if (localGameNoticeInfo != null)
      {
        localGameNoticeInfo.shown = true;
        GameNoticeCenter.a(GameNoticeCenter.this).updateDB(localGameNoticeInfo);
      }
      GameNoticeCenter.a(GameNoticeCenter.this, true);
      if (this.a.bannerType == 1) {
        GameNoticeCenter.a(GameNoticeCenter.this).e("81706").b("205435").d("20").c(this.a.appId).h(this.a.apkChannel).NF();
      }
      while (this.a.bannerType != 2) {
        return;
      }
      GameNoticeCenter.a(GameNoticeCenter.this).e("81707").b("205436").d("20").c(this.a.appId).h(this.a.apkChannel).NF();
    }
    
    public void onEnter()
    {
      QLog.d("GameNoticeCenter", 1, new Object[] { "onEnter, ", this.a });
      GameNoticeCenter.n(this.a.jumpUrl, BaseApplication.getContext());
      GameNoticeInfo localGameNoticeInfo = GameNoticeCenter.a(GameNoticeCenter.this).getByAppId(this.a.appId);
      if (localGameNoticeInfo != null)
      {
        localGameNoticeInfo.shown = true;
        GameNoticeCenter.a(GameNoticeCenter.this).updateDB(localGameNoticeInfo);
      }
      GameNoticeCenter.a(GameNoticeCenter.this, true);
      if (this.a.bannerType == 1) {
        GameNoticeCenter.a(GameNoticeCenter.this).e("81706").b("205432").d("20").c(this.a.appId).h(this.a.apkChannel).NF();
      }
      while (this.a.bannerType != 2) {
        return;
      }
      GameNoticeCenter.a(GameNoticeCenter.this).e("81707").b("205434").d("20").c(this.a.appId).h(this.a.apkChannel).NF();
    }
    
    public void onOverride()
    {
      QLog.d("GameNoticeCenter", 1, new Object[] { "onOverride, ", this.a });
      if ((GameNoticeCenter.a(GameNoticeCenter.this) != null) && (this.a.equals(GameNoticeCenter.a(GameNoticeCenter.this).a)))
      {
        GameNoticeInfo localGameNoticeInfo = GameNoticeCenter.a(GameNoticeCenter.this).getByAppId(this.a.appId);
        if (localGameNoticeInfo != null)
        {
          localGameNoticeInfo.shown = true;
          GameNoticeCenter.a(GameNoticeCenter.this).updateDB(localGameNoticeInfo);
          GameNoticeCenter.a(GameNoticeCenter.this, false);
        }
      }
      if (this.a.bannerType == 1) {
        GameNoticeCenter.a(GameNoticeCenter.this).e("81706").b("205584").c(this.a.appId).h(this.a.apkChannel).NF();
      }
      while (this.a.bannerType != 2) {
        return;
      }
      GameNoticeCenter.a(GameNoticeCenter.this).e("81707").b("205585").c(this.a.appId).h(this.a.apkChannel).NF();
    }
    
    public String toString()
    {
      if (this.a != null) {
        return this.a.toString();
      }
      return super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter
 * JD-Core Version:    0.7.0.1
 */