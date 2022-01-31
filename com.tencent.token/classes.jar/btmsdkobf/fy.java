package btmsdkobf;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

class fy
  implements df.a
{
  fy(cy paramcy) {}
  
  public void a(boolean paramBoolean, int paramInt, byte[] arg3, cy.f paramf)
  {
    eh.f("SharkNetwork", "onFinish(), retCode: " + paramInt);
    if (paramInt != 0) {
      cy.a(this.a, paramBoolean, paramInt, paramf);
    }
    for (;;)
    {
      return;
      if (??? == null)
      {
        eh.h("SharkNetwork", "onFinish() null == retData");
        cy.a(this.a, paramBoolean, -21000005, paramf);
        return;
      }
      eh.e("SharkNetwork", "onFinish() retData.length: " + ???.length);
      if (cx.i(???))
      {
        byte b = ???[0];
        paramInt = cv.by().b(b);
        if (paramInt < 0) {
          continue;
        }
        synchronized (cy.a(this.a))
        {
          paramf = (cy.f)cy.a(this.a).get(Integer.valueOf(paramInt));
          if (paramf != null)
          {
            cy.a(this.a, paramBoolean, paramf, 0, 0, null);
            return;
          }
        }
      }
    }
    try
    {
      ??? = cp.g(???);
      if (??? == null)
      {
        eh.h("SharkNetwork", "onFinish() null == obj");
        cy.a(this.a, paramBoolean, -21000400, paramf);
        return;
      }
    }
    catch (Exception ???)
    {
      eh.h("SharkNetwork", "onFinish() e: " + ???.toString());
      cy.a(this.a, paramBoolean, -21000400, paramf);
      return;
    }
    bb localbb = (bb)???;
    ArrayList localArrayList = localbb.du;
    int j = localbb.dd;
    if ((cy.b(this.a) != null) && (cy.b(this.a).jQ == j)) {
      paramf = cy.b(this.a);
    }
    int i;
    while (localArrayList != null)
    {
      ??? = localArrayList.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)???).hasNext())
        {
          localObject2 = (ba)((Iterator)???).next();
          eh.f("SharkNetwork_CMDID", "[" + i + "]收包：cmd id:[" + ((ba)localObject2).bM + "]seqNo:[" + ((ba)localObject2).dc + "]refSeqNo:[" + ((ba)localObject2).dd + "]retCode:[" + ((ba)localObject2).df + "]dataRetCode:[" + ((ba)localObject2).dg + "]");
          i += 1;
          continue;
          if ((cy.c(this.a) != null) && (cy.c(this.a).jQ == j))
          {
            paramf = cy.c(this.a);
            break;
          }
          synchronized (cy.a(this.a))
          {
            paramf = (cy.f)cy.a(this.a).get(Integer.valueOf(j));
          }
        }
      }
    }
    if (localArrayList == null)
    {
      eh.h("SharkNetwork", "onFinish() null == respSashimiList");
      cy.a(this.a, paramBoolean, paramf, -21000005, localbb.dc, null);
      return;
    }
    cy.e(localArrayList);
    eh.e("SharkNetwork", "onFinish() sharkSeq: " + j + " ssTag: " + paramf + " shark回包或push个数: " + localArrayList.size());
    boolean bool = cy.a(this.a, localArrayList);
    Object localObject2 = new StringBuilder().append("[rsa_key]onFinish() 密钥是否过期：");
    if (bool) {}
    for (??? = "是";; ??? = "否")
    {
      eh.f("SharkNetwork", (String)???);
      if (!bool) {
        break;
      }
      cy.a(this.a, true);
      cy.d(this.a).removeMessages(1);
      cy.d(this.a).sendEmptyMessageDelayed(1, 100L);
      return;
    }
    localObject2 = cy.a(this.a, paramf, paramBoolean, localbb, localArrayList);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      while (localIterator.hasNext())
      {
        ba localba = (ba)localIterator.next();
        if (localba != null)
        {
          cv localcv = cv.by();
          i = localba.bM;
          j = localba.dd;
          if (??? != null) {}
          for (??? = String.format("%d/%d", new Object[] { Integer.valueOf(???.length + 4), Integer.valueOf(localArrayList.size()) });; ??? = null)
          {
            localcv.a("SharkNetwork", i, j, localba, 17, paramInt, (String)???);
            ??? = dg.J(localba.dd);
            if (??? == null) {
              break;
            }
            ((dg)???).ml = String.valueOf(cd.e(cy.e(this.a)));
            ((dg)???).errorCode = localba.df;
            ((dg)???).I(localba.bM);
            ((dg)???).f(cy.f(this.a));
            break;
          }
        }
      }
    }
    cy.a(this.a, paramBoolean, paramf, 0, localbb.dc, (ArrayList)localObject2);
    cy.g(this.a);
  }
  
  public void b(boolean paramBoolean, int paramInt, cy.f paramf)
  {
    if (paramf != null) {
      eh.h("SharkNetwork", "onSendFailed(), isTcpChannel: " + paramBoolean + " retCode: " + paramInt + " seqNo: " + paramf.jQ);
    }
    for (;;)
    {
      if (paramInt != 0) {
        cy.a(this.a, paramBoolean, paramInt, paramf);
      }
      return;
      eh.h("SharkNetwork", "onSendFailed(), isTcpChannel: " + paramBoolean + " retCode: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fy
 * JD-Core Version:    0.7.0.1
 */