package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleBeachController.BottleLoadWatcher;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.utilities.log.QMLog;

class BottleBeachFragment$23
  implements BottleBeachController.BottleLoadWatcher
{
  BottleBeachFragment$23(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onBottleLoadInMainThread(BottleBeach[] paramArrayOfBottleBeach)
  {
    QMLog.log(4, "BottleBeachFragment", "mLoadBottleWatcher onBottleLoadInMainThread beachBottles.length:" + paramArrayOfBottleBeach.length + ", isDeleteAnimation:" + BottleBeachFragment.access$2100(this.this$0) + ", isFlyAnimation:" + BottleBeachFragment.access$2200(this.this$0));
    BottleBeachFragment.access$1500(this.this$0, paramArrayOfBottleBeach);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.23
 * JD-Core Version:    0.7.0.1
 */