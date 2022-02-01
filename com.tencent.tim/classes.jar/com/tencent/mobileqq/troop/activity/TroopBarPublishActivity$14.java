package com.tencent.mobileqq.troop.activity;

import aouw;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import pog;

public class TroopBarPublishActivity$14
  implements Runnable
{
  TroopBarPublishActivity$14(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    this.this$0.k = pog.a(this.vh);
    this.this$0.a.cOh = this.this$0.k.isLocalPublish;
    if (this.this$0.k.isLocalPublish)
    {
      TroopBarPublishActivity.a(this.this$0, this.val$videoPath, this.aqB);
      return;
    }
    this.this$0.k.videoNeedRotate = true;
    pog localpog = new pog();
    aouw localaouw = new aouw(this);
    localpog.a(this.this$0.k, this.val$videoPath + ".tmp.mp4", false, true, localaouw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.14
 * JD-Core Version:    0.7.0.1
 */