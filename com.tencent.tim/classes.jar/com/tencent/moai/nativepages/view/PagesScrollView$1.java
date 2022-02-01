package com.tencent.moai.nativepages.view;

class PagesScrollView$1
  implements Runnable
{
  PagesScrollView$1(PagesScrollView paramPagesScrollView) {}
  
  public void run()
  {
    int i = this.this$0.getScrollY();
    if (i != PagesScrollView.access$000(this.this$0)) {
      if (PagesScrollView.access$100(this.this$0) != null)
      {
        PagesScrollView.access$100(this.this$0).onScrollChanged(this.this$0, 0, i, 0, PagesScrollView.access$200(this.this$0));
        this.this$0.postDelayed(PagesScrollView.access$300(this.this$0), PagesScrollView.access$400(this.this$0));
      }
    }
    for (;;)
    {
      PagesScrollView.access$002(this.this$0, this.this$0.getScrollY());
      return;
      if (i == PagesScrollView.access$000(this.this$0))
      {
        if (PagesScrollView.access$100(this.this$0) != null) {
          PagesScrollView.access$100(this.this$0).onScrollStopped(PagesScrollView.access$000(this.this$0), PagesScrollView.access$200(this.this$0));
        }
        PagesScrollView.access$202(this.this$0, PagesScrollView.access$000(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.PagesScrollView.1
 * JD-Core Version:    0.7.0.1
 */