package com.tencent.av;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoController$30
  implements Runnable
{
  VideoController$30(VideoController paramVideoController) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    long l = AudioHelper.hF() / 1000L;
    Iterator localIterator = VideoController.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      VideoController.b localb = (VideoController.b)localIterator.next();
      if ((localb.Pn) || (localb.timeStamp + 60L > l)) {
        localArrayList.add(localb);
      }
    }
    if (localArrayList.size() != VideoController.a(this.this$0).size())
    {
      VideoController.a(this.this$0, localArrayList);
      this.this$0.mApp.l(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), VideoController.a(this.this$0) });
    }
    this.this$0.mApp.getHandler().postDelayed(VideoController.a(this.this$0), 10000L);
    QLog.d(VideoController.TAG, 1, "InviteMemberList call mRemoveUnAttenedMember");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.30
 * JD-Core Version:    0.7.0.1
 */