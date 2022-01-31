package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ctf;
import ctg;
import cth;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespInfoV2;

public class LebaHelper
{
  public static final String a = "qzone_feedlist";
  private static final int jdField_b_of_type_Int = 3;
  public static final String b = "nearby_friends";
  public static final String c = "nearby_troops";
  public static final String d = "hot_chat";
  private static final String e = "LebaHelper";
  private static final String f = "mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.qqlite&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s";
  private static final String g = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.qqlite&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
  private static final String h = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.qqlite&cmp=com.tencent.mobileqq.troop.activity.NearbyTroopsActivity";
  private static final String i = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.qqlite&cmp=com.tencent.mobileqq.activity.HotChatListActivity";
  private static final String j = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.qqlite&cmp=com.dataline.activities.LiteActivity";
  int jdField_a_of_type_Int = 0;
  public QQAppInterface a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  List jdField_a_of_type_JavaUtilList;
  public Set a;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new ctf(this);
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List jdField_b_of_type_JavaUtilList;
  public List c;
  public List d;
  
  public LebaHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.b = new ArrayList(10);
    this.c = new ArrayList(2);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.d = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int k = localOptions.outWidth;
    int m = localOptions.outHeight;
    if ((k > 300) && (m > 300)) {
      localOptions.inSampleSize = 3;
    }
    localOptions.inJustDecodeBounds = false;
    return BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.b(paramRunnable);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "Download success icon key = " + paramString);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Map localMap;
    while (localIterator.hasNext())
    {
      localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          if (!localMap.containsKey("TIME")) {
            break label180;
          }
        }
      }
    }
    label180:
    for (int k = ((Integer)localMap.get("TIME")).intValue();; k = 0)
    {
      if (k >= 3) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "Download failed icon key = " + paramString + ",time=" + k);
        }
        return;
        k += 1;
        localMap.put("TIME", Integer.valueOf(k));
        localMap.put("LOADING", Boolean.valueOf(false));
      }
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 64	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 64	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 227	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: ldc 229
    //   27: iconst_0
    //   28: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   31: astore_2
    //   32: aload_2
    //   33: new 135	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   40: ldc 237
    //   42: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 64	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   49: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   52: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: iconst_1
    //   59: invokeinterface 245 3 0
    //   64: pop
    //   65: invokestatic 248	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   68: ifeq +11 -> 79
    //   71: ldc 22
    //   73: iconst_4
    //   74: ldc 250
    //   76: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_0
    //   80: getfield 64	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   83: invokevirtual 253	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   86: invokevirtual 259	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   89: astore_1
    //   90: aload_1
    //   91: bipush 64
    //   93: iconst_0
    //   94: invokestatic 265	com/tencent/mobileqq/data/ResourcePluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;IZ)Ljava/util/List;
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +123 -> 222
    //   102: aload_3
    //   103: invokeinterface 268 1 0
    //   108: astore_3
    //   109: aload_3
    //   110: invokeinterface 157 1 0
    //   115: ifeq +107 -> 222
    //   118: aload_3
    //   119: invokeinterface 161 1 0
    //   124: checkcast 261	com/tencent/mobileqq/data/ResourcePluginInfo
    //   127: astore 4
    //   129: aload 4
    //   131: ifnull -22 -> 109
    //   134: aload 4
    //   136: getfield 272	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   139: iconst_1
    //   140: if_icmpne -31 -> 109
    //   143: aload 4
    //   145: getfield 275	com/tencent/mobileqq/data/ResourcePluginInfo:iPluginType	I
    //   148: bipush 64
    //   150: if_icmpne -41 -> 109
    //   153: aload_1
    //   154: aload 4
    //   156: getfield 278	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   159: invokestatic 281	com/tencent/mobileqq/data/ResourcePluginInfo:remove	(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/String;)V
    //   162: goto -53 -> 109
    //   165: astore_3
    //   166: aload_3
    //   167: invokevirtual 284	java/lang/Exception:printStackTrace	()V
    //   170: aload_1
    //   171: invokevirtual 288	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   174: aload_2
    //   175: invokeinterface 292 1 0
    //   180: astore_1
    //   181: aload_1
    //   182: new 135	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   189: ldc 237
    //   191: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_0
    //   195: getfield 64	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   198: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   201: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: iconst_0
    //   208: invokeinterface 298 3 0
    //   213: pop
    //   214: aload_1
    //   215: invokeinterface 301 1 0
    //   220: pop
    //   221: return
    //   222: aload_1
    //   223: invokevirtual 288	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   226: goto -52 -> 174
    //   229: astore_2
    //   230: aload_1
    //   231: invokevirtual 288	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   234: aload_2
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	LebaHelper
    //   89	142	1	localObject1	Object
    //   31	144	2	localSharedPreferences	android.content.SharedPreferences
    //   229	6	2	localObject2	Object
    //   97	22	3	localObject3	Object
    //   165	2	3	localException	Exception
    //   127	28	4	localResourcePluginInfo	ResourcePluginInfo
    // Exception table:
    //   from	to	target	type
    //   90	98	165	java/lang/Exception
    //   102	109	165	java/lang/Exception
    //   109	129	165	java/lang/Exception
    //   134	162	165	java/lang/Exception
    //   90	98	229	finally
    //   102	109	229	finally
    //   109	129	229	finally
    //   134	162	229	finally
    //   166	170	229	finally
  }
  
  private void f()
  {
    Object localObject = new ResourcePluginInfo();
    ((ResourcePluginInfo)localObject).strPkgName = "nearby_friends";
    ((ResourcePluginInfo)localObject).strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363187);
    ((ResourcePluginInfo)localObject).strResURL = "qq_leba_list_seek_neighbour";
    ((ResourcePluginInfo)localObject).strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363617);
    ((ResourcePluginInfo)localObject).sResSubType = 2;
    ((ResourcePluginInfo)localObject).cCanChangeState = 1;
    ((ResourcePluginInfo)localObject).cDefaultState = 0;
    ((ResourcePluginInfo)localObject).cLocalState = 1;
    ((ResourcePluginInfo)localObject).cDataType = 1;
    ((ResourcePluginInfo)localObject).isNew = 1;
    ((ResourcePluginInfo)localObject).sLanType = 1;
    ((ResourcePluginInfo)localObject).uiResId = 0L;
    ((ResourcePluginInfo)localObject).strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.qqlite&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
    ((ResourcePluginInfo)localObject).iPluginType = 64;
    ((ResourcePluginInfo)localObject).sPriority = 270;
    this.b.add(localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().widthPixels >= 480) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      GetResourceRespInfoV2 localGetResourceRespInfoV2 = new GetResourceRespInfoV2();
      localGetResourceRespInfoV2.cCanChangeState = 1;
      localGetResourceRespInfoV2.cDefaultState = 0;
      localGetResourceRespInfoV2.cPush = 1;
      localGetResourceRespInfoV2.cStatus = 1;
      localGetResourceRespInfoV2.iPluginType = 64;
      localGetResourceRespInfoV2.sLanType = 0;
      localGetResourceRespInfoV2.sPriority = 395;
      localGetResourceRespInfoV2.sResSubType = 2;
      localGetResourceRespInfoV2.strPkgName = "com.android.group";
      localGetResourceRespInfoV2.strResConf = "<pluginConfig><pluginEntranceName>群与活动</pluginEntranceName><pluginEntranceUrl><![CDATA[mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.qqlite&cmp=com.tencent.mobileqq.troop.activity.NearbyTroopsActivity]]></pluginEntranceUrl></pluginConfig>";
      localGetResourceRespInfoV2.strResDesc = "";
      localGetResourceRespInfoV2.strResName = "附近的群";
      localGetResourceRespInfoV2.uiResId = 886L;
      localGetResourceRespInfoV2.uiNewVer = 0L;
      localGetResourceRespInfoV2.strResURL_big = "http://dl.url.cn/qq_desk/f/886/group_64_20141023.png";
      localGetResourceRespInfoV2.strResURL_small = "http://dl.url.cn/qq_desk/f/886/group_64_20141023.png";
      localObject = ConfigManager.a((EntityManager)localObject, bool, localGetResourceRespInfoV2);
      this.b.add(localObject);
      localObject = new ResourcePluginInfo();
      ((ResourcePluginInfo)localObject).strPkgName = AppConstants.T;
      ((ResourcePluginInfo)localObject).strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363189);
      ((ResourcePluginInfo)localObject).strResDesc = "";
      ((ResourcePluginInfo)localObject).strResURL = "qq_leba_list_seek_computer";
      ((ResourcePluginInfo)localObject).sResSubType = 2;
      ((ResourcePluginInfo)localObject).cCanChangeState = 1;
      ((ResourcePluginInfo)localObject).cDefaultState = 0;
      ((ResourcePluginInfo)localObject).cLocalState = 0;
      ((ResourcePluginInfo)localObject).cDataType = 1;
      ((ResourcePluginInfo)localObject).isNew = 1;
      ((ResourcePluginInfo)localObject).sLanType = 1;
      ((ResourcePluginInfo)localObject).sPriority = 330;
      ((ResourcePluginInfo)localObject).uiResId = 0L;
      ((ResourcePluginInfo)localObject).strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.qqlite&cmp=com.dataline.activities.LiteActivity";
      ((ResourcePluginInfo)localObject).iPluginType = 64;
      this.b.add(localObject);
      return;
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "error happens: loadAllPlugins while app is null || app is not login");
      }
      return;
    }
    this.b.clear();
    try
    {
      f();
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void h()
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
  
  public ResourcePluginInfo a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = ResourcePluginInfo.getAll((EntityManager)localObject, 64, false);
    ((EntityManager)localObject).a();
    if ((localList != null) && (localList.size() > 0))
    {
      int k = 0;
      while (k < localList.size())
      {
        localObject = (ResourcePluginInfo)localList.get(k);
        if (((ResourcePluginInfo)localObject).uiResId == paramInt) {
          return localObject;
        }
        k += 1;
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    a(new ctg(this));
  }
  
  public void a(DownloadIconsListener paramDownloadIconsListener)
  {
    if (!this.d.contains(paramDownloadIconsListener)) {
      this.d.add(paramDownloadIconsListener);
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.c.contains(paramResourcePluginListener)) {
      this.c.add(paramResourcePluginListener);
    }
  }
  
  public void a(String paramString, URL paramURL, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "Download icon for " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cth(this, paramURL, paramFile, paramString));
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, "Download " + paramList.size() + " icons");
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str = (String)localMap.get("KEY");
        paramList = (URL)localMap.get("URL");
        Object localObject = MsfSdkUtils.insertMtype("Dynamic", paramList.toString());
        try
        {
          localObject = new URL((String)localObject);
          paramList = (List)localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.d("LebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
          }
        }
        localObject = (File)localMap.get("FILE");
        if (this.jdField_a_of_type_JavaUtilSet.add(str))
        {
          a(str, paramList, (File)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "Download icon key = " + str);
          }
          localMap.put("LOADING", Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void b(DownloadIconsListener paramDownloadIconsListener)
  {
    this.d.remove(paramDownloadIconsListener);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    this.c.remove(paramResourcePluginListener);
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str;
        Object localObject1;
        if (localMap != null)
        {
          str = (String)localMap.get("KEY");
          localObject1 = (URL)localMap.get("URL");
          localObject2 = MsfSdkUtils.insertMtype("Dynamic", ((URL)localObject1).toString());
        }
        try
        {
          localObject2 = new URL((String)localObject2);
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            Object localObject3;
            QLog.d("LebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
            continue;
            boolean bool = false;
          }
        }
        Object localObject2 = (File)localMap.get("FILE");
        localObject3 = localMap.get("LOADING");
        if ((localObject3 == null) || (!(localObject3 instanceof Boolean))) {
          break label273;
        }
        bool = ((Boolean)localObject3).booleanValue();
        if ((!TextUtils.isEmpty(str)) && (!bool) && (this.jdField_a_of_type_JavaUtilSet.add(str)))
        {
          a(str, (URL)localObject1, (File)localObject2);
          localMap.put("LOADING", Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "reDownload icon key = " + str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaHelper
 * JD-Core Version:    0.7.0.1
 */