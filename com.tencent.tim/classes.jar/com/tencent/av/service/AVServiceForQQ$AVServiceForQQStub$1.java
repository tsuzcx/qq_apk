package com.tencent.av.service;

import com.tencent.qphone.base.util.QLog;

class AVServiceForQQ$AVServiceForQQStub$1
  implements Runnable
{
  AVServiceForQQ$AVServiceForQQStub$1(AVServiceForQQ.a parama) {}
  
  public void run()
  {
    try
    {
      this.b.a.startForeground(235, this.b.a.a);
      QLog.d(this.b.a.TAG, 1, "setAvServiceForegroud start foreground.");
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.b.a.TAG, 1, "setAVServiceForegroud, e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.1
 * JD-Core Version:    0.7.0.1
 */