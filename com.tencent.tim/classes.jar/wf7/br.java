package wf7;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class br
{
  public String ey = null;
  public int ez = -1;
  public int gd = 2147483647;
  public byte[] ge;
  private final List<a> gf = new ArrayList();
  
  public br(ScanResult paramScanResult)
  {
    this.ey = cb.j(paramScanResult.SSID);
    a(paramScanResult.BSSID, paramScanResult.level, paramScanResult.frequency);
    this.ez = cb.a(paramScanResult);
  }
  
  public int Y()
  {
    return cb.d(this.ey, this.ez);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!cb.k(paramString)) {
      return;
    }
    if (ca.compareSignalLevel(paramInt1, this.gd) > 0)
    {
      this.gd = paramInt1;
      this.ge = cb.m(paramString);
    }
    synchronized (this.gf)
    {
      this.gf.add(new a(cb.m(paramString), paramInt1, paramInt2));
      return;
    }
  }
  
  public String aa()
  {
    if ((this.ge != null) && (this.ge.length == 6)) {}
    for (String str = cb.c(this.ge);; str = null)
    {
      if (cb.k(str)) {
        return str;
      }
      return null;
    }
  }
  
  public boolean ag()
  {
    synchronized (this.gf)
    {
      boolean bool = this.gf.isEmpty();
      return bool;
    }
  }
  
  public void ah()
  {
    this.gd = 2147483647;
  }
  
  public void ai()
  {
    synchronized (this.gf)
    {
      this.gf.clear();
      return;
    }
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    synchronized (this.gf)
    {
      if (this.gf.size() > 0)
      {
        Iterator localIterator = this.gf.iterator();
        while (localIterator.hasNext()) {
          if (Arrays.equals(((a)localIterator.next()).gg, paramArrayOfByte)) {
            return true;
          }
        }
      }
      return false;
    }
  }
  
  public int h(String arg1)
  {
    byte[] arrayOfByte = cb.m(???);
    synchronized (this.gf)
    {
      Iterator localIterator = this.gf.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (Arrays.equals(arrayOfByte, locala.gg))
        {
          int i = locala.gh;
          return i;
        }
      }
      return -1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SimpleScanResult mSsid:");
    localStringBuilder.append(this.ey);
    localStringBuilder.append(" mSecurity:");
    localStringBuilder.append(this.ez);
    localStringBuilder.append(" mRssi:");
    localStringBuilder.append(this.gd);
    synchronized (this.gf)
    {
      if (this.gf.size() > 0) {
        localStringBuilder.append(this.gf.toString());
      }
      return localStringBuilder.toString();
    }
  }
  
  static class a
    implements Comparable<a>
  {
    public int gd;
    public byte[] gg;
    public int gh;
    
    public a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.gg = paramArrayOfByte;
      this.gd = paramInt1;
      this.gh = paramInt2;
    }
    
    public int a(a parama)
    {
      if (parama == null) {
        return -1;
      }
      return WifiManager.compareSignalLevel(this.gd, parama.gd);
    }
    
    public String toString()
    {
      return "Ap [mBssid=" + Arrays.toString(this.gg) + ", mRssi=" + this.gd + ", mFrequency=" + this.gh + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.br
 * JD-Core Version:    0.7.0.1
 */