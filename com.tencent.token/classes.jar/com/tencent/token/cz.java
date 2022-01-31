package com.tencent.token;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.token.global.h;
import java.util.HashMap;

public class cz
{
  private static cz a = null;
  private SoundPool b = null;
  private Context c = null;
  private HashMap d = null;
  private boolean e = false;
  private Handler f = null;
  
  public static cz a(Context paramContext)
  {
    if (a == null) {
      a = new cz();
    }
    try
    {
      a.b(paramContext);
      return a;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void b(Context paramContext)
  {
    if (this.c == paramContext) {
      return;
    }
    this.c = paramContext;
    this.b = new SoundPool(1, 3, 100);
    this.d = new HashMap();
    int i = 1;
    if (i <= 10)
    {
      int j = this.b.load(this.c, 2131165185 + (i - 1), 1);
      if (j == 0) {
        h.c("load audio number=" + i + " fail");
      }
      for (;;)
      {
        i += 1;
        break;
        this.d.put(Integer.valueOf(i), Integer.valueOf(j));
      }
    }
    i = this.b.load(this.c, 2131165184, 100);
    if (i == 0)
    {
      h.c("load audio door_open fail");
      return;
    }
    this.d.put(Integer.valueOf(11), Integer.valueOf(i));
  }
  
  public int a(int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)this.c.getSystemService("audio");
    float f1 = localAudioManager.getStreamVolume(3) / localAudioManager.getStreamMaxVolume(3);
    return this.b.play(paramInt, f1, f1, 1, 0, 1.0F);
  }
  
  public void a()
  {
    if (!this.e)
    {
      this.e = true;
      new da(this).execute(new String[] { "" });
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    h.a("start play token1");
    if (!this.e)
    {
      this.e = true;
      h.a("start play token2");
      new db(this, paramArrayOfInt).execute(new String[] { Integer.toString(paramInt) });
    }
  }
  
  public void b()
  {
    this.b.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cz
 * JD-Core Version:    0.7.0.1
 */