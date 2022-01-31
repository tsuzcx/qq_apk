package com.tencent.token;

import android.media.SoundPool;
import android.os.AsyncTask;
import com.tencent.token.global.e;
import java.util.HashMap;

final class ak
  extends AsyncTask
{
  private int c = 0;
  
  ak(ai paramai, int[] paramArrayOfInt) {}
  
  private String a(String... paramVarArgs)
  {
    try
    {
      if (paramVarArgs.length > 0) {
        this.c = Integer.parseInt(paramVarArgs[0]);
      }
      e.a("start play token3");
      int i = 0;
      while (i < this.a.length)
      {
        paramVarArgs = (Integer)ai.a(this.b).get(Integer.valueOf(this.a[i] + 1));
        if (paramVarArgs == null)
        {
          e.c("token number index=" + i + ",value=" + this.a[i] + " get sound error");
          return "";
        }
        int j = this.b.a(paramVarArgs.intValue());
        Thread.sleep(600L);
        ai.b(this.b).stop(j);
        i += 1;
      }
      ai.c(this.b);
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        e.c("run exception msg=" + paramVarArgs.getMessage());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ak
 * JD-Core Version:    0.7.0.1
 */