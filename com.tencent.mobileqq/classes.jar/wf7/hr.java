package wf7;

import android.util.Pair;

public class hr
  extends hn
{
  public float U = -1.0F;
  public String bssid = "";
  private bn gc;
  public boolean isBestWiFi = false;
  public int level;
  public String recommendReason = "";
  public int security = -1;
  public String ssid = "";
  public int starLevel = 3;
  public int tI;
  public int tJ = 0;
  public boolean tK = false;
  public String tL = "";
  public boolean tM = false;
  public boolean tN = false;
  public boolean tO = false;
  
  public hr(bn parambn)
  {
    super(0);
    this.gc = parambn;
    this.ssid = this.gc.Z();
    this.bssid = this.gc.aa();
    this.security = parambn.ab();
    this.level = ca.calculateSignalLevel(this.gc.ac().al().gd, 4);
    int i = this.level;
    if ((i < 0) || (i >= 4)) {
      this.level = 2;
    }
    if (hm.d(this.gc)) {
      this.tI = 1;
    } else {
      this.tI = 2;
    }
    if (this.tI == 1)
    {
      parambn = this.gc.ad();
      this.starLevel = hm.a(parambn);
      this.tK = hm.w(this.gc);
      this.tM = ck.m(parambn.L(), this.gc.ab());
      this.tL = parambn.N();
      parambn = hm.b(parambn);
      if (((Boolean)parambn.first).booleanValue())
      {
        this.isBestWiFi = true;
        this.recommendReason = ((String)parambn.second);
      }
    }
    else
    {
      if (this.gc.ac().aj() != null)
      {
        this.tJ = 1;
        return;
      }
      if (hm.v(this.gc)) {
        this.tJ = 2;
      }
    }
  }
  
  public bn af()
  {
    return this.gc;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ssid: ");
    localStringBuilder.append(this.ssid);
    localStringBuilder.append(" bssid: ");
    localStringBuilder.append(this.bssid);
    localStringBuilder.append(" level: ");
    localStringBuilder.append(this.level);
    localStringBuilder.append(" starLevel: ");
    localStringBuilder.append(this.starLevel);
    localStringBuilder.append(" latency: ");
    localStringBuilder.append(this.U);
    localStringBuilder.append(" needAuthByWiFiManager: ");
    localStringBuilder.append(this.tK);
    localStringBuilder.append(" isBestWiFi: ");
    localStringBuilder.append(this.isBestWiFi);
    localStringBuilder.append(" recommendReason: ");
    localStringBuilder.append(this.recommendReason);
    localStringBuilder.append(" poiDesc: ");
    localStringBuilder.append(this.tL);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hr
 * JD-Core Version:    0.7.0.1
 */