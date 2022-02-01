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
    if (paramInt != 0)
    {
      int i = 1;
      if (paramInt != 1)
      {
        i = 2;
        if (paramInt != 2)
        {
          i = 3;
          if (paramInt != 3) {
            return -1;
          }
        }
      }
      return i;
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseWifiReportBean [sessionKey=");
    localStringBuilder.append(this.ec);
    localStringBuilder.append(", bssid=");
    localStringBuilder.append(this.fZ);
    localStringBuilder.append(", ssid=");
    localStringBuilder.append(this.ey);
    localStringBuilder.append(", wifiType=");
    localStringBuilder.append(this.eE);
    localStringBuilder.append(", subWifiType=");
    localStringBuilder.append(this.fo);
    localStringBuilder.append(", securityType=");
    localStringBuilder.append(this.hH);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cp
 * JD-Core Version:    0.7.0.1
 */