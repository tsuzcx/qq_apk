package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.SafeMsgItem;

final class to
  implements View.OnClickListener
{
  SafeMsgItem a = null;
  int b;
  
  public to(tj paramtj, SafeMsgItem paramSafeMsgItem, int paramInt)
  {
    this.a = paramSafeMsgItem;
    this.b = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    if (tj.b(this.c).isListEdit()) {
      return;
    }
    Intent localIntent = new Intent(tj.b(this.c), OpMsgDisplayActivity.class);
    localIntent.putExtra("position", this.b);
    localIntent.putExtra("type", 2);
    if ((this.a.mFlag & 0x80) == 128) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("abnormmsg", bool);
      tj.b(this.c).startActivity(localIntent);
      if (this.a.mIsRead) {
        break;
      }
      paramView.postDelayed(new tn(this.c, this.a), 5L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.to
 * JD-Core Version:    0.7.0.1
 */