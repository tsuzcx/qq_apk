package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleBeachController;
import com.tencent.qqmail.utilities.ui.PtrListView.OnRefreshListener;

class BottleBeachFragment$12
  extends PtrListView.OnRefreshListener
{
  BottleBeachFragment$12(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onRefresh()
  {
    BottleBeachFragment.access$1100(this.this$0)[1] = System.currentTimeMillis();
    BottleBeachFragment.access$200(this.this$0).requestBeachBottle();
    BottleBeachFragment.access$1200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.12
 * JD-Core Version:    0.7.0.1
 */