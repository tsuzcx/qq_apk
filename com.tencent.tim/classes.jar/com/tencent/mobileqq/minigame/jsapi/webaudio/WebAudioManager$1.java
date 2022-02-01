package com.tencent.mobileqq.minigame.jsapi.webaudio;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;

class WebAudioManager$1
  implements Runnable
{
  WebAudioManager$1(WebAudioManager paramWebAudioManager, int paramInt1, int paramInt2, JsRuntime paramJsRuntime, int paramInt3) {}
  
  public void run()
  {
    if (WebAudioManager.access$000(this.this$0) != null)
    {
      WebAudioManager.access$000(this.this$0).play(this.val$sourceId, this.val$offset);
      WebAudioManager.access$100(this.this$0, this.val$jsRuntime, this.val$sourceId, this.val$audioId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.1
 * JD-Core Version:    0.7.0.1
 */