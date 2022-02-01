package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nyi;
import nyn;

public class ServiceAccountFolderManager$4
  implements Runnable
{
  public ServiceAccountFolderManager$4(nyn paramnyn, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(nyn.a(this.this$0));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      nyi localnyi = (nyi)localIterator.next();
      this.this$0.a(this.val$app, localnyi, false);
    }
    localArrayList.clear();
    this.this$0.aj(this.val$app);
    this.this$0.al(this.val$app);
    this.this$0.e(this.val$app, this.val$time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.4
 * JD-Core Version:    0.7.0.1
 */