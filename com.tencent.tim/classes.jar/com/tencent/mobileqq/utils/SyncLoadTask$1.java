package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import aqms;
import aqms.a;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public final class SyncLoadTask$1
  implements Runnable
{
  public SyncLoadTask$1(ArrayList paramArrayList1, Resources paramResources, aqms.a parama, ArrayList paramArrayList2) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.val$list.iterator();
    while (localIterator.hasNext())
    {
      aqms localaqms = (aqms)localIterator.next();
      if (localaqms.runOnSubThread(this.val$resources))
      {
        localArrayList1.add(localaqms);
      }
      else
      {
        localaqms.clean();
        localArrayList2.add(localaqms);
      }
    }
    ThreadManager.getUIHandler().post(new SyncLoadTask.1.1(this, localArrayList1, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SyncLoadTask.1
 * JD-Core Version:    0.7.0.1
 */