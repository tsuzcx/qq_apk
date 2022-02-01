package com.tencent.mobileqq.Doraemon.util;

import org.json.JSONObject;
import tzd;

public final class DoraemonUtil$1
  implements Runnable
{
  public DoraemonUtil$1(tzd paramtzd, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.val$callback.onSuccess(this.val$result);
    this.val$callback.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.util.DoraemonUtil.1
 * JD-Core Version:    0.7.0.1
 */