package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.List;

public final class PhoneUtil
{
  public static final String CELL_CDMA = "cdma";
  public static final String CELL_GSM = "gsm";
  private static final int aI = 17;
  
  public static List getCellInfoList(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 5) {
      return new PhoneUtil20Impl().getCellInfoList(paramContext);
    }
    return new PhoneUtil16Impl().getCellInfoList(paramContext);
  }
  
  public static String getCellXml(List paramList)
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
      str = str + "mcc=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).mcc + "\" ";
      str = str + "mnc=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).mnc + "\" ";
      str = str + "lac=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).lac + "\" ";
      str = str + "type=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).type + "\" ";
      str = str + "stationId=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).stationId + "\" ";
      str = str + "networkId=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).networkId + "\" ";
      str = str + "systemId=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).systemId + "\" ";
      str = str + "dbm=\"" + ((PhoneUtil.CellInfo)paramList.get(i)).dbm + "\" ";
      str = str + " >";
      str = str + ((PhoneUtil.CellInfo)paramList.get(i)).cellid;
      str = str + "</cell>";
      i += 1;
    }
  }
  
  public static String getMacXml(List paramList)
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
    if ((paramList.get(i) != null) && (((PhoneUtil.MacInfo)paramList.get(i)).mac.length() == aI))
    {
      str1 = str1 + "<mac ";
      str1 = str1 + "macDbm=\"" + ((PhoneUtil.MacInfo)paramList.get(i)).dbm + "\"";
      str1 = str1 + ">";
      str1 = str1 + ((PhoneUtil.MacInfo)paramList.get(i)).mac;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneUtil
 * JD-Core Version:    0.7.0.1
 */