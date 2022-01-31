package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;

class yc
  implements View.OnClickListener
{
  yc(ScanLoginAccountListActivity paramScanLoginAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQUser)paramView.getTag();
    ScanLoginAccountListActivity.access$102(this.a, "" + paramView.mRealUin);
    if (ScanLoginAccountListActivity.access$400(this.a).b(ScanLoginAccountListActivity.access$100(this.a), 523005419L))
    {
      ScanLoginAccountListActivity.access$500(this.a);
      return;
    }
    ScanLoginAccountListActivity.access$400(this.a).a(ScanLoginAccountListActivity.access$100(this.a), ScanLoginAccountListActivity.access$300(this.a), 523005419L);
    this.a.showUserDialog(11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yc
 * JD-Core Version:    0.7.0.1
 */