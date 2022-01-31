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
    if ((this.level < 0) || (this.level >= 4)) {
      this.level = 2;
    }
    if (hm.d(this.gc))
    {
      this.tI = 1;
      if (this.tI != 1) {
        break label270;
      }
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
    label270:
    do
    {
      return;
      this.tI = 2;
      break;
      if (this.gc.ac().aj() != null)
      {
        this.tJ = 1;
        return;
      }
    } while (!hm.v(this.gc));
    this.tJ = 2;
  }
  
  public bn af()
  {
    return this.gc;
  }
  
  public String toString()
  {
    return "[ssid: " + this.ssid + " bssid: " + this.bssid + " level: " + this.level + " starLevel: " + this.starLevel + " latency: " + this.U + " needAuthByWiFiManager: " + this.tK + " isBestWiFi: " + this.isBestWiFi + " recommendReason: " + this.recommendReason + " poiDesc: " + this.tL + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hr
 * JD-Core Version:    0.7.0.1
 */