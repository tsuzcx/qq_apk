package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;

class BrandPageWebview$1
  implements StateMachine.OnStateChangeListener
{
  BrandPageWebview$1(BrandPageWebview paramBrandPageWebview) {}
  
  public void onStateChanged()
  {
    PageWebview localPageWebview;
    if (BrandPageWebview.access$000(this.this$0) != null)
    {
      localPageWebview = BrandPageWebview.access$000(this.this$0);
      if (this.this$0.getCurrState() != BrandPageWebview.access$100(this.this$0)) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      localPageWebview.setPageJsLoadSucc(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.1
 * JD-Core Version:    0.7.0.1
 */