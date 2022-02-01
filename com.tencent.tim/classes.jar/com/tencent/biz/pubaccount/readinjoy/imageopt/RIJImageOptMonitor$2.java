package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Arrays;
import jle.a;
import lgk;
import noz;

public final class RIJImageOptMonitor$2
  implements Runnable
{
  public RIJImageOptMonitor$2(noz paramnoz) {}
  
  public void run()
  {
    if ((this.b != null) && (this.b.url != null))
    {
      String str = this.b.url.toString();
      String[] arrayOfString = lgk.f(this.b.url.getHost());
      int i = jle.a.ay(str);
      QLog.d("RIJImageOptMonitor", 1, "ping url: " + str + " ip: " + Arrays.toString(arrayOfString) + " time: " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.2
 * JD-Core Version:    0.7.0.1
 */