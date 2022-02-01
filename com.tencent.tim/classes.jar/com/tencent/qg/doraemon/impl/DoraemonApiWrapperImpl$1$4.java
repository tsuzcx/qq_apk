package com.tencent.qg.doraemon.impl;

import asgd;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper.ApiCallback;

public class DoraemonApiWrapperImpl$1$4
  implements Runnable
{
  public DoraemonApiWrapperImpl$1$4(asgd paramasgd) {}
  
  public void run()
  {
    if (this.a.val$apiCallback != null) {
      this.a.val$apiCallback.onComplete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.4
 * JD-Core Version:    0.7.0.1
 */