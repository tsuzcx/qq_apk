package com.tencent.mobileqq.app;

import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetAutoInfoResp;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendListObserver
  implements BusinessObserver
{
  public static final int c = 7;
  
  protected void a() {}
  
  protected void a(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 16: 
    case 17: 
    case 20: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 29: 
    case 31: 
    case 32: 
    case 34: 
    case 36: 
    case 40: 
    case 46: 
    case 54: 
    case 55: 
    case 57: 
    default: 
    case 1: 
    case 48: 
    case 2: 
    case 64: 
    case 65: 
    case 45: 
    case 4: 
    case 30: 
    case 53: 
    case 3: 
    case 67: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 27: 
    case 28: 
    case 33: 
    case 35: 
    case 37: 
    case 38: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 47: 
    case 39: 
    case 49: 
    case 73: 
    case 50: 
    case 58: 
    case 59: 
    case 60: 
    case 51: 
    case 61: 
    case 62: 
    case 52: 
    case 56: 
    case 69: 
    case 70: 
    case 63: 
    case 66: 
    case 68: 
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
                if (paramBoolean)
                {
                  a(paramBoolean, ((Boolean)paramObject).booleanValue());
                  return;
                }
                a(paramBoolean, false);
                return;
                if (paramBoolean) {}
                for (bool1 = ((Boolean)paramObject).booleanValue();; bool1 = true)
                {
                  b(paramBoolean, bool1);
                  return;
                }
                b(paramBoolean, (String[])paramObject);
                return;
                paramObject = (Object[])paramObject;
                a(paramBoolean, (String[])paramObject[0], (Bundle)paramObject[1]);
                return;
                paramObject = (Object[])paramObject;
                a(paramBoolean, (String[])paramObject[0], (Map)paramObject[1]);
                return;
                a(paramBoolean, (Setting)paramObject);
                return;
                a(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                return;
                c(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                return;
                paramObject = (Bundle)paramObject;
                a(paramBoolean, paramObject.getString("troopUin"), paramObject.getString("url"));
                return;
                a((String)paramObject, paramBoolean);
                return;
                a((ArrayList)paramObject, paramBoolean);
                return;
                a();
                return;
                a(paramBoolean, (HashMap)paramObject);
                return;
                if (paramBoolean)
                {
                  paramObject = (Object[])paramObject;
                  a((String)paramObject[0], ((Byte)paramObject[1]).byteValue(), ((Byte)paramObject[2]).byteValue());
                  return;
                }
                a(null, (byte)0, (byte)0);
                return;
                if (paramBoolean)
                {
                  paramObject = (Object[])paramObject;
                  a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                  return;
                }
                a(paramBoolean, "", 0);
                return;
                b(paramBoolean, (Bundle)paramObject);
                return;
                a(paramBoolean, (Bundle)paramObject);
                return;
                a(paramBoolean, (String[])paramObject);
                return;
                b(paramBoolean);
                return;
                a(paramBoolean, paramObject);
                return;
                paramObject = (Object[])paramObject;
                a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Byte)paramObject[2]).byteValue());
                return;
                a(paramBoolean);
                return;
                paramObject = (GetAutoInfoResp)paramObject;
              } while (paramObject == null);
              a(paramBoolean, paramObject.strRemark, paramObject.cGroupID, paramObject.strGroupName);
              return;
              boolean bool1 = bool2;
              if ((paramObject instanceof Object[]))
              {
                paramObject = (Object[])paramObject;
                bool1 = bool2;
                if (paramObject.length == 1)
                {
                  bool1 = bool2;
                  if ((paramObject[0] instanceof Boolean)) {
                    bool1 = ((Boolean)paramObject[0]).booleanValue();
                  }
                }
              }
              c(paramBoolean, bool1);
              return;
              a(paramBoolean, (ArrayList)paramObject);
              return;
              a(paramBoolean, (Map)paramObject);
              return;
              c(paramBoolean, (Map)paramObject);
              return;
              d(paramBoolean, (Map)paramObject);
              return;
              e(paramBoolean, (Map)paramObject);
              return;
              f(paramBoolean, (Map)paramObject);
              return;
              b(paramBoolean, (Map)paramObject);
              return;
              b(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
              return;
              paramObject = (Object[])paramObject;
              a(((Long)paramObject[0]).longValue(), paramBoolean, paramObject[1], ((Integer)paramObject[2]).intValue());
              return;
              if (paramObject == null)
              {
                a(false, null, null);
                return;
              }
              paramObject = (Object[])paramObject;
              a(paramBoolean, (List)paramObject[0], (List)paramObject[1]);
              return;
              b(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
              return;
              c(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
              return;
              a(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
              return;
              paramObject = (Object[])paramObject;
              d(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
              return;
              paramObject = (Object[])paramObject;
              b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
              return;
              paramObject = (Object[])paramObject;
              c(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            a(((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
            return;
            if (paramBoolean)
            {
              b(paramBoolean, (ArrayList)paramObject);
              return;
            }
            b(paramBoolean, null);
            return;
            c(paramBoolean);
            return;
          } while ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof String)));
          a((String)paramObject);
          return;
          b(paramBoolean, paramObject);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
        paramInt = paramObject.length;
        if (paramInt == 2)
        {
          a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], null);
          return;
        }
      } while (paramInt != 3);
      a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (GetOnlineInfoResp)paramObject[2]);
      return;
    case 18: 
      a(paramBoolean, (GroupActionResp)paramObject);
      return;
    case 19: 
      b(paramBoolean, (GroupActionResp)paramObject);
      return;
    case 21: 
      c(paramBoolean, (GroupActionResp)paramObject);
      return;
    case 22: 
      d(paramBoolean, (GroupActionResp)paramObject);
      return;
    }
    int i = 146;
    if (paramInt == 72) {
      i = 147;
    }
    a(i, paramBoolean, (Bundle)paramObject);
  }
  
  protected void a(long paramLong, boolean paramBoolean, Object paramObject, int paramInt) {}
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Shield", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " isSetOrClear:" + paramBoolean1 + " isSuc:" + paramBoolean2 + " isPush:" + paramBoolean3 + " errMsg:" + paramString);
    }
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(ArrayList paramArrayList, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, byte paramByte1, String paramString1, long paramLong, byte paramByte2, byte paramByte3, short paramShort, String paramString2) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp) {}
  
  protected void a(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void a(boolean paramBoolean, Setting paramSetting) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, Object paramObject, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, HashMap paramHashMap) {}
  
  protected void a(boolean paramBoolean, List paramList1, List paramList2) {}
  
  protected void a(boolean paramBoolean, Map paramMap) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Map paramMap) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void b(boolean paramBoolean, Map paramMap) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void c(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void c(boolean paramBoolean, Map paramMap) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void d(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void d(boolean paramBoolean, Map paramMap) {}
  
  protected void e(boolean paramBoolean, Map paramMap) {}
  
  protected void f(boolean paramBoolean, Map paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListObserver
 * JD-Core Version:    0.7.0.1
 */