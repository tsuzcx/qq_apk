package wf7;

import android.net.wifi.ScanResult;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;

class cx$b
  implements cz.a
{
  public long fi;
  public long ju = System.currentTimeMillis();
  public bh jv;
  public int jw;
  boolean jx = false;
  public List<h> jy;
  public List<bn> jz = new ArrayList();
  
  public cx$b(List<ScanResult> paramList, bh parambh, long paramLong, int paramInt)
  {
    this.jv = paramLong;
    this.jy = j(parambh);
    this.fi = ???;
    int i;
    this.jw = i;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    bh localbh = this.jv;
    if (this.jn.jg != -1)
    {
      paramLong = this.jn.jf;
      paramInt1 = this.jn.jg;
      localbh = this.jn.jh;
      this.jn.jf = -1L;
      this.jn.jg = -1;
      this.jn.jh = null;
    }
    for (;;)
    {
      cx.a(this.jn, localbh, paramLong, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
  
  private List<h> j(List<ScanResult> paramList)
  {
    cv.bj().bk();
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = (List<ScanResult>)localObject2;
      do
      {
        localObject1 = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (ScanResult)localIterator.next();
      } while (localObject2 == null);
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      int i = cb.a((ScanResult)localObject2);
      paramList = new h();
      paramList.u = cb.m(((ScanResult)localObject2).BSSID);
      paramList.ssid = cb.j(((ScanResult)localObject2).SSID);
      paramList.C = cb.F(i);
      paramList.frequency = ((ScanResult)localObject2).frequency;
      localObject2 = ((bq)ao.c().i(1)).a(paramList.ssid, i);
      boolean bool1;
      if (localObject2 != null)
      {
        this.jz.add(localObject2);
        if (((bn)localObject2).ac().aj() == null) {
          break label223;
        }
        bool1 = true;
        label181:
        bool2 = bool1;
        if (bool1) {
          if (!((bn)localObject2).ad().S()) {
            break label228;
          }
        }
      }
      label223:
      label228:
      for (boolean bool2 = false;; bool2 = true)
      {
        paramList.aC = bool2;
        ((List)localObject1).add(paramList);
        paramList = (List<ScanResult>)localObject1;
        break;
        bool1 = false;
        break label181;
      }
    }
    return localObject1;
  }
  
  public void a(long paramLong, boolean paramBoolean1, ArrayList<ct> paramArrayList, boolean paramBoolean2, int paramInt)
  {
    paramBoolean2 = cv.bj().b(paramArrayList);
    if ((!this.jx) && (paramInt == 0)) {
      paramArrayList = this.jz.iterator();
    }
    while (paramArrayList.hasNext())
    {
      Object localObject = (bn)paramArrayList.next();
      ct localct = cw.p((bn)localObject);
      localct.U(5);
      if ((localct != null) && ((((bn)localObject).ad() == null) || (((bl)localct.getData()).S()))) {
        if ((!((bl)localct.getData()).O()) && (ck.P(localct.L())))
        {
          by.b(500096, "19_0");
        }
        else if (ck.m(localct.L(), ((bn)localObject).ab()))
        {
          by.b(500096, "25_0");
        }
        else if (ck.Q(localct.L()))
        {
          by.b(500096, "27_" + ((bl)localct.getData()).M());
          continue;
          if ((!this.jx) && (paramInt != 0)) {
            paramArrayList = this.jz.iterator();
          }
          while (paramArrayList.hasNext())
          {
            localObject = (bn)paramArrayList.next();
            localct = cw.p((bn)localObject);
            if ((localct != null) && (((bl)localct.getData()).Q()) && (((bl)localct.getData()).S())) {
              localct.U(5);
            }
            for (;;)
            {
              if ((localct == null) || ((localct.R() != null) && (((bl)localct.getData()).S()))) {
                break label364;
              }
              if ((((bl)localct.getData()).O()) || (!ck.P(localct.L()))) {
                break label366;
              }
              by.b(500096, "19_0");
              break;
              localct.U(4);
            }
            label364:
            continue;
            label366:
            if (ck.m(localct.L(), ((bn)localObject).ab()))
            {
              by.b(500096, "25_0");
            }
            else if (ck.Q(localct.L()))
            {
              by.b(500096, "27_" + ((bl)localct.getData()).M());
              continue;
              if (this.jx)
              {
                paramArrayList = this.jz.iterator();
                while (paramArrayList.hasNext())
                {
                  localObject = cw.p((bn)paramArrayList.next());
                  if ((localObject != null) && (((bl)((ct)localObject).getData()).Q()) && (((bl)((ct)localObject).getData()).S())) {
                    ((ct)localObject).U(5);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (!this.jx)
    {
      cx.a(this.jn, System.currentTimeMillis());
      this.jn.iZ = false;
      this.jn.mHandler.removeMessages(1);
      j = this.jw;
      if (paramBoolean1)
      {
        i = 1;
        a(paramLong, j, i, paramInt);
        if (this.jn.ja)
        {
          cx.a(this.jn, -1L, 1, null, cx.b(this.jn).js * 1000);
          this.jn.ja = false;
        }
      }
    }
    while (!paramBoolean2) {
      for (;;)
      {
        int j;
        return;
        int i = 0;
      }
    }
    cx.a(this.jn, null, -1L, 1, 2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cx.b
 * JD-Core Version:    0.7.0.1
 */