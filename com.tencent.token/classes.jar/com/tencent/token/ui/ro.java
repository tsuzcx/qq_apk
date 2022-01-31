package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;

final class ro
  implements View.OnClickListener
{
  ro(NetActiveVryOtherListActivity paramNetActiveVryOtherListActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, WtloginFinishNoMibaoActivity.class);
    paramView.putExtra("uin", NetActiveVryOtherListActivity.access$000(this.a).mRealUin);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ro
 * JD-Core Version:    0.7.0.1
 */