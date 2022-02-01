package com.tencent.qg.doraemon.impl;

import asgd;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper.ApiCallback;

public class DoraemonApiWrapperImpl$1$1
  implements Runnable
{
  public DoraemonApiWrapperImpl$1$1(asgd paramasgd, int paramInt) {}
  
  public void run()
  {
    if (this.a.val$apiCallback != null) {
      this.a.val$apiCallback.onPermission(this.val$code);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl.1.1
 * JD-Core Version:    0.7.0.1
 */