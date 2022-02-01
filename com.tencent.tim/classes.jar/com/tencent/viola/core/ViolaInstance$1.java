package com.tencent.viola.core;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.utils.ViolaLogUtils;

class ViolaInstance$1
  implements Runnable
{
  ViolaInstance$1(ViolaInstance paramViolaInstance, VComponentContainer paramVComponentContainer) {}
  
  public void run()
  {
    ViolaLogUtils.e("ViolaInstance", "violaInstance pageEndMonitor start!");
    ViolaInstance.access$002(this.this$0, this.val$root);
    ViolaInstance.access$100(this.this$0).removeAllViews();
    if (this.val$root.getHostView().getParent() == null) {
      ViolaInstance.access$100(this.this$0).addView(this.val$root.getHostView());
    }
    for (;;)
    {
      if (!ViolaInstance.access$200(this.this$0))
      {
        ViolaLogUtils.e("ViolaInstance", "violaInstance pageEndMonitor end!");
        this.this$0.pageEndMonitor();
      }
      ViolaInstance.access$202(this.this$0, true);
      if (ViolaInstance.access$300(this.this$0)) {
        ViolaInstance.access$000(this.this$0).onActivityResume();
      }
      return;
      ViolaInstance.access$100(this.this$0).addView((View)this.val$root.getRealView().getParent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaInstance.1
 * JD-Core Version:    0.7.0.1
 */