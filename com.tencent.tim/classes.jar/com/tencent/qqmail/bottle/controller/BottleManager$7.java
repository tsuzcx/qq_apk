package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Iterator;
import java.util.List;

class BottleManager$7
  implements Runnable
{
  BottleManager$7(BottleManager paramBottleManager, List paramList, OnActionCallback paramOnActionCallback) {}
  
  public void run()
  {
    Object localObject1 = this.val$bottleIdList.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new String[1];
      localObject3[0] = localObject2;
      this.this$0.mBottleListController.deleteBottle((String[])localObject3);
      this.this$0.mBottleBeachController.deleteBottle((String[])localObject3);
    }
    QMLog.log(4, "BottleManager", "batch remove bottle size:" + this.val$bottleIdList.size());
    this.this$0.mSettings.setListTotal(this.this$0.mSettings.getListTotal() - this.val$bottleIdList.size());
    Threads.runOnMainThread(new BottleManager.7.1(this));
    localObject1 = new StringBuilder("t=bottle_error_app&cmd=del");
    Object localObject2 = this.val$bottleIdList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (!StringExtention.isNullOrEmpty((String)localObject3)) {
        ((StringBuilder)localObject1).append(StringExtention.replaceWithEncodeURIValue("&mailid=$mailid$", "mailid", (String)localObject3));
      }
    }
    this.this$0.httpPost("bottle_opr", ((StringBuilder)localObject1).toString(), new BottleManager.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.7
 * JD-Core Version:    0.7.0.1
 */