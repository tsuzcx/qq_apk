package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import ixs;

public class BaseInviteFloatBarUICtr$2
  implements Runnable
{
  public BaseInviteFloatBarUICtr$2(ixs paramixs) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "timeout~ mPeerUin:" + this.this$0.mPeerUin);
    }
    this.this$0.asc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr.2
 * JD-Core Version:    0.7.0.1
 */