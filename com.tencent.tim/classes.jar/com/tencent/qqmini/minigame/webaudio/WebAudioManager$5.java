package com.tencent.qqmini.minigame.webaudio;

import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;

class WebAudioManager$5
  implements Runnable
{
  WebAudioManager$5(WebAudioManager paramWebAudioManager, int paramInt, RequestEvent paramRequestEvent, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    AudioDecoder localAudioDecoder = new AudioDecoder();
    localAudioDecoder.setOnDecodeProcessListener(new WebAudioManager.5.1(this, localAudioDecoder));
    if (Build.VERSION.SDK_INT >= 23) {
      localAudioDecoder.decodeInMemory(this.val$audioData, this.val$decodeId);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    String str = Environment.getExternalStorageDirectory().getPath() + "/minigame/audio_" + System.currentTimeMillis();
    FileUtils.writeFile(this.val$audioData, str);
    localAudioDecoder.decodeByPath(str, this.val$decodeId);
    FileUtils.deleteFile(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.webaudio.WebAudioManager.5
 * JD-Core Version:    0.7.0.1
 */