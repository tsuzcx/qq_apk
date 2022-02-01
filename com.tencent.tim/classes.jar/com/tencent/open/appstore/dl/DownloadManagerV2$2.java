package com.tencent.open.appstore.dl;

import android.content.Context;
import android.content.IntentFilter;
import aroi;
import arvv;

public class DownloadManagerV2$2
  implements Runnable
{
  public DownloadManagerV2$2(arvv paramarvv, IntentFilter paramIntentFilter1, IntentFilter paramIntentFilter2) {}
  
  public void run()
  {
    aroi.a().getContext().registerReceiver(arvv.a(this.this$0), this.f);
    aroi.a().getContext().registerReceiver(arvv.a(this.this$0), this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.2
 * JD-Core Version:    0.7.0.1
 */