package com.tencent.mobileqq.medalwall;

import SummaryCard.TMedalWallInfo;
import acff;
import ajri;
import akjp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import aqft;
import aqhq;
import aqmj;
import arwv;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class MedalWallMng
  implements Handler.Callback, Manager
{
  protected static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  protected static final String bQn = SDCARD_ROOT + File.separator + "tencent/MobileQQ/medal/";
  public static int dhp = 1;
  public static int dhq = 2;
  public static int dhr = 3;
  public static int dhs = 4;
  public static int dht = 5;
  public static int dhu = 6;
  public static int dhv = 7;
  protected final auru a;
  private String bQo;
  private String bQp;
  protected final SparseArray<MedalInfo> cQ;
  private boolean cng;
  protected int dhw;
  protected int dhx;
  private int dhy = -2147483648;
  protected QQAppInterface mApp;
  protected boolean mIsInit;
  private String mShareUrl;
  protected final ArrayList<a> xA;
  
  public MedalWallMng(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.cQ = new SparseArray(3);
    this.xA = new ArrayList();
    this.a = new auru(ThreadManager.getSubThreadLooper(), this);
    this.dhw = 0;
  }
  
  private void Qx(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCheckResFlag value: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.mApp.getAccount() });
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4);
    if (((SharedPreferences)localObject).getInt("MEDAL_CHECK_RES_STATE", 0) != paramInt) {
      ((SharedPreferences)localObject).edit().putInt("MEDAL_CHECK_RES_STATE", paramInt).apply();
    }
  }
  
  public static void a(MedalInfo paramMedalInfo, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalInfo[");
    paramStringBuilder.append("iId: ").append(paramMedalInfo.iId).append(",");
    paramStringBuilder.append("iType: ").append(paramMedalInfo.iType).append(",");
    paramStringBuilder.append("iLevel: ").append(paramMedalInfo.iLevel).append(",");
    paramStringBuilder.append("iLevelCount: ").append(paramMedalInfo.iLevelCount).append(",");
    paramStringBuilder.append("lEndTime: ").append(paramMedalInfo.lEndTime).append(",");
    paramStringBuilder.append("iUnreadLevel1: ").append(paramMedalInfo.iUnreadLevel1).append(",");
    paramStringBuilder.append("iUnreadLevel2: ").append(paramMedalInfo.iUnreadLevel2).append(",");
    paramStringBuilder.append("iUnreadLevel3: ").append(paramMedalInfo.iUnreadLevel3).append(",");
    paramStringBuilder.append("iNoProgress: ").append(paramMedalInfo.iNoProgress).append(",");
    paramStringBuilder.append("strName: ").append(paramMedalInfo.strName);
    paramStringBuilder.append("] ");
  }
  
  public static void a(MedalID paramMedalID, StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("MedalID[");
    paramStringBuilder.append("id: ").append(paramMedalID.id).append(",");
    paramStringBuilder.append("level: ").append(paramMedalID.level);
    paramStringBuilder.append("] ");
  }
  
  private void a(a parama)
  {
    if ((parama == null) || (parama.a == null)) {}
    while (!aqhq.fileExistsAndNotEmpty(parama.localPath)) {
      return;
    }
    try
    {
      Resources localResources = BaseApplicationImpl.getApplication().getResources();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = localResources.getDimensionPixelSize(2131298720);
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      URLDrawable.getDrawable(new File(parama.localPath), localURLDrawableOptions).startDownload(true);
      return;
    }
    catch (Exception parama)
    {
      QLog.e("MedalWallMng", 1, "tryPreloadImg fail.", parama);
    }
  }
  
  private boolean aqi()
  {
    boolean bool;
    if (aqmj.aG(this.mApp.getApplication(), this.mApp.getCurrentAccountUin()) != 1)
    {
      bool = true;
      this.cng = bool;
      if (!this.cng) {
        break label42;
      }
    }
    label42:
    while ((((acff)this.mApp.getManager(51)).c(this.mApp.getCurrentAccountUin()).medalSwitchDisable) || (aqft.rj(this.mApp.getCurrentAccountUin())))
    {
      return true;
      bool = false;
      break;
    }
    return false;
  }
  
  private void dvM()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckMedalRes checkedCount: %d", new Object[] { Integer.valueOf(this.dhw) }));
    }
    synchronized (this.xA)
    {
      if (this.dhw <= 0) {
        break label190;
      }
      i = this.dhw - 1;
      break label178;
      if (i < this.xA.size())
      {
        a locala1 = (a)this.xA.get(i);
        if ((locala1 == null) || (locala1.cnh))
        {
          this.dhw = (i + 1);
        }
        else if (locala1.aqj())
        {
          this.dhw = (i + 1);
          a(locala1);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ThreadManager.post(new DownloadResTask(locala2), 5, null, false);
        return;
      }
      if (this.dhx > 0)
      {
        Qx(2);
        return;
      }
      Qx(1);
      return;
    }
    for (;;)
    {
      label178:
      Object localObject = null;
      break;
      i += 1;
      break;
      label190:
      i = 0;
    }
  }
  
  private void dvN()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "doCheckForLogin");
    }
    this.a.removeMessages(3);
    Object localObject = (akjp)this.mApp.getManager(160);
    boolean bool;
    int i;
    if (((akjp)localObject).a(((akjp)localObject).a(10015), false))
    {
      bool = true;
      if (!bool) {
        break label164;
      }
      localObject = String.format(Locale.getDefault(), "%s%s", new Object[] { "medal_wall_", this.mApp.getAccount() });
      i = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject, 4).getInt("MEDAL_CHECK_RES_STATE", 0);
      if (i != 2) {
        break label157;
      }
      dvP();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckForLogin hasRP: %s, flag: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      return;
      bool = false;
      break;
      label157:
      dvQ();
      continue;
      label164:
      Qx(0);
      i = 0;
    }
  }
  
  private void dvR()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    this.bQo = localSharedPreferences.getString("hostUrl", "");
    this.bQp = localSharedPreferences.getString("guestUrl", "");
    this.mShareUrl = localSharedPreferences.getString("shareUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,local hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { this.bQo, this.bQp, this.mShareUrl }));
    }
    if (TextUtils.isEmpty(this.bQo)) {
      this.bQo = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.bQp)) {
      this.bQp = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4";
    }
    if (TextUtils.isEmpty(this.mShareUrl)) {
      this.mShareUrl = "https://ti.qq.com/qqmedal2/share.html?_wv=16777217&_wwv=4&_bid=2450";
    }
  }
  
  private void init()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mIsInit;
        if (bool) {
          return;
        }
        if (!QLog.isColorLevel()) {
          break label223;
        }
        StringBuilder localStringBuilder = new StringBuilder(200);
        Object localObject4 = this.mApp.a().createEntityManager().query(MedalInfo.class);
        if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
          synchronized (this.cQ)
          {
            this.cQ.clear();
            localObject4 = ((List)localObject4).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              MedalInfo localMedalInfo = (MedalInfo)((Iterator)localObject4).next();
              if (localMedalInfo == null) {
                continue;
              }
              this.cQ.put(localMedalInfo.iId, localMedalInfo);
              if ((!QLog.isColorLevel()) || (localStringBuilder == null)) {
                continue;
              }
              a(localMedalInfo, localStringBuilder);
              localStringBuilder.append("\r\n");
            }
          }
        }
      }
      finally {}
      this.mIsInit = true;
      if ((QLog.isColorLevel()) && (localObject2 != null))
      {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "init size: %d \r\n{%s}", new Object[] { Integer.valueOf(this.cQ.size()), localObject2.toString() }));
        continue;
        label223:
        Object localObject3 = null;
      }
    }
  }
  
  public static String lM(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MedalWallMng", 2, String.format("validateUrl>>> url=%s", new Object[] { paramString }));
    }
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.startsWith("https://"));
      paramString = "https://" + paramString;
      str = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("MedalWallMng", 2, String.format("validateUrl<<< url=%s", new Object[] { paramString }));
    return paramString;
  }
  
  /* Error */
  public void E(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 100	com/tencent/mobileqq/medalwall/MedalWallMng:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 484	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   10: invokevirtual 490	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 7
    //   15: new 109	java/util/ArrayList
    //   18: dup
    //   19: iconst_5
    //   20: invokespecial 544	java/util/ArrayList:<init>	(I)V
    //   23: astore 6
    //   25: iload_1
    //   26: iconst_2
    //   27: if_icmpne +309 -> 336
    //   30: aload_0
    //   31: getfield 107	com/tencent/mobileqq/medalwall/MedalWallMng:cQ	Landroid/util/SparseArray;
    //   34: astore 8
    //   36: aload 8
    //   38: monitorenter
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: aload_0
    //   43: getfield 107	com/tencent/mobileqq/medalwall/MedalWallMng:cQ	Landroid/util/SparseArray;
    //   46: invokevirtual 526	android/util/SparseArray:size	()I
    //   49: if_icmpge +265 -> 314
    //   52: aload_0
    //   53: getfield 107	com/tencent/mobileqq/medalwall/MedalWallMng:cQ	Landroid/util/SparseArray;
    //   56: iload_3
    //   57: invokevirtual 547	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   60: checkcast 207	com/tencent/mobileqq/data/MedalInfo
    //   63: astore 9
    //   65: aload 9
    //   67: aload 6
    //   69: invokevirtual 551	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   72: aload 9
    //   74: invokevirtual 554	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   77: aload 9
    //   79: invokevirtual 557	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   82: sipush 1000
    //   85: if_icmpne +13 -> 98
    //   88: aload 7
    //   90: aload 9
    //   92: invokevirtual 561	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   95: goto +469 -> 564
    //   98: aload 9
    //   100: invokevirtual 557	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   103: sipush 1001
    //   106: if_icmpeq +14 -> 120
    //   109: aload 9
    //   111: invokevirtual 557	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   114: sipush 1002
    //   117: if_icmpne +447 -> 564
    //   120: aload 7
    //   122: aload 9
    //   124: invokevirtual 565	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   127: pop
    //   128: goto +436 -> 564
    //   131: astore_2
    //   132: aload 8
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: iconst_0
    //   139: istore_3
    //   140: aload_2
    //   141: invokevirtual 568	java/lang/Throwable:printStackTrace	()V
    //   144: iload_1
    //   145: ifne +320 -> 465
    //   148: aload_0
    //   149: aconst_null
    //   150: iconst_1
    //   151: invokevirtual 571	com/tencent/mobileqq/medalwall/MedalWallMng:a	(LSummaryCard/TMedalWallInfo;Z)Lcom/tencent/mobileqq/data/Card;
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 100	com/tencent/mobileqq/medalwall/MedalWallMng:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   159: sipush 160
    //   162: invokevirtual 357	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   165: checkcast 414	akjp
    //   168: astore 7
    //   170: iload_1
    //   171: iconst_1
    //   172: if_icmpeq +8 -> 180
    //   175: iload_1
    //   176: iconst_2
    //   177: if_icmpne +335 -> 512
    //   180: aload 7
    //   182: sipush 10015
    //   185: invokevirtual 574	akjp:RT	(I)V
    //   188: aload 7
    //   190: sipush 10016
    //   193: invokevirtual 574	akjp:RT	(I)V
    //   196: aload 6
    //   198: invokevirtual 576	java/util/ArrayList:isEmpty	()Z
    //   201: ifne +19 -> 220
    //   204: aload_0
    //   205: getfield 100	com/tencent/mobileqq/medalwall/MedalWallMng:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: iconst_2
    //   209: invokevirtual 580	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   212: checkcast 582	com/tencent/mobileqq/app/CardHandler
    //   215: aload 6
    //   217: invokevirtual 585	com/tencent/mobileqq/app/CardHandler:dz	(Ljava/util/ArrayList;)V
    //   220: aload_2
    //   221: ifnull +17 -> 238
    //   224: aload_2
    //   225: getfield 588	com/tencent/mobileqq/data/Card:iNewCount	I
    //   228: ifne +15 -> 243
    //   231: aload_2
    //   232: getfield 591	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   235: ifne +8 -> 243
    //   238: aload_0
    //   239: iconst_0
    //   240: invokespecial 403	com/tencent/mobileqq/medalwall/MedalWallMng:Qx	(I)V
    //   243: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +67 -> 313
    //   249: invokestatic 142	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   252: astore 6
    //   254: aload_2
    //   255: ifnonnull +286 -> 541
    //   258: iconst_0
    //   259: istore 4
    //   261: aload_2
    //   262: ifnonnull +288 -> 550
    //   265: ldc 136
    //   267: iconst_2
    //   268: aload 6
    //   270: ldc_w 593
    //   273: iconst_4
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: iload_1
    //   280: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: iload_3
    //   287: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: iload 4
    //   295: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: aastore
    //   299: dup
    //   300: iconst_3
    //   301: iload 5
    //   303: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: aastore
    //   307: invokestatic 156	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   310: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: return
    //   314: aload 8
    //   316: monitorexit
    //   317: aload_0
    //   318: getfield 112	com/tencent/mobileqq/medalwall/MedalWallMng:xA	Ljava/util/ArrayList;
    //   321: astore 8
    //   323: aload 8
    //   325: monitorenter
    //   326: aload_0
    //   327: getfield 112	com/tencent/mobileqq/medalwall/MedalWallMng:xA	Ljava/util/ArrayList;
    //   330: invokevirtual 594	java/util/ArrayList:clear	()V
    //   333: aload 8
    //   335: monitorexit
    //   336: aload_2
    //   337: instanceof 13
    //   340: ifeq +219 -> 559
    //   343: aload_2
    //   344: checkcast 13	com/tencent/mobileqq/medalwall/MedalWallMng$a
    //   347: astore_2
    //   348: aload_2
    //   349: getfield 287	com/tencent/mobileqq/medalwall/MedalWallMng$a:a	Lcom/tencent/mobileqq/data/MedalInfo;
    //   352: getfield 210	com/tencent/mobileqq/data/MedalInfo:iId	I
    //   355: istore_3
    //   356: aload_2
    //   357: getfield 287	com/tencent/mobileqq/medalwall/MedalWallMng$a:a	Lcom/tencent/mobileqq/data/MedalInfo;
    //   360: astore 8
    //   362: aload 8
    //   364: aload 6
    //   366: invokevirtual 551	com/tencent/mobileqq/data/MedalInfo:putReportInfo	(Ljava/util/ArrayList;)V
    //   369: aload 8
    //   371: invokevirtual 554	com/tencent/mobileqq/data/MedalInfo:setRead	()V
    //   374: aload 8
    //   376: invokevirtual 557	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   379: sipush 1000
    //   382: if_icmpne +40 -> 422
    //   385: aload 7
    //   387: aload 8
    //   389: invokevirtual 561	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   392: aload_0
    //   393: getfield 112	com/tencent/mobileqq/medalwall/MedalWallMng:xA	Ljava/util/ArrayList;
    //   396: astore 7
    //   398: aload 7
    //   400: monitorenter
    //   401: aload_0
    //   402: getfield 112	com/tencent/mobileqq/medalwall/MedalWallMng:xA	Ljava/util/ArrayList;
    //   405: aload_2
    //   406: invokevirtual 598	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   409: pop
    //   410: aload 7
    //   412: monitorexit
    //   413: goto -269 -> 144
    //   416: astore_2
    //   417: aload 8
    //   419: monitorexit
    //   420: aload_2
    //   421: athrow
    //   422: aload 8
    //   424: invokevirtual 557	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   427: sipush 1001
    //   430: if_icmpeq +14 -> 444
    //   433: aload 8
    //   435: invokevirtual 557	com/tencent/mobileqq/data/MedalInfo:getStatus	()I
    //   438: sipush 1002
    //   441: if_icmpne -49 -> 392
    //   444: aload 7
    //   446: aload 8
    //   448: invokevirtual 565	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   451: pop
    //   452: goto -60 -> 392
    //   455: astore_2
    //   456: goto -316 -> 140
    //   459: astore_2
    //   460: aload 7
    //   462: monitorexit
    //   463: aload_2
    //   464: athrow
    //   465: aload_0
    //   466: getfield 100	com/tencent/mobileqq/medalwall/MedalWallMng:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   469: bipush 51
    //   471: invokevirtual 357	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   474: checkcast 359	acff
    //   477: astore 7
    //   479: aload 7
    //   481: aload_0
    //   482: getfield 100	com/tencent/mobileqq/medalwall/MedalWallMng:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   485: invokevirtual 345	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   488: invokevirtual 363	acff:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   491: astore_2
    //   492: aload_2
    //   493: iconst_0
    //   494: putfield 591	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   497: aload_2
    //   498: iconst_0
    //   499: putfield 588	com/tencent/mobileqq/data/Card:iNewCount	I
    //   502: aload 7
    //   504: aload_2
    //   505: invokevirtual 601	acff:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   508: pop
    //   509: goto -354 -> 155
    //   512: aload_2
    //   513: ifnull +17 -> 530
    //   516: aload_2
    //   517: getfield 588	com/tencent/mobileqq/data/Card:iNewCount	I
    //   520: ifne -324 -> 196
    //   523: aload_2
    //   524: getfield 591	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   527: ifne -331 -> 196
    //   530: aload 7
    //   532: sipush 10015
    //   535: invokevirtual 574	akjp:RT	(I)V
    //   538: goto -342 -> 196
    //   541: aload_2
    //   542: getfield 588	com/tencent/mobileqq/data/Card:iNewCount	I
    //   545: istore 4
    //   547: goto -286 -> 261
    //   550: aload_2
    //   551: getfield 591	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   554: istore 5
    //   556: goto -291 -> 265
    //   559: iconst_0
    //   560: istore_3
    //   561: goto -148 -> 413
    //   564: iload_3
    //   565: iconst_1
    //   566: iadd
    //   567: istore_3
    //   568: goto -527 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	MedalWallMng
    //   0	571	1	paramInt	int
    //   0	571	2	paramObject	Object
    //   40	528	3	i	int
    //   259	287	4	j	int
    //   1	554	5	k	int
    //   23	342	6	localObject1	Object
    //   34	413	8	localObject3	Object
    //   63	60	9	localMedalInfo	MedalInfo
    // Exception table:
    //   from	to	target	type
    //   41	95	131	finally
    //   98	120	131	finally
    //   120	128	131	finally
    //   132	135	131	finally
    //   314	317	131	finally
    //   30	39	137	java/lang/Throwable
    //   135	137	137	java/lang/Throwable
    //   317	326	137	java/lang/Throwable
    //   336	356	137	java/lang/Throwable
    //   420	422	137	java/lang/Throwable
    //   326	336	416	finally
    //   417	420	416	finally
    //   356	392	455	java/lang/Throwable
    //   392	401	455	java/lang/Throwable
    //   422	444	455	java/lang/Throwable
    //   444	452	455	java/lang/Throwable
    //   463	465	455	java/lang/Throwable
    //   401	413	459	finally
    //   460	463	459	finally
  }
  
  public ArrayList<MedalID> L(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject;
    try
    {
      paramString = paramString.replaceAll("new_medals=", "").replaceAll("update_medals=", "").replaceAll("&", ",").split(",");
      i = 0;
      if (i >= paramString.length) {
        break label136;
      }
      if ((paramString[i] == null) || (paramString[i].isEmpty())) {
        break label338;
      }
      localObject = paramString[i].split("_");
      if (localObject.length != 3) {
        break label338;
      }
      localArrayList.add(new MedalID(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1])));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "summarycard", paramString);
      }
    }
    label133:
    return localArrayList;
    label136:
    int j = localArrayList.size() - 1;
    label144:
    if (j >= 0)
    {
      paramString = (MedalID)localArrayList.get(j);
      localObject = a(paramString.id);
      switch (paramString.level)
      {
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localArrayList.remove(j);
        if (QLog.isColorLevel())
        {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "parsePromptParams local read [id: %d , level: %d]", new Object[] { Integer.valueOf(paramString.id), Integer.valueOf(paramString.level) }));
          break label350;
          if (((MedalInfo)localObject).iUnreadLevel1 != 2) {
            break label357;
          }
          i = 1;
          continue;
          if (((MedalInfo)localObject).iUnreadLevel2 != 2) {
            break label362;
          }
          i = 1;
          continue;
          if (((MedalInfo)localObject).iUnreadLevel3 != 2) {
            break label367;
          }
          i = 1;
          continue;
          i = ((MedalInfo)localObject).iUnreadLevel1;
          if (i == 2)
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
          label338:
          i += 1;
          break;
          i = 0;
          continue;
        }
      }
      label350:
      j -= 1;
      break label144;
      break label133;
      label357:
      i = 0;
      continue;
      label362:
      i = 0;
      continue;
      label367:
      i = 0;
    }
  }
  
  public void Qy(int paramInt)
  {
    this.dhy = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetMedalStrongReminderConfig value: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public Card a(TMedalWallInfo paramTMedalWallInfo, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    Object localObject1 = this.cQ;
    int i1 = 0;
    for (;;)
    {
      Object localObject2;
      int n;
      int m;
      try
      {
        if (i1 < this.cQ.size())
        {
          localObject2 = (MedalInfo)this.cQ.valueAt(i1);
          if (localObject2 == null) {
            break label527;
          }
          if (((MedalInfo)localObject2).iLevel == 255)
          {
            n = i;
            m = j;
            if (((MedalInfo)localObject2).iUnreadLevel1 != 1) {
              break label520;
            }
            j += 1;
            break label527;
          }
          n = i;
          m = j;
          if (((MedalInfo)localObject2).iLevelCount <= 1) {
            break label520;
          }
          int k = j;
          if (((MedalInfo)localObject2).iLevel >= 1)
          {
            k = j;
            if (((MedalInfo)localObject2).iUnreadLevel1 == 1) {
              k = j + 1;
            }
          }
          j = i;
          if (((MedalInfo)localObject2).iLevel >= 2)
          {
            j = i;
            if (((MedalInfo)localObject2).iUnreadLevel2 == 1) {
              j = i + 1;
            }
          }
          n = j;
          m = k;
          if (((MedalInfo)localObject2).iLevel < 3) {
            break label520;
          }
          n = j;
          m = k;
          if (((MedalInfo)localObject2).iUnreadLevel3 != 1) {
            break label520;
          }
          i = j + 1;
          j = k;
          break label527;
        }
        localObject1 = (acff)this.mApp.getManager(51);
        localObject2 = ((acff)localObject1).c(this.mApp.getCurrentAccountUin());
        if (paramTMedalWallInfo != null)
        {
          ((Card)localObject2).iMedalCount = paramTMedalWallInfo.iMedalCount;
          if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo needCheck: %s, compute[iNewCount: %d, iUpgradeCount: %d] server[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramTMedalWallInfo.iNewCount), Integer.valueOf(paramTMedalWallInfo.iUpgradeCount), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
          }
          if ((paramBoolean) && ((paramTMedalWallInfo.iNewCount > j) || (paramTMedalWallInfo.iUpgradeCount > i)))
          {
            paramTMedalWallInfo.iNewCount = Math.min(paramTMedalWallInfo.iNewCount, j);
            paramTMedalWallInfo.iUpgradeCount = Math.min(paramTMedalWallInfo.iUpgradeCount, i);
          }
          ((Card)localObject2).iNewCount = paramTMedalWallInfo.iNewCount;
          ((Card)localObject2).iUpgradeCount = paramTMedalWallInfo.iUpgradeCount;
          ((acff)localObject1).a((Card)localObject2);
          return localObject2;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo compute[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((Card)localObject2).iNewCount), Integer.valueOf(((Card)localObject2).iUpgradeCount) }));
      }
      ((Card)localObject2).iNewCount = Math.min(((Card)localObject2).iNewCount, j);
      ((Card)localObject2).iUpgradeCount = Math.min(((Card)localObject2).iUpgradeCount, i);
      continue;
      label520:
      i = n;
      j = m;
      label527:
      i1 += 1;
    }
  }
  
  public MedalInfo a(int paramInt)
  {
    init();
    synchronized (this.cQ)
    {
      MedalInfo localMedalInfo = (MedalInfo)this.cQ.get(paramInt);
      ??? = localMedalInfo;
      if (localMedalInfo == null)
      {
        ??? = new MedalInfo();
        ((MedalInfo)???).iId = paramInt;
        ((MedalInfo)???).iLevel = 0;
        ((MedalInfo)???).iUnreadLevel1 = 0;
        ((MedalInfo)???).iUnreadLevel2 = 0;
        ((MedalInfo)???).iUnreadLevel3 = 0;
      }
      return ???;
    }
  }
  
  public void a(boolean paramBoolean, TMedalWallInfo paramTMedalWallInfo, SparseArray<MedalInfo> paramSparseArray)
  {
    init();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(200);
      ((StringBuilder)???).append("onGetSelfNewObtainedMedaInfo isSuc:").append(paramBoolean);
      if (paramTMedalWallInfo != null) {
        ((StringBuilder)???).append(", iMedalCount:").append(paramTMedalWallInfo.iMedalCount).append(", iNewCount:").append(paramTMedalWallInfo.iNewCount).append(", iUpgradeCount:").append(paramTMedalWallInfo.iUpgradeCount);
      }
      if (paramSparseArray != null)
      {
        ((StringBuilder)???).append(", medalInfoArrayList: ").append(paramSparseArray.size());
        i = 0;
        if (i < paramSparseArray.size())
        {
          localObject2 = (MedalInfo)paramSparseArray.valueAt(i);
          if (localObject2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            ((StringBuilder)???).append("\r\n info [id: ").append(((MedalInfo)localObject2).iId).append(", iLevel: ").append(((MedalInfo)localObject2).iLevel).append(", name: ").append(((MedalInfo)localObject2).strName).append(", res: ").append(((MedalInfo)localObject2).strResJson).append("]");
          }
        }
      }
      QLog.i("MedalWallMng", 2, ((StringBuilder)???).toString());
    }
    if (!paramBoolean)
    {
      Qx(2);
      dvQ();
      return;
    }
    Object localObject2 = this.mApp.a().createEntityManager();
    Object localObject3 = this.cQ;
    int i = 0;
    for (;;)
    {
      MedalInfo localMedalInfo;
      try
      {
        if (i >= this.cQ.size()) {
          break label446;
        }
        localMedalInfo = (MedalInfo)this.cQ.valueAt(i);
        if (localMedalInfo == null) {
          break label591;
        }
        if (paramSparseArray != null)
        {
          ??? = (MedalInfo)paramSparseArray.get(localMedalInfo.iId);
          if ((??? != null) || (!localMedalInfo.isUnread())) {
            break label591;
          }
          localMedalInfo.setRead();
          if (localMedalInfo.getStatus() != 1000) {
            break label413;
          }
          ((EntityManager)localObject2).persistOrReplace(localMedalInfo);
          if (!QLog.isColorLevel()) {
            break label591;
          }
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetSelfNewObtainedMedaInfo just local is unread [id: %d, level: %d, name: %s]", new Object[] { Integer.valueOf(localMedalInfo.iId), Integer.valueOf(localMedalInfo.iLevel), localMedalInfo.strName }));
        }
      }
      finally {}
      ??? = null;
      continue;
      label413:
      if ((localMedalInfo.getStatus() == 1001) || (localMedalInfo.getStatus() == 1002))
      {
        ((EntityManager)localObject2).update(localMedalInfo);
        continue;
        label446:
        i = 0;
        while ((paramSparseArray != null) && (i < paramSparseArray.size()))
        {
          localObject3 = (MedalInfo)paramSparseArray.valueAt(i);
          if (localObject3 == null)
          {
            i += 1;
          }
          else
          {
            if (((MedalInfo)localObject3).getStatus() == 1000) {
              ((EntityManager)localObject2).persistOrReplace((Entity)localObject3);
            }
            for (;;)
            {
              synchronized (this.cQ)
              {
                this.cQ.put(((MedalInfo)localObject3).iId, localObject3);
              }
              if ((((MedalInfo)localObject3).getStatus() == 1001) || (((MedalInfo)localObject3).getStatus() == 1002)) {
                ((EntityManager)localObject2).update((Entity)localObject3);
              }
            }
          }
        }
        a(paramTMedalWallInfo, true);
        Qx(0);
        break;
        label591:
        i += 1;
      }
    }
  }
  
  public boolean a(BaseActivity paramBaseActivity, View paramView, int paramInt, Object paramObject)
  {
    if (aqh()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkShowMedalGuide medal strong reminder is off!");
      }
    }
    for (;;)
    {
      return false;
      if (this.cng)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkShowMedalGuide isMedalConfigOff: %s", new Object[] { Boolean.valueOf(this.cng) }));
        return false;
      }
      Object localObject1 = (akjp)this.mApp.getManager(160);
      if (((akjp)localObject1).a(((akjp)localObject1).a(10015), false)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label131;
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no red point");
        return false;
      }
      label131:
      Object localObject3 = null;
      localObject1 = null;
      try
      {
        Iterator localIterator = this.xA.iterator();
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = localObject1;
          a locala = (a)localIterator.next();
          if (locala != null)
          {
            localObject3 = localObject1;
            if (locala.cni) {
              break label640;
            }
            localObject3 = localObject1;
            if (!locala.cnh) {
              break label640;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(locala.url)) {
              break label640;
            }
            localObject3 = localObject1;
            if (TextUtils.isEmpty(locala.localPath)) {
              break label640;
            }
            localObject3 = localObject1;
            if (locala.downloadState == 2) {
              break label640;
            }
            localObject3 = localObject1;
            if (locala.a == null) {
              break label640;
            }
            localObject3 = locala;
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              boolean bool = locala.a.isNewer(((a)localObject1).a);
              if (!bool) {
                break label640;
              }
              localObject3 = locala;
            }
            localObject1 = localObject3;
          }
        }
        if ((localObject1 != null) && (((a)localObject1).a != null))
        {
          ((a)localObject1).cni = true;
          localObject3 = ((a)localObject1).a;
          if ((paramObject instanceof Card))
          {
            paramObject = (Card)paramObject;
            if (((MedalInfo)localObject3).iLevel == 255)
            {
              if (((MedalInfo)localObject3).iUnreadLevel1 != 1) {
                break label631;
              }
              i = 0;
              k = 1;
              label371:
              paramObject.iNewCount -= k;
              paramObject.iUpgradeCount -= i;
            }
          }
          else
          {
            paramObject = Message.obtain();
            paramObject.what = 4;
            paramObject.obj = localObject1;
            this.a.sendMessage(paramObject);
            MedalGuideView.a((a)localObject1, paramBaseActivity, paramView, paramInt);
            if (QLog.isDevelopLevel()) {
              QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "checkShowMedalGuide [%d, %d,  %s]", new Object[] { Integer.valueOf(((MedalInfo)localObject3).iId), Integer.valueOf(((MedalInfo)localObject3).iLevel), ((MedalInfo)localObject3).strName }));
            }
            return true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          Object localObject2 = localObject3;
          continue;
          if (((MedalInfo)localObject3).iLevelCount > 1)
          {
            if ((((MedalInfo)localObject3).iLevel >= 1) && (((MedalInfo)localObject3).iUnreadLevel1 == 1)) {}
            for (int j = 1;; j = 0)
            {
              if ((((MedalInfo)localObject3).iLevel >= 2) && (((MedalInfo)localObject3).iUnreadLevel2 == 1)) {}
              for (int m = 1;; m = 0)
              {
                k = j;
                i = m;
                if (((MedalInfo)localObject3).iLevel < 3) {
                  break label371;
                }
                k = j;
                i = m;
                if (((MedalInfo)localObject3).iUnreadLevel3 != 1) {
                  break label371;
                }
                i = m + 1;
                k = j;
                break label371;
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.i("MedalWallMng", 4, "checkShowMedalGuide no medal to show");
                return false;
              }
            }
          }
          label631:
          i = 0;
          int k = 0;
          continue;
          label640:
          localObject3 = localObject2;
        }
      }
    }
  }
  
  public boolean aqh()
  {
    if (this.dhy == -2147483648)
    {
      this.dhy = aqmj.e(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), 3);
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "isMedalStrongReminderOff value: %s", new Object[] { Integer.valueOf(this.dhy) }));
      }
    }
    return this.dhy == 1;
  }
  
  public String b(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.bQo == null) || (this.bQp == null) || (this.mShareUrl == null)) {
      dvR();
    }
    StringBuilder localStringBuilder;
    if (!paramBoolean)
    {
      localStringBuilder = new StringBuilder(this.bQp);
      localStringBuilder.append("&tuin=").append(ajri.encode(paramString));
    }
    for (paramString = localStringBuilder;; paramString = new StringBuilder(this.bQo))
    {
      paramString.append("&from=").append(paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "getMedalWallUrl url: %s", new Object[] { paramString }));
      }
      return paramString.toString();
    }
  }
  
  public void dvO()
  {
    if (aqh()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkForLogin medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!aqi()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "checkForLogin medal is off!");
    return;
    this.a.removeMessages(3);
    this.a.sendEmptyMessageDelayed(3, 1000L);
  }
  
  public void dvP()
  {
    if (aqh()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "onGetSelfObtainNewMedalNotice medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!aqi()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "onGetSelfObtainNewMedalNotice medal is off!");
    return;
    this.a.removeMessages(3);
    ((CardHandler)this.mApp.getBusinessHandler(2)).cHK();
  }
  
  protected void dvQ()
  {
    if (aqh()) {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "checkMedalWall medal strong reminder is off!");
      }
    }
    do
    {
      return;
      if (!aqi()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "checkMedalWall medal is off!");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalWall mIsInit: %s", new Object[] { Boolean.valueOf(this.mIsInit) }));
    }
    this.a.removeMessages(3);
    this.a.removeMessages(1);
    this.dhw = 0;
    this.dhx = 0;
    init();
    ArrayList localArrayList = new ArrayList();
    ??? = this.cQ;
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (i < this.cQ.size())
          {
            MedalInfo localMedalInfo = (MedalInfo)this.cQ.valueAt(i);
            if ((localMedalInfo == null) || (!localMedalInfo.isUnread())) {
              break label255;
            }
            a locala = new a();
            locala.a = localMedalInfo;
            localArrayList.add(locala);
          }
        }
        finally {}
        synchronized (this.xA)
        {
          this.xA.clear();
          this.xA.addAll(localCollection);
          if (this.dhw >= this.xA.size()) {
            break;
          }
          this.a.sendEmptyMessage(1);
          return;
        }
      }
      label255:
      i += 1;
    }
  }
  
  public String getShareUrl()
  {
    if ((this.bQo == null) || (this.bQp == null) || (this.mShareUrl == null)) {
      dvR();
    }
    return this.mShareUrl;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        dvM();
        return true;
        a locala = (a)paramMessage.obj;
        if (locala != null)
        {
          if (locala.downloadState == 2) {
            this.dhx += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "MSG_DOWNLOAD_RES_RESULT failCount: %d, cost: %d, failCode: %d, url: %s", new Object[] { Integer.valueOf(this.dhx), Integer.valueOf(paramMessage.arg1), Integer.valueOf(locala.failCode), locala.url }));
          }
        }
      } while (this.dhw >= this.xA.size());
      this.a.sendEmptyMessage(1);
      return true;
      dvN();
      return true;
    } while (!(paramMessage.obj instanceof a));
    E(0, (a)paramMessage.obj);
    return true;
  }
  
  public void j(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onGetConfig,hostUrl:%s,guestUrl:%s,shareUrl:%s", new Object[] { paramString1, paramString2, paramString3 }));
    }
    if ((this.bQo == null) || (this.bQp == null) || (this.mShareUrl == null)) {
      dvR();
    }
    if ((aqft.equalsWithNullCheck(paramString1, this.bQo)) && (aqft.equalsWithNullCheck(paramString2, this.bQp)) && (aqft.equalsWithNullCheck(paramString3, this.mShareUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 4, "onGetConfig, no change return.");
      }
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putString("hostUrl", paramString1);
    localEditor.putString("guestUrl", paramString2);
    localEditor.putString("shareUrl", paramString3);
    localEditor.commit();
    this.bQo = paramString1;
    this.bQp = paramString2;
    this.mShareUrl = paramString3;
    if (paramInt != 1) {}
    for (;;)
    {
      this.cng = bool;
      return;
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.cQ)
    {
      this.cQ.clear();
    }
    synchronized (this.xA)
    {
      this.xA.clear();
      this.mIsInit = false;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public class DownloadResTask
    implements Runnable
  {
    final MedalWallMng.a b;
    
    public DownloadResTask(MedalWallMng.a parama)
    {
      this.b = parama;
    }
    
    public void run()
    {
      long l3 = SystemClock.elapsedRealtime();
      long l2 = 0L;
      if (TextUtils.isEmpty(this.b.url))
      {
        this.b.downloadState = 2;
        this.b.failCode = 1000;
      }
      for (;;)
      {
        Object localObject = Message.obtain();
        ((Message)localObject).what = 2;
        ((Message)localObject).arg1 = ((int)l2);
        ((Message)localObject).obj = this.b;
        MedalWallMng.this.a.sendMessage((Message)localObject);
        return;
        long l1 = l2;
        try
        {
          localObject = new File(this.b.localPath);
          l1 = l2;
          this.b.failCode = HttpDownloadUtil.a(MedalWallMng.this.mApp, this.b.url, (File)localObject, 2);
          l1 = l2;
          l2 = SystemClock.elapsedRealtime() - l3;
          l1 = l2;
          if (this.b.failCode != 0) {
            break label208;
          }
          l1 = l2;
          this.b.downloadState = 1;
        }
        catch (Throwable localThrowable)
        {
          this.b.downloadState = 2;
          this.b.failCode = 2000;
          localThrowable.printStackTrace();
          l2 = l1;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("MedalWallMng", 2, "DownloadResTask", localThrowable);
          l2 = l1;
          continue;
          label208:
          l1 = l2;
          this.b.downloadState = 2;
        }
      }
    }
  }
  
  public static class a
  {
    public MedalInfo a;
    public String bQq;
    public boolean cnh;
    public boolean cni;
    public int downloadState = 0;
    public int failCode;
    public String localPath;
    public String url;
    
    public boolean aqj()
    {
      if (TextUtils.isEmpty(this.url)) {}
      for (;;)
      {
        try
        {
          localJSONArray = new JSONArray(this.a.strResJson);
          localJSONObject = null;
          i = localJSONArray.length();
          if ((this.a.iLevelCount <= 1) || (i <= this.a.iLevel)) {
            continue;
          }
          localJSONObject = localJSONArray.getJSONObject(this.a.iLevel);
          if ((localJSONObject != null) && (localJSONObject.has("owned3d"))) {
            this.url = MedalWallMng.lM(localJSONObject.getString("owned3d"));
          }
          if ((localJSONObject != null) && (localJSONObject.has("share"))) {
            this.bQq = MedalWallMng.lM(localJSONObject.getString("share"));
          }
        }
        catch (Exception localException)
        {
          JSONArray localJSONArray;
          JSONObject localJSONObject;
          int i;
          localException.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("MedalWallMng", 2, "parse res json fail", localException);
          continue;
          if (this.downloadState != 1) {
            continue;
          }
          this.cnh = true;
          continue;
          if (!aqhq.fileExistsAndNotEmpty(this.localPath)) {
            continue;
          }
          this.cnh = true;
          continue;
        }
        if ((!TextUtils.isEmpty(this.url)) && (TextUtils.isEmpty(this.localPath))) {
          this.localPath = (MedalWallMng.bQn + arwv.toMD5(this.url));
        }
        if (this.downloadState != 2) {
          continue;
        }
        this.cnh = true;
        return this.cnh;
        if (i > 1) {
          localJSONObject = localJSONArray.getJSONObject(1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng
 * JD-Core Version:    0.7.0.1
 */