package com.tencent.mobileqq.Doraemon.util;

import tzd;

public final class DoraemonUtil$2
  implements Runnable
{
  public DoraemonUtil$2(tzd paramtzd, int paramInt, String paramString) {}
  
  public void run()
  {
    this.val$callback.onFailure(this.val$code, this.val$msg);
    this.val$callback.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.util.DoraemonUtil.2
 * JD-Core Version:    0.7.0.1
 */