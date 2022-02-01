package com.tencent.biz.pubaccount.subscript;

import java.io.Serializable;
import java.util.ArrayList;
import nzj;
import nzo;

public class SubscriptFeedsActivity$14$3
  implements Runnable
{
  public SubscriptFeedsActivity$14$3(nzj paramnzj, Serializable paramSerializable) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.b != null) && (SubscriptFeedsActivity.a(this.a.this$0) != null))
    {
      SubscriptFeedsActivity.a(this.a.this$0, (ArrayList)this.b);
      SubscriptFeedsActivity.a(this.a.this$0).dt(SubscriptFeedsActivity.a(this.a.this$0));
      SubscriptFeedsActivity.a(this.a.this$0).avO = true;
      localSubscriptFeedsActivity = this.a.this$0;
      if (SubscriptFeedsActivity.a(this.a.this$0).bdt != 1) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      SubscriptFeedsActivity.a(localSubscriptFeedsActivity, false, false, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.3
 * JD-Core Version:    0.7.0.1
 */