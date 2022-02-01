package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import inx;
import izv;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiIncomingCallsActivity$1$1
  implements Runnable
{
  public MultiIncomingCallsActivity$1$1(izv paramizv, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.a.this$0.b != null)
    {
      MultiIncomingCallsActivity.a(this.a.this$0).clear();
      Iterator localIterator = this.is.iterator();
      while (localIterator.hasNext())
      {
        inx localinx = (inx)localIterator.next();
        if (localinx.mUserUin != this.a.this$0.mf) {
          MultiIncomingCallsActivity.a(this.a.this$0).add(localinx);
        }
      }
      MultiIncomingCallsActivity.a(this.a.this$0);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.this$0.TAG, 2, "InviteMemberObserverWithoutCache mMemberChangeEventReceiver size:" + MultiIncomingCallsActivity.a(this.a.this$0).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.1.1
 * JD-Core Version:    0.7.0.1
 */