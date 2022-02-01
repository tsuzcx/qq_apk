package com.tencent.mobileqq.app;

import android.graphics.Rect;

class ScreenShot$1
  implements Runnable
{
  ScreenShot$1(ScreenShot paramScreenShot, ScreenShot.ScreenView paramScreenView) {}
  
  public void run()
  {
    if (!this.b.bJl) {
      this.b.rect.setEmpty();
    }
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot.1
 * JD-Core Version:    0.7.0.1
 */