package com.tencent.mobileqq.triton.audio;

import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;

class e$b$a
  implements ITDownloadListener
{
  e$b$a(e.b paramb) {}
  
  public void onCancel(String paramString)
  {
    paramString = this.a.b;
    if (paramString != null) {
      paramString.onError(10002);
    }
  }
  
  public void onFail(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = this.a.b;
    if (paramString1 != null) {
      paramString1.onError(10002);
    }
  }
  
  public void onProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onSuccess(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.d = paramString3;
    TTLog.c("[audio] TTAudioPlayerManager", "download rawPath:" + this.a.c + " success, localPath:" + this.a.d);
    a.a().a(new e.b.a.a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.e.b.a
 * JD-Core Version:    0.7.0.1
 */