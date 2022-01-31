package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.cw;
import com.tencent.token.er;
import com.tencent.token.gb;

class sf
  implements View.OnClickListener
{
  sf(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    cw.a().a(0L, this.a.mItem.a(), OpMsgDisplayActivity.access$300(this.a));
    paramView = this.a.mItem;
    paramView.mFlag |= 0x100;
    LoginMsgActivity.mConfirmLogin = true;
    this.a.mItem.mContent += this.a.getResources().getString(2131231128);
    this.a.mCache.a.a(this.a.mItem.a(), this.a.mItem.mFlag, this.a.mItem.mContent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sf
 * JD-Core Version:    0.7.0.1
 */