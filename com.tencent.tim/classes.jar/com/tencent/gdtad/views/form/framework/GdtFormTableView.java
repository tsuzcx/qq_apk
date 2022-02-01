package com.tencent.gdtad.views.form.framework;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;
import java.lang.ref.WeakReference;
import tkw;
import tmb;

public class GdtFormTableView
  extends TableLayout
{
  private AdFormTableData a;
  private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
  
  public GdtFormTableView(Context paramContext, AdFormTableData paramAdFormTableData, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    super(paramContext);
    a(paramContext, paramAdFormTableData, paramWeakReference);
  }
  
  private static Drawable a(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    localGradientDrawable.setStroke(paramInt1, paramInt2);
    localGradientDrawable.setColor(paramInt3);
    return localGradientDrawable;
  }
  
  private void a(Context paramContext, AdFormTableData paramAdFormTableData, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    if ((paramContext == null) || (paramAdFormTableData == null) || (!paramAdFormTableData.isValid()))
    {
      tkw.e("GdtFormTableView", "init error");
      return;
    }
    this.a = paramAdFormTableData;
    setColumnShrinkable(1, true);
    setColumnStretchable(1, true);
    int i = 0;
    while (i < paramAdFormTableData.getSize())
    {
      Object localObject = paramAdFormTableData.getItem(i);
      GdtFormItemTextBoxView localGdtFormItemTextBoxView = null;
      if ((localObject instanceof GdtFormItemTextBoxData)) {
        localGdtFormItemTextBoxView = new GdtFormItemTextBoxView(paramContext, (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject), paramWeakReference);
      }
      if (localGdtFormItemTextBoxView == null)
      {
        tkw.e("GdtFormTableView", "init error");
        i += 1;
      }
      else
      {
        localObject = new TableLayout.LayoutParams(-2, -2);
        if (i == paramAdFormTableData.getSize() - 1) {
          ((TableLayout.LayoutParams)localObject).setMargins(paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth);
        }
        for (;;)
        {
          addView(localGdtFormItemTextBoxView, (ViewGroup.LayoutParams)localObject);
          break;
          ((TableLayout.LayoutParams)localObject).setMargins(paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, 0);
        }
      }
    }
    resetBackground();
  }
  
  private static float[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 0) || (paramInt2 >= paramInt3) || (paramInt3 <= 0)) {
      return null;
    }
    if (paramInt3 == 1) {
      return new float[] { paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1 };
    }
    if (paramInt2 == 0) {
      return new float[] { paramInt1, paramInt1, paramInt1, paramInt1, 0.0F, 0.0F, 0.0F, 0.0F };
    }
    if (paramInt2 == paramInt3 - 1) {
      return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt1, paramInt1, paramInt1 };
    }
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private Drawable l(int paramInt)
  {
    if ((this.a == null) || (!this.a.isValid()) || (this.a.getSize() != getChildCount()))
    {
      tkw.e("GdtFormTableView", "getBackground error");
      localObject1 = null;
    }
    int i;
    Object localObject2;
    label164:
    do
    {
      return localObject1;
      if (paramInt == -1)
      {
        i = this.a.getSize();
        localObject1 = new Drawable[i];
        j = 0;
      }
      for (;;)
      {
        if (j >= this.a.getSize()) {
          break label164;
        }
        localObject2 = this.a.getItem(j);
        if (localObject2 == null)
        {
          tkw.e("GdtFormTableView", "getBackground error");
          return null;
          i = this.a.getSize() + 1;
          break;
        }
        localObject1[j] = a(a(this.a.borderCornerRadius, j, this.a.getSize()), this.a.borderWidth, this.a.borderColor, ((AdFormItemData)localObject2).backgroundColor);
        j += 1;
      }
      if (paramInt != -1)
      {
        localObject2 = this.a.getItem(paramInt);
        if (localObject2 == null)
        {
          tkw.e("GdtFormTableView", "getBackground error");
          return null;
        }
        localObject1[(i - 1)] = a(a(this.a.borderCornerRadius, paramInt, this.a.getSize()), this.a.borderWidth, this.a.borderColorError, ((AdFormItemData)localObject2).backgroundColor);
      }
      localObject2 = new LayerDrawable((Drawable[])localObject1);
      int j = 0;
      while (j < this.a.getSize())
      {
        localObject1 = getChildAt(j);
        if (localObject1 == null)
        {
          tkw.e("GdtFormTableView", "getBackground error");
          return null;
        }
        ((LayerDrawable)localObject2).setLayerInset(j, 0, ((View)localObject1).getTop() - this.a.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.a.borderWidth);
        j += 1;
      }
      localObject1 = localObject2;
    } while (paramInt == -1);
    Object localObject1 = getChildAt(paramInt);
    if (localObject1 == null)
    {
      tkw.e("GdtFormTableView", "getBackground error");
      return null;
    }
    ((LayerDrawable)localObject2).setLayerInset(i - 1, 0, ((View)localObject1).getTop() - this.a.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.a.borderWidth);
    return localObject2;
  }
  
  @TargetApi(16)
  private void resetBackground()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return;
      if ((this.layoutListener != null) && (getViewTreeObserver() != null))
      {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
        this.layoutListener = null;
      }
      this.layoutListener = new tmb(this);
    } while ((this.layoutListener == null) || (getViewTreeObserver() == null));
    getViewTreeObserver().addOnGlobalLayoutListener(this.layoutListener);
  }
  
  public void reset()
  {
    resetBackground();
    if ((this.a == null) || (!this.a.isValid()) || (this.a.getSize() != getChildCount()))
    {
      tkw.e("GdtFormTableView", "reset error");
      return;
    }
    int i = 0;
    label45:
    if (i < getChildCount())
    {
      if ((getChildAt(i) != null) && ((getChildAt(i) instanceof GdtFormItemView))) {
        break label86;
      }
      tkw.e("GdtFormTableView", "reset error");
    }
    for (;;)
    {
      i += 1;
      break label45;
      break;
      label86:
      ((GdtFormItemView)GdtFormItemView.class.cast(getChildAt(i))).reset();
    }
  }
  
  @TargetApi(16)
  public void showError(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(l(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormTableView
 * JD-Core Version:    0.7.0.1
 */