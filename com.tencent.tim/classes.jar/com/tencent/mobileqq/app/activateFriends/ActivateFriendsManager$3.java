package com.tencent.mobileqq.app.activateFriends;

import acoe;
import acof;
import acog;
import android.os.Bundle;
import aqgv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import ujt;
import ujt.d;

public class ActivateFriendsManager$3
  implements Runnable
{
  public ActivateFriendsManager$3(acof paramacof, int paramInt1, long[] paramArrayOfLong1, String paramString, int paramInt2, long[] paramArrayOfLong2) {}
  
  public void run()
  {
    if (this.aBm == 1)
    {
      localObject = this.ad;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        l = localObject[i];
        localSessionInfo = new SessionInfo();
        localSessionInfo.aTl = String.valueOf(l);
        localSessionInfo.cZ = 0;
        localSessionInfo.aTn = aqgv.D(acof.a(this.this$0), String.valueOf(l));
        locald = new ujt.d();
        locald.aTs = false;
        ujt.a(acof.a(this.this$0), acof.a(this.this$0).getApp(), localSessionInfo, this.bql, null, locald);
        i += 1;
      }
      this.this$0.b(this.ad, 1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 0);
      acof.a(this.this$0).notifyObservers(acog.class, 113, true, (Bundle)localObject);
    }
    while ((this.aBm != 2) || (this.cyw == -1) || (acoe.a(acof.a(this.this$0), this.bql, this.ad, this.ae, this.cyw)))
    {
      int j;
      int i;
      long l;
      SessionInfo localSessionInfo;
      ujt.d locald;
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_rt_type", 2);
    acof.a(this.this$0).notifyObservers(acog.class, 113, false, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3
 * JD-Core Version:    0.7.0.1
 */