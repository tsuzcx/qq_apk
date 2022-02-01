import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.timleba.TimLebaHelper.2;
import com.tencent.tim.timleba.TimLebaHelper.3;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.util.Map<Ljava.lang.String;Ljava.lang.Object;>;>;
import java.util.Map;
import java.util.Set;
import mqq.observer.ServerConfigObserver;

public class auno
{
  ArrayList<Map<String, Object>> Eo;
  public List<aehu> La;
  private ServerConfigObserver b = new aunp(this);
  boolean bHU = false;
  byte[] cO = new byte[0];
  int cwf = 0;
  public Set<String> dv;
  public QQAppInterface mApp;
  List<ResourcePluginListener> xA;
  List<ResourcePluginInfo> xy;
  List<ResourcePluginInfo> xz;
  
  public auno(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.xy = new ArrayList(10);
    this.xz = new ArrayList(10);
    this.xA = new ArrayList(2);
    this.dv = new HashSet();
    this.La = new ArrayList();
    this.Eo = new ArrayList();
  }
  
  private ResourcePluginInfo a(long paramLong)
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.sResSubType = 1;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = paramLong;
    localResourcePluginInfo.iPluginType = 64;
    return localResourcePluginInfo;
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
      QLog.d("TimLebaHelper", 4, "clearLocalDBPlugin.local plugin.");
    }
    localObject1 = this.mApp.a().createEntityManager();
    try
    {
      List localList = ResourcePluginInfo.getAll((EntityManager)localObject1, 64, false);
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localList.get(i);
          if ((localResourcePluginInfo != null) && (localResourcePluginInfo.cDataType == 1) && (localResourcePluginInfo.iPluginType == 64)) {
            ResourcePluginInfo.remove((EntityManager)localObject1, localResourcePluginInfo.strPkgName);
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
    ResourcePluginInfo localResourcePluginInfo = a(21L);
    localResourcePluginInfo.strPkgName = "PKG_FILE";
    localResourcePluginInfo.strResName = this.mApp.getApp().getString(2131692563);
    localResourcePluginInfo.strResURL = "me_file";
    localResourcePluginInfo.strResSimpleDesc = "微云、在线文档等";
    localResourcePluginInfo.strResDesc = "微云、在线文档等";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 398;
    this.xz.add(localResourcePluginInfo);
    localResourcePluginInfo = a(18L);
    localResourcePluginInfo.strPkgName = "PKG_FAV";
    localResourcePluginInfo.strResName = "收藏";
    localResourcePluginInfo.strResURL = "me_favorite";
    localResourcePluginInfo.strResSimpleDesc = "文本图片链接语音";
    localResourcePluginInfo.strResDesc = "永久收藏QQ内容，支持添加文字、图片、网页链接、文件、短视频等内容。";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 397;
    this.xz.add(localResourcePluginInfo);
    localResourcePluginInfo = a(17L);
    localResourcePluginInfo.strPkgName = "PKG_EMAIL";
    localResourcePluginInfo.strResName = "邮箱";
    localResourcePluginInfo.strResURL = "me_mail";
    localResourcePluginInfo.strResSimpleDesc = "邮件收发";
    localResourcePluginInfo.strResDesc = "你可以通过该功能收取和回复QQ邮箱邮件和代收邮箱邮件。";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 395;
    this.xz.add(localResourcePluginInfo);
    localResourcePluginInfo = a(26L);
    localResourcePluginInfo.strPkgName = "PKG_TODOLIST";
    localResourcePluginInfo.strResName = "待办";
    localResourcePluginInfo.strResURL = "me_todo";
    localResourcePluginInfo.strResSimpleDesc = this.mApp.getApp().getString(2131695253);
    localResourcePluginInfo.strResDesc = "待办事项";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 396;
    this.xz.add(localResourcePluginInfo);
    localResourcePluginInfo = a(20L);
    localResourcePluginInfo.strPkgName = "PKG_PHONE";
    localResourcePluginInfo.strResName = "电话";
    localResourcePluginInfo.strResURL = "me_call";
    localResourcePluginInfo.strResSimpleDesc = "快捷联系好友";
    localResourcePluginInfo.strResDesc = "查看通话记录，从通讯录拨打电话。";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 394;
    this.xz.add(localResourcePluginInfo);
    localResourcePluginInfo = a(19L);
    localResourcePluginInfo.strPkgName = "PKG_SCHEDULE";
    localResourcePluginInfo.strResName = "日程";
    localResourcePluginInfo.strResURL = "me_celendar";
    localResourcePluginInfo.strResSimpleDesc = "查看近期行程安排";
    localResourcePluginInfo.strResDesc = "预约他人时间，规划自己的时间，到点提醒。";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 393;
    localResourcePluginInfo.uiResId = 19L;
    this.xz.add(localResourcePluginInfo);
    localResourcePluginInfo = a(22L);
    localResourcePluginInfo.strPkgName = "PKG_QQ_WALLET";
    localResourcePluginInfo.strResName = "钱包";
    localResourcePluginInfo.strResURL = "me_wallet";
    localResourcePluginInfo.strResSimpleDesc = "余额资金管理";
    localResourcePluginInfo.strResDesc = "你可以进行充值、转账、理财等服务。";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 297;
    this.xz.add(localResourcePluginInfo);
    if (aqmj.a(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), "key_fuli_switch", 1) == 0)
    {
      localResourcePluginInfo = a(30L);
      localResourcePluginInfo.strPkgName = "PKG_FULI";
      localResourcePluginInfo.strResName = aqmj.n(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), "key_fuli_name");
      localResourcePluginInfo.strResURL = "me_fuli";
      localResourcePluginInfo.strResDesc = aqmj.n(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), "key_fuli_desc");
      localResourcePluginInfo.strGotoUrl = "";
      localResourcePluginInfo.sPriority = 296;
      this.xz.add(localResourcePluginInfo);
    }
    localResourcePluginInfo = a(35L);
    localResourcePluginInfo.strPkgName = "PKG_XIAOCHENGXU";
    localResourcePluginInfo.strResName = "工作台";
    localResourcePluginInfo.strResURL = "me_xiaochengxu";
    localResourcePluginInfo.strResSimpleDesc = "我的工作台";
    localResourcePluginInfo.strResDesc = "根据你的兴趣爱好，为你推荐最想看的咨询：新闻时事、娱乐八卦、科技动漫、文化历史……你想看的尽在看点。";
    localResourcePluginInfo.strGotoUrl = "";
    localResourcePluginInfo.sPriority = 295;
    this.xz.add(localResourcePluginInfo);
    localResourcePluginInfo = a(24L);
    localResourcePluginInfo.strPkgName = "qzone_feedlist";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.strResName = "好友动态";
    localResourcePluginInfo.strResURL = "me_qzone";
    localResourcePluginInfo.strResSimpleDesc = "今日说说";
    localResourcePluginInfo.strResDesc = "可以随时查看到好友最新的动态。";
    localResourcePluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.mApp.getCurrentAccountUin(), "tab_qzone" });
    localResourcePluginInfo.sPriority = 294;
    this.xz.add(localResourcePluginInfo);
  }
  
  /* Error */
  private void cJz()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	auno:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 48	auno:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 159	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   16: ifne +21 -> 37
    //   19: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc 200
    //   27: iconst_2
    //   28: ldc_w 428
    //   31: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 57	auno:xz	Ljava/util/List;
    //   41: astore 4
    //   43: aload 4
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield 57	auno:xz	Ljava/util/List;
    //   50: invokeinterface 431 1 0
    //   55: aload 4
    //   57: monitorexit
    //   58: aload_0
    //   59: invokespecial 433	auno:cJy	()V
    //   62: aload_0
    //   63: getfield 35	auno:cO	[B
    //   66: astore 4
    //   68: aload 4
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 55	auno:xy	Ljava/util/List;
    //   75: invokeinterface 431 1 0
    //   80: aload_0
    //   81: getfield 55	auno:xy	Ljava/util/List;
    //   84: aload_0
    //   85: getfield 57	auno:xz	Ljava/util/List;
    //   88: invokeinterface 437 2 0
    //   93: pop
    //   94: aload_0
    //   95: getfield 55	auno:xy	Ljava/util/List;
    //   98: invokeinterface 222 1 0
    //   103: ifle +97 -> 200
    //   106: iconst_0
    //   107: istore_1
    //   108: iload_1
    //   109: aload_0
    //   110: getfield 55	auno:xy	Ljava/util/List;
    //   113: invokeinterface 222 1 0
    //   118: if_icmpge +82 -> 200
    //   121: aload_0
    //   122: getfield 55	auno:xy	Ljava/util/List;
    //   125: iload_1
    //   126: invokeinterface 226 2 0
    //   131: checkcast 79	com/tencent/mobileqq/data/ResourcePluginInfo
    //   134: astore 5
    //   136: aload 5
    //   138: ifnull +17 -> 155
    //   141: aload 5
    //   143: getfield 107	com/tencent/mobileqq/data/ResourcePluginInfo:uiResId	J
    //   146: lstore_2
    //   147: lload_2
    //   148: ldc2_w 438
    //   151: lcmp
    //   152: ifeq +35 -> 187
    //   155: iload_1
    //   156: iconst_1
    //   157: iadd
    //   158: istore_1
    //   159: goto -51 -> 108
    //   162: astore 5
    //   164: aload 4
    //   166: monitorexit
    //   167: aload 5
    //   169: athrow
    //   170: astore 4
    //   172: aload_0
    //   173: monitorexit
    //   174: aload 4
    //   176: athrow
    //   177: astore 4
    //   179: aload 4
    //   181: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   184: goto -122 -> 62
    //   187: aload 5
    //   189: getfield 270	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   192: ifnonnull -37 -> 155
    //   195: goto -40 -> 155
    //   198: astore 5
    //   200: aload 4
    //   202: monitorexit
    //   203: goto -169 -> 34
    //   206: astore 5
    //   208: aload 4
    //   210: monitorexit
    //   211: aload 5
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	auno
    //   107	52	1	i	int
    //   146	2	2	l	long
    //   170	5	4	localObject2	Object
    //   177	32	4	localException	Exception
    //   134	8	5	localResourcePluginInfo	ResourcePluginInfo
    //   162	26	5	localObject3	Object
    //   198	1	5	localThrowable	java.lang.Throwable
    //   206	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   46	58	162	finally
    //   164	167	162	finally
    //   2	19	170	finally
    //   19	34	170	finally
    //   37	46	170	finally
    //   58	62	170	finally
    //   62	71	170	finally
    //   167	170	170	finally
    //   179	184	170	finally
    //   211	214	170	finally
    //   58	62	177	java/lang/Exception
    //   94	106	198	java/lang/Throwable
    //   108	136	198	java/lang/Throwable
    //   141	147	198	java/lang/Throwable
    //   187	195	198	java/lang/Throwable
    //   71	94	206	finally
    //   94	106	206	finally
    //   108	136	206	finally
    //   141	147	206	finally
    //   187	195	206	finally
    //   200	203	206	finally
    //   208	211	206	finally
  }
  
  private Bitmap d(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    aqcu.decodeFile(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i > 300) && (j > 300)) {
      localOptions.inSampleSize = 3;
    }
    localOptions.inJustDecodeBounds = false;
    return aqcu.decodeFile(paramFile.getAbsolutePath(), localOptions);
  }
  
  private void downloadFail(String paramString)
  {
    Iterator localIterator = this.Eo.iterator();
    Map localMap;
    while (localIterator.hasNext())
    {
      localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          if (!localMap.containsKey("TIME")) {
            break label183;
          }
        }
      }
    }
    label183:
    for (int i = ((Integer)localMap.get("TIME")).intValue();; i = 0)
    {
      if (i >= 3) {
        localIterator.remove();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TimLebaHelper", 2, "Download failed icon key = " + paramString + ",time=" + i);
        }
        return;
        i += 1;
        localMap.put("TIME", Integer.valueOf(i));
        localMap.put("LOADING", Boolean.valueOf(false));
      }
    }
  }
  
  private void rC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TimLebaHelper", 2, "Download success icon key = " + paramString);
    }
    Iterator localIterator = this.Eo.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          this.Eo.remove(localMap);
        }
      }
    }
  }
  
  private void runOnSubThread(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, null, true);
  }
  
  public void a(String paramString, URL paramURL, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TimLebaHelper", 2, "Download icon for " + paramString);
    }
    this.mApp.execute(new TimLebaHelper.3(this, paramURL, paramFile, paramString));
  }
  
  public List<ResourcePluginInfo> dZ()
  {
    return this.xy;
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TimLebaHelper", 2, "LebaHelper  init");
    }
    runOnSubThread(new TimLebaHelper.2(this));
  }
  
  public void oc(List<Map<String, Object>> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.Eo.clear();
      this.Eo.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.i("TimLebaHelper", 2, "Download " + paramList.size() + " icons");
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
          paramList = (List<Map<String, Object>>)localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.d("TimLebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
          }
        }
        localObject = (File)localMap.get("FILE");
        if (this.dv.add(str))
        {
          a(str, paramList, (File)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("TimLebaHelper", 2, "Download icon key = " + str);
          }
          localMap.put("LOADING", Boolean.valueOf(true));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auno
 * JD-Core Version:    0.7.0.1
 */