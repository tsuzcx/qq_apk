package com.tencent.mobileqq.app.upgrade;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadQueryListener;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.qphone.base.util.QLog;
import dbg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import protocol.KQQConfig.UpgradeInfo;

public final class UpgradeController
  implements DownloadListener, DownloadQueryListener, UpdateManager.OnCheckUpdateListener
{
  public static final int a = 0;
  private static UpgradeController jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController;
  public static final String a = "UpgradeController";
  public static final int b = 1;
  public static final String b = "qqupgrade";
  public static final int c = -1;
  public static final String c = "100686848";
  public static final int d = 0;
  private static final String d = "_100686848";
  public static final int e = 1;
  private static final String e = "ANDROIDQQ.QQUPDATE";
  public static final int f = 2;
  private static final String f = "6633";
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 100000;
  public static final int j = 100001;
  public static final int k = 100002;
  public static final int l = 100003;
  public static final int m = 100004;
  public static final int n = 100005;
  public static final int o = 100006;
  private static final int p = 1;
  private Application jdField_a_of_type_AndroidAppApplication;
  private UpgradeController.AutoDownloadInWifiController jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private DownloadInfo jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  private UpgradeController()
  {
    a(false);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 12) || (paramInt1 == 2)) && (a() == 4)) {
      return 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null)) {
      return 1;
    }
    String str;
    Bundle localBundle;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString;
      localBundle = new Bundle();
      localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, "100686848");
      localBundle.putString(DownloadConstants.i, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString(DownloadConstants.e, this.jdField_a_of_type_AndroidAppApplication.getPackageName());
      localBundle.putInt(DownloadConstants.j, paramInt1);
      if (paramInt1 == 12) {
        localBundle.putBoolean(DownloadConstants.n, true);
      }
      localBundle.putString(DownloadConstants.h, "ANDROIDQQ.QQUPDATE");
      localBundle.putString(DownloadConstants.k, str);
      if (paramInt2 == 0) {
        break label347;
      }
      localBundle.putString(DownloadConstants.l, "_100686848");
      localBundle.putBoolean(DownloadConstants.w, false);
      i1 = paramInt2;
      if (paramInt1 != 5)
      {
        i1 = paramInt2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade != 0) {}
      }
    }
    for (int i1 = 0;; i1 = paramInt2)
    {
      localBundle.putString(DownloadConstants.b, "6633");
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int > 0)) {
        localBundle.putInt(DownloadConstants.d, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
      }
      localBundle.putBoolean(DownloadConstants.f, true);
      localBundle.putBoolean(DownloadConstants.g, true);
      localBundle.putInt(DownloadConstants.m, 1);
      localBundle.putInt(DownloadConstants.z, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bGray);
      DownloadApi.a(BaseActivity.sTopActivity, localBundle, 1, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, i1);
      return 0;
      str = "新版手Q";
      break;
      label347:
      localBundle.putBoolean(DownloadConstants.w, true);
    }
  }
  
  public static UpgradeController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController == null) {
      jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController = new UpgradeController();
    }
    return jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "invokeStateChangedToListeners:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((UpgradeController.OnStateChangedListener)localIterator.next()).a(paramInt, this);
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.a(this.jdField_a_of_type_AndroidAppApplication).a("", "IncrementalUpgradeErr", paramBoolean, 0L, 0L, localHashMap, "", true);
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a().a();
    if (localObject == null) {
      return;
    }
    ConfigHandler.a((QQAppInterface)localObject, b());
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 1))
    {
      if (!paramBoolean) {
        break label202;
      }
      str = ConfigHandler.a(this.jdField_a_of_type_AndroidAppApplication);
    }
    for (;;)
    {
      try
      {
        BaseActivity localBaseActivity = BaseActivity.sTopActivity;
        if ((localBaseActivity != null) && (str != null) && (!str.startsWith("com.tencent.av.")) && (!str.equals("com.tencent.mobileqq.activity.UserguideActivity")) && (!str.equals("com.tencent.mobileqq.activity.UpgradeDetailActivity"))) {
          localBaseActivity.runOnUiThread(new dbg(this, localBaseActivity, (QQAppInterface)localObject));
        }
        localObject = ((QQAppInterface)localObject).a(Conversation.class);
        if (localObject != null) {
          ((Handler)localObject).obtainMessage(1134018).sendToTarget();
        }
      }
      catch (Exception localException)
      {
        int i1;
        label202:
        continue;
      }
      i1 = 0;
      if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppApplication)) {
        i1 = 1;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", Integer.toString(i1));
      StatisticCollector.a(this.jdField_a_of_type_AndroidAppApplication).a("", "UpgradeErr", true, 0L, 0L, (HashMap)localObject, "", true);
      return;
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null) {
        ((Handler)localObject).obtainMessage(1134018).sendToTarget();
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      UpgradeController.OnHandleUpgradeFinishListener localOnHandleUpgradeFinishListener = (UpgradeController.OnHandleUpgradeFinishListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localOnHandleUpgradeFinishListener != null)
      {
        localOnHandleUpgradeFinishListener.a(0, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper, this);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  private void g()
  {
    ArrayList localArrayList = new ArrayList();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.b = "100686848";
    localDownloadInfo.d = this.jdField_a_of_type_AndroidAppApplication.getPackageName();
    localDownloadInfo.i = "6633";
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int > 0)) {
      localDownloadInfo.g = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
    }
    localArrayList.add(localDownloadInfo);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "queryDownloadInfo:" + localDownloadInfo);
    }
    DownloadApi.a(localArrayList, this);
  }
  
  private void h()
  {
    try
    {
      if (!b())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController = new UpgradeController.AutoDownloadInWifiController(this);
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void i()
  {
    try
    {
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController.b();
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void j()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "initDownloadEnv: " + this.c);
      }
      if (!this.c)
      {
        UpdateManager.a().a(this);
        DownloadApi.a(this);
        this.c = true;
      }
      return;
    }
    finally {}
  }
  
  private void k()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "releaseDownloadEnv: " + this.c);
      }
      if (this.c)
      {
        UpdateManager.a().b(this);
        UpdateManager.a().a();
        DownloadApi.b(this);
        this.c = false;
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
    {
      i1 = i2;
      switch (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a())
      {
      default: 
        i1 = i2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "getDownloadState: " + i1);
      }
      return i1;
      i1 = 4;
      continue;
      i1 = 1;
      continue;
      i1 = 2;
      continue;
      i1 = 3;
    }
  }
  
  public UpgradeDetailWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1)) {}
    while (((this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h == 1)) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    b(true);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onException:" + paramInt + ", " + paramString);
    }
    f();
  }
  
  public void a(Context paramContext)
  {
    int i2 = 1;
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a() != 4)) {
      return;
    }
    for (int i1 = i2;; i1 = 0)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h != 1) {
            continue;
          }
          i1 = i2;
        }
        a(5, i1);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UpgradeController", 2, "installApk:", paramContext);
      return;
    }
  }
  
  public void a(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadPause");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    a(a());
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.jdField_a_of_type_Boolean = false;
    i();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadError: " + paramInt1 + ", " + paramString);
    }
    a(a());
    if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppApplication)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramDownloadInfo = new HashMap();
      paramDownloadInfo.put("param_FailCode", Integer.toString(paramInt1));
      StatisticCollector.a(this.jdField_a_of_type_AndroidAppApplication).a("", "UpgradeErr", false, 0L, 0L, paramDownloadInfo, "", true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "onCheckUpdateFailed");
    }
    g();
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (ApkUpdateDetail)paramArrayList.get(0);
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramArrayList;
      if (QLog.isDevelopLevel()) {
        QLog.d("UpgradeController", 4, "onCheckUpdateSucceed:" + paramArrayList.url + " -- " + paramArrayList.updatemethod);
      }
    }
    g();
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ("100686848".equals(localDownloadInfo.b)) {
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = localDownloadInfo;
        }
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "onDownloadUpdate Status:" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a());
      }
      a(a());
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 2)) {
      return;
    }
    c();
    this.jdField_a_of_type_AndroidAppApplication = BaseApplicationImpl.a();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = new UpgradeDetailWrapper(null, null);
    this.b = false;
    k();
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null;
  }
  
  public boolean a(UpgradeInfo paramUpgradeInfo, UpgradeController.OnHandleUpgradeFinishListener paramOnHandleUpgradeFinishListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo = ConfigHandler.a(paramUpgradeInfo);
    if ((paramOnHandleUpgradeFinishListener == null) || (paramUpgradeInfo == null)) {}
    while (paramUpgradeInfo.iUpgradeType == 0) {
      return false;
    }
    j();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnHandleUpgradeFinishListener);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "handleUpgradeInfo packageName = " + this.jdField_a_of_type_AndroidAppApplication.getPackageName() + ", bGray = " + paramUpgradeInfo.bGray + ", versioncode = " + this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
    }
    paramUpgradeInfo = new ApkUpdateParam(this.jdField_a_of_type_AndroidAppApplication.getPackageName(), paramUpgradeInfo.bGray, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
    paramOnHandleUpgradeFinishListener = new ArrayList();
    paramOnHandleUpgradeFinishListener.add(paramUpgradeInfo);
    UpdateManager.a().b(paramOnHandleUpgradeFinishListener);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (b())) {
      c();
    }
  }
  
  public void b(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadWait");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    a(a());
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void b(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = ((DownloadInfo)paramList.get(0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onResult Status:" + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
    f();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "startDownload:" + paramBoolean + ", " + this.jdField_a_of_type_Boolean);
    }
    if (a() == 4) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramBoolean)
    {
      h();
      return;
    }
    c(false);
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController != null;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 17
    //   10: iconst_2
    //   11: ldc_w 521
    //   14: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 257	com/tencent/mobileqq/app/upgrade/UpgradeController:jdField_a_of_type_Boolean	Z
    //   21: ifeq +21 -> 42
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 257	com/tencent/mobileqq/app/upgrade/UpgradeController:jdField_a_of_type_Boolean	Z
    //   29: aload_0
    //   30: invokevirtual 523	com/tencent/mobileqq/app/upgrade/UpgradeController:e	()V
    //   33: aload_0
    //   34: invokespecial 440	com/tencent/mobileqq/app/upgrade/UpgradeController:i	()V
    //   37: ldc 28
    //   39: invokestatic 525	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: goto -13 -> 33
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	UpgradeController
    //   45	1	1	localException	Exception
    //   49	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	33	45	java/lang/Exception
    //   2	17	49	finally
    //   17	29	49	finally
    //   29	33	49	finally
    //   33	42	49	finally
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadFinish");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.jdField_a_of_type_Boolean = false;
    a(a());
    d(true);
    i();
  }
  
  public void c(String paramString1, String paramString2) {}
  
  void c(boolean paramBoolean)
  {
    int i2 = 1;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod != 4)) {
        break label55;
      }
    }
    label55:
    for (int i1 = 12;; i1 = 2)
    {
      if (paramBoolean) {
        i2 = 0;
      }
      a(i1, i2);
      return;
    }
  }
  
  public void d()
  {
    int i2 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "resumeDownload:");
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4) {
        i1 = 12;
      }
    }
    if (!b()) {}
    for (i2 = 1;; i2 = 0)
    {
      a(i1, i2);
      return;
    }
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadCancel");
    }
    this.jdField_a_of_type_Boolean = false;
    i();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    a(a());
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "pauseDownload:");
    }
    if (!b()) {}
    for (int i1 = 1;; i1 = 0)
    {
      a(3, i1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeController
 * JD-Core Version:    0.7.0.1
 */