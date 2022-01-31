package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.a.a.a.e;
import com.tencent.tmassistantsdk.f.j;
import java.util.ArrayList;

final class d
  extends e
{
  d(c paramc) {}
  
  public final void a(byte[] paramArrayOfByte)
  {
    j.b("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + paramArrayOfByte + "  mListeners.size:" + this.a.a.size());
    g.a();
    g.a(paramArrayOfByte, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.d
 * JD-Core Version:    0.7.0.1
 */