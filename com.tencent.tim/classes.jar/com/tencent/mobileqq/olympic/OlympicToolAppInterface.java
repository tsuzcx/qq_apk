package com.tencent.mobileqq.olympic;

import accg;
import acci;
import adaw;
import adfb;
import adua;
import akqb;
import android.content.Intent;
import android.os.Bundle;
import anot;
import aolm;
import aomf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

public class OlympicToolAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public akqb a;
  private aomf jdField_a_of_type_Aomf;
  a jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface$a = null;
  public HashMap<Integer, accg> el;
  public List<acci> fc;
  Map<Integer, Manager> iX = new HashMap(20);
  
  public OlympicToolAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.iX.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.iX.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void addObserver(acci paramacci)
  {
    addObserver(paramacci, false);
  }
  
  public void addObserver(acci paramacci, boolean paramBoolean)
  {
    if (!this.fc.contains(paramacci)) {
      this.fc.add(paramacci);
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_Akqb.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.getAppId();
  }
  
  public accg getBusinessHandler(int paramInt)
  {
    accg localaccg1 = (accg)this.el.get(Integer.valueOf(paramInt));
    if (localaccg1 == null) {}
    for (;;)
    {
      accg localaccg2;
      synchronized (this.el)
      {
        localaccg2 = (accg)this.el.get(Integer.valueOf(paramInt));
        if (localaccg2 == null) {
          break label106;
        }
        return localaccg2;
        if (localaccg1 != null) {
          this.el.put(Integer.valueOf(paramInt), localaccg1);
        }
        return localaccg1;
      }
      Object localObject2 = new adua(this);
      continue;
      localObject2 = new adaw(this);
      continue;
      return localObject2;
      label106:
      localObject2 = localaccg2;
      switch (paramInt)
      {
      }
      localObject2 = localaccg2;
    }
  }
  
  public List<acci> getBusinessObserver(int paramInt)
  {
    if (paramInt == 0) {
      return this.fc;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public String getModuleId()
  {
    return "module_olympic";
  }
  
  public aolm getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aomf == null) {
      this.jdField_a_of_type_Aomf = new aomf();
    }
    return this.jdField_a_of_type_Aomf.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onBeforeExitProc");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Akqb = new akqb(this);
    this.fc = new Vector();
    this.el = new HashMap(10);
    AudioHelper.a(this.app, getLongAccountUin());
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onDestroy ,FaceScanModelsLoader.hasFaceModelInit = " + adfb.bMx);
    }
    super.onDestroy();
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onReceiveAccountAction");
    }
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onReceiveLegalExitProcAction");
    }
    return false;
  }
  
  public void removeObserver(acci paramacci)
  {
    this.fc.remove(paramacci);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    anot.a(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Akqb.g(paramToServiceMsg);
  }
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface$a = new a(null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface$a);
    super.start(paramBoolean);
  }
  
  class a
    implements INetInfoHandler
  {
    private a() {}
    
    public void onNetMobile2None()
    {
      if (OlympicToolAppInterface.i(OlympicToolAppInterface.this) != null) {
        OlympicToolAppInterface.j(OlympicToolAppInterface.this).onNetMobile2None();
      }
    }
    
    public void onNetMobile2Wifi(String paramString)
    {
      if (OlympicToolAppInterface.g(OlympicToolAppInterface.this) != null) {
        OlympicToolAppInterface.h(OlympicToolAppInterface.this).onNetMobile2Wifi(paramString);
      }
    }
    
    public void onNetNone2Mobile(String paramString)
    {
      if (OlympicToolAppInterface.a(OlympicToolAppInterface.this) != null) {
        OlympicToolAppInterface.b(OlympicToolAppInterface.this).onNetNone2Mobile(paramString);
      }
    }
    
    public void onNetNone2Wifi(String paramString)
    {
      if (OlympicToolAppInterface.e(OlympicToolAppInterface.this) != null) {
        OlympicToolAppInterface.f(OlympicToolAppInterface.this).onNetNone2Wifi(paramString);
      }
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      if (OlympicToolAppInterface.c(OlympicToolAppInterface.this) != null) {
        OlympicToolAppInterface.d(OlympicToolAppInterface.this).onNetWifi2Mobile(paramString);
      }
    }
    
    public void onNetWifi2None()
    {
      if (OlympicToolAppInterface.k(OlympicToolAppInterface.this) != null) {
        OlympicToolAppInterface.l(OlympicToolAppInterface.this).onNetWifi2None();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolAppInterface
 * JD-Core Version:    0.7.0.1
 */