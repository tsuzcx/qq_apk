package com.google.android.exoplayer2.ext.mediaplayer;

import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultAllocator;

public class QLoadControl
  extends DefaultLoadControl
{
  public static final String LOG_TAG = "QLoadControl";
  private static int sBufferForPlaybackMs = 2500;
  private static int sBufferForPlaybackRebufferMs = 5000;
  private static int sBufferSegmentSize = 65536;
  private static int sMaxBufferMs;
  private static int sMinBufferMs = 15000;
  
  static
  {
    sMaxBufferMs = 30000;
  }
  
  public QLoadControl()
  {
    super(new DefaultAllocator(true, sBufferSegmentSize), sMinBufferMs, sMaxBufferMs, sBufferForPlaybackMs, sBufferForPlaybackRebufferMs, -1, true);
  }
  
  static void updateConfig(Config paramConfig)
  {
    if (paramConfig == null)
    {
      Log.v("QLoadControl", "updateConfig config null");
      return;
    }
    sBufferSegmentSize = paramConfig.bufferSegmentSize;
    sMinBufferMs = paramConfig.minBufferMs;
    sMaxBufferMs = paramConfig.maxBufferMs;
    sBufferForPlaybackMs = paramConfig.bufferForPlaybackMs;
    sBufferForPlaybackRebufferMs = paramConfig.bufferForPlaybackRebufferMs;
    Log.v("QLoadControl", "updateConfig with config " + paramConfig);
  }
  
  static void updateConfig(String paramString)
  {
    Log.v("QLoadControl", "updateConfig configStr=" + paramString);
    String[] arrayOfString = paramString.split(",");
    Config localConfig = new Config();
    try
    {
      if (arrayOfString.length > 0) {
        Config.access$002(localConfig, Integer.parseInt(arrayOfString[0]));
      }
      if (arrayOfString.length > 1) {
        Config.access$102(localConfig, Integer.parseInt(arrayOfString[1]));
      }
      if (arrayOfString.length > 2) {
        Config.access$202(localConfig, Integer.parseInt(arrayOfString[2]));
      }
      if (arrayOfString.length > 3) {
        Config.access$302(localConfig, Integer.parseInt(arrayOfString[3]));
      }
      if (arrayOfString.length > 4) {
        Config.access$402(localConfig, Integer.parseInt(arrayOfString[4]));
      }
      updateConfig(localConfig);
      return;
    }
    catch (Exception localException)
    {
      Log.v("QLoadControl", "invalid qloadcontrol configStr=" + paramString);
    }
  }
  
  public int calculateTargetBufferSize(Renderer[] paramArrayOfRenderer, TrackSelectionArray paramTrackSelectionArray)
  {
    return super.calculateTargetBufferSize(paramArrayOfRenderer, paramTrackSelectionArray);
  }
  
  public boolean shouldContinueLoading(long paramLong, float paramFloat)
  {
    return super.shouldContinueLoading(paramLong, paramFloat);
  }
  
  public boolean shouldStartPlayback(long paramLong, float paramFloat, boolean paramBoolean)
  {
    return super.shouldStartPlayback(paramLong, paramFloat, paramBoolean);
  }
  
  public static class Config
  {
    private int bufferForPlaybackMs = 2500;
    private int bufferForPlaybackRebufferMs = 5000;
    private int bufferSegmentSize = 65536;
    private int maxBufferMs = 30000;
    private int minBufferMs = 15000;
    
    public String toString()
    {
      return "QLoadControl.Config[bufferSegmentSize=" + this.bufferSegmentSize + ",minBufferMs=" + this.minBufferMs + ",maxBufferMs=" + this.maxBufferMs + ",bufferForPlaybackMs=" + this.bufferForPlaybackMs + ",bufferForPlaybackRebufferMs=" + this.bufferForPlaybackRebufferMs + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.QLoadControl
 * JD-Core Version:    0.7.0.1
 */