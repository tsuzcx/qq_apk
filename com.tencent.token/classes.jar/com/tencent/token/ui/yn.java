package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.e;

final class yn
  implements View.OnClickListener
{
  yn(ScanLoginAccountListActivity paramScanLoginAccountListActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = (QQUser)paramView.getTag();
    if (paramView == null) {
      return;
    }
    if (!paramView.mIsBinded)
    {
      this.a.showUserDialog(2131361808, this.a.getString(2131361912), 2131361800, 2131361804, new yo(this, paramView), null);
      return;
    }
    ScanLoginAccountListActivity.access$002(this.a, paramView);
    long l = ScanLoginAccountListActivity.access$000(this.a).mUin;
    e.b("unbind uin: " + l);
    af.a().g(l, ScanLoginAccountListActivity.access$300(this.a));
    this.a.showProDialog(this.a, 2131361808, 2131361905, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yn
 * JD-Core Version:    0.7.0.1
 */