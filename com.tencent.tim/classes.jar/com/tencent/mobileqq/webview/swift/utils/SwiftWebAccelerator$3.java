package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import arbz;
import arcn;
import arcn.a;
import com.tencent.qphone.base.util.QLog;

public class SwiftWebAccelerator$3
  implements Runnable
{
  public SwiftWebAccelerator$3(arcn paramarcn, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    arcn.a.init();
    arbz.ave = System.currentTimeMillis() - this.val$startTime;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on sub thread, cost " + arbz.ave + "ms.");
    this.this$0.dD(this.bv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3
 * JD-Core Version:    0.7.0.1
 */