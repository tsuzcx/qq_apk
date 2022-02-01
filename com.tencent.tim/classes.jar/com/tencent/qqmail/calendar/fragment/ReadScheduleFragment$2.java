package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class ReadScheduleFragment$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadScheduleFragment$2(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onGlobalLayout()
  {
    if ((ReadScheduleFragment.access$300(this.this$0) != null) && (ReadScheduleFragment.access$400(this.this$0) != null) && (ReadScheduleFragment.access$400(this.this$0).getLineCount() >= 4))
    {
      ReadScheduleFragment.access$500(this.this$0).setVisibility(0);
      ReadScheduleFragment.access$300(this.this$0).setOnClickListener(ReadScheduleFragment.access$600(this.this$0));
      return;
    }
    ReadScheduleFragment.access$500(this.this$0).setVisibility(8);
    ReadScheduleFragment.access$300(this.this$0).setOnClickListener(null);
    ReadScheduleFragment.access$300(this.this$0).setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.2
 * JD-Core Version:    0.7.0.1
 */