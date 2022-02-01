package com.tencent.av.smallscreen;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import anot;
import aqmj;
import com.tencent.qphone.base.util.QLog;
import igd;
import ivv;

public class SmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  boolean Vw = false;
  boolean Vx = false;
  a jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a;
  b jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$b = null;
  final int aum;
  int aun;
  int auo;
  final int aup;
  final int auq;
  final int aur;
  int aus = -1;
  int aut = -1;
  int auu = -1;
  int auv = -1;
  int auw = -1;
  int aux = -1;
  int auy = 6;
  Display mDisplay;
  boolean mIsInit = true;
  boolean mIsShow = false;
  int mPosition = 7;
  int mRotation = 0;
  int mScreenHeight = 0;
  int mScreenWidth = 0;
  int mTitleHeight;
  final int mTouchSlop;
  ValueAnimator v;
  ValueAnimator w;
  
  public SmallScreenRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "SmallScreenRelativeLayout");
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.aup = getResources().getDimensionPixelSize(2131298325);
    this.auq = getResources().getDimensionPixelSize(2131298326);
    this.aum = getResources().getDimensionPixelSize(2131298333);
    this.mTitleHeight = getResources().getDimensionPixelSize(2131299627);
    this.aur = getResources().getDimensionPixelSize(2131298321);
    this.v = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.v.setDuration(200L);
    this.v.addListener(this);
    this.v.addUpdateListener(this);
    this.w = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.w.setDuration(400L);
    this.w.addListener(this);
    this.v.addUpdateListener(this);
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.mRotation = lG();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$b = new b(getContext(), 2);
  }
  
  private int lG()
  {
    try
    {
      int i = this.mDisplay.getRotation();
      return i;
    }
    catch (Exception localException)
    {
      igd.aL("SmallScreenRelativeLayout", localException.getMessage());
    }
    return 0;
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 1;
    int i;
    label31:
    SharedPreferences.Editor localEditor;
    if ((paramInt1 < paramInt2) && (paramInt3 > paramInt4))
    {
      i = 1;
      if ((paramInt1 <= paramInt2) || (paramInt3 >= paramInt4)) {
        break label94;
      }
      paramInt2 = j;
      if (i == 0)
      {
        paramInt1 = paramInt5;
        if (paramInt2 == 0) {}
      }
      else
      {
        SharedPreferences localSharedPreferences = aqmj.j(getContext());
        localEditor = localSharedPreferences.edit();
        if (i == 0) {
          break label99;
        }
        paramInt1 = localSharedPreferences.getInt("small_window_position_land", 12);
      }
    }
    for (;;)
    {
      localEditor.commit();
      return paramInt1;
      i = 0;
      break;
      label94:
      paramInt2 = 0;
      break label31;
      label99:
      paramInt1 = paramInt5;
      if (paramInt2 != 0)
      {
        localEditor.putInt("small_window_position_land", paramInt5);
        paramInt1 = 7;
      }
    }
  }
  
  public Point a(int paramInt)
  {
    Rect localRect = n();
    Point localPoint = new Point();
    switch (paramInt)
    {
    default: 
      return localPoint;
    case 0: 
      localPoint.x = localRect.centerX();
      localPoint.y = localRect.centerY();
      return localPoint;
    case 1: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.top;
      return localPoint;
    case 2: 
      localPoint.x = localRect.left;
      localPoint.y = (localRect.top + this.mTitleHeight);
      return localPoint;
    case 3: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 4: 
      localPoint.x = localRect.left;
      localPoint.y = (localRect.bottom - this.aur);
      return localPoint;
    case 5: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.bottom;
      return localPoint;
    case 6: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.top;
      return localPoint;
    case 7: 
      localPoint.x = localRect.right;
      localPoint.y = (localRect.top + this.mTitleHeight);
      return localPoint;
    case 8: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 9: 
      localPoint.x = localRect.right;
      localPoint.y = (localRect.bottom - this.aur);
      return localPoint;
    case 10: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.bottom;
      return localPoint;
    case 11: 
      localPoint.x = (localRect.centerX() / 2);
      localPoint.y = localRect.top;
      return localPoint;
    case 12: 
      localPoint.x = localRect.centerX();
      localPoint.y = localRect.top;
      return localPoint;
    }
    localPoint.x = (localRect.centerX() * 3 / 2);
    localPoint.y = localRect.top;
    return localPoint;
  }
  
  public void ard()
  {
    int k = lG();
    Rect localRect = new Rect();
    try
    {
      getWindowVisibleDisplayFrame(localRect);
      boolean bool = ivv.hasSmartBar();
      int m = localRect.width();
      int j = localRect.height();
      i = j;
      if (bool) {
        i = j - this.aum;
      }
      j = this.mRotation;
      this.mPosition = a(this.mScreenWidth, this.mScreenHeight, m, i, this.mPosition);
      if ((this.mRotation != k) || (m != this.mScreenWidth) || ((k == 0) && (this.mScreenHeight < i)) || ((k != 0) && (this.mScreenHeight != i)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenRelativeLayout", 1, "onOrientationChangedInner, mPosition[" + j + "->" + this.mPosition + "], mRotation[" + this.mRotation + "->" + k + "], mScreenWidth[" + this.mScreenWidth + "->" + m + "], mScreenHeight[" + this.mScreenHeight + "->" + i + "], mIsInit[" + this.mIsInit + "]");
        }
        if ((this.mIsInit) && (k != 0)) {
          this.mIsInit = false;
        }
        this.v.cancel();
        this.mRotation = k;
        this.mScreenWidth = m;
        this.mScreenHeight = i;
        setCurPosition(this.mPosition);
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a == null) {
          break label386;
        }
        i = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
        this.auw = i;
        this.aus = i;
        i = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.b(this);
        this.aux = i;
        this.aut = i;
        if (!this.mIsInit) {
          this.v.start();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("SmallScreenRelativeLayout", 2, "Can not getWindowVisibleDisplayFrame");
          continue;
          label386:
          i = getLeft();
          this.auw = i;
          this.aus = i;
          i = getTop();
          this.aux = i;
          this.aut = i;
        }
      }
    }
  }
  
  void bR(int paramInt1, int paramInt2)
  {
    paramInt1 = this.aus + paramInt1 - this.auu;
    int k = this.aut + paramInt2 - this.auv;
    int i;
    int j;
    int m;
    if ((this.mRotation % 2 == 0) || (!this.Vw))
    {
      i = this.aun;
      paramInt2 = this.auo;
      j = this.mScreenWidth - i;
      m = this.mScreenHeight - paramInt2;
      if (paramInt1 >= 0) {
        break label166;
      }
      paramInt1 = 0;
    }
    label166:
    for (;;)
    {
      if (paramInt1 > j) {}
      for (;;)
      {
        if (k < 0) {}
        for (paramInt1 = 0;; paramInt1 = k)
        {
          if (paramInt1 > m) {
            paramInt1 = m;
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a != null)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this, j, paramInt1, i + j, paramInt1 + paramInt2);
              return;
              i = this.auo;
              paramInt2 = this.aun;
              break;
            }
            layout(j, paramInt1, j + i, paramInt2 + paramInt1);
            return;
          }
        }
        j = paramInt1;
      }
    }
  }
  
  int d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = 2147483647;
    int i = 0;
    paramInt1 = 1;
    if (paramInt1 < 14)
    {
      Point localPoint = a(paramInt1);
      int j = localPoint.x;
      int k = localPoint.x;
      int m = localPoint.y;
      j = (paramInt4 - localPoint.y) * (paramInt4 - m) + (paramInt3 - j) * (paramInt3 - k);
      if (j >= paramInt2) {
        break label91;
      }
      i = paramInt1;
      paramInt2 = j;
    }
    label91:
    for (;;)
    {
      paramInt1 += 1;
      break;
      return i;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.v.cancel();
        this.auu = i;
        this.auv = j;
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a != null) {
          this.aus = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
        }
        for (this.aut = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.b(this);; this.aut = getTop())
        {
          this.Vx = false;
          return true;
          this.aus = getLeft();
        }
        if (this.Vx)
        {
          bR(i, j);
          return true;
        }
      } while ((Math.abs(i - this.auu) <= this.mTouchSlop) && (Math.abs(j - this.auv) <= this.mTouchSlop));
      this.Vx = true;
      return true;
    case 1: 
      if (this.Vx)
      {
        bR(i, j);
        label195:
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a == null) {
          break label266;
        }
        this.auw = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
      }
      for (this.aux = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.b(this); !bool; this.aux = getTop())
      {
        this.v.start();
        return true;
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a == null) {
          break label195;
        }
        bool = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
        break label195;
        label266:
        this.auw = getLeft();
      }
    }
    if (this.Vx) {
      bR(i, j);
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a != null) {
      this.auw = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
    }
    for (this.aux = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.b(this);; this.aux = getTop())
    {
      this.v.start();
      return true;
      this.auw = getLeft();
    }
  }
  
  public boolean getIsShow()
  {
    return this.mIsShow;
  }
  
  public void hide()
  {
    jh(false);
  }
  
  void jh(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenRelativeLayout", 2, "startShowHideAnimation mIsShow = " + this.mIsShow);
      QLog.d("SmallScreenRelativeLayout", 2, "startShowHideAnimation isShow = " + paramBoolean);
    }
    this.mIsShow = paramBoolean;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a != null)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
      }
      return;
    }
  }
  
  public int lH()
  {
    int j;
    if ((this.mScreenWidth != 0) && (this.mScreenHeight != 0))
    {
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a == null) {
        break label60;
      }
      j = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
    }
    for (int i = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.b(this);; i = getTop())
    {
      this.mPosition = d(j, i, j, i);
      return this.mPosition;
      label60:
      j = getLeft();
    }
  }
  
  Rect n()
  {
    int k;
    int i;
    label20:
    int j;
    label29:
    Rect localRect;
    int m;
    if (lG() % 2 == 0)
    {
      k = 1;
      if (k == 0) {
        break label121;
      }
      i = this.aup;
      if (k == 0) {
        break label129;
      }
      j = this.auq;
      localRect = new Rect();
      localRect.left = i;
      localRect.top = j;
      if ((k == 0) && (this.Vw)) {
        break label137;
      }
      m = this.aun;
      k = this.auo;
      label72:
      if ((this.mScreenWidth == 0) || (this.mScreenHeight == 0)) {
        break label151;
      }
      localRect.right = (this.mScreenWidth - m - i);
      localRect.bottom = (this.mScreenHeight - k - j);
    }
    label121:
    do
    {
      return localRect;
      k = 0;
      break;
      i = this.auq;
      break label20;
      j = this.aup;
      break label29;
      m = this.auo;
      k = this.aun;
      break label72;
      try
      {
        localRect.right = (this.mDisplay.getWidth() - m - i);
        localRect.bottom = (this.mDisplay.getHeight() - k - j);
        return localRect;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    label129:
    label137:
    label151:
    QLog.e("SmallScreenRelativeLayout", 2, "getPositionRect e = " + localException);
    return localRect;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Point localPoint;
    int i;
    int j;
    if (paramAnimator == this.v)
    {
      localPoint = a(this.auy);
      switch (this.auy)
      {
      default: 
        paramAnimator = null;
        if ((this.mRotation % 2 == 0) || (!this.Vw))
        {
          i = this.aun;
          j = this.auo;
          label92:
          if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a == null) {
            break label221;
          }
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this, localPoint.x, localPoint.y, i + localPoint.x, localPoint.y + j);
          label133:
          this.mIsInit = false;
          this.mPosition = this.auy;
          if (paramAnimator != null) {
            anot.a(null, "CliOper", "", "", paramAnimator, paramAnimator, 0, 0, "", "", "", "");
          }
        }
        break;
      }
    }
    label221:
    do
    {
      do
      {
        return;
        paramAnimator = "0X80057E1";
        break;
        paramAnimator = "0X80057E3";
        break;
        paramAnimator = "0X80057E2";
        break;
        paramAnimator = "0X80057E4";
        break;
        i = this.auo;
        j = this.aun;
        break label92;
        layout(localPoint.x, localPoint.y, localPoint.x + i, j + localPoint.y);
        break label133;
      } while ((paramAnimator != this.w) || (this.mIsShow));
      setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
      }
    } while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a == null);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.v) {
      this.auy = d(this.aus, this.aut, this.auw, this.aux);
    }
    do
    {
      do
      {
        return;
      } while ((paramAnimator != this.w) || (!this.mIsShow));
      setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("SmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (paramValueAnimator == this.v)
    {
      paramValueAnimator = a(this.auy);
      k = (int)(this.auw + (paramValueAnimator.x - this.auw) * f1);
      f2 = this.aux;
      m = (int)(f1 * (paramValueAnimator.y - this.aux) + f2);
      if ((this.mRotation % 2 == 0) || (!this.Vw))
      {
        i = this.aun;
        j = this.auo;
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a == null) {
          break label147;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this, k, m, i + k, m + j);
      }
    }
    label147:
    while ((paramValueAnimator != this.w) || (this.mIsShow))
    {
      int k;
      int m;
      int i;
      int j;
      for (;;)
      {
        float f2;
        return;
        i = this.auo;
        j = this.aun;
      }
      layout(k, m, k + i, j + m);
      return;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    ard();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "onCreate");
    }
    this.mIsInit = true;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$b.enable();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$b.disable();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mScreenWidth == 0) || (this.mScreenHeight == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.mScreenWidth = localRect.width();
      if (this.mScreenHeight < localRect.height()) {
        this.mScreenHeight = localRect.height();
      }
      setCurPosition(this.mPosition);
    }
  }
  
  public void setCurPosition(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenRelativeLayout", 2, "setCurPosition position = " + paramInt);
      QLog.d("SmallScreenRelativeLayout", 2, "setCurPosition mScreenWidth = " + this.mScreenWidth);
      QLog.d("SmallScreenRelativeLayout", 2, "setCurPosition mScreenHeight = " + this.mScreenHeight);
    }
    this.mPosition = paramInt;
    Point localPoint;
    if ((this.mScreenWidth != 0) && (this.mScreenHeight != 0))
    {
      localPoint = a(paramInt);
      if ((this.mRotation % 2 != 0) && (this.Vw)) {
        break label179;
      }
      paramInt = this.aun;
    }
    for (int i = this.auo; this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a != null; i = this.aun)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this, localPoint.x, localPoint.y, paramInt + localPoint.x, localPoint.y + i);
      return;
      label179:
      paramInt = this.auo;
    }
    layout(localPoint.x, localPoint.y, localPoint.x + paramInt, i + localPoint.y);
  }
  
  public void setFloatListener(a parama)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a = parama;
  }
  
  public void setIsRotateSize(boolean paramBoolean)
  {
    this.Vw = paramBoolean;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.aun = paramInt1;
    this.auo = paramInt2;
  }
  
  public void setTitleHeight(int paramInt)
  {
    this.mTitleHeight = paramInt;
  }
  
  public void show()
  {
    jh(true);
  }
  
  public void updateLayout()
  {
    Point localPoint;
    int i;
    if ((this.mScreenWidth != 0) && (this.mScreenHeight != 0))
    {
      localPoint = a(this.mPosition);
      if ((this.mRotation % 2 != 0) && (this.Vw)) {
        break label87;
      }
      i = this.aun;
    }
    for (int j = this.auo; this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a != null; j = this.aun)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$a.a(this, localPoint.x, localPoint.y, i + localPoint.x, localPoint.y + j);
      return;
      label87:
      i = this.auo;
    }
    layout(localPoint.x, localPoint.y, localPoint.x + i, j + localPoint.y);
  }
  
  public static abstract interface a
  {
    public abstract int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout);
    
    public abstract void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout);
    
    public abstract void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout);
    
    public abstract int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout);
  }
  
  class b
    extends OrientationEventListener
  {
    public b(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void onOrientationChanged(int paramInt)
    {
      SmallScreenRelativeLayout.this.ard();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */