import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.PopupMenu;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.redbag.AVRedBagMgr.4;
import com.tencent.av.ui.redbag.AVRedBagMgr.6;
import com.tencent.av.ui.redbag.AVRedBagMgr.7;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class jht
  extends ijo
{
  public boolean Zq = false;
  jhr.a jdField_a_of_type_Jhr$a;
  public jht.b a;
  jhz jdField_a_of_type_Jhz = null;
  jia.a jdField_a_of_type_Jia$a;
  jia jdField_a_of_type_Jia = null;
  public jig a;
  jih jdField_a_of_type_Jih;
  jim jdField_a_of_type_Jim = null;
  jis jdField_a_of_type_Jis = null;
  jho jdField_b_of_type_Jho = null;
  jhr jdField_b_of_type_Jhr = null;
  WeakReference<jht.a> bO;
  WeakReference<AVActivity> bx;
  public String mPeerUin;
  
  public jht(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, jil paramjil)
  {
    if (paramjil.Zw) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).c(paramjil.Sn, paramjil.St, paramjil.Sp, paramjil.Sq, paramjil.aAf);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + paramjil.St + "], mPlayerGetRedbag_ResultCode[" + paramjil.Sp + "], mPlayerGetRedbag_ResultState[" + paramjil.Sq + "], mHitScore[" + paramjil.aAf + "], mSucAboutGame[" + paramjil.Zw + "]");
  }
  
  private void init()
  {
    String str = this.mPeerUin;
    if ((!TextUtils.isEmpty(this.mPeerUin)) && (this.mPeerUin.equals(this.mApp.b().b().peerUin))) {
      return;
    }
    this.mPeerUin = this.mApp.b().b().peerUin;
    QLog.w("AVRedBag", 1, "init, mPeerUin[" + str + "->" + this.mPeerUin + "]");
    ky("init_when_not_support");
    this.mApp.addObserver(new jhu(this));
  }
  
  public jhr.a a()
  {
    return this.jdField_a_of_type_Jhr$a;
  }
  
  jht.a a()
  {
    WeakReference localWeakReference = this.bO;
    if (localWeakReference != null) {
      return (jht.a)localWeakReference.get();
    }
    return null;
  }
  
  public jhz a()
  {
    if (this.jdField_a_of_type_Jhz == null) {
      this.jdField_a_of_type_Jhz = new jhz(this);
    }
    return this.jdField_a_of_type_Jhz;
  }
  
  public jia a(AVActivity paramAVActivity, jil paramjil, WeakReference<jia.a> paramWeakReference)
  {
    if (this.jdField_a_of_type_Jia != null)
    {
      this.jdField_a_of_type_Jia.cancel("startActivity_getRegBag");
      this.jdField_a_of_type_Jia = null;
    }
    jia localjia = new jia(this);
    if (localjia.a(this.mApp, paramAVActivity, paramjil, paramWeakReference)) {
      this.jdField_a_of_type_Jia = localjia;
    }
    return localjia;
  }
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_Jht$b == null) {
      this.jdField_a_of_type_Jht$b = new jht.b();
    }
  }
  
  public void a(AVActivity paramAVActivity, jil paramjil)
  {
    this.jdField_a_of_type_Jia$a = new jhx(this);
    paramAVActivity = a(paramAVActivity, paramjil, new WeakReference(this.jdField_a_of_type_Jia$a));
    if (paramAVActivity.b.aAj != 1)
    {
      a("getRedBag_Fail", this.mApp, paramAVActivity.b);
      return;
    }
    QLog.w("AVRedBag", 1, "callGetRedBag, 发送中，等红包回调通知, getRedBag[" + paramAVActivity.pC + "]");
  }
  
  void a(String paramString, VideoAppInterface paramVideoAppInterface, jil paramjil)
  {
    this.jdField_a_of_type_Jia$a = null;
    a(paramVideoAppInterface, paramjil);
    paramVideoAppInterface = this.jdField_a_of_type_Jim;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + paramjil + "], src[" + paramVideoAppInterface.b + "]");
      paramVideoAppInterface.f(paramjil);
    }
  }
  
  void a(String paramString1, AVActivity paramAVActivity, String paramString2)
  {
    boolean bool2 = false;
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "prepareAVActivity, Begin, from[" + paramString1 + "], seq[" + l + "]");
    }
    irk.a().pause(8);
    if (this.jdField_a_of_type_Jih == null) {
      this.jdField_a_of_type_Jih = new jih(this);
    }
    this.jdField_a_of_type_Jih.hook();
    this.mApp.l(new Object[] { Integer.valueOf(134) });
    new iya.f(l, "prepareAVActivity", 2, null).n(this.mApp);
    this.mApp.l(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.mApp.l(new Object[] { Integer.valueOf(8001), paramString1 });
    this.mApp.l(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.mApp.ch(2);
    if (bool3) {
      ((ikl)this.mApp.a(2)).a(l, null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.b;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.y(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(paramAVActivity.getApplicationContext());
      if (paramString2 != null)
      {
        paramString2.cp(l);
        iwu.a(l, this.mApp);
      }
      kB(paramString1);
      paramString1 = new StringBuilder().append("prepareAVActivity, end, from[").append(paramString1).append("], seq[").append(l).append("], isPendantActive[").append(bool3).append("], setVideoToBigView[").append(bool1).append("], avActivity[").append(paramAVActivity).append("], videoLayerUI[");
      bool1 = bool2;
      if (localVideoLayerUI != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + "]");
      return;
    }
  }
  
  void a(jhz paramjhz)
  {
    kR(true);
    kz("onGameStart_from_GameSink");
    this.mApp.b().b().Ri = true;
    this.mApp.getHandler().post(new AVRedBagMgr.6(this));
  }
  
  void a(jil paramjil)
  {
    if (this.bx == null)
    {
      QLog.w("AVRedBag", 1, "showResultUI, mWeakAVActivity为空");
      return;
    }
    jim localjim = new jim(this);
    localjim.a(paramjil, new jhw(this));
    this.jdField_a_of_type_Jim = localjim;
  }
  
  public boolean a(AVActivity paramAVActivity, int paramInt)
  {
    if (this.jdField_a_of_type_Jis != null)
    {
      QLog.w("AVRedBag", 1, "startActivity_SendRedBag, 上次的红包操作还未结束");
      this.jdField_a_of_type_Jis.cancel();
      this.jdField_a_of_type_Jis = null;
    }
    this.jdField_a_of_type_Jis = new jis(this);
    boolean bool = this.jdField_a_of_type_Jis.a(this.mApp, paramInt, paramAVActivity, new jhv(this));
    if (bool)
    {
      this.bx = new WeakReference(paramAVActivity);
      kQ(true);
      return bool;
    }
    this.jdField_a_of_type_Jis = null;
    return bool;
  }
  
  void awv()
  {
    if (this.mApp != null) {
      this.mApp.getHandler().post(new AVRedBagMgr.7(this));
    }
  }
  
  public void aww()
  {
    if (this.jdField_a_of_type_Jis != null)
    {
      this.jdField_a_of_type_Jis.cancel();
      this.jdField_a_of_type_Jis = null;
      kQ(false);
    }
  }
  
  public void awx() {}
  
  public void awy()
  {
    QLog.w("AVRedBag", 1, "requestSendMode");
    ije localije = ije.a(this.mApp);
    if (localije != null) {
      localije.a(11, 6, null);
    }
  }
  
  public VideoAppInterface b()
  {
    return this.mApp;
  }
  
  public void b(WeakReference<jht.a> paramWeakReference)
  {
    this.bO = paramWeakReference;
  }
  
  void b(jhr.a parama)
  {
    if (this.mApp == null) {
      return;
    }
    kz("onDownloadResResult");
    if ((parama != null) && (parama.Zp)) {
      ky("onDownloadResResult");
    }
    this.jdField_b_of_type_Jhr = null;
  }
  
  void b(jil paramjil)
  {
    kR(false);
    kz("onGameEnd_from_GameSink");
    if (this.jdField_a_of_type_Jig != null) {
      kQ(this.jdField_a_of_type_Jig.Zv);
    }
    this.mApp.b().b().Ri = false;
    c(paramjil);
    a(paramjil);
    if (this.jdField_a_of_type_Jih != null)
    {
      this.jdField_a_of_type_Jih.awD();
      this.jdField_a_of_type_Jih = null;
    }
    this.jdField_a_of_type_Jhz = null;
    this.mApp.l(new Object[] { Integer.valueOf(8002) });
  }
  
  void c(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = getAVActivity();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    jik.nC(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.bx = new WeakReference(paramAVActivity);
    init();
  }
  
  void c(jhr.a parama)
  {
    if (this.mApp == null) {}
    jht.a locala;
    do
    {
      return;
      this.jdField_a_of_type_Jhr$a = parama;
      locala = a();
    } while (locala == null);
    if (parama == null) {}
    for (boolean bool = false;; bool = parama.Zo)
    {
      locala.jG(bool);
      return;
    }
  }
  
  void c(jil paramjil)
  {
    if ((!paramjil.Zx) && (this.mApp != null)) {
      this.mApp.getHandler().post(new AVRedBagMgr.4(this, paramjil));
    }
  }
  
  void c(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str = paramString;
    if (this.jdField_a_of_type_Jht$b != null)
    {
      bool1 = paramBoolean;
      str = paramString;
      if (this.jdField_a_of_type_Jht$b.Zs)
      {
        str = "10000448011711161400109338189700";
        bool1 = true;
      }
    }
    if ((this.mApp != null) && (bool1) && (!TextUtils.isEmpty(str)))
    {
      ((AVRedPacketManager)this.mApp.a(6)).b(true, str, paramInt);
      return;
    }
    paramString = new StringBuilder().append("startGame, fail, mApp[");
    if (this.mApp != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = paramString.append(paramBoolean).append("], bSuc[").append(bool1).append("], redbagId[");
      paramBoolean = bool2;
      if (!TextUtils.isEmpty(str)) {
        paramBoolean = true;
      }
      QLog.w("AVRedBag", 1, paramBoolean + "]");
      return;
    }
  }
  
  protected boolean cs(String paramString)
  {
    return false;
  }
  
  public AVActivity getAVActivity()
  {
    WeakReference localWeakReference = this.bx;
    if (localWeakReference != null) {
      return (AVActivity)localWeakReference.get();
    }
    return null;
  }
  
  public void kA(String paramString)
  {
    if (!wI())
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], 不是GameMode");
      return;
    }
    Object localObject = this.jdField_a_of_type_Jhz;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], GameSink为空");
      return;
    }
    localObject = ((jhz)localObject).b;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], ResultData为空");
      return;
    }
    AVActivity localAVActivity = getAVActivity();
    if ((localAVActivity == null) || (!localAVActivity.isResume()))
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], 等待AVActivity显示, avActivity[" + localAVActivity + "]");
      return;
    }
    a(paramString, localAVActivity, ((jil)localObject).Sm);
  }
  
  void kB(String paramString)
  {
    jim localjim = this.jdField_a_of_type_Jim;
    this.jdField_a_of_type_Jim = null;
    if (localjim != null) {
      localjim.cH(paramString);
    }
  }
  
  public void kQ(boolean paramBoolean)
  {
    ije localije = ije.a(this.mApp);
    int i;
    Object localObject;
    if (localije != null)
    {
      if (paramBoolean)
      {
        i = 4;
        localije.a(11, i, null);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendEnterMode, bEnter[");
      if (this.jdField_a_of_type_Jig != null) {
        break label126;
      }
      localObject = null;
      label54:
      localObject = localStringBuilder.append(localObject).append("->").append(paramBoolean).append("], mHandlerForVideo[");
      if (localije == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedBag", 1, bool + "]");
      if (this.jdField_a_of_type_Jig != null) {
        this.jdField_a_of_type_Jig.Zv = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_Jig.Zv);
      break label54;
    }
  }
  
  public void kR(boolean paramBoolean)
  {
    if (this.Zq != paramBoolean)
    {
      this.Zq = paramBoolean;
      awv();
    }
  }
  
  void kS(boolean paramBoolean)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("clearWhenAVactivityStop, bFinish[").append(paramBoolean).append(", SendRedBag[");
    if (this.jdField_a_of_type_Jis != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", mResultUI[");
      if (this.jdField_a_of_type_Jim == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(", mOtherBtnController[");
      bool1 = bool2;
      if (this.jdField_a_of_type_Jih != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + ", AVActivity[" + getAVActivity() + "]");
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Jih != null)
        {
          this.jdField_a_of_type_Jih.awD();
          this.jdField_a_of_type_Jih = null;
        }
        this.bx = null;
      }
      aww();
      kB("clearWhenAVactivityStop");
      return;
      bool1 = false;
      break;
    }
  }
  
  void ky(String paramString)
  {
    int i = 3;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    ije localije = ije.a(this.mApp);
    if (localije == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.mApp.b().b().state;
    int k = this.mApp.b().kF();
    if (j == 4) {
      if (jik.isDeviceSupport()) {
        if (this.jdField_a_of_type_Jhr$a != null) {
          if (this.jdField_a_of_type_Jhr$a.Zp) {
            if (k == VideoController.alJ)
            {
              bool1 = bool2;
              localije.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSoExist[" + bool1 + "], GetConfigReady[" + this.jdField_a_of_type_Jhr$a + "]");
      return;
      if (k == VideoController.alK)
      {
        i = 2;
        bool1 = bool2;
        break;
      }
      bool1 = bool3;
      if (k == VideoController.alI)
      {
        bool2 = ankq.by(BaseApplicationImpl.getContext());
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = bool2;
      }
      do
      {
        i = 2;
        break;
        bool1 = bool3;
      } while (this.jdField_a_of_type_Jhr$a.Zo);
      i = 1;
      bool1 = bool2;
      break;
      i = 1;
      bool1 = bool2;
      break;
      i = 0;
      bool1 = bool2;
      break;
      i = 0;
    }
  }
  
  public void kz(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = xq();
    int i = mB();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("notifyStatusChangedEvent[").append(paramString).append("], remoteHasVideo[").append(bool3).append("], peerSupportRedBag[").append(i).append("], isPeerInSendMode[").append(xr()).append("], mInGameMode[").append(wI()).append("], mApp[");
      if (this.mApp != null)
      {
        bool1 = true;
        QLog.w("AVRedBag", 2, bool1 + "]");
      }
    }
    else
    {
      if (this.mApp != null) {
        break label132;
      }
    }
    label132:
    do
    {
      return;
      bool1 = false;
      break;
      paramString = a();
    } while (paramString == null);
    if (i == 1) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.h(bool3, bool1, this.Zq);
      return;
    }
  }
  
  public int mB()
  {
    if (this.jdField_a_of_type_Jig != null) {
      return this.jdField_a_of_type_Jig.aAa;
    }
    return -1;
  }
  
  protected void onCreate() {}
  
  void p(int paramInt, Intent paramIntent) {}
  
  void q(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Jis == null)
    {
      localObject = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.I(acfp.m(2131703009), paramIntent.getExtras());
      }
      return;
    }
    Object localObject = getAVActivity();
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "onActivityResult_SendRedBag, activity为空");
      return;
    }
    if ((paramIntent == null) && (((AVActivity)localObject).vY()))
    {
      QLog.w("AVRedBag", 1, "onActivityResult_SendRedBag, 忽略");
      return;
    }
    this.jdField_a_of_type_Jis.a(paramInt, paramIntent);
    kQ(false);
    this.jdField_a_of_type_Jis = null;
  }
  
  public boolean wI()
  {
    return this.Zq;
  }
  
  public boolean xq()
  {
    return VideoController.a().b().PZ;
  }
  
  public boolean xr()
  {
    if (this.jdField_a_of_type_Jig != null) {
      return this.jdField_a_of_type_Jig.Zu;
    }
    return false;
  }
  
  public boolean xs()
  {
    if (this.jdField_a_of_type_Jhz != null)
    {
      jil localjil = this.jdField_a_of_type_Jhz.b;
      if (localjil != null) {
        return localjil.Zx;
      }
    }
    return false;
  }
  
  boolean xt()
  {
    AVActivity localAVActivity = getAVActivity();
    if (localAVActivity != null) {
      return localAVActivity.vY();
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract void jG(boolean paramBoolean);
  }
  
  public static class b
  {
    public static ArrayList<VideoController.b> ja;
    public String RZ = "20000005011710261000100000426100";
    public String Sa = "0";
    public String Sb = "0";
    public boolean Zr;
    public boolean Zs;
    public boolean Zt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jht
 * JD-Core Version:    0.7.0.1
 */