package com.tencent.biz.pubaccount.readinjoy.engine;

import java.lang.ref.WeakReference;
import lby;
import lcc;
import lhy;

public class ReadInJoyFollowingMemberPrefetcher$4
  implements Runnable
{
  public ReadInJoyFollowingMemberPrefetcher$4(lby paramlby, boolean paramBoolean) {}
  
  public void run()
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following members");
    }
    lhy locallhy = (lhy)lby.a(this.this$0).get();
    if (locallhy != null)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadInJoyFollowingMemberPrefetcher", 2, "preload all following members, force=" + this.val$forceReload);
      }
      try
      {
        if ((lby.b(this.this$0).get() == null) || (lby.a(this.this$0)))
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following member when appinterface is null or uninitialized!");
          }
          return;
        }
        lby.a(this.this$0, true);
        lcc.a().b(this.this$0);
        this.this$0.aJd();
        locallhy.j(1000, 1, true);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.4
 * JD-Core Version:    0.7.0.1
 */