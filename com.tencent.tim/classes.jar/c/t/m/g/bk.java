package c.t.m.g;

import android.location.Location;

public final class bk
  extends bm
{
  public final Location a;
  public final long b;
  public final int c;
  private final long d = 30000L;
  private final long e = 10000L;
  private int f;
  private int g;
  
  public bk(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.f = paramInt1;
    this.c = paramInt2;
    this.g = paramInt3;
  }
  
  public bk(bk parambk)
  {
    if (parambk.a == null) {}
    for (Location localLocation = null;; localLocation = new Location(parambk.a))
    {
      this.a = localLocation;
      this.b = parambk.b;
      this.f = parambk.f;
      this.c = parambk.c;
      this.g = parambk.g;
      return;
    }
  }
  
  public final String toString()
  {
    return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.f + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.g + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bk
 * JD-Core Version:    0.7.0.1
 */