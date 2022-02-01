package com.tencent.mobileqq.upgrade;

import acbn;
import ahch;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import anot;
import aqiw;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jox;
import jpn;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class UpgradeTIMManager
  implements INetInfoHandler, Manager
{
  private static final String csk = acbn.SDCARD_PATH + "tim";
  private DownloadTask a;
  private File aB;
  private QQAppInterface app;
  private UpgradeTIMWrapper jdField_c_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper;
  private jpn jdField_c_of_type_Jpn;
  private boolean cTu;
  private Handler handler = new Handler(Looper.getMainLooper());
  
  public UpgradeTIMManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.jdField_c_of_type_Jpn = new jpn();
    this.aB = new File(csk, "tim.apk");
  }
  
  private boolean aBO()
  {
    if (this.aB.exists())
    {
      long l = this.aB.lastModified();
      if ((System.currentTimeMillis() - l) / 86400000L > 14L) {
        this.aB.delete();
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private void asB()
  {
    this.a = null;
    edg();
    if (this.jdField_c_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper != null) {
      b(this.app, this.jdField_c_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMManager |showUpgradeInfo");
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.obtainMessage(1134045, paramUpgradeTIMWrapper).sendToTarget();
    }
  }
  
  private void cg(String paramString1, String paramString2)
  {
    this.a = new DownloadTask(paramString1, paramString2);
    ThreadManager.post(this.a, 5, null, true);
    edf();
  }
  
  private void edf()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this);
    this.cTu = true;
  }
  
  private void edg()
  {
    if (!this.cTu) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    this.cTu = false;
  }
  
  private void onDownloadSuccess()
  {
    anot.a(this.app, "CliOper", "", "", "0X8008A48", "0X8008A48", 0, 0, "", "", "", "");
    if (this.aB.exists())
    {
      PackageInfo localPackageInfo = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(this.aB.getAbsolutePath(), 64);
      if (localPackageInfo == null) {
        break label85;
      }
      if (!"com.tencent.tim".equals(localPackageInfo.packageName)) {
        this.aB.delete();
      }
    }
    for (;;)
    {
      asB();
      return;
      label85:
      this.aB.delete();
    }
  }
  
  public void Uj(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo");
    }
    if (this.a != null) {}
    while ((aBO()) || (!aqiw.isWifiConnected(BaseApplication.getContext()))) {
      return;
    }
    cg(paramString, this.aB.getPath());
  }
  
  public void a(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, with wrapper");
    }
    if (this.a != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper = paramUpgradeTIMWrapper;
      return;
    }
    if (aBO())
    {
      b(paramQQAppInterface, paramUpgradeTIMWrapper);
      return;
    }
    if (!aqiw.isWifiConnected(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, wifi not connected...");
      }
      b(paramQQAppInterface, paramUpgradeTIMWrapper);
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper = paramUpgradeTIMWrapper;
    cg(paramUpgradeTIMWrapper.url, this.aB.getPath());
  }
  
  public void cl(Context paramContext, String paramString)
  {
    int j = 0;
    int i = j;
    if (aBO())
    {
      i = j;
      if (ahch.dh(this.aB.getAbsolutePath()) == 0) {
        i = 1;
      }
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "jumpToDownloadTIM| no existing apk file, download.");
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_operation_bar", true);
      paramContext.startActivity(localIntent);
      if (this.a != null)
      {
        DownloadTask.a(this.a);
        this.a = null;
      }
      edg();
    }
  }
  
  public void onDestroy()
  {
    edg();
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
    }
    if (this.a != null) {
      DownloadTask.b(this.a);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetNone2Mobile, pause download");
    }
    if (this.a != null) {
      DownloadTask.a(this.a);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
    }
    if (this.a != null) {
      DownloadTask.b(this.a);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2Mobile, pause download");
    }
    if (this.a != null) {
      DownloadTask.a(this.a);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, pause download");
    }
    if (this.a != null) {
      DownloadTask.a(this.a);
    }
  }
  
  class DownloadTask
    implements Runnable, jox
  {
    boolean isStop;
    String path;
    int retryTime;
    String url;
    
    public DownloadTask(String paramString1, String paramString2)
    {
      this.url = paramString1;
      this.path = paramString2;
    }
    
    private void dIP()
    {
      UpgradeTIMManager.a(UpgradeTIMManager.this).postDelayed(new UpgradeTIMManager.DownloadTask.1(this), 3000L);
    }
    
    private void resume()
    {
      if (this.isStop)
      {
        ThreadManager.post(this, 5, null, false);
        this.isStop = false;
      }
    }
    
    private void stop()
    {
      if (!this.isStop)
      {
        ThreadManager.post(new UpgradeTIMManager.DownloadTask.2(this), 8, null, false);
        this.isStop = true;
      }
    }
    
    public void loaded(String paramString, int paramInt)
    {
      QLog.d("UpgradeTIMManager", 2, new Object[] { "on download result, code=", Integer.valueOf(paramInt) });
      if (paramInt == 0)
      {
        UpgradeTIMManager.b(UpgradeTIMManager.this);
        return;
      }
      if (paramInt == 10)
      {
        paramInt = this.retryTime;
        this.retryTime = (paramInt + 1);
        if (paramInt < 3)
        {
          dIP();
          return;
        }
      }
      UpgradeTIMManager.a(UpgradeTIMManager.this);
    }
    
    public void progress(int paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("UpgradeTIMManager", 4, new Object[] { "downloading,  progress = ", Integer.valueOf(paramInt) });
      }
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "start download...");
      }
      if (!aqiw.isWifiConnected(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeTIMManager", 2, "run download, wifi not connected...");
        }
        UpgradeTIMManager.a(UpgradeTIMManager.this);
        return;
      }
      anot.a(UpgradeTIMManager.a(UpgradeTIMManager.this), "CliOper", "", "", "0X8008A47", "0X8008A47", 0, 0, "", "", "", "");
      UpgradeTIMManager.a(UpgradeTIMManager.this).a(BaseApplication.getContext(), this.url, this.path, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMManager
 * JD-Core Version:    0.7.0.1
 */