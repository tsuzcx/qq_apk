package com.tencent.token;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Handler;
import java.util.HashMap;

public final class se
{
  private static se c;
  public SoundPool a = null;
  public boolean b = false;
  private Context d = null;
  private HashMap<Integer, Integer> e = null;
  private Handler f = null;
  
  public static se a(Context paramContext)
  {
    if (c == null) {
      c = new se();
    }
    for (;;)
    {
      int i;
      try
      {
        se localse = c;
        if (localse.d != paramContext)
        {
          localse.d = paramContext;
          localse.a = new SoundPool(1, 3, 100);
          localse.e = new HashMap();
          i = 1;
          if (i <= 10)
          {
            int j = localse.a.load(localse.d, i - 1 + 2131427329, 1);
            if (j == 0)
            {
              paramContext = new StringBuilder("load audio number=");
              paramContext.append(i);
              paramContext.append(" fail");
              xb.c(paramContext.toString());
              break label199;
            }
            localse.e.put(Integer.valueOf(i), Integer.valueOf(j));
            break label199;
          }
          i = localse.a.load(localse.d, 2131427328, 100);
          if (i == 0) {
            xb.c("load audio door_open fail");
          } else {
            localse.e.put(Integer.valueOf(11), Integer.valueOf(i));
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return c;
      label199:
      i += 1;
    }
  }
  
  public final int a(int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)this.d.getSystemService("audio");
    float f1 = localAudioManager.getStreamVolume(3) / localAudioManager.getStreamMaxVolume(3);
    return this.a.play(paramInt, f1, f1, 1, 0, 1.0F);
  }
  
  public final void a()
  {
    if (!this.b)
    {
      this.b = true;
      new AsyncTask()
      {
        private String a()
        {
          try
          {
            Integer localInteger = (Integer)se.a(se.this).get(Integer.valueOf(11));
            if (localInteger == null) {
              return null;
            }
            int i = se.this.a(localInteger.intValue());
            Thread.sleep(600L);
            se.b(se.this).stop(i);
            se.c(se.this);
            return null;
          }
          catch (Exception localException) {}
          return null;
        }
      }.execute(new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.se
 * JD-Core Version:    0.7.0.1
 */