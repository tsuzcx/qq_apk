package dov.com.tencent.biz.qqstory.takevideo.linker;

import aygu;
import aypi;

class LinkerSummaryView$1
  implements Runnable
{
  LinkerSummaryView$1(LinkerSummaryView paramLinkerSummaryView, aypi paramaypi) {}
  
  public void run()
  {
    if (this.this$0.b != null) {
      this.this$0.b.a(this.b);
    }
    if ((this.this$0.getVisibility() == 0) && (this.this$0.a != null) && (this.this$0.a.mUrl != null) && (this.b.mUrl.equals(this.this$0.a.mUrl))) {
      this.this$0.c(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView.1
 * JD-Core Version:    0.7.0.1
 */