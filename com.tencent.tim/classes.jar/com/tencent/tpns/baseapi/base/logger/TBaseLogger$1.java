package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;

final class TBaseLogger$1
  implements TBaseLogger.WriteFileCallback
{
  TBaseLogger$1(Context paramContext, String paramString, HttpRequestCallback paramHttpRequestCallback) {}
  
  public void onFinished()
  {
    LogUploadUtil.uploadFile(this.a, this.b, "Logs", "tmp", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.logger.TBaseLogger.1
 * JD-Core Version:    0.7.0.1
 */