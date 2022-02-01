package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.ListViewHelper;

class BottleBeachFragment$8
  implements View.OnClickListener
{
  BottleBeachFragment$8(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onClick(View paramView)
  {
    ListViewHelper.scrollToTop(this.this$0.getActivity(), BottleBeachFragment.access$300(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.8
 * JD-Core Version:    0.7.0.1
 */