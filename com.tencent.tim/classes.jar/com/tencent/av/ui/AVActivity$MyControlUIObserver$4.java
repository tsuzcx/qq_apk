package com.tencent.av.ui;

import com.tencent.av.ui.funchat.filter.EffectFilterPanel;

class AVActivity$MyControlUIObserver$4
  implements Runnable
{
  AVActivity$MyControlUIObserver$4(AVActivity.b paramb) {}
  
  public void run()
  {
    if (this.a.this$0.isDestroyed()) {}
    while (this.a.this$0.a == null) {
      return;
    }
    this.a.this$0.a.setAnimationTrigger(this.a.this$0.a());
    this.a.this$0.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.4
 * JD-Core Version:    0.7.0.1
 */