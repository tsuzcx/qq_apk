package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import aftr;
import afxd;
import afxd.a;
import afxe;

class MatchingStateHandler$1$1
  implements Runnable
{
  MatchingStateHandler$1$1(MatchingStateHandler.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.b != null)
    {
      this.a.this$0.b.a(100, null);
      if (this.a.this$0.b.b != null)
      {
        String str2 = "";
        String str1 = str2;
        if (this.a.this$0.c != null)
        {
          str1 = str2;
          if (this.a.this$0.c.nickName != null) {
            str1 = this.a.this$0.c.nickName;
          }
        }
        this.a.this$0.b.b.a(0, this.a.this$0.c, str1, "");
      }
      afxe.a(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1.1
 * JD-Core Version:    0.7.0.1
 */