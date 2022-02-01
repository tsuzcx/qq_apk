import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.AboutConfig.1;
import com.tencent.mobileqq.config.AboutConfig.3;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfoV2;

public class aehl
{
  private boolean amf;
  private QQAppInterface app;
  private ServerConfigObserver b = new aehm(this);
  private boolean bTU = true;
  private List<ResourcePluginListener> gV;
  private Hashtable<String, ResourcePluginInfo> t;
  
  public aehl(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.gV = new ArrayList();
    this.t = new Hashtable();
  }
  
  private Hashtable<String, ResourcePluginInfo> a()
  {
    Hashtable localHashtable = new Hashtable();
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "tim.tx.help";
    localResourcePluginInfo.strResName = this.app.getApp().getString(2131694592);
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
    localResourcePluginInfo.strGotoUrl = "https://kf.qq.com/touch/product/qebg_app.html#showmenu=1004004";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "tim.tx.android.feedback";
    localResourcePluginInfo.strResName = this.app.getApp().getString(2131693475);
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
    localResourcePluginInfo.strGotoUrl = "https://support.qq.com/product/79336";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    return localHashtable;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ResourcePluginInfo paramResourcePluginInfo)
  {
    aehl localaehl = paramQQAppInterface.a();
    Object localObject2 = paramResourcePluginInfo.strGotoUrl;
    Object localObject1 = localObject2;
    if (paramResourcePluginInfo.strPkgName.equals("tim.tx.android.feedback")) {
      localObject1 = i(paramQQAppInterface, (String)localObject2);
    }
    QLog.i("timBugDebug_About", 2, "about Jump pkg = " + paramResourcePluginInfo.strPkgName + "||| url = " + (String)localObject1);
    localObject2 = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("url", (String)localObject1).putExtra("bFormatUrl", false);
    ((Intent)localObject2).putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    if ((paramResourcePluginInfo.strPkgName.equals("tim.tx.android.feedback")) || (paramResourcePluginInfo.strPkgName.equals("tim.tx.help"))) {
      ((Intent)localObject2).putExtra("reportMsfLog", true);
    }
    if (paramResourcePluginInfo.strPkgName.equals("tim.tx.android.feedback")) {
      ((Intent)localObject2).putExtra("hide_more_button", true);
    }
    try
    {
      paramContext.startActivity((Intent)localObject2);
      label179:
      if (paramResourcePluginInfo.isNew == 0)
      {
        paramResourcePluginInfo.isNew = 1;
        ThreadManager.post(new AboutConfig.3(localaehl, paramResourcePluginInfo), 8, null, false);
      }
      return;
    }
    catch (SecurityException paramQQAppInterface)
    {
      break label179;
    }
  }
  
  private void cWX()
  {
    if (this.t != null) {
      this.t.clear();
    }
  }
  
