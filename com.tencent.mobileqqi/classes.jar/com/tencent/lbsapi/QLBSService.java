package com.tencent.lbsapi;

import LBSAPIProtocol.LBSKeyData;
import android.content.Context;
import com.tencent.lbsapi.a.b;
import com.tencent.lbsapi.a.d;
import com.tencent.lbsapi.model.CellInfo;
import com.tencent.lbsapi.model.GpsInfo;
import java.util.ArrayList;

public class QLBSService
{
  private d a = null;
  private String b = null;
  private String c = null;
  private String d = null;
  
  public QLBSService(Context paramContext, QLBSNotification paramQLBSNotification, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      throw new NullPointerException("user == null");
    }
    if (paramString2 == null) {
      throw new NullPointerException("password == null");
    }
    this.a = new d(paramContext, paramQLBSNotification);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  public int getCarrierId()
  {
    return this.a.c();
  }
  
  public CellInfo getCell()
  {
    return getCell(false);
  }
  
  public CellInfo getCell(boolean paramBoolean)
  {
    return this.a.b(paramBoolean);
  }
  
  public byte[] getDeviceData()
  {
    try
    {
      byte[] arrayOfByte = b.a(this.a.a(this.d), this.b, this.c);
      LBSKeyData localLBSKeyData = new LBSKeyData();
      localLBSKeyData.setVAuthName(this.b.getBytes());
      localLBSKeyData.setVEncryptData(arrayOfByte);
      arrayOfByte = b.a(b.a(localLBSKeyData));
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public GpsInfo getGPS()
  {
    return this.a.i();
  }
  
  public String getIMEI()
  {
    return this.a.j();
  }
  
  public ArrayList getNeighboringCells()
  {
    return this.a.h();
  }
  
  public ArrayList getWIFI2Long()
  {
    return b.a(this.a.c(false));
  }
  
  public ArrayList getWifiList()
  {
    return getWifiList(false);
  }
  
  public ArrayList getWifiList(boolean paramBoolean)
  {
    return this.a.c(paramBoolean);
  }
  
  public boolean isDeviceDataValid()
  {
    return this.a.g();
  }
  
  public boolean isGpsEnabled()
  {
    return this.a.b();
  }
  
  public void release()
  {
    this.a.f();
  }
  
  public void setGpsEnabled(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setTimeoutSeconds(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void startLocation()
  {
    this.a.a();
  }
  
  public void stopLocation()
  {
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.lbsapi.QLBSService
 * JD-Core Version:    0.7.0.1
 */