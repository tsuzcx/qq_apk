package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.token.cr;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int g = this.f;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private final Paint m = new Paint();
  private final Rect n = new Rect();
  private int o = 255;
  private boolean p = false;
  private boolean q = false;
  private int r;
  private boolean s;
  private float t;
  private float u;
  private int v;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m.setColor(this.g);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.h = ((int)(3.0F * f + 0.5F));
    this.i = ((int)(6.0F * f + 0.5F));
    this.j = ((int)(64.0F * f));
    this.l = ((int)(16.0F * f + 0.5F));
    this.r = ((int)(1.0F * f + 0.5F));
    this.k = ((int)(f * 32.0F + 0.5F));
    this.v = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.b.setFocusable(true);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() - 1);
      }
    });
    this.d.setFocusable(true);
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() + 1);
      }
    });
    if (getBackground() == null) {
      this.p = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.n;
    int i1 = getHeight();
    int i2 = this.c.getLeft();
    int i3 = this.l;
    int i4 = this.c.getRight();
    int i5 = this.l;
    int i6 = i1 - this.h;
    localRect.set(i2 - i3, i6, i4 + i5, i1);
    super.a(paramInt, paramFloat, paramBoolean);
    this.o = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.c.getLeft() - this.l, i6, this.c.getRight() + this.l, i1);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.p;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.k);
  }
  
  public int getTabIndicatorColor()
  {
    return this.g;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getHeight();
    int i2 = this.c.getLeft();
    int i3 = this.l;
    int i4 = this.c.getRight();
    int i5 = this.l;
    int i6 = this.h;
    this.m.setColor(this.o << 24 | this.g & 0xFFFFFF);
    float f1 = i2 - i3;
    float f2 = i1 - i6;
    float f3 = i4 + i5;
    float f4 = i1;
    paramCanvas.drawRect(f1, f2, f3, f4, this.m);
    if (this.p)
    {
      this.m.setColor(0xFF000000 | this.g & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i1 - this.r, getWidth() - getPaddingRight(), f4, this.m);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 0) && (this.s)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i1)
    {
    default: 
      return true;
    case 2: 
      if ((Math.abs(f1 - this.t) > this.v) || (Math.abs(f2 - this.u) > this.v))
      {
        this.s = true;
        return true;
      }
      break;
    case 1: 
      if (f1 < this.c.getLeft() - this.l)
      {
        this.a.setCurrentItem(this.a.getCurrentItem() - 1);
        return true;
      }
      if (f1 > this.c.getRight() + this.l)
      {
        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
        return true;
      }
      break;
    case 0: 
      this.t = f1;
      this.u = f2;
      this.s = false;
    }
    return true;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.q)
    {
      boolean bool;
      if ((paramInt & 0xFF000000) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.p = bool;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.q)
    {
      boolean bool;
      if (paramDrawable == null) {
        bool = true;
      } else {
        bool = false;
      }
      this.p = bool;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.q)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.p = bool;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.p = paramBoolean;
    this.q = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = this.i;
    int i1 = paramInt4;
    if (paramInt4 < i2) {
      i1 = i2;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i1);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.g = paramInt;
    this.m.setColor(this.g);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(cr.c(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i2 = this.j;
    int i1 = paramInt;
    if (paramInt < i2) {
      i1 = i2;
    }
    super.setTextSpacing(i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */