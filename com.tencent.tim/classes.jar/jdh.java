import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavVideoRecordUICtrl.1;
import com.tencent.av.ui.QavVideoRecordUICtrl.2;
import com.tencent.av.ui.QavVideoRecordUICtrl.3;
import com.tencent.av.ui.QavVideoRecordUICtrl.4;
import com.tencent.av.ui.QavVideoRecordUICtrl.7;
import com.tencent.av.ui.QavVideoRecordUICtrl.8;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordButtonView.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;

@TargetApi(18)
public class jdh
  implements Handler.Callback, View.OnClickListener, QavRecordButtonView.a, jgw, jhb
{
  public static String RB = BaseApplicationImpl.getApplication().getFilesDir() + "/qav_record_test_switch.dat";
  public static boolean XN;
  public static boolean XP;
  private ValueAnimator A;
  private ImageButton L;
  private String RC;
  private String RD;
  private String RE;
  private boolean XO;
  private boolean XQ = true;
  private boolean XR;
  public boolean XS;
  public boolean XT;
  private volatile boolean XU;
  private volatile boolean XV;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoNetStateBar jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
  private QavRecordButtonView jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
  public jgu a;
  private jha jdField_a_of_type_Jha;
  private int axh = 1;
  public int axi;
  private int axj;
  public int axk;
  private Animator.AnimatorListener jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener;
  private ValueAnimator.AnimatorUpdateListener jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private DoubleVideoCtrlUI jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI;
  private ValueAnimator.AnimatorUpdateListener c;
  public long ch;
  private RelativeLayout dX;
  private LinearLayout dg;
  private RelativeLayout.LayoutParams e;
  private RelativeLayout em;
  private RelativeLayout en;
  private RelativeLayout eo;
  private RelativeLayout ep;
  private RelativeLayout.LayoutParams f;
  private RelativeLayout.LayoutParams g;
  private RelativeLayout.LayoutParams h;
  private RelativeLayout.LayoutParams i;
  private View ii;
  private View ij;
  private View ik;
  private WeakReference<AVActivity> mActivity;
  private int mCurRotate;
  private long mEndTime;
  private Handler mHandler;
  private long mStartTime;
  private volatile long mVideoSize;
  private TextView mX;
  private TextView mY;
  public long oL = 60000L;
  private long oM;
  private volatile long oN;
  public long oO;
  private ValueAnimator jdField_z_of_type_AndroidAnimationValueAnimator;
  private File jdField_z_of_type_JavaIoFile;
  
  public jdh(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout1, VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, RelativeLayout paramRelativeLayout2, VideoControlUI paramVideoControlUI)
  {
    this.mActivity = new WeakReference(paramAVActivity);
    this.em = paramRelativeLayout1;
    this.mHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.dX = paramRelativeLayout2;
    if ((paramVideoControlUI instanceof DoubleVideoCtrlUI)) {
      paramAVActivity = (DoubleVideoCtrlUI)paramVideoControlUI;
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI = paramAVActivity;
      if (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null)
      {
        paramAVActivity = null;
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = paramAVActivity;
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.kL(true);
        }
        p(paramVideoAppInterface);
        this.jdField_a_of_type_Jgu = jgu.a();
        this.oL = (this.jdField_a_of_type_Jgu.azj * 60 * 1000L);
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().lh < 0L) {
          this.jdField_a_of_type_ComTencentAvVideoController.b().lh = this.oL;
        }
      }
      try
      {
        if (wz()) {
          this.jdField_a_of_type_Jha = new jha();
        }
        paramAVActivity = aqgz.BY();
        QLog.i("QavVideoRecordUICtrl", 1, "QavVideoRecordUICtrl manufacture=" + paramAVActivity);
        if (("OPPO".equalsIgnoreCase(paramAVActivity)) || ("vivo".equalsIgnoreCase(paramAVActivity))) {
          this.XO = true;
        }
        return;
        paramAVActivity = null;
        continue;
        paramAVActivity = this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.b;
      }
      catch (OutOfMemoryError paramAVActivity)
      {
        for (;;)
        {
          this.jdField_a_of_type_Jha = null;
          QLog.e("QavVideoRecordUICtrl", 1, "oom " + paramAVActivity, paramAVActivity);
        }
      }
    }
  }
  
  private void auA()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "doExpandAnim");
    }
    this.XU = true;
    wja.dp2px(7.5F, ((AVActivity)this.mActivity.get()).getResources());
    wja.dp2px(64.0F, ((AVActivity)this.mActivity.get()).getResources());
    cA(2131298300);
    cA(2131298297);
    cA(2131298297);
    cA(2131298299);
    cA(2131298304);
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener == null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new jdi(this);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new jdj(this);
    }
    if (this.jdField_z_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_z_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 260 });
      this.jdField_z_of_type_AndroidAnimationValueAnimator.setDuration(260L);
    }
    this.jdField_z_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_z_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_z_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    this.jdField_z_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    if (this.jdField_z_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_z_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_z_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void auB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 1, "clearAnim mAnimExpanding=" + this.XU + ", mAnimFolding=" + this.XV);
    }
    if ((this.XU) && (this.jdField_z_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_z_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    while ((!this.XV) || (this.A == null) || (!this.A.isRunning())) {
      try
      {
        this.jdField_z_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
        this.jdField_z_of_type_AndroidAnimationValueAnimator.removeAllListeners();
        this.jdField_z_of_type_AndroidAnimationValueAnimator.cancel();
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + localException1, localException1);
        this.XU = false;
        return;
      }
      finally
      {
        this.XU = false;
        setShowState(3, false);
      }
    }
    try
    {
      this.A.removeAllUpdateListeners();
      this.A.removeAllListeners();
      this.A.cancel();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + localException2, localException2);
      return;
    }
    finally
    {
      this.XV = false;
      setShowState(3, false);
    }
  }
  
  private void auD()
  {
    if (((AVActivity)this.mActivity.get()).mApp == null) {
      return;
    }
    this.axj = 0;
    QLog.d("QavVideoRecordUICtrl", 1, "onRecordBegin");
    this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording = true;
    K(1, true);
    auF();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(0L, this.oL);
    this.mY.setText(ak(0L));
    this.dg.setVisibility(0);
    ((AVActivity)this.mActivity.get()).mApp.l(new Object[] { Integer.valueOf(163) });
  }
  
  private void auG()
  {
    AVActivity localAVActivity = (AVActivity)this.mActivity.get();
    if (localAVActivity == null) {}
    do
    {
      return;
      if ((localAVActivity.mApp != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavVideoRecordUICtrl", 2, "record activity.mApp == null  || mVideoController == null");
    return;
    jgx.kw("0X8008AAE");
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().Ql)
    {
      localAVActivity.jdField_b_of_type_Iya.me(2);
      QLog.d("QavVideoRecordUICtrl", 1, "start record, child lock");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording)
    {
      aur();
      long l = (System.currentTimeMillis() - this.ch) / 1000L;
      anot.a(null, "CliOper", "", "", "0X800863B", "0X800863B", 0, 0, String.valueOf(l), "", "", "");
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(localAVActivity.mApp.getCurrentAccountUin(), "av_record_click_end", true, l, 0L, null, "", false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().D.clear();
    int j;
    if (!wz())
    {
      if (localAVActivity.mApp != null) {
        iwu.b(localAVActivity.mApp, 1022, 2131697968);
      }
      j = 0;
      QLog.d("QavVideoRecordUICtrl", 1, "start record, api not support");
    }
    for (;;)
    {
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qu = true;
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qv = vX();
        startRecord();
        Object localObject;
        if ((wC()) && (localAVActivity.mApp.ch(3)))
        {
          localObject = (ijv)localAVActivity.mApp.a(3);
          if (((FaceItem)((ijv)localObject).a() != null) && (((ijv)localObject).isSender()) && (localAVActivity.mApp != null)) {
            iwu.b(localAVActivity.mApp, 1022, 2131697978);
          }
        }
        jgx.kw("0X800863A");
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qp) {
          jgx.kw("0X8008ACC");
        }
        if (vX()) {
          jgx.kw("0X8008AB9");
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().D.size() != 0) {
            break label1183;
          }
          jgx.kw("0X8008ABB");
          return;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qo)
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, friend not support");
            if (this.jdField_a_of_type_ComTencentAvVideoController.getPeerTerminalType(this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin) == 5) {
              jgx.kw("0X8008AB6");
            }
            for (j = 2131697976;; j = 2131697975)
            {
              if (localAVActivity.mApp == null) {
                break label1192;
              }
              iwu.b(localAVActivity.mApp, 1022, j);
              j = 0;
              break;
              jgx.kw("0X8008AB5");
            }
          }
          if (!wB())
          {
            if (localAVActivity.mApp != null) {
              iwu.b(localAVActivity.mApp, 1022, 2131697981);
            }
            j = 0;
            QLog.d("QavVideoRecordUICtrl", 1, "start record, isPerformanceSupport==false");
            jgx.kw("0X8008AB4");
            break;
          }
          if ((this.jdField_a_of_type_ComTencentAvVideoController.b().Qp) && (this.jdField_a_of_type_ComTencentAvVideoController.b().amV < 735))
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, friend's old version not support record in same time");
            iwu.b(localAVActivity.mApp, 1022, 2131697979);
            j = 0;
            break;
          }
          if (!wy())
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, last encode not stop");
            if (localAVActivity.mApp != null) {
              iwu.b(localAVActivity.mApp, 1022, 2131697977);
            }
            j = 0;
            break;
          }
          if (localAVActivity.mApp.ch(3))
          {
            localObject = (ijv)localAVActivity.mApp.a(3);
            FaceItem localFaceItem = (FaceItem)((ijv)localObject).a();
            if (localFaceItem != null)
            {
              boolean bool1 = ((ijv)localObject).isSender();
              boolean bool2 = localFaceItem.isSameType("pendant");
              boolean bool3 = localFaceItem.isSameType("face");
              boolean bool4 = localFaceItem.isSameType("voicesticker");
              if ((bool1) && ((bool3) || (bool4)))
              {
                j = 1;
                label741:
                if (j == 0) {
                  break label817;
                }
                localObject = localAVActivity.mApp;
                if (!bool4) {
                  break label801;
                }
              }
              label801:
              for (j = 2131698001;; j = 2131698000)
              {
                iwu.b((VideoAppInterface)localObject, 1022, j);
                j = 0;
                QLog.d("QavVideoRecordUICtrl", 1, "start record, isDoubleScreen");
                if (!bool4) {
                  break label808;
                }
                jgx.kw("0X8009852");
                break;
                j = 0;
                break label741;
              }
              label808:
              jgx.kw("0X8008AC3");
              break;
              label817:
              if (bool2) {
                jgx.kw("0X8008ABE");
              }
            }
          }
          if (localAVActivity.mApp.ch(0))
          {
            localObject = (ilg)localAVActivity.mApp.a(0);
            if (localObject != null)
            {
              localObject = (ZimuItem)((ilg)localObject).a();
              if (localObject != null)
              {
                if (!TextUtils.isEmpty(((ZimuItem)localObject).getId())) {}
                for (j = 1;; j = 0)
                {
                  if (j == 0) {
                    break label931;
                  }
                  iwu.b(localAVActivity.mApp, 1022, 2131698002);
                  j = 0;
                  QLog.d("QavVideoRecordUICtrl", 1, "start record, usingZimu");
                  jgx.kw("0X8008AD2");
                  break;
                }
              }
            }
          }
          label931:
          if ((localAVActivity.a != null) && (localAVActivity.a.xj()))
          {
            j = 0;
            iwu.b(localAVActivity.mApp, 1022, 2131697999);
            break;
          }
          if (jgn.bS() < 31457280L)
          {
            if (localAVActivity.mApp != null) {
              iwu.b(localAVActivity.mApp, 1022, 2131697993);
            }
            j = 0;
            QLog.d("QavVideoRecordUICtrl", 1, "start record, STORAGE_LEFT_MIN_SIZE not enough");
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().YN != 0)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.b().D.add(Integer.valueOf(0));
            jgx.kw("0X8008AC1");
          }
          if ((jik.isDeviceSupport()) && (jik.a(localAVActivity.mApp).xr()))
          {
            QLog.d("QavVideoRecordUICtrl", 1, "start record, redbag PeerInSendMode");
            this.jdField_a_of_type_ComTencentAvVideoController.b().D.add(Integer.valueOf(2));
            jgx.kw("0X8008AC0");
          }
          if (localAVActivity.mApp.ch(2))
          {
            localObject = (ikl)localAVActivity.mApp.a(2);
            if ((localObject != null) && (((ikl)localObject).a() != null))
            {
              this.jdField_a_of_type_ComTencentAvVideoController.b().D.add(Integer.valueOf(6));
              jgx.kw("0X8008ABC");
            }
          }
          j = 1;
          break;
          jgx.kw("0X8008AB8");
        }
        label1183:
        break;
      }
      jgx.kw("0X8008AAF");
      return;
      label1192:
      j = 0;
    }
  }
  
  private void auH()
  {
    if (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {}
    while ((this.ii == null) || (this.ij == null) || (this.ik == null)) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.wH())
    {
      this.ij.setVisibility(8);
      this.ii.setVisibility(8);
      this.ik.setVisibility(8);
      return;
    }
    if (wx())
    {
      this.ij.setVisibility(8);
      this.ik.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.mt() == 3) || (ww()))
      {
        this.ii.setVisibility(0);
        return;
      }
      this.ii.setVisibility(8);
      return;
    }
    this.ii.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.mt() == 3) {
      this.ik.setVisibility(0);
    }
    while (ww())
    {
      this.ij.setVisibility(0);
      return;
      this.ik.setVisibility(8);
    }
    this.ij.setVisibility(8);
  }
  
  private void auI()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.np(this.mCurRotate);
    if ((this.mCurRotate != 90) && (this.mCurRotate != 270) && (ww()))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.no(mb() + cA(2131298259));
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.no(cA(2131298259));
  }
  
  private void auJ()
  {
    this.c = null;
    this.A = null;
    this.jdField_b_of_type_AndroidAnimationAnimator$AnimatorListener = null;
    this.jdField_z_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_b_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = null;
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  }
  
  private void aut()
  {
    if ((this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (((AVActivity)this.mActivity.get()).jdField_b_of_type_ComTencentAvUiVideoLayerUI == null)) {}
    while (!vX()) {
      return;
    }
    if (ww())
    {
      if (wx())
      {
        this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.jy(true);
        return;
      }
      this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.jy(false);
      return;
    }
    this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.jy(true);
  }
  
  public static void b(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "sendSupportMsg, controller=" + paramVideoController);
    }
    if ((!wz()) || (isInBlackList())) {
      QLog.d("QavVideoRecordUICtrl", 1, "sendSupportMsg, not support");
    }
    while (paramVideoController == null) {
      return;
    }
    paramVideoController.d(8, "SUPPORT_TRUE");
    paramVideoController.d(8, "SUPPORT_TRUE");
    paramVideoController.d(8, "SUPPORT_TRUE_7.3.5#" + jgu.a().azj);
    paramVideoController.d(8, "SUPPORT_TRUE_7.3.5#" + jgu.a().azj);
  }
  
  private long bQ()
  {
    return Math.max(0L, System.currentTimeMillis() - this.oM);
  }
  
  private int cA(int paramInt)
  {
    return ((AVActivity)this.mActivity.get()).getResources().getDimensionPixelSize(paramInt);
  }
  
  private int cz(int paramInt)
  {
    int j = paramInt;
    if (paramInt != 0)
    {
      if ((!this.XS) && (!this.XT)) {
        break label24;
      }
      j = 0;
    }
    label24:
    do
    {
      do
      {
        return j;
        j = paramInt;
      } while (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null);
      j = paramInt;
    } while (!this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.wH());
    return 0;
  }
  
  private void dA(long paramLong)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onRecordEnd time=" + paramLong);
    if (((AVActivity)this.mActivity.get()).mApp == null) {
      return;
    }
    this.axj = 0;
    this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording = false;
    if ((paramLong > 1000L) || (((AVActivity)this.mActivity.get()).VP))
    {
      K(3, true);
      this.jdField_a_of_type_ComTencentAvVideoController.b().amW = 0;
    }
    for (;;)
    {
      auF();
      this.dg.setVisibility(8);
      ((AVActivity)this.mActivity.get()).mApp.l(new Object[] { Integer.valueOf(163) });
      return;
      if (paramLong >= 0L)
      {
        this.mHandler.postDelayed(new QavVideoRecordUICtrl.7(this), 1000L);
        iwu.b(((AVActivity)this.mActivity.get()).mApp, 1023, 2131697998);
        jgx.kw("0X8008AB0");
      }
      else if (paramLong < 0L)
      {
        K(3, true);
        iwu.b(((AVActivity)this.mActivity.get()).mApp, 1023, 2131697973);
        this.jdField_a_of_type_ComTencentAvVideoController.ama();
      }
    }
  }
  
  private void dB(long paramLong)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onForceStop time=" + paramLong);
    if (((AVActivity)this.mActivity.get()).mApp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording = false;
    iwu.b(((AVActivity)this.mActivity.get()).mApp, 1023, 2131697974);
    this.jdField_a_of_type_ComTencentAvVideoController.ama();
    auF();
    this.dg.setVisibility(8);
    ((AVActivity)this.mActivity.get()).mApp.l(new Object[] { Integer.valueOf(163) });
  }
  
  public static boolean isInBlackList()
  {
    ioj localioj = ioj.a();
    if ((localioj == null) || (localioj.uE())) {}
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        QLog.d("QavVideoRecordUICtrl", 1, "isInBlackList device not support");
      }
      if (j != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void mV(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (((AVActivity)this.mActivity.get()).VP);
      if (this.XO) {}
      for (paramInt = 2131697988;; paramInt = 2131697987)
      {
        QQToast.a((Context)this.mActivity.get(), 2, ((AVActivity)this.mActivity.get()).getResources().getString(paramInt), 0).show();
        return;
      }
    } while (((AVActivity)this.mActivity.get()).VP);
    iwu.b(((AVActivity)this.mActivity.get()).mApp, 1023, 2131697973);
  }
  
  private void p(VideoAppInterface paramVideoAppInterface)
  {
    LayoutInflater.from((Context)this.mActivity.get()).inflate(2131559994, this.em);
    this.en = ((RelativeLayout)this.em.findViewById(2131381800));
    this.eo = ((RelativeLayout)this.em.findViewById(2131376987));
    this.ep = ((RelativeLayout)this.em.findViewById(2131376986));
    this.mX = ((TextView)this.em.findViewById(2131379501));
    this.L = ((ImageButton)this.em.findViewById(2131376972));
    this.ij = this.em.findViewById(2131376969);
    this.ii = this.em.findViewById(2131376968);
    this.ik = this.em.findViewById(2131376967);
    this.e = ((RelativeLayout.LayoutParams)this.mX.getLayoutParams());
    this.f = ((RelativeLayout.LayoutParams)this.L.getLayoutParams());
    this.L.setOnClickListener(this);
    this.g = ((RelativeLayout.LayoutParams)this.eo.getLayoutParams());
    this.h = ((RelativeLayout.LayoutParams)this.ep.getLayoutParams());
    this.i = ((RelativeLayout.LayoutParams)this.en.getLayoutParams());
    if (AudioHelper.jY(0) == 1)
    {
      this.en.setBackgroundColor(1602735851);
      this.eo.setBackgroundColor(2142109487);
    }
    this.en.setWillNotDraw(false);
    this.axi = wja.dp2px(51.0F, ((AVActivity)this.mActivity.get()).getResources());
    this.RC = ((AVActivity)this.mActivity.get()).getString(2131697986);
    this.RD = ((AVActivity)this.mActivity.get()).getString(2131697982);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)((AVActivity)this.mActivity.get()).findViewById(2131376957));
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setListener(this);
    this.dg = ((LinearLayout)((AVActivity)this.mActivity.get()).findViewById(2131376975));
    this.mY = ((TextView)((AVActivity)this.mActivity.get()).findViewById(2131376974));
    this.dg.setVisibility(8);
    if (AudioHelper.jY(0) == 1)
    {
      this.dg.setBackgroundColor(-273627938);
      this.mY.setBackgroundColor(-65281);
    }
  }
  
  private void reset()
  {
    this.axh = 1;
    this.mHandler.removeMessages(1);
    kf(false);
    kh(false);
    this.en.setVisibility(8);
  }
  
  public static boolean wz()
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoRecordUICtrl", 2, "isDeviceSupport, apiSupport=" + bool);
      }
      return bool;
    }
  }
  
  public void K(int paramInt, boolean paramBoolean)
  {
    b(paramInt, paramBoolean, 3);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Jha != null) {
      this.jdField_a_of_type_Jha.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
    }
    jgx.awi();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeError " + paramInt + ", e=" + paramThrowable);
    if (QLog.isColorLevel())
    {
      paramThrowable.printStackTrace();
      QLog.e("QavVideoRecordUICtrl", 1, "onEncodeError ", paramThrowable);
    }
    jgx.b(paramInt, paramThrowable);
    this.XQ = true;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 5)) {}
    do
    {
      this.mHandler.post(new QavVideoRecordUICtrl.3(this));
      do
      {
        return;
      } while (paramInt != 4);
      this.XR = true;
    } while (bR() < 1000L);
    this.mHandler.post(new QavVideoRecordUICtrl.4(this));
  }
  
  public void a(VideoControlUI paramVideoControlUI, int paramInt)
  {
    if ((paramVideoControlUI == null) || (!(paramVideoControlUI instanceof DoubleVideoCtrlUI))) {}
    for (;;)
    {
      return;
      if ((paramInt == 90) || (paramInt == 270)) {}
      for (paramInt = 1; (paramInt != 0) && (this.axh != 1); paramInt = 0)
      {
        cA(2131298307);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean1, VideoControlUI paramVideoControlUI, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoRecordUICtrl", 2, "setDoubleScreenStatusBar doubleScreen=" + paramBoolean1 + ", controlUI=" + paramVideoControlUI + ", showBar=" + paramBoolean2);
    }
    aut();
  }
  
  @TargetApi(17)
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Jha == null) {}
    try
    {
      if (wz()) {
        this.jdField_a_of_type_Jha = new jha();
      }
      if (paramBoolean)
      {
        j = jdm.cC(paramInt1);
        this.RE = jgn.hn();
        this.jdField_z_of_type_JavaIoFile = new File(this.RE);
        this.mVideoSize = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord path=" + this.RE + ", w=" + paramInt1 + ", h=" + paramInt2 + ", rh=" + j);
        }
        paramInt2 = this.jdField_a_of_type_Jgu.maxVideoWidth;
        if (paramInt1 > paramInt2)
        {
          float f1 = 1.0F * paramInt2 / paramInt1;
          int k = (int)(j * f1);
          j = k;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord calc size, maxWidth=" + paramInt2 + ", realWidth=" + paramInt2 + ", realHeight=" + k);
            paramInt1 = paramInt2;
            j = k;
          }
          if (j % 2 == 1)
          {
            paramInt2 = j + 1;
            QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord height+1");
            QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord rW=" + paramInt1 + ", rH=" + paramInt2);
            amae localamae = new amae(this.RE, paramInt1, paramInt2, 5120000, 1, false, 0);
            localamae.a(EGL14.eglGetCurrentContext());
            if (this.jdField_a_of_type_Jha != null)
            {
              this.jdField_a_of_type_Jha.a(localamae, this);
              jgx.onRecordStart();
              return new int[] { paramInt1, paramInt2 };
            }
          }
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_Jha = null;
        QLog.e("QavVideoRecordUICtrl", 1, "oom " + localOutOfMemoryError, localOutOfMemoryError);
        continue;
        a(5, null);
        continue;
        paramInt2 = j;
        continue;
        continue;
        int j = paramInt2;
      }
    }
  }
  
  public void aM(String paramString1, String paramString2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoRecordUICtrl", 1, "onReceiveRecordMsg, fromUin[" + paramString1 + "], data[" + paramString2 + "], seq[" + l + "]");
    }
    int k;
    do
    {
      try
      {
        j = Integer.parseInt(paramString2);
        if (j == -1)
        {
          QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=" + paramString2);
          if (TextUtils.isEmpty(paramString2)) {
            return;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        do
        {
          for (;;)
          {
            QLog.i("QavVideoRecordUICtrl", 1, "Qav.Record, onChangeUi_ReceiveRecordMsg, " + localNumberFormatException.getMessage());
            j = -1;
          }
          if ("SUPPORT_TRUE".equals(paramString2))
          {
            this.jdField_a_of_type_ComTencentAvVideoController.b().Qo = true;
            this.jdField_a_of_type_ComTencentAvVideoController.b().amV = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.b().amV, 730);
            auF();
            return;
          }
        } while (!paramString2.startsWith("SUPPORT_TRUE_7.3.5"));
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qo = true;
        this.jdField_a_of_type_ComTencentAvVideoController.b().amV = Math.max(this.jdField_a_of_type_ComTencentAvVideoController.b().amV, 735);
        j = jgy.n(paramString2, this.jdField_a_of_type_Jgu.azj);
        QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + j);
        this.jdField_a_of_type_ComTencentAvVideoController.b().lh = (j * 60 * 1000L);
        auF();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (((AVActivity)this.mActivity.get()).mApp == null))
      {
        QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, mVideoController == null || mActivity.get().mApp == null");
        return;
      }
      k = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "onChangeUi_ReceiveRecordMsg, session type=" + k);
      }
    } while ((k != 2) && (k != 1));
    switch (j)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qp = true;
      setShowState(3);
      auF();
      kg(vX());
      a(vX(), this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI, true);
      a(this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.mCurRotate);
      this.oO = System.currentTimeMillis();
      kh(true);
      ((AVActivity)this.mActivity.get()).cP(l);
      if (!"self".equalsIgnoreCase(paramString1))
      {
        K(2, false);
        if (!((AVActivity)this.mActivity.get()).isResume()) {
          break label675;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.ama();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().YN != 0) {
          jgx.kw("0X8008AC2");
        }
        if (((AVActivity)this.mActivity.get()).mApp.ch(2))
        {
          paramString1 = (ikl)((AVActivity)this.mActivity.get()).mApp.a(2);
          if ((paramString1 != null) && (paramString1.a() != null)) {
            jgx.kw("0X8008ABC");
          }
        }
        ((AVActivity)this.mActivity.get()).mApp.l(new Object[] { Integer.valueOf(163) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.alZ();
      }
    case 2: 
      mQ(1);
      return;
    case 3: 
    case 8: 
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qp = false;
      if (j == 3)
      {
        K(4, false);
        iwu.b(((AVActivity)this.mActivity.get()).mApp, 1022, 2131697972);
      }
      for (;;)
      {
        auE();
        return;
        K(9, false);
        iwu.b(((AVActivity)this.mActivity.get()).mApp, 1022, 2131697971);
      }
    case 4: 
      mQ(3);
      return;
    case 5: 
      label675:
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) {
        auq();
      }
      break;
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (j = 6;; j = 7)
      {
        K(j, false);
        return;
      }
      mQ(5);
      return;
      mQ(8);
      return;
    }
  }
  
  public String ak(long paramLong)
  {
    if (paramLong == 0L) {
      return this.RD;
    }
    int j = (int)(paramLong / 1000L);
    int k = j / 60;
    return String.format(Locale.getDefault(), "%s (%02d:%02d)", new Object[] { this.RC, Integer.valueOf(k), Integer.valueOf(j - k * 60) });
  }
  
  public void auC()
  {
    K(5, true);
    a(vX(), this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
    kg(true);
    if (((AVActivity)this.mActivity.get()).mApp != null) {
      iwu.b(((AVActivity)this.mActivity.get()).mApp, 1023, 2131698004);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b().Qp = false;
    auF();
    ((AVActivity)this.mActivity.get()).mApp.l(new Object[] { Integer.valueOf(163) });
    long l = (System.currentTimeMillis() - this.oO) / 1000L;
    anot.a(null, "CliOper", "", "", "0X800863E", "0X800863E", 0, 0, "", String.valueOf(l), "", "");
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(((AVActivity)this.mActivity.get()).mApp.getCurrentAccountUin(), "av_record_cancel", true, l, 0L, null, "", false);
    setShowState(1);
  }
  
  public void auE()
  {
    long l = AudioHelper.hG();
    QLog.w("QavVideoRecordUICtrl", 1, "endBeenRecordedState, seq[" + l + "]");
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b() != null) && (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qp = false;
      setShowState(1);
      a(this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.mCurRotate);
      kg(true);
      a(vX(), this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI, false);
      kh(false);
      this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.jy(true);
    }
    for (;;)
    {
      ((AVActivity)this.mActivity.get()).cP(l);
      auF();
      if (((AVActivity)this.mActivity.get()).mApp != null) {
        ((AVActivity)this.mActivity.get()).mApp.l(new Object[] { Integer.valueOf(163) });
      }
      auJ();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "endBeenRecordedState something is null: mControlUI=" + this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI);
      }
    }
  }
  
  public void auF()
  {
    long l = AudioHelper.hG();
    QLog.w("QavVideoRecordUICtrl", 1, "updateRecordButton, seq[" + l + "]");
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b() == null) || (((AVActivity)this.mActivity.get()).mApp == null) || (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView == null)) {
      return;
    }
    if (isEnableRecord())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(3, ((AVActivity)this.mActivity.get()).mApp.sO());
      }
      for (;;)
      {
        ((AVActivity)this.mActivity.get()).mControlUI.O(l, 65535);
        return;
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(2, ((AVActivity)this.mActivity.get()).mApp.sO());
      }
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setShowState(1, ((AVActivity)this.mActivity.get()).mApp.sO());
  }
  
  public void auq()
  {
    mR(2);
  }
  
  public void aur()
  {
    mR(1);
  }
  
  public void aus()
  {
    if ((this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.isDestroyed())) {}
    do
    {
      return;
      this.mCurRotate = cz(this.mCurRotate);
      mU(this.mCurRotate);
      auH();
      auI();
    } while (!ww());
    int j;
    if ((this.mCurRotate == 90) || (this.mCurRotate == 270))
    {
      j = 1;
      if ((j == 0) || (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.wH())) {
        break label296;
      }
      if (md() != 3) {
        break label238;
      }
      j = cA(2131298296);
      label111:
      this.g.height = j;
      this.g.width = j;
      this.g.leftMargin = wja.dp2px(15.0F, ((AVActivity)this.mActivity.get()).getResources());
      if (this.eo != null) {
        this.eo.setLayoutParams(this.g);
      }
      if (this.mCurRotate != 90) {
        break label249;
      }
      if (this.eo != null) {
        this.eo.setRotation(-90.0F);
      }
      if (this.ep != null)
      {
        this.ep.setScaleX(1.0F);
        this.ep.setScaleY(1.0F);
      }
    }
    for (;;)
    {
      aut();
      kf(ww());
      return;
      j = 0;
      break;
      label238:
      j = cA(2131298302);
      break label111;
      label249:
      if (this.ep != null)
      {
        this.ep.setScaleX(-1.0F);
        this.ep.setScaleY(-1.0F);
      }
      if (this.eo != null)
      {
        this.eo.setRotation(-90.0F);
        continue;
        label296:
        this.g.height = -2;
        this.g.width = -2;
        this.g.leftMargin = 0;
        if (this.eo != null) {
          this.eo.setLayoutParams(this.g);
        }
        if (this.ep != null)
        {
          this.ep.setScaleX(1.0F);
          this.ep.setScaleY(1.0F);
        }
        if (this.eo != null) {
          this.eo.setRotation(this.mCurRotate);
        }
      }
    }
  }
  
  public void auu()
  {
    if ((this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) || (!ww())) {
      return;
    }
    int j = ma();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.en.getLayoutParams();
    localLayoutParams.topMargin = j;
    QLog.i("QavVideoRecordUICtrl", 1, "iveswu statusBar:density=" + ((AVActivity)this.mActivity.get()).getResources().getDisplayMetrics().density);
    this.en.setLayoutParams(localLayoutParams);
  }
  
  public void auv()
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onEncodeStart");
    this.XQ = false;
  }
  
  public void auw() {}
  
  public void aux() {}
  
  public void auy()
  {
    this.oM = System.currentTimeMillis();
    QLog.w("QavVideoRecordUICtrl", 1, "onEncodeRealStart, mRealStartTime[" + this.oM + "], StartOffset[" + (this.oM - this.mStartTime) + "]");
  }
  
  public void auz()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, cur=" + this.axh + ", mAnimExpanding=" + this.XU);
    }
    if ((this.jdField_z_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_z_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, isRunning");
      }
      return;
    }
    auA();
  }
  
  public void b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "sendRecordMsg " + paramInt1 + ", " + paramBoolean + ", " + paramInt2);
    this.jdField_a_of_type_ComTencentAvVideoController.d(8, String.valueOf(paramInt1));
    if (paramBoolean)
    {
      this.mHandler.removeMessages(paramInt1);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(paramInt1, paramInt2, 0), 3000L);
    }
  }
  
  public long bP()
  {
    try
    {
      if (this.jdField_z_of_type_JavaIoFile == null) {}
      for (l = this.mVideoSize;; l = jgn.getFileSize(this.jdField_z_of_type_JavaIoFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize=" + l);
        }
        return l;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = this.mVideoSize;
        QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize Exception=" + localException.getMessage());
      }
    }
  }
  
  public long bR()
  {
    long l = this.mEndTime - this.oM;
    QLog.w("QavVideoRecordUICtrl", 1, "getRealDuration, dur[" + l + "], UITime[" + (this.mEndTime - this.mStartTime) + "]");
    return Math.max(0L, l);
  }
  
  public void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((XP) && (this.jdField_a_of_type_Jha != null) && (paramInt1 == 100)) {
      this.jdField_a_of_type_Jha.d(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.mHandler.removeMessages(10);
      if (!XP) {
        return true;
      }
      long l = bQ();
      if (l > this.oL)
      {
        aur();
        l = this.oL / 1000L;
        anot.a(null, "CliOper", "", "", "0X800863C", "0X800863C", 0, 0, String.valueOf(l), "", "", "");
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_timeout", true, l, 0L, null, "", false);
        return true;
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setProgress(l, this.oL);
      this.mY.setText(ak(l));
      this.mHandler.sendEmptyMessageDelayed(10, 500L);
      this.mHandler.removeMessages(11);
      if (!XP) {
        return true;
      }
      ThreadManager.postImmediately(new QavVideoRecordUICtrl.1(this), null, false);
      continue;
      QLog.d("QavVideoRecordUICtrl", 1, "on msg time, msg=" + paramMessage.what);
      b(paramMessage.what, false, paramMessage.arg1 - 1);
      continue;
      if (!((AVActivity)this.mActivity.get()).VP)
      {
        auE();
        continue;
        if (((AVActivity)this.mActivity.get()).mApp != null) {
          iwu.b(((AVActivity)this.mActivity.get()).mApp, 1022, 2131697985);
        }
      }
    }
  }
  
  public boolean isEnableRecord()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.b() == null) || (((AVActivity)this.mActivity.get()).mApp == null)) {}
    boolean bool1;
    boolean bool6;
    boolean bool7;
    do
    {
      return false;
      bool1 = this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording;
      bool6 = this.jdField_a_of_type_ComTencentAvVideoController.b().Qp;
      bool7 = this.jdField_a_of_type_ComTencentAvVideoController.b().Ql;
    } while (!wA());
    if (bool1) {
      return true;
    }
    Object localObject;
    boolean bool4;
    boolean bool3;
    boolean bool2;
    if (((AVActivity)this.mActivity.get()).mApp.ch(3))
    {
      localObject = (ijv)((AVActivity)this.mActivity.get()).mApp.a(3);
      FaceItem localFaceItem = (FaceItem)((ijv)localObject).a();
      if (localFaceItem != null)
      {
        bool4 = ((ijv)localObject).isSender();
        bool3 = localFaceItem.isSameType("face");
        bool2 = localFaceItem.isSameType("voicesticker");
      }
    }
    for (boolean bool5 = true;; bool5 = false)
    {
      if (((AVActivity)this.mActivity.get()).mApp.ch(0))
      {
        localObject = (ilg)((AVActivity)this.mActivity.get()).mApp.a(0);
        if (localObject != null)
        {
          localObject = (ZimuItem)((ilg)localObject).a();
          if (localObject != null) {
            if (!TextUtils.isEmpty(((ZimuItem)localObject).getId())) {
              bool1 = true;
            }
          }
        }
      }
      for (;;)
      {
        QLog.i("QavVideoRecordUICtrl", 1, "isEnableRecord. isPlayingMagicFace " + bool5 + ", isUsingZimu=" + bool1 + ", isSender=" + bool4);
        if ((bool7) || (bool1) || ((bool5) && (bool4) && ((bool3) || (bool2))) || ((bool6) && (this.jdField_a_of_type_ComTencentAvVideoController.b().amV < 735))) {
          break;
        }
        return true;
        bool1 = false;
        continue;
        bool1 = false;
      }
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  public boolean isRecording()
  {
    return XP;
  }
  
  public void kf(String paramString)
  {
    boolean bool2 = false;
    QLog.w("QavVideoRecordUICtrl", 1, "onEncodeFinish, filePath[" + paramString + "], mDeleteThisVideo[" + this.XR + "]");
    jgx.awk();
    if (this.XR) {
      this.XR = false;
    }
    for (;;)
    {
      try
      {
        bool1 = new File(paramString).delete();
        QLog.d("QavVideoRecordUICtrl", 1, "onEncodeFinish delete=" + bool1);
        this.XQ = true;
        return;
      }
      catch (Exception paramString)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QavVideoRecordUICtrl", 2, "onEncodeFinish", paramString);
        bool1 = bool2;
        continue;
      }
      jgn.e(paramString, (Context)this.mActivity.get());
      this.mHandler.post(new QavVideoRecordUICtrl.2(this));
    }
  }
  
  public void kf(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    auu();
    if (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    Object localObject;
    int j;
    if ((this.en.getVisibility() == 0) && (!vX()) && (!ayxa.isLiuHaiUseValid()))
    {
      localObject = this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI;
      j = mc();
      int k = ma();
      if ((!paramBoolean) || (vX())) {
        bool1 = true;
      }
      ((DoubleVideoCtrlUI)localObject).H(j + k, bool1);
    }
    for (;;)
    {
      localObject = (RedPacketGameView)((AVActivity)this.mActivity.get()).findViewById(2131374182);
      if (localObject != null) {
        ((RedPacketGameView)localObject).setScoreMarginTop(l(paramBoolean));
      }
      ((AVActivity)this.mActivity.get()).cP(-1034L);
      auI();
      return;
      localObject = this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI;
      j = mc();
      if (paramBoolean)
      {
        bool1 = bool2;
        if (!vX()) {}
      }
      else
      {
        bool1 = true;
      }
      ((DoubleVideoCtrlUI)localObject).H(j, bool1);
    }
  }
  
  public void kg(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.ks(paramBoolean);
  }
  
  public void kh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b() == null) {}
    do
    {
      return;
      this.mHandler.removeMessages(14);
    } while (!paramBoolean);
    this.mHandler.sendEmptyMessageDelayed(14, this.jdField_a_of_type_ComTencentAvVideoController.b().lh);
  }
  
  public int l(boolean paramBoolean)
  {
    int k = 0;
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!vX())
      {
        j = k;
        if (this.eo != null)
        {
          j = k;
          if (this.eo.getRotation() == 0.0F) {
            j = cA(2131298307);
          }
        }
      }
    }
    return j;
  }
  
  public void mQ(int paramInt)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "removeTimeoutMsg" + paramInt);
    this.mHandler.removeMessages(paramInt);
  }
  
  public void mR(int paramInt)
  {
    XP = false;
    this.mEndTime = System.currentTimeMillis();
    QLog.w("QavVideoRecordUICtrl", 1, "endRecord, stopType[" + paramInt + "], mStartTime[" + this.mStartTime + "], mRealStartTime[" + this.oM + "], mEndTime[" + this.mEndTime + "]");
    this.mHandler.removeMessages(10);
    this.mHandler.removeMessages(11);
    this.mHandler.removeMessages(15);
    if (paramInt == 1)
    {
      dA(bR());
      if ((bR() >= 1000L) && (paramInt == 1)) {
        break label376;
      }
    }
    label376:
    for (boolean bool = true;; bool = false)
    {
      this.XR = bool;
      if (this.jdField_a_of_type_Jha != null) {
        this.jdField_a_of_type_Jha.stopRecording();
      }
      this.jdField_z_of_type_JavaIoFile = null;
      this.jdField_a_of_type_ComTencentAvVideoController.a(0, null);
      int j = this.jdField_a_of_type_ComTencentAvVideoController.unregisterDAudioDataCallback(2, true);
      int k = this.jdField_a_of_type_ComTencentAvVideoController.unregisterDAudioDataCallback(4, true);
      QLog.i("QavVideoRecordUICtrl", 1, "endRecord, after unregisterDAudioDataCallbackAll, ret2=" + j + ", ret4=" + k);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qs)
      {
        j = this.jdField_a_of_type_ComTencentAvVideoController.registerDAudioDataCallback(3, false);
        k = this.jdField_a_of_type_ComTencentAvVideoController.c(3, 48000, 1, 16);
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qq = true;
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qr = false;
        QLog.i("QavVideoRecordUICtrl", 1, "endRecord, registerDAudioDataCallback, mix = true, ret3=" + j + ", set3=" + k);
      }
      jgx.e(this.jdField_a_of_type_Jgu.azt, this.jdField_a_of_type_Jgu.azu, paramInt, bR());
      return;
      if (paramInt == 2)
      {
        dB(bR());
        break;
      }
      dA(-1L);
      break;
    }
  }
  
  public void mS(int paramInt)
  {
    paramInt = cz(paramInt);
    if (this.mCurRotate != paramInt)
    {
      this.mCurRotate = paramInt;
      kf(ww());
      auB();
    }
  }
  
  public void mT(int paramInt)
  {
    auH();
  }
  
  public void mU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 180: 
      localLayoutParams = (RelativeLayout.LayoutParams)this.dg.getLayoutParams();
      localLayoutParams.setMargins(wja.dp2px(10.0F, ((AVActivity)this.mActivity.get()).getResources()), 0, 0, 0);
      localLayoutParams.addRule(2, 0);
      localLayoutParams.addRule(1, 2131376957);
      localLayoutParams.addRule(6, 2131376957);
      this.dg.setLayoutParams(localLayoutParams);
      if (paramInt == 0)
      {
        this.dg.setGravity(19);
        this.dg.setRotation(0.0F);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(paramInt);
        return;
        this.dg.setGravity(21);
        this.dg.setRotation(180.0F);
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.dg.getLayoutParams();
    localLayoutParams.setMargins(wja.dp2px(-12.5F, ((AVActivity)this.mActivity.get()).getResources()), 0, 0, wja.dp2px(32.5F, ((AVActivity)this.mActivity.get()).getResources()));
    localLayoutParams.addRule(2, 2131376957);
    localLayoutParams.addRule(1, 0);
    localLayoutParams.addRule(6, 0);
    this.dg.setLayoutParams(localLayoutParams);
    if (paramInt == 90)
    {
      this.dg.setGravity(19);
      this.dg.setRotation(270.0F);
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(270.0F);
      return;
    }
    this.dg.setGravity(21);
    this.dg.setRotation(90.0F);
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setRotation(90.0F);
  }
  
  public void mW(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI == null) {}
    int j;
    do
    {
      boolean bool;
      do
      {
        return;
        bool = this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording;
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect " + paramInt + ", recording=" + bool);
        }
      } while ((!bool) || (((AVActivity)this.mActivity.get()).mApp == null));
      j = 1 << paramInt - 1;
      if ((this.axj & j) != j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect return, type=" + paramInt);
    return;
    this.axj = (j | this.axj);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      FaceItem localFaceItem = (FaceItem)((ijv)((AVActivity)this.mActivity.get()).mApp.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.getId().equalsIgnoreCase("daquan"))) {
        break;
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        this.mHandler.postDelayed(new QavVideoRecordUICtrl.8(this), 2000L);
      }
      for (;;)
      {
        jgx.kw("0X8008AC8");
        return;
        iwu.b(((AVActivity)this.mActivity.get()).mApp, 1022, 2131697984);
      }
      iwu.b(((AVActivity)this.mActivity.get()).mApp, 1022, 2131697983);
      jgx.kw("0X8008AC9");
      return;
      this.mHandler.sendEmptyMessageDelayed(15, 2000L);
      jgx.kw("0X8008ACA");
      return;
    }
  }
  
  int ma()
  {
    int j = 0;
    boolean bool = ayxa.isLiuHaiUseValid();
    if (ww())
    {
      if (bool) {
        j = ayxa.getNotchInScreenHeight((Activity)this.mActivity.get());
      }
    }
    else {
      return j;
    }
    return this.jdField_b_of_type_ComTencentAvUiDoubleVideoCtrlUI.mj();
  }
  
  int mb()
  {
    if (ww()) {
      return ma() + mc();
    }
    return 0;
  }
  
  public int mc()
  {
    return cA(2131298307);
  }
  
  public int md()
  {
    return this.axh;
  }
  
  public int me()
  {
    return l(ww());
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "onClick");
    if (paramView == this.L) {
      auC();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView) {
        auG();
      }
    }
  }
  
  public void onDestroy()
  {
    XP = false;
    this.mHandler.removeMessages(10);
    this.mHandler.removeMessages(11);
    if (this.jdField_a_of_type_Jha != null) {
      this.jdField_a_of_type_Jha.onDestroy();
    }
    this.ep = null;
    this.eo = null;
    this.ii = null;
    this.ij = null;
    this.ik = null;
  }
  
  public void setShowState(int paramInt)
  {
    setShowState(paramInt, true);
  }
  
  public void setShowState(int paramInt, boolean paramBoolean)
  {
    QLog.d("QavVideoRecordUICtrl", 1, "setShowState=" + paramInt);
    switch (paramInt)
    {
    default: 
      reset();
      auH();
      return;
    }
    this.axh = 3;
    this.en.setVisibility(0);
    this.mX.setVisibility(0);
    this.L.setVisibility(0);
    this.mX.setAlpha(1.0F);
    this.L.setAlpha(1.0F);
    this.e.setMargins(cA(2131298300), 0, 0, 0);
    this.mX.setLayoutParams(this.e);
    this.L.setLayoutParams(this.f);
    this.g.height = -2;
    this.g.width = -2;
    if (this.eo != null) {
      this.eo.setLayoutParams(this.g);
    }
    if (this.eo != null) {
      this.eo.requestLayout();
    }
    if (paramBoolean) {
      aus();
    }
    for (;;)
    {
      aut();
      kf(ww());
      return;
      auH();
    }
  }
  
  public void startRecord()
  {
    XP = true;
    this.mStartTime = (System.currentTimeMillis() - 200L);
    this.oM = (this.mStartTime + 99999999L);
    QLog.w("QavVideoRecordUICtrl", 1, "startRecord, mStartTime[" + this.mStartTime + "], mRealStartTime[" + this.oM + "]");
    this.mVideoSize = 0L;
    this.oN = 31457380L;
    auD();
    this.ch = System.currentTimeMillis();
    this.mHandler.sendEmptyMessageDelayed(10, 500L);
    this.mHandler.sendEmptyMessageDelayed(11, 500L);
    this.jdField_a_of_type_ComTencentAvVideoController.a(0, this);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.registerDAudioDataCallback(2, true);
    int k = this.jdField_a_of_type_ComTencentAvVideoController.registerDAudioDataCallback(4, true);
    int m = this.jdField_a_of_type_ComTencentAvVideoController.c(2, 48000, 1, 16);
    int n = this.jdField_a_of_type_ComTencentAvVideoController.c(4, 48000, 1, 16);
    QLog.i("QavVideoRecordUICtrl", 1, "startRecord, after registerDAudioDataCallback, ret2=" + j + ", ret4=" + k + ", set2=" + m + ", set4=" + n);
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qs)
    {
      j = this.jdField_a_of_type_ComTencentAvVideoController.registerDAudioDataCallback(3, true);
      k = this.jdField_a_of_type_ComTencentAvVideoController.c(3, 48000, 1, 16);
      QLog.d("QavVideoRecordUICtrl", 1, "startRecord, registerDAudioDataCallback, mix = true, ret3=" + j + ", set3=" + k);
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qq = true;
      this.jdField_a_of_type_ComTencentAvVideoController.b().Qr = true;
    }
  }
  
  public boolean vX()
  {
    return (((AVActivity)this.mActivity.get()).jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) && (((AVActivity)this.mActivity.get()).jdField_b_of_type_ComTencentAvUiVideoLayerUI.vX());
  }
  
  public boolean wA()
  {
    if ((isInBlackList()) || (!wz()) || (!wB()) || (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qo)) {}
    for (boolean bool = false;; bool = true)
    {
      QLog.i("QavVideoRecordUICtrl", 1, "isSupportRecord. isSupport = " + bool);
      return bool;
    }
  }
  
  public boolean wB()
  {
    if (this.axk == 0)
    {
      if (this.jdField_a_of_type_Jgu.azt <= this.jdField_a_of_type_Jgu.azg) {
        break label111;
      }
      this.axk = 2;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Jgu.enable != 1) {
        this.axk = 4;
      }
      if (XN) {
        this.axk = 5;
      }
      QLog.d("QavVideoRecordUICtrl", 1, "isPerformanceSupport=" + this.axk);
      if ((this.axk != 2) && (this.axk != 1) && (this.axk != 5)) {
        break;
      }
      return true;
      label111:
      if ((this.jdField_a_of_type_Jgu.azt == this.jdField_a_of_type_Jgu.azg) && (this.jdField_a_of_type_Jgu.azu >= this.jdField_a_of_type_Jgu.azh)) {
        this.axk = 2;
      } else if (this.jdField_a_of_type_Jgu.azt > this.jdField_a_of_type_Jgu.aze) {
        this.axk = 1;
      } else if ((this.jdField_a_of_type_Jgu.azt == this.jdField_a_of_type_Jgu.aze) && (this.jdField_a_of_type_Jgu.azu >= this.jdField_a_of_type_Jgu.azf)) {
        this.axk = 1;
      } else {
        this.axk = 3;
      }
    }
    return false;
  }
  
  public boolean wC()
  {
    if (this.axk == 0) {
      wB();
    }
    return this.axk == 1;
  }
  
  public boolean ww()
  {
    return this.axh == 3;
  }
  
  public boolean wx()
  {
    return (this.mCurRotate == 90) || (this.mCurRotate == 270);
  }
  
  public boolean wy()
  {
    return this.XQ;
  }
  
  public static class a
    extends Animation
  {
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      if (paramFloat < 0.5F) {}
      for (float f = (0.5F - paramFloat) / 0.5F;; f = (paramFloat - 0.5F) / 0.5F)
      {
        paramTransformation.setAlpha(f);
        super.applyTransformation(paramFloat, paramTransformation);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdh
 * JD-Core Version:    0.7.0.1
 */