package com.tencent.token.ui;

import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.er;

class sr
  implements Runnable
{
  SafeMsgItem a = null;
  
  public sr(sn paramsn, SafeMsgItem paramSafeMsgItem)
  {
    this.a = paramSafeMsgItem;
  }
  
  public void run()
  {
    this.b.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sr
 * JD-Core Version:    0.7.0.1
 */