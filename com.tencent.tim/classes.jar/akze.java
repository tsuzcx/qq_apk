import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.ConversationHongBao.1;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.HongbaoCaidanRainView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.LogoConfig;
import com.tencent.mobileqq.portal.PrepareView;
import com.tencent.mobileqq.portal.ProgressViewRed;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.HongBaoListView;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.LogoutReason;

public class akze
  implements Handler.Callback
{
  ImageView Cc;
  long PQ = 0L;
  StringBuilder R = new StringBuilder(12);
  StringBuilder S = new StringBuilder(8);
  public autu a;
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
  Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  public FormalView a;
  public PrepareView a;
  private ProgressViewRed jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed;
  public HongBaoListView a;
  public boolean aTW;
  public boolean aUN;
  public long afD;
  long afE;
  public long afF;
  private ValueAnimator b;
  public boolean bQN = true;
  public boolean bQO = VersionUtils.isHoneycomb();
  private boolean bQP;
  private String bUS;
  String bUT = "";
  private BreathEffectView c;
  private int cJY = -1;
  boolean cvs = true;
  public boolean cvt = true;
  private Animator.AnimatorListener d;
  int dqn = 0;
  public int dqo = 0;
  int dqp = 0;
  public int dqq = 0;
  AtomicBoolean dx = new AtomicBoolean(false);
  CountDownTimer jdField_e_of_type_AndroidOsCountDownTimer = null;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  public Runnable hm = new ConversationHongBao.1(this);
  private Activity mActivity;
  private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
  public int mState = -1;
  Handler mSubHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  public long mTaskId = -1L;
  public Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  
  public akze(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Autu = new akzh(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.mActivity = paramConversation.a();
    this.jdField_e_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private void M(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "startLoopIcon, forceStart=" + paramBoolean);
    }
    if ((this.dx.get()) && (!paramBoolean)) {
      return;
    }
    dEl();
    this.dx.set(true);
    Message.obtain(this.mSubHandler, 1004, 0, 0, null).sendToTarget();
  }
  
  private void Sw(int paramInt)
  {
    Object localObject1;
    int i;
    long l;
    if (((this.mState == 3) || (this.mState == 4) || (this.mState == 5)) && (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.EJ;
      i = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dqr;
      l = this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.scrollTime;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationHongBao", 2, "loopIcon logoList=" + localObject1 + ", index=" + paramInt + ", mState=" + this.mState + ", mode=" + i + ", scrollTime=" + l);
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= paramInt) || (!this.dx.get()) || (i != 3))
      {
        return;
        if ((this.mState == 2) && (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.EJ;
          i = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.mMode;
          l = this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.scrollTime;
        }
      }
      else
      {
        Object localObject3 = (PortalManager.LogoConfig)((List)localObject1).get(paramInt);
        Bundle localBundle = new Bundle();
        Bitmap localBitmap;
        Object localObject4;
        if (localObject3 != null)
        {
          localBitmap = PortalManager.d(((PortalManager.LogoConfig)localObject3).logoImageMD5, "hb_busi_logo_path");
          localObject4 = ((PortalManager.LogoConfig)localObject3).nameMD5;
          if (this.mState != 2) {
            break label406;
          }
        }
        label406:
        for (Object localObject2 = "hb_yure_busi_name_path";; localObject2 = "hb_name_path")
        {
          localObject2 = PortalManager.d((String)localObject4, (String)localObject2);
          localObject4 = PortalManager.d(((PortalManager.LogoConfig)localObject3).greetImageMD5, null);
          localObject3 = PortalManager.d(((PortalManager.LogoConfig)localObject3).padantImageMD5, "hb_busi_logo_path");
          localBundle.putParcelable("logoBitmap", localBitmap);
          localBundle.putParcelable("nameBitmap", (Parcelable)localObject2);
          localBundle.putParcelable("greetBitmap", (Parcelable)localObject4);
          localBundle.putParcelable("pandantBitmap", (Parcelable)localObject3);
          i = paramInt + 1;
          paramInt = i;
          if (i >= ((List)localObject1).size()) {
            paramInt = 0;
          }
          this.mUIHandler.removeMessages(1003);
          Message.obtain(this.mUIHandler, 1003, localBundle).sendToTarget();
          localObject1 = Message.obtain(this.mSubHandler, 1004, paramInt, 0, null);
          this.mSubHandler.sendMessageDelayed((Message)localObject1, l);
          return;
        }
      }
      i = -1;
      localObject1 = null;
      l = 3000L;
    }
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "updateIcon greetBitmap=" + paramBitmap3 + ", pandantBitmap=" + paramBitmap4 + ", mState=" + this.mState);
    }
    if (this.mState == 2) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setLogo(paramBitmap1, paramBitmap2);
    }
    if ((this.mState == 4) || (this.mState == 5))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressLogo(paramBitmap1, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setProgressNameBitmap(paramBitmap2, null, true);
    }
    paramBitmap1 = this.jdField_a_of_type_ComTencentWidgetHongBaoListView;
    if (this.mState != 3) {}
    for (;;)
    {
      paramBitmap1.setLogo(paramBitmap4, bool);
      if (paramBitmap3 != null) {}
      return;
      bool = false;
    }
  }
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (!this.bQP) {
      i(paramView2, paramView1);
    }
    if (this.cJY <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.mInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new akzm(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new akzn(this, paramView3);
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void c(View paramView1, View paramView2, View paramView3)
  {
    if (!this.bQP) {
      i(paramView2, paramView1);
    }
    if (this.cJY <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.b == null)
    {
      this.b = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.b.setDuration(300L);
      this.b.setInterpolator(this.mInterpolator);
      this.b.addUpdateListener(new akzf(this, paramView2, paramView1, paramView3));
      this.d = new akzg(this, paramView3, paramView1);
    }
    this.b.removeAllListeners();
    this.b.cancel();
    this.b.addListener(this.d);
    this.b.start();
  }
  
  private void dEl()
  {
    this.dx.set(false);
    this.mSubHandler.removeMessages(1004);
    this.mUIHandler.removeMessages(1003);
  }
  
  private void dEm()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) && (this.mState == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.dEG();
      this.mUIHandler.removeMessages(1006);
      this.mUIHandler.sendEmptyMessageDelayed(1006, 500L);
    }
  }
  
  private void dEn()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentWidgetHongBaoListView.etx;
      if (this.mState == 3)
      {
        int j = wja.dp2px(100.0F, this.mActivity.getResources());
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.abi(i - j);
        return;
      }
    } while ((this.mState != 2) && (this.mState != 5) && (this.mState != 4));
    dEm();
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.abi(i);
  }
  
  private void i(View paramView1, View paramView2)
  {
    this.cJY = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.cJY;
    paramView1.setLayoutParams(paramView2);
    this.bQP = true;
  }
  
  @TargetApi(11)
  public void GJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
      {
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      resetTitle();
      this.bQN = true;
    }
    while (this.bQN) {
      return;
    }
    this.bQN = true;
    b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aJ(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aK(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aL());
  }
  
  @TargetApi(11)
  public void Nx(boolean paramBoolean)
  {
    if ((!this.bQN) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {
      return;
    }
    this.bQN = false;
    if (!paramBoolean)
    {
      c(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aJ(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aK(), this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aL());
      return;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aJ();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (-this.cJY);
    localView.setLayoutParams(localLayoutParams);
    localView = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aL();
    localView.setVisibility(8);
    if (this.bQO) {
      localView.setAlpha(0.0F);
    }
    this.bQN = false;
  }
  
  public boolean atb()
  {
    if ((this.mState == -1) || (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null)) {}
    while ((!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.mForHongBao) || (!this.jdField_a_of_type_ComTencentWidgetHongBaoListView.dkw)) {
      return false;
    }
    return true;
  }
  
  public boolean atc()
  {
    if (FrameHelperActivity.ZW()) {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showPreGuide" + this.mState);
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetHongBaoListView == null) {
      return false;
    }
    dEn();
    return true;
  }
  
  public boolean atd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "startGestureGuide, " + this.mState);
    }
    switch (this.mState)
    {
    default: 
      return false;
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(1L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new akzj(this));
    int i = (int)this.jdField_e_of_type_AndroidViewViewGroup.getResources().getDimension(2131298659);
    int j = -this.jdField_a_of_type_ComTencentWidgetHongBaoListView.ON();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "startGestureGuide, " + j + "," + i);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, j, 0, i + j);
    localTranslateAnimation.setDuration(1500L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new akzk(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setAnimationListener(new akzl(this));
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.Cc.clearAnimation();
    this.Cc.startAnimation(localAnimationSet);
    return true;
  }
  
  public void bMe()
  {
    if (this.mState == -1) {
      return;
    }
    cUr();
  }
  
  public void cUr()
  {
    GJ(true);
    if (this.mState == -1) {}
    while (!atb()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "normalMode");
    }
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    FrameHelperActivity.EN(true);
    this.jdField_a_of_type_ComTencentWidgetHongBaoListView.ewR();
    cUt();
    dEk();
    this.c.stop();
    this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(8);
    this.mUIHandler.removeCallbacks(this.hm);
    dEl();
    this.mTaskId = -1L;
    this.mState = 1;
  }
  
  public void cUs()
  {
    this.mUIHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void cUt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "stopGestureGuide, " + this.mState);
    }
    this.mUIHandler.removeMessages(1001);
    this.Cc.clearAnimation();
    this.Cc.setVisibility(8);
  }
  
  public void dEk()
  {
    if (this.jdField_e_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_e_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_e_of_type_AndroidOsCountDownTimer = null;
    }
    FrameHelperActivity.EN(true);
    this.dqp = 0;
    this.afD = 0L;
    this.afE = 0L;
    ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79)).dEB();
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.etw == -this.dqo)
    {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Bitmap localBitmap1 = null;
    Bitmap localBitmap2;
    Bitmap localBitmap3;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      cUt();
      atd();
      return false;
    case 1002: 
      onResume();
      return false;
    case 1003: 
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        localBitmap1 = (Bitmap)paramMessage.getParcelable("logoBitmap");
        localBitmap2 = (Bitmap)paramMessage.getParcelable("nameBitmap");
        localBitmap3 = (Bitmap)paramMessage.getParcelable("greetBitmap");
        paramMessage = (Bitmap)paramMessage.getParcelable("pandantBitmap");
      }
      break;
    }
    for (;;)
    {
      a(localBitmap1, localBitmap2, localBitmap3, paramMessage);
      return false;
      Sw(paramMessage.arg1);
      return false;
      if ((this.dqq == 0) || (this.mState != 5)) {
        break;
      }
      this.dqq = 0;
      ((PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79)).eL(this.mActivity);
      return false;
      if (!this.aTW) {
        break;
      }
      paramMessage = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getAppInterface().getManager(79);
      if (paramMessage == null) {
        break;
      }
      paramMessage.SA(4);
      return false;
      paramMessage = null;
      localBitmap3 = null;
      localBitmap2 = null;
    }
  }
  
  void ky(long paramLong)
  {
    if (this.afF == paramLong) {
      return;
    }
    this.afF = paramLong;
    int j = (int)(paramLong / 1000L);
    int i = j / 60;
    j %= 60;
    int k = (int)paramLong % 100;
    this.S.delete(0, this.S.length());
    if (i < 10) {
      this.S.append("0");
    }
    this.S.append(i).append(":");
    if (j < 10) {
      this.S.append("0");
    }
    this.S.append(j);
    this.S.append(".");
    if (k < 10) {
      this.S.append("0");
    }
    this.S.append(k);
    this.R.delete(0, this.R.length());
    this.R.append(this.bUT);
    this.R.append(this.S);
  }
  
  public void kz(long paramLong)
  {
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79);
    long[] arrayOfLong = localPortalManager.k();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startCountDown");
      if (arrayOfLong == null) {
        break label78;
      }
    }
    label78:
    for (String str = Arrays.toString(arrayOfLong);; str = "null")
    {
      QLog.d("PortalManager", 2, str);
      if (arrayOfLong != null) {
        break;
      }
      return;
    }
    if (this.mState != 4)
    {
      this.mState = 4;
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
      FrameHelperActivity.EN(false);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.ewW();
      if ((paramLong != -1L) && (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.etw == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.dqo);
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(-this.dqo);
      }
      cUt();
      this.c.stop();
      dEl();
    }
    if (paramLong == -1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.Ny(true);
      M(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.scrollTime);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_AndroidOsCountDownTimer != null) {
        this.jdField_e_of_type_AndroidOsCountDownTimer.cancel();
      }
      if ((this.cvt) && (this.aTW)) {
        localPortalManager.SA(2);
      }
      this.jdField_e_of_type_AndroidOsCountDownTimer = new akzi(this, arrayOfLong[1], 40L, arrayOfLong);
      this.jdField_e_of_type_AndroidOsCountDownTimer.start();
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.cvu) {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dEu();
      }
    }
  }
  
  public void onDrawerClosed()
  {
    if (!atb()) {
      return;
    }
    updateState();
  }
  
  public void onDrawerOpened()
  {
    if (!atb()) {}
    do
    {
      return;
      updateState();
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() != 0) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
      }
      GJ(true);
    } while ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a == null));
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a.setPause(true);
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (this.mState == -1) {
      return;
    }
    cUr();
  }
  
  public void onPause()
  {
    this.aTW = false;
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "onPause()");
    }
    if (!atb()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a.setPause(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dEw();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.dEw();
    }
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListView.ewV();
    }
    if (this.c != null) {
      this.c.stop();
    }
    if (this.jdField_e_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_e_of_type_AndroidOsCountDownTimer.cancel();
    }
    dEl();
    updateState();
  }
  
  public void onPostThemeChanged()
  {
    if (!atb()) {
      return;
    }
    switch (this.mState)
    {
    default: 
      return;
    }
    atd();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationHongBao", 2, "onResume()");
    }
    if ((this.mUIHandler == null) || (this.mUIHandler.hasMessages(1002))) {}
    do
    {
      return;
      this.aTW = true;
    } while (!atb());
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dEt();
    }
    if (this.aUN)
    {
      if (this.cvs) {
        atc();
      }
      this.aUN = false;
    }
    switch (this.mState)
    {
    }
    for (;;)
    {
      updateState();
      this.mUIHandler.removeCallbacks(this.hm);
      this.mUIHandler.postDelayed(this.hm, 2000L);
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79);
      if (localPortalManager == null) {
        break;
      }
      localPortalManager.dEA();
      localPortalManager.dED();
      return;
      this.c.dEf();
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.mMode == 3))
      {
        M(true, this.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.scrollTime);
        continue;
        this.c.dEg();
        this.jdField_a_of_type_ComTencentWidgetHongBaoListView.ewU();
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalFormalView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.dqr == 3)) {
          M(true, this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.scrollTime);
        }
      }
    }
  }
  
  @TargetApi(11)
  public void resetTitle()
  {
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aJ();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.aL();
    if (localView1 != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localView1.setLayoutParams(localLayoutParams);
    }
    if (localView2 != null)
    {
      if (this.bQO) {
        localView2.setAlpha(1.0F);
      }
      localView2.setVisibility(0);
    }
  }
  
  public void updateState()
  {
    if (!atb()) {
      return;
    }
    switch (this.mState)
    {
    default: 
      return;
    }
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.getManager(79);
    if ((!this.aTW) || (!this.cvt) || (FrameHelperActivity.ZW()))
    {
      localPortalManager.dEB();
      FrameHelperActivity.EN(true);
      return;
    }
    FrameHelperActivity.EN(false);
    localPortalManager.SA(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akze
 * JD-Core Version:    0.7.0.1
 */