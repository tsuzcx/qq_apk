package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import arft;
import com.tencent.mobileqq.theme.ThemeUtil;

public class FormItemRelativeLayout
  extends RelativeLayout
{
  static boolean daf = true;
  int mBgType = 0;
  private final Paint mPaint = new Paint();
  private final Rect mRect = new Rect();
  
  public FormItemRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormItemRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(arft.COLOR_DEFAULT_BG_DIVIDER);
    setBackgroundDrawable(d(getResources(), this.mBgType));
  }
  
  public static Drawable c(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (daf) {
        return paramResources.getDrawable(2130839682);
      }
      return paramResources.getDrawable(2130851351);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839682);
    case 0: 
      if (daf) {
        return paramResources.getDrawable(2130839682);
      }
      return paramResources.getDrawable(2130851351);
    case 1: 
      if (daf) {
        return paramResources.getDrawable(2130839695);
      }
      return paramResources.getDrawable(2130851365);
    case 2: 
      if (daf) {
        return paramResources.getDrawable(2130839695);
      }
      return paramResources.getDrawable(2130851365);
    }
    if (daf) {
      return paramResources.getDrawable(2130839689);
    }
    return paramResources.getDrawable(2130851356);
  }
  
  private boolean isDefTheme()
  {
    return ("1000".equals(ThemeUtil.curThemeId)) || ("999".equals(ThemeUtil.curThemeId));
  }
  
  protected Drawable d(Resources paramResources, int paramInt)
  {
    return c(paramResources, paramInt, isDefTheme());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mBgType == 1) || (this.mBgType == 2))
    {
      if (!isDefTheme()) {
        break label73;
      }
      this.mPaint.setColor(arft.COLOR_DEFAULT_BG_DIVIDER);
    }
    for (;;)
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.mRect.set(arft.PADDING_DEFAULT_BG_DIVIDER, j - arft.HEIGHT_DEFAULT_BG_DIVIDER, i, j);
      paramCanvas.drawRect(this.mRect, this.mPaint);
      return;
      label73:
      this.mPaint.setColor(0);
    }
  }
  
  public void setBGType(int paramInt)
  {
    this.mBgType = paramInt;
    setBackgroundDrawable(d(getResources(), this.mBgType));
  }
  
  public void setNeedFocusBg(boolean paramBoolean)
  {
    daf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormItemRelativeLayout
 * JD-Core Version:    0.7.0.1
 */