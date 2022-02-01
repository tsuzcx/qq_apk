package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.utilities.ui.PtrListView.OnRefreshCompleteListener;

class BottleBeachFragment$13
  implements PtrListView.OnRefreshCompleteListener
{
  BottleBeachFragment$13(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onAnimationEnd()
  {
    if ((BottleBeachFragment.access$1300(this.this$0) == null) || (BottleBeachFragment.access$1300(this.this$0).length == 0))
    {
      BottleBeachFragment.access$1402(this.this$0, false);
      return;
    }
    BottleBeachFragment.access$1402(this.this$0, true);
    BottleBeachFragment.access$1500(this.this$0, BottleBeachFragment.access$1300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.13
 * JD-Core Version:    0.7.0.1
 */