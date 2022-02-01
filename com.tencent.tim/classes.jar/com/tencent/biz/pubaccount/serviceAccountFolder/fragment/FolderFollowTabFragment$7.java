package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nyi;
import nyn;

class FolderFollowTabFragment$7
  implements Runnable
{
  FolderFollowTabFragment$7(FolderFollowTabFragment paramFolderFollowTabFragment, int paramInt) {}
  
  public void run()
  {
    Object localObject = nyn.a();
    List localList = ((nyn)localObject).be();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      nyi localnyi = (nyi)localIterator.next();
      if (FolderFollowTabFragment.a(this.this$0, localnyi.mUin))
      {
        localArrayList.add(localnyi);
        localIterator.remove();
      }
    }
    ((nyn)localObject).dq(localList);
    localObject = Message.obtain();
    ((Message)localObject).arg1 = this.val$from;
    ((Message)localObject).obj = localList;
    ((Message)localObject).what = 101;
    FolderFollowTabFragment.a(this.this$0).sendMessage((Message)localObject);
    FolderFollowTabFragment.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.7
 * JD-Core Version:    0.7.0.1
 */