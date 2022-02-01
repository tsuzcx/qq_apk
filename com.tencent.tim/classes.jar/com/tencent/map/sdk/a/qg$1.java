package com.tencent.map.sdk.a;

import java.util.Map;

final class qg$1
  implements Runnable
{
  qg$1(qg paramqg, String paramString, qe paramqe, int paramInt) {}
  
  public final void run()
  {
    byte[] arrayOfByte = null;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    qg localqg = this.d;
    String str = this.a;
    Object localObject3 = this.b;
    int i = this.c;
    boolean bool2 = bool4;
    for (;;)
    {
      try
      {
        if (qh.a(i) != qh.a)
        {
          bool2 = bool4;
          Thread.currentThread().setPriority(qh.b(i));
        }
        bool2 = bool4;
        qg.a locala = (qg.a)localqg.a.get(str);
        if (locala != null)
        {
          bool2 = bool4;
          if (locala.d == qg.b.a)
          {
            bool2 = bool4;
            locala.d = qg.b.b;
          }
        }
        bool2 = bool4;
        localObject3 = ((qe)localObject3).a(str);
        if (localObject3 != null)
        {
          bool2 = bool4;
          if (localObject3.length == 0)
          {
            if (locala != null)
            {
              bool2 = bool4;
              if (locala.d == qg.b.c) {
                bool1 = true;
              }
              bool2 = bool1;
              if (locala.d != qg.b.b)
              {
                bool3 = bool1;
                bool2 = bool1;
                if (locala.d != qg.b.d) {}
              }
              else
              {
                bool2 = bool1;
                locala.d = qg.b.d;
                bool3 = bool1;
              }
            }
            bool2 = bool3;
            localqg.a(str, arrayOfByte, bool3);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localqg.a(str, null, bool2);
        return;
      }
      finally
      {
        localqg.a.remove(str);
      }
      Object localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.qg.1
 * JD-Core Version:    0.7.0.1
 */