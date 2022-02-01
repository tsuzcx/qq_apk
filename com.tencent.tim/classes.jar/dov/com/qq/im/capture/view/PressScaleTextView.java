package dov.com.qq.im.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import axxe;

public class PressScaleTextView
  extends TextView
{
  private final axxe a = new axxe(this);
  
  public PressScaleTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PressScaleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressScaleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a.aPU())
    {
      paramCanvas.save();
      this.a.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
    if (this.a.aPU()) {
      paramCanvas.restore();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.a.ejg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.PressScaleTextView
 * JD-Core Version:    0.7.0.1
 */