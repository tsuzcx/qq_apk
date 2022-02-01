package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import com.tencent.qqmail.namelist.watcher.LoadNameListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class NameListMainFragment$17
  implements LoadNameListWatcher
{
  NameListMainFragment$17(NameListMainFragment paramNameListMainFragment) {}
  
  public void onBefore(int paramInt) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    NameListMainFragment.access$1302(this.this$0, true);
    NameListMainFragment.access$1402(this.this$0, true);
    NameListMainFragment.access$2300(this.this$0, new NameListMainFragment.17.3(this));
  }
  
  public void onSuccess(int paramInt, boolean paramBoolean)
  {
    NameListMainFragment.access$1302(this.this$0, true);
    NameListMainFragment.access$1402(this.this$0, false);
    if (!paramBoolean) {
      NameListMainFragment.access$2100(this.this$0, new NameListMainFragment.17.1(this));
    }
    while (NameListMainFragment.access$1500(this.this$0) == null) {
      return;
    }
    NameListMainFragment.access$1500(this.this$0).refresh(false, new NameListMainFragment.17.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.17
 * JD-Core Version:    0.7.0.1
 */