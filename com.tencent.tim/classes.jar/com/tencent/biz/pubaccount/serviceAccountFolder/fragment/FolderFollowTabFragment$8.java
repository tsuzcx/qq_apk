package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import java.util.Iterator;
import java.util.List;
import nyi;
import nyn;

class FolderFollowTabFragment$8
  implements Runnable
{
  FolderFollowTabFragment$8(FolderFollowTabFragment paramFolderFollowTabFragment, List paramList) {}
  
  public void run()
  {
    if (this.kJ != null)
    {
      Iterator localIterator = this.kJ.iterator();
      while (localIterator.hasNext())
      {
        nyi localnyi = (nyi)localIterator.next();
        if (localnyi.mUnreadNum > 0) {
          nyn.a().b(FolderFollowTabFragment.a(this.this$0), localnyi, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.8
 * JD-Core Version:    0.7.0.1
 */