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
  
  public List<PhoneUtil.CellInfo> getCellInfoList(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject6 = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject5 = ((TelephonyManager)localObject6).getNetworkOperator();
    Object localObject3;
    Object localObject2;
    if (localObject5 != null)
    {
      if (((String)localObject5).equals("")) {
        return localLinkedList;
      }
      paramContext = "460";
      localObject3 = "";
      try
      {
        Object localObject1 = ((String)localObject5).substring(0, 3);
        paramContext = (Context)localObject1;
        localObject5 = ((String)localObject5).substring(3);
        paramContext = (Context)localObject1;
        localObject1 = localObject5;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = (GsmCellLocation)((TelephonyManager)localObject6).getCellLocation();
        if (localObject3 == null) {
          break label226;
        }
        i = ((GsmCellLocation)localObject3).getCid();
        j = ((GsmCellLocation)localObject3).getLac();
        if ((j >= 65535) || (j == -1) || (i == -1)) {
          break label226;
        }
        if (aK == aJ)
        {
          localObject3 = "";
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(aK);
          localObject3 = ((StringBuilder)localObject3).toString();
        }
      }
      catch (Exception localException2)
      {
        int i;
        int j;
        localException2.printStackTrace();
      }
      localLinkedList.add(new PhoneUtil.CellInfo(paramContext, localObject2, String.valueOf(j), String.valueOf(i), (String)localObject3, "gsm", "", "", ""));
      label226:
      Object localObject4 = ((TelephonyManager)localObject6).getNeighboringCellInfo();
      if ((localObject4 != null) && (((List)localObject4).size() > 0))
      {
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (NeighboringCellInfo)((Iterator)localObject4).next();
          if (((NeighboringCellInfo)localObject5).getCid() != -1)
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(((NeighboringCellInfo)localObject5).getCid());
            localLinkedList.add(new PhoneUtil.CellInfo(paramContext, localObject2, "", ((StringBuilder)localObject6).toString(), "", "gsm", "", "", ""));
          }
        }
      }
      return localLinkedList;
    }
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