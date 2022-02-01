package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import com.tencent.mobileqq.triton.engine.TTLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class d
{
  private static d b;
  private ConcurrentLinkedQueue<MediaPlayer> a = new ConcurrentLinkedQueue();
  
  public static d b()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new d();
      }
      return b;
    }
    finally {}
  }
  
  public MediaPlayer a()
  {
    Object localObject2 = (MediaPlayer)this.a.poll();
    if (localObject2 == null)
    {
      try
      {
        localObject1 = new MediaPlayer();
        TTLog.b("[audio] MediaPlayerManager", "new MediaPlayer on dequeue - exception. ", (Throwable)localObject2);
      }
      finally
      {
        try
        {
          TTLog.d("[audio] MediaPlayerManager", "new MediaPlayer on dequeue. " + localObject1);
          return localObject1;
        }
        finally
        {
          Object localObject1;
          break label55;
        }
        localObject3 = finally;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      label55:
      return localObject1;
    }
    return localMediaPlayer;
  }
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      this.a.add(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.d
 * JD-Core Version:    0.7.0.1
 */