package tmsdk.QQPIM;

import java.io.Serializable;

public final class ConnectType
  implements Serializable
{
  public static final ConnectType CT_3G_NET = new ConnectType(5, 5, "CT_3G_NET");
  public static final ConnectType CT_GPRS;
  public static final ConnectType CT_GPRS_NET;
  public static final ConnectType CT_GPRS_WAP;
  public static final ConnectType CT_NONE;
  public static final ConnectType CT_WIFI;
  public static final int _CT_3G_NET = 5;
  public static final int _CT_GPRS = 1;
  public static final int _CT_GPRS_NET = 4;
  public static final int _CT_GPRS_WAP = 3;
  public static final int _CT_NONE = 0;
  public static final int _CT_WIFI = 2;
  private static ConnectType[] ea = new ConnectType[6];
  private int eb;
  private String ec = new String();
  
  static
  {
    CT_NONE = new ConnectType(0, 0, "CT_NONE");
    CT_GPRS = new ConnectType(1, 1, "CT_GPRS");
    CT_WIFI = new ConnectType(2, 2, "CT_WIFI");
    CT_GPRS_WAP = new ConnectType(3, 3, "CT_GPRS_WAP");
    CT_GPRS_NET = new ConnectType(4, 4, "CT_GPRS_NET");
  }
  
  private ConnectType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ea[paramInt1] = this;
  }
  
  public static ConnectType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      ConnectType[] arrayOfConnectType = ea;
      if (i >= arrayOfConnectType.length) {
        break;
      }
      if (arrayOfConnectType[i].value() == paramInt) {
        return ea[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static ConnectType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      ConnectType[] arrayOfConnectType = ea;
      if (i >= arrayOfConnectType.length) {
        break;
      }
      if (arrayOfConnectType[i].toString().equals(paramString)) {
        return ea[i];
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return this.ec;
  }
  
  public int value()
  {
    return this.eb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ConnectType
 * JD-Core Version:    0.7.0.1
 */