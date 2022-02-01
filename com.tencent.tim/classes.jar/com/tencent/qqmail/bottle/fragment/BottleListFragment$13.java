package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.utilities.log.QMLog;

class BottleListFragment$13
  implements Runnable
{
  BottleListFragment$13(BottleListFragment paramBottleListFragment) {}
  
  public void run()
  {
    BottleListFragment.access$800(this.this$0).readDataFromDB();
    QMLog.log(3, "BottleListFragment", "animRemoveItem");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.13
 * JD-Core Version:    0.7.0.1
 */