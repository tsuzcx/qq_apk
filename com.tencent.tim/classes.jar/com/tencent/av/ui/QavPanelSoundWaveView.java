package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.AudioHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jde;

public class QavPanelSoundWaveView
  extends View
{
  boolean VZ = false;
  boolean XK = false;
  boolean XL = false;
  List<jde> fA;
  float hN;
  float hO;
  float hP = 0.0F;
  Handler mHandler = new Handler(Looper.getMainLooper());
  Runnable mRunnable = new QavPanelSoundWaveView.1(this);
  
  public QavPanelSoundWaveView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QavPanelSoundWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QavPanelSoundWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  void atX()
  {
    this.mHandler.postDelayed(this.mRunnable, 20L);
    invalidate();
  }
  
  void atY()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    this.hP = 0.0F;
    Iterator localIterator = this.fA.iterator();
    while (localIterator.hasNext()) {
      ((jde)localIterator.next()).aun();
    }
    invalidate();
  }
  
  void aum()
  {
    this.hN = getWidth();
    this.hO = getHeight();
    this.fA.clear();
    float f;
    PointF localPointF;
    Paint localPaint;
    if (!this.XK)
    {
      f = 1.5F;
      localPointF = new PointF(0.0F, this.hO / 2.0F);
      localPaint = new Paint();
      if (!this.VZ) {
        break label281;
      }
      localPaint.setColor(Color.parseColor("#b3ffffff"));
      label76:
      localPaint.setStrokeWidth(2.0F);
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.STROKE);
      this.fA.add(new jde(0, this.hN, this.hO, f, localPaint, localPointF, this.XK));
      localPaint = new Paint();
      if (!this.VZ) {
        break label293;
      }
      localPaint.setColor(Color.parseColor("#66ffffff"));
      label150:
      localPaint.setStrokeWidth(2.0F);
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.STROKE);
      this.fA.add(new jde(1, this.hN, this.hO, f, localPaint, localPointF, this.XK));
      localPaint = new Paint();
      if (!this.VZ) {
        break label305;
      }
      localPaint.setColor(Color.parseColor("#26ffffff"));
    }
    for (;;)
    {
      localPaint.setStrokeWidth(2.0F);
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.STROKE);
      this.fA.add(new jde(2, this.hN, this.hO, f, localPaint, localPointF, this.XK));
      return;
      f = 8.0F;
      break;
      label281:
      localPaint.setColor(Color.parseColor("#b312b7f5"));
      break label76;
      label293:
      localPaint.setColor(Color.parseColor("#6612b7f5"));
      break label150;
      label305:
      localPaint.setColor(Color.parseColor("#2612b7f5"));
    }
  }
  
  public void destory()
  {
    atY();
    this.mHandler = null;
    this.mRunnable = null;
    if (this.fA != null)
    {
      this.fA.clear();
      this.fA = null;
    }
  }
  
  void init()
  {
    boolean bool = true;
    this.fA = new ArrayList();
    if (AudioHelper.jY(0) == 1) {}
    for (;;)
    {
      this.XL = bool;
      return;
      bool = false;
    }
  }
  
  public void ke(boolean paramBoolean)
  {
    this.VZ = paramBoolean;
    if ((this.fA == null) || (this.fA.size() != 3)) {}
    do
    {
      do
      {
        return;
        if (!this.VZ) {
          break;
        }
        if ((this.fA.get(0) != null) && (((jde)this.fA.get(0)).getPaint() != null)) {
          ((jde)this.fA.get(0)).getPaint().setColor(Color.parseColor("#b3ffffff"));
        }
        if ((this.fA.get(1) != null) && (((jde)this.fA.get(1)).getPaint() != null)) {
          ((jde)this.fA.get(1)).getPaint().setColor(Color.parseColor("#66ffffff"));
        }
      } while ((this.fA.get(2) == null) || (((jde)this.fA.get(2)).getPaint() == null));
      ((jde)this.fA.get(2)).getPaint().setColor(Color.parseColor("#26ffffff"));
      return;
      if ((this.fA.get(0) != null) && (((jde)this.fA.get(0)).getPaint() != null)) {
        ((jde)this.fA.get(0)).getPaint().setColor(Color.parseColor("#b312b7f5"));
      }
      if ((this.fA.get(1) != null) && (((jde)this.fA.get(1)).getPaint() != null)) {
        ((jde)this.fA.get(1)).getPaint().setColor(Color.parseColor("#6612b7f5"));
      }
    } while ((this.fA.get(2) == null) || (((jde)this.fA.get(2)).getPaint() == null));
    ((jde)this.fA.get(2)).getPaint().setColor(Color.parseColor("#2612b7f5"));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.hN != getWidth()) || (this.hO != getHeight())) {
      aum();
    }
    if (this.XL)
    {
      localObject = new Paint();
      ((Paint)localObject).setColor(-268780356);
      paramCanvas.drawRect(0.0F, 0.0F, this.hN, this.hO, (Paint)localObject);
    }
    Object localObject = this.fA.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((jde)((Iterator)localObject).next()).R(paramCanvas);
    }
  }
  
  public void setRoundStyle(boolean paramBoolean)
  {
    this.XK = paramBoolean;
  }
  
  public void startAnim()
  {
    atX();
  }
  
  public void stopAnim()
  {
    atY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelSoundWaveView
 * JD-Core Version:    0.7.0.1
 */