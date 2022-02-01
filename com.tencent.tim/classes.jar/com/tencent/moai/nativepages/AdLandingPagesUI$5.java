package com.tencent.moai.nativepages;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.moai.nativepages.component.AdLandingPageBaseComp;
import java.util.Iterator;
import java.util.LinkedList;

class AdLandingPagesUI$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AdLandingPagesUI$5(AdLandingPagesUI paramAdLandingPagesUI, int paramInt) {}
  
  public void onGlobalLayout()
  {
    int i;
    if (!AdLandingPagesUI.access$200(this.this$0))
    {
      AdLandingPagesUI.access$300(this.this$0);
      AdLandingPagesUI.access$202(this.this$0, true);
      i = ((AdLandingPageBaseComp)AdLandingPagesUI.access$000(this.this$0).getFirst()).getView().getHeight();
      Iterator localIterator = AdLandingPagesUI.access$000(this.this$0).iterator();
      if (localIterator.hasNext())
      {
        AdLandingPageBaseComp localAdLandingPageBaseComp = (AdLandingPageBaseComp)localIterator.next();
        if (AdLandingPagesUI.access$000(this.this$0).indexOf(localAdLandingPageBaseComp) == 0) {
          break label119;
        }
        i = localAdLandingPageBaseComp.getView().getHeight() + i;
      }
    }
    label119:
    for (;;)
    {
      if (i >= this.val$screenHeight)
      {
        AdLandingPagesUI.access$400(this.this$0);
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.5
 * JD-Core Version:    0.7.0.1
 */