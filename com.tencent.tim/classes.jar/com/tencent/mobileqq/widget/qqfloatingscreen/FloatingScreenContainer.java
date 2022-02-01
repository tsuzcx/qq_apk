package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import arkr;
import arks;
import arkt;
import arku;
import arkv;
import arkw;
import arlc;
import wja;

public class FloatingScreenContainer
  extends FrameLayout
{
  private a jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$a;
  private b jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$b;
  private c jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$c;
  private FloatingScreenParams jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams;
  private ValueAnimator aR;
  private FloatingScreenParams b;
  private ObjectAnimator bP;
  private boolean dcd;
  private int ejY = 0;
  private int ejZ;
  private WindowManager.LayoutParams i;
  private Context mContext;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mScreenHeight;
  private int mScreenWidth;
  private int mTouchSlop = 20;
  private WindowManager mWindowManager;
  
  public FloatingScreenContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingScreenContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingScreenContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    if (this.mWindowManager != null)
    {
      this.mScreenHeight = this.mWindowManager.getDefaultDisplay().getHeight();
      this.mScreenWidth = this.mWindowManager.getDefaultDisplay().getWidth();
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.ejZ = 2038;
      return;
    }
    this.ejZ = 2002;
  }
  
  private void YX(int paramInt)
  {
    this.ejY = paramInt;
  }
  
  private void a(WindowManager.LayoutParams paramLayoutParams)
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    if (this.bP != null)
    {
      if (this.bP.isRunning()) {
        this.bP.cancel();
      }
      this.bP = null;
    }
    this.bP = ObjectAnimator.ofPropertyValuesHolder(this.mWindowManager, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.bP.addUpdateListener(new arkt(this, paramLayoutParams));
    this.bP.addListener(new arku(this));
    this.bP.start();
  }
  
  private void b(WindowManager.LayoutParams paramLayoutParams)
  {
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F });
    if (this.bP != null)
    {
      if (this.bP.isRunning()) {
        this.bP.cancel();
      }
      this.bP = null;
    }
    this.bP = ObjectAnimator.ofPropertyValuesHolder(this.mWindowManager, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.bP.addUpdateListener(new arkv(this, paramLayoutParams));
    this.bP.addListener(new arkw(this));
    this.bP.start();
  }
  
  private void ejK()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = this.b.clone();
    k = 28;
    j = k;
    if (this.mContext != null)
    {
      j = k;
      if (this.mContext.getResources() != null) {
        j = wja.dp2px(14.0F, this.mContext.getResources());
      }
    }
    m = 0;
    k = m;
    try
    {
      if (this.mContext != null)
      {
        k = m;
        if (this.mContext.getResources() != null)
        {
          n = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
          k = m;
          if (n > 0) {
            k = this.mContext.getResources().getDimensionPixelSize(n);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int n;
        int i1;
        WindowManager.LayoutParams localLayoutParams;
        int i2;
        localException.printStackTrace();
        k = m;
        continue;
        j = m;
        continue;
      }
    }
    m = this.mScreenWidth / 2 - j - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() / 2;
    i1 = this.mScreenHeight / 2 - j - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() / 2;
    n = -i1 + k;
    j = -this.mScreenWidth;
    k = -this.mScreenHeight;
    localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    localLayoutParams.gravity = 17;
    if (localLayoutParams.x < -m) {
      j = -m;
    }
    if (localLayoutParams.x > m) {
      j = m;
    }
    if (localLayoutParams.y < n) {
      k = n;
    }
    if (localLayoutParams.y > i1)
    {
      k = i1;
      if ((localLayoutParams.x > -m) && (localLayoutParams.x < m)) {
        if (localLayoutParams.x < 0)
        {
          j = -m;
          if (this.aR != null)
          {
            if (this.aR.isRunning()) {
              this.aR.cancel();
            }
            this.aR = null;
          }
          this.aR = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          this.aR.setTarget(this);
          this.aR.setDuration(200L);
          i1 = localLayoutParams.x;
          i2 = localLayoutParams.y;
          this.aR.addUpdateListener(new arkr(this, j, m, localLayoutParams, i1, k, n, i2));
          this.aR.addListener(new arks(this));
          this.aR.start();
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$b != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$b.bRI();
          }
          return;
        }
      }
    }
  }
  
  private void ejL()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        this.i = ((WindowManager.LayoutParams)getLayoutParams());
        this.i.layoutInDisplayCutoutMode = 2;
        if (this.mWindowManager != null) {
          this.mWindowManager.updateViewLayout(this, this.i);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void init(Context paramContext)
  {
    if (paramContext != null) {
      this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    }
  }
  
  private void kE(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getCanMove())
    {
      this.b.setShapeType(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType());
      this.b.setFloatingCenterX(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX() + paramInt1);
      this.b.setFloatingCenterY(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY() + paramInt2);
      c(b(this.b));
    }
  }
  
  public void TY(boolean paramBoolean)
  {
    FloatingScreenParams localFloatingScreenParams = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams;
    if (paramBoolean) {}
    for (j = 1;; j = 2)
    {
      localFloatingScreenParams.setShapeType(j);
      int i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
      m = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();
      i1 = 28;
      n = 0;
      j = n;
      k = i1;
      if (this.mContext != null)
      {
        j = n;
        k = i1;
        if (this.mContext.getResources() != null) {
          i1 = wja.dp2px(14.0F, this.mContext.getResources());
        }
      }
      try
      {
        int i3 = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        j = n;
        k = i1;
        if (i3 > 0)
        {
          j = this.mContext.getResources().getDimensionPixelSize(i3);
          k = i1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          j = n;
          k = i1;
          continue;
          j = m;
        }
      }
      i1 = this.mScreenWidth / 2 - k - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth() / 2;
      n = this.mScreenHeight / 2 - k - this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight() / 2;
      j += -n;
      k = i1;
      if (i2 < 0) {
        k = -i1;
      }
      if (m >= j) {
        break;
      }
      m = j;
      if (j > n) {
        m = n;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterX(k);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setFloatingCenterY(m);
      if (this.i == null) {
        this.i = ((WindowManager.LayoutParams)getLayoutParams());
      }
      this.i.width = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth();
      this.i.height = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight();
      this.i.x = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
      this.i.y = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();
      this.i.gravity = 17;
      c(this.i);
      return;
    }
  }
  
  public void YY(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShapeType(paramInt);
      this.b = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
      c(b(this.b));
    }
  }
  
  WindowManager.LayoutParams a(FloatingScreenParams paramFloatingScreenParams)
  {
    int j = (this.mScreenWidth - paramFloatingScreenParams.getOuterWidth()) / 2;
    int k = (this.mScreenHeight - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > j)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() > 0) {
        paramFloatingScreenParams.setFloatingCenterX(j);
      }
    }
    else if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > k) {
      if (paramFloatingScreenParams.getFloatingCenterY() <= 0) {
        break label210;
      }
    }
    label210:
    for (j = k;; j = -k)
    {
      paramFloatingScreenParams.setFloatingCenterY(j);
      if (this.i == null) {
        this.i = new WindowManager.LayoutParams();
      }
      this.i.type = this.ejZ;
      this.i.format = 1;
      this.i.flags = 16777256;
      this.i.width = paramFloatingScreenParams.getOuterWidth();
      this.i.height = paramFloatingScreenParams.getOuterHeight();
      this.i.x = paramFloatingScreenParams.getFloatingCenterX();
      this.i.y = paramFloatingScreenParams.getFloatingCenterY();
      if (Build.VERSION.SDK_INT >= 28) {
        this.i.layoutInDisplayCutoutMode = 2;
      }
      if (!arlc.ck(this.mContext)) {
        this.i.systemUiVisibility = 5892;
      }
      return this.i;
      j = -j;
      break;
    }
  }
  
  public void a(View paramView, FloatingScreenParams paramFloatingScreenParams)
  {
    if (aGM()) {
      aGP();
    }
    ejI();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams = paramFloatingScreenParams;
    this.b = paramFloatingScreenParams.clone();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    removeAllViews();
    addView(paramView, localLayoutParams);
    a(paramFloatingScreenParams);
    ejK();
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams)
  {
    try
    {
      if (this.mWindowManager != null)
      {
        paramFloatingScreenParams = a(paramFloatingScreenParams);
        this.mWindowManager.addView(this, paramFloatingScreenParams);
      }
      return;
    }
    catch (Exception paramFloatingScreenParams)
    {
      paramFloatingScreenParams.printStackTrace();
    }
  }
  
  public boolean aGM()
  {
    return this.ejY != 0;
  }
  
  public boolean aGN()
  {
    return this.ejY == 1;
  }
  
  public boolean aGO()
  {
    return this.ejY == 2;
  }
  
  public boolean aGP()
  {
    if (!aGM()) {
      return false;
    }
    ejH();
    setVisibility(8);
    ejL();
    ejM();
    this.i = null;
    stopAnimation();
    removeAllViews();
    this.b = null;
    return true;
  }
  
  public void aVf()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams == null) || (!aGN())) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShowPadding(false);
    }
    a(c());
    ejJ();
  }
  
  WindowManager.LayoutParams b(FloatingScreenParams paramFloatingScreenParams)
  {
    int j = (this.mScreenWidth - paramFloatingScreenParams.getOuterWidth()) / 2;
    int k = (this.mScreenHeight - paramFloatingScreenParams.getOuterHeight()) / 2;
    if (Math.abs(paramFloatingScreenParams.getFloatingCenterX()) > j)
    {
      if (paramFloatingScreenParams.getFloatingCenterX() > 0) {
        paramFloatingScreenParams.setFloatingCenterX(j);
      }
    }
    else if (Math.abs(paramFloatingScreenParams.getFloatingCenterY()) > k) {
      if (paramFloatingScreenParams.getFloatingCenterY() <= 0) {
        break label145;
      }
    }
    label145:
    for (j = k;; j = -k)
    {
      paramFloatingScreenParams.setFloatingCenterY(j);
      if (this.i == null) {
        this.i = ((WindowManager.LayoutParams)getLayoutParams());
      }
      this.i.width = paramFloatingScreenParams.getOuterWidth();
      this.i.height = paramFloatingScreenParams.getOuterHeight();
      this.i.x = paramFloatingScreenParams.getFloatingCenterX();
      this.i.y = paramFloatingScreenParams.getFloatingCenterY();
      return this.i;
      j = -j;
      break;
    }
  }
  
  public void bh(float paramFloat)
  {
    if (paramFloat != this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getScreenRatio())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setScreenRatio(paramFloat);
      this.b = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.clone();
      c(b(this.b));
    }
  }
  
  WindowManager.LayoutParams c()
  {
    if (this.i == null) {
      this.i = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.i.type = this.ejZ;
    this.i.format = 1;
    this.i.width = -1;
    this.i.height = -1;
    this.i.x = 0;
    this.i.y = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      this.i.layoutInDisplayCutoutMode = 1;
    }
    if (!arlc.ck(this.mContext)) {
      this.i.flags = 256;
    }
    return this.i;
  }
  
  public void c(WindowManager.LayoutParams paramLayoutParams)
  {
    try
    {
      if (this.mWindowManager != null) {
        this.mWindowManager.updateViewLayout(this, paramLayoutParams);
      }
      return;
    }
    catch (Exception paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
  }
  
  WindowManager.LayoutParams d()
  {
    if (this.i == null) {
      this.i = ((WindowManager.LayoutParams)getLayoutParams());
    }
    this.i.type = this.ejZ;
    this.i.format = 1;
    this.i.flags = 40;
    if (Build.VERSION.SDK_INT >= 28) {
      this.i.layoutInDisplayCutoutMode = 2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null)
    {
      this.i.width = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterWidth();
      this.i.height = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getOuterHeight();
      this.i.x = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
    }
    for (this.i.y = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();; this.i.y = 0)
    {
      return this.i;
      this.i.width = 500;
      this.i.height = 281;
      this.i.x = 200;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (aGO()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$a.onBackPressed();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  void ejH()
  {
    YX(0);
  }
  
  void ejI()
  {
    YX(1);
  }
  
  void ejJ()
  {
    YX(2);
  }
  
  public void ejM()
  {
    try
    {
      if (this.mWindowManager != null) {
        this.mWindowManager.removeView(this);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void ejN()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.setShowPadding(true);
    }
    b(d());
    ejI();
  }
  
  public int getFloatingCenterX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterX();
    }
    return 0;
  }
  
  public int getFloatingCenterY()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getFloatingCenterY();
    }
    return 0;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (aGO())
    {
      this.mIsBeingDragged = false;
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      this.mInitialMotionY = paramMotionEvent.getY();
      this.mInitialMotionX = paramMotionEvent.getX();
      this.mIsBeingDragged = false;
      continue;
      float f1 = paramMotionEvent.getY();
      float f2 = paramMotionEvent.getX();
      if ((Math.abs(this.mInitialMotionY - f1) > this.mTouchSlop) || (Math.abs(this.mInitialMotionX - f2) > this.mTouchSlop)) {
        bool = true;
      }
      this.mIsBeingDragged = bool;
      if (this.mIsBeingDragged)
      {
        this.mInitialMotionY = paramMotionEvent.getRawY();
        this.mInitialMotionX = paramMotionEvent.getRawX();
        continue;
        this.mIsBeingDragged = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mIsBeingDragged) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.dcd)
    {
      Log.d("FloatingScreenContainer", "could not dragging while scaling!");
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      float f = paramMotionEvent.getRawY();
      kE((int)(paramMotionEvent.getRawX() - this.mInitialMotionX), (int)(f - this.mInitialMotionY));
      continue;
      ejK();
    }
  }
  
  public void setOnBackPressListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$a = parama;
  }
  
  public void setOnDragListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$b = paramb;
  }
  
  public void setOnScaleAnimListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer$c = paramc;
  }
  
  public void stopAnimation()
  {
    if ((this.aR != null) && (this.aR.isRunning())) {
      this.aR.cancel();
    }
  }
  
  public void x(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int j = -1;
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131375043);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    if (localFrameLayout != null)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        localFrameLayout.setLayoutParams(localLayoutParams);
      }
    }
    else {
      return;
    }
    float f2 = paramInt1 / paramInt2;
    if (paramBoolean)
    {
      if ((this.mScreenWidth == 0) || (this.mScreenHeight == 0))
      {
        localFrameLayout.setLayoutParams(localLayoutParams);
        return;
      }
      if (f2 >= this.mScreenWidth / this.mScreenHeight)
      {
        paramInt2 = this.mScreenWidth;
        paramInt1 = (int)(paramInt2 / f2);
      }
      for (;;)
      {
        localLayoutParams.width = paramInt2;
        localLayoutParams.height = paramInt1;
        localFrameLayout.setLayoutParams(localLayoutParams);
        return;
        paramInt1 = this.mScreenHeight;
        paramInt2 = (int)(paramInt1 * f2);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams == null)
    {
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localFrameLayout.setLayoutParams(localLayoutParams);
      return;
    }
    float f1 = 1.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType() == 1)
    {
      f1 = 1.777778F;
      if (Math.abs(f2 - f1) >= 0.1D) {
        break label264;
      }
      paramInt1 = -1;
      paramInt2 = j;
    }
    for (;;)
    {
      localLayoutParams.width = paramInt2;
      localLayoutParams.height = paramInt1;
      localLayoutParams.gravity = 17;
      localFrameLayout.setLayoutParams(localLayoutParams);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getShapeType() != 2) {
        break;
      }
      f1 = 0.5625F;
      break;
      label264:
      if (f2 > f1)
      {
        paramInt1 = (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getWidth() / f2);
        paramInt2 = j;
      }
      else
      {
        paramInt2 = (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenParams.getHeight() * f2);
        paramInt1 = -1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onBackPressed();
  }
  
  public static abstract interface b
  {
    public abstract void bRI();
  }
  
  public static abstract interface c
  {
    public abstract void ejO();
    
    public abstract void ejP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer
 * JD-Core Version:    0.7.0.1
 */