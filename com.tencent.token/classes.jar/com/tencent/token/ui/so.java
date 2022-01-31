package com.tencent.token.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.bean.SafeMsgItem.MsgAction;

final class so
  implements View.OnClickListener
{
  so(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.a.mItem.mAction.mTargetUrl));
      this.a.startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.so
 * JD-Core Version:    0.7.0.1
 */