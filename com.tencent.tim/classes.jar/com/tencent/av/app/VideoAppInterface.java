package com.tencent.av.app;

import accg;
import acci;
import altt;
import android.app.Notification;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.ResultReceiver;
import android.text.TextUtils;
import anfb;
import anot;
import anpc.f;
import aolm;
import aomf;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igd;
import igs;
import ihl;
import ihm;
import iho;
import ihr;
import iia;
import iib;
import iic;
import iie;
import iig;
import iih;
import iii;
import iik;
import iim;
import iip;
import iiq;
import iis;
import iiv;
import iix;
import iiy;
import ijb;
import ijc;
import ijk;
import ijo;
import ijp;
import ijq;
import ikn;
import ikp;
import ikr;
import ilp;
import ilu;
import ior;
import itw;
import ivv;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Vector;
import jko;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class VideoAppInterface
  extends AppInterface
  implements anpc.f
{
  private static String TAG = "VideoAppInterface";
  public boolean RA;
  public boolean RB;
  private boolean RC;
  public boolean RD;
  public boolean RE;
  public boolean RF;
  protected boolean Ry;
  public boolean Rz;
  private aomf jdField_a_of_type_Aomf;
  private ihl jdField_a_of_type_Ihl;
  private ihm jdField_a_of_type_Ihm;
  iia jdField_a_of_type_Iia;
  iic jdField_a_of_type_Iic;
  iik jdField_a_of_type_Iik;
  iip jdField_a_of_type_Iip;
  private iiq jdField_a_of_type_Iiq;
  iiy jdField_a_of_type_Iiy = null;
  private ijb jdField_a_of_type_Ijb;
  private ijk jdField_a_of_type_Ijk;
  public ijp a;
  protected ijq a;
  ilu jdField_a_of_type_Ilu;
  private final ior jdField_a_of_type_Ior = new ior();
  protected int anE = 1;
  protected DeviceCapabilityExamination b;
  private EntityManagerFactory jdField_b_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  ihr jdField_b_of_type_Ihr;
  iib jdField_b_of_type_Iib;
  iie jdField_b_of_type_Iie;
  iig jdField_b_of_type_Iig;
  iih jdField_b_of_type_Iih;
  iii jdField_b_of_type_Iii;
  iim jdField_b_of_type_Iim;
  iis jdField_b_of_type_Iis;
  private Runnable bi;
  private Runnable bj = new VideoAppInterface.1(this);
  igs c;
  public VideoController d;
  protected List<acci> fc;
  protected Handler mHandler;
  
  public VideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private void acquireWakeLock()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)getApp().getSystemService("power");
      if (!localPowerManager.isScreenOn()) {
        localPowerManager.newWakeLock(1, "mobileqq:videoapp").acquire(10000L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void amJ()
  {
    AudioManager localAudioManager = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
    {
      this.Ry = localAudioManager.isSpeakerphoneOn();
      this.anE = localAudioManager.getMode();
    }
  }
  
  private void amK()
  {
    this.jdField_a_of_type_Iia.amx();
    this.jdField_a_of_type_Iic.amx();
    this.jdField_b_of_type_Iih.amx();
    this.jdField_b_of_type_Iim.amx();
    this.jdField_b_of_type_Iib.amx();
    this.jdField_b_of_type_Iie.amx();
    this.jdField_a_of_type_Iik.register();
    this.jdField_b_of_type_Iii.amx();
    this.jdField_b_of_type_Iig.amx();
    this.jdField_a_of_type_Iiq.register();
  }
  
  private void amL()
  {
    if (this.d == null) {
      b();
    }
    for (;;)
    {
      AudioHelper.rw("VideoAppInterface.onCreate.end");
      return;
      this.d.a(this);
    }
  }
  
  private void amN()
  {
    ThreadManager.post(this.bj, 10, null, true);
  }
  
  private void amO()
  {
    if ((AudioHelper.isDev()) && (AudioHelper.jY(13) == 1))
    {
      QLog.d(TAG, 1, "onCreate, 音视频进程在等待调试器连接(界面会无响应)");
      Debug.waitForDebugger();
    }
  }
  
  private void amQ()
  {
    QLog.d(TAG, 2, "registerExitProcessReceiver");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.exit_process");
    getApp().registerReceiver(new iix(this), localIntentFilter);
  }
  
  private void amR()
  {
    if (this.bi == null) {
      this.bi = new VideoAppInterface.4(this);
    }
    for (;;)
    {
      getHandler().postDelayed(this.bi, 5000L);
      return;
      getHandler().removeCallbacks(this.bi);
    }
  }
  
  public void T(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Iis.T(paramInt, paramString);
  }
  
  public void U(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Iis.U(paramInt, paramString);
  }
  
  public void V(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Ijp.V(paramInt, paramString);
  }
  
  public void X(String paramString, int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Iig.X(paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_b_of_type_Iis.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_b_of_type_Iis.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("red_touch_app_id", paramString);
    paramString = a(7, 0, 0, localBundle, null);
    if (paramString == null) {
      return null;
    }
    paramString.setClassLoader(RedAppInfo.class.getClassLoader());
    return altt.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public igs a()
  {
    return this.c;
  }
  
  public ihl a()
  {
    return this.jdField_a_of_type_Ihl;
  }
  
  public ihm a()
  {
    return this.jdField_a_of_type_Ihm;
  }
  
  public iiy a()
  {
    if (this.jdField_a_of_type_Iiy == null) {
      this.jdField_a_of_type_Iiy = new iiy(this);
    }
    return this.jdField_a_of_type_Iiy;
  }
  
  public ijo a(int paramInt)
  {
    return this.jdField_a_of_type_Ijp.a(paramInt);
  }
  
  public ilu a()
  {
    return this.jdField_a_of_type_Ilu;
  }
  
  public ior a()
  {
    if (this.RC) {
      return this.jdField_a_of_type_Ior;
    }
    synchronized (this.jdField_a_of_type_Ior)
    {
      String str;
      if (!this.RC)
      {
        str = AVNotifyCenter.dr(getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        int j = AVNotifyCenter.ak(getCurrentAccountUin());
        i = j;
        if (j != -1)
        {
          this.jdField_a_of_type_Ior.aj("BEAUTY_SKIN", j);
          i = j;
        }
        this.RC = true;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_Ior;
      label133:
      this.jdField_a_of_type_Ior.bj(str);
      int i = -1;
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_b_of_type_Ihr.a(paramBoolean, paramNotification);
  }
  
  public boolean a(itw paramitw)
  {
    return this.jdField_b_of_type_Iis.a(paramitw);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_b_of_type_Iis.a(paramString);
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
  
  public void addObserver(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      a().addObserver(paramObserver);
      if ((this.jdField_b_of_type_Iis != null) && (this.jdField_b_of_type_Iis.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public int aj(String paramString)
  {
    return this.jdField_b_of_type_Iis.aj(paramString);
  }
  
  public int ak(String paramString)
  {
    return a().at(paramString);
  }
  
  public boolean ak(long paramLong)
  {
    return this.jdField_b_of_type_Iis.ak(paramLong);
  }
  
  public void amD()
  {
    this.jdField_b_of_type_Iis.amD();
  }
  
  public void amM()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, anfb.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public void amP()
  {
    this.jdField_b_of_type_Iis.amE();
  }
  
  public void amS()
  {
    a().reset();
    amR();
  }
  
  public VideoController b()
  {
    if (this.d == null)
    {
      this.d = VideoController.a();
      this.d.a(this);
    }
    return this.d;
  }
  
  public void bL(long paramLong)
  {
    this.jdField_b_of_type_Iis.bL(paramLong);
  }
  
  public void c(String paramString, int paramInt, boolean paramBoolean)
  {
    a().aj(paramString, paramInt);
    if (paramBoolean)
    {
      amR();
      if (QLog.isDevelopLevel()) {
        QLog.i(TAG, 4, "setBeautyValue name[" + paramString + "], value[" + paramInt + "]");
      }
    }
  }
  
  public boolean ch(int paramInt)
  {
    return this.jdField_a_of_type_Ijp.ch(paramInt);
  }
  
  public int countObservers()
  {
    return a().countObservers();
  }
  
  public boolean cp(String paramString)
  {
    return this.jdField_b_of_type_Iis.cp(paramString);
  }
  
  public boolean cq(String paramString)
  {
    return this.jdField_b_of_type_Iis.cq(paramString);
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public String dh(String paramString)
  {
    return this.jdField_b_of_type_Iis.dh(paramString);
  }
  
  public String di(String paramString)
  {
    return this.jdField_b_of_type_Iis.di(paramString);
  }
  
  public int e(int paramInt, String paramString)
  {
    return this.jdField_b_of_type_Iis.e(paramInt, paramString);
  }
  
  public void e(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_b_of_type_Iis.e(paramLong1, paramString, paramLong2);
  }
  
  public boolean e(String paramString, int paramInt)
  {
    return this.jdField_b_of_type_Iis.e(paramString, paramInt);
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(TAG, 2, "receiveToService");
    this.jdField_a_of_type_Ijb.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public boolean g(int paramInt, long paramLong)
  {
    return this.jdField_b_of_type_Iis.g(paramInt, paramLong);
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
    return this.jdField_a_of_type_Ijk.a(this, paramInt);
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
  
  public String getDisplayName(int paramInt, String paramString1, String paramString2)
  {
    return this.jdField_b_of_type_Iis.getDisplayName(paramInt, paramString1, paramString2);
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_b_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_b_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public Handler getHandler()
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    return this.mHandler;
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { iho.class };
  }
  
  public aolm getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aomf == null) {
      this.jdField_a_of_type_Aomf = new aomf();
    }
    return this.jdField_a_of_type_Aomf.a(this, paramInt);
  }
  
  public String getSKey()
  {
    return this.jdField_b_of_type_Iis.getSKey();
  }
  
  public void h(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Iis.h(paramInt, paramString1, paramString2);
  }
  
  public void hW(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Iis != null) {
      this.jdField_b_of_type_Iis.hW(paramBoolean);
    }
  }
  
  public void hZ(boolean paramBoolean)
  {
    QLog.d(TAG, 1, "reportQuaProcessWakeUp() isBroadcastCreated = " + paramBoolean);
    if (paramBoolean) {
      this.RE = true;
    }
    for (;;)
    {
      if (this.RE)
      {
        if (!this.RF) {
          break;
        }
        ikn.I(this.RE, this.RF);
      }
      return;
      this.RF = true;
    }
    getHandler().postDelayed(new VideoAppInterface.2(this), 3000L);
  }
  
  public void iA(String paramString)
  {
    Object localObject = getApplication().refreAccountList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if (paramString.equals(localSimpleAccount.getUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Switch Account: " + paramString);
          }
          switchAccount(localSimpleAccount, null);
          if (this.d != null) {
            this.d.af(paramString);
          }
          this.d = null;
        }
      }
    }
  }
  
  public boolean isFriend(String paramString)
  {
    return this.jdField_b_of_type_Iis.isFriend(paramString);
  }
  
  public void iw(String paramString)
  {
    this.jdField_b_of_type_Iis.iw(paramString);
  }
  
  public void ix(String paramString)
  {
    this.jdField_b_of_type_Iis.ix(paramString);
  }
  
  public void iy(String paramString)
  {
    this.jdField_b_of_type_Iis.iy(paramString);
  }
  
  public void iz(String paramString)
  {
    ikr localikr = (ikr)a(4);
    if (localikr != null)
    {
      localikr.iZ(paramString);
      localikr.r(36, 1L);
      localikr.r(29, 1L);
      localikr.anB();
      ikp.r(16, 1L);
      ikp.reportMemory();
    }
    onDestroy();
  }
  
  public void kH(int paramInt)
  {
    long l = AudioHelper.hG();
    QLog.w(TAG, 1, "exitVideoProcess, reason[" + paramInt + "], videoController[" + this.d + "], reason[" + paramInt + "], seq[" + l + "]");
    int i;
    switch (paramInt)
    {
    default: 
      i = 260;
    }
    for (;;)
    {
      try
      {
        if (this.d != null)
        {
          int j = this.d.b().state;
          if ((j > 0) && (j <= 4))
          {
            String str = this.d.b().peerUin;
            this.d.O(str, i);
            this.d.ko(i);
            this.d.P(str, 0);
            this.d.OR = false;
            q(l, paramInt);
            return;
          }
          if (!this.d.OB) {
            continue;
          }
          this.d.b(this.d.alr, this.d.kJ, 72);
          continue;
        }
        QLog.d(TAG, 1, "exitVideoProcess System.exit ");
      }
      catch (Exception localException)
      {
        QLog.d(TAG, 1, "exitVideoProcess Exception System.exit ");
        QLog.flushLog();
        return;
      }
      QLog.flushLog();
      return;
      i = 254;
      continue;
      i = 255;
      continue;
      i = 256;
      continue;
      i = 257;
      continue;
      i = 258;
      continue;
      i = 259;
    }
  }
  
  public void kI(int paramInt)
  {
    this.jdField_a_of_type_Ijp.kI(paramInt);
  }
  
  public void l(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().m(paramArrayOfObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.isDev()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    AudioHelper.rw("VideoAppInterface.onCreate.begin");
    AVSoUtils.lx(-1045L);
    this.RA = true;
    ikp.e(this);
    ikp.ant();
    ikp.kQ(27);
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    amO();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.fx(BaseApplication.getContext());
    AudioHelper.rw("VideoAppInterface.onCreate.begin1");
    acquireWakeLock();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Iip = new iip(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Iip);
    this.jdField_a_of_type_Ijb = new ijb(this);
    this.jdField_a_of_type_Ijk = new ijk();
    this.jdField_a_of_type_Ijk.a(this.jdField_a_of_type_Ijb);
    this.jdField_a_of_type_Ijp = new ijp(this);
    this.jdField_a_of_type_Ijq = new ijq(this);
    amL();
    this.jdField_b_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Iic = new iic(this);
    this.jdField_a_of_type_Iia = new iia(this);
    this.jdField_b_of_type_Iih = new iih(this);
    this.jdField_b_of_type_Iim = new iim(this);
    this.jdField_b_of_type_Iib = new iib(this);
    this.jdField_b_of_type_Iie = new iie(this);
    this.jdField_a_of_type_Iik = new iik(this);
    this.jdField_b_of_type_Iii = new iii(this);
    this.jdField_b_of_type_Iig = new iig(this);
    this.jdField_a_of_type_Ihl = new ihl(this);
    this.jdField_a_of_type_Ihm = new ihm(this);
    this.jdField_a_of_type_Iiq = new iiq(this);
    this.jdField_b_of_type_Iis = new iis(this);
    this.jdField_b_of_type_Iis.init();
    this.jdField_b_of_type_Iis.amD();
    this.jdField_b_of_type_Ihr = new ihr(this);
    this.jdField_b_of_type_Ihr.bindService();
    this.jdField_a_of_type_Ilu = new ilu(this);
    this.c = new igs(this);
    AVReport.a().aqA();
    amJ();
    ThreadManager.post(new CameraUsageRunnable(), 5, null, true);
    this.fc = new Vector();
    amN();
    amK();
    try
    {
      MagnifierSDK.setUin(Long.parseLong(getAccount()));
    }
    catch (Exception paramBundle)
    {
      try
      {
        for (;;)
        {
          ReporterMachine.a();
          if (QLog.isDevelopLevel())
          {
            long l2 = System.currentTimeMillis();
            QLog.d("IVR_TS_" + TAG, 4, String.format("VideoAppInterface onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
          }
          AudioHelper.rw("VideoAppInterface.onCreate.end");
          amQ();
          ClientLogReport.instance().checkLocalReportRecord();
          if (AudioHelper.jY(25) == 1)
          {
            AudioHelper.UA("使用了index_disable_immersive");
            com.tencent.widget.immersive.ImmersiveUtils.i_support_immersive = 0;
          }
          return;
          paramBundle = paramBundle;
          QLog.e(TAG, 4, paramBundle.toString());
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          QLog.e(TAG, 1, "[Magnifier startMachine error]" + paramBundle);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.bi != null)
    {
      getHandler().removeCallbacks(this.bi);
      this.bi = null;
    }
    amR();
    this.bj = null;
    this.jdField_b_of_type_Ihr.amt();
    this.jdField_b_of_type_Iis.uninit();
    this.jdField_b_of_type_Iis.amE();
    if (this.jdField_a_of_type_Aomf != null) {}
    try
    {
      this.jdField_a_of_type_Aomf.onDestroy();
      this.jdField_a_of_type_Aomf = null;
      PtvTemplateManager.destroy();
      AVRedPacketManager.apY();
      this.jdField_a_of_type_Iik.unregister();
      this.jdField_b_of_type_Iii.amw();
      this.jdField_a_of_type_Iic.amw();
      this.jdField_a_of_type_Iia.amw();
      this.jdField_b_of_type_Iih.amw();
      this.jdField_b_of_type_Iim.amw();
      this.jdField_b_of_type_Iib.amw();
      this.jdField_b_of_type_Iie.amw();
      this.jdField_b_of_type_Iig.amw();
      this.jdField_a_of_type_Iiq.unRegister();
      ijc.onDestroy(getApp());
      ikp.release();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Aomf.onDestroy();
      }
    }
  }
  
  public void q(long paramLong, int paramInt)
  {
    if (paramInt < 200) {}
    for (int i = paramInt + 200;; i = paramInt)
    {
      boolean bool;
      if (i == 261) {
        bool = true;
      }
      for (;;)
      {
        QLog.w(TAG, 1, "video exit, mIsExit[" + this.RD + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_Ijp + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        this.RD = true;
        Object localObject;
        if ((this.d != null) && (this.d.b() != null))
        {
          if (this.d.b().Qu) {
            anot.a(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.Rz) && (this.d != null)) {
            this.d.alX();
          }
          this.Rz = false;
          ivv.a(paramLong, 1, getApplication());
          igd.aK(TAG, "exit video process clearNotification");
          QQNotificationManager.getInstance().cancel(TAG, 235);
          localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
          if (localObject == null) {}
        }
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.Ry);
          ((AudioManager)localObject).setMode(this.anE);
          localObject = jko.a(this);
          if (localObject != null) {
            ((jko)localObject).axu();
          }
          igd.aK(TAG, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_Ihl != null)
          {
            if (this.jdField_a_of_type_Ihl.sE()) {
              this.jdField_a_of_type_Ihl.hT(bool);
            }
            if (this.jdField_a_of_type_Ihl.sG()) {
              this.d.hR(false);
            }
            if (this.jdField_a_of_type_Ihl.sF()) {
              this.d.hP(false);
            }
          }
          return;
          bool = false;
          continue;
          anot.a(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            igd.aK(TAG, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void removeObserver(acci paramacci)
  {
    this.fc.remove(paramacci);
  }
  
  public boolean sI()
  {
    return this.jdField_b_of_type_Ihr.sI();
  }
  
  public boolean sK()
  {
    return this.jdField_b_of_type_Iis.sK();
  }
  
  public boolean sL()
  {
    return this.jdField_b_of_type_Iis.sL();
  }
  
  public boolean sM()
  {
    return this.jdField_b_of_type_Iis.sM();
  }
  
  public boolean sN()
  {
    return this.jdField_b_of_type_Iis.sN();
  }
  
  public boolean sO()
  {
    return this.jdField_b_of_type_Iis.sO();
  }
  
  public boolean sP()
  {
    return this.jdField_b_of_type_Iis.sP();
  }
  
  public boolean sQ()
  {
    return this.jdField_b_of_type_Iis.sQ();
  }
  
  public boolean sR()
  {
    return this.jdField_b_of_type_Iis.sR();
  }
  
  public boolean sS()
  {
    return this.jdField_b_of_type_Iis.sS();
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    igd.aJ(TAG, "sendToService");
    this.jdField_a_of_type_Ijb.a(paramToServiceMsg, null, iho.class);
  }
  
  public boolean sy()
  {
    return this.jdField_b_of_type_Iis.sy();
  }
  
  public boolean tq()
  {
    ior localior = a();
    if (localior.at("BEAUTY_SKIN") != 0) {
      return true;
    }
    if (AEFilterSupport.uP()) {
      return localior.uT();
    }
    return false;
  }
  
  public Map<String, Integer> u()
  {
    try
    {
      Map localMap = this.jdField_b_of_type_Iig.u();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long w(String paramString)
  {
    return this.jdField_b_of_type_Iis.v(paramString);
  }
  
  class CameraUsageRunnable
    implements Runnable
  {
    CameraUsageRunnable() {}
    
    public void run()
    {
      QLog.w(VideoAppInterface.access$000(), 1, "CameraUsageRunnable");
      ilp.az(VideoAppInterface.this.getApplication(), "CameraUsageRunnable");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */