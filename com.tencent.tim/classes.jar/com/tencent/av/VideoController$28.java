package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import inx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class VideoController$28
  implements Runnable
{
  VideoController$28(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (VideoController.a(this.this$0).isEmpty()) {
      QLog.d(VideoController.TAG, 1, "InviteMemberList dealInviteMemberRsp empty result");
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = VideoController.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(Long.valueOf(((VideoController.b)localIterator.next()).uin));
    }
    localIterator = this.ic.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      inx localinx = (inx)localIterator.next();
      if (localHashSet.contains(Long.valueOf(localinx.mUserUin))) {
        break label276;
      }
      VideoController.b localb = new VideoController.b();
      localb.accountType = 0;
      localb.uin = localinx.mUserUin;
      localb.Pn = false;
      localb.timeStamp = localinx.mg;
      VideoController.a(this.this$0).add(localb);
      bool = true;
    }
    label276:
    for (;;)
    {
      break;
      if (bool) {
        this.this$0.mApp.l(new Object[] { Integer.valueOf(708), Long.valueOf(this.kS), Long.valueOf(this.kT), VideoController.a(this.this$0) });
      }
      QLog.d(VideoController.TAG, 1, "InviteMemberList dealInviteMemberRsp memberLists size=" + this.ic.size() + ";change:" + bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.28
 * JD-Core Version:    0.7.0.1
 */