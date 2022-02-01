package com.tencent.biz.qqcircle;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

class QCircleFeedPicLoader$8
  implements Runnable
{
  QCircleFeedPicLoader$8(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void run()
  {
    Iterator localIterator = QCircleFeedPicLoader.a(this.this$0).keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ((QCircleFeedPicLoader.PicDownLoadTask)QCircleFeedPicLoader.a(this.this$0).get(str)).cancel();
      QCircleFeedPicLoader.a(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.a(this.this$0).getQueue().clear();
    localIterator = QCircleFeedPicLoader.b(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      ((QCircleFeedPicLoader.PicDownLoadTask)QCircleFeedPicLoader.b(this.this$0).get(str)).cancel();
      QCircleFeedPicLoader.b(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.b(this.this$0).getQueue().clear();
    QCircleFeedPicLoader.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleFeedPicLoader.8
 * JD-Core Version:    0.7.0.1
 */