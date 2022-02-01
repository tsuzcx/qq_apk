package com.tencent.mobileqq.activity.qwallet.preload;

import Wallet.DownloadChooseReq;
import aaai;
import aaai.b;
import aacc;
import aacf;
import aacg;
import aach;
import aaci;
import aacj;
import aack;
import aacl;
import aacm;
import aadj;
import aagd;
import aeic;
import aemb;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import anld;
import aquy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import zyb;
import zyn;

public class PreloadManager
  extends aacl
  implements aaai.b, INetInfoHandler, Manager
{
  public boolean Vn;
  private PreloadBackControlConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig = PreloadBackControlConfig.readBackControlConfig(this.mApp);
  private PreloadConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig = PreloadConfig.readConfig("preload.config", this.mApp);
  private int cgd = 30;
  private int cge = 1024;
  private Handler ci;
  
  public PreloadManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    ctG();
    try
    {
      AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
      ctI();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        QLog.d("PreloadManager", 1, "AppNetConnInfo.registerConnectionChangeReceiver is error msg=" + paramQQAppInterface.getMessage());
        h(paramQQAppInterface);
      }
    }
  }
  
  private void Ae(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("qwallet_preload_config", 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("config_from_qq" + this.mApp.getAccount(), paramString).apply();
      }
    }
  }
  
  private boolean Wg()
  {
    String str = qj();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(str))
    {
      long l2 = anld.s(str);
      l1 = l2;
      if (l2 > 104857600L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "isDiskEnoughToDownload|true|" + str + "|" + l2);
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "isDiskEnoughToDownload|false|" + str + "|" + l1);
    }
    return false;
  }
  
  public static aacl a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (PreloadManager)((QQAppInterface)localAppRuntime).getManager(151);
    }
    return aacm.a();
  }
  
  public static PathResult a(DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResPathSync: param" + paramDownloadParam);
    }
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {}
    ResourceInfo localResourceInfo;
    do
    {
      return null;
      paramDownloadParam.standardlize();
      localResourceInfo = a(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
    } while (!a(localResourceInfo, paramDownloadParam));
    PathResult localPathResult = new PathResult();
    localPathResult.url = paramDownloadParam.url;
    localPathResult.filePath = localResourceInfo.filePath;
    localPathResult.folderPath = localResourceInfo.folderPath;
    localPathResult.isAlreadyExist = true;
    return localPathResult;
  }
  
  public static ResourceInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    ResourceInfo localResourceInfo = aadj.a(paramString, paramBoolean, 0, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResInfoByUrl :" + paramString + "|" + paramBoolean + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  private List<PreloadModule> a(List<PreloadModule> paramList, aquy paramaquy)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    PreloadConfig.splitModulesBySize(this.cge, paramList, localArrayList1, localArrayList2);
    if (localArrayList2.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "delayLargerModulesAndReturnSmallerModules|begin delay download:" + this.cgd + "|" + this.cge + "|" + localArrayList2);
      }
      paramList = new WeakReference(this);
      ThreadManager.getTimer().schedule(new PreloadManager.4(this, paramList, localArrayList2, paramaquy), this.cgd * 1000);
    }
    return localArrayList1;
  }
  
  private void a(List<PreloadModule> paramList, aquy paramaquy)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((PreloadModule)paramList.next()).downloadModule(false, paramaquy, this, true);
      }
    }
  }
  
  private void a(List<PreloadModule> paramList, aquy paramaquy, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig.isLocalResNewest())
    {
      DownloadChooseReq localDownloadChooseReq = new DownloadChooseReq();
      localDownloadChooseReq.iUin = this.mApp.getLongAccountUin();
      localDownloadChooseReq.vecResInfo = PreloadConfig.modulesToResInfos(paramList);
      zyb.a(localDownloadChooseReq, new aacg(this, paramList, paramaquy, paramBoolean));
      return;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.resInfosToModules(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig.getLastBackResInfos());
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "downloadBackControlModules|choose res:" + paramList);
    }
    b(paramList, paramaquy, paramBoolean);
  }
  
  public static boolean a(PreloadManager paramPreloadManager)
  {
    return (paramPreloadManager != null) && (!paramPreloadManager.Vn);
  }
  
  private static boolean a(ResourceInfo paramResourceInfo, DownloadParam paramDownloadParam)
  {
    if (paramDownloadParam == null) {}
    do
    {
      String str;
      long l;
      boolean bool;
      do
      {
        do
        {
          return false;
        } while ((paramResourceInfo == null) || (TextUtils.isEmpty(paramResourceInfo.filePath)));
        str = paramDownloadParam.md5;
        l = paramDownloadParam.md5Time;
        bool = paramDownloadParam.isForceUnzip;
        paramDownloadParam = paramDownloadParam.md5ForChecked;
      } while (((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!str.equalsIgnoreCase(paramResourceInfo.fileMd5)) && (paramResourceInfo.doneTime < l)) || ((!TextUtils.isEmpty(paramDownloadParam)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!paramDownloadParam.equalsIgnoreCase(paramResourceInfo.fileMd5))));
      if ((!bool) && (!PreloadResource.isNeedAutoUnzip(paramResourceInfo.url, 0))) {
        break;
      }
    } while (TextUtils.isEmpty(paramResourceInfo.folderPath));
    return true;
    return true;
  }
  
  private void b(List<PreloadModule> paramList, aquy paramaquy, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModules|afterGetConfig");
      }
      localObject = a(paramList, paramaquy);
    }
    a((List)localObject, paramaquy);
  }
  
  private void ctG()
  {
    int i = zyn.getInt(this.mApp.getLongAccountUin() + "", "deal_delay_interval", 30);
    int j = zyn.getInt(this.mApp.getLongAccountUin() + "", "need_wait_size", 1024);
    gl(i, j);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "initPreloadHelpConfig|" + i + "|" + j + "|" + this.cgd + "|" + this.cge);
    }
  }
  
  private void ctI()
  {
    ThreadManager.executeOnSubThread(new PreloadManager.1(this));
  }
  
  private void ctJ()
  {
    Cd(false);
  }
  
  private void ctK()
  {
    if (this.ci == null) {
      this.ci = new aacj(this, ThreadManager.getSubThreadLooper());
    }
  }
  
  public static void e(String paramString, boolean paramBoolean, int paramInt)
  {
    ResourceInfo localResourceInfo = a(paramString, paramBoolean, paramInt);
    if (localResourceInfo != null)
    {
      aadj.cU(paramString, paramInt);
      aagd.delete(localResourceInfo.filePath);
      aagd.delete(localResourceInfo.folderPath);
    }
  }
  
  private void h(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(paramThrowable.toString());
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int i = 0;
        while ((i < paramThrowable.length) && (i < 16))
        {
          localStringBuilder.append("\n ");
          localStringBuilder.append(paramThrowable[i].toString());
          i += 1;
        }
      }
      VACDReportUtil.a("preload_crash", "qqwallet", "crash", "Catch", null, 668814, localStringBuilder.toString());
    }
  }
  
  public static String ia(String paramString)
  {
    ResourceInfo localResourceInfo = aadj.a(paramString, false, 0, 0);
    paramString = null;
    if (localResourceInfo != null) {
      paramString = localResourceInfo.folderPath;
    }
    return paramString;
  }
  
  public static String ib(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getSharedPreferences("qwallet_preload_config", 4);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((SharedPreferences)localObject3).getString("config_from_qq" + paramString, null);
      }
    }
    return localObject1;
  }
  
  public void Ac(String paramString)
  {
    try
    {
      paramString = a(paramString);
      if (paramString != null) {
        paramString.downloadModule(true, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  public void Ad(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.mergeConfig(paramString, this);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void Cc(boolean paramBoolean)
  {
    try
    {
      a(null, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("PreloadManager", 1, "checkAndDownload is error msg= " + localThrowable.getMessage());
      }
    }
    finally {}
  }
  
  public void Cd(boolean paramBoolean)
  {
    if (this.Vn) {
      return;
    }
    ThreadManager.post(new PreloadManager.5(this, new WeakReference(this), paramBoolean), 5, null, true);
  }
  
  public PreloadModule a(String paramString)
  {
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByID(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public PreloadResource a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModules().iterator();
      Iterator localIterator2;
      do
      {
        localObject2 = localObject1;
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((PreloadModule)localIterator1.next()).getResList().iterator();
        localObject2 = localObject1;
        localObject1 = localObject2;
      } while (!localIterator2.hasNext());
      localObject1 = (PreloadResource)localIterator2.next();
      if (!aagd.j(paramString, ((PreloadResource)localObject1).mResId)) {
        break label100;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return localObject2;
      label100:
      localObject1 = localObject2;
    }
  }
  
  public void a(aemb paramaemb)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if ((paramaemb != null) && (paramaemb.a != null))
        {
          paramaemb = paramaemb.a;
          int k = paramaemb.length;
          i = 0;
          if (i < k)
          {
            Object localObject = paramaemb[i].content;
            if (QLog.isColorLevel()) {
              QLog.d("PreloadManager", 2, "receiveAllConfigs|type: 68,content: " + (String)localObject);
            }
            try
            {
              localObject = new JSONObject((String)localObject).getJSONArray("module_config");
              int j = 0;
              if (j >= ((JSONArray)localObject).length()) {
                break label165;
              }
              localJSONArray.put(((JSONArray)localObject).get(j));
              j += 1;
              continue;
              Ae(localJSONArray.toString());
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.innerReplaceConfig(localJSONArray, this, 0);
        return;
      }
      finally {}
      label165:
      i += 1;
    }
  }
  
  /* Error */
  public void a(aquy paramaquy, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +41 -> 46
    //   8: ldc 91
    //   10: iconst_2
    //   11: new 93	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 589
    //   21: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 261	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc 189
    //   30: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   37: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: invokevirtual 592	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:ctH	()V
    //   50: aload_0
    //   51: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   54: invokevirtual 595	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModuleNum	()I
    //   57: ifle +12 -> 69
    //   60: aload_0
    //   61: invokespecial 597	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:Wg	()Z
    //   64: istore_3
    //   65: iload_3
    //   66: ifne +6 -> 72
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   76: aload_0
    //   77: invokevirtual 600	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:filterInvalidModules	(Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;)V
    //   80: aload_0
    //   81: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   84: invokevirtual 531	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModules	()Ljava/util/List;
    //   87: astore 4
    //   89: new 264	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 265	java/util/ArrayList:<init>	()V
    //   96: astore 5
    //   98: new 264	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 265	java/util/ArrayList:<init>	()V
    //   105: astore 6
    //   107: aload 4
    //   109: aload 5
    //   111: aload 6
    //   113: invokestatic 604	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:splitModulesByBackControl	(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    //   116: aload 6
    //   118: invokeinterface 275 1 0
    //   123: ifle +44 -> 167
    //   126: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +30 -> 159
    //   132: ldc 91
    //   134: iconst_2
    //   135: new 93	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 606
    //   145: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 6
    //   150: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: aload 6
    //   162: aload_1
    //   163: iload_2
    //   164: invokespecial 375	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:b	(Ljava/util/List;Laquy;Z)V
    //   167: aload 5
    //   169: invokeinterface 275 1 0
    //   174: ifle +44 -> 218
    //   177: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +30 -> 210
    //   183: ldc 91
    //   185: iconst_2
    //   186: new 93	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 608
    //   196: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 5
    //   201: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_0
    //   211: aload 5
    //   213: aload_1
    //   214: iload_2
    //   215: invokespecial 312	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:a	(Ljava/util/List;Laquy;Z)V
    //   218: aload_0
    //   219: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   222: invokevirtual 611	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:savePreloadConfig	()V
    //   225: goto -156 -> 69
    //   228: astore_1
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_1
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	PreloadManager
    //   0	233	1	paramaquy	aquy
    //   0	233	2	paramBoolean	boolean
    //   64	2	3	bool	boolean
    //   87	21	4	localList	List
    //   96	116	5	localArrayList1	ArrayList
    //   105	56	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	46	228	finally
    //   46	65	228	finally
    //   72	159	228	finally
    //   159	167	228	finally
    //   167	210	228	finally
    //   210	218	228	finally
    //   218	225	228	finally
  }
  
  /* Error */
  public void a(QWalletConfig.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 544	org/json/JSONArray
    //   5: dup
    //   6: invokespecial 545	org/json/JSONArray:<init>	()V
    //   9: astore 8
    //   11: aload_1
    //   12: ifnull +18 -> 30
    //   15: ldc_w 614
    //   18: aload_1
    //   19: getfield 619	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:module	Ljava/lang/String;
    //   22: invokevirtual 623	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifne +6 -> 33
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +59 -> 95
    //   39: ldc 91
    //   41: iconst_2
    //   42: new 93	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 625
    //   52: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 628	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:version	J
    //   59: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 189
    //   64: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   71: getfield 631	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   74: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc 189
    //   79: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: getfield 634	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:configStr	Ljava/lang/String;
    //   86: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_1
    //   96: getfield 628	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:version	J
    //   99: lstore 4
    //   101: aload_0
    //   102: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   105: getfield 631	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   108: lstore 6
    //   110: lload 4
    //   112: lload 6
    //   114: lcmp
    //   115: ifle -85 -> 30
    //   118: new 559	org/json/JSONObject
    //   121: dup
    //   122: aload_1
    //   123: getfield 634	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:configStr	Ljava/lang/String;
    //   126: invokespecial 560	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   129: ldc_w 562
    //   132: invokevirtual 566	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   135: astore 9
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_2
    //   140: aload 9
    //   142: invokevirtual 569	org/json/JSONArray:length	()I
    //   145: if_icmpge +29 -> 174
    //   148: aload 8
    //   150: aload 9
    //   152: iload_2
    //   153: invokevirtual 573	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   156: invokevirtual 577	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   159: pop
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_2
    //   164: goto -25 -> 139
    //   167: astore 9
    //   169: aload 9
    //   171: invokevirtual 580	java/lang/Throwable:printStackTrace	()V
    //   174: aload_0
    //   175: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   178: aload 8
    //   180: aload_0
    //   181: iconst_1
    //   182: invokevirtual 587	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:innerReplaceConfig	(Lorg/json/JSONArray;Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;I)V
    //   185: aload_0
    //   186: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   189: aload_1
    //   190: getfield 628	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:version	J
    //   193: putfield 631	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:moggyConfigVersion	J
    //   196: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +32 -> 231
    //   202: ldc 91
    //   204: iconst_2
    //   205: new 93	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 636
    //   215: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   222: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   235: invokevirtual 611	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:savePreloadConfig	()V
    //   238: goto -208 -> 30
    //   241: astore_1
    //   242: aload_0
    //   243: monitorexit
    //   244: aload_1
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	PreloadManager
    //   0	246	1	parama	QWalletConfig.a
    //   138	26	2	i	int
    //   25	2	3	bool	boolean
    //   99	12	4	l1	long
    //   108	5	6	l2	long
    //   9	170	8	localJSONArray1	JSONArray
    //   135	16	9	localJSONArray2	JSONArray
    //   167	3	9	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   118	137	167	java/lang/Throwable
    //   139	160	167	java/lang/Throwable
    //   2	11	241	finally
    //   15	26	241	finally
    //   33	95	241	finally
    //   95	110	241	finally
    //   118	137	241	finally
    //   139	160	241	finally
    //   169	174	241	finally
    //   174	231	241	finally
    //   231	238	241	finally
  }
  
  public void a(DownloadParam paramDownloadParam, d paramd)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {
      if (paramd != null) {
        paramd.onResult(1, PathResult.getFailRes(null));
      }
    }
    ResourceInfo localResourceInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "getResPath: param" + paramDownloadParam);
      }
      paramDownloadParam.standardlize();
      localResourceInfo = a(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
      boolean bool = a(localResourceInfo, paramDownloadParam);
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "getResPath: isValidFileExist" + bool + "|" + localResourceInfo);
      }
      if (!bool) {
        break;
      }
    } while (paramd == null);
    PathResult localPathResult = new PathResult();
    localPathResult.url = paramDownloadParam.url;
    localPathResult.filePath = localResourceInfo.filePath;
    localPathResult.folderPath = localResourceInfo.folderPath;
    localPathResult.isAlreadyExist = true;
    paramd.onResult(0, localPathResult);
    return;
    if (localResourceInfo != null)
    {
      aadj.cU(paramDownloadParam.url, paramDownloadParam.filePos);
      aagd.delete(localResourceInfo.filePath);
      aagd.delete(localResourceInfo.folderPath);
    }
    b(paramDownloadParam, paramd);
  }
  
  public void a(PreloadResource paramPreloadResource, PreloadModule paramPreloadModule, aquy paramaquy)
  {
    if (this.ci == null) {
      ctK();
    }
    Message localMessage = this.ci.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new b(paramPreloadResource, paramPreloadModule, paramaquy);
    this.ci.sendMessage(localMessage);
  }
  
  public void a(String paramString, d paramd)
  {
    a(paramString, "", paramd);
  }
  
  public void a(String paramString1, String paramString2, QWalletConfig.a parama)
  {
    if (aagd.j(paramString1, "preload"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "configFromMoggy onUpdate");
      }
      a(parama);
      ctJ();
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, a parama)
  {
    String str = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "downloadRes|" + paramString1 + "|" + paramString2);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          Ad(paramString2);
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.savePreloadConfig();
        }
        Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModules().iterator();
        localObject2 = null;
        if (!localIterator1.hasNext()) {
          break label268;
        }
        PreloadModule localPreloadModule = (PreloadModule)localIterator1.next();
        Iterator localIterator2 = localPreloadModule.getResList().iterator();
        Object localObject1 = localObject2;
        paramString2 = str;
        str = paramString2;
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject2 = (PreloadResource)localIterator2.next();
        if (!aagd.j(paramString1, ((PreloadResource)localObject2).mResId)) {
          break label265;
        }
        localObject1 = localObject2;
        paramString2 = localPreloadModule;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadRes ERR_CONFIG_NOT_EXIST");
      }
      parama.onDownloadResFinished(null, -7, null, null);
      return;
      if (!Wg())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "downloadRes|disk space not enough");
        }
        parama.onDownloadResFinished(null, -4, null, null);
      }
      else
      {
        ((PreloadResource)localObject2).startDownload(this, str, new aach(this, parama), false);
        continue;
        label265:
        continue;
        label268:
        if (str != null) {
          if (localObject2 != null) {}
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, d paramd)
  {
    Object localObject;
    long l;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = (aaai)this.mApp.getManager(245);
      if (localObject != null) {
        l = ((aaai)localObject).getLastReqTime();
      }
    }
    for (;;)
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).url = paramString1;
      ((DownloadParam)localObject).md5 = paramString2;
      ((DownloadParam)localObject).md5Time = l;
      ((DownloadParam)localObject).isForceUnzip = true;
      a((DownloadParam)localObject, paramd);
      return;
      l = 0L;
      continue;
      l = 0L;
    }
  }
  
  public void a(LinkedList<DownloadParam> paramLinkedList, e parame)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResPath: params" + paramLinkedList + ",OnGetPathsListener=" + parame);
    }
    if (paramLinkedList == null)
    {
      if (parame != null) {
        parame.b(1, null);
      }
      return;
    }
    new c(paramLinkedList, parame).start();
  }
  
  public void a(List<String> paramList, d paramd)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((String)paramList.next(), paramd);
      }
    }
  }
  
  public void b(DownloadParam paramDownloadParam, d paramd)
  {
    paramd = new aacf(this, paramDownloadParam, paramd, new WeakReference(this));
    if (TextUtils.isEmpty(paramDownloadParam.filePath)) {
      paramDownloadParam.filePath = Y(paramDownloadParam.url, paramDownloadParam.filePos);
    }
    aacc.a().a(paramDownloadParam, paramd, null);
  }
  
  public void b(String paramString, d paramd)
  {
    b(paramString, "", paramd);
  }
  
  @Deprecated
  public void b(String paramString1, String paramString2, a parama)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadManager", 2, "downloadModule|" + paramString1 + " | " + paramString2);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          boolean bool = TextUtils.isEmpty(paramString1);
          if ((!bool) && (parama != null)) {}
        }
        else
        {
          return;
        }
        Ad(paramString2);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.savePreloadConfig();
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByID(paramString1);
        if ((paramString2 == null) || (paramString2.getResNum() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadManager", 2, "downloadModule|json wrong");
          }
          parama.onDownloadResFinished(paramString1, -7, null, null);
          continue;
        }
        if (Wg()) {
          break label171;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "downloadModule|disk space not enough");
      }
      parama.onDownloadResFinished(paramString1, -4, null, null);
      continue;
      label171:
      paramString2.downloadModule(true, new aaci(this, paramString1, parama), this, false);
    }
  }
  
  public void b(String paramString1, String paramString2, d paramd)
  {
    Object localObject;
    long l;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = (aaai)this.mApp.getManager(245);
      if (localObject != null) {
        l = ((aaai)localObject).getLastReqTime();
      }
    }
    for (;;)
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).url = paramString1;
      ((DownloadParam)localObject).md5 = paramString2;
      ((DownloadParam)localObject).md5Time = l;
      ((DownloadParam)localObject).isForceUnzip = false;
      a((DownloadParam)localObject, paramd);
      return;
      l = 0L;
      continue;
      l = 0L;
    }
  }
  
  public void bn(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getModuleByName(paramString);
      if (paramString != null) {
        paramString.downloadModule(paramBoolean, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  public void c(String paramString, ResultReceiver paramResultReceiver)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModules().iterator();
          localObject2 = null;
          if (!localIterator1.hasNext()) {
            break label211;
          }
          PreloadModule localPreloadModule = (PreloadModule)localIterator1.next();
          Iterator localIterator2 = localPreloadModule.getResList().iterator();
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (!localIterator2.hasNext()) {
            continue;
          }
          localObject2 = (PreloadResource)localIterator2.next();
          if (aagd.j(paramString, ((PreloadResource)localObject2).mResId)) {
            localObject1 = X(((PreloadResource)localObject2).getResDownloadUrl(localPreloadModule), ((PreloadResource)localObject2).getFilePos());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadManager", 2, "getFilePathByResID|" + paramString + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig + "|" + (String)localObject1);
          }
          if (paramResultReceiver != null)
          {
            paramString = new Bundle();
            paramString.putString("path", (String)localObject1);
            paramResultReceiver.send(0, paramString);
          }
          return;
        }
      }
      finally {}
      continue;
      label211:
      localObject1 = localObject2;
    }
  }
  
  public void ctH()
  {
    if (!aacl.bvb) {
      aadj.a(0, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig);
    }
    aadj.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig);
  }
  
  public void ctL()
  {
    if (this.ci == null) {
      ctK();
    }
    this.ci.sendEmptyMessage(2);
  }
  
  public PreloadModule getModuleByName(String paramString)
  {
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getModuleByName(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ResourceInfo getResInfoByResId(String paramString)
  {
    ResourceInfo localResourceInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.getResInfoByResId(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "getResInfoByResId :" + paramString + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  public void gl(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 5) {
      this.cgd = 5;
    }
    while (paramInt2 <= 0)
    {
      this.cge = 1024;
      return;
      if (paramInt1 > 1800) {
        this.cgd = 1800;
      } else {
        this.cgd = paramInt1;
      }
    }
    this.cge = paramInt2;
  }
  
  public String hZ(String paramString)
  {
    paramString = getResInfoByResId(paramString);
    if (paramString != null) {
      return paramString.folderPath;
    }
    return null;
  }
  
  /* Error */
  public String ic(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +41 -> 46
    //   8: ldc 91
    //   10: iconst_2
    //   11: new 93	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 829
    //   21: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 189
    //   30: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   37: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 62	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadConfig;
    //   50: aload_1
    //   51: invokevirtual 526	com/tencent/mobileqq/activity/qwallet/preload/PreloadConfig:getModuleByID	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadModule;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +77 -> 133
    //   59: aload_1
    //   60: invokevirtual 534	com/tencent/mobileqq/activity/qwallet/preload/PreloadModule:getResList	()Ljava/util/List;
    //   63: invokeinterface 316 1 0
    //   68: astore_2
    //   69: aload_2
    //   70: invokeinterface 321 1 0
    //   75: ifeq +58 -> 133
    //   78: aload_2
    //   79: invokeinterface 325 1 0
    //   84: checkcast 403	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource
    //   87: astore_3
    //   88: aload_3
    //   89: getfield 832	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:type	I
    //   92: iconst_5
    //   93: if_icmpne -24 -> 69
    //   96: aload_3
    //   97: getfield 833	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:url	Ljava/lang/String;
    //   100: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +13 -> 116
    //   106: aload_3
    //   107: getfield 836	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:urlPath	Ljava/lang/String;
    //   110: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne -44 -> 69
    //   116: aload_3
    //   117: aload_1
    //   118: invokevirtual 784	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:getResDownloadUrl	(Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadModule;)Ljava/lang/String;
    //   121: aload_3
    //   122: invokevirtual 787	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:getFilePos	()I
    //   125: invokestatic 790	com/tencent/mobileqq/activity/qwallet/preload/PreloadManager:X	(Ljava/lang/String;I)Ljava/lang/String;
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: areturn
    //   133: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +12 -> 148
    //   139: ldc 91
    //   141: iconst_2
    //   142: ldc_w 838
    //   145: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -21 -> 129
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	PreloadManager
    //   0	158	1	paramString	String
    //   68	11	2	localIterator	Iterator
    //   87	35	3	localPreloadResource	PreloadResource
    // Exception table:
    //   from	to	target	type
    //   2	46	153	finally
    //   46	55	153	finally
    //   59	69	153	finally
    //   69	116	153	finally
    //   116	129	153	finally
    //   133	148	153	finally
  }
  
  public boolean isResInConfig(PreloadResource paramPreloadResource)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.isResInConfig(paramPreloadResource);
  }
  
  public void onDestroy()
  {
    this.Vn = true;
    aaai localaaai = (aaai)this.mApp.getManager(245);
    if (localaaai != null) {
      localaaai.b("preload", this);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    if (this.ci != null) {
      this.ci.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadBackControlConfig = null;
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetMobile2Wifi");
    }
    ctJ();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetNone2Mobile");
    }
    ctJ();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetNone2Wifi");
    }
    ctJ();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "onNetWifi2Mobile");
    }
    ctJ();
  }
  
  public void onNetWifi2None() {}
  
  public void savePreloadConfig()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadConfig.savePreloadConfig();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static class PathResult
    implements Serializable
  {
    public String filePath;
    public String folderPath;
    public boolean isAlreadyExist;
    public int subErrCode;
    public String url;
    
    public PathResult() {}
    
    public PathResult(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.filePath = paramString1;
      this.folderPath = paramString2;
      this.url = paramString3;
      this.subErrCode = paramInt;
    }
    
    public static PathResult getFailRes(String paramString)
    {
      return getFailRes(paramString, 0);
    }
    
    public static PathResult getFailRes(String paramString, int paramInt)
    {
      return new PathResult(null, null, paramString, paramInt);
    }
    
    public boolean retryUnzip()
    {
      if ((TextUtils.isEmpty(this.filePath)) || (TextUtils.isEmpty(this.folderPath))) {
        return false;
      }
      try
      {
        aagd.delete(this.folderPath);
        boolean bool = PreloadResource.unzipAtomically(this.filePath, this.folderPath);
        return bool;
      }
      finally {}
    }
    
    public String toString()
    {
      return "PathResult{file='" + this.filePath + '\'' + ", folder='" + this.folderPath + '\'' + ", url='" + this.url + '\'' + '}';
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDownloadResFinished(String paramString1, int paramInt, String paramString2, ResourceInfo paramResourceInfo);
  }
  
  public static class b
  {
    PreloadModule jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule;
    PreloadResource jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource;
    aquy g;
    
    public b(PreloadResource paramPreloadResource, PreloadModule paramPreloadModule, aquy paramaquy)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource = paramPreloadResource;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule = paramPreloadModule;
      this.g = paramaquy;
    }
  }
  
  public class c
  {
    public PreloadManager.e a;
    public int cgf = 0;
    public HashMap<String, PreloadManager.PathResult> hO = new HashMap();
    public boolean isFailed = false;
    public List<DownloadParam> params;
    
    public c(PreloadManager.e parame)
    {
      this.params = parame;
      Object localObject;
      this.a = localObject;
    }
    
    public void start()
    {
      Iterator localIterator = this.params.iterator();
      while (localIterator.hasNext())
      {
        DownloadParam localDownloadParam = (DownloadParam)localIterator.next();
        PreloadManager.this.a(localDownloadParam, new aack(this));
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void onResult(int paramInt, PreloadManager.PathResult paramPathResult);
  }
  
  public static abstract interface e
  {
    public abstract void b(int paramInt, HashMap<String, PreloadManager.PathResult> paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager
 * JD-Core Version:    0.7.0.1
 */