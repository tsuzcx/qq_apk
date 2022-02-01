package com.tencent.moai.nativepages;

import android.util.Log;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

class AdLandingPagesPreviewAnimation$2
  implements Runnable
{
  AdLandingPagesPreviewAnimation$2(AdLandingPagesPreviewAnimation paramAdLandingPagesPreviewAnimation, View paramView, LinkedList paramLinkedList) {}
  
  public void run()
  {
    if (AdLandingPagesPreviewAnimation.access$000(this.this$0) == AdLandingPagesPreviewAnimation.access$500(this.this$0))
    {
      Log.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
      this.val$gallery.requestLayout();
      Iterator localIterator = this.val$galleryBottomList.iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesPreviewAnimation.2
 * JD-Core Version:    0.7.0.1
 */