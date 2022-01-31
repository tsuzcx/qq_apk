package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class PhotoBoard
  extends View
  implements Handler.Callback
{
  public static final float a = 1.2F;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  protected static final int h = 3;
  protected static final int i = 0;
  public Handler a;
  protected boolean a;
  protected TCTransitDrawable[] a;
  protected float b;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q = 0;
  
  public PhotoBoard(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable = null;
    c();
  }
  
  public PhotoBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable = null;
    c();
  }
  
  public PhotoBoard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable = null;
    c();
  }
  
  private void c()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.b = localDisplayMetrics.density;
    this.j = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    this.k = getResources().getDimensionPixelSize(2131427495);
    if (this.k <= 0) {
      this.k = ((int)(130.0F * this.b));
    }
    this.l = ((int)(2.0F * this.b));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable = new TCTransitDrawable[3];
    int i1 = 0;
    while (i1 < 3)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[i1] = new TCTransitDrawable(getContext());
      i1 += 1;
    }
    this.q = 0;
    this.jdField_a_of_type_AndroidOsHandler = new PhotoBoard.PhotoBoardHandler(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    int i1 = 0;
    while (i1 < 3)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[i1].b();
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[paramInt].a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    TCTransitDrawable localTCTransitDrawable = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[0];
    paramCanvas.clipRect(0, 0, this.o, this.p);
    localTCTransitDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
    i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(this.o + this.l, 0.0F);
    localTCTransitDrawable = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[1];
    paramCanvas.clipRect(0, 0, this.m, this.n);
    localTCTransitDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
    i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(this.o + this.l, this.n + this.l);
    localTCTransitDrawable = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[2];
    paramCanvas.clipRect(0, 0, this.m, this.n);
    localTCTransitDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
  }
  
  public void a(Drawable paramDrawable, int paramInt)
  {
    switch (this.q)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {
        invalidate();
      }
      return;
      paramInt = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[0].a(paramDrawable, this.j, this.k, 1, this) | false;
      continue;
      if (paramInt == 0)
      {
        paramInt = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[0].a(paramDrawable, this.o, this.p, 0, this) | false;
      }
      else if (paramInt == 1)
      {
        paramInt = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[1].a(paramDrawable, this.m, this.n, 0, this) | false;
      }
      else
      {
        if (paramInt != 2) {
          break;
        }
        paramInt = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[2].a(paramDrawable, this.m, this.n, 0, this) | false;
        continue;
        paramInt = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[0].a(paramDrawable, this.j, this.k, 1.2F, this) | false;
        continue;
        paramInt = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[0].a(paramDrawable, this.j, this.k, 0, this) | false;
      }
    }
  }
  
  public void b()
  {
    int i1 = 0;
    this.jdField_a_of_type_Boolean = false;
    while (i1 < 3)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[i1].c();
      i1 += 1;
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    int i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    TCTransitDrawable localTCTransitDrawable = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[0];
    paramCanvas.clipRect(0, 0, this.o, this.p);
    localTCTransitDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
    i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.p + this.l);
    localTCTransitDrawable = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[1];
    paramCanvas.clipRect(0, 0, this.m, this.n);
    localTCTransitDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
    i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(this.m + this.l, this.p + this.l);
    localTCTransitDrawable = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[2];
    paramCanvas.clipRect(0, 0, this.m, this.n);
    localTCTransitDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
      postInvalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.q)
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 6: 
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[0].draw(paramCanvas);
      return;
    case 4: 
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void setPhotoBoardStyle(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 6) && (this.q != paramInt))
    {
      this.q = paramInt;
      int i1 = 0;
      while (i1 < 3)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetTCTransitDrawable[i1].a();
        i1 += 1;
      }
      if (paramInt != 4) {
        break label105;
      }
      this.n = ((this.k - this.l) / 2);
      this.m = this.n;
      this.p = this.k;
      this.o = (this.j - this.m - this.l);
    }
    for (;;)
    {
      postInvalidate();
      return;
      label105:
      if (paramInt == 5)
      {
        this.m = ((this.j - this.l) / 2);
        this.n = ((this.k - this.l) / 2);
        this.o = this.j;
        this.p = (this.k - this.n - this.l);
      }
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoBoard
 * JD-Core Version:    0.7.0.1
 */