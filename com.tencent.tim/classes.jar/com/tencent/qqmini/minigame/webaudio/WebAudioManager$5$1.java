package com.tencent.qqmini.minigame.webaudio;

import android.media.MediaFormat;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$5$1
  implements AudioDecoder.onDecodeProcessListener
{
  WebAudioManager$5$1(WebAudioManager.5 param5, AudioDecoder paramAudioDecoder) {}
  
  public void onDecodeProcess(byte[] paramArrayOfByte, MediaFormat paramMediaFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    WebAudioManager.DecodeAsPlayStatus localDecodeAsPlayStatus;
    synchronized ()
    {
      if (WebAudioManager.access$000(this.this$1.this$0) == null) {
        return;
      }
      if (!WebAudioManager.access$300(this.this$1.this$0).containsKey(Integer.valueOf(this.this$1.val$decodeId))) {
        WebAudioManager.access$300(this.this$1.this$0).put(Integer.valueOf(this.this$1.val$decodeId), new WebAudioManager.DecodeAsPlayStatus(this.this$1.this$0));
      }
      localDecodeAsPlayStatus = (WebAudioManager.DecodeAsPlayStatus)WebAudioManager.access$300(this.this$1.this$0).get(Integer.valueOf(this.this$1.val$decodeId));
      ArrayList localArrayList = (ArrayList)WebAudioManager.access$400(this.this$1.this$0).get(Integer.valueOf(this.this$1.val$decodeId));
      paramMediaFormat = localArrayList;
      if (localArrayList == null) {
        paramMediaFormat = new ArrayList();
      }
      if (paramBoolean2)
      {
        WebAudioManager.DecodeAsPlayStatus.access$502(localDecodeAsPlayStatus, 3);
        return;
      }
    }
    int i = WebAudioManager.access$000(this.this$1.this$0).loadRawData(paramArrayOfByte, this.val$audioDecoder.getSampleRate(), this.val$audioDecoder.getChannelCount(), this.val$audioDecoder.getBitsPerChannel());
    paramMediaFormat.add(Integer.valueOf(i));
    WebAudioManager.access$400(this.this$1.this$0).put(Integer.valueOf(this.this$1.val$decodeId), paramMediaFormat);
    switch (WebAudioManager.DecodeAsPlayStatus.access$500(localDecodeAsPlayStatus))
    {
    }
    for (;;)
    {
      if (paramBoolean1) {
        paramArrayOfByte = new JSONObject();
      }
      try
      {
        paramArrayOfByte.put("decodeId", this.this$1.val$decodeId);
        paramArrayOfByte.put("status", "ok");
        if (this.this$1.val$req != null) {
          this.this$1.val$req.jsService.evaluateSubscribeJS("onDecodeWebAudioDataDone", paramArrayOfByte.toString(), 0);
        }
        return;
        WebAudioManager.DecodeAsPlayStatus.access$502(localDecodeAsPlayStatus, 1);
        continue;
        paramArrayOfByte = WebAudioManager.DecodeAsPlayStatus.access$600(localDecodeAsPlayStatus);
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
        {
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            int j = ((Integer)paramArrayOfByte.next()).intValue();
            WebAudioManager.access$000(this.this$1.this$0).setQueueBuffer(j, i);
          }
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.webaudio.WebAudioManager.5.1
 * JD-Core Version:    0.7.0.1
 */