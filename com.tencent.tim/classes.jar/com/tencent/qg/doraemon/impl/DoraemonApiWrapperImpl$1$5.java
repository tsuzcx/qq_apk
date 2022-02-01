package com.tencent.qg.doraemon.impl;

import asgd;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper.ApiCallback;
import org.json.JSONObject;

public class DoraemonApiWrapperImpl$1$5
  implements Runnable
{
  public DoraemonApiWrapperImpl$1$5(asgd paramasgd, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.a.val$apiCallback != null) {
      this.a.val$apiCallback.onTrigger(this.val$result.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.5
 * JD-Core Version:    0.7.0.1
 */