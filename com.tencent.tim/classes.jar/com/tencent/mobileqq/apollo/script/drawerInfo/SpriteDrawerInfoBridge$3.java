package com.tencent.mobileqq.apollo.script.drawerInfo;

import abqt;
import abrc;
import abrr;

public class SpriteDrawerInfoBridge$3
  implements Runnable
{
  public SpriteDrawerInfoBridge$3(abrr paramabrr, abqt paramabqt, abrc paramabrc) {}
  
  public void run()
  {
    if ((this.a != null) && (this.b != null))
    {
      this.a.bv(this.b.mSelfUin, false);
      this.a.bv(this.b.mFriendUin, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3
 * JD-Core Version:    0.7.0.1
 */