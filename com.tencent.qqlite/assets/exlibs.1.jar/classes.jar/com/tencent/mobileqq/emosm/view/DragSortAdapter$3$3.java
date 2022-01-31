package com.tencent.mobileqq.emosm.view;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.widget.ProgressCircle;

class DragSortAdapter$3$3
  implements Runnable
{
  DragSortAdapter$3$3(DragSortAdapter.3 param3, int paramInt) {}
  
  public void run()
  {
    if (this.val$resultCode == 0)
    {
      this.this$1.val$progressCircle.setVisibility(8);
      this.this$1.val$updateLayout.setVisibility(8);
    }
    Button localButton;
    do
    {
      return;
      this.this$1.val$progressCircle.setProgress(0);
      this.this$1.val$progressCircle.setVisibility(8);
      localButton = (Button)this.this$1.val$updateLayout.findViewById(2131297085);
    } while (localButton == null);
    localButton.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.3.3
 * JD-Core Version:    0.7.0.1
 */