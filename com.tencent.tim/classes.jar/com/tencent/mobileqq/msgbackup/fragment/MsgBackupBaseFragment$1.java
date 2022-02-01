package com.tencent.mobileqq.msgbackup.fragment;

import android.os.Message;
import aqiw;
import mqq.os.MqqHandler;

class MsgBackupBaseFragment$1
  implements Runnable
{
  MsgBackupBaseFragment$1(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void run()
  {
    int j = 1;
    Message localMessage;
    if (aqiw.getSystemNetwork(this.this$0.getActivity()) == 1)
    {
      i = 1;
      localMessage = this.this$0.mUIHandler.obtainMessage(10012);
      if (i == 0) {
        break label76;
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localMessage.arg1 = i;
      this.this$0.mUIHandler.sendMessage(localMessage);
      this.this$0.t.postDelayed(this, 800L);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */