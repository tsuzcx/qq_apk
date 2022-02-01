package com.tencent.mobileqq.mini.widget;

import android.os.Handler;
import android.widget.TextView;

class MiniLoadingAdLayout$4
  implements Runnable
{
  MiniLoadingAdLayout$4(MiniLoadingAdLayout paramMiniLoadingAdLayout, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    MiniLoadingAdLayout.access$110(this.this$0);
    if (MiniLoadingAdLayout.access$100(this.this$0) == MiniLoadingAdLayout.access$200(this.this$0)) {
      MiniLoadingAdLayout.access$300(this.this$0).setVisibility(0);
    }
    if (MiniLoadingAdLayout.access$100(this.this$0) > 0)
    {
      MiniLoadingAdLayout.access$400(this.this$0).setText(MiniLoadingAdLayout.access$100(this.this$0) + "秒");
      MiniLoadingAdLayout.access$500(this.this$0).postDelayed(this, 1000L);
      return;
    }
    this.this$0.dismiss(false, this.val$onDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.4
 * JD-Core Version:    0.7.0.1
 */