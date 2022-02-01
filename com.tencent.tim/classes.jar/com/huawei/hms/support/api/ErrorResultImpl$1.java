package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.ResultCallback;

class ErrorResultImpl$1
  implements Runnable
{
  ErrorResultImpl$1(ErrorResultImpl paramErrorResultImpl, ResultCallback paramResultCallback) {}
  
  public void run()
  {
    this.a.onResult(ErrorResultImpl.a(this.b, ErrorResultImpl.a(this.b)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.ErrorResultImpl.1
 * JD-Core Version:    0.7.0.1
 */