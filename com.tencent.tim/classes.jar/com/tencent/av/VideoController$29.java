package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import inx;
import java.util.ArrayList;
import java.util.Iterator;

class VideoController$29
  implements Runnable
{
  VideoController$29(VideoController paramVideoController, ArrayList paramArrayList, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    VideoController.a(this.this$0).clear();
    Iterator localIterator = this.ic.iterator();
    while (localIterator.hasNext())
    {
      inx localinx = (inx)localIterator.next();
      VideoController.b localb = new VideoController.b();
      localb.accountType = 0;
      localb.uin = localinx.mUserUin;
      localb.Pn = false;
      localb.timeStamp = localinx.mg;
      VideoController.a(this.this$0).add(localb);
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.TAG, 2, "InviteMemberList saveInviteMembers add: member uin:=" + localb.uin);
      }
    }
    this.this$0.mApp.l(new Object[] { Integer.valueOf(708), Long.valueOf(this.kS), Long.valueOf(this.kT), VideoController.a(this.this$0) });
    QLog.d(VideoController.TAG, 1, "InviteMemberList saveInviteMembers + mIviteMemberLists size=" + VideoController.a(this.this$0).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.29
 * JD-Core Version:    0.7.0.1
 */