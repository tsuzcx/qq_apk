package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import iiv;
import ixb;

public class AVActivity$1$1
  implements Runnable
{
  public AVActivity$1$1(ixb paramixb) {}
  
  public void run()
  {
    if ((this.a.this$0.mApp != null) && (this.a.this$0.a != null) && (this.a.this$0.a.b() != null)) {
      this.a.this$0.a.b().setPhoneNum(this.a.this$0.mApp.di(this.a.this$0.mPeerUin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.1.1
 * JD-Core Version:    0.7.0.1
 */