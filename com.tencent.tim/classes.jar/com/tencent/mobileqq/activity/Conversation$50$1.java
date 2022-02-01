package com.tencent.mobileqq.activity;

import anxk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;
import utg;

public class Conversation$50$1
  implements Runnable
{
  Conversation$50$1(Conversation.50 param50) {}
  
  public void run()
  {
    if (this.a.this$0.isDestroy) {}
    for (;;)
    {
      return;
      anxk localanxk = (anxk)this.a.this$0.app.getManager(62);
      if (localanxk != null)
      {
        ArrayList localArrayList = localanxk.W("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localanxk.a(this.a.this$0.app, this.a.this$0.a(), localPair, new utg(this, localanxk, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.50.1
 * JD-Core Version:    0.7.0.1
 */