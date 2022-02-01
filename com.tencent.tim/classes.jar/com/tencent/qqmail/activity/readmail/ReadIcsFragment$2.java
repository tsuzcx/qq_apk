package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class ReadIcsFragment$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadIcsFragment$2(ReadIcsFragment paramReadIcsFragment) {}
  
  public void onGlobalLayout()
  {
    if ((ReadIcsFragment.access$300(this.this$0) != null) && (ReadIcsFragment.access$400(this.this$0) != null) && (ReadIcsFragment.access$400(this.this$0).getLineCount() >= 4))
    {
      ReadIcsFragment.access$500(this.this$0).setVisibility(0);
      ReadIcsFragment.access$300(this.this$0).setOnClickListener(ReadIcsFragment.access$600(this.this$0));
      return;
    }
    ReadIcsFragment.access$500(this.this$0).setVisibility(8);
    ReadIcsFragment.access$300(this.this$0).setOnClickListener(null);
    ReadIcsFragment.access$300(this.this$0).setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsFragment.2
 * JD-Core Version:    0.7.0.1
 */