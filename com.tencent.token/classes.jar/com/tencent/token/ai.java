package com.tencent.token;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.token.global.e;
import java.util.HashMap;

public final class ai
{
  private static ai a = null;
  private SoundPool b = null;
  private Context c = null;
  private HashMap d = null;
  private boolean e = false;
  private Handler f = null;
  
  public static ai a(Context paramContext)
  {
    int i = 1;
    if (a == null) {
      a = new ai();
    }
    for (;;)
    {
      ai localai;
      try
      {
        localai = a;
        if (localai.c != paramContext)
        {
          localai.c = paramContext;
          localai.b = new SoundPool(1, 3, 100);
          localai.d = new HashMap();
          if (i > 10) {
            break label148;
          }
          int j = localai.b.load(localai.c, 2131099650 + (i - 1), 1);
          if (j == 0) {
            e.c("load audio number=" + i + " fail");
          } else {
            localai.d.put(Integer.valueOf(i), Integer.valueOf(j));
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      for (;;)
      {
        return a;
        label148:
        i = localai.b.load(localai.c, 2131099649, 100);
        if (i == 0) {
          e.c("load audio door_open fail");
        } else {
          localai.d.put(Integer.valueOf(11), Integer.valueOf(i));
        }
      }
      i += 1;
    }
  }
  
  public final int a(int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)this.c.getSystemService("audio");
    float f1 = localAudioManager.getStreamVolume(3) / localAudioManager.getStreamMaxVolume(3);
    return this.b.play(paramInt, f1, f1, 1, 0, 1.0F);
  }
  
  public final void a()
  {
    if (!this.e)
    {
      this.e = true;
      new aj(this).execute(new String[] { "" });
    }
  }
  
  public final void a(int[] paramArrayOfInt)
  {
    e.a("start play token1");
    if (!this.e)
    {
      this.e = true;
      e.a("start play token2");
      new ak(this, paramArrayOfInt).execute(new String[] { Integer.toString(0) });
    }
  }
  
  public final void b()
  {
    this.b.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ai
 * JD-Core Version:    0.7.0.1
 */