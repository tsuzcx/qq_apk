package com.tencent.token;

import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.h;
import java.util.HashMap;

class db
  extends AsyncTask
{
  private int c = 0;
  
  db(cz paramcz, int[] paramArrayOfInt) {}
  
  public String a(String... paramVarArgs)
  {
    try
    {
      if (paramVarArgs.length > 0) {
        this.c = Integer.parseInt(paramVarArgs[0]);
      }
      h.a("start play token3");
      int i = 0;
      while (i < this.a.length)
      {
        paramVarArgs = (Integer)cz.a(this.b).get(Integer.valueOf(this.a[i] + 1));
        if (paramVarArgs == null)
        {
          h.c("token number index=" + i + ",value=" + this.a[i] + " get sound error");
          return "";
        }
        int j = this.b.a(paramVarArgs.intValue());
        Thread.sleep(600L);
        cz.b(this.b).stop(j);
        i += 1;
      }
      cz.a(this.b, false);
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        h.c("run exception msg=" + paramVarArgs.getMessage());
      }
    }
    return "";
  }
  
  public void a(String paramString)
  {
    if ((cz.c(this.b) != null) && (1 == this.c))
    {
      paramString = new Message();
      paramString.what = 200;
      cz.c(this.b).sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.db
 * JD-Core Version:    0.7.0.1
 */