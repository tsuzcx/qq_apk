package com.tencent.mobileqq.dating.widget;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;

class InputBar$1
  implements Runnable
{
  InputBar$1(InputBar paramInputBar, int paramInt) {}
  
  public void run()
  {
    if (InputBar.a(this.this$0) <= this.cQx - InputBar.b(this.this$0))
    {
      InputBar.a(this.this$0).setSelectionFromTop(InputBar.d(this.this$0) + InputBar.c(this.this$0), this.cQx - InputBar.e(this.this$0) - InputBar.b(this.this$0));
      return;
    }
    if (InputBar.a(this.this$0).getAdapter() == null) {}
    for (int i = 0;; i = InputBar.a(this.this$0).getAdapter().getCount())
    {
      int j = InputBar.c(this.this$0);
      int k = InputBar.a(this.this$0).getFooterViewsCount();
      float f = this.this$0.getResources().getDisplayMetrics().density;
      int m = (int)(61.0F * f);
      j = InputBar.b(this.this$0) - this.cQx + InputBar.a(this.this$0).getBottom() - (i - j - k - InputBar.d(this.this$0) - 1) * m;
      i = j;
      if (InputBar.a(this.this$0).getFooterViewsCount() > 0) {
        i = (int)(j - f * 60.0F);
      }
      if (i <= 0) {
        break;
      }
      if (InputBar.a(this.this$0) != null) {
        InputBar.a(this.this$0).removeFooterView(InputBar.a(this.this$0));
      }
      InputBar.a(this.this$0, new View(this.this$0.getContext()));
      InputBar.a(this.this$0).setLayoutParams(new AbsListView.LayoutParams(-1, i));
      InputBar.a(this.this$0).addFooterView(InputBar.a(this.this$0));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.InputBar.1
 * JD-Core Version:    0.7.0.1
 */