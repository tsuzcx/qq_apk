package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ThemeURLImageView
  extends URLImageView
{
  public static String cAA = "1000";
  boolean cbQ = true;
  Paint mPaint;
  
  public ThemeURLImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ThemeURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ThemeURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  public static void setCurThemeId(String paramString)
  {
    cAA = paramString;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.cbQ) && (ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)))
    {
      paramCanvas.saveLayer(null, this.mPaint, 31);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.cbQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ThemeURLImageView
 * JD-Core Version:    0.7.0.1
 */