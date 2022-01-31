package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceRespInfo;

public class EarlyDownloadManager
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, Manager
{
  static final int jdField_a_of_type_Int = 131328;
  public static final String a = "actEarlyDown";
  public static final Lock a;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.system.face.gif" };
  static final int jdField_b_of_type_Int = 131329;
  private static String jdField_b_of_type_JavaLangString;
  static final int c = 131330;
  static final int d = 131331;
  public static final int e = 60000;
  private Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int f = -1;
  private int g = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public EarlyDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
  }
  
  private static final EarlyHandler a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "createHandler pkgName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return null;
      if ("qq.android.system.face.gif".equals(paramString)) {
        return new SystemFaceHandler(paramQQAppInterface);
      }
    } while (!QLog.isColorLevel());
    QLog.e("EarlyDown", 2, "createHandler() can't find Handler for:" + paramString);
    return null;
  }
  
  public static String a()
  {
    Context localContext;
    if ((jdField_b_of_type_JavaLangString == null) || (jdField_b_of_type_JavaLangString.length() == 0))
    {
      localContext = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label52;
      }
    }
    label52:
    for (int i = 4;; i = 0)
    {
      jdField_b_of_type_JavaLangString = localContext.getSharedPreferences("Last_Login", i).getString("uin", "");
      return jdField_b_of_type_JavaLangString;
    }
  }
  
  private boolean a(XmlData paramXmlData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "verifyResource() data=" + paramXmlData.Name + ", filepath=" + paramString);
    }
    if ((paramXmlData == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (TextUtils.isEmpty(paramXmlData.MD5)) {
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "verifyResource() file[" + paramString + "] not exist..");
      }
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = MD5FileUtil.a(localFile);
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "verifyResource.data.md5=" + paramXmlData.MD5 + ", file.md5=" + paramString);
      }
      if (paramXmlData.MD5.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("EarlyDown", 2, "verifyResource() get file md5 failed");
          paramString = localObject;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.equals(paramString))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = a(arrayOfString[i]);
      if (((EarlyHandler)localObject).f())
      {
        localObject = ((EarlyHandler)localObject).a();
        if (localObject != null)
        {
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "doOnNetChanged() add2List:pkg=" + ((GetResourceReqInfo)localObject).strPkgName + " ver=" + ((GetResourceReqInfo)localObject).uiCurVer);
          }
        }
      }
      i += 1;
    }
    if (localArrayList != null) {
      ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(localArrayList, new GetResourceReqInfo[0]);
    }
  }
  
  private void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "doOnCancelDownload.name=" + paramXmlData.Name + ",strResURL_big=" + paramXmlData.strResURL_big + ",strResURL_small=" + paramXmlData.strResURL_small + ",localVer=" + paramXmlData.Version);
    }
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = (NetReq)this.jdField_b_of_type_JavaUtilHashMap.remove(paramXmlData.Name);
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b((NetReq)localObject);
      localObject = a(paramXmlData.getStrPkgName());
      if (localObject != null) {
        ((EarlyHandler)localObject).c(paramXmlData);
      }
      return;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void b(NetResp paramNetResp)
  {
    XmlData localXmlData = (XmlData)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    long l3 = SystemClock.elapsedRealtime();
    long l4 = localXmlData.tStart;
    long l1 = 0L;
    try
    {
      long l2 = new File(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString).length();
      l1 = l2;
    }
    catch (Exception localException1)
    {
      label48:
      boolean bool1;
      break label48;
    }
    if (paramNetResp.d == 0) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool1 = a(localXmlData, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString);
        if (!bool1)
        {
          paramNetResp.e = -5103066;
          paramNetResp.jdField_a_of_type_JavaLangString = ("md5 not same.localSize=" + l1);
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("EarlyDown", 2, "doOnResp() verifyResource=" + bool1 + " strPkgName=" + localXmlData.Name);
          bool2 = bool1;
        }
      }
      String str = localXmlData.getStrPkgName();
      Object localObject1 = a(str);
      if (bool2)
      {
        localXmlData.tLoadFail = 0L;
        localXmlData.loadState = 1;
        if ((!localXmlData.StoreBackup) || (localObject1 == null)) {}
      }
      try
      {
        Object localObject2 = ((EarlyHandler)localObject1).b();
        bool1 = FileUtils.c(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString, (String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "onDownloadFinish() copyResult=" + bool1 + " src=" + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString + " dest=" + (String)localObject2);
        }
        for (;;)
        {
          label299:
          EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail" });
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "doOnResp() result=" + bool2 + " errCode=" + paramNetResp.e + " name=" + localXmlData.Name + ",strResURL_big=" + localXmlData.strResURL_big);
          }
          jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
          try
          {
            localObject2 = (NetReq)this.jdField_b_of_type_JavaUtilHashMap.remove(localXmlData.Name);
            jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
            if (localObject2 == null) {
              break label742;
            }
            if (localObject1 != null)
            {
              ((EarlyHandler)localObject1).a(localXmlData, bool2, paramNetResp.e, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString);
              ((EarlyHandler)localObject1).c();
            }
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("param_FailCode", Integer.toString(paramNetResp.e));
            ((HashMap)localObject1).put("param_strPkgName", str);
            if (!bool2)
            {
              if (paramNetResp.jdField_a_of_type_JavaUtilHashMap != null)
              {
                str = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("serverip");
                if ((str != null) && (str.length() > 0)) {
                  ((HashMap)localObject1).put("param_serverIP", str);
                }
              }
              if ((localXmlData.strLog != null) && (localXmlData.strLog.length() > 0)) {
                ((HashMap)localObject1).put("param_range", localXmlData.strLog);
              }
              if ((paramNetResp.jdField_a_of_type_JavaLangString != null) && (paramNetResp.jdField_a_of_type_JavaLangString.length() > 0)) {
                ((HashMap)localObject1).put("param_desc", paramNetResp.jdField_a_of_type_JavaLangString);
              }
            }
            if (paramNetResp.e != 9366) {}
            return;
          }
          finally
          {
            jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          }
          bool1 = false;
          break;
          localXmlData.tLoadFail = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "set tLoadFail=" + localXmlData.tLoadFail + " strPkgName=" + localXmlData.Name);
          }
          ((EarlyHandler)localObject1).b(false);
          FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString);
        }
        label742:
        QLog.d("EarlyDown", 2, "doOnResp. netReq is null. may has been cancelled.");
        return;
      }
      catch (Exception localException2)
      {
        break label299;
      }
    }
  }
  
  private void b(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "doOnServerResp() iResult=" + paramGetResourceRespInfo.iResult + " resp.strPkgName=" + paramGetResourceRespInfo.strPkgName);
    }
    if (paramGetResourceRespInfo.iResult == 0)
    {
      localEarlyHandler = a(paramGetResourceRespInfo.strPkgName);
      localEarlyHandler.a(EarlyDataFactory.a(paramGetResourceRespInfo, localEarlyHandler));
    }
    while (paramGetResourceRespInfo.iResult != -2)
    {
      EarlyHandler localEarlyHandler;
      return;
    }
    a(paramGetResourceRespInfo.strPkgName).a(System.currentTimeMillis());
    a(paramGetResourceRespInfo.strPkgName);
  }
  
  public EarlyHandler a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    EarlyHandler localEarlyHandler;
    do
    {
      do
      {
        return localObject;
        localEarlyHandler = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localObject = localEarlyHandler;
      } while (localEarlyHandler != null);
      localEarlyHandler = a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = localEarlyHandler;
    } while (localEarlyHandler == null);
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localEarlyHandler);
      }
      return localEarlyHandler;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      GetResourceReqInfo localGetResourceReqInfo = a(arrayOfString[i]).a();
      if (localGetResourceReqInfo != null) {
        localArrayList.add(localGetResourceReqInfo);
      }
      i += 1;
    }
    if (this.f == -1) {
      this.f = localArrayList.size();
    }
    if (localArrayList.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "getResourceReqInfos() list.size()=0");
      }
    }
    while (!QLog.isColorLevel()) {
      return localArrayList;
    }
    QLog.d("EarlyDown", 2, "getResourceReqInfos() list.size()=" + localArrayList.size());
    return localArrayList;
  }
  
  public void a()
  {
    if (this.f == this.g)
    {
      localMessage = Message.obtain();
      localMessage.what = 131330;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(131330)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(131330);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 60000L);
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "onNetChange() sendMsg:ACTION_NET_CHANGE, delay(ms):60000");
      }
    }
    while (!QLog.isColorLevel())
    {
      Message localMessage;
      return;
    }
    QLog.d("EarlyDown", 2, "onNetChanged() return, first[req=" + this.f + "] != [" + "resp=" + this.g + "], waiting ..");
  }
  
  void a(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    paramXmlData.tStart = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "cancelDownload.name=" + paramXmlData.Name + ",strResURL_big=" + paramXmlData.strResURL_big + ",localVer=" + paramXmlData.Version);
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131329, paramXmlData).sendToTarget();
  }
  
  public void a(XmlData paramXmlData, String paramString)
  {
    if ((paramXmlData == null) || (paramString == null) || (paramString.length() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("downloadResource() return, ");
        if (paramXmlData != null) {
          break label58;
        }
        paramXmlData = "data==null";
        QLog.d("EarlyDown", 2, paramXmlData);
      }
    }
    label58:
    do
    {
      do
      {
        return;
        paramXmlData = "storagePath=" + paramString;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "downloadResource() name=" + paramXmlData.Name + " strResURL_big=" + paramXmlData.strResURL_big + " storagePath=" + paramString);
        }
      } while (TextUtils.isEmpty(paramXmlData.strResURL_big));
      if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramXmlData.Name)) {
        break label200;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "downloadResource() return, already exist=" + paramXmlData.Name);
    return;
    label200:
    paramXmlData.tStart = SystemClock.elapsedRealtime();
    Object localObject = a(paramXmlData.getStrPkgName());
    if (localObject != null) {
      ((EarlyHandler)localObject).b(paramXmlData);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramXmlData.strResURL_big;
    localHttpNetReq.jdField_c_of_type_Int = 0;
    localHttpNetReq.a(paramXmlData);
    localHttpNetReq.jdField_b_of_type_JavaLangString = paramString;
    localHttpNetReq.jdField_c_of_type_Boolean = true;
    if (paramXmlData.isUserClick) {}
    for (localHttpNetReq.l = 1;; localHttpNetReq.l = 2)
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramXmlData.Name, localHttpNetReq);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (XmlData)paramNetReq.a();
    if (paramNetReq != null)
    {
      paramNetReq = a(paramNetReq.getStrPkgName());
      if (paramNetReq != null) {
        paramNetReq.a(paramLong1, paramLong2);
      }
    }
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("start=" + localHttpNetReq.jdField_a_of_type_Long + " written=" + paramNetResp.c);
      localHttpNetReq.jdField_a_of_type_Long += paramNetResp.c;
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-";
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      localStringBuffer.append(" range=");
      localStringBuffer.append(paramNetResp);
    } while (!(paramNetReq.a() instanceof XmlData));
    ((XmlData)paramNetReq.a()).strLog = localStringBuffer.toString();
  }
  
  public void a(NetResp paramNetResp)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131328, paramNetResp).sendToTarget();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "removeHandler() strPkgName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        paramString = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (paramString == null) {
          continue;
        }
        paramString.a();
        return;
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    long l1 = 0L;
    if (this.g < this.f)
    {
      long l2 = 60000L;
      this.g += 1;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "onServerResp() rep=" + this.f + " resp=" + this.g + " delay=" + 60000L);
        l1 = l2;
      }
    }
    Message localMessage = Message.obtain();
    localMessage.what = 131331;
    localMessage.obj = paramGetResourceRespInfo;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      b((XmlData)paramMessage.obj);
      continue;
      b();
      continue;
      b((GetResourceRespInfo)paramMessage.obj);
    }
  }
  
  public void onDestroy()
  {
    jdField_b_of_type_JavaLangString = null;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfString[i];
      localObject2 = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (localObject2 != null) {
        ((EarlyHandler)localObject2).a();
      }
      i += 1;
    }
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDownloadManager
 * JD-Core Version:    0.7.0.1
 */