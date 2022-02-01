package com.tencent.mobileqq.apollo;

import abhh;
import abiv;
import abuj;
import abxi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(abiv paramabiv) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (abiv.a(this.this$0) != null)
    {
      abiv.a(this.this$0).BA(abhh.bfW);
      abiv.a(this.this$0).BA(abhh.bfV);
      String str = abuj.m(new File(abxi.biF + "preload.js"));
      abiv.a(this.this$0).BA(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */