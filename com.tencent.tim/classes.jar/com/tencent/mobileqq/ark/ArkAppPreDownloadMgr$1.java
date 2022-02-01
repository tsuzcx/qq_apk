package com.tencent.mobileqq.ark;

import adqy;
import aeix;
import aeix.e;
import aeiy;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(adqy paramadqy) {}
  
  public void run()
  {
    aeix.e locale = aeiy.b(380).a();
    if ((locale == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    adqy.a(this.this$0).clear();
    this.this$0.a(locale);
    adqy.a(this.this$0);
    this.this$0.cTR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */