package btmsdkobf;

import java.util.ArrayList;
import java.util.Iterator;

class fq
  implements cy.b
{
  fq(cf paramcf, int paramInt, an paraman) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    paramInt2 = 0;
    eh.e("GuidCertifier", "updateGuid() retCode: " + paramInt1);
    if (paramInt1 != 0)
    {
      eh.h("GuidCertifier", "[cu_guid]updateGuid() ESharkCode.ERR_NONE != retCode, retCode: " + paramInt1);
      cv.by().a("GuidCertifier", 10002, this.a, null, 30, paramInt1);
      cv.by().x(this.a);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      eh.h("GuidCertifier", "[cu_guid]updateGuid(), no sashimi, serverSashimis: " + paramArrayList);
      paramInt1 = -21250000;
    }
    for (;;)
    {
      cv.by().a("GuidCertifier", 10002, this.a, null, 30, paramInt1);
      cv.by().x(this.a);
      return;
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          ba localba = (ba)paramArrayList.next();
          if ((localba != null) && (10002 == localba.bM))
          {
            if (localba.df != 0)
            {
              eh.h("GuidCertifier", "[cu_guid]updateGuid(), mazu error: " + localba.df);
              paramInt1 = localba.df;
              break;
            }
            if (localba.dg != 0)
            {
              eh.h("GuidCertifier", "[cu_guid]updateGuid(), dataRetCode: " + localba.dg);
              paramInt1 = -21300000;
              break;
            }
            eh.e("GuidCertifier", "[cu_guid]updateGuid(), succ, save info to db, mGuid: " + cf.c(this.c));
            cf.a(this.c, cf.c(this.c), this.b, false);
            paramInt1 = paramInt2;
            break;
          }
        }
      }
      paramInt1 = -21250000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fq
 * JD-Core Version:    0.7.0.1
 */