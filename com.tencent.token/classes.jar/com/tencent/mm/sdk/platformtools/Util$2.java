package com.tencent.mm.sdk.platformtools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class Util$2
  implements View.OnTouchListener
{
  Util$2(View paramView1, View paramView2) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.bD.setSelected(true);
      return false;
    case 1: 
    case 3: 
    case 4: 
      this.bD.setSelected(false);
      return false;
    }
    this.bD.setSelected(this.bE.isPressed());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Util.2
 * JD-Core Version:    0.7.0.1
 */