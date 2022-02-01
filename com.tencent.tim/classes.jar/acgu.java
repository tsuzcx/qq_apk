import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LebaHelper.1;
import com.tencent.mobileqq.app.LebaHelper.2;
import com.tencent.mobileqq.app.LebaHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;

public class acgu
{
  public static final String bow = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=" + aqgo.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0);
  public areh a;
  boolean bHU = false;
  public boolean bHV;
  boolean bHW = false;
  byte[] cO = new byte[0];
  int cwf = 0;
  int cwg = 0;
  public QQAppInterface mApp;
  List<ResourcePluginListener> xA;
  List<LebaPluginInfo> xy;
  List<LebaPluginInfo> xz;
  
  public acgu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.xy = new ArrayList();
    this.xz = new ArrayList();
    this.xA = new ArrayList();
  }
  
  private void a(int paramInt1, List<acgu.a> paramList, int paramInt2, int paramInt3)
  {
    int j = acgw.B(this.mApp);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      QLog.i("LebaHelper", 1, String.format("saveLebaGroupInfo, localSeq=%d, seq=%d , groupListSize=%d, layoutType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2) }));
      if ((paramInt1 > 0) && (paramInt1 != j) && (paramList != null))
      {
        acgw.o(this.mApp, paramInt1);
        acgw.f(this.mApp, paramList);
        acgw.e(this.mApp, paramInt2, paramInt3);
      }
      return;
    }
  }
  
  private void cJB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Map localMap = acgw.c(acgw.f(this.mApp));
    if (localMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "loadServerPlugins, groupMap is null");
      }
      return;
    }
    ??? = this.mApp.a().createEntityManager();
    List localList = LebaPluginInfo.getAll((EntityManager)???);
    ((EntityManager)???).close();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localList != null) && (localList.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.xz)
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          acgu.a locala = (acgu.a)localMap.get(Long.valueOf(localLebaPluginInfo.uiResId));
          if (locala == null)
          {
            localStringBuilder.append(",remove ").append(localLebaPluginInfo);
            localList.remove(localLebaPluginInfo);
          }
          else
          {
            localStringBuilder.append(",add ").append(localLebaPluginInfo);
            localLebaPluginInfo.sPriority = acgw.a(locala);
          }
        }
      }
      this.xz.addAll(localList);
      QLog.i("LebaHelper", 1, "loadServerPlugins data =  " + localStringBuilder);
      return;
      i -= 1;
    }
  }
  
  private void cJC()
  {
    Iterator localIterator = new ArrayList(this.xA).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
  
  private void cJx()
  {
    if ((this.mApp == null) || (!this.mApp.isLogin())) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.mApp.getApp().getSharedPreferences("mobileQQ", 0);
    } while (!localSharedPreferences.getBoolean("lebaplugin_clear_local" + this.mApp.getCurrentAccountUin(), true));
    if (QLog.isDevelopLevel()) {
      QLog.d("LebaHelper", 4, "clearLocalDBPlugin.local plugin.");
    }
    localObject1 = this.mApp.a().createEntityManager();
    try
    {
      List localList = LebaPluginInfo.getAll((EntityManager)localObject1);
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          if ((localLebaPluginInfo != null) && (localLebaPluginInfo.cDataType == 1)) {
            LebaPluginInfo.remove((EntityManager)localObject1, localLebaPluginInfo.uiResId);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((EntityManager)localObject1).close();
      }
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("lebaplugin_clear_local" + this.mApp.getCurrentAccountUin(), false);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  private void cJy()
  {
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    localLebaPluginInfo.strPkgName = "qzone_feedlist";
    localLebaPluginInfo.strResName = this.mApp.getApp().getString(2131717869);
    localLebaPluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localLebaPluginInfo.sResSubType = 2;
    localLebaPluginInfo.cCanChangeState = 0;
    localLebaPluginInfo.cDataType = 1;
    localLebaPluginInfo.uiResId = 0L;
    localLebaPluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.mApp.getCurrentAccountUin(), "tab_qzone" });
    localLebaPluginInfo.showInSimpleMode = 1;
    this.xz.add(localLebaPluginInfo);
  }
  
  /* Error */
  private void cJz()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	acgu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 75	acgu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 250	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   14: ifne +19 -> 33
    //   17: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 93
    //   25: iconst_2
    //   26: ldc_w 342
    //   29: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload_0
    //   34: getfield 82	acgu:xz	Ljava/util/List;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 82	acgu:xz	Ljava/util/List;
    //   44: invokeinterface 345 1 0
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: invokespecial 347	acgu:cJy	()V
    //   55: aload_0
    //   56: invokespecial 349	acgu:cJB	()V
    //   59: aload_0
    //   60: getfield 65	acgu:cO	[B
    //   63: astore_1
    //   64: aload_1
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 80	acgu:xy	Ljava/util/List;
    //   70: invokeinterface 345 1 0
    //   75: aload_0
    //   76: getfield 80	acgu:xy	Ljava/util/List;
    //   79: aload_0
    //   80: getfield 82	acgu:xz	Ljava/util/List;
    //   83: invokeinterface 222 2 0
    //   88: pop
    //   89: aload_1
    //   90: monitorexit
    //   91: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +37 -> 131
    //   97: ldc 93
    //   99: iconst_2
    //   100: new 31	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 351
    //   110: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 80	acgu:xy	Ljava/util/List;
    //   117: invokeinterface 129 1 0
    //   122: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 356	acgu:bHV	Z
    //   136: return
    //   137: astore_2
    //   138: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -92 -> 49
    //   144: ldc 93
    //   146: iconst_2
    //   147: aload_2
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: goto -106 -> 49
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 300	java/lang/Exception:printStackTrace	()V
    //   168: goto -113 -> 55
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: aload_2
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	acgu
    //   163	10	1	localException1	Exception
    //   137	11	2	localException2	Exception
    //   158	4	2	localObject2	Object
    //   171	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	137	java/lang/Exception
    //   40	49	158	finally
    //   49	51	158	finally
    //   138	155	158	finally
    //   159	161	158	finally
    //   51	55	163	java/lang/Exception
    //   66	91	171	finally
    //   172	174	171	finally
  }
  
  private void runOnSubThread(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 8, null, true);
  }
  
  public void Fa(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bHW = false;
      cJC();
      return;
    }
    this.bHW = true;
  }
  
  public PluginConfig.GetResourceReq a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "getLebaPluginInfoReq");
    }
    if (acgw.ah(this.mApp))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isAppUpgrade");
      acgw.o(this.mApp, 0);
      acgw.cs(this.mApp);
    }
    if (acha.aaB())
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isLocaleUpdated");
      acgw.o(this.mApp, 0);
      localObject = this.mApp.a().createEntityManager();
    }
    try
    {
      ((EntityManager)localObject).drop(LebaPluginInfo.class);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ArrayList localArrayList;
        LebaPluginInfo localLebaPluginInfo2;
        QLog.e("LebaHelper", 1, "getLebaPluginInfoReq exception", localThrowable);
        if (localObject != null) {
          ((EntityManager)localObject).close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label322;
      }
      ((EntityManager)localObject).close();
    }
    if (acgw.ag(this.mApp))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isChangeModel");
      acgw.o(this.mApp, 0);
    }
    int k = acgw.B(this.mApp);
    Object localObject = LebaPluginInfo.getAll(this.mApp.a().createEntityManager());
    localArrayList = new ArrayList();
    if (localObject != null)
    {
      i = 0;
      if (i < ((List)localObject).size())
      {
        LebaPluginInfo localLebaPluginInfo1 = (LebaPluginInfo)((List)localObject).get(i);
        if ((localLebaPluginInfo1 != null) && (localLebaPluginInfo1.cDataType == 0))
        {
          localLebaPluginInfo2 = new LebaPluginInfo();
          if (k > 0) {
            break label325;
          }
        }
        label322:
        label325:
        for (int j = 0;; j = localLebaPluginInfo1.sResSeq)
        {
          localLebaPluginInfo2.sResSeq = j;
          localLebaPluginInfo2.uiResId = localLebaPluginInfo1.uiResId;
          localArrayList.add(localLebaPluginInfo2);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "" + localLebaPluginInfo1);
          }
          i += 1;
          break;
        }
      }
    }
    if (localList.isEmpty()) {}
    for (int i = 0;; i = k)
    {
      HotChatManager.v(this.mApp, false);
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "getLebaPluginInfoReq, layoutSeq=" + i + ", lebaPluginInfos.size" + localList.size() + ", tempLebaList.size()=" + ((List)localObject).size());
      }
      return acgw.a(i, localList);
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.xA)
    {
      if (!this.xA.contains(paramResourcePluginListener)) {
        this.xA.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, List<acgu.a> arg3, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    b(paramBoolean, paramInt1, ???, paramList1, paramInt2, paramInt3);
    EntityManager localEntityManager;
    EntityTransaction localEntityTransaction;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    StringBuffer localStringBuffer;
    boolean bool3;
    boolean bool4;
    if (paramBoolean)
    {
      this.bHU = false;
      localEntityManager = this.mApp.a().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
      bool2 = false;
      bool1 = false;
      bool5 = false;
      paramBoolean = false;
      localStringBuffer = new StringBuffer();
      bool3 = bool5;
      bool4 = bool2;
    }
    for (;;)
    {
      boolean bool6;
      boolean bool7;
      try
      {
        localStringBuffer.append("onGetPluginConfig saveDb start");
        bool3 = bool5;
        bool4 = bool2;
        localEntityTransaction.begin();
        bool3 = bool5;
        bool4 = bool2;
        paramList1 = paramList1.iterator();
        bool3 = paramBoolean;
        bool4 = bool1;
        if (paramList1.hasNext())
        {
          bool3 = paramBoolean;
          bool4 = bool1;
          localLebaPluginInfo = (LebaPluginInfo)paramList1.next();
          if (localLebaPluginInfo == null) {
            continue;
          }
          bool3 = paramBoolean;
          bool4 = bool1;
          localStringBuffer.append(localLebaPluginInfo);
          bool3 = paramBoolean;
          bool4 = bool1;
          if (localLebaPluginInfo.sResSubType != 0)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            bool6 = paramBoolean;
            bool7 = bool1;
            if (localLebaPluginInfo.sResSubType != 2) {
              break label697;
            }
          }
          bool2 = paramBoolean;
          bool5 = bool1;
          bool3 = paramBoolean;
          bool4 = bool1;
          if (localLebaPluginInfo.state == 3)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            LebaPluginInfo.persistOrReplace(localEntityManager, localLebaPluginInfo);
            bool5 = true;
            bool2 = true;
          }
          bool3 = bool2;
          bool4 = bool5;
          bool6 = bool2;
          bool7 = bool5;
          if (localLebaPluginInfo.state != 1) {
            break label697;
          }
          bool3 = bool2;
          bool4 = bool5;
          LebaPluginInfo.persistOrReplace(localEntityManager, localLebaPluginInfo);
          bool1 = true;
          paramBoolean = bool2;
        }
      }
      catch (Exception paramList1)
      {
        LebaPluginInfo localLebaPluginInfo;
        QLog.i("LebaHelper", 1, "onGetPluginConfig", paramList1);
        paramBoolean = false;
        paramList1.printStackTrace();
        localEntityTransaction.end();
        localEntityManager.close();
        bool1 = bool4;
        continue;
      }
      finally
      {
        localEntityTransaction.end();
        localEntityManager.close();
      }
      try
      {
        if (localLebaPluginInfo.state != 2) {
          break label694;
        }
        LebaPluginInfo.remove(localEntityManager, localLebaPluginInfo.uiResId);
        bool1 = true;
      }
      catch (Exception paramList1)
      {
        bool3 = paramBoolean;
        bool4 = bool1;
        continue;
        continue;
      }
      bool2 = true;
      bool3 = paramBoolean;
      bool4 = bool1;
      localEntityTransaction.commit();
      localEntityTransaction.end();
      localEntityManager.close();
      bool3 = paramBoolean;
      paramBoolean = bool2;
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(String.format("onGetPluginConfig saveDb end, saveDbSuc=%b, isAddNew=%b, isChange=%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
        QLog.i("LebaHelper", 2, localStringBuffer.toString());
      }
      if (paramBoolean) {
        a(paramInt1, ???, paramInt2, paramInt3);
      }
      cJz();
      cJC();
      if (bool3) {
        ((acks)this.mApp.getBusinessHandler(87)).JF(1);
      }
      if (bool1)
      {
        ??? = new ArrayList(this.xA).iterator();
        if (!???.hasNext()) {
          break;
        }
        paramList1 = (ResourcePluginListener)???.next();
        if (bool3)
        {
          ResourcePluginListener.a(paramList1, (byte)3, 1);
          continue;
        }
        ResourcePluginListener.a(paramList1, (byte)2, 1);
        continue;
      }
      ??? = this.xA;
      paramInt1 = 0;
      try
      {
        while (paramInt1 < this.xA.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.xA.get(paramInt1), (byte)1, 1);
          paramInt1 += 1;
        }
        return;
      }
      finally {}
      synchronized (this.xA)
      {
        this.bHU = true;
        paramInt1 = 0;
        while (paramInt1 < this.xA.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.xA.get(paramInt1), (byte)-1, 1);
          paramInt1 += 1;
        }
        return;
      }
      label694:
      label697:
      bool1 = bool7;
      paramBoolean = bool6;
    }
  }
  
  public boolean aav()
  {
    return acgw.D(this.mApp) == 1;
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.xA)
    {
      this.xA.remove(paramResourcePluginListener);
      return;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt1, List<acgu.a> paramList, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(" onGetPluginConfig, isSucc= ").append(paramBoolean).append(",layoutSeq=").append(paramInt1).append(",layoutType=").append(paramInt2).append(",pluginType=").append(paramInt3);
    localStringBuilder.append(",groupList=");
    if (paramList != null)
    {
      localStringBuilder.append(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        acgu.a locala = (acgu.a)paramList.next();
        if (locala != null) {
          localStringBuilder.append(locala.toString());
        }
      }
    }
    localStringBuilder.append(",resultInfos=");
    if (paramList1 != null)
    {
      localStringBuilder.append(paramList1.size());
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (LebaPluginInfo)paramList.next();
        if (paramList1 != null) {
          localStringBuilder.append(paramList1.toString());
        }
      }
    }
    QLog.i("LebaHelper", 1, localStringBuilder.toString());
  }
  
  public void cJA()
  {
    if (this.a != null) {
      this.a.aCG();
    }
  }
  
  public void cJt()
  {
    if ((this.bHU) && (this.cwf < 3))
    {
      this.bHU = false;
      ((aimc)this.mApp.getBusinessHandler(128)).dsP();
      this.cwf += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "checkPluginConfig, mGetPluginConfigFail=" + this.bHU + ", mPluginRetryTime=" + this.cwf);
    }
  }
  
  public void cJu()
  {
    if (acgw.ag(this.mApp))
    {
      QLog.i("LebaHelper", 1, "checkModleAndRefesh getAllPluginList");
      ThreadManager.excute(new LebaHelper.2(this), 160, null, true);
    }
  }
  
  public void cJv()
  {
    synchronized (this.cO)
    {
      this.xy.clear();
      return;
    }
  }
  
  public void cJw()
  {
    if ((this.bHW) && (this.cwg < 3))
    {
      this.bHU = false;
      this.cwg += 1;
      ThreadManager.excute(new LebaHelper.3(this), 128, null, true);
      QLog.i("leba_sort", 1, "checkPluginSort, mGetUserSortFail=" + this.bHW + ", mPluginRetryTime=" + this.cwg);
    }
  }
  
  public List<LebaPluginInfo> dZ()
  {
    return this.xy;
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    runOnSubThread(new LebaHelper.1(this));
  }
  
  public static class a
  {
    public int cwh;
    public int index;
    public long uiResId;
    
    public String toString()
    {
      return "GroupInfo：" + this.uiResId + "|" + this.cwh + "|" + this.index;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acgu
 * JD-Core Version:    0.7.0.1
 */