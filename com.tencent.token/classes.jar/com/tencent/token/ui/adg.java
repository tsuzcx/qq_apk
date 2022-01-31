package com.tencent.token.ui;

import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.base.dh;
import com.tencent.token.utils.s;

final class adg
  implements dh
{
  adg(adf paramadf) {}
  
  public final void a(int paramInt)
  {
    if (ax.a().e() == null)
    {
      if (paramInt == 0)
      {
        this.a.a.showNoAccountTipDialog(this.a.a, 13, 0);
        return;
      }
      s.b(this.a.a, this.a.a.getString(2131361988));
      return;
    }
    if (!ax.a().e().mIsBinded)
    {
      if (paramInt == 0)
      {
        this.a.a.showNoAccountTipDialog(this.a.a, 13, 1);
        return;
      }
      s.b(this.a.a, this.a.a.getString(2131361988));
      return;
    }
    UtilsActivity.access$200(this.a.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adg
 * JD-Core Version:    0.7.0.1
 */