package com.tencent.mobileqq.activity;

import aahb;
import akwp;
import com.tencent.mobileqq.app.QQAppInterface;
import ury;

public class Conversation$1$3
  implements Runnable
{
  public Conversation$1$3(ury paramury) {}
  
  public void run()
  {
    boolean bool3 = true;
    int i;
    boolean bool4;
    boolean bool1;
    if (this.a.this$0.a.fL(17) == 2)
    {
      i = 1;
      bool4 = akwp.a().bl(this.a.this$0.app);
      if (!bool4) {
        break label122;
      }
      if (i != 0) {
        break label165;
      }
      akwp.a().dC(this.a.this$0.app);
      bool1 = false;
    }
    for (;;)
    {
      label69:
      boolean bool2;
      if ((bool4) && (i == 0))
      {
        bool2 = true;
        label80:
        if ((bool4) || (!bool1) || (i == 0)) {
          break label160;
        }
      }
      label160:
      for (bool1 = bool3;; bool1 = false)
      {
        this.a.this$0.runOnUiThread(new Conversation.1.3.1(this, bool2, bool1));
        return;
        i = 0;
        break;
        label122:
        bool1 = akwp.a().N(this.a.this$0.app, this.a.this$0.app.getCurrentAccountUin());
        break label69;
        bool2 = false;
        break label80;
      }
      label165:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.3
 * JD-Core Version:    0.7.0.1
 */