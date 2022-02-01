package com.tencent.gdtad.api.motivebrowsing;

import ajou;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wja;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingImage;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "circleDrawable", "Landroid/graphics/drawable/GradientDrawable;", "closeDrawable", "Landroid/graphics/drawable/Drawable;", "translate", "", "getTranslate", "()I", "translate$delegate", "Lkotlin/Lazy;", "getCircleDrawable", "getImageDrawable", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingImage
  extends View
{
  private final Lazy b = LazyKt.lazy((Function0)new GdtMotiveBrowsingImage.translate.2(this));
  private Drawable du;
  private GradientDrawable e;
  
  public GdtMotiveBrowsingImage(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final Drawable av()
  {
    if (this.e == null)
    {
      this.e = new GradientDrawable();
      localGradientDrawable = this.e;
      if (localGradientDrawable == null) {
        Intrinsics.throwNpe();
      }
      localGradientDrawable.setStroke(wja.dp2px(1.0F, getResources()), Color.parseColor("#E5E5E5"));
      localGradientDrawable.setCornerRadius(wja.dp2px(18.0F, getResources()));
      int i = wja.dp2px(33.0F, getResources());
      localGradientDrawable.setBounds(0, 0, i, i);
    }
    GradientDrawable localGradientDrawable = this.e;
    if (localGradientDrawable == null) {
      Intrinsics.throwNpe();
    }
    return (Drawable)localGradientDrawable;
  }
  
  private final Drawable b()
  {
    if (this.du == null)
    {
      localObject = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "resources");
      this.du = ajou.g((Resources)localObject, 2130840586);
      int i = wja.dp2px(18.0F, getResources());
      localObject = this.du;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
    }
    Object localObject = this.du;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return localObject;
  }
  
  private final int uU()
  {
    return ((Number)this.b.getValue()).intValue();
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      av().draw(paramCanvas);
      paramCanvas.save();
      paramCanvas.translate(uU(), uU());
      b().draw(paramCanvas);
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingImage
 * JD-Core Version:    0.7.0.1
 */