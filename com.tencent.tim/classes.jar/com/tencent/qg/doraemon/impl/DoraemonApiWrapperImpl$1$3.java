package com.tencent.qg.doraemon.impl;

import asgd;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper.ApiCallback;

public class DoraemonApiWrapperImpl$1$3
  implements Runnable
{
  public DoraemonApiWrapperImpl$1$3(asgd paramasgd, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.a.val$apiCallback != null) {
      this.a.val$apiCallback.onFailure(this.val$code, this.val$msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.3
 * JD-Core Version:    0.7.0.1
 */