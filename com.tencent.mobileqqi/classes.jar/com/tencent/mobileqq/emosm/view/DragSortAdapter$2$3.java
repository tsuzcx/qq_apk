package com.tencent.mobileqq.emosm.view;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.widget.ProgressCircle;

class DragSortAdapter$2$3
  implements Runnable
{
  DragSortAdapter$2$3(DragSortAdapter.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.val$resultCode == 0)
    {
      this.this$1.val$progressCircle.setVisibility(8);
      this.this$1.val$updateLayout.setVisibility(8);
      this.this$1.val$director.setVisibility(0);
      return;
    }
    this.this$1.val$progressCircle.setProgress(0);
    this.this$1.val$progressCircle.setVisibility(8);
    Button localButton = (Button)this.this$1.val$updateLayout.findViewById(2131231648);
    if (localButton != null) {
      localButton.setVisibility(0);
    }
    this.this$1.val$director.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.2.3
 * JD-Core Version:    0.7.0.1
 */