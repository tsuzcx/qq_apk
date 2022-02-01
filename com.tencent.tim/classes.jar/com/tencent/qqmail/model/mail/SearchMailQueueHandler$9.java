package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.SearchInfo;

class SearchMailQueueHandler$9
  implements Runnable
{
  SearchMailQueueHandler$9(SearchMailQueueHandler paramSearchMailQueueHandler, SearchInfo paramSearchInfo) {}
  
  public void run()
  {
    if (this.val$searchInfo == null) {
      return;
    }
    if (!SearchMailQueueHandler.access$300(this.this$0, this.val$searchInfo))
    {
      this.this$0.setFreshSearch(true);
      SearchMailQueueHandler.access$400(this.this$0);
      SearchMailQueueHandler.access$500(this.this$0);
      SearchMailQueueHandler.access$600(this.this$0, this.val$searchInfo);
    }
    for (;;)
    {
      SearchMailQueueHandler.access$700(this.this$0, true);
      return;
      this.this$0.setFreshSearch(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.9
 * JD-Core Version:    0.7.0.1
 */