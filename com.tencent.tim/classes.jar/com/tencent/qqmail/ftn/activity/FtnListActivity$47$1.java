package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FtnListActivity$47$1
  implements Runnable
{
  FtnListActivity$47$1(FtnListActivity.47 param47) {}
  
  public void run()
  {
    FtnListActivity.access$1200(this.this$1.this$0);
    FtnListAdapter localFtnListAdapter = FtnListActivity.access$900(this.this$1.this$0);
    Iterator localIterator = FtnListActivity.access$2200(this.this$1.this$0).iterator();
    while (localIterator.hasNext())
    {
      FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)localIterator.next();
      localFtnListAdapter.putUploadItem(localFtnUploadInfo);
      FtnListActivity.access$500(this.this$1.this$0).signFile(localFtnUploadInfo);
    }
    localFtnListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.47.1
 * JD-Core Version:    0.7.0.1
 */