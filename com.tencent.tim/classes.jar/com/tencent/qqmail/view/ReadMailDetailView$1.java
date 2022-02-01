package com.tencent.qqmail.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class ReadMailDetailView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadMailDetailView$1(ReadMailDetailView paramReadMailDetailView) {}
  
  public void onGlobalLayout()
  {
    if (ReadMailDetailView.access$000(this.this$0) == null) {
      return;
    }
    TextView localTextView1 = (TextView)ReadMailDetailView.access$100(this.this$0).findViewById(2131368180);
    TextView localTextView2 = (TextView)ReadMailDetailView.access$100(this.this$0).findViewById(2131372384);
    TextView localTextView3 = (TextView)ReadMailDetailView.access$100(this.this$0).findViewById(2131363032);
    ViewGroup localViewGroup = (ViewGroup)ReadMailDetailView.access$000(this.this$0).findViewById(2131367736);
    int j = ReadMailDetailView.access$100(this.this$0).getWidth();
    int k = ReadMailDetailView.access$200(this.this$0).getWidth();
    if (localTextView1.getVisibility() != 8) {}
    for (int i = localTextView1.getWidth();; i = 0)
    {
      if (localTextView3.getVisibility() != 8) {
        localTextView3.getWidth();
      }
      ReadMailDetailView.access$100(this.this$0).setPadding(0, 0, k, 0);
      localViewGroup.setPadding(0, 0, k, 0);
      localTextView2.setMaxWidth((int)((j - k - i) * 0.7D));
      ((TextView)ReadMailDetailView.access$000(this.this$0).findViewById(2131368147).findViewById(2131370111)).setWidth(((TextView)ReadMailDetailView.access$000(this.this$0).findViewById(2131379661).findViewById(2131370111)).getWidth());
      ReadMailDetailView.access$100(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailDetailView.1
 * JD-Core Version:    0.7.0.1
 */