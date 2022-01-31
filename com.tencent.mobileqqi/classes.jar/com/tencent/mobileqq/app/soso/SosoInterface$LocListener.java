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
      if (!bool)
      {
        try
        {
          localSosoLbsInfo = SosoInterface.SosoLbsInfo.a(new String(new String(paramArrayOfByte, "GBK").getBytes("UTF-8"), "UTF-8"));
          paramInt = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            SosoInterface.SosoLbsInfo localSosoLbsInfo;
            Iterator localIterator;
            Object localObject = null;
            paramInt = -1;
          }
          SosoInterface.a(this.a).clear();
          SOSOMapLBSApi.getInstance().removeLocationUpdate();
        }
        localIterator = SosoInterface.a(this.a).iterator();
        if (localIterator.hasNext()) {
          ((SosoInterface.OnLocationListener)localIterator.next()).a(paramInt, localSosoLbsInfo, paramArrayOfByte, this.a);
        }
      }
    }
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult) {}
  
  public void onStatusUpdate(int paramInt)
  {
    switch (paramInt)
    {
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.LocListener
 * JD-Core Version:    0.7.0.1
 */