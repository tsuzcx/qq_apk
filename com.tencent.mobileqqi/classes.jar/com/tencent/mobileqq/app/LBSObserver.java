package com.tencent.mobileqq.app;

import EncounterSvc.RespGetEncounterV2;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NeighborSvc.RespGetNeighbors;
import QQService.RespFaceInfo;
import java.util.List;

public class LBSObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 12: 
    case 13: 
    case 14: 
    case 9: 
    case 10: 
    case 11: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (paramObject == null);
              if (paramBoolean)
              {
                paramObject = (Object[])paramObject;
                a(true, (byte[])paramObject[0], (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
                return;
              }
              a(false, (byte[])paramObject, null, null, null);
              return;
              if (!paramBoolean) {
                break;
              }
            } while (paramObject == null);
            paramObject = (Object[])paramObject;
            a(true, (String)paramObject[0], (RespGetNeighbors)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), 0);
            return;
            a(false, null, null, false, -1);
            return;
            a(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
          } while (paramObject == null);
          if (paramBoolean)
          {
            paramObject = (Object[])paramObject;
            a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (RespGetEncounterV2)paramObject[2], ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue(), 0);
            return;
          }
          paramObject = (Object[])paramObject;
          a(false, null, 0, null, false, ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[0]).intValue());
          return;
        } while (paramObject == null);
        if (paramBoolean)
        {
          paramObject = (Object[])paramObject;
          a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue());
          return;
        }
        a(false, null, 0);
        return;
        paramObject = (Object[])paramObject;
        boolean bool = ((Boolean)paramObject[0]).booleanValue();
        paramObject = (RspGetNearbyGroup)paramObject[1];
        if (paramBoolean)
        {
          a(true, bool, paramObject);
          return;
        }
        a(false, bool, paramObject);
        return;
        if (paramBoolean)
        {
          if (paramObject == null)
          {
            a(true, null, false);
            return;
          }
          paramObject = (Object[])paramObject;
          paramBoolean = ((Boolean)paramObject[0]).booleanValue();
          a(true, (RspGetAreaList)paramObject[1], paramBoolean);
          return;
        }
        a(false, null, false);
        return;
        if (paramBoolean)
        {
          if (paramObject == null)
          {
            a(true, null);
            return;
          }
          a(true, (RspGetGroupInArea)((Object[])(Object[])paramObject)[0]);
          return;
        }
        a(false, null);
        return;
        if ((paramBoolean == true) && (paramObject != null))
        {
          paramObject = (Object[])paramObject;
          a(true, ((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue());
          return;
        }
        a(false, 0L, false);
        return;
        b(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
        paramObject = (Object[])paramObject;
        if (paramBoolean)
        {
          a(true, ((Integer)paramObject[0]).intValue(), ((Boolean)paramObject[1]).booleanValue());
          return;
        }
        a(false, -1, false);
        return;
      } while ((!paramBoolean) || (paramObject == null));
      a(true, (byte[])paramObject);
      return;
    case 18: 
      a(true, (String[])paramObject);
      return;
    case 15: 
      a(paramBoolean, (Object[])paramObject);
      return;
    case 16: 
      b(paramBoolean, (Object[])paramObject);
      return;
    }
    c(paramBoolean, (Object[])paramObject);
  }
  
  protected void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea) {}
  
  public void a(boolean paramBoolean1, String paramString, int paramInt1, RespGetEncounterV2 paramRespGetEncounterV2, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean1, String paramString, RespGetNeighbors paramRespGetNeighbors, boolean paramBoolean2, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, RespFaceInfo paramRespFaceInfo) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void a(boolean paramBoolean, String[] paramArrayOfString) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void c(boolean paramBoolean, Object[] paramArrayOfObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LBSObserver
 * JD-Core Version:    0.7.0.1
 */