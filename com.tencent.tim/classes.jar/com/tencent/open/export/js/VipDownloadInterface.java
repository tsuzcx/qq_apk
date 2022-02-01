package com.tencent.open.export.js;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import arwt;
import arxp;
import arxq;
import aryr;
import aryy;
import arzx;
import arzx.a;
import asah;
import asai;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipDownloadInterface
  extends BaseInterface
  implements arxp
{
  protected final Activity K;
  public final String TAG = VipDownloadInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  protected arzx.a listener;
  protected Handler mHandler;
  protected final WebView webview;
  
  public VipDownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    arwt.d(this.TAG, "init in");
    this.webview = paramWebView;
    this.K = paramActivity;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((this.K instanceof PublicFragmentActivityForTool)) {
      paramActivity = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      aryy.a().setAppInterface(paramActivity);
      aryy.a();
      arwt.d(this.TAG, "init out");
      return;
      paramActivity = localObject;
      if ((this.K instanceof BaseActivity)) {
        paramActivity = (AppInterface)((BaseActivity)this.K).getAppRuntime();
      }
    }
  }
  
  public boolean cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return false;
    }
    aryr.Z(paramString1, paramString2, true);
    return true;
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    aryy.a().cancelNotification(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    arwt.d(this.TAG, "enter checkUpdate json=" + paramString1);
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      paramString2 = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("packageNames");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      if (this.listener == null)
      {
        this.listener = new a(paramString1);
        arzx.a().a(this.listener);
      }
      arzx.a().checkUpdate(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      arwt.e(this.TAG, "httpRequest JSONException", paramString1);
    }
  }
  
  public void destroy()
  {
    arwt.d(this.TAG, "destroy");
    arxq.a().b(this);
    if (arzx.PN()) {
      arzx.a().b(this.listener);
    }
  }
  
  /* Error */
  public void doDownloadAction(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   7: new 124	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   14: ldc 218
    //   16: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 221	arwt:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 107	com/tencent/open/export/js/VipDownloadInterface:hasRight	()Z
    //   33: ifne +4 -> 37
    //   36: return
    //   37: new 223	android/os/Bundle
    //   40: dup
    //   41: invokespecial 224	android/os/Bundle:<init>	()V
    //   44: astore 6
    //   46: new 136	org/json/JSONObject
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore 7
    //   56: aload 7
    //   58: ldc 226
    //   60: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   63: istore_2
    //   64: aload 7
    //   66: getstatic 235	aryv:cDC	Ljava/lang/String;
    //   69: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 4
    //   74: aload 4
    //   76: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +873 -> 952
    //   82: aload 4
    //   84: ldc 237
    //   86: invokevirtual 242	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +863 -> 952
    //   92: aload_0
    //   93: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   96: new 124	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   103: ldc 244
    //   105: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 4
    //   110: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 221	arwt:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: iload_2
    //   120: ifne +226 -> 346
    //   123: aload 6
    //   125: getstatic 247	aryv:PARAM_SNG_APPID	Ljava/lang/String;
    //   128: aload 7
    //   130: ldc 249
    //   132: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 6
    //   140: getstatic 255	aryv:PARAM_URL	Ljava/lang/String;
    //   143: aload 7
    //   145: ldc_w 257
    //   148: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 6
    //   156: getstatic 260	aryv:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   159: aload 7
    //   161: ldc_w 262
    //   164: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload 6
    //   172: getstatic 265	aryv:PARAM_ACTIONCODE	Ljava/lang/String;
    //   175: aload 7
    //   177: ldc_w 267
    //   180: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   183: invokevirtual 271	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   186: aload 6
    //   188: getstatic 274	aryv:PARAM_VIA	Ljava/lang/String;
    //   191: aload 7
    //   193: ldc_w 276
    //   196: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 6
    //   204: getstatic 279	aryv:PARAM_APPNAME	Ljava/lang/String;
    //   207: aload 7
    //   209: ldc_w 281
    //   212: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 6
    //   220: getstatic 235	aryv:cDC	Ljava/lang/String;
    //   223: aload 4
    //   225: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 7
    //   230: ldc_w 283
    //   233: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 4
    //   238: aload 4
    //   240: astore_1
    //   241: aload 4
    //   243: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: ifeq +11 -> 257
    //   249: aload_0
    //   250: getfield 49	com/tencent/open/export/js/VipDownloadInterface:K	Landroid/app/Activity;
    //   253: invokestatic 289	com/tencent/open/appcommon/js/DownloadInterface:getSourceInfoFromActivity	(Landroid/app/Activity;)Ljava/lang/String;
    //   256: astore_1
    //   257: aload_1
    //   258: astore 4
    //   260: ldc_w 291
    //   263: aload_1
    //   264: invokevirtual 242	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifne +8 -> 275
    //   270: ldc_w 293
    //   273: astore 4
    //   275: aload_0
    //   276: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   279: new 124	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 295
    //   289: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 7
    //   294: invokevirtual 296	org/json/JSONObject:toString	()Ljava/lang/String;
    //   297: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 221	arwt:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_0
    //   307: getfield 49	com/tencent/open/export/js/VipDownloadInterface:K	Landroid/app/Activity;
    //   310: aload 6
    //   312: aload 4
    //   314: aconst_null
    //   315: iconst_0
    //   316: invokestatic 299	aryr:d	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;Lcom/tencent/apkupdate/logic/data/ApkUpdateDetail;I)V
    //   319: return
    //   320: astore_1
    //   321: aload_0
    //   322: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   325: ldc_w 301
    //   328: aload_1
    //   329: invokestatic 195	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   332: return
    //   333: astore_1
    //   334: aload_0
    //   335: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   338: ldc_w 303
    //   341: aload_1
    //   342: invokestatic 195	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   345: return
    //   346: new 136	org/json/JSONObject
    //   349: dup
    //   350: aload_1
    //   351: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   354: astore 7
    //   356: aload 6
    //   358: getstatic 247	aryv:PARAM_SNG_APPID	Ljava/lang/String;
    //   361: aload 7
    //   363: ldc 249
    //   365: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   368: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 6
    //   373: getstatic 255	aryv:PARAM_URL	Ljava/lang/String;
    //   376: aload 7
    //   378: ldc_w 257
    //   381: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload 6
    //   389: getstatic 260	aryv:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   392: aload 7
    //   394: ldc_w 262
    //   397: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload 6
    //   405: getstatic 265	aryv:PARAM_ACTIONCODE	Ljava/lang/String;
    //   408: aload 7
    //   410: ldc_w 267
    //   413: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   416: invokevirtual 271	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   419: aload 6
    //   421: getstatic 274	aryv:PARAM_VIA	Ljava/lang/String;
    //   424: aload 7
    //   426: ldc_w 276
    //   429: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload 6
    //   437: getstatic 279	aryv:PARAM_APPNAME	Ljava/lang/String;
    //   440: aload 7
    //   442: ldc_w 281
    //   445: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   448: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload 6
    //   453: getstatic 306	aryv:PARAM_SHOW_NETWORK_DIALOG	Ljava/lang/String;
    //   456: aload 7
    //   458: ldc_w 308
    //   461: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   464: invokestatic 312	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   467: invokevirtual 316	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   470: aload 6
    //   472: getstatic 319	aryv:PARAM_WORDING	Ljava/lang/String;
    //   475: aload 7
    //   477: ldc_w 321
    //   480: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   483: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload 6
    //   488: getstatic 235	aryv:cDC	Ljava/lang/String;
    //   491: aload 4
    //   493: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload 7
    //   498: ldc_w 276
    //   501: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   504: pop
    //   505: aload 7
    //   507: ldc 249
    //   509: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   512: pop
    //   513: aload 7
    //   515: ldc_w 267
    //   518: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   521: pop
    //   522: aload 5
    //   524: astore_1
    //   525: aload 7
    //   527: ldc_w 267
    //   530: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   533: bipush 12
    //   535: if_icmpne +185 -> 720
    //   538: aload 7
    //   540: ldc_w 323
    //   543: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   546: invokestatic 312	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   549: istore_3
    //   550: aload 6
    //   552: getstatic 326	aryv:PARAM_PATCH_UPDATE	Ljava/lang/String;
    //   555: iload_3
    //   556: invokevirtual 316	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   559: aload 7
    //   561: ldc_w 328
    //   564: invokevirtual 332	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   567: istore_3
    //   568: aload 5
    //   570: astore_1
    //   571: iload_3
    //   572: ifeq +148 -> 720
    //   575: aload 7
    //   577: ldc_w 328
    //   580: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   583: astore 4
    //   585: aload 4
    //   587: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   590: ifne +357 -> 947
    //   593: new 334	com/tencent/apkupdate/logic/data/ApkUpdateDetail
    //   596: dup
    //   597: invokespecial 335	com/tencent/apkupdate/logic/data/ApkUpdateDetail:<init>	()V
    //   600: astore_1
    //   601: new 136	org/json/JSONObject
    //   604: dup
    //   605: aload 4
    //   607: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   610: astore 4
    //   612: aload_1
    //   613: aload 4
    //   615: ldc_w 262
    //   618: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   621: putfield 337	com/tencent/apkupdate/logic/data/ApkUpdateDetail:packageName	Ljava/lang/String;
    //   624: aload_1
    //   625: aload 4
    //   627: ldc_w 339
    //   630: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   633: putfield 342	com/tencent/apkupdate/logic/data/ApkUpdateDetail:newapksize	I
    //   636: aload_1
    //   637: aload 4
    //   639: ldc_w 344
    //   642: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   645: putfield 346	com/tencent/apkupdate/logic/data/ApkUpdateDetail:patchsize	I
    //   648: aload_1
    //   649: aload 4
    //   651: ldc_w 348
    //   654: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   657: putfield 350	com/tencent/apkupdate/logic/data/ApkUpdateDetail:updatemethod	I
    //   660: aload_1
    //   661: aload 4
    //   663: ldc_w 352
    //   666: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   669: putfield 354	com/tencent/apkupdate/logic/data/ApkUpdateDetail:versioncode	I
    //   672: aload_1
    //   673: aload 4
    //   675: ldc_w 356
    //   678: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   681: putfield 358	com/tencent/apkupdate/logic/data/ApkUpdateDetail:versionname	Ljava/lang/String;
    //   684: aload_1
    //   685: aload 4
    //   687: ldc_w 360
    //   690: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   693: putfield 362	com/tencent/apkupdate/logic/data/ApkUpdateDetail:fileMd5	Ljava/lang/String;
    //   696: aload_1
    //   697: aload 4
    //   699: ldc_w 364
    //   702: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   705: putfield 366	com/tencent/apkupdate/logic/data/ApkUpdateDetail:sigMd5	Ljava/lang/String;
    //   708: aload_1
    //   709: aload 4
    //   711: ldc_w 257
    //   714: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   717: putfield 368	com/tencent/apkupdate/logic/data/ApkUpdateDetail:url	Ljava/lang/String;
    //   720: aload 6
    //   722: getstatic 371	aryv:PARAM_TASK_APPID	Ljava/lang/String;
    //   725: aload 7
    //   727: ldc_w 373
    //   730: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   733: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: aload 6
    //   738: getstatic 376	aryv:PARAM_TASK_APK_ID	Ljava/lang/String;
    //   741: aload 7
    //   743: ldc_w 378
    //   746: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   749: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   752: aload 6
    //   754: getstatic 381	aryv:PARAM_TASK_VERSION	Ljava/lang/String;
    //   757: aload 7
    //   759: ldc_w 383
    //   762: bipush 246
    //   764: invokevirtual 386	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   767: invokevirtual 271	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   770: aload 6
    //   772: getstatic 389	aryv:PARAM_TO_PAGETYPE	Ljava/lang/String;
    //   775: aload 7
    //   777: ldc_w 391
    //   780: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   783: invokevirtual 271	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   786: aload 6
    //   788: getstatic 394	aryv:PARAM_AUTO_DOWNLOAD	Ljava/lang/String;
    //   791: aload 7
    //   793: ldc_w 396
    //   796: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   799: invokestatic 312	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   802: invokevirtual 316	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   805: aload 6
    //   807: getstatic 399	aryv:PARAM_AUTO_INSTALL	Ljava/lang/String;
    //   810: aload 7
    //   812: ldc_w 401
    //   815: invokevirtual 230	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   818: invokestatic 312	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   821: invokevirtual 316	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   824: aload 7
    //   826: ldc_w 283
    //   829: invokevirtual 150	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   832: astore 5
    //   834: aload 5
    //   836: astore 4
    //   838: aload 5
    //   840: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   843: ifeq +12 -> 855
    //   846: aload_0
    //   847: getfield 49	com/tencent/open/export/js/VipDownloadInterface:K	Landroid/app/Activity;
    //   850: invokestatic 289	com/tencent/open/appcommon/js/DownloadInterface:getSourceInfoFromActivity	(Landroid/app/Activity;)Ljava/lang/String;
    //   853: astore 4
    //   855: aload_0
    //   856: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   859: new 124	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 295
    //   869: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload 7
    //   874: invokevirtual 296	org/json/JSONObject:toString	()Ljava/lang/String;
    //   877: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 45	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: aload_0
    //   887: getfield 49	com/tencent/open/export/js/VipDownloadInterface:K	Landroid/app/Activity;
    //   890: aload 6
    //   892: aload 4
    //   894: aload_1
    //   895: iload_2
    //   896: invokestatic 299	aryr:d	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;Lcom/tencent/apkupdate/logic/data/ApkUpdateDetail;I)V
    //   899: return
    //   900: astore_1
    //   901: aload_0
    //   902: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   905: ldc_w 303
    //   908: aload_1
    //   909: invokestatic 195	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   912: return
    //   913: astore_1
    //   914: aconst_null
    //   915: astore_1
    //   916: aload_0
    //   917: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   920: ldc_w 403
    //   923: invokestatic 45	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: goto -206 -> 720
    //   929: astore_1
    //   930: aload_0
    //   931: getfield 33	com/tencent/open/export/js/VipDownloadInterface:TAG	Ljava/lang/String;
    //   934: ldc_w 301
    //   937: aload_1
    //   938: invokestatic 195	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   941: return
    //   942: astore 4
    //   944: goto -28 -> 916
    //   947: aconst_null
    //   948: astore_1
    //   949: goto -229 -> 720
    //   952: ldc 35
    //   954: astore 4
    //   956: goto -864 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	959	0	this	VipDownloadInterface
    //   0	959	1	paramString	String
    //   63	833	2	i	int
    //   549	23	3	bool	boolean
    //   72	821	4	localObject	Object
    //   942	1	4	localException	java.lang.Exception
    //   954	1	4	str1	String
    //   1	838	5	str2	String
    //   44	847	6	localBundle	android.os.Bundle
    //   54	819	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   123	238	320	java/lang/NumberFormatException
    //   241	257	320	java/lang/NumberFormatException
    //   260	270	320	java/lang/NumberFormatException
    //   275	319	320	java/lang/NumberFormatException
    //   46	56	333	org/json/JSONException
    //   346	522	900	org/json/JSONException
    //   525	568	900	org/json/JSONException
    //   575	601	900	org/json/JSONException
    //   601	720	900	org/json/JSONException
    //   720	834	900	org/json/JSONException
    //   838	855	900	org/json/JSONException
    //   855	899	900	org/json/JSONException
    //   916	926	900	org/json/JSONException
    //   575	601	913	java/lang/Exception
    //   346	522	929	java/lang/NumberFormatException
    //   525	568	929	java/lang/NumberFormatException
    //   575	601	929	java/lang/NumberFormatException
    //   601	720	929	java/lang/NumberFormatException
    //   720	834	929	java/lang/NumberFormatException
    //   838	855	929	java/lang/NumberFormatException
    //   855	899	929	java/lang/NumberFormatException
    //   916	926	929	java/lang/NumberFormatException
    //   601	720	942	java/lang/Exception
  }
  
  public String getDownloadVersion()
  {
    return aryr.getVersionCode() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download_vip";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    arwt.i(this.TAG, "enter getQueryDownloadAction = " + paramString);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("infolist");
      localObject = ((JSONObject)localObject).getString("guid");
      int j = paramString.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.appId = localJSONObject.optString("appid");
        localDownloadInfo.cDG = localJSONObject.optString("myAppId");
        localDownloadInfo.cCL = localJSONObject.optString("apkId");
        localDownloadInfo.packageName = localJSONObject.optString("packageName");
        localDownloadInfo.versionCode = localJSONObject.optInt("versionCode");
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      aryr.b(localArrayList, new asah(this, (String)localObject));
      return;
    }
    catch (JSONException paramString)
    {
      arwt.e(this.TAG, "getQueryDownloadAction>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    arwt.v(this.TAG, "enter getQueryDownloadAction = " + paramString1);
    if (!hasRight()) {
      return;
    }
    try
    {
      paramString1 = new JSONArray(paramString1);
      int j = paramString1.length();
      paramString2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.appId = paramString1.getString(i);
        paramString2.add(localDownloadInfo);
        i += 1;
      }
      aryr.b(paramString2, new asai(this));
      return;
    }
    catch (JSONException paramString1)
    {
      arwt.e(this.TAG, "getQueryDownloadAction>>>", paramString1);
    }
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  public void jsCallBack(String paramString)
  {
    this.mHandler.post(new VipDownloadInterface.3(this, paramString));
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    arxq.a().a(this);
    this.jsCallBackMethod = paramString;
  }
  
  public class a
    implements arzx.a
  {
    protected final String guid;
    
    public a(String paramString)
    {
      arwt.i(VipDownloadInterface.this.TAG, "new  JsCheckUpdateCallback");
      this.guid = paramString;
    }
    
    public void Ui(String paramString)
    {
      if (!VipDownloadInterface.this.hasRight()) {
        return;
      }
      arwt.e(VipDownloadInterface.this.TAG, "JsCheckUpdateCallback onException >>> " + paramString);
      paramString = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.guid + "\",\"r\":\"-1\"});}void(0);";
      VipDownloadInterface.this.jsCallBack(paramString);
    }
    
    public void onResult(ArrayList<ApkUpdateDetail> paramArrayList)
    {
      if (!VipDownloadInterface.this.hasRight()) {
        return;
      }
      arwt.v(VipDownloadInterface.this.TAG, "JsCheckUpdateCallback onResult >>> " + paramArrayList.size());
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      try
      {
        while (i < paramArrayList.size())
        {
          ApkUpdateDetail localApkUpdateDetail = (ApkUpdateDetail)paramArrayList.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("packageName", localApkUpdateDetail.packageName);
          localJSONObject2.put("newapksize", localApkUpdateDetail.newapksize);
          localJSONObject2.put("patchsize", localApkUpdateDetail.patchsize);
          localJSONObject2.put("updatemethod", localApkUpdateDetail.updatemethod);
          localJSONObject2.put("versioncode", localApkUpdateDetail.versioncode);
          localJSONObject2.put("versionname", localApkUpdateDetail.versionname);
          localJSONObject2.put("fileMd5", localApkUpdateDetail.fileMd5);
          localJSONObject2.put("sigMd5", localApkUpdateDetail.sigMd5);
          localJSONObject2.put("url", localApkUpdateDetail.url);
          localJSONArray.put(localJSONObject2);
          i += 1;
        }
        localJSONObject1.put("guid", this.guid);
        localJSONObject1.put("content", localJSONArray.toString());
        localJSONObject1.put("resultCode", "0");
        paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'" + this.guid + "','r':'0','data':'" + localJSONArray.toString() + "'});}void(0);";
      }
      catch (JSONException paramArrayList)
      {
        for (;;)
        {
          paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.guid + "\",\"r\":\"-1\"});}void(0);";
        }
      }
      arwt.i(VipDownloadInterface.this.TAG, ">>checkUpdate jsUrl:" + paramArrayList);
      VipDownloadInterface.this.jsCallBack(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface
 * JD-Core Version:    0.7.0.1
 */