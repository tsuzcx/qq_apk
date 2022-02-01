package com.tencent.mobileqq.minigame.jsapi.webaudio;

import android.os.Build.VERSION;
import android.os.Environment;
import aqhq;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.io.File;

class WebAudioManager$5
  implements Runnable
{
  WebAudioManager$5(WebAudioManager paramWebAudioManager, int paramInt, JsRuntime paramJsRuntime, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    GameLog.getInstance().d("decodeWebAudioData", "decodeId:" + this.val$decodeId + " new AudioDecoder And start decode");
    AudioDecoder localAudioDecoder = new AudioDecoder();
    localAudioDecoder.setOnDecodeProcessListener(new WebAudioManager.5.1(this, localAudioDecoder));
    if (Build.VERSION.SDK_INT >= 23) {
      localAudioDecoder.decodeInMemory(this.val$audioData, this.val$decodeId);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    String str = Environment.getExternalStorageDirectory().getPath() + "/minigame/audio_" + System.currentTimeMillis();
    aqhq.writeFile(this.val$audioData, str);
    localAudioDecoder.decodeByPath(str, this.val$decodeId);
    aqhq.deleteFile(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.5
 * JD-Core Version:    0.7.0.1
 */