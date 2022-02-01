package c.t.m.g;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.telephony.CellInfo;>;

public final class bj
  extends bm
{
  public a a = a.a;
  public int b = 460;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 2147483647;
  public int h = 2147483647;
  public final long i = System.currentTimeMillis();
  public boolean j = false;
  public List<String> k = new ArrayList();
  private List<NeighboringCellInfo> l;
  private List<bj> m;
  
  @SuppressLint({"NewApi"})
  private static bj a(ap paramap, CellInfo paramCellInfo)
  {
    int n = -88;
    if ((paramCellInfo == null) || (paramap == null)) {
      return null;
    }
    Object localObject = paramap.f;
    paramap = new bj();
    do
    {
      for (;;)
      {
        try
        {
          if (!(paramCellInfo instanceof CellInfoCdma)) {
            continue;
          }
          paramCellInfo = (CellInfoCdma)paramCellInfo;
          CellIdentityCdma localCellIdentityCdma = paramCellInfo.getCellIdentity();
          paramap.a = a.c;
          paramap.a((TelephonyManager)localObject, a.c);
          paramap.c = localCellIdentityCdma.getSystemId();
          paramap.d = localCellIdentityCdma.getNetworkId();
          paramap.e = localCellIdentityCdma.getBasestationId();
          paramap.g = localCellIdentityCdma.getLatitude();
          paramap.h = localCellIdentityCdma.getLongitude();
          i2 = paramCellInfo.getCellSignalStrength().getDbm();
          i1 = n;
          if (i2 > -110)
          {
            i1 = n;
            if (i2 < -40) {
              i1 = i2;
            }
          }
          paramap.f = i1;
        }
        catch (Throwable paramCellInfo)
        {
          int i2;
          int i1;
          continue;
        }
        if (paramap.d()) {
          paramap.j = true;
        }
        paramap.k.add(paramap.c());
        return paramap;
        if ((paramCellInfo instanceof CellInfoGsm))
        {
          paramCellInfo = (CellInfoGsm)paramCellInfo;
          paramap.a = a.b;
          localObject = paramCellInfo.getCellIdentity();
          paramap.d = ((CellIdentityGsm)localObject).getLac();
          paramap.e = ((CellIdentityGsm)localObject).getCid();
          paramap.b = ((CellIdentityGsm)localObject).getMcc();
          paramap.c = ((CellIdentityGsm)localObject).getMnc();
          i2 = paramCellInfo.getCellSignalStrength().getDbm();
          i1 = n;
          if (i2 > -110)
          {
            i1 = n;
            if (i2 < -40) {
              i1 = i2;
            }
          }
          paramap.f = i1;
        }
        else
        {
          if (!(paramCellInfo instanceof CellInfoWcdma)) {
            continue;
          }
          paramCellInfo = (CellInfoWcdma)paramCellInfo;
          paramap.a = a.d;
          localObject = paramCellInfo.getCellIdentity();
          paramap.d = ((CellIdentityWcdma)localObject).getLac();
          paramap.e = ((CellIdentityWcdma)localObject).getCid();
          paramap.b = ((CellIdentityWcdma)localObject).getMcc();
          paramap.c = ((CellIdentityWcdma)localObject).getMnc();
          i2 = paramCellInfo.getCellSignalStrength().getDbm();
          i1 = n;
          if (i2 > -110)
          {
            i1 = n;
            if (i2 < -40) {
              i1 = i2;
            }
          }
          paramap.f = i1;
        }
      }
    } while (!(paramCellInfo instanceof CellInfoLte));
    paramCellInfo = (CellInfoLte)paramCellInfo;
    paramap.a = a.e;
    localObject = paramCellInfo.getCellIdentity();
    paramap.d = ((CellIdentityLte)localObject).getTac();
    paramap.e = ((CellIdentityLte)localObject).getCi();
    paramap.b = ((CellIdentityLte)localObject).getMcc();
    paramap.c = ((CellIdentityLte)localObject).getMnc();
    n = paramCellInfo.getCellSignalStrength().getDbm();
    if ((n > -110) && (n < -40)) {}
    for (;;)
    {
      paramap.f = n;
      break;
      n = -88;
    }
  }
  
  public static bj a(ap paramap, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!paramap.b()) || (paramCellLocation == null)) {
      return null;
    }
    TelephonyManager localTelephonyManager = paramap.f;
    paramap = new bj();
    for (;;)
    {
      try
      {
        if (!(paramCellLocation instanceof CdmaCellLocation)) {
          continue;
        }
        paramCellLocation = (CdmaCellLocation)paramCellLocation;
        paramap.a = a.c;
        paramap.a(localTelephonyManager, a.c);
        paramap.c = paramCellLocation.getSystemId();
        paramap.d = paramCellLocation.getNetworkId();
        paramap.e = paramCellLocation.getBaseStationId();
        paramap.g = paramCellLocation.getBaseStationLatitude();
        paramap.h = paramCellLocation.getBaseStationLongitude();
        if (paramSignalStrength != null) {
          continue;
        }
        paramap.f = -1;
      }
      catch (Throwable paramCellLocation)
      {
        continue;
      }
      if (paramap.d()) {
        paramap.j = true;
      }
      paramap.k.add(paramap.c());
      return paramap;
      paramap.f = paramSignalStrength.getCdmaDbm();
      continue;
      paramCellLocation = (GsmCellLocation)paramCellLocation;
      paramap.a = a.b;
      paramap.a(localTelephonyManager, a.b);
      paramap.d = paramCellLocation.getLac();
      paramap.e = paramCellLocation.getCid();
      if (paramSignalStrength == null) {
        paramap.f = -1;
      } else {
        paramap.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static bj a(ap paramap, List<CellInfo> paramList)
  {
    if ((paramList == null) || (paramap == null) || (paramList.size() == 0)) {
      return new bj();
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bj();
    Iterator localIterator = paramList.iterator();
    int n = 1;
    paramList = (List<CellInfo>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (CellInfo)localIterator.next();
      if (((CellInfo)localObject).isRegistered())
      {
        localObject = a(paramap, (CellInfo)localObject);
        if (((bj)localObject).d())
        {
          paramList.k.add(((bj)localObject).c());
          if (n != 0)
          {
            ((bj)localObject).j = true;
            n = 0;
            paramList = (List<CellInfo>)localObject;
          }
          else
          {
            localArrayList.add(localObject);
          }
        }
      }
    }
    paramList.m = localArrayList;
    return paramList;
  }
  
  private void a(TelephonyManager paramTelephonyManager, a parama)
  {
    int i2 = 0;
    int n = 0;
    paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
    if ((paramTelephonyManager != null) && (paramTelephonyManager.length() >= 5)) {}
    for (;;)
    {
      int i3;
      try
      {
        i3 = Integer.parseInt(paramTelephonyManager.substring(0, 3));
      }
      catch (Throwable paramTelephonyManager)
      {
        int i4;
        i1 = 460;
        continue;
      }
      try
      {
        i4 = Integer.parseInt(paramTelephonyManager.substring(3, 5));
        n = i4;
        i1 = i3;
        if (i3 == 460)
        {
          n = i4;
          i1 = i3;
          if (i4 == 3)
          {
            n = i4;
            i1 = i3;
            i2 = i4;
            if (parama != a.c)
            {
              n = i4;
              i1 = i3;
              i2 = i4;
              if (paramTelephonyManager.length() == 11)
              {
                i2 = i4;
                n = Integer.parseInt(paramTelephonyManager.substring(9, 11));
                i1 = i3;
              }
            }
          }
        }
      }
      catch (Throwable paramTelephonyManager)
      {
        n = i2;
        i1 = i3;
        continue;
      }
      if ((i1 > 0) && (n >= 0))
      {
        this.b = i1;
        this.c = n;
      }
      return;
      int i1 = 460;
    }
  }
  
  private boolean d()
  {
    boolean bool = true;
    if (this.a != a.c) {
      if ((this.b < 0) || (this.c < 0) || (this.b == 535) || (this.c == 535) || (this.d < 0) || (this.d == 65535) || (this.d == 25840) || (this.e == 65535) || (this.e == 268435455) || (this.e == 2147483647) || (this.e == 50594049) || (this.e == 8) || (this.e == 10) || (this.e == 33) || (this.e <= 0)) {
        bool = false;
      }
    }
    while ((this.b >= 0) && (this.c >= 0) && (this.b != 535) && (this.c != 535) && (this.d >= 0) && (this.d != 65535) && (this.e != 65535) && (this.e > 0)) {
      return bool;
    }
    return false;
  }
  
  public final List<NeighboringCellInfo> a()
  {
    try
    {
      if (this.l == null) {
        this.l = Collections.emptyList();
      }
      List localList = this.l;
      return localList;
    }
    finally {}
  }
  
  public final void a(List<NeighboringCellInfo> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.l = Collections.unmodifiableList(paramList);
        return;
      }
      finally {}
      this.l = Collections.emptyList();
    }
  }
  
  public final List<bj> b()
  {
    if (this.m == null) {
      this.m = Collections.emptyList();
    }
    return this.m;
  }
  
  public final String c()
  {
    return this.b + this.c + this.d + this.e;
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
  
  public static enum a
  {
    static
    {
      a locala = a;
      locala = b;
      locala = c;
      locala = d;
      locala = e;
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bj
 * JD-Core Version:    0.7.0.1
 */