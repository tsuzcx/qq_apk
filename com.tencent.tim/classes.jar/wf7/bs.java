package wf7;

import android.net.wifi.WifiConfiguration;
import java.util.LinkedList;
import java.util.Queue;

public class bs
{
  private int gi = cb.gI;
  private WifiConfiguration gj;
  private int gk = -1;
  private long gl = -1L;
  private br gm;
  private boolean gn = false;
  private boolean go = false;
  private long gp = 0L;
  private final Queue<a> gq = new LinkedList();
  
  public void B(int paramInt)
  {
    this.gi = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.gl = paramLong;
  }
  
  public void a(WifiConfiguration paramWifiConfiguration)
  {
    this.gj = paramWifiConfiguration;
  }
  
  public void a(br parambr)
  {
    this.gm = parambr;
  }
  
  public WifiConfiguration aj()
  {
    return this.gj;
  }
  
  public long ak()
  {
    return this.gl;
  }
  
  public br al()
  {
    return this.gm;
  }
  
  public boolean am()
  {
    return this.go;
  }
  
  public long an()
  {
    return this.gp;
  }
  
  public Queue<a> ao()
  {
    return this.gq;
  }
  
  public void b(long paramLong)
  {
    this.gp = paramLong;
  }
  
  public void d(boolean paramBoolean)
  {
    this.gn = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.go = paramBoolean;
  }
  
  public int getLevel()
  {
    return this.gk;
  }
  
  public int getNetworkId()
  {
    return this.gi;
  }
  
  public void setLevel(int paramInt)
  {
    this.gk = paramInt;
  }
  
  public String toString()
  {
    return "WifiInfo{mNetworkId=" + this.gi + ", mConfig=" + this.gj + ", mLevel=" + this.gk + ", mAppearTime=" + this.gl + ", mScanResult=" + this.gm + ", mHaveConfSinceAppera=" + this.gn + ", mNewWifiConfig=" + this.go + ", mSignalStartTime=" + this.gp + ", mSignalRecords=" + this.gq + '}';
  }
  
  public static class a
  {
    public int gr = 0;
    public int gs = 0;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.gr);
      localStringBuilder.append(":");
      localStringBuilder.append(this.gs);
      localStringBuilder.append(",");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.bs
 * JD-Core Version:    0.7.0.1
 */