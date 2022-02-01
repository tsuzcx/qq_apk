package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageButton;

public class TCWNumberPickerButton
  extends ImageButton
{
  private TCWNumberPicker e;
  
  public TCWNumberPickerButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TCWNumberPickerButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TCWNumberPickerButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void ai(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      exu();
    }
  }
  
  private void exu()
  {
    if (2131369135 == getId()) {
      this.e.exs();
    }
    while (2131365660 != getId()) {
      return;
    }
    this.e.ext();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 23) || (paramInt == 66)) {
      exu();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ai(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    ai(paramMotionEvent);
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void setNumberPicker(TCWNumberPicker paramTCWNumberPicker)
  {
    this.e = paramTCWNumberPicker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPickerButton
 * JD-Core Version:    0.7.0.1
 */