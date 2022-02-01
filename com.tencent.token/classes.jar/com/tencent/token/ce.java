package com.tencent.token;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.g;
import java.util.HashMap;

public class ce
{
  private static ce a;
  private SoundPool b = null;
  private Context c = null;
  private HashMap<Integer, Integer> d = null;
  private boolean e = false;
  private Handler f = null;
  
  public static ce a(Context paramContext)
  {
    if (a == null)
    {
      a = new ce();
      try
      {
        a.b(paramContext);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return a;
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
    while (i <= 10)
    {
      int j = this.b.load(this.c, i - 1 + 2131427329, 1);
      if (j == 0)
      {
        paramContext = new StringBuilder();
        paramContext.append("load audio number=");
        paramContext.append(i);
        paramContext.append(" fail");
        g.c(paramContext.toString());
      }
      else
      {
        this.d.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      i += 1;
    }
    i = this.b.load(this.c, 2131427328, 100);
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
            paramAnonymousVarArgs = (Integer)ce.a(ce.this).get(Integer.valueOf(11));
            if (paramAnonymousVarArgs == null) {
              return null;
            }
            int i = ce.this.a(paramAnonymousVarArgs.intValue());
            Thread.sleep(600L);
            ce.b(ce.this).stop(i);
            ce.a(ce.this, false);
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
              paramAnonymousVarArgs = (Integer)ce.a(ce.this).get(Integer.valueOf(paramArrayOfInt[i] + 1));
              if (paramAnonymousVarArgs == null)
              {
                paramAnonymousVarArgs = new StringBuilder();
                paramAnonymousVarArgs.append("token number index=");
                paramAnonymousVarArgs.append(i);
                paramAnonymousVarArgs.append(",value=");
                paramAnonymousVarArgs.append(paramArrayOfInt[i]);
                paramAnonymousVarArgs.append(" get sound error");
                g.c(paramAnonymousVarArgs.toString());
                return "";
              }
              int j = ce.this.a(paramAnonymousVarArgs.intValue());
              Thread.sleep(600L);
              ce.b(ce.this).stop(j);
              i += 1;
            }
            ce.a(ce.this, false);
          }
          catch (Exception paramAnonymousVarArgs)
          {
            paramAnonymousVarArgs.printStackTrace();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("run exception msg=");
            localStringBuilder.append(paramAnonymousVarArgs.getMessage());
            g.c(localStringBuilder.toString());
          }
          return "";
        }
        
        public void a(String paramAnonymousString)
        {
          if ((ce.c(ce.this) != null) && (1 == this.c))
          {
            paramAnonymousString = new Message();
            paramAnonymousString.what = 200;
            ce.c(ce.this).sendMessage(paramAnonymousString);
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
 * Qualified Name:     com.tencent.token.ce
 * JD-Core Version:    0.7.0.1
 */