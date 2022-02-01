package dov.com.qq.im.story.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import aqnm;
import axjd;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import rpq;
import wja;

public class AnimationQIMCircleProgress
  extends QIMCircleProgress
{
  private float Fx = 1.0F;
  private boolean JS;
  private RectF a;
  Paint dh;
  private boolean dyB;
  private boolean dyC;
  private boolean dyD = true;
  private axjd e;
  private int eJO;
  private int eJP;
  private int eJQ;
  private int eJR;
  
  public AnimationQIMCircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationQIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void Yp(boolean paramBoolean)
  {
    this.dyB = paramBoolean;
    if (this.dyB)
    {
      setBackgroundResource(2130838016);
      setCenterCircleColor(getResources().getColor(2131166534));
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(2130845324);
      setCenterCircleColor(-1);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull axjd paramaxjd)
  {
    this.dyC = paramBoolean;
    this.e = paramaxjd;
    if (this.dyC)
    {
      setBackgroundResource(this.e.eFq);
      setCenterCircleColor(0);
      setProgressOffset(wja.dp2px(1.8F, getResources()));
      setProgressColor(this.e.eFr);
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(2130845324);
      setCenterCircleColor(-1);
    }
  }
  
  public void aea(int paramInt)
  {
    if ((this.dyC) && (this.e != null)) {
      setBackgroundResource(this.e.eFq);
    }
    for (;;)
    {
      super.aea(paramInt);
      return;
      if (this.dyB) {
        setBackgroundResource(2130838016);
      } else if ((paramInt != 1) && (this.JS)) {
        setBackgroundDrawable(null);
      } else {
        setBackgroundResource(2130845324);
      }
    }
  }
  
  public void bZ(Canvas paramCanvas)
  {
    if (!this.dyD) {
      return;
    }
    if (!this.JS)
    {
      if (this.mMode == 3)
      {
        cd(paramCanvas);
        return;
      }
      ce(paramCanvas);
      return;
    }
    if (this.mMode == 1)
    {
      ce(paramCanvas);
      return;
    }
    if (this.mMode == 3) {
      cd(paramCanvas);
    }
    cf(paramCanvas);
  }
  
  protected void cd(Canvas paramCanvas)
  {
    int i = (getWidth() - this.eJQ) / 2;
    int j = (getHeight() - this.eJQ) / 2;
    this.a.set(i, j, i + this.eJQ, j + this.eJQ);
    paramCanvas.drawRoundRect(this.a, this.eJR, this.eJR, this.dc);
  }
  
  protected void ce(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.eJP * this.Fm, this.dc);
  }
  
  protected void cf(Canvas paramCanvas)
  {
    int i = rpq.dip2px(getContext(), 3.0F);
    Color.parseColor("#33000000");
    float f1 = this.mWidth / 2;
    float f2 = this.mWidth / 2;
    float f3 = this.mWidth / 2 - i / 2;
    this.dh.setStyle(Paint.Style.STROKE);
    this.dh.setStrokeWidth(i);
    this.dh.setColor(-1);
    paramCanvas.drawCircle(f1, f2, f3, this.dh);
  }
  
  public void init()
  {
    super.init();
    this.dh = new Paint();
    this.dh.setAntiAlias(true);
    this.dc.setStyle(Paint.Style.FILL);
    setBackgroundResource(2130845324);
    this.eJQ = aqnm.dip2px(30.0F);
    this.eJR = aqnm.dip2px(6.0F);
    this.a = new RectF();
  }
  
  public void setCenterView()
  {
    super.setCenterView();
    this.eJO = aqnm.dip2px(3.0F);
    this.eJP = (aqnm.dip2px(53.0F) / 2);
  }
  
  public void setDrawCenterCircle(boolean paramBoolean)
  {
    if (this.dyD != paramBoolean)
    {
      this.dyD = paramBoolean;
      invalidate();
    }
  }
  
  public void setIldeStyle(boolean paramBoolean)
  {
    this.JS = paramBoolean;
    if (this.JS) {
      setBackgroundDrawable(null);
    }
    for (;;)
    {
      invalidate();
      return;
      setBackgroundResource(2130845324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.story.view.AnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */