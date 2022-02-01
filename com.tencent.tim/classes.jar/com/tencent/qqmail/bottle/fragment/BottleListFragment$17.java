package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.bottle.controller.BottleManager;

class BottleListFragment$17
  implements BottleListController.UpdateUnreadStatusWatcher
{
  BottleListFragment$17(BottleListFragment paramBottleListFragment) {}
  
  public void onSuccessInMainThread(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    BottleManager.log("bottlelist mUnreadWatcher: " + paramBoolean + ", " + paramInt1 + ", " + paramInt2);
    BottleListFragment.access$1900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.17
 * JD-Core Version:    0.7.0.1
 */