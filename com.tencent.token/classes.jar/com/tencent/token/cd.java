package com.tencent.token;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.g;
import java.util.HashMap;

public class cd
{
  private static cd a = null;
  private SoundPool b = null;
  private Context c = null;
  private HashMap<Integer, Integer> d = null;
  private boolean e = false;
  private Handler f = null;
  
  public static cd a(Context paramContext)
  {
    if (a == null) {
      a = new cd();
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
        g.c("load audio number=" + i + " fail");
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
      g.c("load audio door_open fail");
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
      new AsyncTask()
      {
        public String a(String... paramAnonymousVarArgs)
        {
          try
          {
            paramAnonymousVarArgs = (Integer)cd.a(cd.this).get(Integer.valueOf(11));
            if (paramAnonymousVarArgs == null) {
              return null;
            }
            int i = cd.this.a(paramAnonymousVarArgs.intValue());
            Thread.sleep(600L);
            cd.b(cd.this).stop(i);
            cd.a(cd.this, false);
            return null;
          }
          catch (Exception paramAnonymousVarArgs) {}
          return null;
        }
      }.execute(new String[] { "" });
    }
  }
  
  public void a(final int[] paramArrayOfInt, int paramInt)
  {
    g.a("start play token1");
    if (!this.e)
    {
      this.e = true;
      g.a("start play token2");
      new AsyncTask()
      {
        private int c = 0;
        
        public String a(String... paramAnonymousVarArgs)
        {
          try
          {
            if (paramAnonymousVarArgs.length > 0) {
              this.c = Integer.parseInt(paramAnonymousVarArgs[0]);
            }
            g.a("start play token3");
            int i = 0;
            while (i < paramArrayOfInt.length)
            {
              paramAnonymousVarArgs = (Integer)cd.a(cd.this).get(Integer.valueOf(paramArrayOfInt[i] + 1));
              if (paramAnonymousVarArgs == null)
              {
                g.c("token number index=" + i + ",value=" + paramArrayOfInt[i] + " get sound error");
                return "";
              }
              int j = cd.this.a(paramAnonymousVarArgs.intValue());
              Thread.sleep(600L);
              cd.b(cd.this).stop(j);
              i += 1;
            }
            cd.a(cd.this, false);
          }
          catch (Exception paramAnonymousVarArgs)
          {
            for (;;)
            {
              paramAnonymousVarArgs.printStackTrace();
              g.c("run exception msg=" + paramAnonymousVarArgs.getMessage());
            }
          }
          return "";
        }
        
        public void a(String paramAnonymousString)
        {
          if ((cd.c(cd.this) != null) && (1 == this.c))
          {
            paramAnonymousString = new Message();
            paramAnonymousString.what = 200;
            cd.c(cd.this).sendMessage(paramAnonymousString);
          }
        }
      }.execute(new String[] { Integer.toString(paramInt) });
    }
  }
  
  public void b()
  {
    this.b.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cd
 * JD-Core Version:    0.7.0.1
 */