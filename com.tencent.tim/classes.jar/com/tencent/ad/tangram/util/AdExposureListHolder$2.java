package com.tencent.ad.tangram.util;

import android.content.Context;
import com.tencent.ad.tangram.process.AdProcessManager;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;

class AdExposureListHolder$2
  implements Runnable
{
  AdExposureListHolder$2(AdExposureListHolder paramAdExposureListHolder, LinkedList paramLinkedList, Context paramContext) {}
  
  public void run()
  {
    JSONArray localJSONArray = new JSONArray();
    ??? = this.val$linkedList.iterator();
    while (((Iterator)???).hasNext()) {
      localJSONArray.put((String)((Iterator)???).next());
    }
    synchronized (AdExposureListHolder.access$200(this.this$0))
    {
      a.write(AdExposureListHolder.access$000(this.this$0, this.val$context, AdProcessManager.INSTANCE.getCurrentProcessName(this.val$context)), localJSONArray.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureListHolder.2
 * JD-Core Version:    0.7.0.1
 */