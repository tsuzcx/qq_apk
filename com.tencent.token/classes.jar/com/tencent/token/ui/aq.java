package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;
import com.tencent.token.cw;

class aq
  implements View.OnClickListener
{
  aq(AddFaceRealNameApplyResultActivity paramAddFaceRealNameApplyResultActivity) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 219);
    cw.a().a(0L, this.a.mRealUin, 5, this.a.mName, this.a.mId, this.a.mFaceData, this.a.mFrontData, this.a.mBackData, this.a.frontphotoinfo, this.a.backphotoinfo, AddFaceRealNameApplyResultActivity.access$400(this.a));
    this.a.showProDialog(this.a, 2131230843, 2131231601, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aq
 * JD-Core Version:    0.7.0.1
 */