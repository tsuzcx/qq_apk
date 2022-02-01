package com.tencent.biz.pubaccount.readinjoy.protocol;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import lun;

public class ReadInJoyMSFService$1
  implements Runnable
{
  public ReadInJoyMSFService$1(lun paramlun, ToServiceMsg paramToServiceMsg, WeakReference paramWeakReference) {}
  
  public void run()
  {
    int i = lun.a(this.this$0);
    this.f.getAttributes().put("seq", Integer.valueOf(i));
    lun.a(this.this$0).put(Integer.valueOf(i), this.ch);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.1
 * JD-Core Version:    0.7.0.1
 */