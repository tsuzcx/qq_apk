package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class TabThemeMaskView
  extends ImageView
{
  RectF an = new RectF();
  private int caO = ThemeUtil.NIGHTMODE_MASKCOLOR;
  Paint mMaskPaint;
  
  public TabThemeMaskView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TabThemeMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TabThemeMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId));
  }
  
  protected void init()
  {
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (isNightMode())
    {
      this.an.set(0.0F, 0.0F, getWidth(), getHeight());
      super.onDraw(paramCanvas);
      this.mMaskPaint.setColorFilter(null);
      this.mMaskPaint.setColor(this.caO);
      paramCanvas.drawRect(this.an, this.mMaskPaint);
      return;
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.TabThemeMaskView
 * JD-Core Version:    0.7.0.1
 */