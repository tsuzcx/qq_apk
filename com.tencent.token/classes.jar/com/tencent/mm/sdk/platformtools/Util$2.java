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
    boolean bool;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 2: 
      paramView = this.bD;
      bool = this.bE.isPressed();
      break;
    case 1: 
    case 3: 
    case 4: 
      this.bD.setSelected(false);
      return false;
    case 0: 
      paramView = this.bD;
      bool = true;
    }
    paramView.setSelected(bool);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Util.2
 * JD-Core Version:    0.7.0.1
 */