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
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private boolean X(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    if (paramInt == 2) {
      return true;
    }
    return paramInt == 3;
  }
  
  private void a(long paramLong1, int paramInt, bh parambh, long paramLong2)
  {
    int i = 1;
    if (paramInt != 0)
    {
      long l = this.jb;
      if ((l >= -1L) && ((l <= 0L) || (System.currentTimeMillis() + paramLong2 >= this.jb))) {
        i = 0;
      }
    }
    if (i != 0)
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
      Object localObject = localcd.a(0, "", ",");
      if ((localObject != null) && (localObject.length >= 3))
      {
        this.iX.jo = cb.G(Integer.valueOf(localObject[0]).intValue());
        this.iX.jp = cb.G(Integer.valueOf(localObject[1]).intValue());
        this.iX.jq = cb.G(Integer.valueOf(localObject[2]).intValue());
      }
      localObject = this.iX;
      ((cx.a)localObject).jr = localcd.e(1, ((cx.a)localObject).jr);
      localObject = this.iX;
      ((cx.a)localObject).js = localcd.e(2, ((cx.a)localObject).js);
      localObject = this.iX;
      ((cx.a)localObject).jt = localcd.b(3, ((cx.a)localObject).jt);
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
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
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
    }
    return false;
  }
  
  public boolean b(long paramLong, int paramInt, bh parambh)
  {
    int i = 1;
    if (paramInt == 1) {
      return false;
    }
    int k;
    if (paramInt == 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (!ca.isWifiEnabled())
    {
      a(parambh, paramLong, paramInt, 3, 0);
      return false;
    }
    Object localObject1 = ca.getScanResults();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (this.iZ)
      {
        this.ja = true;
        if (paramInt == 0)
        {
          i = this.jg;
          if (i != -1) {
            a(this.jh, this.jf, i, 3, 0);
          }
          this.jf = paramLong;
          this.jg = paramInt;
          this.jh = parambh;
        }
        return false;
      }
      if ((paramInt == 1) && (i((List)localObject1))) {
        a(null, paramLong, paramInt, 2, 0);
      }
      int m;
      if ((!W(paramInt)) && (!this.jl)) {
        m = 0;
      } else {
        m = 1;
      }
      Object localObject2 = bz.av().A();
      boolean bool;
      if (localObject2 != null) {
        bool = ((bz.b)localObject2).aA().aE();
      } else {
        bool = false;
      }
      long l4 = System.currentTimeMillis();
      if (m == 0)
      {
        if ((!this.iX.jq) && (bu.aq()) && (!bool))
        {
          a(parambh, paramLong, paramInt, 3, 0);
          return false;
        }
        l1 = l4 - this.iY;
        if (l1 < this.iX.js * 1000)
        {
          a(paramLong, paramInt, parambh, l1);
          return false;
        }
      }
      if (paramLong > 0L) {
        cw.bo().br().a(paramLong, new DogFood(b.fS));
      }
      Iterator localIterator = ((List)localObject1).iterator();
      long l1 = -1L;
      for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
      {
        ScanResult localScanResult = (ScanResult)localIterator.next();
        int j = i;
        long l2 = l1;
        localObject2 = localObject1;
        if (localScanResult != null)
        {
          int n = cb.a(localScanResult);
          ct localct = cw.f(cb.j(localScanResult.SSID), n);
          if (localct != null)
          {
            j = i;
            l2 = l1;
            localObject2 = localObject1;
            if (localct == null) {
              break label735;
            }
            if (localct.b(cb.m(localScanResult.BSSID)))
            {
              j = i;
              l2 = l1;
              localObject2 = localObject1;
              if (((bl)localct.getData()).P()) {
                break label735;
              }
            }
          }
          if ((cb.b(localScanResult)) && (X(n)))
          {
            localObject2 = ((bq)ao.c().i(i)).a(cb.j(localScanResult.SSID), n);
            if ((m == 0) && (this.iX.jr > 0))
            {
              j = i;
              if (localObject2 != null)
              {
                l2 = l4 - ((bn)localObject2).ac().ak();
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
                  localObject2 = cw.p((bn)localObject2);
                  j = 1;
                  ((ct)localObject2).U(1);
                  localObject2 = localObject1;
                  break label735;
                }
                j = 1;
                cw.p((bn)localObject2).U(3);
              }
            }
            else
            {
              j = i;
              if (localObject2 != null)
              {
                cw.p((bn)localObject2).U(3);
                j = i;
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((List)localObject2).add(localScanResult);
            l2 = l1;
          }
          else
          {
            j = i;
            l2 = l1;
            localObject2 = localObject1;
            if (localct != null)
            {
              localct.U(6);
              localObject2 = localObject1;
              l2 = l1;
              j = i;
            }
          }
        }
        label735:
        i = j;
        l1 = l2;
      }
      if (l1 > 0L) {
        a(-1L, 1, null, l1);
      }
      localObject1 = new cx.b(this, (List)localObject1, parambh, paramLong, paramInt);
      if ((((cx.b)localObject1).jy != null) && (((cx.b)localObject1).jy.size() > 0))
      {
        parambh = this.jk;
        localObject2 = ((cx.b)localObject1).jy;
        if (k != 0) {
          l1 = 8000L;
        } else {
          l1 = -1L;
        }
        parambh.a(paramLong, (cz.a)localObject1, (List)localObject2, l1, paramInt);
        this.mHandler.sendEmptyMessageDelayed(1, 60000L);
        this.iZ = true;
        this.jl = false;
        return false;
      }
      a(parambh, paramLong, paramInt, 3, 0);
      return false;
    }
    a(parambh, paramLong, paramInt, 3, 0);
    return false;
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