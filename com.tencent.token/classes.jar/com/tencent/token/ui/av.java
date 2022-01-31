package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cw;

class av
  implements View.OnClickListener
{
  av(AddFaceResultActivity paramAddFaceResultActivity) {}
  
  public void onClick(View paramView)
  {
    AddFaceResultActivity.access$102(this.a, AddFaceResultActivity.ADD_FACE_CAN_UPDATE_ZZB);
    cw.a().j(0L, AddFaceResultActivity.access$300(this.a));
    this.a.showProDialog(this.a, 2131230843, 2131231601, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.av
 * JD-Core Version:    0.7.0.1
 */