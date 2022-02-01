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
    bs.a locala1 = null;
    try
    {
      if (localQueue.size() > 4) {
        locala1 = (bs.a)localQueue.poll();
      }
      bs.a locala2 = locala1;
      if (locala1 == null) {
        locala2 = new bs.a();
      }
      locala2.gs = paramInt;
      locala2.gr = ((int)(System.currentTimeMillis() / 1000L - ((bs)getData()).an() / 1000L));
      localQueue.add(locala2);
      return;
    }
    finally {}
  }
  
  protected void Y(int paramInt)
  {
    bs.a locala = this.jV;
    if (locala != null)
    {
      if (Math.abs(locala.gs - paramInt) > 5) {
        Z(paramInt);
      }
    }
    else {
      Z(paramInt);
    }
  }
  
  public void a(WifiConfiguration paramWifiConfiguration, boolean paramBoolean)
  {
    if (paramWifiConfiguration != null)
    {
      ((bs)getData()).getNetworkId();
      int i = paramWifiConfiguration.networkId;
      ((bs)this.gb).B(paramWifiConfiguration.networkId);
      ((bs)this.gb).a(paramWifiConfiguration);
      if (paramBoolean) {
        ((bs)getData()).d(true);
      }
    }
    else
    {
      ((bs)this.gb).aj();
      ((bs)this.gb).B(cb.gI);
      ((bs)this.gb).a(null);
    }
  }
  
  public br al()
  {
    return ((bs)getData()).al();
  }
  
  public boolean bG()
  {
    br localbr = al();
    boolean bool2 = false;
    boolean bool1 = false;
    if (localbr != null)
    {
      int i = ((bs)this.gb).getLevel();
      ((bs)this.gb).setLevel(ca.calculateSignalLevel(al().gd, 100) + 1);
      if (((bs)this.gb).getLevel() != i) {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1)
      {
        Y(((bs)this.gb).getLevel());
        return bool1;
      }
    }
    else
    {
      ((bs)this.gb).setLevel(-1);
    }
    return bool2;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtraWifiInfo{mData=");
    localStringBuilder.append(this.gb);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.dc
 * JD-Core Version:    0.7.0.1
 */