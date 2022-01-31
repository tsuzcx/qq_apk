package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.SafeMsgItem;

class ss
  implements View.OnClickListener
{
  SafeMsgItem a = null;
  int b;
  
  public ss(sn paramsn, SafeMsgItem paramSafeMsgItem, int paramInt)
  {
    this.a = paramSafeMsgItem;
    this.b = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (sn.b(this.c).isListEdit()) {}
    do
    {
      return;
      Intent localIntent = new Intent(sn.b(this.c), OpMsgDisplayActivity.class);
      localIntent.putExtra("position", this.b);
      localIntent.putExtra("type", 2);
      localIntent.putExtra("abnormmsg", this.a.p());
      sn.b(this.c).startActivity(localIntent);
    } while (this.a.mIsRead);
    paramView.postDelayed(new sr(this.c, this.a), 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ss
 * JD-Core Version:    0.7.0.1
 */