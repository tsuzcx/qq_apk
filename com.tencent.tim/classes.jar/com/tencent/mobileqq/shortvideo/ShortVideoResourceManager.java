package com.tencent.mobileqq.shortvideo;

import aevk;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import anfs;
import angj;
import angm;
import angn;
import angp;
import angp.a;
import angp.c;
import angz;
import aoll;
import aolm;
import aolm.b;
import aomg;
import aomh;
import aomi;
import aomj;
import aopo;
import aqec;
import aqhq;
import aqiw;
import aqmr;
import awtn.b.b;
import awto.b;
import axce;
import axiy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class ShortVideoResourceManager
  implements angp.a, aolm.b, Manager
{
  private static ArrayList<angp.a> Az;
  private static a a = new a();
  public static long akY;
  private static final Object eL;
  private INetInfoHandler b = new angm(this);
  private final Object eM = new Object();
  private QQAppInterface mApp;
  private HashMap<String, b> nn = new HashMap();
  
  static
  {
    Az = new ArrayList();
    eL = new Object();
    dPt();
  }
  
  public ShortVideoResourceManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.b);
  }
  
  private static int A(List<SVConfigItem> paramList)
  {
    int j = 0;
    int i = 0;
    while (i < paramList.size())
    {
      j = anfs.a((SVConfigItem)paramList.get(i));
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  public static void H(QQAppInterface paramQQAppInterface, int paramInt)
  {
    
    if (paramInt != 3)
    {
      a(paramQQAppInterface, paramInt, paramQQAppInterface.a());
      return;
    }
    throw new Error("preDownloadShortVideoConfigData: call user type...");
  }
  
  private static void HZ(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  public static int Jk()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getInt("short_video_resource_version", 0);
  }
  
  private static int Jl()
  {
    int i = Jk();
    String str = zD();
    VideoEnvironment.k("ShortVideoResourceManager", "checkLocalConfigIsOK:version=" + i + " config_content" + str, null);
    if ((i != 0) && (!TextUtils.isEmpty(str)))
    {
      ArrayList localArrayList = new ArrayList();
      int j = a(str, localArrayList);
      VideoEnvironment.k("ShortVideoResourceManager", "checkLocalConfigIsOK:parseConfigData_errCode=" + j, null);
      i = j;
      if (j == 0) {
        i = A(localArrayList);
      }
      return i;
    }
    return -101;
  }
  
  public static void Qu(String paramString)
  {
    ThreadManager.getUIHandler().post(new ShortVideoResourceManager.15(paramString));
  }
  
  public static void UM(int paramInt)
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.k("ShortVideoResourceManager", "onReceiveFailed:status=" + a.getStatus() + " mGetConfigType" + a.dFv + ",serverResult=" + paramInt + ",LogSignature=" + zC(), null);
        if (a.dFu == 2)
        {
          a.dFu = 0;
          if (paramInt == 0)
          {
            VideoEnvironment.k("ShortVideoResourceManager", "onReceiveFailed[RESULT_NO_DATA]", null);
            a.mResultCode = 1;
            a.dFw = 0;
            paramInt = Az.size() - 1;
            if (paramInt >= 0)
            {
              if (Az.get(paramInt) == null) {
                break label238;
              }
              ((angp.a)Az.get(paramInt)).cu(a.mResultCode, a.dFw);
              break label238;
            }
          }
          else
          {
            VideoEnvironment.k("ShortVideoResourceManager", "onReceiveFailed[RESULT_FAILED]", null);
            a.mResultCode = -1;
            a.dFw = paramInt;
            continue;
          }
          Az.clear();
        }
      }
      finally {}
      for (;;)
      {
        return;
        VideoEnvironment.k("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveFailed] mConfigStatus=" + a.getStatus(), null);
      }
      label238:
      paramInt -= 1;
    }
  }
  
  public static void UN(int paramInt)
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.k("ShortVideoResourceManager", "onReceiveSuccess LogSignature=" + zC(), null);
        int i;
        if (a.dFu == 2)
        {
          a.dFu = 0;
          a.mResultCode = 0;
          i = Az.size() - 1;
          if (i >= 0)
          {
            if (Az.get(i) != null) {
              ((angp.a)Az.get(i)).cu(a.mResultCode, paramInt);
            }
          }
          else {
            Az.clear();
          }
        }
        else
        {
          VideoEnvironment.k("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=" + a.getStatus(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  /* Error */
  private static int a(angp.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_2
    //   5: getstatic 47	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a;
    //   8: getfield 238	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a:dFu	I
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +11 -> 24
    //   16: bipush 141
    //   18: istore_1
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: aload_0
    //   25: ifnonnull +9 -> 34
    //   28: bipush 140
    //   30: istore_1
    //   31: goto -12 -> 19
    //   34: getstatic 52	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:Az	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: invokevirtual 269	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   41: istore_3
    //   42: ldc 171
    //   44: new 173	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 271
    //   54: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_3
    //   58: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: aconst_null
    //   65: invokestatic 192	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: iload_2
    //   69: istore_1
    //   70: iload_3
    //   71: ifne -52 -> 19
    //   74: getstatic 52	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:Az	Ljava/util/ArrayList;
    //   77: aload_0
    //   78: invokevirtual 277	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: ldc 171
    //   84: ldc_w 279
    //   87: aconst_null
    //   88: invokestatic 192	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: iload_2
    //   92: istore_1
    //   93: goto -74 -> 19
    //   96: astore_0
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	parama	angp.a
    //   11	82	1	i	int
    //   4	88	2	j	int
    //   41	30	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	96	finally
    //   34	68	96	finally
    //   74	91	96	finally
  }
  
  public static int a(@Nullable QQAppInterface paramQQAppInterface, angp.a parama)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -101;
    }
    int j;
    do
    {
      return i;
      j = a(parama);
      axiy.i("ShortVideoResourceManager", "startUserDownloadConfigUpdateForce[checkLocalConfigIsOK]:errCode=" + j);
      if (j == -115)
      {
        a(paramQQAppInterface, parama);
        return 0;
      }
      i = j;
    } while (j != -116);
    return j;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, SVConfigItem paramSVConfigItem)
  {
    String str1 = ba(paramSVConfigItem.name);
    if (anfs.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      VideoEnvironment.k("ShortVideoResourceManager", "doNoNeedDownload: signature=" + str2, null);
      int i = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (i != 0)
      {
        angp.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, i);
        HZ(str1);
        VideoEnvironment.k("ShortVideoResourceManager", "doNoNeedDownload: errCode=" + i, null);
        return i;
      }
      angp.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, i);
      return i;
    }
    VideoEnvironment.k("ShortVideoResourceManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = anfs.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    VideoEnvironment.k("ShortVideoResourceManager", "[userUncompressZipResource]needRestore=" + bool + ",keyName=" + paramString1, null);
    if (bool) {}
    for (paramInt = -118;; paramInt = 0)
    {
      VideoEnvironment.k("ShortVideoResourceManager", "[userUncompressZipResource]errCode=" + paramInt + ",keyName=" + paramString1, null);
      return paramInt;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList)
  {
    int i = Jk();
    paramQQAppInterface = zD();
    if ((i == 0) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      bool = ak("", 0);
      VideoEnvironment.k("ShortVideoResourceManager", "[checkConfigResourceIsOK]:version=" + i + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
      i = -101;
    }
    int j;
    do
    {
      return i;
      i = a(paramQQAppInterface, paramList);
      VideoEnvironment.k("ShortVideoResourceManager", "[checkConfigResourceIsOK]parseConfigData_errCode=" + i, null);
      if (i != 0)
      {
        paramList.clear();
        bool = ak("", 0);
        VideoEnvironment.k("ShortVideoResourceManager", "[doUserDownloadResource]parseConfigData:errCode=" + i + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
        return i;
      }
      j = A(paramList);
      i = j;
    } while (j == 0);
    paramList.clear();
    boolean bool = ak("", 0);
    VideoEnvironment.k("ShortVideoResourceManager", "[doUserDownloadResource]checkResourceVersion:errCode=" + j + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
    return j;
  }
  
  public static int a(String paramString, List<SVConfigItem> paramList)
  {
    try
    {
      paramString = new JSONArray(paramString);
      j = paramString.length();
      if (j > 0) {
        break label211;
      }
      VideoEnvironment.k("ShortVideoResourceManager", "parseConfigData: arrayLength=" + j, null);
      return -100;
    }
    catch (JSONException paramString)
    {
      int j;
      SVConfigItem localSVConfigItem;
      if (!QLog.isColorLevel()) {
        break label124;
      }
      QLog.d("ShortVideoResourceManager", 2, "parseConfigData[JSONException]", paramString);
      paramList.clear();
      for (i = -100;; i = 0)
      {
        VideoEnvironment.k("ShortVideoResourceManager", "parseConfigData:errCode=" + i, null);
        return i;
        paramList.add(localSVConfigItem);
        i += 1;
        break;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        label124:
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoResourceManager", 2, "parseConfigData[OutOfMemoryError]", paramString);
        }
        paramList.clear();
        int i = -100;
        continue;
        label211:
        i = 0;
      }
    }
    if (i < j)
    {
      localSVConfigItem = (SVConfigItem)aqec.convertFrom(paramString.getJSONObject(i), SVConfigItem.class);
      if (localSVConfigItem == null)
      {
        VideoEnvironment.k("ShortVideoResourceManager", "parseConfigData:item=null i=" + i, null);
        paramList.clear();
        return -100;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, angp.a parama)
  {
    for (;;)
    {
      try
      {
        if (a.dFu == 0)
        {
          if (paramInt == 3)
          {
            i = Jl();
            if (i == 0)
            {
              if (parama != null) {
                parama.cu(1, i);
              }
              return;
            }
          }
          int i = Jk();
          String str = zD();
          VideoEnvironment.k("ShortVideoResourceManager", "doUserDownload[Begin download print]:version=" + i + " config_content" + str, null);
          VideoEnvironment.k("ShortVideoResourceManager", "downloadShortVideoConfigData LogSignature=" + zC(), null);
          a.dFu = 1;
          a.dFv = paramInt;
          a.mResultCode = 0;
          a.dFw = 0;
          aevk.w(paramQQAppInterface, paramInt);
          VideoEnvironment.k("ShortVideoResourceManager", "downloadShortvideoConfigData[request started]:status=" + a.getStatus() + " mGetConfigType" + a.dFv, null);
          if (parama == null) {
            continue;
          }
          boolean bool = Az.contains(parama);
          VideoEnvironment.k("ShortVideoResourceManager", "downloadShortVideoConfigData contains=" + bool, null);
          if (bool) {
            continue;
          }
          if (paramInt == 3) {
            break label316;
          }
          Az.add(0, parama);
          VideoEnvironment.k("ShortVideoResourceManager", "downloadShortVideoConfigData: add callBack OK...", null);
          continue;
        }
        VideoEnvironment.k("ShortVideoResourceManager", "downloadShortvideoConfigData[request pending]:status=" + a.getStatus() + " mGetConfigType" + a.dFv, null);
      }
      finally {}
      continue;
      label316:
      Az.add(parama);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, angp.a parama)
  {
    a(paramQQAppInterface, 3, parama);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SVConfigItem paramSVConfigItem, d paramd)
  {
    axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin] - BEING -, itemConfig.name =" + paramSVConfigItem.name);
    Object localObject = zE();
    String str = zF();
    HZ((String)localObject + paramSVConfigItem.name);
    HZ(str + paramSVConfigItem.name);
    paramd = new angn(paramSVConfigItem, paramQQAppInterface, paramd);
    localObject = new aoll();
    ((aoll)localObject).f = paramd;
    ((aoll)localObject).mHttpMethod = 0;
    if ((angz.awV()) && (paramSVConfigItem.check64BitReady())) {}
    for (((aoll)localObject).bZ = paramSVConfigItem.arm64v8a_url;; ((aoll)localObject).bZ = paramSVConfigItem.armv7a_url)
    {
      ((aoll)localObject).atY = (str + paramSVConfigItem.name);
      ((aoll)localObject).dPo = 0;
      ((aoll)localObject).bw(paramSVConfigItem.name);
      axce.a().a(paramQQAppInterface).a((aomg)localObject);
      axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin] - END -, itemConfig.name =" + paramSVConfigItem.name);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, c paramc)
  {
    a(paramQQAppInterface, paramc, "new_qq_android_native_short_video_");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, c paramc, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramc != null) {
        paramQQAppInterface.a().a(paramc, paramString);
      }
      return;
    }
    VideoEnvironment.k("ShortVideoResourceManager", "clearResourceCallBackWithNamePrefixSafe: app=null...", null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, c paramc)
  {
    ThreadManager.excute(new ShortVideoResourceManager.4(paramQQAppInterface, paramList, paramc), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, c paramc, String paramString)
  {
    ThreadManager.excute(new ShortVideoResourceManager.10(paramQQAppInterface, paramList, paramc, paramString), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, d paramd, String paramString)
  {
    axiy.i("ShortVideoResourceManager", "[doUserDownloadResourceWithoutLogin] - BEGIN -");
    ThreadManager.excute(new ShortVideoResourceManager.11(paramQQAppInterface, paramList, paramd, paramString), 128, null, false);
    axiy.i("ShortVideoResourceManager", "[doUserDownloadResourceWithoutLogin] - BEGIN -");
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SVConfigItem paramSVConfigItem)
  {
    String str = ba(paramSVConfigItem.name);
    VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload:name=" + paramSVConfigItem.name, null);
    angp.c localc = angp.a(paramSVConfigItem.name);
    VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload:versionCode=" + paramSVConfigItem.versionCode + " status.version" + localc.version + ",status.lastErr=" + localc.dFx, null);
    if (!anfs.a(paramQQAppInterface, paramSVConfigItem)) {
      VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload:userDownload=false", null);
    }
    label236:
    label243:
    do
    {
      do
      {
        do
        {
          return false;
          if (paramSVConfigItem.versionCode <= localc.version) {
            break label243;
          }
          if (localc.version != 0) {
            break label236;
          }
          VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload:status.version=0", null);
          if (!new File(str).exists()) {
            break;
          }
          VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload:[exists]filePath=" + str, null);
          i = b(paramSVConfigItem);
          VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload[zipVerifyMd5]:errCode=" + i, null);
        } while (i == 0);
        HZ(str);
        return true;
        HZ(str);
        return true;
      } while (paramSVConfigItem.versionCode != localc.version);
      if (localc.status != 0)
      {
        VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload[No equal]:status=" + localc.status + ",version" + localc.version, null);
        HZ(str);
        return true;
      }
      boolean bool = oZ(paramSVConfigItem.name);
      VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:exist=" + bool, null);
      if (!bool) {
        return true;
      }
      int i = b(paramSVConfigItem);
      VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:errCode=" + i, null);
      if (i != 0)
      {
        HZ(str);
        return true;
      }
    } while (localc.dFx == 0);
    VideoEnvironment.k("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:status=" + localc.status + ",lastErr" + localc.dFx, null);
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SVConfigItem paramSVConfigItem, d paramd)
  {
    axiy.i("ShortVideoResourceManager", "[packageAlreadyUnzippedAndExist] - BEGIN -");
    String str = ba(paramSVConfigItem.name);
    boolean bool = anfs.R(paramQQAppInterface, paramSVConfigItem.name);
    if ((bool) && (paramd != null)) {
      paramd.Z(paramSVConfigItem.name, 1, str);
    }
    axiy.i("ShortVideoResourceManager", "[packageAlreadyUnzippedAndExist] - END -, alreadyExists=" + bool);
    return bool;
  }
  
  private boolean a(SVConfigItem paramSVConfigItem, c paramc, boolean[] paramArrayOfBoolean)
  {
    boolean bool1 = true;
    String str = ba(paramSVConfigItem.name);
    boolean bool2 = anfs.R(this.mApp, paramSVConfigItem.name);
    VideoEnvironment.k("ShortVideoResourceManager", "doRealSendRequest:alreadyExists=" + bool2, null);
    paramArrayOfBoolean[0] = bool2;
    if (bool2)
    {
      VideoEnvironment.k("ShortVideoResourceManager", "doRealSendRequest:onDownloadFinish...", null);
      if (paramc != null)
      {
        if ((!paramSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) && (!paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_"))) {
          break label211;
        }
        paramc.o(paramSVConfigItem.name, 1, str);
      }
    }
    for (;;)
    {
      VideoEnvironment.k("ShortVideoResourceManager", "doRealSendRequest:itemConfig.versionCode=" + paramSVConfigItem.versionCode, null);
      bool2 = a(this.mApp, paramSVConfigItem);
      bool1 = bool2;
      if (!bool2)
      {
        int i = a(this.mApp, paramSVConfigItem);
        VideoEnvironment.k("ShortVideoResourceManager", "doRealSendRequest:doNoNeedDownload_errCode=" + i, null);
        bool1 = bool2;
        if (i == 0) {}
      }
      return bool1;
      label211:
      paramc.o(paramSVConfigItem.name, 0, str);
    }
  }
  
  private static boolean ak(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).edit();
    localEditor.putString("short_video_res_config_key", paramString);
    localEditor.putInt("short_video_resource_version", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| saveContentOK，config_content = " + paramString);
    }
    return localEditor.commit();
  }
  
  public static int b(QQAppInterface paramQQAppInterface, angp.a parama)
  {
    int i = 0;
    dPt();
    int j = Jl();
    VideoEnvironment.k("ShortVideoResourceManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + j, null);
    if (j != 0)
    {
      boolean bool = aqiw.isNetworkAvailable(null);
      VideoEnvironment.k("ShortVideoResourceManager", "startUserDownloadConfig:netUsable=" + bool, null);
      j = a(parama);
      if (j == -115)
      {
        a(paramQQAppInterface, parama);
        VideoEnvironment.k("ShortVideoResourceManager", "startUserDownloadConfig[end]:errCode=" + i, null);
        return i;
      }
      i = j;
      if (j != -116) {}
    }
    for (;;)
    {
      break;
      i = j;
      if (parama != null)
      {
        parama.cu(1, 0);
        i = j;
      }
    }
  }
  
  private static int b(SVConfigItem paramSVConfigItem)
  {
    String str = zE();
    str = str + paramSVConfigItem.name;
    if ((angz.awV()) && (paramSVConfigItem.check64BitReady())) {
      return d(paramSVConfigItem.name, paramSVConfigItem.arm64v8a_md5, paramSVConfigItem.armv7a_md5, str);
    }
    return d(paramSVConfigItem.name, paramSVConfigItem.armv7a_md5, paramSVConfigItem.arm64v8a_md5, str);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, c paramc)
  {
    a(paramQQAppInterface, paramc, "new_qq_android_native_short_filter_");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, c paramc)
  {
    ThreadManager.excute(new ShortVideoResourceManager.5(paramQQAppInterface, paramList, paramc), 128, null, false);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, c paramc, String paramString)
  {
    Object localObject = eL;
    int i = 0;
    SVConfigItem localSVConfigItem;
    label81:
    int j;
    for (;;)
    {
      try
      {
        if (i < paramList.size())
        {
          localSVConfigItem = (SVConfigItem)paramList.get(i);
          if (!localSVConfigItem.name.startsWith(paramString)) {
            break;
          }
          if (paramQQAppInterface != null) {
            continue;
          }
          VideoEnvironment.k("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
          if (paramc != null) {
            paramc.o(localSVConfigItem.name, -1501, "");
          }
        }
        return;
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        VideoEnvironment.k("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: needDownload=" + bool, null);
        if (bool)
        {
          paramQQAppInterface = paramQQAppInterface.a();
          if (paramQQAppInterface == null) {
            continue;
          }
          paramQQAppInterface.a(localSVConfigItem, paramc);
          continue;
        }
        paramList = ba(localSVConfigItem.name);
      }
      finally {}
      j = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.k("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = " + localSVConfigItem.name + ", errCode=" + j, null);
      if (paramc != null)
      {
        if (localSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) {
          break label273;
        }
        i = j;
        if (localSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {
          break label273;
        }
      }
    }
    for (;;)
    {
      paramc.o(localSVConfigItem.name, i, paramList);
      break label81;
      i += 1;
      break;
      label273:
      i = j;
      if (j == 0) {
        i = 1;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, d paramd, String paramString)
  {
    axiy.i("ShortVideoResourceManager", "[doUserDownloadResourceWithoutLoginInternal] - BEGIN -");
    SVConfigItem localSVConfigItem;
    label100:
    String str;
    int j;
    do
    {
      synchronized (eL)
      {
        paramList = paramList.iterator();
        do
        {
          while (paramList.hasNext())
          {
            localSVConfigItem = (SVConfigItem)paramList.next();
            if (localSVConfigItem.name.startsWith(paramString))
            {
              if (paramQQAppInterface != null) {
                break label100;
              }
              axiy.e("ShortVideoResourceManager", "[doUserDownloadResourceWithoutLoginInternal], app=null");
              if (paramd != null) {
                paramd.Z(localSVConfigItem.name, -1501, "");
              }
            }
          }
          axiy.i("ShortVideoResourceManager", "[doUserDownloadResourceWithoutLoginInternal] - BEGIN -");
          return;
          boolean bool = a(paramQQAppInterface, localSVConfigItem);
          axiy.i("ShortVideoResourceManager", "[doUserDownloadResourceWithoutLoginInternal], needDownload=" + bool);
          if (!bool) {
            break;
          }
        } while (a(paramQQAppInterface, localSVConfigItem, paramd));
        a(paramQQAppInterface, localSVConfigItem, paramd);
      }
      str = ba(localSVConfigItem.name);
      j = a(paramQQAppInterface, localSVConfigItem);
      axiy.i("ShortVideoResourceManager", "[doUserDownloadResourceWithoutLoginInternal], doNoNeedDownload, itemConfig.name = " + localSVConfigItem.name + ", errCode=" + j);
    } while (paramd == null);
    int i;
    if (!localSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_"))
    {
      i = j;
      if (localSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {}
    }
    for (;;)
    {
      paramd.Z(localSVConfigItem.name, i, str);
      break;
      i = j;
      if (j == 0) {
        i = 1;
      }
    }
  }
  
  private static boolean bA(String paramString1, String paramString2)
  {
    synchronized (eL)
    {
      VideoEnvironment.k("ShortVideoResourceManager", "[onResp]renameResourceZip destPath=" + paramString1 + ",outPath=" + paramString2, null);
      paramString1 = new File(paramString1);
      if (paramString1.exists())
      {
        paramString1.delete();
        VideoEnvironment.k("ShortVideoResourceManager", "[onResp]renameResourceZip rename  destFile already exists[delete]...", null);
      }
      paramString2 = new File(paramString2);
      long l1 = paramString2.length();
      boolean bool = paramString2.renameTo(paramString1);
      VideoEnvironment.k("ShortVideoResourceManager", "[onResp]renameResourceZip orgLength=" + l1 + ",success=" + bool, null);
      if (bool)
      {
        bool = paramString1.exists();
        long l2 = paramString1.length();
        VideoEnvironment.k("ShortVideoResourceManager", "[onResp]renameResourceZip destExists=" + bool + ",destLength=" + l2, null);
        if ((bool) && (l2 == l1)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public static String ba(String paramString)
  {
    String str = zE();
    return str + paramString;
  }
  
  private void c(aomh paramaomh)
  {
    Object localObject1 = paramaomh.b;
    ??? = ((aomg)localObject1).atY;
    VideoEnvironment.k("ShortVideoResourceManager", "[onResp]filePath=" + (String)??? + ",resp.mResult=" + paramaomh.mResult + ",mHttpCode=" + paramaomh.dPy + ",mErrCode=" + paramaomh.mErrCode + ",mErrDesc=" + paramaomh.clO, null);
    localObject1 = (String)((aomg)localObject1).U();
    if (localObject1 == null) {}
    for (;;)
    {
      b localb;
      Object localObject4;
      int j;
      int i;
      synchronized (this.eM)
      {
        localb = (b)this.nn.get(localObject1);
        localObject4 = localb.bYT;
        j = localb.mVersionCode;
        String str = zE();
        ??? = str + (String)localObject1;
        if (paramaomh.mResult == 0)
        {
          i = j((String)localObject1, (String)localObject4, (String)???);
          VideoEnvironment.k("ShortVideoResourceManager", "[onResp]verifyResource keyName=" + (String)localObject1 + ",errCode=" + i, null);
          if (i != 0)
          {
            if (i == -108)
            {
              boolean bool = bA(str + (String)localObject1 + "error", (String)???);
              VideoEnvironment.k("ShortVideoResourceManager", "[onResp]renameResourceZip, save error file, success=" + bool, null);
            }
            HZ((String)???);
            VideoEnvironment.k("ShortVideoResourceManager", "[onResp]verifyResource clearDownloadTempFile errCode=" + i, null);
            angp.a((String)localObject1, j, 0, i);
            label337:
            VideoEnvironment.k("ShortVideoResourceManager", "[onRespAsync]errCode=" + i + ",saveFilePath=" + (String)??? + ",key=" + (String)localObject1, null);
          }
        }
      }
      synchronized (this.eM)
      {
        localb.mDownloadStatus = 3;
        int k = localb.AA.size();
        j = 0;
        label412:
        if (j < k) {
          for (;;)
          {
            try
            {
              if (localb.AA.get(j) != null)
              {
                if (localObject1 != null) {
                  ((c)localb.AA.get(j)).o((String)localObject1, i, (String)???);
                }
                localObject4 = (aopo)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(193);
                if ((localObject1 != null) && (((String)localObject1).startsWith("new_qq_android_native_short_filter_")) && (((aopo)localObject4).isEnable()) && (!axce.a().aOs()))
                {
                  if (i != 0) {
                    continue;
                  }
                  ((aopo)localObject4).be((String)paramaomh.nR.get("param_url"), paramaomh.apU);
                }
              }
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
            {
              continue;
            }
            j += 1;
            break label412;
            paramaomh = finally;
            throw paramaomh;
            if (bA((String)???, (String)???))
            {
              ??? = (String)localObject4 + '_' + j;
              i = a(this.mApp, (String)localObject1, (String)???, (String)???, j);
              VideoEnvironment.k("ShortVideoResourceManager", "[onRespAsync]signature=" + (String)??? + ",errCode=" + i + ",key=" + (String)localObject1, null);
              break;
            }
            i = -3;
            HZ((String)???);
            HZ((String)???);
            break;
            angp.a((String)localObject1, j, 1, -117);
            HZ((String)???);
            VideoEnvironment.k("ShortVideoResourceManager", "[onResp]filePath=" + (String)??? + ",resp.mResult=" + paramaomh.mResult + ",mErrDesc=" + paramaomh.clO + ",mErrDesc=" + paramaomh.clO, null);
            i = -117;
            break label337;
            ((aopo)localObject4).be((String)paramaomh.nR.get("param_url"), -1L);
          }
        }
        localb.AA.clear();
        this.nn.remove(localObject1);
        return;
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, c paramc)
  {
    a(paramQQAppInterface, paramc, "new_qq_android_native_art_filter_");
  }
  
  private static void c(QQAppInterface paramQQAppInterface, HashMap<SVConfigItem, c> paramHashMap)
  {
    for (;;)
    {
      SVConfigItem localSVConfigItem;
      c localc;
      synchronized (eL)
      {
        Iterator localIterator = paramHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localSVConfigItem = (SVConfigItem)localIterator.next();
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        localc = (c)paramHashMap.get(localSVConfigItem);
        VideoEnvironment.k("ShortVideoResourceManager", "doUserDownloadAllResourceSync:name=" + localSVConfigItem.name + ",needDownload=" + bool, null);
        if (bool) {
          paramQQAppInterface.a().a(localSVConfigItem, localc);
        }
      }
      String str = ba(localSVConfigItem.name);
      int i = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.k("ShortVideoResourceManager", "doUserDownloadAllResourceSync:[doNoNeedDownload] errCode=" + i, null);
      if (localc != null) {
        localc.o(localSVConfigItem.name, i, str);
      }
      VideoEnvironment.k("ShortVideoResourceManager", "doUserDownloadAllResourceSync: [onDownloadFinish]name=" + localSVConfigItem.name, null);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, c paramc)
  {
    ThreadManager.excute(new ShortVideoResourceManager.7(paramQQAppInterface, paramList, paramc), 128, null, false);
  }
  
  /* Error */
  private static int d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: ldc 171
    //   8: iconst_2
    //   9: new 173	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 880
    //   23: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 882
    //   33: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 643	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_3
    //   47: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +6 -> 56
    //   53: bipush 151
    //   55: ireturn
    //   56: aload_1
    //   57: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +6 -> 66
    //   63: bipush 150
    //   65: ireturn
    //   66: new 133	java/io/File
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 5
    //   76: aload 5
    //   78: invokevirtual 138	java/io/File:exists	()Z
    //   81: ifne +48 -> 129
    //   84: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +39 -> 126
    //   90: ldc 171
    //   92: iconst_2
    //   93: new 173	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   100: aload_0
    //   101: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 884
    //   107: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 886
    //   117: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 888	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: bipush 149
    //   128: ireturn
    //   129: aconst_null
    //   130: astore 4
    //   132: aload_3
    //   133: invokestatic 894	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   136: invokestatic 900	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   139: astore_3
    //   140: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +43 -> 186
    //   146: ldc 171
    //   148: iconst_2
    //   149: new 173	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   156: aload_0
    //   157: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 902
    //   163: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 904
    //   173: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_3
    //   177: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 643	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_1
    //   187: aload_3
    //   188: invokevirtual 907	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   191: ifeq +15 -> 206
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_3
    //   197: aload 5
    //   199: invokestatic 913	aszr:getFileMD5String	(Ljava/io/File;)Ljava/lang/String;
    //   202: astore_3
    //   203: goto -63 -> 140
    //   206: aload_2
    //   207: invokestatic 917	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   210: ifne +119 -> 329
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 907	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   218: ifne +111 -> 329
    //   221: new 62	java/util/HashMap
    //   224: dup
    //   225: invokespecial 63	java/util/HashMap:<init>	()V
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 919
    //   233: aload_0
    //   234: invokevirtual 923	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload_2
    //   239: ldc_w 925
    //   242: aload_1
    //   243: invokevirtual 923	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload_3
    //   248: ifnull +53 -> 301
    //   251: aload_2
    //   252: ldc_w 927
    //   255: aload_3
    //   256: invokevirtual 923	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload_2
    //   261: ldc_w 929
    //   264: aload 5
    //   266: invokevirtual 720	java/io/File:length	()J
    //   269: invokestatic 933	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   272: invokevirtual 923	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: pop
    //   276: invokestatic 938	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   279: invokestatic 943	anpc:a	(Landroid/content/Context;)Lanpc;
    //   282: ldc_w 341
    //   285: ldc_w 945
    //   288: iconst_1
    //   289: lconst_0
    //   290: lconst_0
    //   291: aload_2
    //   292: ldc_w 341
    //   295: invokevirtual 949	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   298: goto +31 -> 329
    //   301: ldc_w 341
    //   304: astore_3
    //   305: goto -54 -> 251
    //   308: astore_0
    //   309: ldc 171
    //   311: iconst_1
    //   312: ldc_w 951
    //   315: aload_0
    //   316: invokestatic 953	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: goto +10 -> 329
    //   322: astore_3
    //   323: aload 4
    //   325: astore_3
    //   326: goto -186 -> 140
    //   329: bipush 148
    //   331: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString1	String
    //   0	332	1	paramString2	String
    //   0	332	2	paramString3	String
    //   0	332	3	paramString4	String
    //   130	194	4	localObject	Object
    //   74	191	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   132	140	196	java/lang/UnsatisfiedLinkError
    //   221	247	308	java/lang/Exception
    //   251	298	308	java/lang/Exception
    //   197	203	322	java/lang/Exception
  }
  
  public static void d(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList, c paramc)
  {
    ThreadManager.excute(new ShortVideoResourceManager.9(paramQQAppInterface, paramList, paramc), 128, null, false);
  }
  
  /* Error */
  public static void dPo()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 171
    //   5: new 173	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 960
    //   15: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 235	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:zC	()Ljava/lang/String;
    //   21: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokestatic 192	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: getstatic 47	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a;
    //   34: getfield 238	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a:dFu	I
    //   37: iconst_1
    //   38: if_icmpne +14 -> 52
    //   41: getstatic 47	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a;
    //   44: iconst_2
    //   45: putfield 238	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a:dFu	I
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: ldc 171
    //   54: new 173	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 962
    //   64: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 47	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a;
    //   70: invokevirtual 222	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a:getStatus	()Ljava/lang/String;
    //   73: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aconst_null
    //   80: invokestatic 192	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: getstatic 47	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a;
    //   86: getfield 238	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$a:dFu	I
    //   89: ifne -41 -> 48
    //   92: getstatic 52	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:Az	Ljava/util/ArrayList;
    //   95: invokevirtual 247	java/util/ArrayList:size	()I
    //   98: istore_0
    //   99: ldc 171
    //   101: new 173	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 964
    //   111: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_0
    //   115: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aconst_null
    //   122: invokestatic 192	com/tencent/mobileqq/shortvideo/VideoEnvironment:k	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: iload_0
    //   126: ifle -78 -> 48
    //   129: goto -81 -> 48
    //   132: astore_1
    //   133: ldc 2
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   98	28	0	i	int
    //   132	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	48	132	finally
    //   52	125	132	finally
  }
  
  public static void dPp()
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.k("ShortVideoResourceManager", "onReceiveNoDataUpdate LogSignature=" + zC(), null);
        int i;
        if (a.dFu == 2)
        {
          a.dFu = 0;
          a.mResultCode = 1;
          i = Az.size() - 1;
          if (i >= 0)
          {
            if (Az.get(i) != null) {
              ((angp.a)Az.get(i)).cu(a.mResultCode, 0);
            }
          }
          else {
            Az.clear();
          }
        }
        else
        {
          VideoEnvironment.k("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=" + a.getStatus(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  private void dPs()
  {
    synchronized (this.eM)
    {
      Iterator localIterator = this.nn.values().iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb != null) && (localb.AA != null))
        {
          int i = 0;
          while (i < localb.AA.size())
          {
            ((c)localb.AA.get(i)).aFW();
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  private static void dPt()
  {
    File localFile = new File(zE());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(zF());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private static void fT(String paramString, int paramInt)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      VideoEnvironment.UO(paramInt);
    }
    while (!paramString.startsWith("new_qq_android_native_short_filter_")) {
      return;
    }
  }
  
  private static int j(String paramString1, String paramString2, String paramString3)
  {
    return d(paramString1, paramString2, "", paramString3);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, List<SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.3(paramQQAppInterface, paramList), 128, null, false);
  }
  
  private void mr(List<SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.13(this, paramList), 128, null, false);
  }
  
  private void ms(List<SVConfigItem> paramList)
  {
    Object localObject = eL;
    int i = 0;
    for (;;)
    {
      SVConfigItem localSVConfigItem;
      try
      {
        if (i >= paramList.size()) {
          break label119;
        }
        localSVConfigItem = (SVConfigItem)paramList.get(i);
        if (!localSVConfigItem.predownload) {
          VideoEnvironment.k("ShortVideoResourceManager", "preDownloadResource:parseConfigData predownload=false", null);
        } else if (a(this.mApp, localSVConfigItem)) {
          a(localSVConfigItem, null);
        }
      }
      finally {}
      int j = a(this.mApp, localSVConfigItem);
      VideoEnvironment.k("ShortVideoResourceManager", "preDownloadResourceSync:needDownload=false [doNoNeedDownload] errCode=" + j, null);
      break label123;
      label119:
      return;
      label123:
      i += 1;
    }
  }
  
  private static boolean oZ(String paramString)
  {
    String str = zE();
    return aqhq.fileExists(str + paramString);
  }
  
  private static String zC()
  {
    return "hashCode=" + a.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
  }
  
  public static String zD()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getString("short_video_res_config_key", "");
  }
  
  public static String zE()
  {
    return awtn.b.b.cSI;
  }
  
  private static String zF()
  {
    return awto.b.PATH + File.separator;
  }
  
  public void a(SVConfigItem paramSVConfigItem, c paramc)
  {
    for (;;)
    {
      Object localObject2;
      boolean bool;
      synchronized (this.eM)
      {
        localObject2 = (b)this.nn.get(paramSVConfigItem.name);
        if (localObject2 != null) {
          break label361;
        }
        localObject2 = new boolean[1];
        bool = a(paramSVConfigItem, paramc, (boolean[])localObject2);
        if (localObject2[0] != 0) {
          paramc = null;
        }
        VideoEnvironment.k("ShortVideoResourceManager", "doRealSendRequest:doDownload=" + bool, null);
        aoll localaoll;
        if (bool)
        {
          localObject2 = zE();
          HZ((String)localObject2 + paramSVConfigItem.name);
          localObject2 = zF();
          HZ((String)localObject2 + paramSVConfigItem.name);
          localaoll = new aoll();
          localaoll.f = this;
          if ((angz.awV()) && (paramSVConfigItem.check64BitReady()))
          {
            localaoll.bZ = paramSVConfigItem.arm64v8a_url;
            localaoll.mHttpMethod = 0;
            localaoll.atY = ((String)localObject2 + paramSVConfigItem.name);
            localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
            localaoll.cMX = true;
            localaoll.bw(paramSVConfigItem.name);
            localObject2 = new b(localaoll);
            ((b)localObject2).mVersionCode = paramSVConfigItem.versionCode;
            if ((!angz.awV()) || (!paramSVConfigItem.check64BitReady())) {
              break label349;
            }
            ((b)localObject2).bYT = paramSVConfigItem.arm64v8a_md5;
            if (paramc != null)
            {
              ((b)localObject2).AA.add(paramc);
              VideoEnvironment.k("ShortVideoResourceManager", "sendRequest[session][new]add callBack ok...", null);
            }
            this.nn.put(paramSVConfigItem.name, localObject2);
            ((b)localObject2).startDownload();
          }
        }
        else
        {
          return;
        }
        localaoll.bZ = paramSVConfigItem.armv7a_url;
      }
      label349:
      ((b)localObject2).bYT = paramSVConfigItem.armv7a_md5;
      continue;
      label361:
      if (((b)localObject2).mDownloadStatus == 0)
      {
        ((b)localObject2).mVersionCode = paramSVConfigItem.versionCode;
        if ((angz.awV()) && (paramSVConfigItem.check64BitReady())) {}
        for (((b)localObject2).bYT = paramSVConfigItem.arm64v8a_md5;; ((b)localObject2).bYT = paramSVConfigItem.armv7a_md5)
        {
          if (paramc != null)
          {
            bool = ((b)localObject2).AA.contains(paramc);
            VideoEnvironment.k("ShortVideoResourceManager", "sendRequest[oldSession][start]contains=" + bool, null);
            if (!bool)
            {
              ((b)localObject2).AA.add(paramc);
              VideoEnvironment.k("ShortVideoResourceManager", "sendRequest[oldSession][start]add callBack ok...", null);
            }
          }
          ((b)localObject2).startDownload();
          break;
        }
      }
      if (paramc != null)
      {
        bool = ((b)localObject2).AA.contains(paramc);
        VideoEnvironment.k("ShortVideoResourceManager", "sendRequest[oldSession][pending]contains=" + bool, null);
        if (!bool)
        {
          ((b)localObject2).AA.add(paramc);
          VideoEnvironment.k("ShortVideoResourceManager", "sendRequest[oldSession][pending]add callBack ok...", null);
        }
      }
    }
  }
  
  public void a(c paramc, String paramString)
  {
    synchronized (this.eM)
    {
      Iterator localIterator = this.nn.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if ((localObject2 != null) && (((String)localObject2).startsWith(paramString)))
        {
          localObject2 = (b)this.nn.get(localObject2);
          if ((localObject2 != null) && (paramc != null)) {
            ((b)localObject2).AA.remove(paramc);
          }
        }
      }
    }
  }
  
  public int am(String paramString, int paramInt)
  {
    QLog.d("ShortVideoResourceManager", 1, "updateShortVideoOtherConfigOnly|received save version: " + paramInt + ", config_content: " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ShortVideoResourceManager", 1, "updateShortVideoOtherConfigOnly| version: " + paramInt + ",config_content: " + paramString);
      return -101;
    }
    boolean bool = ak(paramString, paramInt);
    QLog.d("ShortVideoResourceManager", 1, "updateShortVideoOtherConfigOnly| saveContentOK: " + bool);
    if (bool) {
      return 0;
    }
    return -128;
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:result=" + paramInt1 + ",serverError" + paramInt2 + ",getType=" + a.dFv, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0) {
        VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:RESULT_OK,saveError=" + paramInt2, null);
      }
    }
    else {
      return;
    }
    paramInt1 = Jk();
    String str = zD();
    boolean bool;
    if ((paramInt1 == 0) || (TextUtils.isEmpty(str)))
    {
      bool = ak("", 0);
      VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:version=" + paramInt1 + ",successReset=" + bool + ",config_content=" + str, null);
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    paramInt1 = a(str, localArrayList);
    VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + paramInt1, null);
    if (paramInt1 == -100)
    {
      bool = ak("", 0);
      VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + paramInt1 + ",successReset=" + bool, null);
      return;
    }
    if (paramInt1 == 0)
    {
      paramInt1 = A(localArrayList);
      if (paramInt1 != 0)
      {
        bool = ak("", 0);
        VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:checkResourceVersion errCode=" + paramInt1 + ",successReset=" + bool, null);
        return;
      }
      mr(localArrayList);
      VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:success,sendRequest or no needDownload or predownload = false...", null);
      return;
    }
    VideoEnvironment.k("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData Other error code ...", null);
  }
  
  public int d(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent|received save version: " + paramInt + ", config_content: " + paramString);
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| version: " + paramInt + ",config_content: " + paramString);
        i = j;
      }
      return i;
    }
    boolean bool = ak(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| saveContentOK: " + bool);
    }
    if (bool) {}
    for (paramInt = 0;; paramInt = -128)
    {
      i = paramInt;
      if (!bool) {
        break;
      }
      bool = angj.g(this.mApp, false);
      i = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| downloadState: " + bool);
      return paramInt;
    }
  }
  
  public void dPq()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.b);
  }
  
  public void dPr()
  {
    ??? = new ArrayList();
    ((List)???).add("new_qq_android_native_short_video_");
    ((List)???).add("new_qq_android_native_short_filter_");
    ((List)???).add("new_qq_android_native_art_filter_");
    ((List)???).add("new_qq_android_native_portrait_filter_");
    ((List)???).add("new_qq_android_native_short_other_");
    ((List)???).add("new_qq_android_native_ptu_res_");
    Iterator localIterator = ((List)???).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      synchronized (this.eM)
      {
        localObject3 = (b)this.nn.get(localObject3);
        if (localObject3 != null) {
          ((b)localObject3).AA.clear();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    try
    {
      int i = Az.size();
      Az.clear();
      QLog.d("ShortVideoResourceManager", 1, new Object[] { "onDestroy sizeCallBack = ", Integer.valueOf(i) });
      AppNetConnInfo.unregisterNetInfoHandler(this.b);
      angj.destory();
      dPr();
      return;
    }
    finally {}
  }
  
  public final void onResp(aomh paramaomh)
  {
    ThreadManager.post(new ShortVideoResourceManager.14(this, paramaomh), 5, null, false);
  }
  
  public final void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    String str = (String)???.U();
    if (str == null) {}
    VideoEnvironment.k("ShortVideoResourceManager", "[onUpdateProgeress]curOffset=" + paramLong1 + ",totalLen=" + paramLong2 + ",key=" + str, null);
    for (;;)
    {
      int i;
      synchronized (this.eM)
      {
        b localb = (b)this.nn.get(str);
        localb.mDownloadStatus = 2;
        int j = localb.AA.size();
        i = 0;
        if (i < j)
        {
          if ((localb.AA.get(i) != null) && (str != null)) {
            ((c)localb.AA.get(i)).f(str, paramLong1, paramLong2);
          }
        }
        else
        {
          i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
          VideoEnvironment.k("ShortVideoResourceManager", "[onUpdateProgeress]downloadProgress=" + i + ",key=" + str, null);
          if (str != null) {
            fT(str, i);
          }
          return;
        }
      }
      i += 1;
    }
  }
  
  public static class SVConfigItem
  {
    public String arm64v8a_md5;
    public String arm64v8a_url;
    public String arm_md5;
    public String arm_url;
    public String armv7a_md5;
    public String armv7a_url;
    public String extend1;
    public String extend2;
    public String name;
    public boolean predownload;
    public int versionCode;
    public String x86_md5;
    public String x86_url;
    
    public boolean check64BitReady()
    {
      return (!aqmr.isEmpty(this.arm64v8a_md5)) && (!aqmr.isEmpty(this.arm64v8a_url));
    }
    
    public String getSignature()
    {
      if ((angz.awV()) && (check64BitReady())) {
        return this.arm64v8a_md5 + '_' + this.versionCode;
      }
      return this.armv7a_md5 + '_' + this.versionCode;
    }
    
    public String toString()
    {
      return "SVConfigItem{name='" + this.name + '\'' + ", arm_url='" + this.arm_url + '\'' + ", armv7a_url='" + this.armv7a_url + '\'' + ", x86_url='" + this.x86_url + '\'' + ", arm64v8a_url='" + this.arm64v8a_url + '\'' + ", arm_md5='" + this.arm_md5 + '\'' + ", armv7a_md5='" + this.armv7a_md5 + '\'' + ", x86_md5='" + this.x86_md5 + '\'' + ", arm64v8a_md5='" + this.arm64v8a_md5 + '\'' + ", versionCode=" + this.versionCode + ", predownload=" + this.predownload + ", extend1='" + this.extend1 + '\'' + ", extend2='" + this.extend2 + '\'' + '}';
    }
  }
  
  public static class a
  {
    volatile int dFu = 0;
    int dFv;
    int dFw;
    int mResultCode = 0;
    
    String getStatus()
    {
      switch (this.dFu)
      {
      default: 
        return "UNKNOWN_STATUS";
      case 0: 
        return "CONFIG_REQUEST_OK";
      case 1: 
        return "CONFIG_START_SERVLET";
      }
      return "CONFIG_SEND_REQ";
    }
  }
  
  class b
  {
    ArrayList<ShortVideoResourceManager.c> AA = new ArrayList(1);
    String bYT;
    aoll f;
    int mDownloadStatus = 0;
    int mVersionCode;
    
    b(aoll paramaoll)
    {
      this.f = paramaoll;
      this.mDownloadStatus = 0;
    }
    
    void startDownload()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
      }
      this.mDownloadStatus = 1;
      ShortVideoResourceManager.a(ShortVideoResourceManager.this).getNetEngine(0).a(this.f);
    }
  }
  
  public static abstract interface c
  {
    public abstract void aFW();
    
    public abstract void f(String paramString, long paramLong1, long paramLong2);
    
    public abstract void o(String paramString1, int paramInt, String paramString2);
  }
  
  public static abstract interface d
    extends ShortVideoResourceManager.c
  {
    public abstract void Z(String paramString1, int paramInt, String paramString2);
    
    public abstract void s(String paramString, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager
 * JD-Core Version:    0.7.0.1
 */