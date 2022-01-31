package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class nk
  implements View.OnClickListener
{
  nk(JLFinditemsChooseZone paramJLFinditemsChooseZone) {}
  
  public final void onClick(View paramView)
  {
    if (JLFinditemsChooseZone.access$000(this.a) == 0)
    {
      this.a.finish();
      return;
    }
    if (JLFinditemsChooseZone.access$000(this.a) == 1)
    {
      JLFinditemsChooseZone.access$002(this.a, 0);
      JLFinditemsChooseZone.access$400(this.a, 0);
      this.a.setTitle(2131362265);
      return;
    }
    JLFinditemsChooseZone.access$002(this.a, 1);
    JLFinditemsChooseZone.access$400(this.a, JLFinditemsChooseZone.access$300(this.a));
    this.a.setTitle(2131362266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nk
 * JD-Core Version:    0.7.0.1
 */