package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import anqo;
import aojs;
import aoko;
import aqiw;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(aojs paramaojs, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    aoko localaoko;
    if ((anqo.b(this.this$0.b.filePath) != 0) && (!this.this$0.cMj))
    {
      localaoko = this.this$0.b;
      aojs localaojs = this.this$0;
      long l = System.nanoTime();
      localaojs.mStartTime = l;
      localaoko.startTime = l;
      this.this$0.cMj = true;
    }
    this.this$0.app.a().a(this.val$selfUin, aojs.a(this.this$0), this.this$0.b.filePath, this.at, aojs.a(this.this$0), aojs.a(this.this$0), this.this$0.voiceType, this.this$0.voiceLength, this.apA, this.val$params);
    this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), true, aqiw.getNetworkType(this.this$0.app.getApp()), 2, 0, anqo.a(this.this$0.b.filePath, this.at));
    if (!this.cMk)
    {
      localaoko = this.this$0.b;
      localaoko.transferedSize += anqo.a(this.this$0.b.filePath, this.at);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */