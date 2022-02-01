package com.tencent.mobileqq.scribble;

import acbn;
import aevk;
import aiin;
import aiio;
import amjc;
import amjd;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import aopo;
import aopp;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScribbleResMgr
{
  static ScribbleResMgr a;
  public static final Long ad = Long.valueOf(30000L);
  public static final String cam = acbn.bng + "Config/";
  public static final String can = acbn.bng + "Config/paint/";
  public static final String cao = acbn.bng + "Config/gif/";
  public static final String cap = acbn.bng + "Config/line_icon/";
  public static final String caq = acbn.bng + "Config/gif_icon/";
  static Object sLock = new Object();
  protected Handler bG = new Handler(ThreadManager.getSubThreadLooper());
  public boolean cCS;
  private boolean cCT;
  private boolean cCU;
  private boolean cCV;
  private String car = "";
  private String cas = "";
  private String cau = "";
  private String cav = "";
  private Lock lock = new ReentrantLock();
  private final ArrayList<a> mCallbacks = new ArrayList();
  private boolean mIsShow = true;
  private final Handler mUiHandler = new amjc(this, Looper.getMainLooper());
  private ArrayList<ResInfo> zv = new ArrayList();
  private ArrayList<ResInfo> zw = new ArrayList();
  
  private void AU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = paramString.substring(0, paramString.lastIndexOf(File.separator));
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new File(paramString);
          if (!paramString.exists())
          {
            paramString.mkdirs();
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.d("ScribbleResMgrdownloading", 2, "makedir execption: " + paramString);
      }
    }
  }
  
  private void H(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 3) {
      this.cCU = paramBoolean;
    }
    if (paramInt1 == 4) {
      this.cCT = paramBoolean;
    }
    Iterator localIterator;
    ResInfo localResInfo;
    if (paramInt1 == 2)
    {
      localIterator = this.zv.iterator();
      while (localIterator.hasNext())
      {
        localResInfo = (ResInfo)localIterator.next();
        if ((localResInfo != null) && (localResInfo.sourceId == paramInt2)) {
          localResInfo.downloading = paramBoolean;
        }
      }
    }
    if (paramInt1 == 1)
    {
      localIterator = this.zw.iterator();
      while (localIterator.hasNext())
      {
        localResInfo = (ResInfo)localIterator.next();
        if ((localResInfo != null) && (localResInfo.sourceId == paramInt2)) {
          localResInfo.downloading = paramBoolean;
        }
      }
    }
  }
  
  private void I(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Message localMessage = new Message();
    if (paramBoolean) {}
    for (int i = 1001;; i = 1002)
    {
      localMessage.what = i;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      this.mUiHandler.sendMessageDelayed(localMessage, 0L);
      return;
    }
  }
  
  public static String P(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return cap + "line_icon_" + String.valueOf(paramInt2) + ".png";
    }
    if (paramInt1 == 2) {
      return caq + "gif_icon_" + String.valueOf(paramInt2) + ".png";
    }
    return null;
  }
  
  private boolean P(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = null;
    String str = aqmj.bv(paramQQAppInterface.getApp().getBaseContext());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("version"))
        {
          localObject1 = localJSONObject.getString("version");
          boolean bool;
          Object localObject3;
          return bool;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (localJSONObject.has("iconUrl")) {
            this.car = localJSONObject.getString("iconUrl");
          }
          if (localJSONObject.has("iconMd5")) {
            this.cas = localJSONObject.getString("iconMd5");
          }
          if (localJSONObject.has("content")) {
            localObject2 = localJSONObject.getJSONArray("content");
          }
          bool = true;
          localObject2 = a((JSONArray)localObject2, 1);
          eO((ArrayList)localObject2);
          if (((str != null) && (str.equalsIgnoreCase((String)localObject1))) || (!bool)) {
            continue;
          }
          QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + (String)localObject1);
          aqmj.cK(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
          aqmj.cM(paramQQAppInterface.getApp().getBaseContext(), paramString);
          b(paramQQAppInterface, 3, ad.longValue());
          if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
            break label398;
          }
          paramString = ((ArrayList)localObject2).iterator();
          if (!paramString.hasNext()) {
            break label398;
          }
          localObject1 = (ResInfo)paramString.next();
          if (((ResInfo)localObject1).downloading) {
            continue;
          }
          if ((((ResInfo)localObject1).predownload != 1) && (!this.cCV)) {
            continue;
          }
          a(paramQQAppInterface, (ResInfo)localObject1, ad.longValue(), true);
          continue;
          localJSONException1 = localJSONException1;
          localObject1 = null;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT JSON EXCEPT");
        bool = false;
        localObject3 = null;
        continue;
        QLog.e("ScribbleResMgr", 2, "mArrPaintInfo index :" + ((ResInfo)localObject1).sourceId + " is downloading ");
        continue;
        QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + (String)localObject1 + " oldVersion=  " + str);
      }
      label398:
      Object localObject1 = null;
    }
  }
  
  public static String Q(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return can + "line_orig_" + String.valueOf(paramInt2) + ".png";
    }
    if (paramInt1 == 2) {
      return eX(paramInt2);
    }
    return null;
  }
  
  private boolean Q(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = null;
    String str = aqmj.bu(paramQQAppInterface.getApp().getBaseContext());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("version"))
        {
          localObject1 = localJSONObject.getString("version");
          boolean bool;
          Object localObject3;
          return bool;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (localJSONObject.has("iconUrl")) {
            this.cau = localJSONObject.getString("iconUrl");
          }
          if (localJSONObject.has("iconMd5")) {
            this.cav = localJSONObject.getString("iconMd5");
          }
          if (localJSONObject.has("content")) {
            localObject2 = localJSONObject.getJSONArray("content");
          }
          bool = true;
          localObject2 = a((JSONArray)localObject2, 2);
          eN((ArrayList)localObject2);
          if (((str != null) && (str.equalsIgnoreCase((String)localObject1))) || (!bool)) {
            continue;
          }
          QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + (String)localObject1);
          aqmj.cJ(paramQQAppInterface.getApp().getBaseContext(), (String)localObject1);
          aqmj.cL(paramQQAppInterface.getApp().getBaseContext(), paramString);
          b(paramQQAppInterface, 4, ad.longValue());
          if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
            break label402;
          }
          paramString = ((ArrayList)localObject2).iterator();
          if ((paramString == null) || (!paramString.hasNext())) {
            break label402;
          }
          localObject1 = (ResInfo)paramString.next();
          if (((ResInfo)localObject1).downloading) {
            continue;
          }
          if ((((ResInfo)localObject1).predownload != 1) && (!this.cCV)) {
            continue;
          }
          a(paramQQAppInterface, (ResInfo)localObject1, ad.longValue(), true);
          continue;
          localJSONException1 = localJSONException1;
          localObject1 = null;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
        bool = false;
        localObject3 = null;
        continue;
        QLog.e("ScribbleResMgr", 2, "mArrGifInfo index :" + ((ResInfo)localObject1).sourceId + " is downloading ");
        continue;
        QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + (String)localObject1 + " oldVersion=  " + str);
      }
      label402:
      Object localObject1 = null;
    }
  }
  
  public static boolean Y(Context paramContext, String paramString)
  {
    boolean bool = aqmj.aD(paramContext, paramString);
    QLog.d("ScribbleResMgr", 2, "getNeedScribbleRedShow" + bool);
    return bool;
  }
  
  public static boolean Z(Context paramContext, String paramString)
  {
    boolean bool1 = aa(paramContext, paramString);
    boolean bool2 = aqmj.aE(paramContext, paramString);
    QLog.d("ScribbleResMgr", 2, "getNeedScribblePlusRedShow" + bool2);
    return (bool2) && (bool1);
  }
  
  public static ScribbleResMgr a()
  {
    if (a != null) {
      return a;
    }
    synchronized (sLock)
    {
      if (a != null)
      {
        ScribbleResMgr localScribbleResMgr1 = a;
        return localScribbleResMgr1;
      }
    }
    a = new ScribbleResMgr();
    ScribbleResMgr localScribbleResMgr2 = a;
    return localScribbleResMgr2;
  }
  
  public static ArrayList<ResInfo> a(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return null;
    }
    try
    {
      int j = paramJSONArray.length();
      if (j <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        ResInfo localResInfo = (ResInfo)aiio.convertFromJSONObject(paramJSONArray.getJSONObject(i), ResInfo.class);
        if (localResInfo != null)
        {
          localResInfo.resType = paramInt;
          localArrayList.add(localResInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      if (QLog.isDevelopLevel())
      {
        paramJSONArray.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "convertFromErr: " + paramJSONArray);
      }
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, ResInfo paramResInfo, long paramLong, boolean paramBoolean)
  {
    if (paramResInfo == null) {
      return;
    }
    ScribbleResMgr.4 local4 = new ScribbleResMgr.4(this, paramResInfo);
    aopo localaopo;
    String str;
    if (paramBoolean)
    {
      localaopo = (aopo)paramQQAppInterface.getManager(193);
      if (localaopo.isEnable())
      {
        str = null;
        if (paramResInfo.resType == 1) {
          str = Q(paramResInfo.resType, paramResInfo.sourceId);
        }
        if (paramResInfo.resType != 2) {
          break label340;
        }
        str = eW(paramResInfo.sourceId);
      }
    }
    label340:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "download res, predownload enable:" + paramResInfo.sourceId + " " + paramResInfo.resType + " outpath:" + str + " url:" + paramResInfo.sourceUrl);
      }
      paramQQAppInterface = new aopp(paramQQAppInterface, "doodle_msg_res", local4, 4000L);
      localaopo.a(10068, "prd", String.valueOf(paramResInfo.sourceId), 0, paramResInfo.sourceUrl, str, 2, 0, true, paramQQAppInterface);
      return;
      paramQQAppInterface = (aopo)paramQQAppInterface.getManager(193);
      if (paramQQAppInterface.isEnable())
      {
        paramQQAppInterface.a(paramResInfo.sourceUrl);
        if (QLog.isColorLevel()) {
          QLog.d("ScribbleResMgr", 2, "download res, cancel predownload reqeust Url:" + paramResInfo.sourceUrl);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "download res, normal download:" + paramResInfo.sourceId + " " + paramResInfo.resType + " Url:" + paramResInfo.sourceUrl);
      }
      this.bG.postDelayed(local4, paramLong);
      return;
    }
  }
  
  private void a(ResInfo paramResInfo, int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramResInfo;
    localMessage.arg1 = paramResInfo.resType;
    this.mUiHandler.sendMessageDelayed(localMessage, 0L);
    I(paramResInfo.resType, paramResInfo.sourceId, false);
  }
  
  public static boolean aa(Context paramContext, String paramString)
  {
    boolean bool = aqmj.aC(paramContext, paramString);
    QLog.d("ScribbleResMgr", 2, "canShowEnter" + bool);
    return bool;
  }
  
  private void b(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    this.bG.postDelayed(new ScribbleResMgr.5(this, paramInt, paramQQAppInterface), paramLong);
  }
  
  /* Error */
  public static boolean b(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: new 272	org/json/JSONObject
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 273	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14: astore 12
    //   16: aload 12
    //   18: ldc_w 532
    //   21: invokevirtual 279	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   24: ifeq +631 -> 655
    //   27: aload 12
    //   29: ldc_w 532
    //   32: invokevirtual 283	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokestatic 537	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   38: invokevirtual 540	java/lang/Integer:intValue	()I
    //   41: istore 6
    //   43: iload 6
    //   45: iconst_1
    //   46: if_icmpne +368 -> 414
    //   49: iconst_1
    //   50: istore 7
    //   52: aload 12
    //   54: ldc_w 542
    //   57: invokevirtual 279	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   60: ifeq +590 -> 650
    //   63: aload 12
    //   65: ldc_w 542
    //   68: invokevirtual 283	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 547	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   74: invokevirtual 551	java/lang/Float:floatValue	()F
    //   77: fstore_3
    //   78: aload 12
    //   80: ldc_w 553
    //   83: invokevirtual 279	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   86: ifeq +558 -> 644
    //   89: aload 12
    //   91: ldc_w 553
    //   94: invokevirtual 283	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: invokestatic 537	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   100: invokevirtual 540	java/lang/Integer:intValue	()I
    //   103: istore 6
    //   105: iload 6
    //   107: iconst_1
    //   108: if_icmpne +312 -> 420
    //   111: iconst_1
    //   112: istore 8
    //   114: aload 12
    //   116: ldc_w 555
    //   119: invokevirtual 279	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   122: ifeq +516 -> 638
    //   125: aload 12
    //   127: ldc_w 555
    //   130: invokevirtual 283	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic 547	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   136: invokevirtual 551	java/lang/Float:floatValue	()F
    //   139: fstore 4
    //   141: iload 11
    //   143: istore 9
    //   145: aload 12
    //   147: ldc_w 557
    //   150: invokevirtual 279	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   153: ifeq +32 -> 185
    //   156: aload 12
    //   158: ldc_w 557
    //   161: invokevirtual 283	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: invokestatic 537	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   167: invokevirtual 540	java/lang/Integer:intValue	()I
    //   170: istore 6
    //   172: iload 11
    //   174: istore 9
    //   176: iload 6
    //   178: iconst_1
    //   179: if_icmpne +6 -> 185
    //   182: iconst_1
    //   183: istore 9
    //   185: iconst_1
    //   186: istore 11
    //   188: iload 7
    //   190: istore 10
    //   192: iload 8
    //   194: istore 7
    //   196: fload_3
    //   197: fstore 5
    //   199: fload 4
    //   201: fstore_3
    //   202: aload_1
    //   203: iload 10
    //   205: aload_2
    //   206: invokestatic 560	aqmj:e	(Landroid/content/Context;ZLjava/lang/String;)V
    //   209: iload 7
    //   211: ifeq +261 -> 472
    //   214: aload_1
    //   215: aload_2
    //   216: invokestatic 563	aqmj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Float;
    //   219: invokevirtual 551	java/lang/Float:floatValue	()F
    //   222: fstore 4
    //   224: fload 5
    //   226: fload 4
    //   228: fcmpl
    //   229: ifle +62 -> 291
    //   232: aload_1
    //   233: iload 7
    //   235: invokestatic 568	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   238: aload_2
    //   239: invokestatic 571	aqmj:a	(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/String;)V
    //   242: aload_1
    //   243: fload 5
    //   245: invokestatic 574	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   248: aload_2
    //   249: invokestatic 577	aqmj:a	(Landroid/content/Context;Ljava/lang/Float;Ljava/lang/String;)V
    //   252: ldc_w 305
    //   255: iconst_2
    //   256: new 49	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 579
    //   266: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: fload 4
    //   271: invokevirtual 582	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   274: ldc_w 584
    //   277: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: fload 5
    //   282: invokevirtual 582	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   285: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: iload 9
    //   293: ifeq +220 -> 513
    //   296: aload_1
    //   297: aload_2
    //   298: invokestatic 586	aqmj:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Float;
    //   301: invokevirtual 551	java/lang/Float:floatValue	()F
    //   304: fstore 4
    //   306: fload_3
    //   307: fload 4
    //   309: fcmpl
    //   310: ifle +57 -> 367
    //   313: aload_1
    //   314: fload_3
    //   315: invokestatic 574	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   318: aload_2
    //   319: invokestatic 588	aqmj:b	(Landroid/content/Context;Ljava/lang/Float;Ljava/lang/String;)V
    //   322: aload_1
    //   323: iload 9
    //   325: aload_2
    //   326: invokestatic 591	aqmj:f	(Landroid/content/Context;ZLjava/lang/String;)V
    //   329: ldc_w 305
    //   332: iconst_2
    //   333: new 49	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 593
    //   343: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: fload 4
    //   348: invokevirtual 582	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   351: ldc_w 595
    //   354: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: fload_3
    //   358: invokevirtual 582	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   361: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: invokestatic 457	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +41 -> 411
    //   373: ldc_w 305
    //   376: iconst_2
    //   377: new 49	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 597
    //   387: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 10
    //   392: invokevirtual 385	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: ldc_w 599
    //   398: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_0
    //   402: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: iload 11
    //   413: ireturn
    //   414: iconst_0
    //   415: istore 7
    //   417: goto -365 -> 52
    //   420: iconst_0
    //   421: istore 8
    //   423: goto -309 -> 114
    //   426: astore 12
    //   428: fconst_0
    //   429: fstore 4
    //   431: iconst_0
    //   432: istore 7
    //   434: iconst_0
    //   435: istore 8
    //   437: fconst_0
    //   438: fstore_3
    //   439: aload 12
    //   441: invokevirtual 337	org/json/JSONException:printStackTrace	()V
    //   444: ldc_w 305
    //   447: iconst_2
    //   448: ldc_w 601
    //   451: invokestatic 342	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: iconst_0
    //   455: istore 11
    //   457: fload 4
    //   459: fstore 5
    //   461: iload 10
    //   463: istore 9
    //   465: iload 8
    //   467: istore 10
    //   469: goto -267 -> 202
    //   472: ldc_w 305
    //   475: iconst_2
    //   476: new 49	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 603
    //   486: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 7
    //   491: invokevirtual 385	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: aload_1
    //   501: iload 7
    //   503: invokestatic 568	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   506: aload_2
    //   507: invokestatic 571	aqmj:a	(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/String;)V
    //   510: goto -219 -> 291
    //   513: ldc_w 305
    //   516: iconst_2
    //   517: new 49	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 605
    //   527: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: iload 9
    //   532: invokevirtual 385	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   535: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload_1
    //   542: iload 9
    //   544: aload_2
    //   545: invokestatic 591	aqmj:f	(Landroid/content/Context;ZLjava/lang/String;)V
    //   548: goto -181 -> 367
    //   551: astore 12
    //   553: fconst_0
    //   554: fstore 4
    //   556: iconst_0
    //   557: istore 9
    //   559: iload 7
    //   561: istore 8
    //   563: fconst_0
    //   564: fstore_3
    //   565: iload 9
    //   567: istore 7
    //   569: goto -130 -> 439
    //   572: astore 12
    //   574: fload_3
    //   575: fstore 4
    //   577: iload 7
    //   579: istore 8
    //   581: iconst_0
    //   582: istore 7
    //   584: fconst_0
    //   585: fstore_3
    //   586: goto -147 -> 439
    //   589: astore 12
    //   591: fload_3
    //   592: fstore 4
    //   594: iload 7
    //   596: istore 9
    //   598: fconst_0
    //   599: fstore_3
    //   600: iload 8
    //   602: istore 7
    //   604: iload 9
    //   606: istore 8
    //   608: goto -169 -> 439
    //   611: astore 12
    //   613: fload_3
    //   614: fstore 5
    //   616: iload 7
    //   618: istore 9
    //   620: fload 4
    //   622: fstore_3
    //   623: fload 5
    //   625: fstore 4
    //   627: iload 8
    //   629: istore 7
    //   631: iload 9
    //   633: istore 8
    //   635: goto -196 -> 439
    //   638: fconst_0
    //   639: fstore 4
    //   641: goto -500 -> 141
    //   644: iconst_0
    //   645: istore 8
    //   647: goto -533 -> 114
    //   650: fconst_0
    //   651: fstore_3
    //   652: goto -574 -> 78
    //   655: iconst_0
    //   656: istore 7
    //   658: goto -606 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	paramString1	String
    //   0	661	1	paramContext	Context
    //   0	661	2	paramString2	String
    //   77	575	3	f1	float
    //   139	501	4	f2	float
    //   197	427	5	f3	float
    //   41	139	6	i	int
    //   50	607	7	bool1	boolean
    //   112	534	8	bool2	boolean
    //   143	489	9	bool3	boolean
    //   1	467	10	bool4	boolean
    //   4	452	11	bool5	boolean
    //   14	143	12	localJSONObject	JSONObject
    //   426	14	12	localJSONException1	JSONException
    //   551	1	12	localJSONException2	JSONException
    //   572	1	12	localJSONException3	JSONException
    //   589	1	12	localJSONException4	JSONException
    //   611	1	12	localJSONException5	JSONException
    // Exception table:
    //   from	to	target	type
    //   6	43	426	org/json/JSONException
    //   52	78	551	org/json/JSONException
    //   78	105	572	org/json/JSONException
    //   114	141	589	org/json/JSONException
    //   145	172	611	org/json/JSONException
  }
  
  public static void bQ(Context paramContext, String paramString)
  {
    QLog.d("ScribbleResMgr", 2, "setScribbleRedShowed false");
    aqmj.a(paramContext, Boolean.valueOf(false), paramString);
  }
  
  public static void bR(Context paramContext, String paramString)
  {
    aqmj.f(paramContext, false, paramString);
    QLog.d("ScribbleResMgr", 2, "setScribblePlusRedShowed false");
  }
  
  /* Error */
  private void c(int paramInt1, int paramInt2, View paramView, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 129	com/tencent/mobileqq/scribble/ScribbleResMgr:mCallbacks	Ljava/util/ArrayList;
    //   6: invokevirtual 207	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 5
    //   11: aload 5
    //   13: invokeinterface 212 1 0
    //   18: ifeq +41 -> 59
    //   21: aload 5
    //   23: invokeinterface 216 1 0
    //   28: checkcast 9	com/tencent/mobileqq/scribble/ScribbleResMgr$a
    //   31: astore 6
    //   33: aload 6
    //   35: invokevirtual 620	com/tencent/mobileqq/scribble/ScribbleResMgr$a:getView	()Landroid/view/View;
    //   38: aload_3
    //   39: if_acmpne -28 -> 11
    //   42: aload 6
    //   44: new 622	java/lang/ref/WeakReference
    //   47: dup
    //   48: aload 4
    //   50: invokespecial 625	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   53: putfield 629	com/tencent/mobileqq/scribble/ScribbleResMgr$a:callback	Ljava/lang/ref/WeakReference;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getfield 129	com/tencent/mobileqq/scribble/ScribbleResMgr:mCallbacks	Ljava/util/ArrayList;
    //   63: new 9	com/tencent/mobileqq/scribble/ScribbleResMgr$a
    //   66: dup
    //   67: aload_0
    //   68: iload_1
    //   69: iload_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokespecial 632	com/tencent/mobileqq/scribble/ScribbleResMgr$a:<init>	(Lcom/tencent/mobileqq/scribble/ScribbleResMgr;IILandroid/view/View;Lcom/tencent/mobileqq/scribble/ScribbleResMgr$b;)V
    //   76: invokevirtual 428	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   79: pop
    //   80: goto -24 -> 56
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ScribbleResMgr
    //   0	88	1	paramInt1	int
    //   0	88	2	paramInt2	int
    //   0	88	3	paramView	View
    //   0	88	4	paramb	b
    //   9	13	5	localIterator	Iterator
    //   31	12	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	11	83	finally
    //   11	56	83	finally
    //   59	80	83	finally
  }
  
  private ArrayList<ResInfo> dA()
  {
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    try
    {
      if ((this.zw != null) && (this.zw.size() > 0))
      {
        Iterator localIterator = this.zw.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if (localResInfo != null) {
            localArrayList.add(localResInfo.cpy(localResInfo));
          }
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
    return localArrayList1;
  }
  
  private ArrayList<ResInfo> dB()
  {
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    try
    {
      if ((this.zv != null) && (this.zv.size() > 0))
      {
        Iterator localIterator = this.zv.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if (localResInfo != null) {
            localArrayList.add(localResInfo.cpy(localResInfo));
          }
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
    return localArrayList1;
  }
  
  private void dNX()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = null;
    localMessage.arg1 = 0;
    this.mUiHandler.sendMessageDelayed(localMessage, 0L);
  }
  
  private void dp(ArrayList<ResInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new amjd(this));
  }
  
  private void eN(ArrayList<ResInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.lock.lock();
    }
    try
    {
      this.zv.clear();
      this.zv.addAll(paramArrayList);
      dp(this.zv);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private void eO(ArrayList<ResInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.lock.lock();
    }
    try
    {
      this.zw.clear();
      this.zw.addAll(paramArrayList);
      dp(this.zw);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private static String eV(int paramInt)
  {
    return cao + "gif_zip_tmp" + String.valueOf(paramInt) + "/";
  }
  
  private static String eW(int paramInt)
  {
    return eV(paramInt) + "gif_zip_tmp" + String.valueOf(paramInt);
  }
  
  private static String eX(int paramInt)
  {
    return eV(paramInt) + "gif_orig_" + String.valueOf(paramInt) + ".gif";
  }
  
  private void h(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int m = 0;
    z(paramQQAppInterface);
    int i;
    int j;
    if (paramInt1 == 3) {
      if (TextUtils.isEmpty(this.car))
      {
        i = 1;
        j = i;
        if (paramInt1 == 4)
        {
          if (!TextUtils.isEmpty(this.cau)) {
            break label140;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      i = j;
      if (paramInt1 == 1)
      {
        if (!this.zw.isEmpty()) {
          break label167;
        }
        i = 1;
      }
      j = i;
      if (paramInt1 == 2)
      {
        if (!this.zv.isEmpty()) {
          break label277;
        }
        j = 1;
      }
      if ((j != 0) && (!this.cCV))
      {
        this.cCV = true;
        aevk.ad(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
      }
      return;
      if (!this.cCU) {
        b(paramQQAppInterface, paramInt1, 50L);
      }
      i = 0;
      break;
      label140:
      j = i;
      if (!this.cCT)
      {
        b(paramQQAppInterface, paramInt1, 50L);
        j = i;
      }
    }
    label167:
    Object localObject = dA();
    ResInfo localResInfo;
    int k;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if ((localObject != null) && (((Iterator)localObject).hasNext()))
        {
          localResInfo = (ResInfo)((Iterator)localObject).next();
          if ((localResInfo != null) && (localResInfo.sourceId == paramInt2)) {
            if (!localResInfo.downloading)
            {
              localResInfo.downloading = true;
              a(paramQQAppInterface, localResInfo, 50L, false);
              k = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = j;
      if (k != 0) {
        break;
      }
      i = 1;
      break;
      label277:
      localObject = dB();
      paramInt1 = m;
      long l;
      if (localObject != null)
      {
        paramInt1 = m;
        if (((ArrayList)localObject).size() > 0)
        {
          localObject = ((ArrayList)localObject).iterator();
          do
          {
            paramInt1 = m;
            if (localObject == null) {
              break;
            }
            paramInt1 = m;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localResInfo = (ResInfo)((Iterator)localObject).next();
          } while ((localResInfo == null) || (localResInfo.sourceId != paramInt2));
          if (localResInfo.downloading) {
            break label465;
          }
          localResInfo.downloading = true;
          l = Thread.currentThread().getId();
          QLog.i("ScribbleResMgr", 2, "RESOURCE_TYPE_GIF threadId: " + l + " inf.resType:  " + localResInfo.resType + " resID: " + localResInfo.sourceId + " downloading is false set true");
          a(paramQQAppInterface, localResInfo, 0L, false);
        }
      }
      for (paramInt1 = 1;; paramInt1 = 1)
      {
        j = i;
        if (paramInt1 != 0) {
          break;
        }
        j = 1;
        break;
        label465:
        l = Thread.currentThread().getId();
        QLog.i("ScribbleResMgr", 2, "RESOURCE_TYPE_GIF threadId: " + l + " inf.resType:  " + localResInfo.resType + " resID: " + localResInfo.sourceId + "is downloading  ");
      }
      k = 1;
      continue;
      k = 0;
    }
  }
  
  private boolean oF(String paramString)
  {
    localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("iconUrl")) {
        this.car = localJSONObject.getString("iconUrl");
      }
      if (localJSONObject.has("iconMd5")) {
        this.cas = localJSONObject.getString("iconMd5");
      }
      paramString = localObject;
      if (localJSONObject.has("content")) {
        paramString = localJSONObject.getJSONArray("content");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "parsePaintConfigInfo JSON EXCEPT");
        paramString = localObject;
      }
    }
    eO(a(paramString, 1));
    return true;
  }
  
  private boolean oG(String paramString)
  {
    localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("iconUrl")) {
        this.cau = localJSONObject.getString("iconUrl");
      }
      if (localJSONObject.has("iconMd5")) {
        this.cav = localJSONObject.getString("iconMd5");
      }
      paramString = localObject;
      if (localJSONObject.has("content")) {
        paramString = localJSONObject.getJSONArray("content");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
        paramString = localObject;
      }
    }
    eN(a(paramString, 2));
    return true;
  }
  
  private String yS()
  {
    return acbn.bng + "paint_icon";
  }
  
  private String yT()
  {
    return acbn.bng + "gif_icon";
  }
  
  private void z(QQAppInterface paramQQAppInterface)
  {
    if (!this.cCS)
    {
      long l1 = System.currentTimeMillis();
      QLog.i("ScribbleResMgr", 2, "init=======================timenow:" + l1);
      String str = aqmj.bx(paramQQAppInterface.getApp().getApplicationContext());
      paramQQAppInterface = aqmj.bw(paramQQAppInterface.getApp().getApplicationContext());
      if (!TextUtils.isEmpty(str)) {
        oF(str);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        oG(paramQQAppInterface);
      }
      this.cCS = true;
      long l2 = System.currentTimeMillis();
      QLog.i("ScribbleResMgr", 2, "init=======================timenow:" + l2);
      QLog.i("ScribbleResMgr", 2, "init==========================timedec:" + (l2 - l1));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, View paramView, b paramb)
  {
    c(paramInt1, paramInt2, paramView, paramb);
    paramQQAppInterface = new ScribbleResMgr.2(this, paramQQAppInterface, paramInt1, paramInt2);
    this.bG.post(paramQQAppInterface);
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 2598) {
      bool = P(paramQQAppInterface, paramString);
    }
    if (paramInt == 2599) {
      bool = Q(paramQQAppInterface, paramString);
    }
    if (!bool) {
      dNX();
    }
    return bool;
  }
  
  public void dNV()
  {
    this.cCV = false;
    QLog.d("ScribbleResMgr", 2, "setGetConfigFinished");
  }
  
  public void dNW()
  {
    dNX();
    dNV();
    QLog.e("ScribbleResMgr", 2, "onGetConfigFailed");
  }
  
  public ArrayList<Integer> i(QQAppInterface paramQQAppInterface)
  {
    z(paramQQAppInterface);
    paramQQAppInterface = new ArrayList();
    this.lock.lock();
    try
    {
      if ((this.zw != null) && (this.zw.size() > 0))
      {
        Iterator localIterator = this.zw.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if ((localResInfo.resType == 1) && (localResInfo.isShow == 1) && ((localResInfo.showInApp & 0x2) > 0)) {
            paramQQAppInterface.add(Integer.valueOf(localResInfo.sourceId));
          }
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
    return paramQQAppInterface;
  }
  
  public ArrayList<Integer> j(QQAppInterface paramQQAppInterface)
  {
    z(paramQQAppInterface);
    paramQQAppInterface = new ArrayList();
    this.lock.lock();
    try
    {
      if ((this.zv != null) && (this.zv.size() > 0))
      {
        Iterator localIterator = this.zv.iterator();
        while (localIterator.hasNext())
        {
          ResInfo localResInfo = (ResInfo)localIterator.next();
          if ((localResInfo.resType == 2) && (localResInfo.isShow == 1) && ((localResInfo.showInApp & 0x2) > 0)) {
            paramQQAppInterface.add(Integer.valueOf(localResInfo.sourceId));
          }
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
    return paramQQAppInterface;
  }
  
  public static class ResInfo
  {
    @aiin("downloading")
    public boolean downloading;
    @aiin("isShow")
    public int isShow = 1;
    @aiin("name")
    public String name = "";
    @aiin("orderIndex")
    public int orderIndex;
    @aiin("predownload")
    public int predownload = 1;
    @aiin("resType")
    public int resType;
    @aiin("showInApp")
    public int showInApp;
    @aiin("sourceId")
    public int sourceId;
    @aiin("sourceMd5")
    public String sourceMd5 = "";
    @aiin("sourceUrl")
    public String sourceUrl = "";
    
    ResInfo cpy(ResInfo paramResInfo)
    {
      ResInfo localResInfo = new ResInfo();
      localResInfo.resType = paramResInfo.resType;
      localResInfo.sourceId = paramResInfo.sourceId;
      localResInfo.sourceUrl = paramResInfo.sourceUrl;
      localResInfo.sourceMd5 = paramResInfo.sourceMd5;
      localResInfo.name = paramResInfo.name;
      localResInfo.predownload = paramResInfo.predownload;
      localResInfo.downloading = paramResInfo.downloading;
      localResInfo.isShow = paramResInfo.isShow;
      localResInfo.showInApp = paramResInfo.showInApp;
      localResInfo.orderIndex = paramResInfo.orderIndex;
      return localResInfo;
    }
  }
  
  public class a
  {
    WeakReference<ScribbleResMgr.b> callback;
    int id;
    int resType;
    WeakReference<View> view;
    
    public a(int paramInt1, int paramInt2, View paramView, ScribbleResMgr.b paramb)
    {
      this.view = new WeakReference(paramView);
      this.callback = new WeakReference(paramb);
      this.resType = paramInt1;
      this.id = paramInt2;
    }
    
    public ScribbleResMgr.b a()
    {
      return (ScribbleResMgr.b)this.callback.get();
    }
    
    public View getView()
    {
      return (View)this.view.get();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr
 * JD-Core Version:    0.7.0.1
 */