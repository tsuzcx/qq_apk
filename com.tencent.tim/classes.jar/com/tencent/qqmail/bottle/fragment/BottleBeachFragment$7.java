package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottleBeachFragment$7
  implements View.OnClickListener
{
  BottleBeachFragment$7(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onClick(View paramView)
  {
    BottleThrowFragment localBottleThrowFragment = new BottleThrowFragment();
    this.this$0.startFragmentForResult(localBottleThrowFragment, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.7
 * JD-Core Version:    0.7.0.1
 */