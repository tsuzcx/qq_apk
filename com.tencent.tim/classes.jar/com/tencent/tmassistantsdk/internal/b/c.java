package com.tencent.tmassistantsdk.internal.b;

import com.tencent.assistant.sdk.remote.SDKActionCallback.Stub;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.t;
import java.util.ArrayList;

class c
  extends SDKActionCallback.Stub
{
  c(b paramb) {}
  
  public void onActionResult(byte[] paramArrayOfByte)
  {
    ab.c("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + paramArrayOfByte + "  mListeners.size:" + this.a.a.size());
    t.a().a(paramArrayOfByte, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.b.c
 * JD-Core Version:    0.7.0.1
 */