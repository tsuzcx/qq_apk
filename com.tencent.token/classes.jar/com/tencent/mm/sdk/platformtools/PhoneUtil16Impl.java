package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class PhoneUtil16Impl
{
  private static int aJ = 10000;
  private static int aK = 10000;
  private TelephonyManager aL;
  private PhoneStateListener aM = new PhoneUtil16Impl.1(this);
  
  public List getCellInfoList(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject3 = localTelephonyManager.getNetworkOperator();
    if ((localObject3 == null) || (((String)localObject3).equals(""))) {
      return localLinkedList;
    }
    paramContext = "460";
    Object localObject1 = "";
    try
    {
      localObject2 = ((String)localObject3).substring(0, 3);
      paramContext = (Context)localObject2;
      localObject3 = ((String)localObject3).substring(3);
      localObject1 = localObject3;
      paramContext = (Context)localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        label171:
        localException1.printStackTrace();
        continue;
        String str = aK;
      }
    }
    try
    {
      localObject2 = (GsmCellLocation)localTelephonyManager.getCellLocation();
      if (localObject2 != null)
      {
        int i = ((GsmCellLocation)localObject2).getCid();
        int j = ((GsmCellLocation)localObject2).getLac();
        if ((j < 65535) && (j != -1) && (i != -1))
        {
          if (aK != aJ) {
            break label294;
          }
          localObject2 = "";
          localLinkedList.add(new PhoneUtil.CellInfo(paramContext, (String)localObject1, String.valueOf(j), String.valueOf(i), (String)localObject2, "gsm", "", "", ""));
        }
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      break label171;
    }
    localObject2 = localTelephonyManager.getNeighboringCellInfo();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NeighboringCellInfo)((Iterator)localObject2).next();
        if (((NeighboringCellInfo)localObject3).getCid() != -1) {
          localLinkedList.add(new PhoneUtil.CellInfo(paramContext, (String)localObject1, "", ((NeighboringCellInfo)localObject3).getCid(), "", "gsm", "", "", ""));
        }
      }
    }
    label294:
    return localLinkedList;
  }
  
  public void getSignalStrength(Context paramContext)
  {
    this.aL = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.aL.listen(this.aM, 256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneUtil16Impl
 * JD-Core Version:    0.7.0.1
 */