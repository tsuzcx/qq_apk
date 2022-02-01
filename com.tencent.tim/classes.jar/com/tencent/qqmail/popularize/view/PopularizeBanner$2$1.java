package com.tencent.qqmail.popularize.view;

import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.TypePageFilter;

class PopularizeBanner$2$1
  implements Runnable
{
  PopularizeBanner$2$1(PopularizeBanner.2 param2) {}
  
  public void run()
  {
    if (PopularizeBanner.access$100(this.this$1.this$0).isRener())
    {
      PopularizeBanner.access$202(this.this$1.this$0, PopularizeManager.sharedInstance().getPopularize(new TypePageFilter(0, PopularizeBanner.access$300(this.this$1.this$0))));
      PopularizeBanner.access$100(this.this$1.this$0).render(true, PopularizeBanner.access$200(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBanner.2.1
 * JD-Core Version:    0.7.0.1
 */