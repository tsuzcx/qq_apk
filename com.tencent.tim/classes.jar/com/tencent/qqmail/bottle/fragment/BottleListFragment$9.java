package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottleListFragment$9
  implements View.OnClickListener
{
  BottleListFragment$9(BottleListFragment paramBottleListFragment) {}
  
  public void onClick(View paramView)
  {
    BottleListFragment.access$1200(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.9
 * JD-Core Version:    0.7.0.1
 */