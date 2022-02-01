package com.tencent.mfsdk;

import aeif;
import aewh;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.config.APMConfRoot;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.Config;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import sxa;
import txg;
import txi;
import txj;
import txk;
import txm;
import txq;
import txw;
import tya;
import tyb;
import tyk;
import tym;
import tyo;
import tys;
import tyt;

public class MagnifierSDK
{
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  public static tyt a;
  public static MqqHandler b;
  public static SharedPreferences.Editor editor;
  public static long uin;
  public static String version = "";
  public static SharedPreferences x;
  private APMConfRoot jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot;
  private APMConfig jdField_a_of_type_ComTencentMfsdkConfigAPMConfig;
  public Config a;
  private txj jdField_a_of_type_Txj = new tyk();
  private txk jdField_a_of_type_Txk = new tyo();
  txm jdField_a_of_type_Txm = null;
  private txq jdField_a_of_type_Txq = new tym();
  private txw jdField_a_of_type_Txw = new txw();
  private tys jdField_a_of_type_Tys = new tys();
  private txq b;
  private AtomicBoolean bq = new AtomicBoolean(false);
  private txq c = new tyb();
  private txq d = new tys();
  
  private MagnifierSDK()
  {
    this.jdField_b_of_type_Txq = new tya();
    this.jdField_a_of_type_ComTencentMfsdkConfigConfig = new Config();
  }
  
  public static SharedPreferences a(Application paramApplication)
  {
    return paramApplication.getSharedPreferences("MagnifierSDK.QAPM", 4);
  }
  
  public static MagnifierSDK a()
  {
    if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null) {
        jdField_a_of_type_ComTencentMfsdkMagnifierSDK = new MagnifierSDK();
      }
      return jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
    }
    finally {}
  }
  
  public static String getProductId()
  {
    return "172";
  }
  
  public static String oB()
  {
    return "V 3.4.4." + aewh.getVersionCode(BaseApplicationImpl.sApplication) + ".r" + AppSetting.getRevision();
  }
  
  public static void setUin(long paramLong)
  {
    QLog.i("MagnifierSDK.QAPM", 1, "lifeCycle setUin " + paramLong);
    uin = paramLong;
    QAPM.setProperty(102, String.valueOf(paramLong));
  }
  
  public APMConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null)
      {
        this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot = ((APMConfRoot)aeif.a().o(255));
        if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot != null) {
          this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig = this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfRoot.pub;
        }
        if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig == null) {
          this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig = new APMConfig();
        }
      }
      return this.jdField_a_of_type_ComTencentMfsdkConfigAPMConfig;
    }
    finally {}
  }
  
  public txg a()
  {
    return this.jdField_b_of_type_Txq;
  }
  
  public txi a()
  {
    return this.jdField_a_of_type_Txw;
  }
  
  public txj a()
  {
    return this.jdField_a_of_type_Txj;
  }
  
  public txk a()
  {
    return this.jdField_a_of_type_Txk;
  }
  
  public txm a()
  {
    try
    {
      if (this.jdField_a_of_type_Txm == null) {
        this.jdField_a_of_type_Txm = new txm();
      }
      txm localtxm = this.jdField_a_of_type_Txm;
      return localtxm;
    }
    finally {}
  }
  
  public txq a()
  {
    return this.jdField_a_of_type_Txq;
  }
  
  public txg b()
  {
    return this.c;
  }
  
  public txg c()
  {
    return this.d;
  }
  
  public void start()
  {
    if (this.bq.compareAndSet(false, true))
    {
      jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
      version = oB();
      RunSDKRunnable localRunSDKRunnable = new RunSDKRunnable(BaseApplicationImpl.getApplication());
      jdField_b_of_type_MqqOsMqqHandler.post(localRunSDKRunnable);
      QLog.i("MagnifierSDK.QAPM", 1, "startVersion = " + version + " gray=" + false + " pub=" + true);
    }
  }
  
  public void uF(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "beginScene:" + paramString);
    }
    this.jdField_a_of_type_Tys.uF(paramString);
  }
  
  public void uG(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPM", 2, "endScene:" + paramString);
    }
    this.jdField_a_of_type_Tys.uG(paramString);
  }
  
  class RunSDKRunnable
    implements Runnable
  {
    private Application sApp;
    
    public RunSDKRunnable(Application paramApplication)
    {
      this.sApp = paramApplication;
    }
    
    public void run()
    {
      MagnifierSDK.x = MagnifierSDK.a(this.sApp);
      MagnifierSDK.editor = MagnifierSDK.x.edit();
      MagnifierSDK.jdField_a_of_type_Tyt = tyt.a(this.sApp.getApplicationContext());
      MagnifierSDK.this.jdField_a_of_type_ComTencentMfsdkConfigConfig.loadLocalConfigs();
      if (BaseApplicationImpl.sProcessId == 1) {
        MagnifierSDK.a().c().start();
      }
      if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 7)) {
        MagnifierSDK.a().b().start();
      }
      if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2)) {
        MagnifierSDK.a().a().start();
      }
      if (BaseApplicationImpl.sProcessId != 4) {
        MagnifierSDK.a().a().start();
      }
      MagnifierSDK.a().a().start();
      if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 9) || (BaseApplicationImpl.sProcessId == 11) || (BaseApplicationImpl.sProcessId == 10))
      {
        MagnifierSDK.a().a().start();
        MagnifierSDK.a().a().start();
        if (BaseApplicationImpl.sProcessId != 1) {
          break label268;
        }
        MemoryManager.a().cJX();
      }
      for (;;)
      {
        if ((!MagnifierSDK.a().a().runIo) && (MagnifierSDK.a().a().runDb)) {}
        return;
        label268:
        sxa.a().bBJ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK
 * JD-Core Version:    0.7.0.1
 */