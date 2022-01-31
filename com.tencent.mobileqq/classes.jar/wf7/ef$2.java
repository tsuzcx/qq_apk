package wf7;

import java.util.ArrayList;
import java.util.Iterator;

class ef$2
  implements em.a
{
  ef$2(ef paramef, int paramInt, dl paramdl) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ae> paramArrayList)
  {
    paramInt2 = 0;
    if (paramInt1 != 0)
    {
      el.cP().a("GuidCertifier", 10002, this.mb, null, 30, paramInt1);
      el.cP().aj(this.mb);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      paramInt1 = -21250000;
    }
    for (;;)
    {
      el.cP().a("GuidCertifier", 10002, this.mb, null, 30, paramInt1);
      el.cP().aj(this.mb);
      return;
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          ae localae = (ae)paramArrayList.next();
          if ((localae != null) && (10002 == localae.bH))
          {
            if (localae.cc != 0)
            {
              paramInt1 = localae.cc;
              break;
            }
            if (localae.cd != 0)
            {
              paramInt1 = -21300000;
              break;
            }
            ef.a(this.ma, ef.c(this.ma), this.mc, false);
            paramInt1 = paramInt2;
            break;
          }
        }
      }
      paramInt1 = -21250000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ef.2
 * JD-Core Version:    0.7.0.1
 */