package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottleBeachFragment$6
  implements View.OnClickListener
{
  BottleBeachFragment$6(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onClick(View paramView)
  {
    BottleListFragment localBottleListFragment = new BottleListFragment();
    this.this$0.startFragment(localBottleListFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.6
 * JD-Core Version:    0.7.0.1
 */