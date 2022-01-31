package com.tencent.mobileqq.config;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import fmj;
import fmk;
import fml;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;

public class AboutConfig
{
  public static final String a = "com.tx.aboutfunction";
  public static final boolean a = true;
  public static final String b = "http://passport.imqq.com/MqqIntl/mqq/intro/?";
  public static final String c = "com.tx.aboutimage";
  public static final String d = "http://fwd.3g.qq.com:8080/forward.jsp?bid=943";
  public static final String e = "com.tx.abouthelp";
  public static final String f = "http://mapp.3g.qq.com/mqq/faq-en/index.jsp?";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private List jdField_a_of_type_JavaUtilList;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new fmk(this);
  private boolean b = true;
  
  public AboutConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  }
  
  private Hashtable a()
  {
    Hashtable localHashtable = new Hashtable();
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.aboutfunction";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562103);
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://passport.imqq.com/MqqIntl/mqq/intro/?";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.aboutimage";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562391);
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://fwd.3g.qq.com:8080/forward.jsp?bid=943";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.abouthelp";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562101);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 0;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://mapp.3g.qq.com/mqq/faq-en/index.jsp?";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    return localHashtable;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ResourcePluginInfo paramResourcePluginInfo)
  {
    AboutConfig localAboutConfig = paramQQAppInterface.a();
    String str = paramResourcePluginInfo.strGotoUrl;
    Object localObject2 = "&version=6.0.2.6602&appid=" + AppSetting.a + "&QUA=" + QZoneHelper.a() + "&sid=" + paramQQAppInterface.getSid();
    Object localObject1 = localObject2;
    if (paramResourcePluginInfo.strPkgName.equals("com.tx.abouthelp")) {
      localObject1 = (String)localObject2 + "&adtag=6602";
    }
    str = str + (String)localObject1;
    if (paramResourcePluginInfo.strPkgName.equals("com.tx.abouthelp"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("About-Feedback", 2, "feedfack before: url = " + str);
      }
      localObject1 = Build.MODEL;
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).replaceAll(" ", "_");
        localObject2 = Build.MANUFACTURER;
        if (localObject2 == null) {
          break label472;
        }
        localObject2 = ((String)localObject2).replaceAll(" ", "_");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str).append("&model=").append((String)localObject1).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.c() / 1024L / 1024L).append("&amem=").append(DeviceInfoUtil.d() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.f()).append("&h=").append(DeviceInfoUtil.g());
        localObject2 = localStringBuilder.toString();
        localObject1 = localObject2;
        if (QLog.isColorLevel()) {
          QLog.i("About-Feedback", 2, "feedfack after: url = " + (String)localObject2);
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = str) {
      for (;;)
      {
        localObject2 = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1).putExtra("bFormatUrl", false);
        ((Intent)localObject2).putExtra("uin", paramQQAppInterface.a());
        if (paramResourcePluginInfo.strPkgName.equals("com.tx.abouthelp")) {
          ((Intent)localObject2).putExtra("reportMsfLog", true);
        }
        try
        {
          paramContext.startActivity((Intent)localObject2);
          label440:
          if (paramResourcePluginInfo.isNew == 0)
          {
            paramResourcePluginInfo.isNew = 1;
            ThreadManager.b(new fml(localAboutConfig, paramResourcePluginInfo));
          }
          return;
          localObject1 = "";
          break;
          label472:
          localObject2 = "";
        }
        catch (SecurityException paramQQAppInterface)
        {
          break label440;
        }
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilHashtable != null) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramList.next();
        this.jdField_a_of_type_JavaUtilHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
      }
    }
  }
  
  public ResourcePluginInfo a(String paramString)
  {
    return (ResourcePluginInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
  }
  
  public void a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().widthPixels >= 480) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      a(false);
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ResourcePluginListener.a((ResourcePluginListener)this.jdField_a_of_type_JavaUtilList.get(i), (byte)1, 2);
        i += 1;
      }
    }
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AboutConfig", 2, "send to get about config");
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashtable != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashtable.values().iterator();
      while (localIterator.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
        if (localResourcePluginInfo.cDataType == 0)
        {
          GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
          localGetResourceReqInfoV2.cState = 0;
          localGetResourceReqInfoV2.sLanType = localResourcePluginInfo.sLanType;
          localGetResourceReqInfoV2.sResSubType = 0;
          localGetResourceReqInfoV2.strPkgName = localResourcePluginInfo.strPkgName;
          localGetResourceReqInfoV2.uiCurVer = localResourcePluginInfo.uiCurVer;
          localArrayList.add(localGetResourceReqInfoV2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on Get Leba start send: " + localArrayList.size());
    }
    paramPluginConfigProxy.a(32, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramResourcePluginListener);
    }
  }
  
  /* Error */
  public void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   4: ifnull +76 -> 80
    //   7: aload_1
    //   8: ifnull +72 -> 80
    //   11: aload_0
    //   12: getfield 55	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   15: aload_1
    //   16: getfield 64	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   19: invokevirtual 393	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   22: ifeq +58 -> 80
    //   25: aload_0
    //   26: getfield 55	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   29: aload_1
    //   30: getfield 64	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   33: invokevirtual 316	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 60	com/tencent/mobileqq/data/ResourcePluginInfo
    //   39: astore_2
    //   40: aload_2
    //   41: aload_1
    //   42: getfield 98	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   45: putfield 98	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   48: aload_2
    //   49: aload_1
    //   50: getfield 104	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   53: putfield 104	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   56: aload_0
    //   57: getfield 45	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   63: invokevirtual 402	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: astore_1
    //   67: aload_1
    //   68: aload_2
    //   69: invokestatic 406	com/tencent/mobileqq/data/ResourcePluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/data/ResourcePluginInfo;)V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   80: return
    //   81: astore_2
    //   82: aload_1
    //   83: ifnull -3 -> 80
    //   86: aload_1
    //   87: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   90: return
    //   91: astore_2
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	AboutConfig
    //   0	102	1	paramResourcePluginInfo	ResourcePluginInfo
    //   39	30	2	localResourcePluginInfo	ResourcePluginInfo
    //   81	1	2	localException	java.lang.Exception
    //   91	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   67	72	81	java/lang/Exception
    //   67	72	91	finally
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "error happens: loadAboutConfig while current account is null, which means there is no logined account now");
      }
    }
    do
    {
      return;
      if ((paramBoolean) || (this.jdField_a_of_type_JavaUtilHashtable == null) || (this.jdField_a_of_type_JavaUtilHashtable.size() <= 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AboutConfig", 2, "there has about data in memory cache, do not need load from DB");
    return;
    this.jdField_a_of_type_JavaUtilHashtable = a();
    ThreadManager.b(new fmj(this));
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashtable.values().iterator();
    while (localIterator.hasNext())
    {
      ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
      if ((localResourcePluginInfo.isNew == 0) && (localResourcePluginInfo.cLocalState == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashtable != null) {
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramResourcePluginListener);
  }
  
  public void c()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.AboutConfig
 * JD-Core Version:    0.7.0.1
 */