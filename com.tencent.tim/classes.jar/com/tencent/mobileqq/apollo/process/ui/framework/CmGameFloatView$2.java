package com.tencent.mobileqq.apollo.process.ui.framework;

import acfp;
import ausj;
import com.tencent.mobileqq.apollo.view.FrameGifView;

class CmGameFloatView$2
  implements Runnable
{
  CmGameFloatView$2(CmGameFloatView paramCmGameFloatView, boolean paramBoolean) {}
  
  public void run()
  {
    if (CmGameFloatView.a(this.this$0)) {
      if (this.val$isOpen) {
        if (CmGameFloatView.a(this.this$0).getState() == 3) {
          CmGameFloatView.a(this.this$0).cGV();
        }
      }
    }
    while (CmGameFloatView.b(this.this$0) == -1)
    {
      return;
      CmGameFloatView.a(this.this$0).setImageResource(2130839445);
      return;
      CmGameFloatView.a(this.this$0).stop();
      CmGameFloatView.a(this.this$0).setImageResource(2130839443);
      return;
    }
    if (this.val$isOpen)
    {
      CmGameFloatView.a(this.this$0).updateButton(CmGameFloatView.b(this.this$0), acfp.m(2131704085));
      return;
    }
    CmGameFloatView.a(this.this$0).updateButton(CmGameFloatView.b(this.this$0), acfp.m(2131704083));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView.2
 * JD-Core Version:    0.7.0.1
 */