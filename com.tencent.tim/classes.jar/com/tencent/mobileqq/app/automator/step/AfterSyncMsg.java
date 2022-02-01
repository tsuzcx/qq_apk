package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import aaai;
import aafp;
import aajt;
import acbn;
import accy;
import acdt;
import acff;
import achg;
import acja;
import acms;
import acny;
import acoh;
import acxu;
import acxw;
import acyd;
import aczr;
import adqy;
import aebm;
import aeee;
import aevk;
import aiur;
import alaj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import anmo;
import annu;
import annz;
import anoe;
import anot;
import anpc;
import anqa;
import aobw.a;
import aopi;
import aops;
import aoxw;
import apnu;
import apuf;
import aqfo;
import aqhq;
import aqiw;
import aqoe;
import aqum;
import armm;
import arnl;
import aroc;
import arwq;
import auqe;
import ausb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import jub;
import jxc;
import jxl;
import jxo;
import jxp;
import kbq;
import mqq.os.MqqHandler;
import obt;
import tns;
import too;
import txn;
import wiq;
import xry;
import ylm;
import ysf;
import yuu;
import zxj;
import zya;

public class AfterSyncMsg
  extends AsyncStep
{
  private void cNt()
  {
    if (anmo.cIA) {}
    try
    {
      Thread.sleep(1500L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  private void cNu()
  {
    Object localObject = (FriendListHandler)this.a.app.getBusinessHandler(1);
    this.a.app.a().cKk();
    this.a.app.a().cKl();
    cNv();
    ((acdt)this.a.app.getBusinessHandler(6)).cIl();
    ((acff)this.a.app.getManager(51)).cIW();
    ((FriendListHandler)localObject).cIM();
    ((FriendListHandler)localObject).cIJ();
    localObject = this.a.app.a();
    boolean bool1;
    if (!this.a.bJK)
    {
      bool1 = true;
      if (this.a.bJL) {
        break label346;
      }
    }
    label346:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((MessageHandler)localObject).bz(bool1, bool2);
      this.a.app.a().cKo();
      this.a.app.b().bEJ();
      ((PhoneContactManagerImp)this.a.app.getManager(11)).aC(false);
      try
      {
        localObject = (AccessibilityManager)this.a.app.getApp().getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("Talkback" + this.a.app.getCurrentAccountUin(), 0);
          long l = ((SharedPreferences)localObject).getLong("ReportTime", 0L);
          if (System.currentTimeMillis() - l > 86400000L)
          {
            anot.a(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
            ((SharedPreferences)localObject).edit().putLong("ReportTime", System.currentTimeMillis()).commit();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("QQInitHandler", 1, localThrowable, new Object[0]);
        }
      }
      anqa.fg(BaseApplicationImpl.getApplication());
      return;
      bool1 = false;
      break;
    }
  }
  
  private void cNv()
  {
    if (aqfo.isExistSDCard())
    {
      aqhq.UD(acbn.bmC + ".nomedia");
      aqhq.UD(acbn.bmD + ".nomedia");
    }
    if (this.a.O.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    List localList = localEntityManager.query(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          if (((Setting)localObject2).bUsrType != 4) {
            break label377;
          }
          if ((((Setting)localObject2).bHeadType != 0) || (((Setting)localObject2).systemHeadID != 0)) {
            break label237;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label237:
          int j;
          label262:
          label264:
          String str1;
          String str2;
          if (((Setting)localObject2).uin.startsWith("troop_"))
          {
            localObject1 = ((Setting)localObject2).uin.substring(6);
            j = 4;
            str1 = this.a.app.v(j, (String)localObject1);
            str2 = this.a.app.a((Setting)localObject2, j, (String)localObject1, 0);
            if (((Setting)localObject2).bHeadType != 0) {
              break label388;
            }
          }
          label388:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label397;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label262;
            label377:
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label264;
          }
          label397:
          if (((File)localObject2).exists())
          {
            aopi.ab(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localEntityManager.close();
    Object localObject1 = new File(acbn.bmC + "_thd/");
    if (((File)localObject1).exists()) {
      arwq.H((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.tim/files/head/_thd/");
    if (((File)localObject1).exists()) {
      arwq.H((File)localObject1);
    }
    this.a.O.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void cez()
  {
    aqum.a().setContext(BaseApplicationImpl.sApplication);
    aqum.a().eG(this.a.app);
    auqe.ewf();
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.2(this));
    UnifiedMonitor.Ql(SQLiteOpenHelper.WAL_ENABLE);
    txn.bEP();
    this.a.app.a().a().bEx();
    this.a.app.a().bEx();
    this.a.app.a().initLazy();
    this.a.app.cLW();
    this.a.app.b().aw(0, false);
    Object localObject1 = acny.a(this.a.app.getCurrentUin());
    if (acny.a(this.a.app, (PayRuleCfg)localObject1, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.3(this));
    }
    cNt();
    this.a.app.bIZ = true;
    this.a.app.cLL();
    this.a.app.Fy(false);
    if (this.a.bJJ) {
      ((acms)this.a.app.getBusinessHandler(20)).cMF();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.He()) });
    }
    localObject1 = this.a.app.getHandler(Conversation.class);
    ((MqqHandler)localObject1).sendEmptyMessage(1055);
    ((MqqHandler)localObject1).sendEmptyMessage(1059);
    ((MqqHandler)localObject1).sendEmptyMessage(1061);
    if (aroc.getNetType(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
    cNu();
    ((acja)this.a.app.getManager(56)).cLa();
    kbq.a().B(this.a.app);
    this.a.app.getManager(237);
    localObject1 = (jxo)this.a.app.getManager(238);
    if (localObject1 != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        ((jxo)localObject1).aAX();
      }
      ((jxo)localObject1).lx(this.a.app.getCurrentUin());
    }
    localObject1 = (jub)this.a.app.getManager(173);
    localObject1 = (PhoneContactManagerImp)this.a.app.getManager(11);
    ((PhoneContactManagerImp)localObject1).clI();
    aevk.X(this.a.app, this.a.app.getCurrentAccountUin());
    ((PhoneContactManagerImp)localObject1).i(true, true, 2);
    cNt();
    obt.ay(this.a.app);
    obt.m(this.a.app, obt.h(this.a.app));
    this.a.app.a().cKq();
    this.a.app.b().bEJ();
    aqoe.aFm();
    localObject1 = (yuu)this.a.app.getManager(102);
    ((yuu)localObject1).cmd();
    ((yuu)localObject1).cmf();
    Object localObject2 = (zxj)this.a.app.getManager(125);
    ((zxj)localObject2).BX(false);
    ((zxj)localObject2).csn();
    ((zxj)localObject2).csl();
    ((zxj)localObject2).csk();
    ((apuf)this.a.app.getManager(81)).eq(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg afterLogin");
    }
    this.a.app.a().cKs();
    this.a.app.cLS();
    SearchConfigManager.dO(this.a.app);
    wiq.aQ(this.a.app);
    anoe.dSE();
    anoe.dSF();
    anoe.dSI();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
    int i;
    if (!anmo.cIx)
    {
      ((acyd)this.a.app.a().a(2)).cOW();
      annz.a().start();
      annu.dSa();
      zya.bx(this.a.app);
      QWalletHelper.getPayCode(this.a.app);
      localObject2 = (aczr)this.a.app.getManager(199);
      if ((localObject2 != null) && (((aczr)localObject2).adh()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
        }
        ((aczr)localObject2).cPq();
      }
      cNt();
      ((ysf)this.a.app.getManager(34)).clw();
      ((accy)this.a.app.getBusinessHandler(4)).cId();
      localObject2 = ((ProxyManager)this.a.app.getManager(18)).a().q(true);
      i = 0;
    }
    for (;;)
    {
      if (i >= ((List)localObject2).size()) {
        break label1057;
      }
      if (((RecentUser)((List)localObject2).get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.app.b().k(((RecentUser)((List)localObject2).get(i)).uin, ((RecentUser)((List)localObject2).get(i)).getType()).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject3 = (MessageRecord)localIterator.next();
            localObject3 = jxp.a(this.a.app, (MessageRecord)localObject3, true);
            if (localObject3 != null)
            {
              jxl.a().b((jxc)localObject3);
              continue;
              anmo.amo = System.currentTimeMillis();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Perf", 2, "delay checkTroopTimeStamp");
              break;
            }
          }
        }
      }
      i += 1;
    }
    label1057:
    this.a.app.a().cNk();
    this.a.app.getManager(358);
    ((FlashChatManager)this.a.app.getManager(217)).dmU();
    DeviceProfileManager.a(new a());
    aoxw.a(this.a.app).dXJ();
    ausb.a(this.a.app).dXJ();
    localObject2 = (aaai)this.a.app.getManager(245);
    if (localObject2 != null) {
      ((aaai)localObject2).FK(1);
    }
    aafp.ctY();
    ((aops)this.a.app.getManager(233)).aSU();
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
    armm.eH(this.a.app);
    arnl.ekA();
    QQAppInterface.cLU();
    aajt.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((achg)this.a.app.getManager(159)).iu(1);
    xry.a(((yuu)localObject1).mApp).cez();
    localObject1 = (CardHandler)this.a.app.getBusinessHandler(2);
    if (localObject1 != null)
    {
      ((CardHandler)localObject1).cHH();
      ((CardHandler)localObject1).cHG();
      ((CardHandler)localObject1).cHE();
      ((CardHandler)localObject1).cHF();
      ((CardHandler)localObject1).cHP();
    }
    localObject1 = (ArkAppCenter)this.a.app.getManager(121);
    if (localObject1 != null)
    {
      localObject1 = ((ArkAppCenter)localObject1).a();
      if (localObject1 != null) {
        ((adqy)localObject1).cTS();
      }
    }
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    cNt();
    aiur.duF();
    ((apnu)this.a.app.getManager(363)).eaM();
    localObject1 = this.a.app.getHandler(Conversation.class);
    if (localObject1 != null) {
      ((MqqHandler)localObject1).obtainMessage(1134064).sendToTarget();
    }
    aobw.a.a(this.a.app).schedule();
    ThreadManager.executeOnSubThread(new AfterSyncMsg.6(this));
    ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.7(this));
    aeee.Ho(true);
    this.a.app.cLX();
    ((aebm)this.a.app.getBusinessHandler(168)).cVH();
  }
  
  private void doOnReconnect()
  {
    if (this.a.bJJ) {
      ((acms)this.a.app.getBusinessHandler(20)).cMF();
    }
    ((FriendListHandler)this.a.app.getBusinessHandler(1)).cIK();
    cNu();
    Object localObject1 = (alaj)this.a.app.getManager(179);
    if (localObject1 != null)
    {
      if (((alaj)localObject1).atj()) {
        aevk.ac(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else
    {
      ((PhoneContactManagerImp)this.a.app.getManager(11)).i(true, true, 3);
      this.a.app.b().bEJ();
      localObject1 = (zxj)this.a.app.getManager(125);
      ((zxj)localObject1).csl();
      ((zxj)localObject1).csk();
      zya.bx(this.a.app);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg onReconnect");
      }
      this.a.app.a().cKs();
      int i = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication());
      switch (i)
      {
      case 2: 
      default: 
        label232:
        if (i == 1) {
          ((PhotoPlusManager)this.a.app.getManager(169)).Ww(false);
        }
        tns.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
        QWalletHelper.getPayCode(this.a.app);
        if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.akY) > 3600000L) {
          ShortVideoResourceManager.H(this.a.app, 2);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = (CardHandler)this.a.app.getBusinessHandler(2);
      Object localObject2 = (aczr)this.a.app.getManager(199);
      if ((localObject1 != null) && (localObject2 != null) && (((aczr)localObject2).adh())) {
        ((CardHandler)localObject1).cHp();
      }
      localObject2 = (aaai)this.a.app.getManager(245);
      if (localObject2 != null) {
        ((aaai)localObject2).FK(2);
      }
      QQAppInterface.cLU();
      if (localObject1 != null)
      {
        ((CardHandler)localObject1).cHH();
        ((CardHandler)localObject1).cHG();
        ((CardHandler)localObject1).cHE();
        ((CardHandler)localObject1).cHF();
        ((CardHandler)localObject1).cHP();
      }
      return;
      ((alaj)localObject1).startDownload();
      break;
      ((ylm)this.a.app.getManager(138)).cjo();
      break label232;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  public int od()
  {
    switch (this.cyx)
    {
    default: 
      this.a.app.a().Fe(false);
      this.a.notifyUI(6008, false, null, true);
    }
    for (;;)
    {
      return 7;
      cez();
      ReporterMachine.a().bEZ();
      UnifiedMonitor.a().dSS();
      continue;
      doOnReconnect();
      continue;
      cNu();
    }
  }
  
  static class a
    implements DeviceProfileManager.a
  {
    public void sr(boolean paramBoolean)
    {
      if (paramBoolean) {
        paramBoolean = anpc.lH(3);
      }
      for (;;)
      {
        try
        {
          QLog.e("QQInitHandler_WalLog", 1, new Object[] { "onDpcPullFinished, isEnable: ", Boolean.valueOf(paramBoolean) });
          if (paramBoolean) {
            continue;
          }
          aqhq.deleteFile(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("QQInitHandler", 1, "onDpcPullFinished, get switch error", localThrowable);
          continue;
        }
        DeviceProfileManager.b(this);
        return;
        aqhq.createFile(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */