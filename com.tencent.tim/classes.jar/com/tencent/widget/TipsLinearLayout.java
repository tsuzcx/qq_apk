package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class TipsLinearLayout
  extends LinearLayout
{
  private a a;
  private long azd;
  private boolean bvA = true;
  private boolean dlc;
  private int euP;
  private int euQ = 0;
  
  public TipsLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public TipsLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void abn(int paramInt)
  {
    this.dlc = true;
    this.bvA = true;
    this.euQ = paramInt;
    invalidate();
  }
  
  private void akX()
  {
    if (this.a == null) {
      return;
    }
    if (this.euQ == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsLinearLayout", 2, "ANIM_IN end.");
      }
      this.a.exx();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "ANIM_OUT end.");
    }
    this.a.exy();
  }
  
  private int at(long paramLong)
  {
    float f2 = getMeasuredHeight();
    float f3 = f2 / 300.0F * (float)paramLong;
    float f1 = f3;
    if (f3 > f2) {
      f1 = f2;
    }
    switch (this.euQ)
    {
    default: 
      f1 = 0.0F;
    }
    for (;;)
    {
      return (int)f1;
      f1 = 0.0F;
      continue;
      f1 -= f2;
      continue;
      f1 = -f1;
    }
  }
  
  public void atK()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startInAnimation");
    }
    abn(1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "Draw....");
    }
    if ((this.dlc) && (this.bvA))
    {
      this.azd = SystemClock.uptimeMillis();
      this.bvA = false;
    }
    long l = SystemClock.uptimeMillis() - this.azd;
    if ((this.dlc) && (!this.bvA) && (l >= 300L))
    {
      this.dlc = false;
      this.bvA = true;
      akX();
    }
    if ((this.dlc) && (!this.bvA)) {
      this.euP = at(l);
    }
    for (;;)
    {
      int i = paramCanvas.save();
      paramCanvas.translate(0.0F, this.euP);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      if (!this.bvA) {
        invalidate();
      }
      return;
      if (this.euQ == 2) {
        this.euP = (0 - getMeasuredHeight());
      } else {
        this.euP = 0;
      }
    }
  }
  
  public void exw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsLinearLayout", 2, "startOutAnimation");
    }
    abn(2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setmTipsLayoutAnimListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void exx();
    
    public abstract void exy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.TipsLinearLayout
 * JD-Core Version:    0.7.0.1
 */