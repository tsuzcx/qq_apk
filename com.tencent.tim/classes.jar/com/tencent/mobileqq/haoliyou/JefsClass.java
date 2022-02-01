package com.tencent.mobileqq.haoliyou;

import aciu;
import adxf;
import ahwd;
import ahwe;
import ahwf;
import ahwg;
import ahwh;
import ahxb;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class JefsClass
  extends ahwd
{
  private static JefsClass jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass = new JefsClass();
  private static final Set<String> cu = new ArraySet();
  private static final Set<String> cv;
  private static final Set<String> cw;
  private d jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$d;
  private e jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$e;
  private boolean enable;
  private int id;
  private final SparseArrayCompat<Runnable> k = new SparseArrayCompat();
  private ThreadLocal<Boolean> w = new ahwe(this);
  
  static
  {
    cu.add("android.settings.ACCESSIBILITY_SETTINGS");
    if (Build.VERSION.SDK_INT >= 26) {
      cu.add("android.settings.APP_NOTIFICATION_SETTINGS");
    }
    cu.add("android.settings.APPLICATION_DETAILS_SETTINGS");
    cu.add("android.settings.BLUETOOTH_SETTINGS");
    cu.add("android.settings.DATA_ROAMING_SETTINGS");
    cu.add("android.settings.DATE_SETTINGS");
    cu.add("android.settings.INTERNAL_STORAGE_SETTINGS");
    cu.add("android.settings.MEMORY_CARD_SETTINGS");
    cu.add("android.settings.LOCALE_SETTINGS");
    cu.add("android.settings.LOCATION_SOURCE_SETTINGS");
    if (Build.VERSION.SDK_INT >= 24) {
      cu.add("android.settings.MANAGE_DEFAULT_APPS_SETTINGS");
    }
    if (Build.VERSION.SDK_INT >= 23) {
      cu.add("android.settings.action.MANAGE_OVERLAY_PERMISSION");
    }
    if (Build.VERSION.SDK_INT >= 19) {
      cu.add("android.settings.NFC_PAYMENT_SETTINGS");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      cu.add("android.settings.NFC_SETTINGS");
    }
    cu.add("android.settings.NFCSHARING_SETTINGS");
    cu.add("android.settings.SETTINGS");
    cu.add("android.settings.WIFI_SETTINGS");
    cu.add("android.settings.WIRELESS_SETTINGS");
    if (Build.VERSION.SDK_INT >= 23) {
      cu.add("android.settings.action.MANAGE_WRITE_SETTINGS");
    }
    cu.add("android.media.action.IMAGE_CAPTURE");
    cu.add("android.intent.action.PICK");
    cu.add("android.intent.action.CALL");
    cu.add("android.intent.action.DIAL");
    cu.add("android.intent.action.CALL_BUTTON");
    cu.add("android.intent.action.SENDTO");
    cu.add("android.intent.action.GET_CONTENT");
    cu.add("android.intent.action.RINGTONE_PICKER");
    if (Build.VERSION.SDK_INT >= 19) {
      cu.add("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
    }
    cu.add("android.content.pm.CONFIRM_ACCESS_APPCATONS");
    cu.add("com.meizu.safe.security.SHOW_APPSEC");
    cu.add("miui.intent.action.APP_PERM_EDITOR");
    cu.add("android.intent.action.INSERT_OR_EDIT");
    cu.add("android.intent.action.INSERT");
    if (Build.VERSION.SDK_INT >= 16) {
      cu.add("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
    }
    cv = new ArraySet();
    cv.add(BaseApplicationImpl.sApplication.getPackageName());
    cv.add("com.android.settings");
    cv.add("com.miui.securitycenter");
    cv.add("com.miui.system");
    cv.add("com.zui.safecenter");
    cv.add("com.android.mms");
    cv.add("com.sonymobile.cta");
    cv.add("com.huawei.systemmanager");
    cv.add("com.sec.android.app.capabilitymanager");
    cv.add("com.coloros.safecenter");
    cv.add("com.tencent.mobileqq");
    cw = new ArraySet();
    cw.add("com.tencent.mm");
    cw.add("com.tencent.mtt");
    cw.add("com.tencent.qzone.capaoptools");
  }
  
  private int a(Runnable paramRunnable)
  {
    synchronized (this.k)
    {
      do
      {
        this.id += 1;
      } while (this.k.get(this.id) != null);
      int i = this.id;
      this.k.put(i, paramRunnable);
      return i;
    }
  }
  
  private ArrayMap<String, String> a(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramString != null)
    {
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localArrayMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localArrayMap;
  }
  
  public static d a(JSONObject paramJSONObject)
  {
    d locald = new d();
    if (paramJSONObject == null) {
      return locald;
    }
    label202:
    for (;;)
    {
      try
      {
        Object localObject1 = paramJSONObject.optJSONArray("packages");
        String str;
        if (localObject1 != null)
        {
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            str = ((JSONArray)localObject1).getString(i);
            if (str == null) {
              break label202;
            }
            locald.cx.add(str);
            break label202;
          }
        }
        paramJSONObject = paramJSONObject.optJSONArray("policy");
        if (paramJSONObject == null) {
          break;
        }
        int j = paramJSONObject.length();
        int i = 0;
        if (i >= j) {
          break;
        }
        Object localObject2 = paramJSONObject.getJSONObject(i);
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("package");
          str = ((JSONObject)localObject2).optString("schema");
          localObject2 = ((JSONObject)localObject2).optString("action");
          c localc = new c();
          localc.packageName = ((String)localObject1);
          localc.schema = str.toLowerCase();
          localc.action = ((String)localObject2).toLowerCase();
          locald.Ck.add(localc);
        }
        i += 1;
        continue;
        i += 1;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.d("TeleScreen|JefsClass", 1, paramJSONObject, new Object[0]);
        return locald;
      }
    }
  }
  
  private static String a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "getSourceId() called with: context = [" + paramContext + "], intent = [" + paramIntent + "]");
    }
    Intent localIntent = null;
    if (paramIntent.hasExtra("big_brother_source_key"))
    {
      paramIntent = paramIntent.getStringExtra("big_brother_source_key");
      localIntent = paramIntent;
      if (QLog.isColorLevel())
      {
        QLog.d("TeleScreen|JefsClass", 2, "getSourceId() src = [" + paramIntent + "], from intent");
        localIntent = paramIntent;
      }
    }
    paramIntent = localIntent;
    if (localIntent == null)
    {
      paramIntent = localIntent;
      if ((paramContext instanceof Activity))
      {
        paramContext = ((Activity)paramContext).getIntent();
        paramIntent = localIntent;
        if (paramContext != null)
        {
          paramContext = paramContext.getStringExtra("big_brother_source_key");
          paramIntent = paramContext;
          if (QLog.isColorLevel())
          {
            QLog.d("TeleScreen|JefsClass", 2, "getSourceId() src = [" + paramContext + "], from Activity");
            paramIntent = paramContext;
          }
        }
      }
    }
    return paramIntent;
  }
  
  private static String a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "getRefId() called with: context = [" + paramContext + "], intent = [" + paramIntent + "], source = [" + paramString + "]");
    }
    if ("biz_src_ads".equals(paramString))
    {
      if ((paramIntent != null) && (paramIntent.getStringExtra("big_brother_ref_source_key") != null))
      {
        paramContext = paramIntent.getStringExtra("big_brother_ref_source_key");
        paramIntent = paramContext;
        if (QLog.isColorLevel())
        {
          QLog.d("TeleScreen|JefsClass", 2, "getRefId() refId = [" + paramContext + "], from intent");
          paramIntent = paramContext;
        }
        return paramIntent;
      }
      if ((paramContext instanceof Activity))
      {
        paramContext = ((Activity)paramContext).getIntent();
        if (paramContext != null)
        {
          paramString = paramContext.getStringExtra("big_brother_source_key");
          String str = paramContext.getStringExtra("big_brother_ref_source_key");
          if (str != null) {}
          for (paramContext = str;; paramContext = paramString)
          {
            paramIntent = paramContext;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TeleScreen|JefsClass", 2, "getRefId() Activity Source = [" + paramString + "], refId = [" + str + "]");
            return paramContext;
          }
        }
      }
      else
      {
        QLog.i("TeleScreen|JefsClass", 1, "getRefId: context is not Activity " + paramContext);
      }
    }
    return null;
  }
  
  private void a(Context paramContext, Intent paramIntent, CancelableRunnable paramCancelableRunnable, b paramb)
  {
    QLog.i("TeleScreen|JefsClass", 1, "intercept: ");
    if (((Boolean)this.w.get()).booleanValue())
    {
      run(paramCancelableRunnable);
      return;
    }
    String str2 = paramIntent.getPackage();
    String str3 = a(paramContext, paramIntent);
    String str1 = a(paramContext, paramIntent, str3);
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "src " + str3 + ", ref " + str1);
    }
    if (!aciu.abf())
    {
      run(paramCancelableRunnable);
      return;
    }
    if (cv.contains(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TeleScreen|JefsClass", 2, "skip package: " + str2 + ", sourceId: " + str3 + ", refId = " + str1);
      }
      run(paramCancelableRunnable);
      return;
    }
    str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      localObject = paramIntent.getComponent();
      str1 = str2;
      if (localObject != null)
      {
        str2 = ((ComponentName)localObject).getPackageName();
        str1 = str2;
        if (cv.contains(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "skip package: " + str2 + ", sourceId: " + str3);
          }
          run(paramCancelableRunnable);
          return;
        }
      }
    }
    str2 = paramIntent.getAction();
    if (cu.contains(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TeleScreen|JefsClass", 2, "skip action: " + str2);
      }
      run(paramCancelableRunnable);
      return;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && (!((AppRuntime)localObject).isLogin()))
    {
      QLog.i("TeleScreen|JefsClass", 1, "haven't login ");
      run(paramCancelableRunnable);
      return;
    }
    localObject = paramIntent.getData();
    if ((localObject != null) && (((Uri)localObject).getScheme() != null) && (((((Uri)localObject).getScheme().startsWith("tencent")) && ("tauth.qq.com".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().startsWith("qwallet")) && ("open_pay".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().equals("tmast")) && ("sdk_wake".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().equals("https")) && ("ssl.ptlogin2.qq.com".equals(((Uri)localObject).getAuthority())) && ("/jump".equals(((Uri)localObject).getPath())))))
    {
      run(paramCancelableRunnable);
      return;
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    if ((localObject != null) && ((paramContext == null) || (paramContext.size() == 0)))
    {
      QLog.i("TeleScreen|JefsClass", 1, "no matching app: " + paramIntent.getDataString());
      run(paramCancelableRunnable);
      return;
    }
    if ((paramContext != null) && (paramContext.size() == 1))
    {
      localObject = ((ResolveInfo)paramContext.get(0)).activityInfo;
      if (localObject != null)
      {
        if (cv.contains(((ActivityInfo)localObject).packageName))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "skip package: " + ((ActivityInfo)localObject).packageName + ", sourceId: " + str3);
          }
          run(paramCancelableRunnable);
          return;
        }
        if (("com.tencent.android.qqdownloader".equals(((ActivityInfo)localObject).packageName)) && ("com.live.push.PushActivity".equals(((ActivityInfo)localObject).name)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "wake up yyb");
          }
          run(paramCancelableRunnable);
          return;
        }
      }
    }
    paramb.a(str1, paramIntent.getDataString(), str2, paramContext, paramCancelableRunnable);
  }
  
  /* Error */
  private void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, List<ResolveInfo> paramList, CancelableRunnable paramCancelableRunnable, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 280
    //   3: iconst_1
    //   4: ldc_w 523
    //   7: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10: aload_1
    //   11: aload_2
    //   12: invokestatic 386	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   15: astore 12
    //   17: aload_1
    //   18: aload_2
    //   19: aload 12
    //   21: invokestatic 388	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 13
    //   26: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +50 -> 79
    //   32: ldc_w 280
    //   35: iconst_2
    //   36: ldc_w 525
    //   39: bipush 6
    //   41: anewarray 282	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload 12
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 13
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: aload_3
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: aload 4
    //   62: aastore
    //   63: dup
    //   64: iconst_4
    //   65: aload 5
    //   67: aastore
    //   68: dup
    //   69: iconst_5
    //   70: aload 6
    //   72: aastore
    //   73: invokestatic 529	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload 8
    //   81: aload 12
    //   83: invokevirtual 533	com/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable:setId	(Ljava/lang/String;)V
    //   86: invokestatic 538	aeif:a	()Laeif;
    //   89: sipush 416
    //   92: invokevirtual 541	aeif:o	(I)Ljava/lang/Object;
    //   95: checkcast 543	adxg$a
    //   98: astore 11
    //   100: aload 11
    //   102: getfield 546	adxg$a:bRA	Z
    //   105: ifeq +183 -> 288
    //   108: aload 11
    //   110: aload 12
    //   112: aload 5
    //   114: invokevirtual 550	adxg$a:aM	(Ljava/lang/String;Ljava/lang/String;)Z
    //   117: ifne +171 -> 288
    //   120: aload 7
    //   122: invokestatic 554	com/tencent/mobileqq/haoliyou/JefsClass:ap	(Ljava/util/List;)Z
    //   125: ifne +163 -> 288
    //   128: aload 12
    //   130: aload 4
    //   132: invokestatic 557	com/tencent/mobileqq/haoliyou/JefsClass:bb	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: ifne +153 -> 288
    //   138: iconst_1
    //   139: istore 10
    //   141: iload 10
    //   143: ifeq +151 -> 294
    //   146: aload 8
    //   148: astore 11
    //   150: iload 10
    //   152: ifne +565 -> 717
    //   155: ldc_w 280
    //   158: iconst_1
    //   159: ldc_w 559
    //   162: invokestatic 364	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload 8
    //   168: invokespecial 381	com/tencent/mobileqq/haoliyou/JefsClass:run	(Ljava/lang/Runnable;)V
    //   171: iconst_0
    //   172: istore 9
    //   174: aload_2
    //   175: ldc_w 561
    //   178: iconst_1
    //   179: invokevirtual 565	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   182: pop
    //   183: new 567	java/lang/ref/WeakReference
    //   186: dup
    //   187: aload_1
    //   188: invokespecial 570	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   191: astore 8
    //   193: ldc_w 572
    //   196: aload 6
    //   198: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +99 -> 300
    //   204: ldc_w 574
    //   207: aload_2
    //   208: invokevirtual 577	android/content/Intent:getType	()Ljava/lang/String;
    //   211: invokevirtual 580	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   214: ifne +13 -> 227
    //   217: aload_2
    //   218: ldc_w 582
    //   221: invokevirtual 326	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   224: ifeq +76 -> 300
    //   227: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +13 -> 243
    //   233: ldc_w 280
    //   236: iconst_2
    //   237: ldc_w 584
    //   240: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: new 586	com/tencent/mobileqq/haoliyou/JefsClass$7
    //   246: dup
    //   247: aload_0
    //   248: aload_2
    //   249: aload 11
    //   251: aload 8
    //   253: aload 12
    //   255: aload 13
    //   257: invokespecial 589	com/tencent/mobileqq/haoliyou/JefsClass$7:<init>	(Lcom/tencent/mobileqq/haoliyou/JefsClass;Landroid/content/Intent;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;)V
    //   260: bipush 64
    //   262: aconst_null
    //   263: iconst_1
    //   264: invokestatic 595	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   267: return
    //   268: astore_1
    //   269: ldc_w 280
    //   272: iconst_1
    //   273: aload_1
    //   274: iconst_0
    //   275: anewarray 282	java/lang/Object
    //   278: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   281: aload_0
    //   282: aload 8
    //   284: invokespecial 381	com/tencent/mobileqq/haoliyou/JefsClass:run	(Ljava/lang/Runnable;)V
    //   287: return
    //   288: iconst_0
    //   289: istore 10
    //   291: goto -150 -> 141
    //   294: aconst_null
    //   295: astore 11
    //   297: goto -147 -> 150
    //   300: aload 5
    //   302: ifnull +99 -> 401
    //   305: aload 5
    //   307: ldc_w 599
    //   310: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   313: ifne +14 -> 327
    //   316: aload 5
    //   318: ldc_w 601
    //   321: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   324: ifeq +77 -> 401
    //   327: ldc_w 574
    //   330: aload_2
    //   331: ldc_w 603
    //   334: invokevirtual 329	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   337: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   340: ifeq +38 -> 378
    //   343: aload_0
    //   344: aload_1
    //   345: aload 12
    //   347: aload 13
    //   349: aconst_null
    //   350: aload 5
    //   352: aload 11
    //   354: invokespecial 606	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   357: return
    //   358: astore_1
    //   359: ldc_w 280
    //   362: iconst_1
    //   363: aload_1
    //   364: iconst_0
    //   365: anewarray 282	java/lang/Object
    //   368: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   371: aload_0
    //   372: aload 11
    //   374: invokespecial 381	com/tencent/mobileqq/haoliyou/JefsClass:run	(Ljava/lang/Runnable;)V
    //   377: return
    //   378: aload_0
    //   379: aload_1
    //   380: aload 12
    //   382: aload 13
    //   384: aload 4
    //   386: aload_3
    //   387: aload 5
    //   389: aload 6
    //   391: aload 7
    //   393: aload 11
    //   395: iload 9
    //   397: invokespecial 609	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   400: return
    //   401: aload 5
    //   403: ifnull +98 -> 501
    //   406: aload 5
    //   408: ldc_w 611
    //   411: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   414: ifeq +87 -> 501
    //   417: aload_0
    //   418: aload 5
    //   420: ldc_w 611
    //   423: invokevirtual 612	java/lang/String:length	()I
    //   426: invokevirtual 615	java/lang/String:substring	(I)Ljava/lang/String;
    //   429: invokespecial 617	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/String;)Landroid/support/v4/util/ArrayMap;
    //   432: astore_2
    //   433: ldc_w 574
    //   436: invokestatic 622	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   439: aload_2
    //   440: ldc_w 624
    //   443: invokevirtual 627	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   446: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   449: ifeq +29 -> 478
    //   452: aload_0
    //   453: aload_1
    //   454: aload 12
    //   456: aload 13
    //   458: aconst_null
    //   459: aload_2
    //   460: ldc_w 629
    //   463: invokevirtual 627	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   466: checkcast 207	java/lang/String
    //   469: invokestatic 634	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   472: aload 11
    //   474: invokespecial 606	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   477: return
    //   478: aload_0
    //   479: aload_1
    //   480: aload 12
    //   482: aload 13
    //   484: aload 4
    //   486: aload_3
    //   487: aload 5
    //   489: aload 6
    //   491: aload 7
    //   493: aload 11
    //   495: iload 9
    //   497: invokespecial 609	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   500: return
    //   501: aload 5
    //   503: ifnull +132 -> 635
    //   506: aload 5
    //   508: ldc_w 636
    //   511: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   514: ifeq +121 -> 635
    //   517: aload 5
    //   519: ldc_w 638
    //   522: invokevirtual 642	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   525: istore 10
    //   527: iload 10
    //   529: iflt +83 -> 612
    //   532: aload_0
    //   533: aload 5
    //   535: iload 10
    //   537: invokevirtual 615	java/lang/String:substring	(I)Ljava/lang/String;
    //   540: invokespecial 617	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/String;)Landroid/support/v4/util/ArrayMap;
    //   543: astore_2
    //   544: ldc_w 574
    //   547: invokestatic 622	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   550: aload_2
    //   551: ldc_w 624
    //   554: invokevirtual 627	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   557: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   560: ifeq +29 -> 589
    //   563: aload_0
    //   564: aload_1
    //   565: aload 12
    //   567: aload 13
    //   569: aconst_null
    //   570: aload_2
    //   571: ldc_w 629
    //   574: invokevirtual 627	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   577: checkcast 207	java/lang/String
    //   580: invokestatic 634	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   583: aload 11
    //   585: invokespecial 606	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   588: return
    //   589: aload_0
    //   590: aload_1
    //   591: aload 12
    //   593: aload 13
    //   595: aload 4
    //   597: aload_3
    //   598: aload 5
    //   600: aload 6
    //   602: aload 7
    //   604: aload 11
    //   606: iload 9
    //   608: invokespecial 609	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   611: return
    //   612: aload_0
    //   613: aload_1
    //   614: aload 12
    //   616: aload 13
    //   618: aload 4
    //   620: aload_3
    //   621: aload 5
    //   623: aload 6
    //   625: aload 7
    //   627: aload 11
    //   629: iload 9
    //   631: invokespecial 609	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   634: return
    //   635: aload 5
    //   637: ifnull +57 -> 694
    //   640: aload 5
    //   642: ldc_w 644
    //   645: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   648: ifeq +46 -> 694
    //   651: aload_2
    //   652: ldc_w 645
    //   655: invokevirtual 329	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   658: astore_3
    //   659: aconst_null
    //   660: astore_2
    //   661: aload_3
    //   662: ifnonnull +18 -> 680
    //   665: aload 5
    //   667: invokestatic 649	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   670: ldc_w 651
    //   673: invokevirtual 654	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   676: invokestatic 634	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   679: astore_2
    //   680: aload_0
    //   681: aload_1
    //   682: aload 12
    //   684: aload 13
    //   686: aload_3
    //   687: aload_2
    //   688: aload 11
    //   690: invokespecial 606	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   693: return
    //   694: aload_0
    //   695: aload_1
    //   696: aload 12
    //   698: aload 13
    //   700: aload 4
    //   702: aload_3
    //   703: aload 5
    //   705: aload 6
    //   707: aload 7
    //   709: aload 11
    //   711: iload 9
    //   713: invokespecial 609	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   716: return
    //   717: goto -543 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	this	JefsClass
    //   0	720	1	paramContext	Context
    //   0	720	2	paramIntent	Intent
    //   0	720	3	paramString1	String
    //   0	720	4	paramString2	String
    //   0	720	5	paramString3	String
    //   0	720	6	paramString4	String
    //   0	720	7	paramList	List<ResolveInfo>
    //   0	720	8	paramCancelableRunnable	CancelableRunnable
    //   0	720	9	paramInt	int
    //   139	397	10	i	int
    //   98	612	11	localObject	Object
    //   15	682	12	str1	String
    //   24	675	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   86	100	268	java/lang/Throwable
    //   183	227	358	java/lang/Throwable
    //   227	243	358	java/lang/Throwable
    //   243	267	358	java/lang/Throwable
    //   305	327	358	java/lang/Throwable
    //   327	357	358	java/lang/Throwable
    //   378	400	358	java/lang/Throwable
    //   406	477	358	java/lang/Throwable
    //   478	500	358	java/lang/Throwable
    //   506	527	358	java/lang/Throwable
    //   532	588	358	java/lang/Throwable
    //   589	611	358	java/lang/Throwable
    //   612	634	358	java/lang/Throwable
    //   640	659	358	java/lang/Throwable
    //   665	680	358	java/lang/Throwable
    //   680	693	358	java/lang/Throwable
    //   694	716	358	java/lang/Throwable
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Runnable paramRunnable)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    String str1;
    if (TextUtils.isEmpty(paramString1))
    {
      if (!(paramContext instanceof BaseActivity)) {
        break label103;
      }
      localQQAppInterface = ((BaseActivity)paramContext).app;
      str2 = paramContext.getClass().getName();
      if (paramString3 == null) {
        break label109;
      }
      str1 = paramString3;
    }
    for (;;)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", str2, str1);
      ahxb.a(paramContext, paramString1, paramString3, paramString4, paramString2, new ahwg(this, paramRunnable, new WeakReference(paramContext), paramString1));
      return;
      label103:
      localQQAppInterface = null;
      break;
      label109:
      if (paramString4 == null) {
        str1 = "";
      } else {
        str1 = paramString4;
      }
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<ResolveInfo> paramList, CancelableRunnable paramCancelableRunnable, int paramInt)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    String str1;
    if (TextUtils.isEmpty(paramString1))
    {
      if (!(paramContext instanceof BaseActivity)) {
        break label111;
      }
      localQQAppInterface = ((BaseActivity)paramContext).app;
      str2 = paramContext.getClass().getName();
      if (paramString3 == null) {
        break label117;
      }
      str1 = paramString3;
    }
    for (;;)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", str2, str1);
      ahxb.a(paramContext, paramString1, paramString4, paramString3, paramString5, paramString6, paramList, paramString2, new ahwh(this, new WeakReference(paramContext), paramCancelableRunnable, paramInt, paramString1));
      return;
      label111:
      localQQAppInterface = null;
      break;
      label117:
      if (paramString5 != null) {
        str1 = paramString5;
      } else if (paramString6 != null) {
        str1 = paramString6;
      } else if (paramString4 == null) {
        str1 = "";
      } else {
        str1 = paramString4;
      }
    }
  }
  
  private static boolean ap(List<ResolveInfo> paramList)
  {
    if (paramList != null)
    {
      String str = BaseApplicationImpl.sApplication.getPackageName();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramList.next();
        if ((localResolveInfo.activityInfo != null) && (str.equals(localResolveInfo.activityInfo.packageName))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean bb(String paramString1, String paramString2)
  {
    return ("biz_src_jc_qzone".equals(paramString1)) && ("com.qzone".equals(paramString2));
  }
  
  public static JefsClass getInstance()
  {
    return jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass;
  }
  
  private void il(int paramInt1, int paramInt2)
  {
    synchronized (this.k)
    {
      Runnable localRunnable = (Runnable)this.k.get(paramInt1);
      if (localRunnable == null) {
        QLog.w("TeleScreen|JefsClass", 1, "no todo");
      }
      im(paramInt1, 0);
      run(localRunnable);
      adxf.a().hE(paramInt2, 2);
      return;
    }
  }
  
  private void im(int paramInt1, int paramInt2)
  {
    for (int i = 1;; i = 0) {
      synchronized (this.k)
      {
        if (this.k.indexOfKey(paramInt1) >= 0)
        {
          this.k.delete(paramInt1);
          if (i != 0)
          {
            paramInt1 = this.k.size();
            if (paramInt1 > 0) {}
          }
          try
          {
            BaseApplicationImpl.context.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$e);
            adxf.a().hE(paramInt2, -1);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("TeleScreen|JefsClass", 1, localThrowable, new Object[0]);
            }
          }
        }
      }
    }
  }
  
  private void run(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.w.set(Boolean.valueOf(true));
    paramRunnable.run();
    this.w.set(Boolean.valueOf(false));
  }
  
  public void E(int paramInt1, String paramString, int paramInt2)
  {
    if ("com.tencent.tim".equals(paramString))
    {
      il(paramInt1, paramInt2);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.telescreen.action_run");
    localIntent.putExtra("key_id", paramInt1);
    localIntent.putExtra("key_process_id", paramString);
    localIntent.putExtra("key_callback_id", paramInt2);
    BaseApplicationImpl.context.sendBroadcast(localIntent);
  }
  
  public void F(int paramInt1, String paramString, int paramInt2)
  {
    if ("com.tencent.tim".equals(paramString))
    {
      im(paramInt1, paramInt2);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.telescreen.action_remove");
    localIntent.putExtra("key_id", paramInt1);
    localIntent.putExtra("key_process_id", paramString);
    localIntent.putExtra("key_callback_id", paramInt2);
    BaseApplicationImpl.context.sendBroadcast(localIntent);
  }
  
  public a a(Context paramContext, Intent paramIntent, String paramString, WeakOuterRefRunnable paramWeakOuterRefRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "checkAndDoAsyn() called with: context = [" + paramContext + "], intent = [" + paramIntent + "], url = [" + paramString + "], todo = [" + paramWeakOuterRefRunnable + "]");
    }
    int i = paramIntent.getIntExtra("key_callback_id", 0);
    paramWeakOuterRefRunnable.LD(i);
    paramWeakOuterRefRunnable = new CancelableRunnable(paramWeakOuterRefRunnable);
    a(paramContext, paramIntent, paramWeakOuterRefRunnable, new ahwf(this, paramContext, paramIntent, paramString, i));
    return paramWeakOuterRefRunnable.a();
  }
  
  public a a(Context paramContext, Intent paramIntent, String paramString, Runnable paramRunnable)
  {
    return a(paramContext, paramIntent, paramString, new WeakOuterRefRunnable(paramRunnable, true));
  }
  
  public void a(Activity paramActivity, Intent paramIntent, Runnable paramRunnable)
  {
    getInstance().b(paramActivity, paramIntent, paramRunnable);
  }
  
  public void b(Context paramContext, Intent paramIntent, Runnable paramRunnable)
  {
    a(paramContext, paramIntent, null, new WeakOuterRefRunnable(paramRunnable, true));
  }
  
  public void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      this.enable = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$d = a(paramJSONObject);
      return;
    }
    finally
    {
      paramJSONObject = finally;
      throw paramJSONObject;
    }
  }
  
  public void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    getInstance().a(paramActivity, paramIntent, new JefsClass.2(this, paramActivity, paramIntent, paramInt, paramBundle));
  }
  
  public static class CancelableRunnable
    implements Runnable
  {
    WeakOuterRefRunnable a;
    boolean canceled = false;
    
    CancelableRunnable(WeakOuterRefRunnable paramWeakOuterRefRunnable)
    {
      this.a = paramWeakOuterRefRunnable;
    }
    
    public void LC(int paramInt)
    {
      this.a.LC(paramInt);
    }
    
    public JefsClass.a a()
    {
      return new JefsClass.a(this);
    }
    
    public void run()
    {
      if (!this.canceled) {
        JefsClass.a(JefsClass.getInstance(), this.a);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("TeleScreen|JefsClass", 2, "canceled");
    }
    
    public void setId(String paramString)
    {
      this.a.setId(paramString);
    }
  }
  
  public static class a
  {
    JefsClass.CancelableRunnable b;
    
    a(JefsClass.CancelableRunnable paramCancelableRunnable)
    {
      this.b = paramCancelableRunnable;
    }
    
    public void dqC()
    {
      this.b.canceled = true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, List<ResolveInfo> paramList, JefsClass.CancelableRunnable paramCancelableRunnable);
  }
  
  public static class c
  {
    public String action;
    public String packageName;
    public String schema;
  }
  
  public static class d
  {
    public List<JefsClass.c> Ck = new ArrayList();
    public Set<String> cx = new TreeSet();
  }
  
  public class e
    extends BroadcastReceiver
  {
    private e() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!BaseApplicationImpl.processName.equals(paramIntent.getStringExtra("key_process_id"))) {
        if (QLog.isColorLevel()) {
          QLog.d("TeleScreen|JefsClass", 2, "is not current process");
        }
      }
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TeleScreen|JefsClass", 2, "start");
        }
        if ("com.tencent.mobileqq.telescreen.action_run".equals(paramIntent.getAction()))
        {
          JefsClass.a(JefsClass.this, paramIntent.getIntExtra("key_id", 0), paramIntent.getIntExtra("key_callback_id", 0));
          return;
        }
      } while (!"com.tencent.mobileqq.telescreen.action_remove".equals(paramIntent.getAction()));
      JefsClass.b(JefsClass.this, paramIntent.getIntExtra("key_id", 0), paramIntent.getIntExtra("key_callback_id", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass
 * JD-Core Version:    0.7.0.1
 */