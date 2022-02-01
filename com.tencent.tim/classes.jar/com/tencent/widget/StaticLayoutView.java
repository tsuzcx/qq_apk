package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.a;

public class StaticLayoutView
  extends View
{
  DatingCommentTextView.a a;
  private Layout layout;
  
  public StaticLayoutView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StaticLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StaticLayoutView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Layout getLayout()
  {
    return this.layout;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if (this.layout != null) {
      this.layout.draw(paramCanvas, null, null, 0);
    }
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.layout != null)
    {
      setMeasuredDimension(this.layout.getWidth(), this.layout.getHeight());
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    Object localObject1 = getLayout();
    Object localObject2 = ((Layout)localObject1).getText();
    if ((localObject2 instanceof Spannable))
    {
      localObject2 = (Spannable)localObject2;
      j = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k), j);
      localObject1 = (ClickableSpan[])((Spannable)localObject2).getSpans(j, j, ClickableSpan.class);
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        if ((i == 1) || (i == 3))
        {
          if (i == 1) {
            localObject1[0].onClick(this);
          }
          if ((localObject1[0] instanceof DatingCommentTextView.a)) {
            ((DatingCommentTextView.a)localObject1[0]).setPressed(false);
          }
          this.a = null;
          postInvalidate();
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            if ((localObject1[0] instanceof DatingCommentTextView.a))
            {
              ((DatingCommentTextView.a)localObject1[0]).setPressed(true);
              this.a = ((DatingCommentTextView.a)localObject1[0]);
            }
            postInvalidate();
          }
        }
      }
      if (((i == 1) || (i == 3)) && (this.a != null))
      {
        this.a.setPressed(false);
        this.a = null;
        postInvalidate();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setLayout(Layout paramLayout)
  {
    this.layout = paramLayout;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.StaticLayoutView
 * JD-Core Version:    0.7.0.1
 */