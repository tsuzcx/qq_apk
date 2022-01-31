package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.x;

final class ym
  implements View.OnClickListener
{
  ym(ScanLoginAccountListActivity paramScanLoginAccountListActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = (QQUser)paramView.getTag();
    ScanLoginAccountListActivity.access$102(this.a, "" + paramView.mRealUin);
    if (ScanLoginAccountListActivity.access$400(this.a).b(ScanLoginAccountListActivity.access$100(this.a), 523005419L))
    {
      paramView = new Intent(this.a, WtLoginAccountInput.class);
      paramView.putExtra("page_id", 6);
      paramView.putExtra("qquin", ScanLoginAccountListActivity.access$100(this.a));
      paramView.putExtra("wtlogin_appid", 523005419L);
      paramView.putExtra("scancode", ScanLoginAccountListActivity.access$200(this.a));
      this.a.startActivity(paramView);
      this.a.finish();
      return;
    }
    ScanLoginAccountListActivity.access$400(this.a).a(ScanLoginAccountListActivity.access$100(this.a), ScanLoginAccountListActivity.access$300(this.a), 523005419L);
    this.a.showUserDialog(11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ym
 * JD-Core Version:    0.7.0.1
 */