package com.tencent.gdtad.api.motivevideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class GdtMvAppBtnView
  extends TextView
{
  private boolean aPh;
  public boolean aPi;
  private RectF ab = new RectF();
  private Drawable dv;
  protected Paint mBluePaint;
  protected int mMaxProgress = 100;
  protected float mProgress;
  
  public GdtMvAppBtnView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void vt(boolean paramBoolean)
  {
    this.aPh = paramBoolean;
  }
  
  public void bnv()
  {
    Drawable localDrawable = null;
    int i = 0;
    if (this.aPh) {
      if (this.aPi)
      {
        localDrawable = getResources().getDrawable(2130840591);
        this.dv = getResources().getDrawable(2130840590);
      }
    }
    while (this.aPi)
    {
      setBackgroundDrawable(localDrawable);
      return;
      i = getResources().getColor(2131165580);
      continue;
      if (this.aPi) {
        localDrawable = getResources().getDrawable(2130840590);
      } else {
        i = getResources().getColor(2131165588);
      }
    }
    setBackgroundColor(i);
  }
  
  public float getProgress()
  {
    return this.mProgress;
  }
  
  public void init(String paramString)
  {
    try
    {
      int i = Color.parseColor("#00CAFC");
      setSingleLine(false);
      setLines(1);
      setText(paramString);
      resetUI();
      this.mBluePaint = new Paint();
      this.mBluePaint.setStrokeWidth(1.0F);
      this.mBluePaint.setColor(i);
      this.mBluePaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mBluePaint.setAntiAlias(true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.aPh)
    {
      float f = getWidth() / this.mMaxProgress * this.mProgress;
      this.ab.set(0.0F, 0.0F, f, getHeight());
      if (this.aPi)
      {
        int i = paramCanvas.save();
        if ((paramCanvas.clipRect(0.0F, 0.0F, f, getHeight())) && (this.dv != null))
        {
          this.dv.setBounds(0, 0, getWidth(), getHeight());
          this.dv.draw(paramCanvas);
        }
        paramCanvas.restoreToCount(i);
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      paramCanvas.drawRect(this.ab, this.mBluePaint);
      continue;
      if (!this.aPi) {}
    }
  }
  
  public void resetUI()
  {
    vt(false);
    bnv();
  }
  
  public void setDownloadingUI(String paramString)
  {
    vt(true);
    bnv();
    setText(paramString);
  }
  
  public void setProgress(int paramInt)
  {
    this.mProgress = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvAppBtnView
 * JD-Core Version:    0.7.0.1
 */