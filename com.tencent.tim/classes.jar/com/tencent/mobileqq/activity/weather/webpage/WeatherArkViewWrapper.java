package com.tencent.mobileqq.activity.weather.webpage;

import abcx;
import abdd;
import abdf;
import adqr;
import adta;
import ajos;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wja;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleRes", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "arkHeight", "getArkHeight", "()I", "setArkHeight", "(I)V", "arkView", "Lcom/tencent/ark/open/ArkView;", "getArkView", "()Lcom/tencent/ark/open/ArkView;", "downInArk", "", "hasMakeUpForTheLossDownEvent", "hasMove", "mSlideStartDir", "", "mStartTime", "", "mStartX", "", "mStartY", "scaledTouchSlop", "getScaledTouchSlop", "scaledTouchSlop$delegate", "Lkotlin/Lazy;", "topPadding", "getTopPadding", "topPadding$delegate", "touchEventData", "Landroid/arch/lifecycle/MutableLiveData;", "Landroid/view/MotionEvent;", "getTouchEventData", "()Landroid/arch/lifecycle/MutableLiveData;", "viewModel", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "createLoadFailView", "Landroid/view/View;", "dispatchTouchEvent", "event", "initArkView", "", "appName", "", "appView", "appVersion", "appMeta", "initViewModel", "store", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "makeUpForLossDownEvent", "isForArk", "onLoadFailed", "onLoadSuccess", "onLoading", "swipeDirectionJudge", "curX", "curY", "touchInArk", "y", "translateYToArkY", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherArkViewWrapper
  extends FrameLayout
{
  public static final a a;
  @NotNull
  private final MutableLiveData<MotionEvent> B = new MutableLiveData();
  private abdf jdField_a_of_type_Abdf;
  @NotNull
  private final ArkView jdField_a_of_type_ComTencentArkOpenArkView;
  private byte aY;
  private boolean bBR;
  private boolean bBS;
  private int cnJ;
  private final Lazy d = LazyKt.lazy((Function0)new WeatherArkViewWrapper.topPadding.2(this));
  private final Lazy e = LazyKt.lazy((Function0)new WeatherArkViewWrapper.scaledTouchSlop.2(this));
  private long mStartTime;
  private float mStartX;
  private float mStartY;
  private boolean vZ;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper$a = new a(null);
    adta.GI(true);
    adta.cUm();
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentArkOpenArkView = new ArkView(paramContext, null);
    paramContext = getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources");
    paramContext = new ArkAppInfo.Size(paramContext.getDisplayMetrics().widthPixels, -1);
    this.jdField_a_of_type_ComTencentArkOpenArkView.setSize(paramContext, paramContext, paramContext);
    addView((View)this.jdField_a_of_type_ComTencentArkOpenArkView);
    setArkHeight(wja.dp2px(481, getResources()));
  }
  
  private final void Ds(boolean paramBoolean)
  {
    MotionEvent localMotionEvent;
    if (!this.bBS)
    {
      this.bBS = true;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebArkWrapper", 2, "dispatchMissingDownEvent isForArk: " + paramBoolean);
      }
      localMotionEvent = MotionEvent.obtain(this.mStartTime, this.mStartTime, 0, this.mStartX, this.mStartY, 0);
      if (!paramBoolean) {
        break label80;
      }
      super.dispatchTouchEvent(localMotionEvent);
    }
    for (;;)
    {
      localMotionEvent.recycle();
      return;
      label80:
      MutableLiveData localMutableLiveData = this.B;
      if (localMotionEvent != null) {
        localMutableLiveData.setValue(localMotionEvent);
      }
    }
  }
  
  private final void L(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Math.abs(paramFloat1 - this.mStartX);
    paramFloat2 = Math.abs(paramFloat2 - this.mStartY);
    if ((paramFloat1 > getScaledTouchSlop()) || (paramFloat2 > getScaledTouchSlop())) {
      if (paramFloat2 <= paramFloat1) {
        break label109;
      }
    }
    label109:
    for (byte b = 2;; b = 1)
    {
      this.aY = b;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebArkWrapper", 2, "swipeDirectionJudge: absDx -> " + paramFloat1 + ", absDy -> " + paramFloat2 + ", mSlideStartDir -> " + this.aY);
      }
      return;
    }
  }
  
  private final View bM()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, this.cnJ);
    ((FrameLayout.LayoutParams)localObject).gravity = 1;
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(2131382149);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.setBackgroundColor(-1);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageResource(2130839729);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    int j = wja.dp2px(170.0F, getResources()) - getTopPadding();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    localLayoutParams.topMargin = i;
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(2131721825);
    ((TextView)localObject).setTextSize(1, 15.0F);
    ((TextView)localObject).setTextColor(-16777216);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = wja.dp2px(20.0F, getResources());
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    return (View)localLinearLayout;
  }
  
  private final void brU()
  {
    Object localObject = this.jdField_a_of_type_Abdf;
    if (localObject != null) {
      ((abdf)localObject).GV(-1);
    }
    setArkHeight(wja.dp2px(481, getResources()));
    localObject = findViewById(2131382149);
    if (localObject == null) {
      localObject = bM();
    }
    for (;;)
    {
      addView((View)localObject);
      abcx.a().E(null, "new_ark_callup_fail");
      return;
      if ((((View)localObject).getParent() instanceof ViewGroup))
      {
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)localViewParent).removeView((View)localObject);
      }
    }
  }
  
  private final int getScaledTouchSlop()
  {
    return ((Number)this.e.getValue()).intValue();
  }
  
  private final int getTopPadding()
  {
    return ((Number)this.d.getValue()).intValue();
  }
  
  private final boolean i(float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    float f = w(paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkWrapper", 2, "touchInArk: locationX -> " + arrayOfInt[0] + ", locationY -> " + arrayOfInt[1] + ", scrollY => " + getScrollY() + ", eventY -> " + paramFloat + ", arkHeight-> " + this.cnJ);
    }
    return (f >= arrayOfInt[1]) && (f <= arrayOfInt[1] + this.cnJ);
  }
  
  private final void onLoadSuccess()
  {
    Object localObject = this.jdField_a_of_type_Abdf;
    if (localObject != null) {
      ((abdf)localObject).GV(1);
    }
    localObject = this.jdField_a_of_type_ComTencentArkOpenArkView.mViewImpl;
    if (localObject != null)
    {
      localObject = ((ArkViewImplement)localObject).getViewModel();
      if (localObject == null) {}
    }
    for (localObject = ((ArkViewModel)localObject).getContainerRect();; localObject = null)
    {
      if (localObject != null)
      {
        float f = adqr.getDensity();
        setArkHeight((int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f));
      }
      abcx.a().E(null, "new_ark_callup_success");
      return;
    }
  }
  
  private final void onLoading()
  {
    abdf localabdf = this.jdField_a_of_type_Abdf;
    if (localabdf != null) {
      localabdf.GV(0);
    }
  }
  
  private final float w(float paramFloat)
  {
    float f = getScrollY();
    if (this.cnJ > 0) {}
    for (int i = getTopPadding();; i = 0) {
      return paramFloat + f - i;
    }
  }
  
  @NotNull
  public final ArkView a()
  {
    return this.jdField_a_of_type_ComTencentArkOpenArkView;
  }
  
  public final void a(@NotNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    Intrinsics.checkParameterIsNotNull(paramViewModelStoreOwner, "store");
    this.jdField_a_of_type_Abdf = ((abdf)ajos.a(paramViewModelStoreOwner).get(abdf.class));
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      if (localObject != null) {
        break label66;
      }
      label25:
      if (localObject != null) {
        break label161;
      }
      label30:
      if (localObject != null) {
        break label318;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        i = j;
        label42:
        boolean bool1 = bool2;
        if (i != 0) {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
        label66:
        do
        {
          return bool1;
          localObject = null;
          break;
          if (((Integer)localObject).intValue() != 0) {
            break label25;
          }
          this.bBR = i(paramMotionEvent.getY());
          this.vZ = false;
          this.bBS = false;
          this.mStartX = paramMotionEvent.getX();
          this.mStartY = paramMotionEvent.getY();
          this.mStartTime = SystemClock.uptimeMillis();
          i = j;
          if (!QLog.isColorLevel()) {
            break label42;
          }
          QLog.d("WeatherWebArkWrapper", 2, "onTouchEvent ACTION_DOWN  downInArk: " + this.bBR);
          i = j;
          break label42;
          if (((Integer)localObject).intValue() != 2) {
            break label30;
          }
          if (this.aY == 0) {
            L(paramMotionEvent.getX(), paramMotionEvent.getY());
          }
          bool1 = bool2;
        } while (this.aY == 0);
        label161:
        this.vZ = true;
        getParent().requestDisallowInterceptTouchEvent(true);
        if ((this.bBR) && (this.aY == 1)) {
          Ds(true);
        }
        for (j = 1;; j = i)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WeatherWebArkWrapper", 2, "onTouchEvent ACTION_MOVE mSlideStartDir: " + this.aY + ", downInArk: " + this.bBR);
          i = j;
          break;
          Ds(false);
          localObject = this.B;
          if (paramMotionEvent != null) {
            ((MutableLiveData)localObject).setValue(paramMotionEvent);
          }
        }
        label318:
        if (((Integer)localObject).intValue() == 1)
        {
          label327:
          if ((!this.bBR) || ((this.vZ) && (this.aY != 1))) {
            break label464;
          }
          Ds(true);
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebArkWrapper", 2, "onTouchEvent ACTION_UP mSlideStartDir: " + this.aY + ", downInArk: " + this.bBR + ", hasMove:" + this.vZ);
      }
      this.mStartX = 0.0F;
      this.mStartY = 0.0F;
      this.mStartTime = 0L;
      this.aY = 0;
      this.bBR = false;
      this.bBS = false;
      break;
      i = j;
      if (((Integer)localObject).intValue() != 3) {
        break;
      }
      break label327;
      label464:
      Ds(false);
      localObject = this.B;
      if (paramMotionEvent != null) {
        ((MutableLiveData)localObject).setValue(paramMotionEvent);
      }
    }
  }
  
  public final void setArkHeight(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkWrapper", 2, "arkHeight set value : " + paramInt);
    }
    if (paramInt > 0) {}
    for (int i = getTopPadding();; i = 0)
    {
      setPadding(0, i, 0, 0);
      this.cnJ = paramInt;
      return;
    }
  }
  
  @NotNull
  public final MutableLiveData<MotionEvent> u()
  {
    return this.B;
  }
  
  public final void y(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appName");
    Intrinsics.checkParameterIsNotNull(paramString2, "appView");
    Intrinsics.checkParameterIsNotNull(paramString3, "appVersion");
    Intrinsics.checkParameterIsNotNull(paramString4, "appMeta");
    String str = adqr.sQ();
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkWrapper", 2, "initArkView appName: " + paramString1 + ", appView: " + paramString2 + ", appVersion: " + paramString3 + ", appMeta: " + paramString4 + ", appConfig: " + str);
    }
    this.jdField_a_of_type_ComTencentArkOpenArkView.load(paramString1, paramString2, paramString3, paramString4, str, (ArkViewImplement.LoadCallback)new abdd(this));
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper$Companion;", "", "()V", "SLIDE_DIR_HORIZONTAL", "", "SLIDE_DIR_NONE", "SLIDE_DIR_VERTICAL", "TAG", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherArkViewWrapper
 * JD-Core Version:    0.7.0.1
 */