package com.tencent.mobileqq.search;

import amkn;
import amkp;
import android.view.View;
import android.widget.RelativeLayout;

public class SearchWordHistoryEntryModel$2$3
  implements Runnable
{
  public SearchWordHistoryEntryModel$2$3(amkp paramamkp, int[] paramArrayOfInt1, View paramView, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    this.a.a.lS.getLocationOnScreen(this.na);
    this.GP.getLocationOnScreen(this.nb);
    if (this.na[1] > this.nb[1])
    {
      View localView1 = this.GP.findViewById(2131362999);
      View localView2 = this.GP.findViewById(2131362986);
      localView1.setVisibility(8);
      localView2.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.3
 * JD-Core Version:    0.7.0.1
 */