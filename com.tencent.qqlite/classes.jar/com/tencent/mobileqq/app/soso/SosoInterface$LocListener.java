package com.tencent.mobileqq.app.soso;

import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import java.util.ArrayList;
import java.util.Iterator;

public final class SosoInterface$LocListener
  extends SOSOMapLBSApiListener
{
  private static final String jdField_a_of_type_JavaLangString = "SosoLocListener";
  
  public SosoInterface$LocListener(SosoInterface paramSosoInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationDataUpdate(byte[] paramArrayOfByte, int paramInt)
  {
    synchronized (SosoInterface.a(this.a))
    {
      boolean bool = SosoInterface.a(this.a).isEmpty();
      if (bool) {
        break label146;
      }
      Object localObject1 = null;
      paramInt = -1;
      try
      {
        localObject2 = SosoInterface.SosoLbsInfo.a(new String(new String(paramArrayOfByte, "GBK").getBytes("UTF-8"), "UTF-8"));
        localObject1 = localObject2;
        paramInt = 0;
      }
      catch (Exception localException)
      {
        Object localObject2;
        label67:
        break label67;
      }
      localObject2 = SosoInterface.a(this.a).iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((SosoInterface.OnLocationListener)((Iterator)localObject2).next()).a(paramInt, localObject1, paramArrayOfByte, this.a);
      }
    }
    SosoInterface.a(this.a).clear();
    SosoInterface.a(this.a, false);
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    label146:
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult) {}
  
  public void onStatusUpdate(int paramInt)
  {
    switch (paramInt)
    {
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.LocListener
 * JD-Core Version:    0.7.0.1
 */