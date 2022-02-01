package com.tencent.biz.pubaccount.subscript;

import com.tencent.widget.SwipListView;
import java.util.List;
import nzj;
import nzo;
import oac;

public class SubscriptFeedsActivity$14$1
  implements Runnable
{
  public SubscriptFeedsActivity$14$1(nzj paramnzj, List paramList) {}
  
  public void run()
  {
    int i;
    if (SubscriptFeedsActivity.a(this.a.this$0) != null)
    {
      i = SubscriptFeedsActivity.a(this.a.this$0).size();
      if (this.gg == null) {
        break label142;
      }
    }
    label142:
    for (int j = this.gg.size();; j = 0)
    {
      SubscriptFeedsActivity.a(this.a.this$0, this.gg);
      if ((SubscriptFeedsActivity.a(this.a.this$0)) && (i != j))
      {
        if (this.a.this$0.a.bdz == 2) {
          SubscriptFeedsActivity.a(this.a.this$0).setSelectionFromBottom(SubscriptFeedsActivity.a(this.a.this$0).getCount() - 1, 0);
        }
        SubscriptFeedsActivity.b(this.a.this$0, false);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.1
 * JD-Core Version:    0.7.0.1
 */