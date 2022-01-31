package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.fo;
import com.tencent.token.gm;

final class tb
  implements View.OnClickListener
{
  tb(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    af.a().b(0L, this.a.mItem.mId, OpMsgDisplayActivity.access$300(this.a));
    paramView = this.a.mItem;
    paramView.mFlag |= 0x100;
    LoginMsgActivity.mConfirmLogin = true;
    this.a.mItem.mContent += this.a.getResources().getString(2131362039);
    this.a.mCache.a.a(this.a.mItem.mId, this.a.mItem.mFlag, this.a.mItem.mContent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tb
 * JD-Core Version:    0.7.0.1
 */