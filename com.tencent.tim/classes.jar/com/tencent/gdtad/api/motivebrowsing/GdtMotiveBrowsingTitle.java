package com.tencent.gdtad.api.motivebrowsing;

import ajov;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tib;
import wja;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "countDownContainer", "Landroid/widget/LinearLayout;", "imgClose", "Landroid/view/View;", "tvBrowsing", "Landroid/widget/TextView;", "createBackGround", "Landroid/graphics/drawable/Drawable;", "createBrowsingString", "", "kotlin.jvm.PlatformType", "second", "createCloseIcon", "", "createCountDownContainer", "initViewWithLeftSecond", "setOnCloseClickListener", "onClick", "Lkotlin/Function0;", "Companion", "GdtMotiveBrowsingCenterFixWidthSpan", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingTitle
  extends RelativeLayout
{
  public static final a a = new a(null);
  private TextView Bk;
  private LinearLayout fD;
  private View qP;
  
  public GdtMotiveBrowsingTitle(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtMotiveBrowsingTitle(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GdtMotiveBrowsingTitle(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ImmersiveUtils.setStatusTextColor(true, ((Activity)paramContext).getWindow());
    int i = wja.dp2px(63.0F, getResources());
    paramInt = i;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int j = ImmersiveUtils.getStatusBarHeight(paramContext);
      paramInt = i + j;
      i = wja.dp2px(15.0F, getResources());
      setPadding(i, j + i, i, i);
    }
    setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, paramInt));
    setBackgroundColor(-1);
    bDc();
    bDd();
  }
  
  private final Drawable aw()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(wja.dp2px(18.0F, getResources()));
    localGradientDrawable.setStroke(wja.dp2px(1.0F, getResources()), Color.parseColor("#E5E5E5"));
    return (Drawable)localGradientDrawable;
  }
  
  private final void bDc()
  {
    int i = wja.dp2px(16.0F, getResources());
    Object localObject1 = new RelativeLayout.LayoutParams(-2, wja.dp2px(33.0F, getResources()));
    this.fD = new LinearLayout(getContext());
    Object localObject2 = this.fD;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ajov.c((View)localObject2, aw());
    localObject2 = this.fD;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setPadding(i, 0, i, 0);
    localObject2 = this.fD;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setOrientation(0);
    localObject2 = this.fD;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setGravity(16);
    localObject2 = this.fD;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setText((CharSequence)getResources().getString(2131694267));
    ((TextView)localObject1).setId(2131367915);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setTextSize(1, 14.0F);
    localObject2 = this.fD;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).addView((View)localObject1);
    localObject1 = new View(getContext());
    i = wja.dp2px(1.0F, getResources());
    int j = wja.dp2px(20.0F, getResources());
    int k = wja.dp2px(10.0F, getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, j);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = k;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = k;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((View)localObject1).setBackgroundColor(Color.parseColor("#E5E5E5"));
    localObject2 = this.fD;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).addView((View)localObject1);
    this.Bk = new TextView(getContext());
    localObject1 = this.Bk;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject1).setId(2131367914);
    localObject1 = this.Bk;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject1).setTextColor(-16777216);
    localObject1 = this.Bk;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject1).setTextSize(1, 14.0F);
    localObject1 = this.fD;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    localObject2 = this.Bk;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject1 = this.fD;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject1).setVisibility(8);
    localObject1 = this.fD;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    addView((View)localObject1);
  }
  
  private final void bDd()
  {
    int i = wja.dp2px(33.0F, getResources());
    Object localObject1 = new RelativeLayout.LayoutParams(i, i);
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    this.qP = ((View)new GdtMotiveBrowsingImage((Context)localObject2));
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    localObject2 = this.qP;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("imgClose");
    }
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.qP;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("imgClose");
    }
    addView((View)localObject1);
  }
  
  private final CharSequence c(int paramInt)
  {
    if (paramInt > 0)
    {
      b localb = new b(wja.dp2px(23.0F, getResources()));
      String str = String.valueOf(paramInt);
      SpannableString localSpannableString = new SpannableString((CharSequence)getResources().getString(2131694264, new Object[] { str }));
      localSpannableString.setSpan(localb, 2, str.length() + 2, 17);
      return (CharSequence)localSpannableString;
    }
    return (CharSequence)getResources().getString(2131694266);
  }
  
  public final void setOnCloseClickListener(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "onClick");
    View localView = this.qP;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("imgClose");
    }
    localView.setOnClickListener((View.OnClickListener)new tib(paramFunction0));
  }
  
  public final void zs(int paramInt)
  {
    Object localObject = this.fD;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject).setVisibility(0);
    localObject = this.Bk;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.Bk;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject).setText(c(paramInt));
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle$Companion;", "", "()V", "CLOSE_IMAGE_HEIGHT", "", "COUNT_DOWN_CORNER", "COUNT_DOWN_DIVIDER_HORIZONTAL_MARGIN", "COUNT_DOWN_HEIGHT", "COUNT_DOWN_HORIZONTAL_PADDING", "COUNT_DOWN_STROKE", "COUNT_DOWN_STROKE_COLOR_NORMAL", "", "COUNT_DOWN_TEXT_SIZE", "TITLE_HEIGHT", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle$GdtMotiveBrowsingCenterFixWidthSpan;", "Landroid/text/style/ReplacementSpan;", "fixWidth", "", "(I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class b
    extends ReplacementSpan
  {
    private final int bBw;
    
    public b(int paramInt)
    {
      this.bBw = paramInt;
    }
    
    public void draw(@NotNull Canvas paramCanvas, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
    {
      Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
      Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        float f = paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
        f = Math.max(0.0F, (this.bBw - f) / 2);
        if (paramCharSequence == null) {
          Intrinsics.throwNpe();
        }
        paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + f, paramInt4, paramPaint);
      }
    }
    
    public int getSize(@NotNull Paint paramPaint, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
    {
      Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
      return this.bBw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingTitle
 * JD-Core Version:    0.7.0.1
 */