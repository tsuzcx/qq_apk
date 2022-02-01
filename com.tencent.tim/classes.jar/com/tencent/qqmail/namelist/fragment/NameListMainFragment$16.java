package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import com.tencent.qqmail.namelist.cursor.NameListSearchCursor;
import java.util.concurrent.Callable;

class NameListMainFragment$16
  implements Callable<NameListBaseCursor>
{
  NameListMainFragment$16(NameListMainFragment paramNameListMainFragment) {}
  
  public NameListBaseCursor call()
  {
    NameListSearchCursor localNameListSearchCursor = NameListManager.sharedInstance().getNameListSearchCursor(NameListMainFragment.access$000(this.this$0), NameListMainFragment.access$100(this.this$0), NameListMainFragment.access$800(this.this$0));
    localNameListSearchCursor.setOnRefresh(new NameListMainFragment.16.1(this));
    localNameListSearchCursor.setThreadWrapper(new NameListMainFragment.16.2(this));
    localNameListSearchCursor.refresh(true, new NameListMainFragment.16.3(this));
    return localNameListSearchCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.16
 * JD-Core Version:    0.7.0.1
 */