  public static String i(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    for (;;)
    {
      return paramQQAppInterface;
      String str1 = Build.MODEL;
      label29:
      String str2;
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      if (str1 != null)
      {
        str1 = str1.replaceAll(" ", "_");
        int i = anpc.Kk();
        str2 = str1;
        if (i > 0) {
          str2 = str1 + "_qzpatch" + i;
        }
        str1 = Build.MANUFACTURER;
        if (str1 == null) {
          break label514;
        }
        str1 = str1.replaceAll(" ", "_");
        localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        localJSONObject3 = new JSONObject();
      }
      try
      {
        localJSONObject1.put("appid", AppSetting.getAppId());
        localJSONObject1.put("QUA", avpw.getQUA());
        localJSONObject2.put("product", str2);
        localJSONObject2.put("manufacture", str1);
        localJSONObject2.put("cpunum", aqgz.getCpuNumber());
        localJSONObject2.put("cpurate", aqgz.getCpuFrequency());
        localJSONObject2.put("mem", aqgz.getSystemTotalMemory() / 1024L / 1024L);
        localJSONObject2.put("amem", aqgz.getSystemAvaialbeMemory() / 1024L / 1024L);
        localJSONObject2.put("w", aqgz.hK());
        localJSONObject2.put("h", aqgz.hL());
        localJSONObject2.put("pss", MemoryManager.C(Process.myPid()) / 1024L / 1024L);
        localJSONObject2.put("heapmax", Runtime.getRuntime().maxMemory() / 1024L / 1024L);
        localJSONObject2.put("heapsize", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L / 1024L);
        localJSONObject3.put("user_tag", QLog.getReportLevel(QLog.getUIN_REPORTLOG_LEVEL()));
        paramString = Uri.parse(paramString).buildUpon().appendQueryParameter("clientInfo", localJSONObject1.toString()).appendQueryParameter("clientVersion", "3.4.4.3058").appendQueryParameter("os", localJSONObject2.toString()).appendQueryParameter("osVersion", Build.VERSION.RELEASE).appendQueryParameter("customInfo", localJSONObject3.toString()).appendQueryParameter("_wv", String.valueOf(0));
        if (paramQQAppInterface != null)
        {
          str1 = paramQQAppInterface.getCurrentUin();
          str2 = paramQQAppInterface.getCurrentNickname();
          paramString.appendQueryParameter("avatar", paramQQAppInterface.getApp().getString(2131701250, new Object[] { str1 }));
          paramString.appendQueryParameter("openid", str1);
          paramString.appendQueryParameter("nickname", str2);
        }
        paramString = paramString.build().toString();
        paramQQAppInterface = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("About-Feedback", 2, "feedback after: url = " + paramString);
        return paramString;
        str1 = "";
        break label29;
        label514:
        str1 = "";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("AboutConfig", 1, "config feedback url param failed", localJSONException);
        }
      }
    }
  }
  
  private void jN(List<ResourcePluginInfo> paramList)
  {
    if ((this.t != null) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramList.next();
        this.t.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
      }
    }
  }
  
  public ResourcePluginInfo a(String paramString)
  {
    return (ResourcePluginInfo)this.t.get(paramString);
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (!this.amf) {
      bR(true, false);
    }
    ArrayList localArrayList = new ArrayList();
    if (this.t != null)
    {
      Iterator localIterator = ((Hashtable)this.t.clone()).values().iterator();
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
          localGetResourceReqInfoV2.iPluginType = localResourcePluginInfo.iPluginType;
          localArrayList.add(localGetResourceReqInfoV2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "sendAboutConfig" + localArrayList.size() + ",hasLoadFromDB=" + this.amf);
    }
    paramPluginConfigProxy.a(32, localArrayList, this.b);
  }
  
  /* Error */
  public void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	aehl:t	Ljava/util/Hashtable;
    //   4: ifnull +76 -> 80
    //   7: aload_1
    //   8: ifnull +72 -> 80
    //   11: aload_0
    //   12: getfield 43	aehl:t	Ljava/util/Hashtable;
    //   15: aload_1
    //   16: getfield 56	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   19: invokevirtual 527	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   22: ifeq +58 -> 80
    //   25: aload_0
    //   26: getfield 43	aehl:t	Ljava/util/Hashtable;
    //   29: aload_1
    //   30: getfield 56	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   33: invokevirtual 471	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 49	com/tencent/mobileqq/data/ResourcePluginInfo
    //   39: astore_2
    //   40: aload_2
    //   41: aload_1
    //   42: getfield 94	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   45: putfield 94	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   48: aload_2
    //   49: aload_1
    //   50: getfield 100	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   53: putfield 100	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   56: aload_0
    //   57: getfield 33	aehl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 530	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   63: invokevirtual 536	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: astore_1
    //   67: aload_1
    //   68: aload_2
    //   69: invokestatic 540	com/tencent/mobileqq/data/ResourcePluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/data/ResourcePluginInfo;)V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 545	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   80: return
    //   81: astore_2
    //   82: aload_1
    //   83: ifnull -3 -> 80
    //   86: aload_1
    //   87: invokevirtual 545	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   90: return
    //   91: astore_2
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 545	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	aehl
    //   0	102	1	paramResourcePluginInfo	ResourcePluginInfo
    //   39	30	2	localResourcePluginInfo	ResourcePluginInfo
    //   81	1	2	localException	java.lang.Exception
    //   91	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   67	72	81	java/lang/Exception
    //   67	72	91	finally
  }
  
  public void bR(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AboutConfig", 2, "loadAboutConfig, isfore=" + paramBoolean1 + ",asynchronous=" + paramBoolean2);
    }
    if (!this.app.isLogin()) {
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "error happens: loadAboutConfig while current account is null, which means there is no logined account now");
      }
    }
    do
    {
      return;
      if ((paramBoolean1) || (this.t == null) || (this.t.size() <= 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AboutConfig", 2, "there has about data in memory cache, do not need load from DB");
    return;
    this.t = a();
    AboutConfig.1 local1 = new AboutConfig.1(this, paramBoolean2);
    if (paramBoolean2)
    {
      ThreadManager.post(local1, 5, null, false);
      return;
    }
    local1.run();
  }
  
  public void cWY()
  {
    Iterator localIterator = new ArrayList(this.gV).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 2);
    }
  }
  
  public void g(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.gV.contains(paramResourcePluginListener)) {
      this.gV.add(paramResourcePluginListener);
    }
  }
  
  public void h(ResourcePluginListener paramResourcePluginListener)
  {
    this.gV.remove(paramResourcePluginListener);
  }
  
  public void init()
  {
    int i = 0;
    if (this.app.getApp().getResources().getDisplayMetrics().widthPixels >= 480) {}
    for (boolean bool = true;; bool = false)
    {
      this.bTU = bool;
      bR(false, true);
      while (i < this.gV.size())
      {
        ResourcePluginListener.a((ResourcePluginListener)this.gV.get(i), (byte)1, 2);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aehl
 * JD-Core Version:    0.7.0.1
 */