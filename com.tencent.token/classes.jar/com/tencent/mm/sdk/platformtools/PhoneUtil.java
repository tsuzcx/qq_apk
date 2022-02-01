package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.List;

public final class PhoneUtil
{
  public static final String CELL_CDMA = "cdma";
  public static final String CELL_GSM = "gsm";
  private static final int aI = 17;
  
  public static List<CellInfo> getCellInfoList(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 5) {
      return new PhoneUtil20Impl().getCellInfoList(paramContext);
    }
    return new PhoneUtil16Impl().getCellInfoList(paramContext);
  }
  
  public static String getCellXml(List<CellInfo> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      localObject = "";
      return localObject;
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramList.size()) {
        break;
      }
      str = str + "<cell ";
      str = str + "mcc=\"" + ((CellInfo)paramList.get(i)).mcc + "\" ";
      str = str + "mnc=\"" + ((CellInfo)paramList.get(i)).mnc + "\" ";
      str = str + "lac=\"" + ((CellInfo)paramList.get(i)).lac + "\" ";
      str = str + "type=\"" + ((CellInfo)paramList.get(i)).type + "\" ";
      str = str + "stationId=\"" + ((CellInfo)paramList.get(i)).stationId + "\" ";
      str = str + "networkId=\"" + ((CellInfo)paramList.get(i)).networkId + "\" ";
      str = str + "systemId=\"" + ((CellInfo)paramList.get(i)).systemId + "\" ";
      str = str + "dbm=\"" + ((CellInfo)paramList.get(i)).dbm + "\" ";
      str = str + " >";
      str = str + ((CellInfo)paramList.get(i)).cellid;
      str = str + "</cell>";
      i += 1;
    }
  }
  
  public static String getMacXml(List<MacInfo> paramList)
  {
    String str1 = "";
    String str2;
    if ((paramList == null) || (paramList.size() <= 0)) {
      str2 = "";
    }
    int i;
    do
    {
      return str2;
      i = 0;
      str2 = str1;
    } while (i >= paramList.size());
    if ((paramList.get(i) != null) && (((MacInfo)paramList.get(i)).mac.length() == aI))
    {
      str1 = str1 + "<mac ";
      str1 = str1 + "macDbm=\"" + ((MacInfo)paramList.get(i)).dbm + "\"";
      str1 = str1 + ">";
      str1 = str1 + ((MacInfo)paramList.get(i)).mac;
      str1 = str1 + "</mac>";
    }
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public static void getSignalStrength(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      new PhoneUtil20Impl().getSignalStrength(paramContext);
      return;
    }
    new PhoneUtil16Impl().getSignalStrength(paramContext);
  }
  
  public static class CellInfo
  {
    public static final int MAX_CID = 65535;
    public static final int MAX_LAC = 65535;
    public String cellid;
    public String dbm;
    public String lac;
    public String mcc;
    public String mnc;
    public String networkId;
    public String stationId;
    public String systemId;
    public String type;
    
    public CellInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.mcc = paramString1;
      this.mnc = paramString2;
      this.lac = paramString3;
      this.type = paramString6;
      this.cellid = paramString4;
      this.stationId = paramString7;
      this.networkId = paramString8;
      this.systemId = paramString9;
      this.dbm = paramString5;
    }
  }
  
  public static class MacInfo
  {
    public String dbm;
    public String mac;
    
    public MacInfo(String paramString1, String paramString2)
    {
      this.mac = paramString1;
      this.dbm = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneUtil
 * JD-Core Version:    0.7.0.1
 */