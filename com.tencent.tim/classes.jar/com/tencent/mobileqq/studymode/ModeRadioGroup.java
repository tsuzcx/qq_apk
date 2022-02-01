package com.tencent.mobileqq.studymode;

import ajou;
import ajov;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvu;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wja;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeRadioGroup;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableCheck", "", "oldType", "onCheckChangeListener", "Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "getOnCheckChangeListener", "()Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "setOnCheckChangeListener", "(Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;)V", "cancelLoading", "", "item", "Landroid/view/View;", "cancelLoadingByType", "type", "createItemBackGround", "Landroid/graphics/drawable/Drawable;", "createItemView", "getContentStringByType", "", "kotlin.jvm.PlatformType", "getTitleStringByType", "onThemeChanged", "selectByType", "needCallback", "showLoading", "OnCheckChangeListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ModeRadioGroup
  extends LinearLayout
  implements SkinnableView
{
  @Nullable
  private a a;
  private boolean cKf = true;
  private int dMV = -1;
  
  public ModeRadioGroup(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ModeRadioGroup(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ModeRadioGroup(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    setGravity(16);
    paramContext = ThemeUtil.getCurrentThemeId();
    if ((TextUtils.equals((CharSequence)"1000", (CharSequence)paramContext)) || (TextUtils.equals((CharSequence)"999", (CharSequence)paramContext))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {}
      setBackgroundResource(2130851351);
      Vx(0);
      Vx(1);
      Vx(2);
      return;
    }
  }
  
  private final void Vx(int paramInt)
  {
    Object localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    int i = wja.dp2px(16.0F, ((Context)localObject1).getResources());
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    localObject1 = ((Context)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources");
    int j = (((Resources)localObject1).getDisplayMetrics().widthPixels - i * 4) / 3;
    localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    Object localObject2 = new LinearLayout.LayoutParams(j, wja.dp2px(115.0F, ((Context)localObject1).getResources()));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setTag(Integer.valueOf(paramInt));
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = wja.dp2px(8.0F, ((Context)localObject2).getResources());
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    ((RelativeLayout)localObject1).setPadding(i, wja.dp2px(12.0F, ((Context)localObject2).getResources()), i, i);
    ajov.c((View)localObject1, aQ());
    addView((View)localObject1);
    localObject2 = new TextView(getContext());
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(ajou.c((Resources)localObject3, 2131167304));
    ((TextView)localObject2).setTextSize(1, 16.0F);
    ((TextView)localObject2).setText((CharSequence)fp(paramInt));
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setId(2131367951);
    localObject3 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
    ((TextView)localObject2).setCompoundDrawablePadding(wja.dp2px(5.0F, ((Context)localObject3).getResources()));
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(getContext());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((TextView)localObject2).setTextColor(ajou.c((Resources)localObject3, 2131167381));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    ((TextView)localObject2).setText((CharSequence)fq(paramInt));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131367951);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RelativeLayout.LayoutParams)localObject3).topMargin = wja.dp2px(4.0F, localContext.getResources());
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131367949);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = wja.dp2px(16.0F, ((Context)localObject2).getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject3).setId(2131367950);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    ((RelativeLayout)localObject1).setOnClickListener((View.OnClickListener)new anvu(this, paramInt));
  }
  
  private final Drawable aQ()
  {
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setCornerRadius(wja.dp2px(6.0F, getResources()));
    Object localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((GradientDrawable)localObject1).setColor(ajou.a((Resources)localObject2, 2131167405));
    int i = wja.dp2px(1.5F, getResources());
    localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((GradientDrawable)localObject1).setStroke(i, ajou.a((Resources)localObject2, 2131167407));
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(wja.dp2px(6.0F, getResources()));
    Object localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setColor(ajou.a((Resources)localObject3, 2131167405));
    i = wja.dp2px(1.5F, getResources());
    localObject3 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
    ((GradientDrawable)localObject2).setStroke(i, ajou.a((Resources)localObject3, 2131167406));
    localObject3 = new StateListDrawable();
    localObject1 = (Drawable)localObject1;
    ((StateListDrawable)localObject3).addState(new int[] { 16842913 }, (Drawable)localObject1);
    localObject1 = (Drawable)localObject2;
    ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject1);
    return (Drawable)localObject3;
  }
  
  private final String fp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131694276);
    case 2: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131694281);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131694279);
  }
  
  private final String fq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131694275);
    case 2: 
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      return localContext.getResources().getString(2131694280);
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getString(2131694278);
  }
  
  private final void hK(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "showLoading");
    }
    paramView = (TextView)paramView.findViewById(2131367951);
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
    localObject = ajou.g((Resources)localObject, 2130839622);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = wja.dp2px(20.0F, localContext.getResources());
    ((Drawable)localObject).setBounds(0, 0, i, i);
    paramView.setCompoundDrawables(null, null, (Drawable)localObject, null);
    if ((localObject instanceof Animatable)) {
      ((Animatable)localObject).start();
    }
  }
  
  private final void hL(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "cancelLoading");
    }
    paramView = (TextView)paramView.findViewById(2131367951);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "titleText");
    Drawable localDrawable = paramView.getCompoundDrawables()[2];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    paramView.setCompoundDrawables(null, null, null, null);
  }
  
  public final void Qx(boolean paramBoolean)
  {
    this.cKf = paramBoolean;
  }
  
  public final void Vy(int paramInt)
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "child");
      Object localObject = localView.getTag();
      if (((localObject instanceof Integer)) && (Intrinsics.areEqual(localObject, Integer.valueOf(paramInt)))) {
        hL(localView);
      }
      i += 1;
    }
  }
  
  public void onThemeChanged()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "getChildAt(index)");
      ajov.c(localView, null);
      localView = getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "getChildAt(index)");
      ajov.c(localView, aQ());
      i += 1;
    }
  }
  
  public final void setOnCheckChangeListener(@Nullable a parama)
  {
    this.a = parama;
  }
  
  public final void t(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralModeRadioGroup", 2, "selectByType type : " + paramInt + ", needCallback : " + paramBoolean1 + ", showLoading : " + paramBoolean2);
    }
    int j = getChildCount();
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = getChildAt(i);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131367950);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "child");
      Object localObject2 = ((View)localObject1).getTag();
      if (((localObject2 instanceof Integer)) && (Intrinsics.areEqual(localObject2, Integer.valueOf(paramInt))))
      {
        if (paramBoolean2) {
          hK((View)localObject1);
        }
        localImageView.setImageResource(2130839620);
        ((View)localObject1).setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setImageResource(2130839621);
        ((View)localObject1).setSelected(false);
        hL((View)localObject1);
      }
    }
    if (paramBoolean1)
    {
      localObject1 = this.a;
      if (localObject1 != null) {
        ((a)localObject1).fc(paramInt, this.dMV);
      }
    }
    this.dMV = paramInt;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeRadioGroup$OnCheckChangeListener;", "", "onModeCheckedChanged", "", "curType", "", "oldType", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface a
  {
    public abstract void fc(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup
 * JD-Core Version:    0.7.0.1
 */