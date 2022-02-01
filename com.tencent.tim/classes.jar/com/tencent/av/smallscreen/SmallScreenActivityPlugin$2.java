package com.tencent.av.smallscreen;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import ivm;
import ivv;

public class SmallScreenActivityPlugin$2
  implements Runnable
{
  public SmallScreenActivityPlugin$2(ivm paramivm, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    long l = this.kQ;
    BaseApplication localBaseApplication = this.this$0.mApp.getApp();
    if ((this.this$0.Vr) && (this.Vs) && (!this.Vt)) {}
    for (boolean bool = true;; bool = false)
    {
      ivv.a(l, 2, localBaseApplication, bool, this.this$0.mApp.getCurrentAccountUin(), this.Mi);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin.2
 * JD-Core Version:    0.7.0.1
 */