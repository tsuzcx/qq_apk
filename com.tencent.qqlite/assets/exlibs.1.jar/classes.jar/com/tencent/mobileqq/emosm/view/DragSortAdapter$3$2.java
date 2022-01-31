package com.tencent.mobileqq.emosm.view;

import com.tencent.mobileqq.widget.ProgressCircle;

class DragSortAdapter$3$2
  implements Runnable
{
  DragSortAdapter$3$2(DragSortAdapter.3 param3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if ((this.val$ammount >= this.val$loaded) && (this.val$loaded > 0)) {
      this.this$1.val$progressCircle.setProgress(this.val$loaded * 100 / this.val$ammount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.3.2
 * JD-Core Version:    0.7.0.1
 */