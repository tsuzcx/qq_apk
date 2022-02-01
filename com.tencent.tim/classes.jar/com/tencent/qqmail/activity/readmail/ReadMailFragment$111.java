package com.tencent.qqmail.activity.readmail;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadMailFragment$111
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadMailFragment$111(ReadMailFragment paramReadMailFragment) {}
  
  public void onGlobalLayout()
  {
    ReadMailFragment.access$2300(this.this$0).reflow();
    ReadMailFragment.access$17400(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.111
 * JD-Core Version:    0.7.0.1
 */