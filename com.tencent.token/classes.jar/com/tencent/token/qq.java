package com.tencent.token;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class qq
{
  private static int a = 10000;
  private static int b = 10000;
  private TelephonyManager c;
  private int d;
  private PhoneStateListener e = new qr(this);
  
  public static List<qn.a> a(Context paramContext)
  {
    Object localObject7 = (TelephonyManager)paramContext.getSystemService("phone");
    localLinkedList = new LinkedList();
    Object localObject2 = "460";
    Object localObject5 = "";
    try
    {
      paramContext = ((TelephonyManager)localObject7).getNetworkOperator();
      if ((paramContext != null) && (!paramContext.equals("")))
      {
        localObject1 = paramContext.substring(0, 3);
      }
      else
      {
        localObject6 = ((TelephonyManager)localObject7).getSimOperator();
        localObject1 = localObject2;
        paramContext = (Context)localObject5;
        if (localObject6 == null) {
          break label109;
        }
        localObject1 = localObject2;
        paramContext = (Context)localObject5;
        if (((String)localObject6).equals("")) {
          break label109;
        }
        localObject1 = ((String)localObject6).substring(0, 3);
        paramContext = (Context)localObject6;
      }
      paramContext = paramContext.substring(3, 5);
      label109:
      if (((TelephonyManager)localObject7).getPhoneType() != 2) {}
    }
    catch (Exception paramContext)
    {
      Object localObject1;
      Object localObject6;
      label177:
      Object localObject8;
      StringBuilder localStringBuilder;
      label319:
      label736:
      paramContext.printStackTrace();
      label691:
      label991:
      return localLinkedList;
    }
    try
    {
      localObject5 = (CdmaCellLocation)((TelephonyManager)localObject7).getCellLocation();
      if (localObject5 == null) {
        break label991;
      }
      if (b == a)
      {
        localObject2 = "";
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(b);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    catch (Exception localException3)
    {
      break label319;
      break label177;
      break label691;
    }
    if ((((CdmaCellLocation)localObject5).getBaseStationId() != -1) && (((CdmaCellLocation)localObject5).getNetworkId() != -1) && (((CdmaCellLocation)localObject5).getSystemId() != -1))
    {
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(((CdmaCellLocation)localObject5).getBaseStationId());
      localObject6 = ((StringBuilder)localObject6).toString();
      localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append(((CdmaCellLocation)localObject5).getNetworkId());
      localObject8 = ((StringBuilder)localObject8).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((CdmaCellLocation)localObject5).getSystemId());
      localObject5 = localStringBuilder.toString();
      for (;;)
      {
        try
        {
          localLinkedList.add(new qn.a((String)localObject1, paramContext, "", "", (String)localObject2, "cdma", (String)localObject6, (String)localObject8, (String)localObject5));
          return localLinkedList;
        }
        catch (Exception localException4)
        {
          int i;
          int j;
          Object localObject3;
          continue;
        }
        try
        {
          localObject2 = (GsmCellLocation)((TelephonyManager)localObject7).getCellLocation();
          if (localObject2 != null)
          {
            i = ((GsmCellLocation)localObject2).getCid();
            j = ((GsmCellLocation)localObject2).getLac();
            if ((j < 65535) && (j != -1) && (i != -1)) {
              localLinkedList.add(new qn.a((String)localObject1, paramContext, String.valueOf(j), String.valueOf(i), "", "gsm", "", "", ""));
            }
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      localObject3 = ((TelephonyManager)localObject7).getNeighboringCellInfo();
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (NeighboringCellInfo)((Iterator)localObject3).next();
          if ((((NeighboringCellInfo)localObject5).getCid() != -1) && (((NeighboringCellInfo)localObject5).getLac() <= 65535) && (((NeighboringCellInfo)localObject5).getLac() != -1))
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(((NeighboringCellInfo)localObject5).getRssi() * 2 - 113);
            localObject6 = ((StringBuilder)localObject6).toString();
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append(((NeighboringCellInfo)localObject5).getLac());
            localObject7 = ((StringBuilder)localObject7).toString();
            localObject8 = new StringBuilder();
            ((StringBuilder)localObject8).append(((NeighboringCellInfo)localObject5).getCid());
            localLinkedList.add(new qn.a((String)localObject1, paramContext, (String)localObject7, ((StringBuilder)localObject8).toString(), (String)localObject6, "gsm", "", "", ""));
            continue;
            try
            {
              localObject3 = (GsmCellLocation)((TelephonyManager)localObject7).getCellLocation();
              if (localObject3 == null) {
                break label736;
              }
              i = ((GsmCellLocation)localObject3).getCid();
              j = ((GsmCellLocation)localObject3).getLac();
              if ((j >= 65535) || (j == -1) || (i == -1)) {
                break label736;
              }
              if (b == a)
              {
                localObject3 = "";
              }
              else
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(b);
                localObject3 = ((StringBuilder)localObject3).toString();
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            localLinkedList.add(new qn.a((String)localObject1, paramContext, String.valueOf(j), String.valueOf(i), (String)localObject3, "gsm", "", "", ""));
            Object localObject4 = ((TelephonyManager)localObject7).getNeighboringCellInfo();
            if ((localObject4 != null) && (((List)localObject4).size() > 0))
            {
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (NeighboringCellInfo)((Iterator)localObject4).next();
                if ((((NeighboringCellInfo)localObject5).getCid() != -1) && (((NeighboringCellInfo)localObject5).getLac() <= 65535))
                {
                  localObject6 = new StringBuilder();
                  ((StringBuilder)localObject6).append(((NeighboringCellInfo)localObject5).getRssi() * 2 - 113);
                  localObject6 = ((StringBuilder)localObject6).toString();
                  localObject7 = new StringBuilder("lac:");
                  ((StringBuilder)localObject7).append(((NeighboringCellInfo)localObject5).getLac());
                  ((StringBuilder)localObject7).append("  cid:");
                  ((StringBuilder)localObject7).append(((NeighboringCellInfo)localObject5).getCid());
                  ((StringBuilder)localObject7).append(" dbm:");
                  ((StringBuilder)localObject7).append((String)localObject6);
                  qk.d("checked", ((StringBuilder)localObject7).toString());
                  localObject7 = new StringBuilder();
                  ((StringBuilder)localObject7).append(((NeighboringCellInfo)localObject5).getLac());
                  localObject7 = ((StringBuilder)localObject7).toString();
                  localObject8 = new StringBuilder();
                  ((StringBuilder)localObject8).append(((NeighboringCellInfo)localObject5).getCid());
                  localLinkedList.add(new qn.a((String)localObject1, paramContext, (String)localObject7, ((StringBuilder)localObject8).toString(), (String)localObject6, "gsm", "", "", ""));
                }
              }
            }
          }
        }
      }
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qq
 * JD-Core Version:    0.7.0.1
 */