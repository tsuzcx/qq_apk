package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.utils.ImageCache;

public class SwitchButton
  extends CheckBox
{
  private static ImageCache g;
  private a A;
  private CompoundButton.OnCheckedChangeListener B = null;
  private CompoundButton.OnCheckedChangeListener C = null;
  private boolean D;
  private final float E = 350.0F;
  private float F;
  private final float G = 15.0F;
  private float H;
  private float I;
  private float J;
  private Paint a;
  private ViewParent b;
  private Bitmap c;
  private Bitmap d;
  private Bitmap e;
  private Bitmap f;
  private RectF h;
  private PorterDuffXfermode i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private int t;
  private int u;
  private final int v = 255;
  private int w = 255;
  private boolean x = false;
  private boolean y;
  private boolean z;
  
  public SwitchButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842860);
  }
  
  public SwitchButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(float paramFloat)
  {
    return paramFloat - this.r / 2.0F;
  }
  
  private void a()
  {
    this.b = getParent();
    ViewParent localViewParent = this.b;
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void a(Context paramContext)
  {
    this.a = new Paint();
    this.a.setColor(-1);
    Resources localResources = paramContext.getResources();
    this.t = (ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout());
    this.u = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = g;
    if (paramContext == null)
    {
      g = new ImageCache("", 10, getContext());
    }
    else
    {
      this.c = paramContext.a("key_switch_button_bottom");
      this.e = g.a("key_switch_button_normal");
      this.f = g.a("key_switch_button_mask");
    }
    if (this.c == null)
    {
      this.c = BitmapFactory.decodeResource(localResources, 2131100149);
      g.b("key_switch_button_bottom", this.c);
    }
    if (this.e == null)
    {
      this.e = BitmapFactory.decodeResource(localResources, 2131100150);
      g.b("key_switch_button_normal", this.e);
    }
    if (this.f == null)
    {
      this.f = BitmapFactory.decodeResource(localResources, 2131100151);
      g.b("key_switch_button_mask", this.f);
    }
    paramContext = this.e;
    this.d = paramContext;
    this.r = paramContext.getWidth();
    this.p = this.f.getWidth();
    this.q = this.f.getHeight();
    float f1 = this.r;
    this.o = (f1 / 2.0F);
    this.n = (this.p - f1 / 2.0F);
    if (this.x) {
      f1 = this.n;
    } else {
      f1 = this.o;
    }
    this.m = f1;
    this.l = a(this.m);
    f1 = getResources().getDisplayMetrics().density;
    this.F = ((int)(350.0F * f1 + 0.5F));
    this.H = ((int)(f1 * 15.0F + 0.5F));
    this.h = new RectF(0.0F, this.H, this.f.getWidth(), this.f.getHeight() + this.H);
    this.i = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
  }
  
  private void a(boolean paramBoolean)
  {
    this.D = true;
    float f1;
    if (paramBoolean) {
      f1 = -this.F;
    } else {
      f1 = this.F;
    }
    this.J = f1;
    this.I = this.m;
    new b(null).run();
  }
  
  private void b()
  {
    this.D = false;
  }
  
  private void b(float paramFloat)
  {
    this.m = paramFloat;
    this.l = a(this.m);
    invalidate();
  }
  
  private void c()
  {
    this.I += this.J * 16.0F / 1000.0F;
    float f1 = this.I;
    if (f1 <= this.n)
    {
      b();
      this.I = this.n;
      setCheckedDelayed(true);
    }
    else if (f1 >= this.o)
    {
      b();
      this.I = this.o;
      setCheckedDelayed(false);
    }
    b(this.I);
  }
  
  private void setCheckedDelayed(final boolean paramBoolean)
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        SwitchButton.this.a(paramBoolean, true);
      }
    }, 10L);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.x != paramBoolean1)
    {
      this.x = paramBoolean1;
      float f1;
      if (paramBoolean1) {
        f1 = this.n;
      } else {
        f1 = this.o;
      }
      this.m = f1;
      this.l = a(this.m);
      invalidate();
      if (this.y) {
        return;
      }
      this.y = true;
      if (paramBoolean2)
      {
        CompoundButton.OnCheckedChangeListener localOnCheckedChangeListener = this.B;
        if (localOnCheckedChangeListener != null) {
          localOnCheckedChangeListener.onCheckedChanged(this, this.x);
        }
        localOnCheckedChangeListener = this.C;
        if (localOnCheckedChangeListener != null) {
          localOnCheckedChangeListener.onCheckedChanged(this, this.x);
        }
      }
      this.y = false;
    }
  }
  
  public CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener()
  {
    return this.B;
  }
  
  public boolean isChecked()
  {
    return this.x;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayerAlpha(this.h, this.w, 31);
    this.a.setAntiAlias(true);
    paramCanvas.drawBitmap(this.f, 0.0F, this.H, this.a);
    this.a.setXfermode(this.i);
    paramCanvas.drawBitmap(this.c, this.l, this.H, this.a);
    this.a.setXfermode(null);
    paramCanvas.drawBitmap(this.d, this.l, this.H, this.a);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension((int)this.p, (int)(this.q + this.H * 2.0F));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1 = Math.abs(f3 - this.k);
    float f2 = Math.abs(f4 - this.j);
    boolean bool = true;
    switch (i1)
    {
    default: 
      break;
    case 2: 
      this.m = (this.s + paramMotionEvent.getX() - this.k);
      f1 = this.m;
      f2 = this.o;
      if (f1 >= f2) {
        this.m = f2;
      }
      f1 = this.m;
      f2 = this.n;
      if (f1 <= f2) {
        this.m = f2;
      }
      f1 = this.m;
      f2 = this.o;
      f3 = this.n;
      if (f1 <= (f2 - f3) / 2.0F + f3) {
        bool = false;
      }
      this.z = bool;
      this.l = a(this.m);
      break;
    case 1: 
      this.d = this.e;
      f3 = (float)(paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime());
      i1 = this.u;
      if ((f2 < i1) && (f1 < i1) && (f3 < this.t))
      {
        if (this.A == null) {
          this.A = new a(null);
        }
        if (!post(this.A)) {
          performClick();
        }
      }
      else
      {
        a(this.z ^ true);
      }
      break;
    case 0: 
      a();
      this.k = f3;
      this.j = f4;
      this.d = this.e;
      if (this.x) {
        f1 = this.n;
      } else {
        f1 = this.o;
      }
      this.s = f1;
    }
    invalidate();
    return isEnabled();
  }
  
  public boolean performClick()
  {
    a(this.x ^ true);
    return true;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 255;
    } else {
      i1 = 127;
    }
    this.w = i1;
    super.setEnabled(paramBoolean);
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.B = paramOnCheckedChangeListener;
  }
  
  void setOnCheckedChangeWidgetListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.C = paramOnCheckedChangeListener;
  }
  
  public void toggle()
  {
    setChecked(this.x ^ true);
  }
  
  private final class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      SwitchButton.this.performClick();
    }
  }
  
  private final class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      if (!SwitchButton.a(SwitchButton.this)) {
        return;
      }
      SwitchButton.b(SwitchButton.this);
      c.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.SwitchButton
 * JD-Core Version:    0.7.0.1
 */