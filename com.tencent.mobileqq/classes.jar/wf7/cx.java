package wf7;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.DogFood;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.a;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;

public class cx
{
  final int iW = 8000;
  private cx.a iX = new cx.a();
  private long iY = 0L;
  boolean iZ = false;
  boolean ja = false;
  long jb = -1L;
  long jc = -1L;
  int jd = -1;
  bh je;
  long jf = -1L;
  int jg = -1;
  bh jh;
  private final int ji = 0;
  private final int jj = 1;
  cz jk = new cz(bz.av().u());
  private boolean jl = true;
  private cf jm = new cx.1(this);
  Handler mHandler = null;
  
  protected cx()
  {
    ce.aK().a(909, this.jm);
    bw();
  }
  
  private boolean W(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return false;
    }
    return true;
  }
  
  private boolean X(int paramInt)
  {
    if (paramInt == 0) {}
    while ((paramInt == 2) || (paramInt == 3)) {
      return true;
    }
    return false;
  }
  
  private void a(long paramLong1, int paramInt, bh parambh, long paramLong2)
  {
    int j = 0;
    int i;
    if (paramInt == 0) {
      i = 1;
    }
    while (i != 0)
    {
      if (this.jb > 0L) {
        a(this.je, this.jc, this.jd, 3, 0);
      }
      this.jc = paramLong1;
      this.jd = paramInt;
      this.je = parambh;
      this.jb = (System.currentTimeMillis() + paramLong2);
      this.mHandler.removeMessages(0);
      this.mHandler.sendEmptyMessageDelayed(0, paramLong2);
      return;
      if (this.jb < -1L)
      {
        i = 1;
      }
      else
      {
        i = j;
        if (this.jb > 0L)
        {
          i = j;
          if (System.currentTimeMillis() + paramLong2 < this.jb) {
            i = 1;
          }
        }
      }
    }
    a(parambh, paramLong1, paramInt, 3, 0);
  }
  
  private void a(bh parambh, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 2) || (paramInt2 == 1)) {
      cw.bo().bt();
    }
    if (parambh != null)
    {
      bh.a locala = new bh.a();
      locala.fi = paramLong;
      locala.fj = paramInt2;
      locala.fk = paramInt3;
      parambh.a(locala);
    }
    if (paramLong > 0L) {
      cw.bo().br().a(paramLong, new DogFood(b.fV));
    }
  }
  
  private void bw()
  {
    this.iX = new cx.a();
    cd localcd = ce.aK().H(909);
    if (localcd.aJ())
    {
      String[] arrayOfString = localcd.a(0, "", ",");
      if ((arrayOfString != null) && (arrayOfString.length >= 3))
      {
        this.iX.jo = cb.G(Integer.valueOf(arrayOfString[0]).intValue());
        this.iX.jp = cb.G(Integer.valueOf(arrayOfString[1]).intValue());
        this.iX.jq = cb.G(Integer.valueOf(arrayOfString[2]).intValue());
      }
      this.iX.jr = localcd.e(1, this.iX.jr);
      this.iX.js = localcd.e(2, this.iX.js);
      this.iX.jt = localcd.b(3, this.iX.jt);
    }
  }
  
  private void c(long paramLong, int paramInt, bh parambh)
  {
    this.jc = -1L;
    this.jd = -1;
    this.je = null;
    this.jb = -1L;
    b(paramLong, paramInt, parambh);
  }
  
  private boolean i(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    cv.bj().bl();
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<ScanResult>)localObject;
    while (localIterator.hasNext())
    {
      ScanResult localScanResult = (ScanResult)localIterator.next();
      if (localScanResult != null)
      {
        ct localct = cv.bj().e(localScanResult.SSID, cb.a(localScanResult));
        if (localct != null)
        {
          localObject = paramList;
          if (paramList == null) {
            localObject = new ArrayList();
          }
          localct.d(cb.m(localScanResult.BSSID));
          ((ArrayList)localObject).add(localct);
          cv.bj().a(localct);
          paramList = (List<ScanResult>)localObject;
        }
      }
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      return cv.bj().b(paramList);
    }
    return false;
  }
  
  public boolean b(long paramLong, int paramInt, bh parambh)
  {
    if (paramInt == 1) {
      return false;
    }
    if (paramInt == 0) {}
    for (int i = 1; !ca.isWifiEnabled(); i = 0)
    {
      a(parambh, paramLong, paramInt, 3, 0);
      return false;
    }
    Object localObject2 = ca.getScanResults();
    Object localObject1 = null;
    if ((localObject2 == null) || (((List)localObject2).size() <= 0))
    {
      a(parambh, paramLong, paramInt, 3, 0);
      return false;
    }
    if (this.iZ)
    {
      this.ja = true;
      if (paramInt == 0)
      {
        if (this.jg != -1) {
          a(this.jh, this.jf, this.jg, 3, 0);
        }
        this.jf = paramLong;
        this.jg = paramInt;
        this.jh = parambh;
      }
      return false;
    }
    if ((paramInt == 1) && (i((List)localObject2))) {
      a(null, paramLong, paramInt, 2, 0);
    }
    if ((W(paramInt)) || (this.jl)) {}
    Object localObject3;
    long l4;
    for (int j = 1;; j = 0)
    {
      localObject3 = bz.av().A();
      boolean bool = false;
      if (localObject3 != null) {
        bool = ((bz.b)localObject3).aA().aE();
      }
      l4 = System.currentTimeMillis();
      if (j != 0) {
        break label292;
      }
      if ((this.iX.jq) || (!bu.aq()) || (bool)) {
        break;
      }
      a(parambh, paramLong, paramInt, 3, 0);
      return false;
    }
    long l1 = l4 - this.iY;
    if (l1 < this.iX.js * 1000)
    {
      a(paramLong, paramInt, parambh, l1);
      return false;
    }
    label292:
    if (paramLong > 0L) {
      cw.bo().br().a(paramLong, new DogFood(b.fS));
    }
    l1 = -1L;
    localObject2 = ((List)localObject2).iterator();
    Object localObject4;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ScanResult)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          int k = cb.a((ScanResult)localObject3);
          localObject4 = cw.f(cb.j(((ScanResult)localObject3).SSID), k);
          if ((localObject4 == null) || ((localObject4 != null) && ((!((ct)localObject4).b(cb.m(((ScanResult)localObject3).BSSID))) || (!((bl)((ct)localObject4).getData()).P())))) {
            if ((!cb.b((ScanResult)localObject3)) || (!X(k)))
            {
              if (localObject4 != null) {
                ((ct)localObject4).U(6);
              }
            }
            else
            {
              localObject4 = ((bq)ao.c().i(1)).a(cb.j(((ScanResult)localObject3).SSID), k);
              if ((j == 0) && (this.iX.jr > 0))
              {
                if (localObject4 != null)
                {
                  long l2 = l4 - ((bn)localObject4).ac().ak();
                  if (l2 < this.iX.jr * 1000)
                  {
                    long l3 = this.iX.jr * 1000 - l2;
                    if (l1 >= 0L)
                    {
                      l2 = l1;
                      if (l1 <= l3) {}
                    }
                    else
                    {
                      l2 = l3;
                    }
                    cw.p((bn)localObject4).U(1);
                    l1 = l2;
                    continue;
                  }
                  cw.p((bn)localObject4).U(3);
                }
                label598:
                if (localObject1 != null) {
                  break label777;
                }
                localObject1 = new ArrayList();
              }
            }
          }
        }
      }
    }
    label777:
    for (;;)
    {
      ((List)localObject1).add(localObject3);
      break;
      if (localObject4 == null) {
        break label598;
      }
      cw.p((bn)localObject4).U(3);
      break label598;
      if (l1 > 0L) {
        a(-1L, 1, null, l1);
      }
      localObject1 = new cx.b(this, (List)localObject1, parambh, paramLong, paramInt);
      if ((((cx.b)localObject1).jy != null) && (((cx.b)localObject1).jy.size() > 0))
      {
        parambh = this.jk;
        localObject2 = ((cx.b)localObject1).jy;
        if (i != 0) {}
        for (l1 = 8000L;; l1 = -1L)
        {
          parambh.a(paramLong, (cz.a)localObject1, (List)localObject2, l1, paramInt);
          this.mHandler.sendEmptyMessageDelayed(1, 60000L);
          this.iZ = true;
          this.jl = false;
          return false;
        }
      }
      a(parambh, paramLong, paramInt, 3, 0);
      return false;
    }
  }
  
  public cx.a bx()
  {
    return this.iX;
  }
  
  protected void h(List<bn> paramList)
  {
    cv.bj().bl();
    cv.bj().g(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cx
 * JD-Core Version:    0.7.0.1
 */