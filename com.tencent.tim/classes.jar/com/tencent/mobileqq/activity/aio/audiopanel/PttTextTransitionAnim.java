package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import ankt;
import com.tencent.qphone.base.util.QLog;

public class PttTextTransitionAnim
  extends ImageView
{
  String aTQ;
  String aTR;
  int bQA = 0;
  int bQB = 0;
  int bQC = -1;
  int bQy;
  int bQz = 255;
  int centerX;
  int centerY;
  private Context mContext;
  float pQ;
  float pR;
  float pS;
  float pT;
  float pU;
  private Paint paint;
  float progress;
  
  public PttTextTransitionAnim(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PttTextTransitionAnim(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PttTextTransitionAnim(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setColor(getResources().getColor(2131167293));
    this.paint.setTextSize(ankt.dip2px(16.0F));
    this.bQz = 255;
    this.bQA = 0;
    this.pS = 0.0F;
    this.pT = 0.0F;
    this.pU = 0.0F;
    this.aTQ = this.mContext.getString(2131690221);
    this.aTR = this.mContext.getString(2131700597);
    this.pQ = this.paint.measureText(this.aTQ);
    this.pR = this.paint.measureText(this.aTR);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.aTQ == null) || (this.aTR == null)) {
      return;
    }
    paramCanvas.save();
    this.paint.setAlpha(this.bQA);
    paramCanvas.drawText(this.aTQ, this.centerX + this.pT - this.pQ / 2.0F, this.centerY, this.paint);
    this.paint.setAlpha(this.bQB);
    paramCanvas.drawText(this.aTR, this.centerX + this.pU - this.pR / 2.0F, this.centerY, this.paint);
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.centerX = ((paramInt3 - paramInt1) / 2);
    this.centerY = ((paramInt4 - paramInt2) / 2);
    this.bQy = ((int)(this.centerX * 0.8D));
    if (QLog.isColorLevel()) {
      QLog.d("PttTextTransitionAnim", 2, "onLayout " + toString());
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.bQC = paramInt;
    if (paramInt == 0)
    {
      this.progress = 0.5F;
      setProgress(this.progress);
      return;
    }
    this.progress = 1.0F;
    setProgress(this.progress);
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat <= 0.5F)
    {
      this.bQz = ((int)((0.5F - paramFloat) * 255.0F) * 2);
      this.bQA = ((int)(255.0F * paramFloat) * 2);
      this.bQB = 0;
      this.pS = (-this.bQy * paramFloat * 2.0F);
      this.pT = (this.bQy * (0.5F - paramFloat) * 2.0F);
    }
    for (;;)
    {
      invalidate();
      return;
      this.bQz = 0;
      this.bQA = ((int)((1.0F - paramFloat) * 255.0F * 2.0F));
      this.bQB = ((int)((paramFloat - 0.5F) * 255.0F * 2.0F));
      this.pT = (-this.bQy * (paramFloat - 0.5F) * 2.0F);
      this.pU = (this.bQy * (1.0F - paramFloat) * 2.0F);
    }
  }
  
  public void setScrollDis(float paramFloat, int paramInt)
  {
    setProgress(paramFloat / paramInt / 2.0F + this.progress);
  }
  
  public String toString()
  {
    return "PttTextTransitionAnim{ progress=" + this.progress + ", alphaVoiceChange=" + this.bQz + ", alphaPressToSpeak=" + this.bQA + ", alphaRecord=" + this.bQB + ", tranlateXVoiceChange=" + this.pS + ", tranlateXPressToSpeak=" + this.pT + ", tranlateXRecord=" + this.pU + ", centerX=" + this.centerX + ", centerY=" + this.centerY + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PttTextTransitionAnim
 * JD-Core Version:    0.7.0.1
 */