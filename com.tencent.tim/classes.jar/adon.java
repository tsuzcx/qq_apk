import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.2;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.5;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.6;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.7;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adon
  extends adnq.b
{
  private adon.a jdField_a_of_type_Adon$a;
  private arut jdField_a_of_type_Arut;
  private aryx b;
  private ArrayList<Long> uC;
  
  adon(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    QLog.i("ArkApp.downloadyyb.module", 1, "init");
    arvv.a();
    this.uC = new ArrayList();
    this.b = new adop(this);
  }
  
  private void a(int paramInt, JSONArray paramJSONArray, long paramLong)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject1;
      Object localObject2;
      try
      {
        int j = paramJSONArray.length();
        localArrayList = new ArrayList();
        i = 0;
        if (i < j)
        {
          localObject1 = paramJSONArray.getJSONObject(i);
          localObject2 = new DownloadInfo();
          ((DownloadInfo)localObject2).urlStr = ((JSONObject)localObject1).optString("url");
          ((DownloadInfo)localObject2).packageName = ((JSONObject)localObject1).optString("packageName");
          ((DownloadInfo)localObject2).versionCode = ((JSONObject)localObject1).optInt("versionCode");
          ((DownloadInfo)localObject2).appId = ((JSONObject)localObject1).optString("appId");
          ((DownloadInfo)localObject2).emb();
          localArrayList.add(localObject2);
          i += 1;
          continue;
        }
        QLog.d("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB action is " + paramInt);
        switch (paramInt)
        {
        default: 
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        int i;
        QLog.e("ArkApp.downloadyyb.module", 1, "[innerQuery] e=", paramJSONArray);
        return;
      }
      try
      {
        paramJSONArray = new JSONArray();
        i = localArrayList.size();
        paramInt = 0;
        if (paramInt < i)
        {
          localObject1 = (DownloadInfo)localArrayList.get(paramInt);
          localObject1 = arvv.a().e(((DownloadInfo)localObject1).urlStr);
          if (localObject1 == null) {
            break label419;
          }
          paramJSONArray.put(a((DownloadInfo)localObject1));
          break label419;
        }
        paramJSONArray = paramJSONArray.toString();
        ArkAppCenter.a().post(this.mAppName, new ArkAppYYBDownloadModule.5(this, paramLong, paramJSONArray));
        return;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB : " + paramJSONArray);
        return;
      }
      if (localArrayList.size() > 0)
      {
        paramJSONArray = BaseActivity.sTopActivity;
        localObject1 = new JSONArray();
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          localObject2 = (DownloadInfo)localArrayList.get(paramInt);
          boolean bool = aqiz.isAppInstalled(paramJSONArray, ((DownloadInfo)localObject2).packageName);
          localObject2 = a((DownloadInfo)localObject2);
          ((JSONObject)localObject2).put("isInstall", bool);
          ((JSONArray)localObject1).put(localObject2);
          paramInt += 1;
        }
        paramJSONArray = ((JSONArray)localObject1).toString();
        ArkAppCenter.a().post(this.mAppName, new ArkAppYYBDownloadModule.6(this, paramLong, paramJSONArray));
        return;
        label419:
        paramInt += 1;
      }
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1 = arwo.cs(localBaseActivity);
    boolean bool2 = arwo.cr(localBaseActivity);
    int i = j;
    if (paramDownloadInfo != null) {
      if (paramDownloadInfo.getState() != 1) {
        break label80;
      }
    }
    label80:
    for (i = j; (paramBoolean) && (bool1) && (!bool2) && (i != 0) && (paramInt == 2) && (localBaseActivity != null); i = 0)
    {
      a(BaseActivity.sTopActivity, paramDownloadInfo);
      return;
    }
    d(paramDownloadInfo, paramInt);
  }
  
  /* Error */
  private void a(String paramString, ark.VariantWrapper paramVariantWrapper)
  {
    // Byte code:
    //   0: new 72	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 225	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 19
    //   10: getstatic 182	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   13: aload 19
    //   15: invokestatic 231	com/tencent/open/appcommon/js/DownloadInterface:parseSourceType	(Landroid/app/Activity;Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 21
    //   20: ldc 233
    //   22: aload 21
    //   24: invokevirtual 238	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +20 -> 47
    //   30: ldc 240
    //   32: ldc 242
    //   34: ldc 244
    //   36: aload 19
    //   38: getstatic 249	aryv:PARAM_EXTRA_INFO	Ljava/lang/String;
    //   41: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 255	arxt:X	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +33 -> 83
    //   53: ldc 20
    //   55: iconst_1
    //   56: new 108	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 261
    //   66: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 19
    //   71: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   74: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload 19
    //   85: getstatic 265	aryv:PARAM_URL	Ljava/lang/String;
    //   88: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 22
    //   93: aload 22
    //   95: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifeq +19 -> 117
    //   101: ldc 20
    //   103: iconst_1
    //   104: ldc_w 273
    //   107: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_2
    //   111: iconst_m1
    //   112: invokevirtual 279	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   115: pop
    //   116: return
    //   117: aload 19
    //   119: getstatic 282	aryv:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   122: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 23
    //   127: aload 19
    //   129: getstatic 285	aryv:PARAM_ACTIONCODE	Ljava/lang/String;
    //   132: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   135: istore_3
    //   136: aload 19
    //   138: getstatic 288	aryv:PARAM_VIA	Ljava/lang/String;
    //   141: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 24
    //   146: aload 19
    //   148: getstatic 291	aryv:PARAM_APPNAME	Ljava/lang/String;
    //   151: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 14
    //   156: aload 19
    //   158: getstatic 294	aryv:PARAM_ICON_URL	Ljava/lang/String;
    //   161: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore 15
    //   166: aload 19
    //   168: ldc_w 296
    //   171: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   174: istore 4
    //   176: aload 19
    //   178: getstatic 249	aryv:PARAM_EXTRA_INFO	Ljava/lang/String;
    //   181: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   184: astore 20
    //   186: aload 19
    //   188: getstatic 299	aryv:PARAM_IS_APK	Ljava/lang/String;
    //   191: iconst_1
    //   192: invokevirtual 303	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   195: istore 6
    //   197: aload 19
    //   199: ldc_w 305
    //   202: iconst_0
    //   203: invokevirtual 303	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   206: istore 7
    //   208: aload 19
    //   210: ldc_w 307
    //   213: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   216: invokestatic 310	adon:changeIntToBoolean	(I)Z
    //   219: istore 9
    //   221: aload 19
    //   223: getstatic 313	aryv:PARAM_BLOCK_NOTIFY	Ljava/lang/String;
    //   226: invokevirtual 316	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   229: istore 10
    //   231: aload 19
    //   233: getstatic 319	aryv:cDD	Ljava/lang/String;
    //   236: iconst_0
    //   237: invokevirtual 322	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   240: istore 5
    //   242: aload 19
    //   244: getstatic 325	aryv:PARAM_IS_AUTOINSTALL_BY_SDK	Ljava/lang/String;
    //   247: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   250: invokestatic 310	adon:changeIntToBoolean	(I)Z
    //   253: istore 11
    //   255: aload 19
    //   257: ldc 95
    //   259: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 16
    //   264: aload 19
    //   266: ldc_w 327
    //   269: ldc_w 329
    //   272: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: astore 17
    //   277: aload 19
    //   279: getstatic 335	aryv:cDE	Ljava/lang/String;
    //   282: ldc_w 329
    //   285: invokevirtual 332	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 18
    //   290: getstatic 182	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   293: invokestatic 339	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   296: ifnonnull +570 -> 866
    //   299: ldc_w 329
    //   302: astore 12
    //   304: aload 19
    //   306: getstatic 342	aryv:PARAM_SHOW_NETWORK_DIALOG	Ljava/lang/String;
    //   309: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   312: invokestatic 310	adon:changeIntToBoolean	(I)Z
    //   315: istore 8
    //   317: aload 19
    //   319: ldc_w 344
    //   322: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   325: astore 25
    //   327: new 108	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   334: aload 19
    //   336: ldc_w 346
    //   339: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   342: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: ldc_w 329
    //   348: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: astore 26
    //   356: new 108	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   363: aload 19
    //   365: ldc_w 348
    //   368: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   371: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: ldc_w 329
    //   377: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: astore 27
    //   385: new 108	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   392: aload 19
    //   394: ldc_w 350
    //   397: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   400: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: ldc_w 329
    //   406: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: astore 28
    //   414: new 108	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   421: aload 19
    //   423: ldc_w 352
    //   426: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   429: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 329
    //   435: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: astore 29
    //   443: aload_0
    //   444: getfield 354	adon:jdField_a_of_type_Arut	Larut;
    //   447: ifnonnull +430 -> 877
    //   450: aload_0
    //   451: new 356	arut
    //   454: dup
    //   455: aload 16
    //   457: aload 24
    //   459: iload_3
    //   460: invokespecial 359	arut:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   463: putfield 354	adon:jdField_a_of_type_Arut	Larut;
    //   466: invokestatic 33	arvv:a	()Larvv;
    //   469: aload 22
    //   471: invokevirtual 137	arvv:e	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   474: astore 13
    //   476: aload 13
    //   478: astore_1
    //   479: aload 13
    //   481: ifnonnull +29 -> 510
    //   484: new 67	com/tencent/open/downloadnew/DownloadInfo
    //   487: dup
    //   488: aload 16
    //   490: aload 22
    //   492: invokevirtual 362	java/lang/String:trim	()Ljava/lang/String;
    //   495: aload 23
    //   497: aload 14
    //   499: aload 24
    //   501: aconst_null
    //   502: aload 21
    //   504: iload 6
    //   506: invokespecial 365	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Z)V
    //   509: astore_1
    //   510: aload_1
    //   511: iload_3
    //   512: putfield 368	com/tencent/open/downloadnew/DownloadInfo:ekZ	I
    //   515: iload 6
    //   517: ifeq +392 -> 909
    //   520: aload_1
    //   521: iload 9
    //   523: putfield 371	com/tencent/open/downloadnew/DownloadInfo:isAutoInstall	Z
    //   526: aload_1
    //   527: iload 10
    //   529: putfield 374	com/tencent/open/downloadnew/DownloadInfo:ddi	Z
    //   532: aload_1
    //   533: iload 5
    //   535: putfield 377	com/tencent/open/downloadnew/DownloadInfo:from	I
    //   538: aload_1
    //   539: aload 15
    //   541: putfield 380	com/tencent/open/downloadnew/DownloadInfo:iconUrl	Ljava/lang/String;
    //   544: aload_1
    //   545: iload 4
    //   547: putfield 383	com/tencent/open/downloadnew/DownloadInfo:ell	I
    //   550: aload_1
    //   551: aload 20
    //   553: putfield 386	com/tencent/open/downloadnew/DownloadInfo:extraData	Ljava/lang/String;
    //   556: aload_1
    //   557: iload 11
    //   559: putfield 389	com/tencent/open/downloadnew/DownloadInfo:isAutoInstallBySDK	Z
    //   562: aload_1
    //   563: iconst_0
    //   564: putfield 392	com/tencent/open/downloadnew/DownloadInfo:elk	I
    //   567: aload_1
    //   568: aload 19
    //   570: getstatic 395	aryv:PARAM_TASK_VERSION	Ljava/lang/String;
    //   573: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   576: putfield 93	com/tencent/open/downloadnew/DownloadInfo:versionCode	I
    //   579: aload_1
    //   580: aload 19
    //   582: getstatic 398	aryv:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   585: invokevirtual 402	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   588: putfield 406	com/tencent/open/downloadnew/DownloadInfo:fileSize	J
    //   591: aload_1
    //   592: aload 25
    //   594: putfield 408	com/tencent/open/downloadnew/DownloadInfo:recommendId	Ljava/lang/String;
    //   597: aload_1
    //   598: aload 26
    //   600: putfield 411	com/tencent/open/downloadnew/DownloadInfo:cCM	Ljava/lang/String;
    //   603: aload_1
    //   604: aload 17
    //   606: putfield 414	com/tencent/open/downloadnew/DownloadInfo:cCL	Ljava/lang/String;
    //   609: aload_1
    //   610: aload 18
    //   612: putfield 417	com/tencent/open/downloadnew/DownloadInfo:channelId	Ljava/lang/String;
    //   615: aload_1
    //   616: aload 27
    //   618: putfield 419	com/tencent/open/downloadnew/DownloadInfo:pageId	Ljava/lang/String;
    //   621: aload_1
    //   622: aload 28
    //   624: putfield 422	com/tencent/open/downloadnew/DownloadInfo:kx	Ljava/lang/String;
    //   627: aload_1
    //   628: aload 29
    //   630: putfield 425	com/tencent/open/downloadnew/DownloadInfo:cDH	Ljava/lang/String;
    //   633: aload_1
    //   634: iload 7
    //   636: putfield 428	com/tencent/open/downloadnew/DownloadInfo:ddx	Z
    //   639: aload_1
    //   640: ldc_w 430
    //   643: aload 12
    //   645: invokevirtual 434	com/tencent/open/downloadnew/DownloadInfo:ce	(Ljava/lang/String;Ljava/lang/String;)Z
    //   648: pop
    //   649: aload_1
    //   650: invokevirtual 100	com/tencent/open/downloadnew/DownloadInfo:emb	()V
    //   653: iconst_1
    //   654: istore 7
    //   656: sipush 380
    //   659: invokestatic 439	aeiy:b	(I)Laeix;
    //   662: invokevirtual 444	aeix:a	()Laeix$e;
    //   665: astore 12
    //   667: iload 7
    //   669: istore 6
    //   671: aload 12
    //   673: ifnull +56 -> 729
    //   676: iload 7
    //   678: istore 6
    //   680: aload 12
    //   682: invokevirtual 449	aeix$e:a	()Laeje$h;
    //   685: ifnull +44 -> 729
    //   688: aload 12
    //   690: invokevirtual 449	aeix$e:a	()Laeje$h;
    //   693: astore 12
    //   695: iload 7
    //   697: istore 6
    //   699: aload 12
    //   701: getfield 454	aeje$h:vD	Ljava/util/ArrayList;
    //   704: ifnull +25 -> 729
    //   707: iload 7
    //   709: istore 6
    //   711: aload 12
    //   713: getfield 454	aeje$h:vD	Ljava/util/ArrayList;
    //   716: aload_0
    //   717: getfield 153	adon:mAppName	Ljava/lang/String;
    //   720: invokevirtual 457	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   723: ifeq +6 -> 729
    //   726: iconst_0
    //   727: istore 6
    //   729: ldc 20
    //   731: iconst_1
    //   732: bipush 10
    //   734: anewarray 459	java/lang/Object
    //   737: dup
    //   738: iconst_0
    //   739: ldc_w 461
    //   742: aastore
    //   743: dup
    //   744: iconst_1
    //   745: aload_0
    //   746: getfield 153	adon:mAppName	Ljava/lang/String;
    //   749: aastore
    //   750: dup
    //   751: iconst_2
    //   752: ldc_w 463
    //   755: aastore
    //   756: dup
    //   757: iconst_3
    //   758: iload 6
    //   760: invokestatic 469	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   763: aastore
    //   764: dup
    //   765: iconst_4
    //   766: ldc_w 471
    //   769: aastore
    //   770: dup
    //   771: iconst_5
    //   772: aload 16
    //   774: aastore
    //   775: dup
    //   776: bipush 6
    //   778: ldc_w 473
    //   781: aastore
    //   782: dup
    //   783: bipush 7
    //   785: aload 14
    //   787: aastore
    //   788: dup
    //   789: bipush 8
    //   791: ldc_w 475
    //   794: aastore
    //   795: dup
    //   796: bipush 9
    //   798: aload 15
    //   800: aastore
    //   801: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   804: iload 6
    //   806: ifeq +121 -> 927
    //   809: invokestatic 483	adso:a	()Ladso;
    //   812: aload_0
    //   813: getfield 153	adon:mAppName	Ljava/lang/String;
    //   816: aload 16
    //   818: aload 14
    //   820: aload 15
    //   822: new 485	adoq
    //   825: dup
    //   826: aload_0
    //   827: aload 16
    //   829: aload 14
    //   831: aload_1
    //   832: iload 8
    //   834: iload_3
    //   835: invokespecial 488	adoq:<init>	(Ladon;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/open/downloadnew/DownloadInfo;ZI)V
    //   838: invokevirtual 491	adso:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   841: aload_2
    //   842: iconst_1
    //   843: invokevirtual 279	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   846: pop
    //   847: return
    //   848: astore_1
    //   849: ldc 20
    //   851: iconst_1
    //   852: ldc_w 493
    //   855: aload_1
    //   856: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   859: aload_2
    //   860: iconst_m1
    //   861: invokevirtual 279	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   864: pop
    //   865: return
    //   866: getstatic 182	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   869: invokestatic 339	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   872: astore 12
    //   874: goto -570 -> 304
    //   877: aload_0
    //   878: getfield 354	adon:jdField_a_of_type_Arut	Larut;
    //   881: aload 16
    //   883: aload 24
    //   885: iload_3
    //   886: invokevirtual 497	arut:j	(Ljava/lang/String;Ljava/lang/String;I)Z
    //   889: ifeq -423 -> 466
    //   892: ldc 20
    //   894: iconst_1
    //   895: ldc_w 499
    //   898: invokestatic 28	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   901: aload_2
    //   902: bipush 253
    //   904: invokevirtual 279	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   907: pop
    //   908: return
    //   909: aload_1
    //   910: iconst_0
    //   911: putfield 371	com/tencent/open/downloadnew/DownloadInfo:isAutoInstall	Z
    //   914: aload_1
    //   915: iconst_1
    //   916: putfield 374	com/tencent/open/downloadnew/DownloadInfo:ddi	Z
    //   919: aload_1
    //   920: iconst_2
    //   921: putfield 502	com/tencent/open/downloadnew/DownloadInfo:updateType	I
    //   924: goto -392 -> 532
    //   927: aload_0
    //   928: aload_1
    //   929: iload 8
    //   931: iload_3
    //   932: invokespecial 204	adon:a	(Lcom/tencent/open/downloadnew/DownloadInfo;ZI)V
    //   935: goto -94 -> 841
    //   938: astore 13
    //   940: goto -349 -> 591
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	943	0	this	adon
    //   0	943	1	paramString	String
    //   0	943	2	paramVariantWrapper	ark.VariantWrapper
    //   135	797	3	i	int
    //   174	372	4	j	int
    //   240	294	5	k	int
    //   195	610	6	bool1	boolean
    //   206	502	7	bool2	boolean
    //   315	615	8	bool3	boolean
    //   219	303	9	bool4	boolean
    //   229	299	10	bool5	boolean
    //   253	305	11	bool6	boolean
    //   302	571	12	localObject	Object
    //   474	6	13	localDownloadInfo	DownloadInfo
    //   938	1	13	localNumberFormatException	java.lang.NumberFormatException
    //   154	676	14	str1	String
    //   164	657	15	str2	String
    //   262	620	16	str3	String
    //   275	330	17	str4	String
    //   288	323	18	str5	String
    //   8	573	19	localJSONObject	JSONObject
    //   184	368	20	str6	String
    //   18	485	21	str7	String
    //   91	400	22	str8	String
    //   125	371	23	str9	String
    //   144	740	24	str10	String
    //   325	268	25	str11	String
    //   354	245	26	str12	String
    //   383	234	27	str13	String
    //   412	211	28	str14	String
    //   441	188	29	str15	String
    // Exception table:
    //   from	to	target	type
    //   0	47	848	java/lang/Exception
    //   47	83	848	java/lang/Exception
    //   83	116	848	java/lang/Exception
    //   117	299	848	java/lang/Exception
    //   304	466	848	java/lang/Exception
    //   466	476	848	java/lang/Exception
    //   484	510	848	java/lang/Exception
    //   510	515	848	java/lang/Exception
    //   520	532	848	java/lang/Exception
    //   532	567	848	java/lang/Exception
    //   567	591	848	java/lang/Exception
    //   591	653	848	java/lang/Exception
    //   656	667	848	java/lang/Exception
    //   680	695	848	java/lang/Exception
    //   699	707	848	java/lang/Exception
    //   711	726	848	java/lang/Exception
    //   729	804	848	java/lang/Exception
    //   809	841	848	java/lang/Exception
    //   841	847	848	java/lang/Exception
    //   866	874	848	java/lang/Exception
    //   877	908	848	java/lang/Exception
    //   909	924	848	java/lang/Exception
    //   927	935	848	java/lang/Exception
    //   567	591	938	java/lang/NumberFormatException
  }
  
  private static boolean changeIntToBoolean(int paramInt)
  {
    return paramInt != 0;
  }
  
  private void d(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (paramDownloadInfo == null) {}
    try
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] is null ");
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "[doDownloadAction] Exception", paramDownloadInfo);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] object " + paramDownloadInfo.toString() + "action =" + paramInt);
      break label159;
      arvv.a().b(paramDownloadInfo);
      return;
      arvv.a().b(paramDownloadInfo);
      return;
      arvv.a().fx(paramDownloadInfo.urlStr);
      return;
      arvv.a().L(paramDownloadInfo.urlStr, true);
      return;
      if (!paramDownloadInfo.ddw)
      {
        QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] not apk");
        return;
      }
      arxt.X("305", paramDownloadInfo.via, paramDownloadInfo.appId, paramDownloadInfo.extraData);
      arvv.a().d(paramDownloadInfo);
      return;
    }
    label159:
    switch (paramInt)
    {
    }
  }
  
  private boolean kZ(String paramString)
  {
    try
    {
      ArkAppCenter.a().postToMainThread(new ArkAppYYBDownloadModule.2(this, paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, " showToast error::", paramString);
    }
    return false;
  }
  
  public void Destruct()
  {
    if ((this.uC != null) && (this.uC.size() > 0))
    {
      int i = 0;
      while (i < this.uC.size())
      {
        a(((Long)this.uC.get(i)).longValue());
        i += 1;
      }
      this.uC.clear();
    }
    this.jdField_a_of_type_Adon$a = null;
    arvv.a().b(this.b);
    this.b = null;
  }
  
  public String GetTypeName()
  {
    return "QQYYBDownload";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("getQueryDownloadAction")) {}
    while ((paramString.equals("doDownloadAction")) || (paramString.equals("RegisterDownloadCallBackListener"))) {
      return true;
    }
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.YYB_DOWNLOAD"))
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        kZ(paramString.getString(2131690510));
      }
    }
    long l;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.downloadyyb.module", 1, String.format("ArkAppYYBDownloadModule.invokeFunc.%s", new Object[] { paramString }));
      }
      if (paramString.equals("getQueryDownloadAction"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          l = a(paramArrayOfVariantWrapper[1].Copy());
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.downloadyyb.module", 1, "<getQueryDownloadAction> paramJson=" + paramString);
          }
        }
        try
        {
          paramString = new JSONObject(paramString);
          paramArrayOfVariantWrapper = new JSONArray(paramString.optString("queryParams"));
          a(paramString.optInt("actioncode"), paramArrayOfVariantWrapper, l);
          return true;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            QLog.e("ArkApp.downloadyyb.module", 1, "[queryDownloadAction] e=" + paramString.getMessage());
          }
        }
      }
      if (paramString.equals("doDownloadAction"))
      {
        if (this.jdField_a_of_type_Adon$a == null)
        {
          QLog.e("ArkApp.downloadyyb.module", 1, "should DownloadInit first ");
          paramVariantWrapper.SetInt(-2);
          return true;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule = " + paramString);
          }
          a(paramString, paramVariantWrapper);
          return true;
        }
        paramVariantWrapper.SetInt(-1);
        return true;
      }
    } while (!paramString.equals("RegisterDownloadCallBackListener"));
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
    {
      l = a(paramArrayOfVariantWrapper[0].Copy());
      arvv.a().a(this.b);
      this.jdField_a_of_type_Adon$a = new adoo(this);
      this.uC.add(Long.valueOf(l));
      paramVariantWrapper.SetBool(true);
      return true;
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  public JSONObject a(DownloadInfo paramDownloadInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramDownloadInfo != null) {
      try
      {
        localJSONObject.put("appid", paramDownloadInfo.appId);
        localJSONObject.put("state", paramDownloadInfo.getState());
        localJSONObject.put("pro", paramDownloadInfo.progress);
        localJSONObject.put("packagename", paramDownloadInfo.packageName);
        if (TextUtils.isEmpty(paramDownloadInfo.filePath))
        {
          localJSONObject.put("final_file_exits", "false");
          return localJSONObject;
        }
        localJSONObject.put("final_file_exits", new File(paramDownloadInfo.filePath).exists());
        return localJSONObject;
      }
      catch (JSONException paramDownloadInfo)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "tranDownloadToJSONObject ", paramDownloadInfo);
      }
    }
    return localJSONObject;
  }
  
  protected JSONObject a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("pro", paramInt2);
      localJSONObject.put("errorMsg", paramString3);
      localJSONObject.put("errorCode", paramInt3);
      localJSONObject.put("writecodestate", paramInt4);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject;
  }
  
  protected JSONObject a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt);
      localJSONObject.put("pro", 0);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppYYBDownloadModule.7(this, paramDownloadInfo, paramActivity));
  }
  
  static abstract interface a
  {
    public abstract void GH(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adon
 * JD-Core Version:    0.7.0.1
 */