package com.tencent.av.gaudio;

import ino;
import inx;
import java.util.ArrayList;
import java.util.Iterator;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(ino paramino, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.a.this$0.a != null)
    {
      GaInviteLockActivity.a(this.a.this$0).clear();
      Iterator localIterator = this.is.iterator();
      while (localIterator.hasNext())
      {
        inx localinx = (inx)localIterator.next();
        if (localinx.mUserUin != this.a.this$0.mf) {
          GaInviteLockActivity.a(this.a.this$0).add(localinx);
        }
      }
      GaInviteLockActivity.a(this.a.this$0, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.a.this$0).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */