package wf7;

public abstract class cp
  extends co
{
  protected int eE;
  protected String ec;
  protected String ey;
  protected String fZ;
  protected int fo;
  protected int hH;
  
  public static int S(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 0;
    case 2: 
      return 2;
    case 1: 
      return 1;
    }
    return 3;
  }
  
  public String toString()
  {
    return "BaseWifiReportBean [sessionKey=" + this.ec + ", bssid=" + this.fZ + ", ssid=" + this.ey + ", wifiType=" + this.eE + ", subWifiType=" + this.fo + ", securityType=" + this.hH + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.cp
 * JD-Core Version:    0.7.0.1
 */