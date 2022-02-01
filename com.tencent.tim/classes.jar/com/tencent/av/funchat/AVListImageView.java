package com.tencent.av.funchat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import jlg;
import wja;

public class AVListImageView
  extends ImageView
{
  private boolean SN;
  private boolean SO;
  private Paint aq = new Paint();
  private int aqk = 3;
  private int aql = -15550475;
  private int mRingWidth = 3;
  
  public AVListImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AVListImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AVListImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = wja.dp2px(this.aqk, getResources()) - 2;
    int n = wja.dp2px(this.mRingWidth, getResources());
    int i = Math.min(getWidth(), getHeight()) / 2;
    int j = getWidth() / 2;
    int k = getHeight() / 2;
    paramCanvas.drawARGB(0, 0, 0, 0);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      if (this.SO)
      {
        if (!(localDrawable instanceof jlg)) {
          localDrawable.setColorFilter(-10591367, PorterDuff.Mode.MULTIPLY);
        }
        localDrawable.setBounds(m, m, getWidth() - m, getHeight() - m);
        localDrawable.draw(paramCanvas);
      }
    }
    else if ((this.SN) && (!this.SO))
    {
      this.aq.reset();
      this.aq.setAntiAlias(true);
      this.aq.setColor(this.aql);
      this.aq.setStyle(Paint.Style.STROKE);
      this.aq.setStrokeWidth(n);
      m = (n + 1) / 2;
      if ((getParent() == null) || (!(getParent().getParent() instanceof LinearLayout))) {
        break label299;
      }
      i = Math.min(((LinearLayout)getParent().getParent()).getWidth() / 2, i);
    }
    label299:
    for (;;)
    {
      paramCanvas.drawCircle(j, k, i - m, this.aq);
      return;
      if ((localDrawable instanceof URLDrawable))
      {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
        break;
      }
      if ((localDrawable instanceof jlg)) {
        break;
      }
      localDrawable.clearColorFilter();
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      setAlpha(0.5F);
    }
    while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
      return true;
    }
    setAlpha(1.0F);
    return true;
  }
  
  public void setDimmed(boolean paramBoolean)
  {
    this.SO = paramBoolean;
    invalidate();
  }
  
  public void setDimmedColor(int paramInt)
  {
    this.aql = paramInt;
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.SN = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.funchat.AVListImageView
 * JD-Core Version:    0.7.0.1
 */