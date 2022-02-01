package com.tencent.moai.nativepages;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.moai.nativepages.component.AdLandingPageBaseComp;
import com.tencent.moai.nativepages.view.PagesScrollView;
import java.util.Iterator;
import java.util.LinkedList;

class AdLandingPagesUI$6
  implements ViewTreeObserver.OnPreDrawListener
{
  AdLandingPagesUI$6(AdLandingPagesUI paramAdLandingPagesUI, int paramInt, View paramView) {}
  
  public boolean onPreDraw()
  {
    LinkedList localLinkedList = new LinkedList();
    int i = ((AdLandingPageBaseComp)AdLandingPagesUI.access$000(this.this$0).getFirst()).getView().getHeight();
    Iterator localIterator = AdLandingPagesUI.access$000(this.this$0).iterator();
    for (;;)
    {
      int j;
      if (localIterator.hasNext())
      {
        AdLandingPageBaseComp localAdLandingPageBaseComp = (AdLandingPageBaseComp)localIterator.next();
        j = i;
        if (AdLandingPagesUI.access$000(this.this$0).indexOf(localAdLandingPageBaseComp) != 0)
        {
          j = i + localAdLandingPageBaseComp.getView().getHeight();
          localLinkedList.add(localAdLandingPageBaseComp.getView());
        }
        if (j >= this.val$screenHeight) {
          AdLandingPagesUI.access$400(this.this$0);
        }
      }
      else
      {
        AdLandingPagesUI.access$500(this.this$0).setVisibility(8);
        AdLandingPagesUI.access$600(this.this$0).setVisibility(8);
        AdLandingPagesUI.access$700(this.this$0).setVisibility(8);
        AdLandingPagesUI.access$800(this.this$0).getViewTreeObserver().removeOnPreDrawListener(this);
        AdLandingPagesUI.access$1000(this.this$0).runEnterAnimation(this.val$firstView, localLinkedList, AdLandingPagesUI.access$900(this.this$0), new AdLandingPagesUI.6.1(this));
        return true;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.6
 * JD-Core Version:    0.7.0.1
 */