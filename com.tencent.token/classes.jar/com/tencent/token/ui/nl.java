package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;

final class nl
  implements View.OnClickListener
{
  nl(JLFinditemsResult paramJLFinditemsResult) {}
  
  public final void onClick(View paramView)
  {
    if (JLFinditemsResult.access$000(this.a) == -1)
    {
      af.a().a(0L, JLFinditemsResult.access$100(this.a), JLFinditemsResult.access$200(this.a), JLFinditemsResult.access$300(this.a), JLFinditemsResult.access$400(this.a), JLFinditemsResult.access$500(this.a), JLFinditemsResult.access$600(this.a), JLFinditemsResult.access$700(this.a), JLFinditemsResult.access$800(this.a));
      return;
    }
    if (JLFinditemsResult.access$000(this.a) == 0)
    {
      paramView = new Intent(this.a, JLAppealListActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, FindItemsActivity.class);
    paramView.addFlags(67108864);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nl
 * JD-Core Version:    0.7.0.1
 */