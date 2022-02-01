package com.tencent.mobileqq.activity.aio.audiopanel;

import acbs;
import acfp;
import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqcl;
import aqft;
import auru;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import mqq.os.MqqHandler;
import wpi;
import wpj;
import wpj.b;
import wpm;

public class AudioPanel
  extends LinearLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, wpj.b
{
  private static final int bPN;
  private static final int bPV;
  private static final int bPW;
  private static final int bPX;
  private static PopupWindow e;
  private static final int[] hl = { 1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000 };
  private static final float pP;
  private TextView Im;
  private TextView In;
  private auru jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  private AudioPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter;
  private AudioPanelViewPager jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager;
  private PressToSpeakPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel;
  private PttTextTransitionAnim jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim;
  private PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  private QQAppInterface app;
  private int bPO;
  private int bPP;
  private int bPQ;
  private int bPR = -1;
  private int bPS = -1;
  private int bPT;
  private int bPU;
  private int bPY;
  private Rect bc;
  private Rect bd;
  private boolean beK;
  private boolean beL;
  private boolean beM;
  private boolean beN;
  private boolean beO;
  private boolean beP;
  private boolean beQ;
  private boolean beR;
  private boolean beS;
  private boolean beT;
  private BaseChatPie c;
  private String[] cC = new String[3];
  private LottieDrawable d;
  private ViewGroup dc;
  private ViewGroup dd;
  private Runnable ej = new AudioPanel.2(this);
  private RelativeLayout ht;
  private boolean init;
  private float kW;
  private Paint mPaint;
  private float mStrokeWidth;
  private float pO;
  private SessionInfo sessionInfo;
  private ImageView sq;
  private int status = 1;
  
  static
  {
    bPN = hl[1] - hl[0];
    int i;
    int j;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = 55;
      bPV = i;
      j = bPV;
      if (Build.VERSION.SDK_INT < 16) {
        break label175;
      }
      i = 4;
    }
    for (;;)
    {
      bPW = j - i;
      pP = (bPV + bPW) * 0.52F / 1200.0F;
      bPX = (bPV + bPW) * -40 / 1200;
      return;
      if (Build.VERSION.SDK_INT > 9)
      {
        i = 65;
        break;
      }
      i = 85;
      break;
      label175:
      if (Build.VERSION.SDK_INT > 9) {
        i = 6;
      } else {
        i = 8;
      }
    }
  }
  
  public AudioPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void Ct(int paramInt)
  {
    int i = -1;
    int j = getCurrentItem();
    if (paramInt == 2131378608) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "doClickItemTransitionAnim() lastSelectItem is:" + j + " nextItem=" + i);
      }
      if ((i >= 0) && (i != j))
      {
        yK(true);
        this.beS = true;
        fp(j, i);
      }
      return;
      if (paramInt == 2131376963) {
        i = 1;
      }
    }
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    paramViewGroup2 = (ViewGroup)paramViewGroup1.getParent();
    int j = paramViewGroup2.getChildCount();
    int i = 0;
    if (i < j) {
      if (paramViewGroup2.getChildAt(i) != paramViewGroup1) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        paramContext = new View(paramContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, paramViewGroup1.getHeight());
        localLayoutParams.addRule(6, paramViewGroup1.getId());
        localLayoutParams.addRule(8, paramViewGroup1.getId());
        paramContext.setLayoutParams(localLayoutParams);
        paramViewGroup2.addView(paramContext, i);
        return paramContext;
        i += 1;
        break;
      }
      return null;
      i = -1;
    }
  }
  
  public static PopupWindow a()
  {
    return e;
  }
  
  public static PopupWindow a(Context paramContext, int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((e != null) && (e.isShowing())) {
      return e;
    }
    paramContext = new View(paramContext);
    paramContext.setBackgroundColor(1275068416);
    e = new PopupWindow(paramContext, paramInt1, paramInt2);
    try
    {
      if (Build.VERSION.SDK_INT >= 22) {
        e.setAttachedInDecor(false);
      }
      e.setClippingEnabled(false);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AudioPanel", 2, paramContext, new Object[0]);
        }
      }
    }
    if (paramView.getWindowToken() != null) {
      e.showAtLocation(paramView, paramInt3, paramInt4, paramInt5);
    }
    return e;
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 1000.0D) {}
    int j;
    for (int i = 0;; i = (int)(paramDouble / 1000.0D + 0.5D))
    {
      j = i / 60;
      i %= 60;
      if (i >= 10) {
        break;
      }
      return j + ":0" + i;
    }
    return j + ":" + i;
  }
  
  private void ap(float paramFloat)
  {
    if (this.pO == 0.0F) {
      this.pO = paramFloat;
    }
    for (;;)
    {
      return;
      paramFloat -= this.pO;
      int i = 0;
      if (paramFloat > 0.0F) {
        i = 1;
      }
      while (this.bPU != i)
      {
        this.beR = true;
        this.bPU = i;
        return;
        if (paramFloat < 0.0F) {
          i = -1;
        }
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "doPageScrolledTransitionAnim() curItem is:" + paramInt1 + " nextItem=" + paramInt2 + " needDoPageScrolledTransitionAnim=" + this.beR + " nextdirect=" + this.bPU);
    }
    paramInt2 = fd(paramInt2);
    if ((this.beR) && (paramInt1 != paramInt2))
    {
      fp(paramInt1, paramInt2);
      this.beR = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setScrollDis(paramFloat, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth());
    if ((this.d != null) && (!this.beR))
    {
      float f = paramFloat;
      if (Math.abs(paramFloat) > this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth()) {
        f = Math.abs(paramFloat) - this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth();
      }
      paramFloat = wpm.b(f, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth());
      wpj.a().a(this.d, paramFloat, this.bPS, this.beS);
    }
  }
  
  private void cag()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.q();
      Rect localRect = new Rect();
      ((ImageView)localObject).getGlobalVisibleRect(localRect);
      localObject = new Rect();
      super.getGlobalVisibleRect((Rect)localObject);
      int i = localRect.left - ((Rect)localObject).left;
      int j = localRect.top - ((Rect)localObject).top;
      this.mStrokeWidth = TypedValue.applyDimension(1, 30.0F, getResources().getDisplayMetrics());
      this.bc = new Rect(i, j, localRect.width() + i, localRect.height() + j);
      this.bPY = 40;
      this.kW = 0.98F;
      if (QLog.isColorLevel()) {
        QLog.d("HollowRound", 2, "initAndStartHollowRoundAnim:" + this.bPY + ", " + this.kW);
      }
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      cai();
    }
  }
  
  private void cah()
  {
    if (this.bc != null)
    {
      this.bPY += bPX;
      this.kW += pP;
      if (QLog.isColorLevel()) {
        QLog.d("HollowRound", 2, "updateHollowRoundAnim:" + this.bPY + ", " + this.kW);
      }
    }
  }
  
  private void cai()
  {
    if (this.bd == null)
    {
      super.invalidate();
      return;
    }
    super.invalidate(this.bd);
  }
  
  private void cal()
  {
    yK(true);
    this.beQ = true;
    this.bPT = getCurrentItem();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(this.bPT);
    this.pO = 0.0F;
    this.bPU = 0;
    this.beL = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageScrollStateChanged()   SCROLL_STATE_DRAGGING curItemWhenPageStatusChangeToDrag=" + this.bPT + " needDoPageScrolledTransitionAnim=" + this.beR);
    }
  }
  
  private void cam()
  {
    this.beQ = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(getCurrentItem());
    if ((!this.beS) && (this.d != null))
    {
      this.d.endAnimation();
      cak();
    }
  }
  
  public static int fc(int paramInt)
  {
    int i = 8000;
    if (paramInt < 5000) {
      i = 4000;
    }
    for (;;)
    {
      paramInt = Math.min((int)(i * 0.3F / bPN), hl.length - 1);
      return hl[paramInt];
      if (paramInt >= 8000) {
        if (paramInt < 10000) {
          i = 10000;
        } else if (paramInt < 14000) {
          i = 13000;
        } else if (paramInt < 18000) {
          i = 16000;
        } else if (paramInt < 23000) {
          i = 19000;
        } else if (paramInt < 27000) {
          i = 22000;
        } else if (paramInt < 32000) {
          i = 25000;
        } else if (paramInt < 35000) {
          i = 28000;
        } else if (paramInt < 40000) {
          i = 32000;
        } else if (paramInt < 50000) {
          i = 40000;
        } else {
          i = 40000;
        }
      }
    }
  }
  
  private int fd(int paramInt)
  {
    int i = 1;
    if (paramInt > 1) {
      paramInt = i;
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void fp(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "doTransitionAnimByNextItem lastSelectItem is:" + paramInt1 + " nextItem=" + paramInt2);
    }
    if (!wpj.a().bT()) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "file not exsit");
      }
    }
    int i;
    do
    {
      return;
      i = paramInt1;
      if (paramInt1 < 0) {
        i = getCurrentItem();
      }
    } while (i == paramInt2);
    this.bPS = wpm.ai(i, paramInt2);
    s(getContext(), this.beS);
  }
  
  private int vR()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager != null) {}
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem())
    {
    default: 
      return -15158044;
    case 0: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167293);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167293);
  }
  
  public void Cr(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
      requestLayout();
      a(this.dd, this.dd.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167294), vR());
    }
  }
  
  public void Cs(int paramInt)
  {
    yK(true);
    this.bPS = wpm.fe(paramInt);
    this.beS = true;
    s(getContext(), true);
  }
  
  public void G(ViewGroup paramViewGroup) {}
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "onAnimationEnd AudioPanel mCurAnimType:" + this.bPS + ",type= " + paramInt + " isPageViewStartDragger=" + this.beQ);
    }
    if (!wpm.gs(paramInt)) {}
    do
    {
      return;
      this.beS = false;
    } while (this.beQ);
    cak();
  }
  
  void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int k = getCurrentItem();
      int i = 0;
      if (i < j)
      {
        Object localObject;
        if (i != k)
        {
          localObject = paramViewGroup.getChildAt(i);
          if ((localObject instanceof TextView))
          {
            localObject = (TextView)localObject;
            ((TextView)localObject).setTextColor(paramInt1);
            ((TextView)localObject).setTextSize(2, 13.0F);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((paramView instanceof TextView))
          {
            localObject = (TextView)paramView;
            ((TextView)localObject).setTextColor(paramInt2);
            ((TextView)localObject).setTextSize(2, 15.0F);
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, InputLinearLayout paramInputLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = paramInputLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
    this.c = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager = ((AudioPanelViewPager)findViewById(2131372827));
    this.sq = ((ImageView)findViewById(2131363072));
    this.ht = ((RelativeLayout)findViewById(2131363073));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim = ((PttTextTransitionAnim)findViewById(2131373744));
    this.dc = ((ViewGroup)findViewById(2131372819));
    this.Im = ((TextView)findViewById(2131378608));
    this.In = ((TextView)findViewById(2131376963));
    this.dd = ((ViewGroup)findViewById(2131372818));
    if (this.c.aSM) {
      this.dc.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = new AudioPanelAdapter(paramQQAppInterface, paramBaseChatPie, this, this.dc, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(0);
    this.Im.setTextColor(vR());
    this.In.setTextColor(this.In.getContext().getResources().getColor(2131167383));
    this.init = true;
    this.beM = true;
    this.Im.setOnClickListener(this);
    this.In.setOnClickListener(this);
    paramBaseChatPie = getResources().getDrawable(2130851275);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    }
    for (;;)
    {
      paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBaseChatPie.setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
      for (;;)
      {
        this.jdField_a_of_type_Auru.sendEmptyMessage(3);
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel.init() is called,time is:" + System.currentTimeMillis());
        }
        if (aqft.rj(this.sessionInfo.aTl))
        {
          paramQQAppInterface = (acbs)paramQQAppInterface.getBusinessHandler(53);
          if (paramQQAppInterface.io(2)) {
            paramQQAppInterface.cGZ();
          }
        }
        wpj.a().a(this);
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label458;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "AudioPanel background is null:");
        }
      }
      label458:
      paramBaseChatPie = null;
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "onDrawableLoaded AudioPanel mCurAnimType:" + this.bPS + ",type= " + paramInt + " drawable=" + paramLottieDrawable);
    }
    if (!wpm.gs(paramInt)) {}
    do
    {
      do
      {
        return;
      } while (this.bPS != paramInt);
      this.d = paramLottieDrawable;
    } while (this.d == null);
    ThreadManager.getUIHandler().removeCallbacks(this.ej);
    ThreadManager.getUIHandler().post(this.ej);
  }
  
  public void cae()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh instanceof ListenChangeVoicePanel)))
    {
      ((wpi)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh).onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.dh = null;
    }
  }
  
  public void caf()
  {
    if (this.bc != null) {
      yJ(true);
    }
  }
  
  public void caj()
  {
    int i = this.c.bEv;
    if (i < 0) {
      return;
    }
    this.c.bEv = -1;
    ThreadManager.post(new AudioPanel.1(this, i), 8, null, false);
  }
  
  public void cak()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanel", 2, "hideAnimLayout ");
    }
    if (this.ht != null) {
      this.ht.setVisibility(8);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Rect localRect = this.bc;
    if (localRect != null)
    {
      if (this.bPY > 0) {
        break label42;
      }
      if (!this.beT) {
        yI(true);
      }
    }
    else
    {
      return;
    }
    yJ(false);
    return;
    label42:
    float f1 = localRect.width() / 2;
    float f2 = this.kW * f1;
    if (f2 > this.mStrokeWidth + f1) {
      f1 = this.mStrokeWidth;
    }
    for (;;)
    {
      if (f1 > 0.0F)
      {
        float f3 = f1 / 2.0F;
        this.mPaint.setColor(Color.argb(this.bPY, 0, 0, 255));
        this.mPaint.setStrokeWidth(f1);
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f2 - f3, this.mPaint);
      }
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(2, bPV);
      return;
      if (f2 > f1) {
        f1 = f2 - f1;
      } else {
        f1 = 0.0F;
      }
    }
  }
  
  public int getCurrentItem()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
    }
    return i;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      cag();
    }
    do
    {
      return true;
      if (paramMessage.what == 2)
      {
        cah();
        cai();
        return true;
      }
    } while (paramMessage.what != 3);
    return true;
  }
  
  public boolean onBackEvent()
  {
    int i;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.de != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.de;
      int j = localViewGroup.getChildCount();
      i = 0;
      if (i >= j) {
        break label91;
      }
      localView = localViewGroup.getChildAt(i);
      if (localView.getVisibility() != 0) {}
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof wpi))) {}
      for (boolean bool = ((wpi)localView).onBackEvent();; bool = false)
      {
        yJ(true);
        return bool;
        i += 1;
        break;
      }
      label91:
      localView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Ct(i);
    if (i == 2131378608)
    {
      setCurrentPannel(0, false);
      i = 0;
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "changevoice", "0X8006F4D", 0, 0, "" + i, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131376963)
      {
        setCurrentPannel(1, false);
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    this.bPS = -1;
    ThreadManager.getUIHandler().removeCallbacks(this.ej);
    wpj.a().onDestory();
    if (this.c.vm() != 36) {
      e = null;
    }
    int i;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.de != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.de;
      int j = localViewGroup.getChildCount();
      i = 0;
      if (i >= j) {
        break label115;
      }
      localView = localViewGroup.getChildAt(i);
      if (localView.getVisibility() != 0) {
        break label108;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof wpi))) {
        ((wpi)localView).onDestroy();
      }
      caj();
      return;
      label108:
      i += 1;
      break;
      label115:
      localView = null;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!this.beL) || (this.beM))
    {
      this.beM = false;
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      View localView = this.dd.getChildAt(paramInt2);
      if (localView != null)
      {
        paramInt1 = (paramInt3 - paramInt1 - localView.getWidth()) / 2;
        paramInt2 = localView.getLeft();
        this.dd.scrollTo(paramInt2 - paramInt1, this.dd.getScrollY());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() == 0)
      {
        boolean bool = ListenChangeVoicePanel.bfb;
        if (!bool) {}
      }
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageScrollStateChanged() is called,state is:" + paramInt + " onPageScrolled=" + this.beQ);
    }
    if (paramInt == 1) {
      cal();
    }
    while (paramInt != 0) {
      return;
    }
    cam();
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getWidth();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getPageMargin() + paramInt1;
    if (!this.beL)
    {
      this.bPQ = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem();
      this.bPO = ((this.bPQ + this.bPR) * paramInt2);
      this.bPP = this.dd.getScrollX();
      this.beL = true;
    }
    paramFloat = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX() - this.bPO;
    if (paramFloat < 0.0F) {
      paramInt1 = this.bPQ - 1;
    }
    for (;;)
    {
      ap(paramFloat);
      if ((!this.beS) && (this.bPU != 0)) {
        c(this.bPT, this.bPT + this.bPU, paramFloat);
      }
      View localView1 = this.dd.getChildAt(this.bPQ);
      View localView2 = this.dd.getChildAt(paramInt1);
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "onPageScrolled() is called,pageBeforeScroll is:" + this.bPQ + ",nextPage is:" + paramInt1 + ",vpWidthWithMargin is:" + paramInt2);
        QLog.d("AIOAudioPanel", 2, "onPageScrolled vpRelativeScrollX is:" + paramFloat + ",vpScrollXBeforeScroll is:" + this.bPO + ",pdScrollXBeforeScroll is:" + this.bPP + " viewPager.getScrollX()=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getScrollX() + " curItem=" + this.bPT + ", centerChild:" + localView1 + ", centerChild:" + localView2);
      }
      if ((localView1 != null) && (localView2 != null))
      {
        paramInt1 = localView1.getLeft();
        int i = localView1.getWidth() / 2;
        int j = localView2.getLeft();
        int k = localView2.getWidth() / 2;
        paramFloat = Math.abs(paramFloat / paramInt2);
        paramInt1 = (int)((j + k - (paramInt1 + i)) * paramFloat);
        this.dd.scrollTo(paramInt1 + this.bPP, this.dd.getScrollY());
      }
      return;
      if (paramFloat > 0.0F) {
        paramInt1 = this.bPQ + 1;
      } else {
        paramInt1 = this.bPQ;
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "onPageSelected() is called,position is:" + paramInt + " onPageScrolled=" + this.beQ);
    }
    int i;
    label172:
    Object localObject;
    if (paramInt == 0)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005471", "0X8005471", 0, 0, "", "", "", "");
      a(this.dd, this.dd.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167294), vR());
      this.c.m(paramInt, this.init, this.beN);
      this.beN = false;
      if ((!AppSetting.enableTalkBack) || (this.cC == null) || (paramInt >= this.cC.length)) {
        return;
      }
      i = 0;
      if (i >= this.dd.getChildCount()) {
        break label341;
      }
      localObject = this.dd.getChildAt(i);
      if ((localObject != null) && (i < this.cC.length))
      {
        localObject = (TextView)localObject;
        this.cC[i] = this.app.getApp().getString(2131690104, new Object[] { ((TextView)localObject).getText() });
        if (paramInt != i) {
          break label328;
        }
        ((TextView)localObject).setContentDescription(acfp.m(2131702923) + this.cC[i]);
      }
    }
    for (;;)
    {
      i += 1;
      break label172;
      if (paramInt != 1) {
        break;
      }
      anot.a(this.app, "dc00898", "", "", "0X800A1D2", "0X800A1D2", 0, 0, "", "", "", "");
      break;
      label328:
      ((TextView)localObject).setContentDescription(this.cC[i]);
    }
    label341:
    aqcl.speak(this.dd, acfp.m(2131702922) + this.cC[paramInt]);
  }
  
  public void onPause()
  {
    BaseChatPie.aSH = false;
    caj();
    int i;
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.de != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.de;
      int j = localViewGroup.getChildCount();
      i = 0;
      if (i >= j) {
        break label87;
      }
      localView = localViewGroup.getChildAt(i);
      if (localView.getVisibility() != 0) {
        break label80;
      }
    }
    for (;;)
    {
      if ((localView != null) && ((localView instanceof wpi))) {
        ((wpi)localView).onPause();
      }
      yJ(true);
      return;
      label80:
      i += 1;
      break;
      label87:
      localView = null;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void s(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "playTransitionAnimByType AudioTransitionAnimManager animType:" + this.bPS + " mCurLottieDrawable=" + this.d);
    }
    wpj localwpj = wpj.a();
    localwpj.a(this);
    if (this.d != null) {
      localwpj.b(this.d);
    }
    for (;;)
    {
      this.d = localwpj.a(paramContext, this.bPS);
      if (this.d != null) {
        localwpj.a(this.d, this.bPS, this.sq, paramBoolean);
      }
      return;
      this.ht.setVisibility(0);
    }
  }
  
  public void setCurrentPannel(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 2)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem() != paramInt)
    {
      this.beN = paramBoolean;
      this.beO = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.setCurrentItem(paramInt);
      requestLayout();
      a(this.dd, this.dd.getChildAt(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getCurrentItem()), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.getContext().getResources().getColor(2131167294), vR());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelViewPager.beV) {
      this.bPR = (-paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTextTransitionAnim.setCurrentItem(paramInt);
  }
  
  public void setReceiptMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.setReceiptMode(paramBoolean);
    this.beP = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setUseOnce(true);
    }
  }
  
  public void setSpeakPanel(PressToSpeakPanel paramPressToSpeakPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel = paramPressToSpeakPanel;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel.setUseOnce(this.beP);
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setStatus(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.beK) {
      this.beK = false;
    }
    if (paramInt == 0) {
      anot.a(this.app, "CliOper", "", "", "changevoice", "0X8006F49", 0, 0, "" + getCurrentItem(), "", "", "");
    }
  }
  
  public void yI(boolean paramBoolean)
  {
    int i = 0;
    yJ(false);
    this.beT = paramBoolean;
    auru localauru = this.jdField_a_of_type_Auru;
    if (paramBoolean) {
      i = 600;
    }
    localauru.sendEmptyMessageDelayed(1, i + 1200);
  }
  
  public void yJ(boolean paramBoolean)
  {
    if (this.bc != null)
    {
      this.bc = null;
      this.bd = null;
    }
    this.beT = false;
    this.jdField_a_of_type_Auru.removeMessages(2);
    this.jdField_a_of_type_Auru.removeMessages(1);
    if (paramBoolean) {
      cai();
    }
  }
  
  public void yK(boolean paramBoolean)
  {
    if (!wpj.a().bT()) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "showAnimLayout fileNotExsit");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.ht == null);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanel", 2, "showAnimMask needStopLastAnim=" + paramBoolean);
      }
      if ((paramBoolean) && (this.d != null) && (this.d.isAnimating())) {
        this.d.endAnimation();
      }
    } while (this.d == null);
    this.ht.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel
 * JD-Core Version:    0.7.0.1
 */