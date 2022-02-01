package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.utilities.log.QMLog;

class BottleBeachFragment$22
  implements BottleListController.UpdateUnreadStatusWatcher
{
  BottleBeachFragment$22(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onSuccessInMainThread(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "BottleBeachFragment", "UpdateUnreadStatusWatcher hasNewMessage:" + paramBoolean + ", unreadBottleCount:" + paramInt1 + ", unreadMessageCount:" + paramInt2);
    BottleBeachFragment.access$2000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.22
 * JD-Core Version:    0.7.0.1
 */