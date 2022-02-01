package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import com.tencent.qqmail.namelist.cursor.NameListCursor;
import java.util.concurrent.Callable;

class NameListMainFragment$15
  implements Callable<NameListBaseCursor>
{
  NameListMainFragment$15(NameListMainFragment paramNameListMainFragment) {}
  
  public NameListBaseCursor call()
  {
    NameListCursor localNameListCursor = NameListManager.sharedInstance().getNameListCursor(NameListMainFragment.access$000(this.this$0), NameListMainFragment.access$100(this.this$0));
    localNameListCursor.setOnRefresh(new NameListMainFragment.15.1(this));
    localNameListCursor.setThreadWrapper(new NameListMainFragment.15.2(this));
    localNameListCursor.refresh(true, null);
    return localNameListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.15
 * JD-Core Version:    0.7.0.1
 */