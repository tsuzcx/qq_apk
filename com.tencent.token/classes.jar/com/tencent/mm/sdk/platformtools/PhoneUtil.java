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
    String str = "";
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("<cell ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("mcc=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).mcc);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("mnc=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).mnc);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("lac=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).lac);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("type=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).type);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("stationId=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).stationId);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("networkId=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).networkId);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("systemId=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).systemId);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("dbm=\"");
        localStringBuilder.append(((CellInfo)paramList.get(i)).dbm);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" >");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(((CellInfo)paramList.get(i)).cellid);
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("</cell>");
        str = localStringBuilder.toString();
        i += 1;
      }
      return str;
    }
    return "";
  }
  
  public static String getMacXml(List<MacInfo> paramList)
  {
    Object localObject1 = "";
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject2 = localObject1;
        if (paramList.get(i) != null)
        {
          localObject2 = localObject1;
          if (((MacInfo)paramList.get(i)).mac.length() == aI)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("<mac ");
            localObject1 = ((StringBuilder)localObject2).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("macDbm=\"");
            ((StringBuilder)localObject2).append(((MacInfo)paramList.get(i)).dbm);
            ((StringBuilder)localObject2).append("\"");
            localObject1 = ((StringBuilder)localObject2).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(">");
            localObject1 = ((StringBuilder)localObject2).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(((MacInfo)paramList.get(i)).mac);
            localObject1 = ((StringBuilder)localObject2).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("</mac>");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      return localObject1;
    }
    return "";
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