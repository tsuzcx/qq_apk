package com.tencent.mobileqq.troop.filemanager.download;

import apef.b;
import apfa;
import aqiw;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileDownloader$1
  implements Runnable
{
  public TroopFileDownloader$1(apfa paramapfa) {}
  
  public void run()
  {
    if (this.this$0.mIsStop) {
      apef.b.w("TroopFileDownloader", apef.b.USR, "[" + this.this$0.mSessionId + "] download. had stoped");
    }
    while (this.this$0.aAW()) {
      return;
    }
    if (!this.this$0.aAX())
    {
      this.this$0.g(true, -5001, "file open exception", "");
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.this$0.g(true, 9004, "no network", "");
      return;
    }
    this.this$0.dZc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */