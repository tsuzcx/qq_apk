package com.tencent.viola.ui.component;

import com.tencent.viola.core.AudioPlayerManager.AudioManagerListener;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONObject;

class VAudio$1
  implements AudioPlayerManager.AudioManagerListener
{
  VAudio$1(VAudio paramVAudio) {}
  
  public void playBuffering()
  {
    this.this$0.audioChangeFireEvent(5, null);
  }
  
  public void playComplete()
  {
    this.this$0.audioChangeFireEvent(3, null);
  }
  
  public void playError(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("what", paramInt1);
      localJSONObject.put("extra", paramInt2);
      this.this$0.audioChangeFireEvent(4, localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("VComponent", "playError,e:" + localException.getMessage());
      }
    }
  }
  
  public void playPaused()
  {
    this.this$0.audioChangeFireEvent(1, null);
  }
  
  public void playResume()
  {
    this.this$0.audioChangeFireEvent(2, null);
  }
  
  public void playStart()
  {
    this.this$0.audioChangeFireEvent(0, null);
  }
  
  public void playTimeChange(int paramInt1, int paramInt2)
  {
    this.this$0.playTimeChangeFireEvent(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VAudio.1
 * JD-Core Version:    0.7.0.1
 */