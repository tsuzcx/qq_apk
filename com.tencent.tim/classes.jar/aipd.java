import android.animation.ValueAnimator;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint.Align;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.1;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.12;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.2;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.4;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.5;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import mqq.os.MqqHandler;

public class aipd
  implements aipa
{
  aiod a;
  public aipb a;
  protected FloatTextLayout a;
  protected QQAppInterface app;
  ValueAnimator as;
  Boolean ay;
  protected ainv b;
  Application.ActivityLifecycleCallbacks b;
  protected FloatIconLayout b;
  String bPo;
  public String bPr;
  String bPs;
  private boolean bTd;
  boolean bTe = false;
  protected Set<String> cE = new ArraySet();
  public boolean clg = false;
  public boolean clh = false;
  public boolean cli;
  public boolean clj;
  boolean clk = true;
  int deA = 0;
  public int deB = 0;
  public int dew = -1;
  int dex = 0;
  int dey = 0;
  int dez = 0;
  private Runnable gL = new LyricsController.2(this);
  Runnable gM = new LyricsController.5(this);
  private Runnable gN = new LyricsController.12(this);
  HashMap<String, Boolean> lo = new HashMap();
  public boolean mIsForeground = true;
  int mPlayState;
  int mScreenHeight;
  private BroadcastReceiver mScreenReceiver = new aipk(this);
  int mScreenWidth;
  
  public aipd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aipb = new aipb();
    this.jdField_b_of_type_Ainv = new aipi(this);
    this.jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new aipj(this);
    this.app = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.jdField_b_of_type_Ainv);
    registerReceiver();
    this.jdField_a_of_type_Aipb.ckY = true;
    paramQQAppInterface = BaseApplicationImpl.getContext();
    this.mScreenWidth = aqnm.getScreenWidth();
    this.mScreenHeight = aqnm.getScreenHeight();
    int i = wja.dp2px(12.0F, paramQQAppInterface.getResources());
    this.dez = i;
    this.dex = i;
    i = wja.dp2px(12.0F, paramQQAppInterface.getResources());
    this.deA = i;
    this.dey = i;
    this.jdField_a_of_type_Aipb.deq = -1000;
    this.jdField_a_of_type_Aipb.der = -1000;
    ThreadManagerV2.excute(new LyricsController.1(this), 32, null, true);
  }
  
  private boolean I(int paramInt, String paramString)
  {
    boolean bool2 = false;
    if ((this.clg) && (this.jdField_a_of_type_Aipb.G(paramInt, paramString))) {
      return true;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    for (;;)
    {
      synchronized (this.cE)
      {
        this.jdField_a_of_type_Aipb.ckZ = this.cE.contains(paramInt + "_" + paramString);
        if (this.jdField_a_of_type_Aipb.H(paramInt, paramString))
        {
          bool1 = false;
          if (bool1 != this.jdField_a_of_type_Aipb.cla)
          {
            this.jdField_a_of_type_Aipb.cla = bool1;
            this.jdField_a_of_type_Aipb.clb = true;
          }
          if (this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout == null)
          {
            this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout = new FloatIconLayout(localBaseApplication);
            this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setFloatLayoutCallback(this);
            aogn.a().hO(this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout = new FloatTextLayout(localBaseApplication);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.setFloatLayoutCallback(this);
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.dtu();
          if (this.jdField_a_of_type_Aipb.cla) {
            break;
          }
          if (!this.jdField_a_of_type_Aipb.ckY) {
            break label478;
          }
          this.jdField_a_of_type_Aipb.deq = (this.mScreenWidth / 2 - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ() / 2);
          if (this.jdField_a_of_type_Aipb.der == -1000) {
            this.jdField_a_of_type_Aipb.der = (this.mScreenHeight - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FR() / 2 - wja.dp2px(110.0F, BaseApplicationImpl.getContext().getResources()));
          }
          this.jdField_a_of_type_Aipb.clc = true;
          if (QLog.isColorLevel()) {
            QLog.d("LyricsController", 2, "showLyricsInner mFloatParams: " + this.jdField_a_of_type_Aipb);
          }
          this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb);
          this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.iv(this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb), this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_Aipb));
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.iv(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Aipb));
          boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb);
          bool1 = this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb);
          this.jdField_a_of_type_Aipb.clb = false;
          if (bool1)
          {
            bool1 = bool2;
            if (bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
      boolean bool1 = true;
      continue;
      label478:
      this.jdField_a_of_type_Aipb.deq = (this.mScreenWidth / 2 + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ() / 2);
    }
    if (this.jdField_a_of_type_Aipb.ckY) {}
    for (this.jdField_a_of_type_Aipb.deq = (this.dez + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2);; this.jdField_a_of_type_Aipb.deq = (this.mScreenWidth - this.dex - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2))
    {
      if (this.jdField_a_of_type_Aipb.der == -1000) {
        this.jdField_a_of_type_Aipb.der = (wja.dp2px(70.0F, BaseApplicationImpl.getContext().getResources()) + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FR() / 2);
      }
      this.jdField_a_of_type_Aipb.clc = false;
      break;
    }
  }
  
  private void LQ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("onPlaySongChange [pre,next]=[%s,%s]", new Object[] { this.bPo, paramString }));
    }
    if (!aqft.equalsWithNullCheck(paramString, this.bPo))
    {
      this.bPo = paramString;
      this.bPs = null;
      this.ay = null;
    }
    aipc localaipc = a();
    if ((localaipc != null) && (!aqft.equalsWithNullCheck(localaipc.wZ(), paramString)))
    {
      localaipc.setSongId(paramString);
      localaipc.setLyric(null, 1);
    }
  }
  
  private aipc a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a();
    }
    return null;
  }
  
  private boolean apq()
  {
    boolean bool1;
    if ((this.app == null) || (this.app.getApp() == null)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = FloatingScreenPermission.checkPermission(this.app.getApp());
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("LyricsController", 2, "hasFloatPermission, isOpEnable: " + bool2);
    return bool2;
  }
  
  private void as(String paramString, int paramInt1, int paramInt2)
  {
    if (this.clg) {
      eV(paramString, paramInt1);
    }
  }
  
  private void cWj()
  {
    if (!this.bTe)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.bTe = true;
    }
  }
  
  private void cWk()
  {
    if (this.bTe)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.bTe = false;
    }
  }
  
  private void dtA()
  {
    if (this.app == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.app.getPreferences().edit();
    synchronized (this.cE)
    {
      if (!this.cE.isEmpty())
      {
        localEditor.putStringSet("listen_together_lyric_user_closes", this.cE);
        localEditor.putInt("listen_together_float_loc_icon_cx", this.jdField_a_of_type_Aipb.deq);
        localEditor.putInt("listen_together_float_loc_icon_cy", this.jdField_a_of_type_Aipb.der);
        localEditor.putBoolean("listen_together_float_align_right", this.jdField_a_of_type_Aipb.ckY);
        localEditor.apply();
        return;
      }
      localEditor.remove("listen_together_lyric_user_closes");
    }
  }
  
  private void dtw()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.apn();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.apn();
    }
    if (this.as != null)
    {
      this.as.cancel();
      this.as = null;
    }
  }
  
  private void dty()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i;
    int j;
    if (localBaseApplication != null)
    {
      i = localBaseApplication.getResources().getDisplayMetrics().widthPixels;
      j = localBaseApplication.getResources().getDisplayMetrics().heightPixels;
      if (i != this.mScreenWidth)
      {
        this.mScreenWidth = i;
        if (this.clg) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.dtu();
        }
      }
      if (j != this.mScreenHeight) {
        this.mScreenHeight = j;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "updateLyricsFloatWindow mScreenWidth: " + this.mScreenWidth + "  mScreenHeight: " + this.mScreenHeight);
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.gL);
    this.jdField_a_of_type_Aipb.cle = false;
    boolean bool1;
    if (this.clg) {
      if ((this.jdField_a_of_type_Aipb.isForeground) && (!this.jdField_a_of_type_Aipb.cld))
      {
        i = this.jdField_a_of_type_Aipb.deq;
        j = this.jdField_a_of_type_Aipb.der;
        bool1 = this.jdField_a_of_type_Aipb.ckY;
        if (!this.jdField_a_of_type_Aipb.cla) {
          break label461;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FN() >= this.mScreenWidth / 2) {
          break label433;
        }
        bool1 = true;
        if (!bool1) {
          break label438;
        }
        i = this.dez + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2;
        label239:
        this.jdField_a_of_type_Aipb.clc = false;
      }
    }
    label670:
    for (;;)
    {
      label247:
      if (j < this.deA + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FR() / 2) {
        j = this.deA + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FR() / 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_Aipb.ckY = bool1;
        this.jdField_a_of_type_Aipb.deq = i;
        this.jdField_a_of_type_Aipb.der = j;
        this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb);
        if ((this.jdField_a_of_type_Aipb.isForeground) && (!this.jdField_a_of_type_Aipb.cld)) {
          dtz();
        }
        bool1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.isVisible();
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb);
        this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb);
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.isVisible();
        this.jdField_a_of_type_Aipb.clb = false;
        if ((bool1 != bool2) && (bool2) && (!TextUtils.isEmpty(this.bPo))) {
          eU(this.bPo, this.mPlayState);
        }
        return;
        label433:
        bool1 = false;
        break;
        label438:
        i = this.mScreenWidth - this.dex - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2;
        break label239;
        label461:
        if (this.jdField_a_of_type_Aipb.clb)
        {
          if (bool1) {}
          for (i = this.mScreenWidth / 2 - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ() / 2;; i = this.mScreenWidth / 2 + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ() / 2)
          {
            this.jdField_a_of_type_Aipb.clc = true;
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FP() <= this.dez)
        {
          i = this.dez - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2;
          bool1 = true;
          break label247;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FO() < this.mScreenWidth - this.dex) {
          break label670;
        }
        i = this.mScreenWidth - this.dex + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2;
        bool1 = false;
        break label247;
        if (j > this.mScreenHeight - this.dey - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FR() / 2) {
          j = this.mScreenHeight - this.dey - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FR() / 2;
        }
      }
    }
  }
  
  private boolean e(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("updateLyricContent [%s]", new Object[] { paramString1 }));
    }
    if (TextUtils.isEmpty(paramString1)) {}
    aipc localaipc;
    do
    {
      return false;
      localaipc = a();
    } while ((localaipc == null) || (!paramString1.equals(localaipc.wZ())) || (localaipc.getState() == 2));
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
    }
    aiwn localaiwn = aiwv.a(paramString1, true);
    paramString2 = localaiwn;
    if (localaiwn == null) {
      paramString2 = aiwv.a(paramString1, false);
    }
    boolean bool;
    int i;
    if (QLog.isColorLevel())
    {
      if (paramString2 == null)
      {
        bool = true;
        QLog.i("LyricsController", 2, String.format("updateLyricContent parse lyric==null [%b]", new Object[] { Boolean.valueOf(bool) }));
      }
    }
    else
    {
      if (paramString2 == null) {
        break label228;
      }
      i = 2;
    }
    for (;;)
    {
      localaipc.stop();
      localaipc.setLyric(paramString2, i);
      return true;
      bool = false;
      break;
      label228:
      if (paramBoolean) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
  
  private void eT(String paramString, int paramInt)
  {
    if (!aqft.equalsWithNullCheck(paramString, this.bPo)) {}
    do
    {
      return;
      this.mPlayState = paramInt;
    } while (!this.clg);
    eU(paramString, paramInt);
  }
  
  private void eU(String paramString, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("updateLyricState [%s, %s]", new Object[] { aipo.bA(paramInt), paramString }));
    }
    aipc localaipc = a();
    if (localaipc == null) {
      return;
    }
    localaipc.setSongId(paramString);
    int j = QQMusicPlayService.FH();
    if (j < 0) {}
    for (;;)
    {
      if (paramInt == 2)
      {
        boolean bool = localaipc.isPlaying();
        if (!bool) {
          localaipc.start();
        }
        QLog.i("LyricsController", 1, "updateLyricPosition() seek to playPosition:" + i + " isPlaying:" + bool);
        localaipc.seek(i);
        return;
      }
      if (3 == paramInt)
      {
        localaipc.seek(i);
        localaipc.pause();
        return;
      }
      if ((1 == paramInt) || (paramInt == 0))
      {
        localaipc.pause();
        return;
      }
      localaipc.stop();
      return;
      i = j;
    }
  }
  
  private void eV(String paramString, int paramInt)
  {
    aipc localaipc = a();
    if (localaipc == null) {}
    while (!aqft.equalsWithNullCheck(localaipc.wZ(), paramString)) {
      return;
    }
    localaipc.seek(paramInt);
  }
  
  private void registerReceiver()
  {
    try
    {
      lcf.init();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      BaseApplicationImpl.getContext().registerReceiver(this.mScreenReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean F(int paramInt, String paramString)
  {
    synchronized (this.cE)
    {
      if (!this.cE.contains(paramInt + "_" + paramString))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("LyricsController", 2, "isLyricsTextShowing type:" + paramInt + " uin:" + paramString + " show:" + bool + " mLyricUserClosedAIOs:" + this.cE);
        }
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public void Ll(boolean paramBoolean)
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.gN);
    if (paramBoolean) {
      ThreadManager.getUIHandlerV2().postDelayed(this.gN, 500L);
    }
    do
    {
      return;
      this.jdField_a_of_type_Aipb.isForeground = paramBoolean;
    } while (!this.clg);
    dty();
  }
  
  public void Lm(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "tmpGoneForSomePage yes: " + paramBoolean);
    }
    if (this.jdField_a_of_type_Aipb.cld != paramBoolean)
    {
      this.jdField_a_of_type_Aipb.cld = paramBoolean;
      if (this.clg) {
        dty();
      }
    }
  }
  
  public void Ln(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "tmpGoneForSomePageDelay yes: " + paramBoolean);
    }
    if (this.jdField_a_of_type_Aipb.cld != paramBoolean)
    {
      this.jdField_a_of_type_Aipb.cld = paramBoolean;
      if (this.clg)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.gL);
        ThreadManager.getUIHandlerV2().postDelayed(this.gL, 500L);
      }
    }
  }
  
  public void O(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    String str;
    if (QLog.isColorLevel())
    {
      str = this.bPo;
      if (paramString2 != null) {
        break label120;
      }
    }
    for (;;)
    {
      QLog.i("LyricsController", 2, String.format("onGetLyric [pre=%s,next=%s] netErr=%b lyric=%d %s", new Object[] { str, paramString1, Boolean.valueOf(paramBoolean), Integer.valueOf(i), paramString2 }));
      if ((paramString1 != null) && (paramString1.equals(this.bPo)))
      {
        this.bPs = paramString2;
        this.ay = Boolean.valueOf(paramBoolean);
        if (this.clg)
        {
          e(paramString1, paramString2, paramBoolean);
          eU(this.bPo, this.mPlayState);
        }
      }
      return;
      label120:
      i = paramString2.length();
    }
  }
  
  public aipb a()
  {
    return this.jdField_a_of_type_Aipb;
  }
  
  public boolean app()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "isListenFloatShowing : " + this.clg);
    }
    return this.clg;
  }
  
  public void de(int paramInt, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "showLyrics, type:" + paramInt + " uin:" + paramString);
    }
    if (!apq())
    {
      if (this.clk) {
        dtv();
      }
      this.dew = paramInt;
      this.bPr = paramString;
      this.clk = false;
    }
    do
    {
      return;
      cWj();
      this.clk = false;
      this.clh = false;
      this.deB = 0;
      this.dew = -1;
      this.bPr = null;
    } while (!I(paramInt, paramString));
    this.jdField_a_of_type_Aipb.dc(paramInt, paramString);
    this.clg = true;
    String str;
    if (QLog.isColorLevel())
    {
      paramString = this.bPo;
      str = aipo.bA(this.mPlayState);
      if (this.bPs != null) {
        break label263;
      }
    }
    label263:
    for (paramInt = i;; paramInt = this.bPs.length())
    {
      QLog.i("LyricsController", 2, String.format("showLyrics[%s %s %d %s]", new Object[] { paramString, str, Integer.valueOf(paramInt), this.ay }));
      LQ(this.bPo);
      if (this.ay != null) {
        e(this.bPo, this.bPs, this.ay.booleanValue());
      }
      eU(this.bPo, this.mPlayState);
      if (this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout == null) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
      return;
    }
  }
  
  public void destroy()
  {
    df(this.jdField_a_of_type_Aipb.des, this.jdField_a_of_type_Aipb.bPp);
    if (this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.destroy();
    }
    BaseApplicationImpl.getContext().unregisterReceiver(this.mScreenReceiver);
    this.app.removeObserver(this.jdField_b_of_type_Ainv);
    cWk();
  }
  
  public void df(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "hideLyrics,  type:" + paramInt + " uin:" + paramString + " mFloatParams:" + this.jdField_a_of_type_Aipb);
    }
    if (!this.jdField_a_of_type_Aipb.G(paramInt, paramString)) {
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.gL);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.gM);
    dtw();
    this.clg = false;
    this.jdField_a_of_type_Aipb.dc(0, null);
    this.dew = -1;
    this.bPr = null;
    this.clh = false;
    this.deB = 0;
    cWk();
    aogn.a().leave();
  }
  
  public void dg(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onEnterAIO, type:" + paramInt + " uin:" + paramString + " mFloatParams:" + this.jdField_a_of_type_Aipb + " mIsForeground:" + this.mIsForeground);
    }
    this.jdField_a_of_type_Aipb.dd(paramInt, paramString);
    if (this.jdField_a_of_type_Aipb.G(paramInt, paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool != this.jdField_a_of_type_Aipb.cla)
      {
        this.jdField_a_of_type_Aipb.cla = bool;
        if (this.mIsForeground) {
          this.jdField_a_of_type_Aipb.clb = true;
        }
        dty();
      }
      if (!(BaseActivity.sTopActivity instanceof SplashActivity)) {
        break;
      }
      this.lo.put(paramInt + "_" + paramString, Boolean.TRUE);
      return;
    }
    this.lo.put(paramInt + "_" + paramString, Boolean.FALSE);
  }
  
  public void dh(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onDestroyAIO, type:" + paramInt + " uin:" + paramString + ", isForeground: " + this.mIsForeground + " mFloatParams:" + this.jdField_a_of_type_Aipb);
    }
    this.lo.remove(paramInt + "_" + paramString);
  }
  
  public void dtB()
  {
    if (this.app == null) {
      return;
    }
    Object localObject2 = this.app.getPreferences();
    Set localSet = ((SharedPreferences)localObject2).getStringSet("listen_together_lyric_user_closes", null);
    this.jdField_a_of_type_Aipb.deq = ((SharedPreferences)localObject2).getInt("listen_together_float_loc_icon_cx", this.jdField_a_of_type_Aipb.deq);
    this.jdField_a_of_type_Aipb.der = ((SharedPreferences)localObject2).getInt("listen_together_float_loc_icon_cy", this.jdField_a_of_type_Aipb.der);
    this.jdField_a_of_type_Aipb.ckY = ((SharedPreferences)localObject2).getBoolean("listen_together_float_align_right", this.jdField_a_of_type_Aipb.ckY);
    localObject2 = this.cE;
    if (localSet != null) {}
    try
    {
      if (!localSet.isEmpty()) {
        this.cE.addAll(localSet);
      }
      return;
    }
    finally {}
  }
  
  public void dtq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPositionChangeEnd mFloatParams:" + this.jdField_a_of_type_Aipb + " mScreenWidth:" + this.mScreenWidth + " mScreenHeight:" + this.mScreenHeight);
    }
    dty();
    dtA();
  }
  
  public void dtr()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onClickLyrics mIsListenFloatShowing:" + this.clg);
    }
    if (!this.clg) {
      return;
    }
    if ((this.jdField_a_of_type_Aipb.apo()) && (BaseActivity.sTopActivity != null))
    {
      localObject = ausj.b(BaseActivity.sTopActivity);
      boolean bool = aiob.aph();
      if (bool) {
        ((ausj)localObject).addButton(2131695353);
      }
      ((ausj)localObject).addButton(2131695323);
      ((ausj)localObject).addCancelButton(2131721058);
      ((ausj)localObject).a(new aipl(this));
      ((ausj)localObject).setOnCancelListener(new aipm(this));
      ((ausj)localObject).a(new aipe(this, (ausj)localObject, bool));
      ((ausj)localObject).show();
      Lm(true);
      anot.a(this.app, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("type", 1);
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).setFlags(268435456);
    PublicFragmentActivity.b.start(BaseApplicationImpl.getContext(), (Intent)localObject, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
  }
  
  public void dts()
  {
    int j = 1;
    if ((!this.clg) || (TextUtils.isEmpty(this.jdField_a_of_type_Aipb.bPp)) || ((this.jdField_a_of_type_Aipb.des != 2) && (this.jdField_a_of_type_Aipb.des != 1)) || (this.jdField_a_of_type_Aipb.apo())) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = this.jdField_a_of_type_Aipb.des + "_" + this.jdField_a_of_type_Aipb.bPp;
    if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.bKT == 1))
    {
      i = 1;
      if ((i == 0) && ((!this.lo.containsKey(localObject)) || (!((Boolean)this.lo.get(localObject)).booleanValue()))) {
        break label290;
      }
      localObject = new Intent(localBaseApplication, SplashActivity.class);
      if (i == 0) {
        break label285;
      }
      i = 1;
      label165:
      localObject = wja.a((Intent)localObject, new int[] { i });
      label177:
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Aipb.bPp);
      if (this.jdField_a_of_type_Aipb.des != 2) {
        break label327;
      }
      ((Intent)localObject).putExtra("uintype", 0);
      label212:
      ((Intent)localObject).addFlags(268435456);
      localBaseApplication.startActivity((Intent)localObject);
      localObject = this.app;
      if (!aogn.a().azA()) {
        break label354;
      }
    }
    label285:
    label290:
    label327:
    label354:
    for (int i = j;; i = 2)
    {
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "qq_vip", "0X800A5C0", i, 0, "", "", VipUtils.K(this.app), "");
      return;
      i = 0;
      break;
      i = 2;
      break label165;
      localObject = wja.a(new Intent(localBaseApplication, ChatActivity.class), new int[] { 2 });
      ((Intent)localObject).putExtra("leftViewText", "");
      break label177;
      ((Intent)localObject).putExtra("uintype", 1);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_Aipb.bPp);
      break label212;
    }
  }
  
  public void dtt()
  {
    if (this.app != null)
    {
      int i = this.jdField_a_of_type_Aipb.des;
      String str = this.jdField_a_of_type_Aipb.bPp;
      this.jdField_a_of_type_Aiod = new aipf(this);
      ListenTogetherManager.a(this.app).a(i, str, this.jdField_a_of_type_Aiod);
    }
  }
  
  public void dtv()
  {
    boolean bool = apq();
    this.clk = false;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "checkPermissionAndShowDialog in mIsFirstJoinTipsShowing:" + this.cli);
      }
      if (!this.cli)
      {
        cWj();
        Intent localIntent = new Intent();
        localIntent.putExtra("type", 2);
        localIntent.putExtra("public_fragment_window_feature", 1);
        localIntent.setFlags(268435456);
        PublicFragmentActivity.b.start(BaseApplicationImpl.getContext(), localIntent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        this.clh = true;
        this.deB = 0;
        this.clj = false;
      }
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new LyricsController.4(this, bool));
      return;
      this.clj = true;
      continue;
      this.clj = false;
    }
  }
  
  public void dtx()
  {
    this.jdField_a_of_type_Aipb.ckZ = true;
    this.jdField_a_of_type_Aipb.cld = false;
    dty();
    int i = this.jdField_a_of_type_Aipb.des;
    String str3 = this.jdField_a_of_type_Aipb.bPp;
    u(i, str3, true);
    if (this.app != null)
    {
      ((aink)this.app.getBusinessHandler(156)).notifyUI(14, true, new Object[] { Integer.valueOf(i), str3 });
      ((ListenTogetherManager)this.app.getManager(331)).k(i, str3, "closeLyric", 0);
      if ((i != 2) || (TextUtils.isEmpty(str3))) {
        break label156;
      }
      anot.a(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_close", 0, 0, str3, "", "", "");
    }
    label156:
    while ((i != 1) || (TextUtils.isEmpty(str3))) {
      return;
    }
    String str2 = "2";
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(str3);
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.app.getCurrentUin())) {
        break label249;
      }
      str1 = "0";
    }
    for (;;)
    {
      anot.a(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_close", 0, 0, str3, "", str1, "");
      return;
      label249:
      str1 = str2;
      if (localTroopInfo.isAdmin()) {
        str1 = "1";
      }
    }
  }
  
  public void dtz()
  {
    if (this.as != null)
    {
      this.as.cancel();
      this.as = null;
    }
    int i = this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb);
    int j = this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_Aipb);
    int k = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb);
    int m = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Aipb);
    int n = this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.getCurrentX();
    int i1 = this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.mu();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.getCurrentX();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.mu();
    if ((Math.abs(n - i) < 10) && (Math.abs(i1 - j) < 10) && (Math.abs(i2 - k) < 10) && (Math.abs(i3 - m) < 10))
    {
      this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.iv(i, j);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.iv(k, m);
      return;
    }
    this.as = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.as.setInterpolator(new LinearInterpolator());
    this.as.setDuration(250L);
    this.as.addUpdateListener(new aipg(this, n, i, i1, j, i2, k, i3, m));
    this.as.addListener(new aiph(this, i, j, k, m));
    this.as.start();
  }
  
  public void iw(int paramInt1, int paramInt2)
  {
    int i;
    int k;
    int j;
    if (this.clg)
    {
      i = this.jdField_a_of_type_Aipb.deq;
      k = this.jdField_a_of_type_Aipb.der;
      j = i - paramInt1;
      i = this.mScreenWidth;
      if (!this.jdField_a_of_type_Aipb.ckY) {
        break label231;
      }
      if ((!this.jdField_a_of_type_Aipb.cla) || (this.jdField_a_of_type_Aipb.ckZ)) {
        break label198;
      }
      paramInt1 = 0 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ();
    }
    for (;;)
    {
      if (j < paramInt1)
      {
        label80:
        i = k - paramInt2;
        if (i >= 0) {
          break label313;
        }
        paramInt2 = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_Aipb.clc = false;
        this.jdField_a_of_type_Aipb.deq = paramInt1;
        this.jdField_a_of_type_Aipb.der = paramInt2;
        this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.iv(this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb), this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_Aipb));
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.iv(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Aipb));
        this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb);
        return;
        label198:
        if (this.jdField_a_of_type_Aipb.ckZ) {
          break label331;
        }
        paramInt1 = 0 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ();
        i -= this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ();
        break;
        label231:
        if ((this.jdField_a_of_type_Aipb.cla) && (!this.jdField_a_of_type_Aipb.ckZ))
        {
          i += this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ();
          paramInt1 = 0;
          break;
        }
        if (this.jdField_a_of_type_Aipb.ckZ) {
          break label331;
        }
        paramInt1 = this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() + 0;
        i += this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ();
        break;
        paramInt1 = i;
        if (j > i) {
          break label80;
        }
        paramInt1 = j;
        break label80;
        label313:
        paramInt2 = i;
        if (i > this.mScreenHeight) {
          paramInt2 = this.mScreenHeight;
        }
      }
      label331:
      paramInt1 = 0;
    }
  }
  
  public void ix(int paramInt1, int paramInt2)
  {
    if ((this.clg) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ();
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onLyricTextSizeChanged oldWidth:" + paramInt2 + " newWidth:" + paramInt1);
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.setFloatWidth(paramInt1);
      if ((this.jdField_a_of_type_Aipb.clc) && (!this.jdField_a_of_type_Aipb.cla)) {
        if (!this.jdField_a_of_type_Aipb.ckY) {
          break label173;
        }
      }
    }
    label173:
    for (this.jdField_a_of_type_Aipb.deq = (this.mScreenWidth / 2 - this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ() / 2);; this.jdField_a_of_type_Aipb.deq = (this.mScreenWidth / 2 + this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ() / 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.iv(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Aipb), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Aipb));
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.dtk();
      return;
    }
  }
  
  public void t(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onExitAIO, type:" + paramInt + " uin:" + paramString + ", isForeground: " + this.mIsForeground + " mFloatParams:" + this.jdField_a_of_type_Aipb);
    }
    int j;
    int k;
    int i;
    if (this.jdField_a_of_type_Aipb.H(paramInt, paramString))
    {
      this.jdField_a_of_type_Aipb.dd(0, null);
      if (!this.jdField_a_of_type_Aipb.cla)
      {
        this.jdField_a_of_type_Aipb.cla = true;
        this.jdField_a_of_type_Aipb.clb = true;
        this.jdField_a_of_type_Aipb.cle = false;
        if ((this.clg) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) && (this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) && (this.mIsForeground))
        {
          if (!this.jdField_a_of_type_Aipb.ckY) {
            break label361;
          }
          paramString = Paint.Align.RIGHT;
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a.setAlign(paramString);
          j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.getCurrentX();
          k = this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.getCurrentX();
          if (!this.jdField_a_of_type_Aipb.ckY) {
            break label368;
          }
          i = -this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.FQ();
        }
      }
    }
    for (paramInt = -this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.FQ();; paramInt = this.mScreenWidth)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.iv(i, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.mu());
      this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.iv(paramInt, this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.mu());
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.apn();
      this.jdField_a_of_type_Aipb.cle = true;
      this.jdField_a_of_type_Aipb.deu = j;
      this.jdField_a_of_type_Aipb.dev = k;
      this.jdField_a_of_type_Aipb.b = Paint.Align.CENTER;
      ThreadManager.getUIHandlerV2().removeCallbacks(this.gL);
      paramInt = 300;
      if (paramBoolean) {
        paramInt = 500;
      }
      ThreadManager.getUIHandlerV2().postDelayed(this.gL, paramInt);
      aogn.a().c(this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, this.jdField_a_of_type_Aipb.bPp, this.jdField_a_of_type_Aipb.des);
      return;
      label361:
      paramString = Paint.Align.LEFT;
      break;
      label368:
      i = this.mScreenWidth;
    }
  }
  
  protected void u(int paramInt, String paramString, boolean paramBoolean)
  {
    synchronized (this.cE)
    {
      paramString = paramInt + "_" + paramString;
      if (paramBoolean) {
        this.cE.add(paramString);
      }
      while (!this.cE.contains(paramString))
      {
        dtA();
        return;
      }
      this.cE.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipd
 * JD-Core Version:    0.7.0.1
 */