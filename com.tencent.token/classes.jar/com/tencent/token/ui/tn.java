package com.tencent.token.ui;

import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.fo;
import com.tencent.token.gm;

final class tn
  implements Runnable
{
  SafeMsgItem a = null;
  
  public tn(tj paramtj, SafeMsgItem paramSafeMsgItem)
  {
    this.a = paramSafeMsgItem;
  }
  
  public final void run()
  {
    fo localfo = this.b.b;
    SafeMsgItem localSafeMsgItem = this.a;
    localSafeMsgItem.mIsRead = true;
    localfo.a.d(localSafeMsgItem.mId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tn
 * JD-Core Version:    0.7.0.1
 */