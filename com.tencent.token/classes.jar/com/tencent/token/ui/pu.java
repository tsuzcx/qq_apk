package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.tencent.token.core.bean.g;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.w;
import com.tmsdk.TMSDKContext;

class pu
  implements View.OnClickListener
{
  pu(ps paramps, g paramg, ProgressBar paramProgressBar) {}
  
  public void onClick(View paramView)
  {
    paramView = cw.a();
    String str1 = this.a.a;
    String str2 = this.a.d;
    int i = this.a.e;
    int j = this.a.f;
    String str3 = this.a.g;
    String str4 = w.a(cp.a(RqdApplication.l()).b());
    ps.a(this.c);
    paramView.a(0L, str1, str2, i, j, str3, str4, 523005419, 1, "com.tencent.token", LoginMsgActivity.mSkey, ps.a(this.c).mHandler);
    this.b.setVisibility(0);
    TMSDKContext.saveActionData(1150063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pu
 * JD-Core Version:    0.7.0.1
 */