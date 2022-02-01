package com.tencent.mobileqq.intervideo.now.dynamic;

import aifc;
import aigd;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class NowEntry$3
  implements Runnable
{
  public NowEntry$3(aigd paramaigd, AtomicBoolean paramAtomicBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.this$0.a.b("download_cover").c("2").report();
    if (!this.dh.get())
    {
      QLog.i("DynamicNow | NowEntry", 1, "download cover pic timeout!");
      this.dh.set(true);
      aigd.a(this.this$0, this.val$extras);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.3
 * JD-Core Version:    0.7.0.1
 */