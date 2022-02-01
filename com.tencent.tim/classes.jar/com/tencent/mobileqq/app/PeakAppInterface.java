package com.tencent.mobileqq.app;

import accg;
import acci;
import achu;
import acil;
import acsn;
import akvm;
import akwg;
import alvs;
import amby;
import ambz;
import amzs;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import andz;
import anjo;
import aolm;
import aomf;
import axbi;
import axbm;
import axiy;
import axjk;
import axpk;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;
import rmf;

public class PeakAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static axpk a;
  private ambz jdField_a_of_type_Ambz;
  private amzs jdField_a_of_type_Amzs;
  private aomf jdField_a_of_type_Aomf;
  private accg[] jdField_a_of_type_ArrayOfAccg = new accg[5];
  private BroadcastReceiver aZ = new acil(this);
  public boolean bIG;
  private boolean bIH;
  private String boR = "";
  private akvm jdField_c_of_type_Akvm;
  private QQStoryContext jdField_c_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private ConcurrentHashMap<Integer, Manager> eg = new ConcurrentHashMap(5);
  private EntityManagerFactory mFactory;
  private List<acci> xM;
  
  static
  {
    jdField_a_of_type_Axpk = new axpk();
  }
  
  public PeakAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private accg a(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new amby(this);
    case 1: 
      return new rmf(this);
    case 2: 
      return new achu(this);
    case 3: 
      return new axbm(this);
    }
    return new axbi(this);
  }
  
  private boolean a(BaseApplication paramBaseApplication, Intent paramIntent)
  {
    paramBaseApplication = paramIntent.getAction();
    if (paramBaseApplication == null) {}
    do
    {
      return false;
      axiy.i("PeakAppInterface", "exitPeakRunTime");
    } while (!paramBaseApplication.equals("com.tencent.process.exit"));
    return axjk.a().aOL();
  }
  
  private boolean abd()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.peak.q2v.AudioTransPush");
    this.app.registerReceiver(this.aZ, localIntentFilter);
    return this.app.registerReceiver(this.aZ, localIntentFilter) != null;
  }
  
  public void Ev(String paramString)
  {
    this.boR = paramString;
  }
  
  public SQLiteDatabase a()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new akwg((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((SQLiteOpenHelper)localObject).getReadableDatabase();
    }
    return null;
  }
  
  public void addObserver(acci paramacci)
  {
    addObserver(paramacci, false);
  }
  
  public void addObserver(acci paramacci, boolean paramBoolean)
  {
    if (!this.xM.contains(paramacci)) {
      this.xM.add(paramacci);
    }
  }
  
  public akvm b()
  {
    if (this.jdField_c_of_type_Akvm == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_c_of_type_Akvm = new akvm(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_c_of_type_Akvm;
  }
  
  public QQStoryContext c()
  {
    return this.jdField_c_of_type_ComTencentBizQqstoryAppQQStoryContext;
  }
  
  public void cKV()
  {
    this.jdField_c_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_c_of_type_ComTencentBizQqstoryAppQQStoryContext.onCreate();
  }
  
  public void cKW()
  {
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.app.getSystemService("accessibility");
      boolean bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.enableTalkBack = bool1;
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")))
    {
      this.jdField_a_of_type_Amzs.b(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_Ambz.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
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
    Object localObject1 = this.jdField_a_of_type_ArrayOfAccg[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAccg)
    {
      accg localaccg = this.jdField_a_of_type_ArrayOfAccg[paramInt];
      localObject1 = localaccg;
      if (localaccg == null)
      {
        localaccg = a(paramInt);
        localObject1 = localaccg;
        if (localaccg != null)
        {
          this.jdField_a_of_type_ArrayOfAccg[paramInt] = localaccg;
          localObject1 = localaccg;
        }
      }
      return localObject1;
    }
  }
  
  public List<acci> getBusinessObserver(int paramInt)
  {
    if (paramInt == 0) {
      return this.xM;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    return this.boR;
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.mFactory == null) {
      this.mFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.mFactory;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject2 = (Manager)this.eg.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      switch (paramInt)
      {
      default: 
        if (this.eg.get(Integer.valueOf(paramInt)) != null) {
          localObject1 = (Manager)this.eg.get(Integer.valueOf(paramInt));
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getManager(paramInt);
      }
      return localObject2;
      localObject2 = new acsn();
      break;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.eg.put(Integer.valueOf(paramInt), localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public aolm getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aomf == null) {
      this.jdField_a_of_type_Aomf = new aomf();
    }
    return this.jdField_a_of_type_Aomf.a(this, paramInt);
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    Object localObject = getCurrentAccountUin();
    localObject = ((QQEntityManagerFactory)getEntityManagerFactory((String)localObject)).build((String)localObject);
    if (localObject != null) {
      return ((SQLiteOpenHelper)localObject).getReadableDatabase();
    }
    return null;
  }
  
  public void onBeforeExitProc()
  {
    axiy.i("PeakAppInterface", "onBeforeExitProc");
    axjk.a().clean();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PeakAppInterface", 2, "onCreate");
    }
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    cKV();
    this.xM = new Vector();
    this.bIH = abd();
    this.jdField_a_of_type_Ambz = new ambz(this);
    this.jdField_a_of_type_Amzs = new amzs(this);
    jdField_a_of_type_Axpk.adh("{1000,1002}");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    alvs.a().unbindService(BaseApplicationImpl.sApplication);
    ??? = PresendPicMgr.a(null);
    if (??? != null) {
      ((PresendPicMgr)???).release();
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAccg)
      {
        accg[] arrayOfaccg = this.jdField_a_of_type_ArrayOfAccg;
        int j = arrayOfaccg.length;
        i = 0;
        if (i < j)
        {
          accg localaccg = arrayOfaccg[i];
          if (localaccg == null) {
            break label168;
          }
          localaccg.onDestroy();
          break label168;
        }
        if (this.jdField_a_of_type_Aomf == null) {}
      }
      try
      {
        this.jdField_a_of_type_Aomf.onDestroy();
        this.jdField_a_of_type_Aomf = null;
        if (this.bIH)
        {
          this.app.unregisterReceiver(this.aZ);
          this.bIH = false;
        }
        if (this.bIG) {
          anjo.a(this).C(this);
        }
        jdField_a_of_type_Axpk.onDestroy();
        if (QLog.isColorLevel()) {
          QLog.d("PeakAppInterface", 2, "onDestroy");
        }
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Aomf.onDestroy();
        }
      }
      label168:
      i += 1;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    axiy.i("PeakAppInterface", "onReceiveAccountAction");
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    axiy.i("PeakAppInterface", "onReceiveAccountAction");
    return a(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  public void onRunningBackground()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("PeakAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    LpReportManager.getInstance().startReportImediately(2);
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    ThreadManager.executeOnFileThread(new PeakAppInterface.2(this));
  }
  
  public void removeObserver(acci paramacci)
  {
    this.xM.remove(paramacci);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")))
    {
      this.jdField_a_of_type_Amzs.g(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_Ambz.a(paramToServiceMsg, null, andz.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */