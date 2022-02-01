package com.tencent.mobileqq.dating;

import afck;
import afdb;
import android.util.Pair;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;
import mqq.os.MqqHandler;

public class StrangerHdHeadUrlFetcher$1
  implements Runnable
{
  public StrangerHdHeadUrlFetcher$1(afdb paramafdb, String paramString1, int paramInt, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.app.getQQHeadSetting(32, this.bDb, this.cvj);
    if (localObject1 != null) {}
    for (boolean bool = ((Boolean)((Pair)localObject1).first).booleanValue();; bool = false)
    {
      if ((bool) && (this.bXv))
      {
        localObject1 = (FriendListHandler)this.this$0.app.getBusinessHandler(1);
        if (localObject1 != null)
        {
          this.this$0.Xk = System.currentTimeMillis();
          synchronized (afdb.a(this.this$0))
          {
            if (!this.this$0.bXu)
            {
              this.this$0.bXu = true;
              this.this$0.app.addObserver(afdb.a(this.this$0), true);
            }
          }
        }
      }
      else
      {
        synchronized (this.this$0.cn)
        {
          this.this$0.cn.add(this.val$key);
          ((FriendListHandler)localObject1).a(this.bDb, this.cvj, (byte)1, (byte)2);
          if (!this.this$0.b.hasMessages(1)) {
            this.this$0.b.sendEmptyMessageDelayed(1, 60000L);
          }
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
      afck.l("StrangerHdHeadUrlFetcher", new Object[] { "flh is null" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher.1
 * JD-Core Version:    0.7.0.1
 */