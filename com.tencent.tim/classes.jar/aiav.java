import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.1;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.2;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.4;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aiav
  extends aiap
{
  private FaceDetectForThirdPartyManager.AppConf a;
  private Intent mIntent;
  
  public aiav(Intent paramIntent, aiay.a parama)
  {
    this.b = parama;
    this.mIntent = paramIntent;
    this.a = ((FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf"));
  }
  
  private void postRunnable(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  @RequiresApi(api=18)
  public void b(boolean paramBoolean, Activity paramActivity)
  {
    Object localObject;
    int k;
    int i;
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new IdentificationPoseReflect.1(this, paramActivity));
      localObject = anij.a().mCamera;
      k = anij.a().dGP;
      i = -1;
    }
    try
    {
      int j = YTCameraSetting.initCamera(paramActivity.getApplicationContext(), (Camera)localObject, k);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera error : ", localException.getMessage() });
      }
      YtSDKKitFramework.YtSDKPlatformContex localYtSDKPlatformContex = YtSDKKitFramework.getInstance().getPlatformContext();
      localYtSDKPlatformContex.currentCamera = ((Camera)localObject);
      localYtSDKPlatformContex.currentCameraId = k;
      localYtSDKPlatformContex.currentRotateState = YTCameraSetting.getRotate(BaseApplicationImpl.getApplication(), k, 1);
      localYtSDKPlatformContex.reflectLayout = null;
      localYtSDKPlatformContex.reflectListener = new aiaw(this);
      localYtSDKPlatformContex.currentAppContex = paramActivity.getApplicationContext();
      localObject = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
      JSONObject localJSONObject = aibb.a().h(5);
      ArrayList localArrayList = YtSDKKitConfigHelper.getPipleStateNames((YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject);
      if ((localArrayList != null) && (localJSONObject != null)) {
        break label268;
      }
      if (!(paramActivity instanceof QQIdentiferActivity)) {
        break label259;
      }
      postRunnable(new IdentificationPoseReflect.4(this, paramActivity));
      QLog.e("qq_Identification.Model", 1, "initSdkResult stateNames == null || sdkConfig == null");
      return;
      QLog.d("qq_Identification.Model", 1, new Object[] { "YtSDKKitFramework init result : ", Integer.valueOf(YtSDKKitFramework.getInstance().init(localYtSDKPlatformContex, localJSONObject, (YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject, localArrayList, new aiax(this))) });
    }
    QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera result : ", Integer.valueOf(i) });
    if (i != 0)
    {
      new HashMap().put("process_action", "failed");
      if ((paramActivity instanceof QQIdentiferActivity)) {
        postRunnable(new IdentificationPoseReflect.2(this, paramActivity));
      }
      return;
    }
    label259:
    label268:
    return;
  }
  
  public void destroy()
  {
    super.destroy();
    YtSDKKitFramework.getInstance().deInit();
  }
  
  public boolean e(String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("qq_Identification.Model", 1, "initLoadSo error : so path is empty");
      return false;
    }
    try
    {
      if (new File(paramString).exists())
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramArrayOfString[i];
          System.load(paramString + str);
          i += 1;
        }
        QLog.d("qq_Identification.Model", 1, "init load so success");
        return true;
      }
      QLog.e("qq_Identification.Model", 1, "init load so, soDir is not exists");
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("qq_Identification.Model", 1, "System.load so Exception : " + paramString.getMessage());
      return false;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      QLog.e("qq_Identification.Model", 1, "System.load so UnsatisfiedLinkError : " + paramString.getMessage());
    }
    return false;
  }
  
  /* Error */
  public int y(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 269	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   10: aload_2
    //   11: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 303
    //   17: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore 6
    //   25: new 269	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   32: aload_2
    //   33: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 305
    //   39: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 8
    //   47: new 269	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   54: astore 9
    //   56: new 269	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   63: astore 10
    //   65: new 307	java/io/BufferedReader
    //   68: dup
    //   69: new 309	java/io/InputStreamReader
    //   72: dup
    //   73: new 311	java/io/FileInputStream
    //   76: dup
    //   77: new 260	java/io/File
    //   80: dup
    //   81: aload 6
    //   83: invokespecial 263	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 317	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   92: invokespecial 320	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   95: astore_2
    //   96: new 307	java/io/BufferedReader
    //   99: dup
    //   100: new 309	java/io/InputStreamReader
    //   103: dup
    //   104: new 311	java/io/FileInputStream
    //   107: dup
    //   108: new 260	java/io/File
    //   111: dup
    //   112: aload 8
    //   114: invokespecial 263	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: invokespecial 317	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   123: invokespecial 320	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   126: astore 6
    //   128: aload 6
    //   130: astore 8
    //   132: aload_2
    //   133: astore 7
    //   135: aload_2
    //   136: invokevirtual 323	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   139: astore 11
    //   141: aload 11
    //   143: ifnull +77 -> 220
    //   146: aload 6
    //   148: astore 8
    //   150: aload_2
    //   151: astore 7
    //   153: aload 9
    //   155: aload 11
    //   157: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: goto -33 -> 128
    //   164: astore 7
    //   166: aload_2
    //   167: astore_1
    //   168: aload 7
    //   170: astore_2
    //   171: ldc 114
    //   173: iconst_1
    //   174: new 269	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 325
    //   184: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_2
    //   188: invokevirtual 326	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 329	java/io/BufferedReader:close	()V
    //   208: aload 6
    //   210: ifnull +8 -> 218
    //   213: aload 6
    //   215: invokevirtual 329	java/io/BufferedReader:close	()V
    //   218: iconst_1
    //   219: ireturn
    //   220: aload 6
    //   222: astore 8
    //   224: aload_2
    //   225: astore 7
    //   227: aload 6
    //   229: invokevirtual 323	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   232: astore 11
    //   234: aload 11
    //   236: ifnull +110 -> 346
    //   239: aload 6
    //   241: astore 8
    //   243: aload_2
    //   244: astore 7
    //   246: aload 10
    //   248: aload 11
    //   250: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: goto -34 -> 220
    //   257: astore_1
    //   258: aload 6
    //   260: astore 8
    //   262: aload_2
    //   263: astore 7
    //   265: ldc 114
    //   267: iconst_1
    //   268: new 269	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 331
    //   278: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   285: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 329	java/io/BufferedReader:close	()V
    //   302: aload 6
    //   304: ifnull -86 -> 218
    //   307: aload 6
    //   309: invokevirtual 329	java/io/BufferedReader:close	()V
    //   312: iconst_1
    //   313: ireturn
    //   314: astore_1
    //   315: ldc 114
    //   317: iconst_1
    //   318: new 269	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 334
    //   328: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_1
    //   332: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iconst_1
    //   345: ireturn
    //   346: aload 6
    //   348: astore 8
    //   350: aload_2
    //   351: astore 7
    //   353: invokestatic 211	aibb:a	()Laibb;
    //   356: aload 9
    //   358: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: aload 10
    //   363: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 338	aibb:L	(Ljava/lang/String;Ljava/lang/String;)I
    //   369: pop
    //   370: aload 6
    //   372: astore 8
    //   374: aload_2
    //   375: astore 7
    //   377: aload_0
    //   378: getfield 31	aiav:a	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   381: ifnull +579 -> 960
    //   384: aload 6
    //   386: astore 8
    //   388: aload_2
    //   389: astore 7
    //   391: aload_0
    //   392: getfield 31	aiav:a	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   395: getfield 342	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   398: ifnull +562 -> 960
    //   401: aload 6
    //   403: astore 8
    //   405: aload_2
    //   406: astore 7
    //   408: invokestatic 211	aibb:a	()Laibb;
    //   411: iconst_5
    //   412: invokevirtual 215	aibb:h	(I)Lorg/json/JSONObject;
    //   415: astore 10
    //   417: aload 10
    //   419: ifnonnull +104 -> 523
    //   422: aload 6
    //   424: astore 8
    //   426: aload_2
    //   427: astore 7
    //   429: ldc 114
    //   431: iconst_1
    //   432: ldc_w 344
    //   435: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload_2
    //   439: ifnull +7 -> 446
    //   442: aload_2
    //   443: invokevirtual 329	java/io/BufferedReader:close	()V
    //   446: aload 6
    //   448: ifnull -230 -> 218
    //   451: aload 6
    //   453: invokevirtual 329	java/io/BufferedReader:close	()V
    //   456: iconst_1
    //   457: ireturn
    //   458: astore_1
    //   459: ldc 114
    //   461: iconst_1
    //   462: new 269	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 334
    //   472: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload_1
    //   476: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   479: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: iconst_1
    //   489: ireturn
    //   490: astore_1
    //   491: ldc 114
    //   493: iconst_1
    //   494: new 269	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   501: ldc_w 346
    //   504: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_1
    //   508: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   511: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: goto -74 -> 446
    //   523: aload 6
    //   525: astore 8
    //   527: aload_2
    //   528: astore 7
    //   530: new 348	org/json/JSONArray
    //   533: dup
    //   534: invokespecial 349	org/json/JSONArray:<init>	()V
    //   537: astore 9
    //   539: aload 6
    //   541: astore 8
    //   543: aload_2
    //   544: astore 7
    //   546: aload_0
    //   547: getfield 31	aiav:a	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   550: getfield 342	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   553: astore 11
    //   555: aload 6
    //   557: astore 8
    //   559: aload_2
    //   560: astore 7
    //   562: aload 11
    //   564: arraylength
    //   565: istore 4
    //   567: iconst_0
    //   568: istore_3
    //   569: iload_3
    //   570: iload 4
    //   572: if_icmpge +27 -> 599
    //   575: aload 6
    //   577: astore 8
    //   579: aload_2
    //   580: astore 7
    //   582: aload 9
    //   584: aload 11
    //   586: iload_3
    //   587: iaload
    //   588: invokevirtual 352	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   591: pop
    //   592: iload_3
    //   593: iconst_1
    //   594: iadd
    //   595: istore_3
    //   596: goto -27 -> 569
    //   599: aload 6
    //   601: astore 8
    //   603: aload_2
    //   604: astore 7
    //   606: aload 10
    //   608: ldc_w 354
    //   611: aload 9
    //   613: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   616: pop
    //   617: aload 6
    //   619: astore 8
    //   621: aload_2
    //   622: astore 7
    //   624: aload 10
    //   626: ldc_w 361
    //   629: aload_0
    //   630: getfield 31	aiav:a	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   633: getfield 365	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:colorSequence	Ljava/lang/String;
    //   636: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   639: pop
    //   640: aload 6
    //   642: astore 8
    //   644: aload_2
    //   645: astore 7
    //   647: aload 10
    //   649: ldc_w 367
    //   652: invokevirtual 371	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   655: pop
    //   656: aload 6
    //   658: astore 8
    //   660: aload_2
    //   661: astore 7
    //   663: aload_1
    //   664: invokevirtual 377	android/content/Context:getFilesDir	()Ljava/io/File;
    //   667: invokevirtual 380	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   670: astore 11
    //   672: aload 6
    //   674: astore 8
    //   676: aload_2
    //   677: astore 7
    //   679: getstatic 386	axcd:c	Laxcd;
    //   682: invokestatic 391	axce:a	(Laxcd;)Ljava/lang/String;
    //   685: astore 9
    //   687: aload 9
    //   689: astore_1
    //   690: aload 6
    //   692: astore 8
    //   694: aload_2
    //   695: astore 7
    //   697: aload 9
    //   699: getstatic 394	java/io/File:separator	Ljava/lang/String;
    //   702: invokevirtual 400	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   705: ifeq +24 -> 729
    //   708: aload 6
    //   710: astore 8
    //   712: aload_2
    //   713: astore 7
    //   715: aload 9
    //   717: iconst_0
    //   718: aload 9
    //   720: invokevirtual 403	java/lang/String:length	()I
    //   723: iconst_1
    //   724: isub
    //   725: invokevirtual 407	java/lang/String:substring	(II)Ljava/lang/String;
    //   728: astore_1
    //   729: aload 6
    //   731: astore 8
    //   733: aload_2
    //   734: astore 7
    //   736: aload 10
    //   738: ldc_w 409
    //   741: new 269	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   748: aload 11
    //   750: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 411
    //   756: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   765: pop
    //   766: aload 6
    //   768: astore 8
    //   770: aload_2
    //   771: astore 7
    //   773: aload 10
    //   775: ldc_w 413
    //   778: aload_1
    //   779: invokevirtual 359	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   782: pop
    //   783: aload 6
    //   785: astore 8
    //   787: aload_2
    //   788: astore 7
    //   790: ldc 114
    //   792: iconst_1
    //   793: iconst_4
    //   794: anewarray 116	java/lang/Object
    //   797: dup
    //   798: iconst_0
    //   799: ldc_w 415
    //   802: aastore
    //   803: dup
    //   804: iconst_1
    //   805: new 269	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   812: aload 11
    //   814: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: ldc_w 411
    //   820: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: aastore
    //   827: dup
    //   828: iconst_2
    //   829: ldc_w 417
    //   832: aastore
    //   833: dup
    //   834: iconst_3
    //   835: aload_1
    //   836: aastore
    //   837: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   840: aload 6
    //   842: astore 8
    //   844: aload_2
    //   845: astore 7
    //   847: new 260	java/io/File
    //   850: dup
    //   851: aload 10
    //   853: ldc_w 409
    //   856: ldc_w 419
    //   859: invokevirtual 423	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   862: invokespecial 263	java/io/File:<init>	(Ljava/lang/String;)V
    //   865: astore_1
    //   866: aload 6
    //   868: astore 8
    //   870: aload_2
    //   871: astore 7
    //   873: aload_1
    //   874: invokevirtual 426	java/io/File:getParentFile	()Ljava/io/File;
    //   877: astore 9
    //   879: aload 9
    //   881: ifnull +115 -> 996
    //   884: aload 6
    //   886: astore 8
    //   888: aload_2
    //   889: astore 7
    //   891: aload 9
    //   893: invokevirtual 267	java/io/File:exists	()Z
    //   896: ifne +100 -> 996
    //   899: aload 6
    //   901: astore 8
    //   903: aload_2
    //   904: astore 7
    //   906: aload 9
    //   908: invokevirtual 429	java/io/File:mkdirs	()Z
    //   911: istore 5
    //   913: iload 5
    //   915: ifne +19 -> 934
    //   918: aload 6
    //   920: astore 8
    //   922: aload_2
    //   923: astore 7
    //   925: aload 10
    //   927: ldc_w 409
    //   930: invokevirtual 371	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   933: pop
    //   934: aload 6
    //   936: astore 8
    //   938: aload_2
    //   939: astore 7
    //   941: aload_1
    //   942: invokevirtual 267	java/io/File:exists	()Z
    //   945: ifeq +15 -> 960
    //   948: aload 6
    //   950: astore 8
    //   952: aload_2
    //   953: astore 7
    //   955: aload_1
    //   956: invokevirtual 432	java/io/File:delete	()Z
    //   959: pop
    //   960: aload 6
    //   962: astore 8
    //   964: aload_2
    //   965: astore 7
    //   967: ldc 114
    //   969: iconst_1
    //   970: ldc_w 434
    //   973: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: aload_2
    //   977: ifnull +7 -> 984
    //   980: aload_2
    //   981: invokevirtual 329	java/io/BufferedReader:close	()V
    //   984: aload 6
    //   986: ifnull +8 -> 994
    //   989: aload 6
    //   991: invokevirtual 329	java/io/BufferedReader:close	()V
    //   994: iconst_0
    //   995: ireturn
    //   996: iconst_1
    //   997: istore 5
    //   999: goto -86 -> 913
    //   1002: astore_1
    //   1003: ldc 114
    //   1005: iconst_1
    //   1006: new 269	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1013: ldc_w 346
    //   1016: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: aload_1
    //   1020: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1023: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1032: goto -48 -> 984
    //   1035: astore_1
    //   1036: ldc 114
    //   1038: iconst_1
    //   1039: new 269	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 334
    //   1049: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload_1
    //   1053: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1056: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1065: goto -71 -> 994
    //   1068: astore_1
    //   1069: ldc 114
    //   1071: iconst_1
    //   1072: new 269	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1079: ldc_w 346
    //   1082: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: aload_1
    //   1086: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1089: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1098: goto -890 -> 208
    //   1101: astore_1
    //   1102: ldc 114
    //   1104: iconst_1
    //   1105: new 269	java/lang/StringBuilder
    //   1108: dup
    //   1109: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1112: ldc_w 334
    //   1115: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: aload_1
    //   1119: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1122: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1128: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1131: iconst_1
    //   1132: ireturn
    //   1133: astore_1
    //   1134: ldc 114
    //   1136: iconst_1
    //   1137: new 269	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1144: ldc_w 346
    //   1147: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload_1
    //   1151: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1154: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1160: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1163: goto -861 -> 302
    //   1166: astore_1
    //   1167: aconst_null
    //   1168: astore 6
    //   1170: aconst_null
    //   1171: astore_2
    //   1172: aload 6
    //   1174: astore 8
    //   1176: aload_2
    //   1177: astore 7
    //   1179: ldc 114
    //   1181: iconst_1
    //   1182: new 269	java/lang/StringBuilder
    //   1185: dup
    //   1186: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1189: ldc_w 436
    //   1192: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: aload_1
    //   1196: invokevirtual 437	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1199: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1205: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1208: aload_2
    //   1209: ifnull +7 -> 1216
    //   1212: aload_2
    //   1213: invokevirtual 329	java/io/BufferedReader:close	()V
    //   1216: aload 6
    //   1218: ifnull -1000 -> 218
    //   1221: aload 6
    //   1223: invokevirtual 329	java/io/BufferedReader:close	()V
    //   1226: iconst_1
    //   1227: ireturn
    //   1228: astore_1
    //   1229: ldc 114
    //   1231: iconst_1
    //   1232: new 269	java/lang/StringBuilder
    //   1235: dup
    //   1236: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1239: ldc_w 334
    //   1242: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: aload_1
    //   1246: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1249: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: iconst_1
    //   1259: ireturn
    //   1260: astore_1
    //   1261: ldc 114
    //   1263: iconst_1
    //   1264: new 269	java/lang/StringBuilder
    //   1267: dup
    //   1268: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1271: ldc_w 346
    //   1274: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: aload_1
    //   1278: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1281: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1290: goto -74 -> 1216
    //   1293: astore_1
    //   1294: aconst_null
    //   1295: astore 6
    //   1297: aconst_null
    //   1298: astore_2
    //   1299: aload_2
    //   1300: ifnull +7 -> 1307
    //   1303: aload_2
    //   1304: invokevirtual 329	java/io/BufferedReader:close	()V
    //   1307: aload 6
    //   1309: ifnull +8 -> 1317
    //   1312: aload 6
    //   1314: invokevirtual 329	java/io/BufferedReader:close	()V
    //   1317: aload_1
    //   1318: athrow
    //   1319: astore_2
    //   1320: ldc 114
    //   1322: iconst_1
    //   1323: new 269	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1330: ldc_w 346
    //   1333: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload_2
    //   1337: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1340: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1346: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1349: goto -42 -> 1307
    //   1352: astore_2
    //   1353: ldc 114
    //   1355: iconst_1
    //   1356: new 269	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   1363: ldc_w 334
    //   1366: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: aload_2
    //   1370: invokevirtual 332	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1373: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: goto -65 -> 1317
    //   1385: astore_1
    //   1386: aconst_null
    //   1387: astore 6
    //   1389: goto -90 -> 1299
    //   1392: astore_1
    //   1393: aload 8
    //   1395: astore 6
    //   1397: aload 7
    //   1399: astore_2
    //   1400: goto -101 -> 1299
    //   1403: astore 7
    //   1405: aload_1
    //   1406: astore_2
    //   1407: aload 7
    //   1409: astore_1
    //   1410: goto -111 -> 1299
    //   1413: astore_1
    //   1414: aconst_null
    //   1415: astore 6
    //   1417: goto -245 -> 1172
    //   1420: astore_1
    //   1421: goto -249 -> 1172
    //   1424: astore_1
    //   1425: aconst_null
    //   1426: astore 6
    //   1428: aconst_null
    //   1429: astore_2
    //   1430: goto -1172 -> 258
    //   1433: astore_1
    //   1434: aconst_null
    //   1435: astore 6
    //   1437: goto -1179 -> 258
    //   1440: astore_2
    //   1441: aconst_null
    //   1442: astore 6
    //   1444: aload 7
    //   1446: astore_1
    //   1447: goto -1276 -> 171
    //   1450: astore 7
    //   1452: aconst_null
    //   1453: astore 6
    //   1455: aload_2
    //   1456: astore_1
    //   1457: aload 7
    //   1459: astore_2
    //   1460: goto -1289 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1463	0	this	aiav
    //   0	1463	1	paramContext	android.content.Context
    //   0	1463	2	paramString	String
    //   568	28	3	i	int
    //   565	8	4	j	int
    //   911	87	5	bool	boolean
    //   23	1431	6	localObject1	Object
    //   1	151	7	str1	String
    //   164	5	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   225	1173	7	str2	String
    //   1403	42	7	localObject2	Object
    //   1450	8	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   45	1349	8	localObject3	Object
    //   54	853	9	localObject4	Object
    //   63	863	10	localObject5	Object
    //   139	674	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   135	141	164	java/io/FileNotFoundException
    //   153	161	164	java/io/FileNotFoundException
    //   227	234	164	java/io/FileNotFoundException
    //   246	254	164	java/io/FileNotFoundException
    //   353	370	164	java/io/FileNotFoundException
    //   377	384	164	java/io/FileNotFoundException
    //   391	401	164	java/io/FileNotFoundException
    //   408	417	164	java/io/FileNotFoundException
    //   429	438	164	java/io/FileNotFoundException
    //   530	539	164	java/io/FileNotFoundException
    //   546	555	164	java/io/FileNotFoundException
    //   562	567	164	java/io/FileNotFoundException
    //   582	592	164	java/io/FileNotFoundException
    //   606	617	164	java/io/FileNotFoundException
    //   624	640	164	java/io/FileNotFoundException
    //   647	656	164	java/io/FileNotFoundException
    //   663	672	164	java/io/FileNotFoundException
    //   679	687	164	java/io/FileNotFoundException
    //   697	708	164	java/io/FileNotFoundException
    //   715	729	164	java/io/FileNotFoundException
    //   736	766	164	java/io/FileNotFoundException
    //   773	783	164	java/io/FileNotFoundException
    //   790	840	164	java/io/FileNotFoundException
    //   847	866	164	java/io/FileNotFoundException
    //   873	879	164	java/io/FileNotFoundException
    //   891	899	164	java/io/FileNotFoundException
    //   906	913	164	java/io/FileNotFoundException
    //   925	934	164	java/io/FileNotFoundException
    //   941	948	164	java/io/FileNotFoundException
    //   955	960	164	java/io/FileNotFoundException
    //   967	976	164	java/io/FileNotFoundException
    //   135	141	257	java/io/IOException
    //   153	161	257	java/io/IOException
    //   227	234	257	java/io/IOException
    //   246	254	257	java/io/IOException
    //   353	370	257	java/io/IOException
    //   377	384	257	java/io/IOException
    //   391	401	257	java/io/IOException
    //   408	417	257	java/io/IOException
    //   429	438	257	java/io/IOException
    //   530	539	257	java/io/IOException
    //   546	555	257	java/io/IOException
    //   562	567	257	java/io/IOException
    //   582	592	257	java/io/IOException
    //   606	617	257	java/io/IOException
    //   624	640	257	java/io/IOException
    //   647	656	257	java/io/IOException
    //   663	672	257	java/io/IOException
    //   679	687	257	java/io/IOException
    //   697	708	257	java/io/IOException
    //   715	729	257	java/io/IOException
    //   736	766	257	java/io/IOException
    //   773	783	257	java/io/IOException
    //   790	840	257	java/io/IOException
    //   847	866	257	java/io/IOException
    //   873	879	257	java/io/IOException
    //   891	899	257	java/io/IOException
    //   906	913	257	java/io/IOException
    //   925	934	257	java/io/IOException
    //   941	948	257	java/io/IOException
    //   955	960	257	java/io/IOException
    //   967	976	257	java/io/IOException
    //   307	312	314	java/io/IOException
    //   451	456	458	java/io/IOException
    //   442	446	490	java/io/IOException
    //   980	984	1002	java/io/IOException
    //   989	994	1035	java/io/IOException
    //   204	208	1068	java/io/IOException
    //   213	218	1101	java/io/IOException
    //   298	302	1133	java/io/IOException
    //   65	96	1166	org/json/JSONException
    //   1221	1226	1228	java/io/IOException
    //   1212	1216	1260	java/io/IOException
    //   65	96	1293	finally
    //   1303	1307	1319	java/io/IOException
    //   1312	1317	1352	java/io/IOException
    //   96	128	1385	finally
    //   135	141	1392	finally
    //   153	161	1392	finally
    //   227	234	1392	finally
    //   246	254	1392	finally
    //   265	294	1392	finally
    //   353	370	1392	finally
    //   377	384	1392	finally
    //   391	401	1392	finally
    //   408	417	1392	finally
    //   429	438	1392	finally
    //   530	539	1392	finally
    //   546	555	1392	finally
    //   562	567	1392	finally
    //   582	592	1392	finally
    //   606	617	1392	finally
    //   624	640	1392	finally
    //   647	656	1392	finally
    //   663	672	1392	finally
    //   679	687	1392	finally
    //   697	708	1392	finally
    //   715	729	1392	finally
    //   736	766	1392	finally
    //   773	783	1392	finally
    //   790	840	1392	finally
    //   847	866	1392	finally
    //   873	879	1392	finally
    //   891	899	1392	finally
    //   906	913	1392	finally
    //   925	934	1392	finally
    //   941	948	1392	finally
    //   955	960	1392	finally
    //   967	976	1392	finally
    //   1179	1208	1392	finally
    //   171	200	1403	finally
    //   96	128	1413	org/json/JSONException
    //   135	141	1420	org/json/JSONException
    //   153	161	1420	org/json/JSONException
    //   227	234	1420	org/json/JSONException
    //   246	254	1420	org/json/JSONException
    //   353	370	1420	org/json/JSONException
    //   377	384	1420	org/json/JSONException
    //   391	401	1420	org/json/JSONException
    //   408	417	1420	org/json/JSONException
    //   429	438	1420	org/json/JSONException
    //   530	539	1420	org/json/JSONException
    //   546	555	1420	org/json/JSONException
    //   562	567	1420	org/json/JSONException
    //   582	592	1420	org/json/JSONException
    //   606	617	1420	org/json/JSONException
    //   624	640	1420	org/json/JSONException
    //   647	656	1420	org/json/JSONException
    //   663	672	1420	org/json/JSONException
    //   679	687	1420	org/json/JSONException
    //   697	708	1420	org/json/JSONException
    //   715	729	1420	org/json/JSONException
    //   736	766	1420	org/json/JSONException
    //   773	783	1420	org/json/JSONException
    //   790	840	1420	org/json/JSONException
    //   847	866	1420	org/json/JSONException
    //   873	879	1420	org/json/JSONException
    //   891	899	1420	org/json/JSONException
    //   906	913	1420	org/json/JSONException
    //   925	934	1420	org/json/JSONException
    //   941	948	1420	org/json/JSONException
    //   955	960	1420	org/json/JSONException
    //   967	976	1420	org/json/JSONException
    //   65	96	1424	java/io/IOException
    //   96	128	1433	java/io/IOException
    //   65	96	1440	java/io/FileNotFoundException
    //   96	128	1450	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiav
 * JD-Core Version:    0.7.0.1
 */