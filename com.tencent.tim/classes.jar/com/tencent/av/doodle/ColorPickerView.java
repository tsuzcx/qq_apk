package com.tencent.av.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import imp;
import imt;

public class ColorPickerView
  extends View
{
  private boolean Sz;
  private Paint ao;
  private Drawable bW;
  private Drawable bX;
  private Drawable bY;
  private Drawable bZ;
  private Drawable ca;
  private Drawable cb;
  private float fZ;
  private float ga;
  private float gb;
  private float gc;
  private float gd;
  private float ge;
  private float gf;
  private float gg;
  private float gh = -1.0F;
  private int mColor = -65536;
  private float mStrokeWidth;
  private int mType = 1;
  
  public ColorPickerView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setId(2131373963);
    paramContext = paramContext.getResources();
    this.fZ = paramContext.getDimension(2131298081);
    this.ga = paramContext.getDimension(2131298080);
    this.gb = paramContext.getDimension(2131298078);
    this.gc = paramContext.getDimension(2131298079);
    this.mStrokeWidth = paramContext.getDimension(2131298084);
    this.gd = paramContext.getDimension(2131298082);
    this.ge = paramContext.getDimension(2131298085);
    this.gf = paramContext.getDimension(2131298083);
    this.gg = paramContext.getDimension(2131298086);
    this.bW = paramContext.getDrawable(2130842931);
    this.bX = paramContext.getDrawable(2130842932);
    this.bY = paramContext.getDrawable(2130842933);
    this.bZ = paramContext.getDrawable(2130842934);
    this.cb = paramContext.getDrawable(2130842936);
    this.ca = paramContext.getDrawable(2130842935);
    this.ao = new Paint(1);
    this.ao.setStyle(Paint.Style.FILL);
    this.bY.setColorFilter(this.mColor, PorterDuff.Mode.SRC_ATOP);
    this.ca.setBounds((int)(this.ge - this.mStrokeWidth / 2.0F), (int)(this.ga / 2.0F), (int)(this.ge + this.mStrokeWidth / 2.0F), (int)(this.ga / 2.0F + this.gd));
    this.cb.setBounds((int)(this.ge - this.mStrokeWidth / 2.0F), (int)(this.ga / 2.0F + this.gd + this.gf), (int)(this.ge + this.mStrokeWidth / 2.0F), (int)(this.ga / 2.0F + this.gd + this.gf + this.mStrokeWidth));
    paramContext = imp.a();
    this.mColor = paramContext.mColor;
    this.mType = paramContext.apU;
    this.gh = paramContext.gh;
    this.ao.setColor(this.mColor);
  }
  
  public void aoh()
  {
    float f = this.ga / 2.0F;
    f = this.gd;
    f = this.gf / 2.0F;
    f = (this.gh - this.ga / 2.0F) / this.gd;
    Bitmap localBitmap = ((BitmapDrawable)this.ca).getBitmap();
    int i = imt.clamp((int)(localBitmap.getHeight() * f), 0, localBitmap.getHeight() - 1);
    this.mColor = ((BitmapDrawable)this.ca).getBitmap().getPixel(localBitmap.getWidth() / 2, i);
    this.bY.setColorFilter(this.mColor, PorterDuff.Mode.SRC_ATOP);
    this.ao.setColor(this.mColor);
    this.mType = 1;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getHeight();
    this.ca.draw(paramCanvas);
    float f = imt.clamp(this.gh, this.ga / 2.0F, this.ga / 2.0F + this.gd);
    Drawable localDrawable2;
    Drawable localDrawable1;
    switch (this.mType)
    {
    case 2: 
    default: 
      localDrawable2 = this.bW;
      localDrawable1 = this.bY;
    }
    for (;;)
    {
      localDrawable2.setBounds((int)(this.ge - this.gb / 2.0F), (int)(f - this.gb / 2.0F), (int)(this.ge + this.gb / 2.0F), (int)(this.gb / 2.0F + f));
      localDrawable2.draw(paramCanvas);
      if (this.mType == 1) {
        paramCanvas.drawCircle(this.ge, f, this.gc, this.ao);
      }
      if (this.Sz)
      {
        localDrawable1.setBounds(0, (int)(f - this.ga / 2.0F), (int)this.fZ, (int)(f + this.ga / 2.0F));
        localDrawable1.draw(paramCanvas);
      }
      return;
      localDrawable2 = this.bW;
      localDrawable1 = this.bY;
      continue;
      localDrawable2 = this.bX;
      localDrawable1 = this.bZ;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = this.ge - this.gb / 2.0F;
    boolean bool;
    if ((f1 > f3) && (f1 < f3 + this.gg)) {
      bool = true;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return bool;
        bool = false;
        break;
        this.Sz = bool;
        if (bool)
        {
          this.gh = f2;
          aoh();
          return bool;
        }
      } while (!this.Sz);
      this.gh = f2;
      aoh();
      return bool;
    }
    if (this.Sz)
    {
      this.gh = f2;
      aoh();
      paramMotionEvent = (DoodleSurfaceView)((View)getParent()).findViewById(2131373974);
      if (paramMotionEvent != null) {
        paramMotionEvent.setColor(this.mColor, this.mType, this.gh);
      }
    }
    this.Sz = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.doodle.ColorPickerView
 * JD-Core Version:    0.7.0.1
 */