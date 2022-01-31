package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.global.h;

class yd
  implements View.OnClickListener
{
  yd(ScanLoginAccountListActivity paramScanLoginAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQUser)paramView.getTag();
    if (paramView == null) {
      return;
    }
    if (!paramView.mIsBinded)
    {
      this.a.showUserDialog(2131230843, this.a.getString(2131231516), 2131230897, 2131230886, new ye(this, paramView), null);
      return;
    }
    ScanLoginAccountListActivity.access$002(this.a, paramView);
    long l = ScanLoginAccountListActivity.access$000(this.a).mUin;
    h.b("unbind uin: " + l);
    cw.a().g(l, ScanLoginAccountListActivity.access$300(this.a));
    this.a.showProDialog(this.a, 2131230843, 2131231517, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yd
 * JD-Core Version:    0.7.0.1
 */