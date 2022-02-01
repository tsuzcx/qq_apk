package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.RelativeLayout;
import wja;

public class FlashPicBubbleView
  extends RelativeLayout
{
  private boolean akU;
  private boolean bXh;
  private Context mContext;
  private boolean mIsSend;
  
  public FlashPicBubbleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlashPicBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    this.mContext = paramContext;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt)) {}
    for (this.akU = true;; this.akU = false)
    {
      invalidate();
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = getResources();
    Drawable localDrawable1 = ((Resources)localObject).getDrawable(2130848114);
    Drawable localDrawable2 = ((Resources)localObject).getDrawable(2130848115);
    localDrawable1.setBounds(0, 0, getWidth(), wja.dp2px(95.0F, (Resources)localObject));
    localDrawable2.setBounds(0, wja.dp2px(95.0F, (Resources)localObject), getWidth(), getHeight());
    LightingColorFilter localLightingColorFilter;
    if ((!this.bXh) && (!this.akU))
    {
      localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166649));
      localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131165685));
    }
    for (;;)
    {
      localDrawable2.setColorFilter((ColorFilter)localObject);
      localDrawable2.setAlpha(255);
      localDrawable2.draw(paramCanvas);
      localDrawable1.setColorFilter(localLightingColorFilter);
      localDrawable1.setAlpha(255);
      if (this.mIsSend) {
        break;
      }
      localDrawable1.draw(paramCanvas);
      return;
      if ((!this.bXh) && (this.akU))
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166650));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166646));
      }
      else if ((this.bXh) && (!this.akU))
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166647));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131165685));
      }
      else
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166648));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166646));
      }
    }
    paramCanvas.save();
    paramCanvas.scale(-1.0F, 1.0F, getWidth() / 2, getHeight() / 2);
    localDrawable1.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setBackground(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((this.mIsSend ^ paramBoolean1)) || ((this.bXh ^ paramBoolean2)))
    {
      this.mIsSend = paramBoolean1;
      this.bXh = paramBoolean2;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FlashPicBubbleView
 * JD-Core Version:    0.7.0.1
 */