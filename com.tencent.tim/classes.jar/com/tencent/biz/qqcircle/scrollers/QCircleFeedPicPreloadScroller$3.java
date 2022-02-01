package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import pda;

public class QCircleFeedPicPreloadScroller$3
  implements Runnable
{
  public QCircleFeedPicPreloadScroller$3(pda parampda) {}
  
  public void run()
  {
    Iterator localIterator = pda.a(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!((Boolean)pda.a(this.this$0).get(str)).booleanValue())
      {
        QCircleFeedPicLoader.a().cancel(str);
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller.3
 * JD-Core Version:    0.7.0.1
 */