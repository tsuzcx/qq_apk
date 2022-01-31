package wf7;

import android.net.wifi.WifiConfiguration;
import java.util.Queue;

public class dc
  extends bn.a<bs>
{
  protected bs.a jV;
  
  public dc(bn parambn)
  {
    super(parambn);
    this.gb = new bs();
  }
  
  private void Z(int paramInt)
  {
    if (((bs)getData()).an() <= 0L) {
      ((bs)getData()).b(System.currentTimeMillis());
    }
    Queue localQueue = ((bs)getData()).ao();
    bs.a locala = null;
    for (;;)
    {
      try
      {
        if (localQueue.size() > 4) {
          locala = (bs.a)localQueue.poll();
        }
        if (locala == null)
        {
          locala = new bs.a();
          locala.gs = paramInt;
          locala.gr = ((int)(System.currentTimeMillis() / 1000L - ((bs)getData()).an() / 1000L));
          localQueue.add(locala);
          return;
        }
      }
      finally {}
    }
  }
  
  protected void Y(int paramInt)
  {
    if (this.jV != null)
    {
      if (Math.abs(this.jV.gs - paramInt) > 5) {
        Z(paramInt);
      }
      return;
    }
    Z(paramInt);
  }
  
  public void a(WifiConfiguration paramWifiConfiguration, boolean paramBoolean)
  {
    int i = 0;
    int j = 1;
    if (paramWifiConfiguration != null)
    {
      if (((bs)getData()).getNetworkId() != paramWifiConfiguration.networkId) {
        i = 1;
      }
      ((bs)this.gb).B(paramWifiConfiguration.networkId);
      ((bs)this.gb).a(paramWifiConfiguration);
      j = i;
      if (paramBoolean)
      {
        ((bs)getData()).d(true);
        j = i;
      }
      if (j != 0) {}
      return;
    }
    if (((bs)this.gb).aj() != null) {}
    for (i = j;; i = 0)
    {
      ((bs)this.gb).B(cb.gI);
      ((bs)this.gb).a(null);
      j = i;
      break;
    }
  }
  
  public br al()
  {
    return ((bs)getData()).al();
  }
  
  public boolean bG()
  {
    boolean bool = false;
    if (al() != null)
    {
      int i = ((bs)this.gb).getLevel();
      ((bs)this.gb).setLevel(ca.calculateSignalLevel(al().gd, 100) + 1);
      if (((bs)this.gb).getLevel() != i) {
        bool = true;
      }
      if (bool) {
        Y(((bs)this.gb).getLevel());
      }
      return bool;
    }
    ((bs)this.gb).setLevel(-1);
    return false;
  }
  
  public void bH()
  {
    long l = System.currentTimeMillis();
    ((bs)this.gb).a(l);
  }
  
  public void c(br parambr)
  {
    this.gc.f(parambr.ey);
    this.gc.A(parambr.ez);
    this.gc.g(parambr.aa());
    ((bs)this.gb).B(cb.gI);
    ((bs)getData()).a(parambr);
    bG();
  }
  
  public void h(boolean paramBoolean)
  {
    ((bs)getData()).e(paramBoolean);
  }
  
  public String toString()
  {
    return "ExtraWifiInfo{mData=" + this.gb + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.dc
 * JD-Core Version:    0.7.0.1
 */