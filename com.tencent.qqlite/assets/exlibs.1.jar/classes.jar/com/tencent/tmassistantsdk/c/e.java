package com.tencent.tmassistantsdk.c;

import com.tencent.tmassistantsdk.downloadservice.c;
import com.tencent.tmassistantsdk.downloadservice.l;
import com.tencent.tmassistantsdk.f.k;

final class e
  implements l
{
  e(d paramd) {}
  
  public final void e()
  {
    k.b("LogReportManager", "onNetworkChanged,netState:" + c.b());
    Class[] arrayOfClass = d.e();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(a.class)) {
            a.a().g();
          } else if (localClass.equals(f.class)) {
            f.a().g();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      else
      {
        if (c.c()) {
          c.b().equalsIgnoreCase("wifi");
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.e
 * JD-Core Version:    0.7.0.1
 */