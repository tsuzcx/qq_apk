package com.tencent.gdtad.views.form.framework;

import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormCommitListener;
import java.lang.ref.WeakReference;

class GdtFormCommitUtil$1$1
  implements Runnable
{
  GdtFormCommitUtil$1$1(GdtFormCommitUtil.1 param1, AdFormError paramAdFormError) {}
  
  public void run()
  {
    if ((this.this$0.val$listener != null) && (this.this$0.val$listener.get() != null)) {
      ((AdFormCommitListener)this.this$0.val$listener.get()).afterCommit(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormCommitUtil.1.1
 * JD-Core Version:    0.7.0.1
 */